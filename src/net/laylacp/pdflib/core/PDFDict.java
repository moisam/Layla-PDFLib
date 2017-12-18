package net.laylacp.pdflib.core;

import net.laylacp.pdflib.core.types.ObjectId;
import net.laylacp.pdflib.graphics.Rectangle;

import java.util.ArrayList;
import java.util.HashMap;

public class PDFDict {

    public static boolean getBooleanDictEntry(HashMap<String, PDFObject> dictionary, String key) {
        if(dictionary == null) return false;
        PDFObject value = dictionary.get(key);
        if(value == null) return false;
        if(value.getType() != PDFObject.OBJECT_TYPE.BOOLEAN_OBJECT) return false;
        return (boolean)value.getValue();
    }

    public static int getIntDictEntry(HashMap<String, PDFObject> dictionary, String key) {
        if(dictionary == null) return -1;
        PDFObject value = dictionary.get(key);
        if(value == null) return -1;
        if(value.getType() != PDFObject.OBJECT_TYPE.INTEGER_OBJECT) {
            if(value.getType() != PDFObject.OBJECT_TYPE.REAL_OBJECT) return -1;
            double i = (double)value.getValue();
            return (int)i;
        }
        return (int)value.getValue();
    }

    public static double getRealDictEntry(HashMap<String, PDFObject> dictionary, String key) {
        if(dictionary == null) return 0.0;
        PDFObject value = dictionary.get(key);
        if(value == null) return 0.0;
        if(value.getType() != PDFObject.OBJECT_TYPE.REAL_OBJECT) {
            if(value.getType() != PDFObject.OBJECT_TYPE.INTEGER_OBJECT) return 0.0;
            int i = (int)value.getValue();
            return (double)i;
        }
        return (double)value.getValue();
    }

    public static ArrayList<PDFObject> getArrayDictEntry(HashMap<String, PDFObject> dictionary, String key) {
        if(dictionary == null) return new ArrayList<>();
        PDFObject value = dictionary.get(key);
        if(value == null) return new ArrayList<>();
        if(value.getType() != PDFObject.OBJECT_TYPE.ARRAY_OBJECT) return new ArrayList<>();
        return (ArrayList<PDFObject>)value.getValue();
    }

    public static Rectangle getRectangleDictEntry(HashMap<String, PDFObject> dictionary, String key) {
        if(dictionary == null) return new Rectangle(0, 0, 0, 0);
        PDFObject value = dictionary.get(key);
        if(value == null) return new Rectangle(0, 0, 0, 0);
        return value.getRectangleValue();
    }

    public static HashMap<String, PDFObject> getDictionaryDictEntry(
            HashMap<String, PDFObject> dictionary, String key) {
        if(dictionary == null) return new HashMap<>();
        PDFObject value = dictionary.get(key);
        if(value == null) return new HashMap<>();
        if(value.getType() != PDFObject.OBJECT_TYPE.DICTIONARY_OBJECT) return new HashMap<>();
        return (HashMap<String, PDFObject>) value.getValue();
    }

    public static String getStringDictEntry(HashMap<String, PDFObject> dictionary, String key) {
        if(dictionary == null) return "";
        PDFObject value = dictionary.get(key);
        if(value == null) return "";
        //System.out.println(value.getValue());
        //if(value.getType() != OBJECT_TYPE.STRING_OBJECT) return "";
        return value.getStringValue();
    }

    public static ObjectId invalidObjectId = new ObjectId(-1, -1);

    public static ObjectId getIndirectRefDictEntry(HashMap<String, PDFObject> dictionary, String key) {
        if(dictionary == null) return invalidObjectId;
        PDFObject value = dictionary.get(key);
        if(value == null) return invalidObjectId;
        //System.out.println(value.getValue());
        if(value.getType() != PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) return invalidObjectId;
        return (ObjectId)value.getValue();
    }


    /*
     * get the Object value of the required dictionary entry. If not found, we check for
     * inheritable entries by recursively looking at the parents (until we reach the root),
     * that is if the caller passed a PDFDocument param.
     */
    public static PDFObject getDictionaryEntry(HashMap<String, PDFObject> dictionary, String key,
                                            PDFDocument pdfDocument) {
        if(dictionary == null) return null;
        //boolean askParent;
        PDFObject value = dictionary.get(key);
        if(value == null) {
            if(pdfDocument != null) {
                ObjectId parentId = getIndirectRefDictEntry(dictionary, "Parent");
                while(parentId != null) {
                    PDFObjectStream parentStream = pdfDocument.reader.getObjectStreamById(parentId.getObjectNumber(),
                            parentId.getGenerationNumber(), pdfDocument.reader.byteArray, pdfDocument);
                    if(parentStream == null) return null;
                    dictionary = parentStream.dictionary;
                    if(dictionary == null) return null;
                    value = dictionary.get(key);
                    if(value != null)
                        return value;
                    else
                        parentId = getIndirectRefDictEntry(dictionary, "Parent");
                }
            }
            return null;
        }
        //System.out.println(value.getValue());
        return value;
    }

    public static Object getDictionaryEntryVal(HashMap<String, PDFObject> dictionary, String key,
                                            PDFDocument pdfDocument) {
        PDFObject object = getDictionaryEntry(dictionary, key, pdfDocument);
        if(object != null) return object.getValue();
        return null;
    }
}
