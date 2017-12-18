/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: PDFDocument.java
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
import net.laylacp.pdflib.core.types.XRefEntry;
import net.laylacp.pdflib.reader.PDFByteArray;
import net.laylacp.pdflib.reader.PDFReader;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class PDFDocument {
    // constants for viewing options
    public static final int FIT_ACTUAL   = 0;   // the actual page size (as in the PDF document itself)
    public static final int FIT_WIDTH    = 1;   // fit the given width, adjust height accordingly
    public static final int FIT_PAGE     = 2;   // fit the given height, adjust width accordingly
    public static final int FIT_50       = 3;   // zoom to 50% of the actual size
    public static final int FIT_75       = 4;   // ditto to 75%
    public static final int FIT_100      = 5;   // same as FIT_ACTUAL
    public static final int FIT_125      = 6;   // zoom to 125% of the actual size
    public static final int FIT_150      = 7;   // ditto to 150%
    public static final int FIT_200      = 8;   // ditto to 200%
    public static final int FIT_300      = 9;   // ... 300%
    public static final int FIT_400      = 10;  // ... 400%

    // member variables
    public String version;
    public String fileName;
    public ArrayList<XRefEntry> xrefTable;
    public HashMap<String, PDFObject> catalog;
    //public HashMap<String, PDFObject> pages;
    public PDFReader reader;
    public PDFByteArray sourceFile;
    public ObjectId pagesRootNode;
    public ArrayList<ObjectId> pagesObjectIds;

    public PDFDocument() {
        this.version = "";
        this.xrefTable = new ArrayList<>();
        this.catalog = null;
        //this.pages = null;
        this.fileName = null;
        this.reader = null;
        this.sourceFile = null;
        pagesObjectIds = null;
        pagesRootNode = PDFDict.invalidObjectId;
    }


    public static int[] getViewingOptions() {
        int[] options = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, };
        return options;
    }

    public static String[] getViewingOptionsNames() {
        String[] options = {
                "Actual size", "Page width", "Page fit",
                "50%", "75%", "100%", "125%", "150%",
                "200%", "300%", "400%"
        };
        return options;
    }

    public ArrayList<ObjectId> getPageObjectIds(ObjectId rootPageNode) {
        PDFObjectStream rootStream = reader.getObjectStreamById(rootPageNode, this);
        return getPageObjectIds(rootStream);
    }

    public ArrayList<ObjectId> getPageObjectIds(PDFObjectStream rootStream) {
        if(rootStream == null) return null;
        ArrayList<ObjectId> pages = new ArrayList<>();
        HashMap<String, PDFObject> dictionary = rootStream.dictionary;
        ArrayList<PDFObject> kids = PDFDict.getArrayDictEntry(dictionary, "Kids");
        if(kids == null) return pages;
        for(PDFObject kid : kids) {
            if(kid.getType() == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
                PDFObjectStream kidStream = reader.getObjectStreamById(kid.getIdValue(), this);
                if(kidStream == null) continue;
                HashMap<String, PDFObject> dictionary2 = kidStream.dictionary;
                String type = PDFDict.getStringDictEntry(dictionary2, "Type");
                if(type.equalsIgnoreCase("Pages")) {
                    ArrayList<ObjectId> kidIds = getPageObjectIds(kidStream);
                    if(kidIds != null) pages.addAll(kidIds);
                } else if(type.equalsIgnoreCase("Page")) {
                    pages.add(kid.getIdValue());
                }
            }
        }
        return pages;
    }

    public int getPageCount() {
        if(pagesObjectIds == null) {
            if(pagesRootNode.equals(PDFDict.invalidObjectId)) {
                reader.setLastError("Failed to read the root pages tree node");
                return -1;
            }
            pagesObjectIds = getPageObjectIds(pagesRootNode);
            if(pagesObjectIds == null) {
                reader.setLastError("Failed to read the root pages tree node");
                return -1;
            }
        }
        return pagesObjectIds.size();
    }

    /*
     * get the page, giving the desired width and height, which will be interpreted according to
     * the value of fit (see possible values up there in the constants named FIT_*).
     */
    public BufferedImage getPage(int pageNumber, int width, int height, int fit) {
        if(pagesObjectIds == null) {
            if(pagesRootNode.equals(PDFDict.invalidObjectId)) {
                reader.setLastError("Failed to read the root pages tree node");
                return null;
            }
            pagesObjectIds = getPageObjectIds(pagesRootNode);
            if(pagesObjectIds == null) {
                reader.setLastError("Failed to read the root pages tree node");
                return null;
            }
        }
        if(pageNumber < 0 || pageNumber >= pagesObjectIds.size()) {
            reader.setLastError("Invalid page number");
            return null;
        }
        ObjectId pageId = pagesObjectIds.get(pageNumber);
        return getPage(pageId.getObjectNumber(), pageId.getGenerationNumber(), width, height, fit);
    }

    /*
     * this is the function the user will typically call. it passes along default values for viewing.
     */
    public BufferedImage getPage(int pageNumber) {
        return getPage(pageNumber, 0, 0, FIT_ACTUAL);
    }

    /*
     * this is the function that actually does the work (sort of). it gets the requested page, using
     * it's Object and Generation numbers, and return the resulting page image to the caller.
     */
    public BufferedImage getPage(int objectNumber, int generationNumber, int width, int height, int fit) {
        PDFPage pdfPage = new PDFPage(objectNumber, generationNumber, this);
        return pdfPage.getPageObject(this, width, height, fit);
    }
}
