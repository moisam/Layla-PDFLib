/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: PDFPattern.java
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

package net.laylacp.pdflib.graphics;

import net.laylacp.pdflib.core.*;
import net.laylacp.pdflib.core.types.ObjectId;
import net.laylacp.pdflib.reader.PDFByteArray;
import net.laylacp.pdflib.reader.PDFReader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PDFPattern {
    // values for patternType
    public static final int TILING_PATTERN  = 1;
    public static final int SHADING_PATTERN = 2;

    // values for paintType
    public static final int COLORED_TILING_PATTERN   = 1;
    public static final int UNCOLORED_TILING_PATTERN = 2;

    private PDFDocument pdfDocument;
    private AffineTransform at;
    private HashMap<String, PDFObject> patternResources;
    private int patternType;
    // tiling patterns
    private int paintType;
    private float xstep, ystep;
    private Rectangle bbox;
    private BufferedImage tileCell;
    // shading patterns
    private HashMap<String, PDFObject> ExtGState;
    PDFShading shading;


    public PDFPattern(PDFDocument pdfDocument) {
        this.pdfDocument = pdfDocument;
    }

    public AffineTransform getMatrix() { return at; }

    public void applyPattern(PDFDraw parent) {
        Graphics2D canvas = parent.getCanvas();
        // save the current graphics state
        //parent.pushGraphicsState();

        // apply the Tx matrix
        //GraphicsState curState = parent.getCurState();
        //AffineTransform CTM = curState.getCTM();
        //CTM.concatenate(at);
        //canvas.transform(at);

        if(patternType == TILING_PATTERN) {
            //Rectangle2D rect = new Rectangle2D.Double(0, 0, xstep, ystep);
            Rectangle2D rect = new Rectangle2D.Double(bbox.x1, bbox.y1, bbox.x2, bbox.y2);
            canvas.setPaint(new TexturePaint(tileCell, rect));
        }

        // restore everything and go home
        //parent.popGraphicsState();
    }

    public boolean setPattern(String patternName, Color color,
                              HashMap<String, PDFObject> Resources, PDFDraw parent) {
        // get the Pattern Resources sub-dictionary
        PDFObject patObject = Resources.get("Pattern");
        HashMap<String, PDFObject> patRes = patObject.getDictionaryValueNoFail(pdfDocument);
        if(patRes.size() == 0) return false;
        // get the requested pattern object
        patObject = patRes.get(patternName);
        if(patObject == null) return false;
        if(patObject.getType() == PDFObject.OBJECT_TYPE.DICTIONARY_OBJECT) {
            return setPattern(patObject.getDictionaryValue());
        } else if(patObject.getType() == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
            ObjectId id = patObject.getIdValue();
            PDFObjectStream stream = pdfDocument.reader.getObjectStreamById(id, pdfDocument);
            return setPattern(stream, color, parent);
        }
        return false;
    }

    public boolean setPattern(PDFObjectStream objectStream, Color color, PDFDraw parent) {
        if(!setPattern(objectStream.dictionary)) return false;

        if(patternType == TILING_PATTERN) {
            Graphics2D parentCanvas = parent.getCanvas();
            PDFReader reader = pdfDocument.reader;
            PDFByteArray savedByteArray = reader.byteArray;
            PDFByteArray byteArray = objectStream.stream;
            PDFDraw pdfDraw = new PDFDraw(this.pdfDocument, null);
            GraphicsState curState = null;
            try {
                curState = (GraphicsState) parent.getCurState().clone();
                pdfDraw.setCurState(curState);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            curState.setMediaBox(bbox);

            /* create the canvas on which we will be drawing */
            int w = (int) Math.abs(bbox.x1 - bbox.x2);
            int h = (int) Math.abs(bbox.y1 - bbox.y2);
            pdfDraw.setCanvasSize(new Point2D.Double(w, h));
            BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D newCanvas = img.createGraphics();
            pdfDraw.setCanvasImg(img);
            pdfDraw.setCanvas(newCanvas);
            pdfDraw.setResources(patternResources);
            pdfDraw.setZoomFactor(1.0f);
            pdfDraw.setCurSubPath(null);
            pdfDraw.setCurPoint(null);
            pdfDraw.setCurPath(new Path2D.Double());
            pdfDraw.initObjectStack();

            // do the clipping
            Path2D clipPath = new Path2D.Double();
            clipPath.moveTo(bbox.x1, bbox.y1);
            clipPath.lineTo(bbox.x1, bbox.y2);
            clipPath.lineTo(bbox.x2, bbox.y2);
            clipPath.lineTo(bbox.x2, bbox.y1);
            clipPath.closePath();

            curState.setBlendMode(null);
            curState.setCropBox(curState.getMediaBox());
            curState.setCTM(new AffineTransform());
            curState.setCurClippingPath(clipPath);
            curState.setDelayedClipping(false);
            curState.setCurState(GraphicsState.State.PAGE_DESCRIPTION_LEVEL);
            //curState.setAlphaIsShape(false);
            //curState.setAlphaStroke(1.0F);
            //curState.setAlphaOthers(1.0F);
            if(paintType == UNCOLORED_TILING_PATTERN) {
                //curState.setCurColorStroke(new Color(0, 0, 0, 1));
                curState.setCurColorOthers(color);
                //curState.setCurColorSpaceStroke(new PDFColorSpace(PDFColorSpace.DeviceGray, Resources, pdfDocument));
                curState.setCurColorSpaceOthers(new PDFColorSpace(PDFColorSpace.DeviceRGB, patternResources, pdfDocument));
            }

            Composite composite = AlphaComposite.Src;
            newCanvas.setComposite(composite);
            newCanvas.setClip(clipPath);
            //newCanvas.setComposite(parentCanvas.getComposite());
            newCanvas.setPaint(parentCanvas.getPaint());
            newCanvas.setStroke(parentCanvas.getStroke());
            newCanvas.setColor(parentCanvas.getColor());
            newCanvas.setBackground(parentCanvas.getBackground());
            newCanvas.setFont(parentCanvas.getFont());
            newCanvas.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            newCanvas.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            /*
            if(!pdfDraw.initCurState()) {
                reader.__DEBUG__("setPattern", "Failed to init default user space");
                return false;
            }
            */
            reader.byteArray = byteArray;
            pdfDraw.parse(reader);
            reader.byteArray = savedByteArray;
            tileCell = pdfDraw.getCanvasImg();
            newCanvas.dispose();



            /*
            File file = new File("MyFile.png");
            try {
                if (!ImageIO.write(tileCell, "PNG", file)) {
                    throw new RuntimeException("Unexpected error writing image");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            */



            return true;
        }
        return false;
    }

    public boolean setPattern(HashMap<String, PDFObject> dictionary) {
        if(dictionary == null || dictionary.size() == 0) return false;
        String type = PDFDict.getStringDictEntry(dictionary, "Type");
        if(!type.isEmpty() && !type.equalsIgnoreCase("Pattern"))
            return false;
        patternType = PDFDict.getIntDictEntry(dictionary, "PatternType");
        if(patternType < TILING_PATTERN || patternType > SHADING_PATTERN)
            return false;

        int i;
        float f;
        // get the transformation matrix
        ArrayList<PDFObject> matrixArray = PDFDict.getArrayDictEntry(dictionary, "Matrix");
        float[] matrix = { 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f };
        if(matrixArray != null && matrixArray.size() != 0) {
            for(i = 0; i < 6; i++) {
                f = (float) matrixArray.get(i).getNumericValue();
                matrix[i] = f;
            }
        }
        at = new AffineTransform(matrix);

        PDFObject patternResourcesObj = dictionary.get("Resources");
        patternResources = patternResourcesObj.getDictionaryValueNoFail(pdfDocument);


        if(patternType == TILING_PATTERN) {
            paintType = PDFDict.getIntDictEntry(dictionary, "PaintType");
            if(paintType != COLORED_TILING_PATTERN && paintType != UNCOLORED_TILING_PATTERN)
                return false;

            /*
             * TODO: parse and use the TilingType field. SEE page 175.
             */

            // get the bounding box (used for clipping)
            ArrayList<PDFObject> bboxArray = PDFDict.getArrayDictEntry(dictionary, "BBox");
            if(bboxArray == null || bboxArray.size() != 4) return false;
            bbox = PDFPage.arrayToRect(bboxArray);

            xstep = (float) PDFDict.getRealDictEntry(dictionary, "XStep");
            ystep = (float) PDFDict.getRealDictEntry(dictionary, "YStep");
            return true;
        } else {
            PDFObject object = dictionary.get("ExtGState");
            if(object != null) ExtGState = object.getDictionaryValueNoFail(pdfDocument);
            else ExtGState = null;

            object = dictionary.get("Shading");
            shading = new PDFShading(patternResources, pdfDocument);
            if(object.getType() == PDFObject.OBJECT_TYPE.DICTIONARY_OBJECT) {
                return shading.setShading(object.getDictionaryValue());
            } else if(object.getType() == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
                ObjectId id = object.getIdValue();
                PDFObjectStream stream = pdfDocument.reader.getObjectStreamById(id, pdfDocument);
                return shading.setShading(stream);
            }
            else return false;
        }
    }
}
