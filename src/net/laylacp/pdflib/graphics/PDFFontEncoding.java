/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: PDFFontEncoding.java
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PDFFontEncoding {

    public static final int ENC_MacRomanEncoding = 0;
    public static final int ENC_WinAnsiEncoding = 1;
    public static final int ENC_StandardEncoding = 2;
    public static final int ENC_Custom = 3;
    public static final int ENC_Type3_Font = 4;

    private int encoding;
    private String[] encodingTable;
    // for type 3 fonts
    private HashMap<Integer, String> encodingTable3;


    public PDFFontEncoding(String fontEncoding) {
        if(fontEncoding.equalsIgnoreCase("MacRomanEncoding")) {
            encoding = ENC_MacRomanEncoding;
            encodingTable = PDFFontEncodingTables2.MacRomanEncoding;
        } else if(fontEncoding.equalsIgnoreCase("WinAnsiEncoding")) {
            encoding = ENC_WinAnsiEncoding;
            encodingTable = PDFFontEncodingTables2.WinAnsiEncoding;
        } else {
            encoding = ENC_StandardEncoding;
            encodingTable = PDFFontEncodingTables2.StandardEncoding;
        }
    }

    public PDFFontEncoding(HashMap<String, PDFObject> dictionary, boolean isType3Font,
                           PDFDocument pdfDocument) {
        // type 3 fonts
        if(isType3Font) {
            PDFObject differencesObj = dictionary.get("Differences");
            ArrayList<PDFObject> differences = differencesObj.getArrayValueNoFail(pdfDocument);
            encodingTable3 = new HashMap<>();
            int i = 0;
            for(PDFObject object : differences) {
                if(object.getType() == PDFObject.OBJECT_TYPE.NAME_OBJECT)
                    encodingTable3.put(i++, object.getStringValue());
                else {
                    i = object.getIntValue();
                }
            }
            encoding = ENC_Type3_Font;
            return;
        }

        // other types of fonts
        String baseEncoding = PDFDict.getStringDictEntry(dictionary, "BaseEncoding");
        encoding = ENC_Custom;
        if(baseEncoding.equalsIgnoreCase("MacRomanEncoding")) {
            encodingTable = PDFFontEncodingTables2.MacRomanEncoding;
            encodingTable = Arrays.copyOfRange(PDFFontEncodingTables2.MacRomanEncoding, 0, 256);
        } else if(baseEncoding.equalsIgnoreCase("WinAnsiEncoding")) {
            encodingTable = PDFFontEncodingTables2.WinAnsiEncoding;
            encodingTable = Arrays.copyOfRange(PDFFontEncodingTables2.WinAnsiEncoding, 0, 256);
        } else {
            encodingTable = PDFFontEncodingTables2.StandardEncoding;
            encodingTable = Arrays.copyOfRange(PDFFontEncodingTables2.StandardEncoding, 0, 256);
        }
        // patch the encoding table
        PDFObject differencesObj = dictionary.get("Differences");
        ArrayList<PDFObject> differences = differencesObj.getArrayValueNoFail(pdfDocument);
        int i = 0;
        for(PDFObject object : differences) {
            if(object.getType() == PDFObject.OBJECT_TYPE.NAME_OBJECT)
                encodingTable[i++] = glyphNameToUtf2(object.getStringValue());
                //encodingTable[i++] = glyphNameToUtf(object.getStringValue());
            else {
                i = object.getIntValue();
                if(i < 0) i = 0;
                if(i >= 256) i = 255;
            }
        }

    }

    public PDFFontEncoding(ObjectId toUnicodeCMap, PDFDocument pdfDocument) {
        PDFObjectStream CMapStream = pdfDocument.reader.getObjectStreamById(toUnicodeCMap, pdfDocument);
        PDFCMap pdfCMap = new PDFCMap();
        encodingTable3 = pdfCMap.getToUnicodeCMap(CMapStream);
    }

    public PDFFontEncoding(PDFObject CMap, PDFDocument pdfDocument) {
        /*
         * TODO: implement this
         */
        if (CMap.getType() == PDFObject.OBJECT_TYPE.STRING_OBJECT ||
                CMap.getType() == PDFObject.OBJECT_TYPE.NAME_OBJECT) {
            // predefined CMap

        } else if (CMap.getType() == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
            ObjectId id = CMap.getIdValue();
            PDFObjectStream CMapStrem = pdfDocument.reader.getObjectStreamById(id, pdfDocument);
            // read cmap stream

        } else {
            /*
             * NOTE: Failsafe, but SHOULD NOT happen!
             */
            encoding = ENC_StandardEncoding;
            encodingTable = PDFFontEncodingTables2.StandardEncoding;
        }
    }

    public String charCodeToUtf(int charCode) {
        if(encodingTable3 != null) {
            String utf = encodingTable3.get(charCode);
            return utf;
        }

        /*
         * TODO: this should never happen. fix it!
         */
        if(encodingTable == null) return "";
        if(charCode < 0) return "";

        return encodingTable[charCode];
    }

    public String charCodeToGlyphName(int charCode) {
        if(encoding == ENC_Type3_Font) {
            return encodingTable3.get(charCode);
        }
        return "";
    }

    private static HashMap<String, Integer> glyphList = null;
    private static HashMap<String, String> glyphList2 = null;

    public static int glyphNameToUtf(String glyph) {
        if(glyphList == null) {
            glyphList = PDFFontEncodingTables.getAdobeGlyphList();
        }
        int i = glyphList.get(glyph);
        return i;
    }

    public static String glyphNameToUtf2(String glyph) {
        if(glyphList2 == null) {
            glyphList2 = PDFFontEncodingTables2.getAdobeGlyphList();
        }
        String i = glyphList2.get(glyph);
        return i;
    }
}
