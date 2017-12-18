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
