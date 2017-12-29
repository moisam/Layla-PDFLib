/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: PDFFontBuiltin.java
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

import java.awt.font.TextAttribute;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

class FCache {
    //public String fileName;
    public PDFFontDescriptor pdfFontDescriptor;
    public HashMap<String, Integer> allWidths;
}

public class PDFFontBuiltin {
    /*
     * keep an internal cache, so that we don't need to re-read the AFM files every time
     * we need them.
     */
    private static HashMap<String, FCache> fcache = new HashMap<>();


    public static boolean getBuiltinMetrics(PDFFont pdfFont) {
        String baseFont = pdfFont.getBaseFont();
        boolean italic = false, bold = false;
        String fileName = "";


        if (baseFont.contains("Italic")) {
            italic = true;
        }

        if (baseFont.contains("Bold")) {
            bold = true;
        }

        if(baseFont.startsWith("Times-Roman") ||
                baseFont.startsWith("Times-") ||
                baseFont.startsWith("Times New Roman")) {
            //pdfFontDescriptor.fontFamily = "Times New Roman";
            if(bold && italic) fileName = "Times-BoldItalic.afm";
            else if(bold) fileName = "Times-Bold.afm";
            else if(italic) fileName = "Times-Italic.afm";
            else fileName = "Times-Roman.afm";
        } else if(baseFont.startsWith("Courier")) {
            //pdfFontDescriptor.fontFamily = "Courier";
            if(bold && italic) fileName = "Courier-BoldOblique.afm";
            else if(bold) fileName = "Courier-Bold.afm";
            else if(italic) fileName = "Courier-Oblique.afm";
            else fileName = "Courier.afm";
        } else if(baseFont.startsWith("Helvetica")) {
            //pdfFontDescriptor.fontFamily = "Helvetica";
            if(bold && italic) fileName = "Helvetica-BoldOblique.afm";
            else if(bold) fileName = "Helvetica-Bold.afm";
            else if(italic) fileName = "Helvetica-Oblique.afm";
            else fileName = "Helvetica.afm";
        } else if(baseFont.startsWith("Symbol")) {
            //pdfFontDescriptor.fontFamily = "Symbol";
            fileName = "Symbol.afm";
        } else if(baseFont.startsWith("ZapfDingbats")) {
            //pdfFontDescriptor.fontFamily = "ZapfDingbats";
            fileName = "ZapfDingbats.afm";
        } else {
            return false;
        }

        FCache cachedFile = loadBuiltinFontMetrics(baseFont, fileName);
        PDFFontDescriptor pdfFontDescriptor = null;
        try {
            pdfFontDescriptor = (PDFFontDescriptor) cachedFile.pdfFontDescriptor.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        HashMap<String, Integer> allWidths = cachedFile.allWidths;

        // now extract the char widths for the chars included in the font, as set in
        // the font encoding table.
        PDFFontEncoding encoding = pdfFont.getEncoding();
        String[] encodingTable = encoding.getEncodingTable();
            /*
             * TODO: we are not handling Font Type 3, in which case we should get the encodingTable3.
             */
        if(encodingTable == null) return false;

        int[] widths = new int[encodingTable.length];
        int i = 0, j;
        for(String enc : encodingTable) {
            try {
                j = allWidths.get(enc);
                widths[i++] = j;
            } catch (NullPointerException e) {
                widths[i++] = 0;
            }
        }

        pdfFont.setWidthArray(widths);
        pdfFont.setFirstChar(0);
        pdfFont.setLastChar(widths.length-1);
        pdfFont.setFontDescriptor(pdfFontDescriptor);
        return true;
    }

    private static FCache loadBuiltinFontMetrics(String baseFont, String fileName) {
        fileName = "Core14_AFMs/" + fileName;
        FCache cachedFile = fcache.get(fileName);
        if(cachedFile != null) return cachedFile;

        PDFFontDescriptor pdfFontDescriptor = new PDFFontDescriptor();
        pdfFontDescriptor.fontWeight = TextAttribute.WEIGHT_REGULAR;
        if (baseFont.contains("Italic")) {
            pdfFontDescriptor.flags |= PDFFontDescriptor.FLAG_ITALIC;
        }

        if (baseFont.contains("Bold")) {
            pdfFontDescriptor.flags |= PDFFontDescriptor.FLAG_FORCEBOLD;
            pdfFontDescriptor.fontWeight = TextAttribute.WEIGHT_BOLD;
        }

        /*
         * We are going to read in the AFM (Adobe Font Metrics) file. The files for Adobe's
         * 14 builtin fonts are included in this JAR (under /res). The following only works
         * because we know EXACTLY how those files are formatted, which enables us to skip
         * things like error checking. We jump straight to the info we want. If you want to
         * generalize this function (i.e. make it world-usable) you will need to rewrite the
         * following code.
         */
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        //InputStream is = classloader.getResourceAsStream(fileName);
        byte[] bytes;
        String contents, substr;
        int i, j;
        boolean b;
        HashMap<String, String> glyphList = PDFFontEncodingTables2.getAdobeGlyphList();

        try {
            bytes = Files.readAllBytes(Paths.get(classloader.getResource(fileName).toURI()));
            contents = new String(bytes);

            i = contents.indexOf("FontName") + 9;
            j = contents.indexOf('\r', i);
            substr = contents.substring(i, j);
            pdfFontDescriptor.fontName = substr;

            i = contents.indexOf("FamilyName") + 11;
            j = contents.indexOf('\r', i);
            substr = contents.substring(i, j);
            pdfFontDescriptor.fontFamily = substr;

            i = contents.indexOf("ItalicAngle", j) + 12;
            j = contents.indexOf('\r', i);
            substr = contents.substring(i, j);
            pdfFontDescriptor.italicAngle = Float.parseFloat(substr);

            i = contents.indexOf("IsFixedPitch", j) + 13;
            j = contents.indexOf('\r', i);
            substr = contents.substring(i, j);
            b = Boolean.parseBoolean(substr);
            if(b) pdfFontDescriptor.flags |= PDFFontDescriptor.FLAG_FIXEDPITCH;

            Rectangle bbox = new Rectangle();
            i = contents.indexOf("FontBBox", j) + 9;
            j = contents.indexOf(' ', i);
            substr = contents.substring(i, j);
            bbox.x1 = Integer.parseInt(substr);
            i = j + 1;
            j = contents.indexOf(' ', i);
            substr = contents.substring(i, j);
            bbox.y1 = Integer.parseInt(substr);
            i = j + 1;
            j = contents.indexOf(' ', i);
            substr = contents.substring(i, j);
            bbox.x2 = Integer.parseInt(substr);
            i = j + 1;
            j = contents.indexOf(' ', i);
            substr = contents.substring(i, j);
            bbox.y2 = Integer.parseInt(substr);
            pdfFontDescriptor.fontBBox = bbox;

            i = contents.indexOf("CapHeight", j) + 10;
            j = contents.indexOf('\r', i);
            substr = contents.substring(i, j);
            pdfFontDescriptor.capHeight = Float.parseFloat(substr);

            i = contents.indexOf("XHeight", j) + 8;
            j = contents.indexOf('\r', i);
            substr = contents.substring(i, j);
            pdfFontDescriptor.xHeight = Float.parseFloat(substr);

            i = contents.indexOf("Ascender", j) + 9;
            j = contents.indexOf('\r', i);
            substr = contents.substring(i, j);
            pdfFontDescriptor.ascent = Float.parseFloat(substr);

            i = contents.indexOf("Descender", j) + 10;
            j = contents.indexOf('\r', i);
            substr = contents.substring(i, j);
            pdfFontDescriptor.descent = Float.parseFloat(substr);

            int end = contents.indexOf("EndCharMetrics", j);
            HashMap<String, Integer> allWidths = new HashMap<>();

            // get the char widths
            while(true) {
                i = contents.indexOf("; WX", j);
                if(i < 0 || i >= end) break;
                i += 5;
                j = contents.indexOf(' ', i);
                substr = contents.substring(i, j);
                int wx = Integer.parseInt(substr);

                i = contents.indexOf("; N", j) + 4;
                j = contents.indexOf(' ', i);
                String name = contents.substring(i, j);

                String utf = glyphList.get(name);
                allWidths.put(utf, wx);
            }

            cachedFile = new FCache();
            cachedFile.allWidths = allWidths;
            cachedFile.pdfFontDescriptor = pdfFontDescriptor;
            return cachedFile;

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return null;
        }
    }
}
