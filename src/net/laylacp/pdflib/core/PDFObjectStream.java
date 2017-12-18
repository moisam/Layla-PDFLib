/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: PDFObjectStream.java
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
import net.laylacp.pdflib.reader.PDFByteArray;
import net.laylacp.pdflib.reader.PDFReader;

import java.util.ArrayList;
import java.util.HashMap;

public class PDFObjectStream {
    public int offset;  //offset of object within the file (or stream)
    public HashMap<String, PDFObject> dictionary;  // all object streams have dictionaries
    public PDFByteArray stream;
    public PDFDocument pdfDocument;


    public boolean isObjectOfType(String type) {
        String type2 = PDFDict.getStringDictEntry(dictionary, "Type");
        return type2.equals(type);
    }

    public ArrayList<String> getFilterList() {
        ArrayList<String> filtersList = new ArrayList<>();
        PDFObject filters = dictionary.get("Filter");
        if (filters != null) {
            if(filters.getType() == PDFObject.OBJECT_TYPE.NAME_OBJECT) {
                filtersList.add(filters.getStringValue());
            } else if(filters.getType() == PDFObject.OBJECT_TYPE.ARRAY_OBJECT) {
                ArrayList<PDFObject> array = (ArrayList<PDFObject>)filters.getValue();
                for(PDFObject f : array) {
                    filtersList.add(f.getStringValue());
                }
            }
        }
        return filtersList;
    }

    public HashMap<String, PDFObject> getDictEntry(String key) {
        Object res = PDFDict.getDictionaryEntry(dictionary, key, null);
        if(res != null) {
            PDFObject res2 = (PDFObject)res;
            if(res2.getType() == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
                PDFReader reader = pdfDocument.reader;
                ObjectId id = (ObjectId) res2.getValue();
                PDFObjectStream stream = reader.getObjectStreamById(id.getObjectNumber(),
                        id.getGenerationNumber(), reader.byteArray, pdfDocument);
                if(stream != null) return stream.dictionary;
            } else if(res2.getType() == PDFObject.OBJECT_TYPE.DICTIONARY_OBJECT) {
                return (HashMap<String, PDFObject>) res2.getValue();
            }
        }
        return new HashMap<>();
    }

    public HashMap<String, PDFObject> getResourcesDict() {
        return getDictEntry("Resources");
    }

    public HashMap<String, PDFObject> getFontsDict() {
        return getDictEntry("Font");
    }
}
