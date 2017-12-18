/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: PDFCMap.java
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

import net.laylacp.pdflib.reader.PDFReader;

import java.util.HashMap;

public class PDFCMap {
    class StringArray {
        String string;
        int offset;
    }

    public HashMap<Integer, String>cmap = new HashMap<>();

    public HashMap<Integer, String> getToUnicodeCMap(PDFObjectStream CMapStream) {
        String str = new String(CMapStream.stream.data);
        StringArray stringArray = new StringArray();
        stringArray.string = str;
        stringArray.offset = 0;
        int offset, endoffset;
        int i, j;
        int bytes = 0;

        /*
         * 1 - get the ranges
         */
        offset = str.indexOf("beginbfrange");
        while(offset >= 0) {
            i = 0;
            endoffset = str.indexOf("endbfrange", offset);
            if(endoffset < 0) endoffset = str.length();
            while(offset < endoffset) {
                // get the start of the range
                while (str.charAt(offset) != '<') offset++;
                stringArray.offset = offset;
                i = getNumber(stringArray);
                if (bytes == 0) {
                    j = stringArray.offset - offset;
                    bytes = j / 2;
                }
                // get the end of the range
                offset = stringArray.offset;
                while (str.charAt(offset) != '<') offset++;
                stringArray.offset = offset;
                j = getNumber(stringArray);
                // go to the start of the values
                offset = stringArray.offset;
                while (str.charAt(offset) != '<' && str.charAt(offset) != '[') offset++;
                // first version
                if (str.charAt(offset) == '<') {
                    stringArray.offset = offset;
                    int val = getNumber(stringArray);
                    for (int k = i; k <= j; k++) {
                        cmap.put(k, new String(Character.toChars(val++)));
                    }
                    while (str.charAt(stringArray.offset) != '>') stringArray.offset++;
                } else {
                    // second version
                    for (int k = i; k <= j; k++) {
                        while (str.charAt(offset) != '<') offset++;
                        stringArray.offset = offset;
                        cmap.put(k, getString(stringArray));
                        while (str.charAt(stringArray.offset) != '>') stringArray.offset++;
                        offset = stringArray.offset;
                    }
                    while (str.charAt(stringArray.offset) != ']') stringArray.offset++;
                }
                char c = str.charAt(stringArray.offset);
                if(c == '>' || c == ']') stringArray.offset++;
                skipSpaces(stringArray);
                offset = stringArray.offset;
            }
            offset = str.indexOf("beginbfrange", endoffset);
        }

        /*
         * 2 - get the individual chars
         */
        offset = str.indexOf("beginbfchar");
        while(offset >= 0) {
            i = 0;
            endoffset = str.indexOf("endbfchar", offset);
            if (endoffset < 0) endoffset = str.length();
            while(offset < endoffset) {
                // get the char code
                while (str.charAt(offset) != '<') offset++;
                stringArray.offset = offset;
                i = getNumber(stringArray);
                // get the value
                offset = stringArray.offset;
                while (str.charAt(offset) != '<') offset++;
                stringArray.offset = offset;
                cmap.put(i, getString(stringArray));
                char c = str.charAt(stringArray.offset);
                if (c == '>') stringArray.offset++;
                skipSpaces(stringArray);
                offset = stringArray.offset;
            }
            offset = str.indexOf("beginbfchar", endoffset);
        }
        return cmap;
    }

    private void skipSpaces(StringArray stringArray) {
        int offset = stringArray.offset;
        int len = stringArray.string.length();
        while (offset < len) {
            char c = stringArray.string.charAt(offset);
            if(c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\0') offset++;
            else break;
        }
        stringArray.offset = offset;
    }

    private int getNumber(StringArray stringArray) {
        String str = stringArray.string;
        int offset = stringArray.offset;
        int i = 0;
        while(str.charAt(++offset) != '>') {
            i *= 16;
            int i2 = (PDFReader.getHextDigitValue((byte) str.charAt(offset)) & 0xff);
            i += i2;
        }
        stringArray.offset = offset;
        return i;
    }

    private String getString(StringArray stringArray) {
        String str = stringArray.string;
        int offset = stringArray.offset;
        int i = 0;
        int digits = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while(str.charAt(++offset) != '>') {
            i *= 16;
            int i2 = (PDFReader.getHextDigitValue((byte) str.charAt(offset)) & 0xff);
            i += i2;
            if(++digits == 4) {
                stringBuilder.appendCodePoint(i);
                digits = 0;
                i = 0;
            }
        }
        stringArray.offset = offset;
        return stringBuilder.toString();
    }

}
