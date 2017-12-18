/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: PDFPage.java
 *    This file is part of Layla-PDFLib.
 *
 *    Layla-PDFLib is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU Lesser General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    Layla-PDFLib is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU Lesser General Public License for more details.
 *
 *    You should have received a copy of the GNU Lesser General Public License
 *    along with Layla-PDFLib.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.laylacp.pdflib.core;

import net.laylacp.pdflib.core.types.ObjectId;
import net.laylacp.pdflib.core.types.ObjectStack;
import net.laylacp.pdflib.graphics.*;
import net.laylacp.pdflib.graphics.Rectangle;
import net.laylacp.pdflib.reader.PDFByteArray;
import net.laylacp.pdflib.reader.PDFReader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PDFPage {
    PDFDocument pdfDocument;
    int objectNumber;
    int generationNumber;
    double zoomFactor = 1.0F;

    PDFObjectStream page;
    HashMap<String, PDFObject> Resources;
    PDFDraw pdfDraw;

    public PDFPage(int objectNumber, int generationNumber, PDFDocument pdfDocument) {
        this.objectNumber = objectNumber;
        this.generationNumber = generationNumber;
        this.pdfDocument = pdfDocument;
    }


    /*
     * SEE Table 30 – Entries in a page object, page 77.
     */

    public BufferedImage getPageObject(PDFDocument pdfDocument, int width, int height, int fit) {
        this.pdfDocument = pdfDocument;
        PDFReader reader = this.pdfDocument.reader;
        PDFByteArray byteArray = reader.byteArray;
        PDFReader.__DEBUG__("getPageObject1", "Reading page object (" + objectNumber + ":" + generationNumber + ")");
        page = reader.getObjectStreamById(objectNumber, generationNumber, byteArray, this.pdfDocument);
        if(page == null) return null;
        if(!page.isObjectOfType("Page")) return null;

        ArrayList<PDFObject> contents;
        PDFObject contentsObj = page.dictionary.get("Contents");
        if(contentsObj == null) return null;
        if(contentsObj.getType() == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
            contents = new ArrayList<>();
            contents.add(contentsObj);
        } else if(contentsObj.getType() == PDFObject.OBJECT_TYPE.ARRAY_OBJECT) {
            contents = contentsObj.getArrayValueNoFail(pdfDocument);
        } else {
            return null;
        }

        pdfDraw = new PDFDraw(this.pdfDocument, page);
        GraphicsState curState = pdfDraw.getCurState();
        //ObjectStack graphicsStateStack = pdfDraw.getGraphicsStateStack();

        /* get the required (but inheritable) MediaBox entry */
        ArrayList<PDFObject> mediaBox = null;
        Object box = PDFDict.getDictionaryEntryVal(page.dictionary, "MediaBox", this.pdfDocument);
        if(box != null) {
            mediaBox = (ArrayList<PDFObject>)box;
        }
        if(mediaBox == null || mediaBox.size() != 4) {
            return null;
        }
        Rectangle mediaBoxRect = arrayToRect(mediaBox);
        curState.setMediaBox(mediaBoxRect);

        /* create the canvas on which we will be drawing */
        int w = (int) Math.abs(mediaBoxRect.x1 - mediaBoxRect.x2);
        int h = (int) Math.abs(mediaBoxRect.y1 - mediaBoxRect.y2);

        // get the destination image size according to the requested zooming level.
        Dimension dimension = getZoomingDimension(w, h, width, height, fit);
        w = dimension.width;
        h = dimension.height;

        pdfDraw.setCanvasSize(new Point2D.Double(w, h));
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        pdfDraw.setCanvasImg(img);
        pdfDraw.setCanvas(img.createGraphics());

        /* crop box, if not defined, defaults to the value of the media box */
        ArrayList<PDFObject> cropBox = null;
        box = PDFDict.getDictionaryEntryVal(page.dictionary, "CropBox", this.pdfDocument);
        if(box != null) {
            cropBox = (ArrayList<PDFObject>)box;
        }
        if(cropBox == null || cropBox.size() != 4) {
            curState.setCropBox(curState.getMediaBox());
        } else {
            curState.setCropBox(arrayToRect(cropBox));
        }

        /*
         * PDF Says (page 78): The number  of  degrees  by  which  the  page shall  be  rotated
         * clockwise  when displayed  or  printed.  The  value shall be a multiple of 90.
         * Default value: 0.
         */
        Object object = PDFDict.getDictionaryEntry(page.dictionary, "Rotate", this.pdfDocument);
        if(object != null) {
            PDFObject object1 = (PDFObject)object;
            if(object1.getType() == PDFObject.OBJECT_TYPE.INTEGER_OBJECT) {
                curState.setRotate((int) object1.getNumericValue());
            } else {
                curState.setRotate(0);
            }
        } else {
            curState.setRotate(0);
        }

        /*
         * PDF Says (page 79): A positive  number that shall  give  the  size  of default  user space
         * units,  in  multiples  of 1⁄ 72  inch.  The  range  of supported values shall be
         * implementation-dependent. Default value: 1.0 (user space unit is 1⁄ 72 inch).
         */
        double userUnit = PDFDict.getRealDictEntry(page.dictionary, "UserUnit");
        if(userUnit == 0.0) userUnit = 1.0;
        curState.setUserUnits(userUnit);

        /*
         * Get the Page's Resource dictionary.
         * SEE Table 33 – Entries in a resource dictionary, page 83.
         */
        Resources = page.getResourcesDict();
        pdfDraw.setResources(Resources);

        /* switch source temporarily */
        PDFByteArray oldByteArray = reader.byteArray;

        /* init some variables to their default state */
        pdfDraw.setZoomFactor(zoomFactor);
        if(!pdfDraw.initCurState()) {
            reader.__DEBUG__("getPageObject", "Failed to init default user space");
            return null;
        }


        for(PDFObject object1 : contents) {
            if(object1.getType() == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
                ObjectId contentsId = object1.getIdValue();
                PDFObjectStream contentsStream = reader.getObjectStreamById(contentsId, this.pdfDocument);
                // try to bear on and render the rest of the page, if any still exists
                if(contentsStream == null) continue;
                contentsStream.stream.setOffset(0);

                reader.byteArray = contentsStream.stream;
                pdfDraw.parse(reader);
            }
        }

        // restore source bytes as it was before
        reader.byteArray = oldByteArray;

        return pdfDraw.getCanvasImg();
    }

    private Dimension getZoomingDimension(int orgW, int orgH, int reqW, int reqH, int fit) {
        Dimension res = new Dimension();
        float ratio;
        switch (fit) {
            case PDFDocument.FIT_WIDTH:
                // fit the given width
                res.width = reqW;
                ratio = (float)orgH/(float)orgW;
                res.height = (int) (reqW*ratio);
                zoomFactor = (float)reqW/(float)orgW;
                break;
            case PDFDocument.FIT_PAGE:
                // fit the given height
                res.height = reqH;
                ratio = (float)orgW/(float)orgH;
                res.width = (int) (reqH*ratio);
                zoomFactor = (float)reqH/(float)orgH;
                break;
            case PDFDocument.FIT_50:
                // zoom to 50%
                res.width = (int) (orgW*0.5);
                res.height = (int) (orgH*0.5);
                zoomFactor = 0.5;
                break;
            case PDFDocument.FIT_75:
                // zoom to 75%
                res.width = (int) (orgW*0.75);
                res.height = (int) (orgH*0.75);
                zoomFactor = 0.75;
                break;
            case PDFDocument.FIT_125:
                // zoom to 125%
                res.width = (int) (orgW*1.25);
                res.height = (int) (orgH*1.25);
                zoomFactor = 1.25;
                break;
            case PDFDocument.FIT_150:
                // zoom to 150%
                res.width = (int) (orgW*1.5);
                res.height = (int) (orgH*1.5);
                zoomFactor = 1.5;
                break;
            case PDFDocument.FIT_200:
                // zoom to 200%
                res.width = (int) (orgW*2);
                res.height = (int) (orgH*2);
                zoomFactor = 2.0;
                break;
            case PDFDocument.FIT_300:
                // zoom to 300%
                res.width = (int) (orgW*3);
                res.height = (int) (orgH*3);
                zoomFactor = 3.0;
                break;
            case PDFDocument.FIT_400:
                // zoom to 400%
                res.width = (int) (orgW*4);
                res.height = (int) (orgH*4);
                zoomFactor = 4.0;
                break;
            case PDFDocument.FIT_ACTUAL:
            case PDFDocument.FIT_100:
            default:
                // fit the original. ignore the requested dimensions (should be zero anyway).
                res.width = orgW;
                res.height = orgH;
                zoomFactor = 1.0;
                break;
        }
        return res;
    }

    public static Rectangle arrayToRect(ArrayList<PDFObject> array) {
        if(array.size() != 4) return null;
        double x1 = array.get(0).getNumericValue();
        double y1 = array.get(1).getNumericValue();
        double x2 = array.get(2).getNumericValue();
        double y2 = array.get(3).getNumericValue();
        Rectangle rect = new Rectangle(x1, y1, x2, y2);

        return rect;
    }

}
