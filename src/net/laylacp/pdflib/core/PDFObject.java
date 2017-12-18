/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: PDFObject.java
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
import net.laylacp.pdflib.core.types.TokenType;
import net.laylacp.pdflib.core.types.XRefEntry;
import net.laylacp.pdflib.graphics.Rectangle;
import net.laylacp.pdflib.reader.PDFByteArray;
import net.laylacp.pdflib.reader.PDFReader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static net.laylacp.pdflib.reader.PDFReader.*;


public class PDFObject {
    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public enum OBJECT_TYPE {
            BOOLEAN_OBJECT,
            //NUMBER_OBJECT,
            INTEGER_OBJECT,
            REAL_OBJECT,
            STRING_OBJECT,
            INDIRECT_REF_OBJECT,
            NAME_OBJECT,
            ARRAY_OBJECT,
            DICTIONARY_OBJECT,
            STREAM_OBJECT,
            OBJ_HEADER_OBJECT,
            NULL_OBJECT
    };

    private OBJECT_TYPE type;
    private Object value;
    private byte[] bytes;

    public OBJECT_TYPE getType() { return type; }

    public Object getValue() { return value; }

    public PDFObject() {
        this.type = OBJECT_TYPE.NULL_OBJECT;
        this.value = null;
    }

    public PDFObject(Object value, OBJECT_TYPE type) {
        this.type = type;
        this.value = value;
    }

    public boolean getBooleanValue() {
        if(type == OBJECT_TYPE.BOOLEAN_OBJECT) {
            return (boolean)value;
        }
        return false;
    }

    public double getNumericValue() {
        if(type == OBJECT_TYPE.REAL_OBJECT) {
            return (double)value;
        } else if(type == OBJECT_TYPE.INTEGER_OBJECT) {
            int i = (int)value;
            return (double)i;
        }
        try {
            double i = Double.parseDouble(value.toString());
            return i;
        } catch (Exception e) {
            return 0;
        }
    }

    public int getIntValue() {
        if(type == OBJECT_TYPE.INTEGER_OBJECT) {
            return (int)value;
        }
        try {
            Integer i = Integer.parseInt(value.toString());
            return i;
        } catch (Exception e) {
            return -1;
        }
    }

    public ObjectId getIdValue() {
        return (ObjectId) value;
    }

    public HashMap<String, PDFObject> getDictionaryValue() {
        return (HashMap<String, PDFObject>) value;
    }

    /*
     * Same as above, but handles the case where the dictionary is an indirect
     * object reference (this is why we pass a PDFDocument as a parameter.
     */
    public HashMap<String, PDFObject> getDictionaryValueNoFail(PDFDocument pdfDocument) {
        if (type == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
            PDFReader reader = new PDFReader();
            PDFObjectStream stream = reader.getObjectStreamById(getIdValue(), pdfDocument);
            if (stream != null) return stream.dictionary;
        } else if (type == PDFObject.OBJECT_TYPE.DICTIONARY_OBJECT) {
            return (HashMap<String, PDFObject>) value;
        }
        return new HashMap<>();
    }

    /*
     * get the value of an array as a PDF Rectangle Object [a b c d].
     */
    public Rectangle getRectangleValue() {
        if(type != OBJECT_TYPE.ARRAY_OBJECT) return new Rectangle(0, 0, 0, 0);
        ArrayList<PDFObject> array = (ArrayList<PDFObject>) value;
        if(array.size() < 4) return new Rectangle(0, 0, 0, 0);
        Double x1 = array.get(0).getNumericValue();
        Double y1 = array.get(1).getNumericValue();
        Double x2 = array.get(2).getNumericValue();
        Double y2 = array.get(3).getNumericValue();
        return new Rectangle(x1, y1, x2, y2);
    }

    public ArrayList<PDFObject> getArrayValue() {
        return (ArrayList<PDFObject>) value;
    }

    public ArrayList<PDFObject> getArrayValueNoFail(PDFDocument pdfDocument) {
        if (type == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
            ObjectId objectId = (ObjectId) value;
            PDFReader reader = new PDFReader();
            XRefEntry xRefEntry = reader.getXRefEntry(pdfDocument.xrefTable,
                    objectId.getObjectNumber(), objectId.getGenerationNumber());
            PDFByteArray byteArray = new PDFByteArray(xRefEntry.getByteOffset(),
                                            pdfDocument.sourceFile.data);
            reader.byteArray = byteArray;
            PDFObject object = reader.getNextObject();
            if(object.getType() == OBJECT_TYPE.OBJ_HEADER_OBJECT) {
                object = reader.getNextObject();
                if(object.getType() == OBJECT_TYPE.ARRAY_OBJECT) {
                    return object.getArrayValue();
                }
            }
        } else if (type == OBJECT_TYPE.ARRAY_OBJECT) {
            return (ArrayList<PDFObject>) value;
        }
        return new ArrayList<PDFObject>();
    }

    public String getStringValue() {
        return toString();
    }

    @Override
    public String toString() {
        if(type == OBJECT_TYPE.NAME_OBJECT || type == OBJECT_TYPE.STRING_OBJECT)
            return (String) value;
        if(type == OBJECT_TYPE.NULL_OBJECT) return "null";
        if(type == OBJECT_TYPE.ARRAY_OBJECT) {
            ArrayList<PDFObject> array = (ArrayList<PDFObject>) value;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[\n");
            for(PDFObject object : array) {
                stringBuilder.append("  ");
                stringBuilder.append(object.toString());
                stringBuilder.append("\n");
            }
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        if(type == OBJECT_TYPE.INDIRECT_REF_OBJECT) {
            ObjectId objectId = (ObjectId)value;
            return objectId.getObjectNumber() + " " + objectId.getGenerationNumber() + " R";
        }
        if(type == OBJECT_TYPE.OBJ_HEADER_OBJECT) {
            ObjectId objectId = (ObjectId)value;
            return objectId.getObjectNumber() + " " + objectId.getGenerationNumber() + " obj";
        }
        if(type == OBJECT_TYPE.DICTIONARY_OBJECT) {
            HashMap<String, PDFObject> dict = (HashMap<String, PDFObject>)value;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<<\n");
            for(Map.Entry object : dict.entrySet()) {
                stringBuilder.append("  ");
                stringBuilder.append(object.getKey());
                stringBuilder.append(" -> ");
                stringBuilder.append(object.getValue());
                stringBuilder.append("\n");
            }
            stringBuilder.append(">>");
            return stringBuilder.toString();
        }
        return value.toString();
    }

    public static boolean isInteger(String objectString) {
        if(objectString.length() == 0) return false;
        int i = -1;
        if(objectString.charAt(0) == '-' || objectString.charAt(0) == '+') i++;
        while(++i < objectString.length()) {
            if(objectString.charAt(i) < '0' || objectString.charAt(i) > '9')
                return false;
        }
        return true;
    }

    public static boolean isReal(String objectString) {
        if(objectString.length() == 0) return false;
        int i = -1;
        int dots = 0;
        if(objectString.charAt(0) == '-' || objectString.charAt(0) == '+') i++;
        while(++i < objectString.length()) {
            if(objectString.charAt(i) < '0' || objectString.charAt(i) > '9') {
                if(objectString.charAt(i) != '.')
                    return false;
                dots++;
            }
        }
        if(dots > 1) return false;
        return true;
    }
}
