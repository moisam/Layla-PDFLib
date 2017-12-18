package net.laylacp.pdflib.reader;

import net.laylacp.pdflib.core.*;
import net.laylacp.pdflib.core.types.ObjectId;
import net.laylacp.pdflib.core.types.TokenType;
import net.laylacp.pdflib.core.types.XRefEntry;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;


public class PDFReader {
    /*
     * PDF File Structure (Figure 2, page 39):
     * • A one-line header identifying the version of the PDF specification to which the file conforms
     * • A body containing the objects that make up the document contained in the file
     * • A cross-reference table containing information about the indirect objects in the file
     * • A trailer giving the location of the cross-reference table and of certain special objects within
     *     the body of the file
     */

    /*
     * Versions accepted by this reader:
     */
    private String[] acceptedVersions = { "1.0", "1.1", "1.2", "1.3", "1.4", "1.5", "1.6", "1.7" };

    private String lastError = "";
    public static PDFToken EOFToken = new PDFToken(TokenType.TOKEN_EOF, null);
    public PDFByteArray byteArray = null;

    private boolean pedantic = false;
    private boolean debugging = true;
    private boolean compatibilityMode = false;

    public String getLastError() { return lastError; }
    public void setLastError(String lastError) { this.lastError = lastError; }
    public boolean getPedantic() { return pedantic; }
    public void setPedantic(boolean pedantic) { this.pedantic = pedantic; }
    public boolean getDebugging() { return debugging; }
    public void setDebugging(boolean debugging) { this.debugging = debugging; }
    public boolean getCompatibilityMode() { return compatibilityMode; }
    public void setCompatibilityMode(boolean compatibilityMode) {
        this.compatibilityMode = compatibilityMode;
    }

    /* offset of Cross-Reference sections from beginning of file */
    private long XRefStartAt = -1;

    /* this field will be used when reading XRef table with multiple sections */
    PDFObject prev;

    /*
     * Table (1) on Page 12 of PDF 32000-1:2008.
     */
    public static byte[] WHITESPACE_CHARS = {
            0x00,   // null
            0x09,   // horz tab
            0x0a,   // line feed
            0x0c,   // form feed
            0x0d,   // carriage return
            0x20,   // space
    };

    /*
     * Table (2) on Page 13 of PDF 32000-1:2008.
     */
    public static byte[] DELIMITER_CHARS = {
            0x28,   // ( left paren
            0x29,   // ) right paren
            0x3c,   // < LT
            0x3e,   // > GT
            0x5b,   // [ left sq bracket
            0x5d,   // ] right sq bracket
            0x7b,   // { left curly bracket
            0x7d,   // } right curly bracket
            //0x2f,   // / solidus
            //0x25,   // % precent sign
    };

    /* token types corresponding to the above DELIMITER_CHARS array */
    public static TokenType[] DELIMITER_TOKEN_TYPES = {
            TokenType.TOKEN_LT_PAREN,
            TokenType.TOKEN_RT_PAREN,
            TokenType.TOKEN_LESS_THAN,
            TokenType.TOKEN_GREATER_THAN,
            TokenType.TOKEN_LT_BRACKET,
            TokenType.TOKEN_RT_BRACKET,
            TokenType.TOKEN_LT_CURLY,
            TokenType.TOKEN_RT_CURLY,
            //TokenType.TOKEN_SOLIDUS,
            //TokenType.TOKEN_PERCENT,
    };

    /*
     * Table (15) on Page 43 of PDF 32000-1:2008.
     * These are the Entries in the file trailer dictionary.
     */
    public static String[] TRAILER_DICT_KEYS = {
            "Size",
            "Prev",
            "Root",
            "Encrypt",
            "Info",
            "ID"
    };

    public static byte[] EOL_CHARS = {
            0x0a,   // line feed
            0x0d,   // carriage return
    };

    public static boolean isEOLChar(byte c) {
        if(c == EOL_CHARS[0] || c == EOL_CHARS[1]) return true;
        return false;
    }

    public static boolean isWhitespaceChar(byte c) {
        //if(c == 0x00 || c == 0x09 || c == 0x0a || c == 0x0c || c == 0x0d || c == 0x20) return true;
        for(byte ws : WHITESPACE_CHARS) {
            if(c == ws) return true;
        }
        return false;
    }

    public static boolean isDelimiterChar(byte c) {
        for(byte dlm : DELIMITER_CHARS) {
            if(c == dlm) return true;
        }
        if(c == '/' || c == '%') return true;
        return false;
    }

    public static void skipWhitespace(PDFByteArray byteArray) throws IOException {
        /*
         * PDF standard says:
         * ==================
         * Any occurrence of the PERCENT SIGN (25h) outside a string or stream introduces a comment.
         * The comment consists of all characters after the PERCENT SIGN and up to but not including
         * the end of the line, including regular,  delimiter,  SPACE  (20h),  and  HORZONTAL  TAB
         * characters  (09h).  A  conforming  reader  shall  ignore comments, and treat them as single
         * white-space characters. That is, a comment separates the token preceding it from the one
         * following it.
         */
        int offset = byteArray.offset;
        if(offset < 0 || offset >= byteArray.getDataLength()) return;

        int i = offset;
        int len = byteArray.getDataLength();
        /* skip the WhiteSpace characters, including all the comments */
        while(i < len) {
            byte b = byteArray.getByteAt(i);
            if(isWhitespaceChar(b)) i++;
            else if(b == '%') {
                /* skip over comment */
                while(++i < len) {
                    b = byteArray.getByteAt(i);
                    if(b == EOL_CHARS[0] || b == EOL_CHARS[1]) break;
                }
            }
            else break;
        }
        byteArray.setOffset(i);
    }

    public PDFToken getNextToken(PDFByteArray byteArray) throws IOException {
        /*
         * PDF standard says:
         * ==================
         * All characters except the white-space characters and delimiters are referred to as
         * regular  characters. These characters  include  bytes  that  are outside  the  ASCII
         * character  set.  A sequence  of  consecutive  regular characters  comprises  a  single
         * token.  PDF  is  case-sensitive;  corresponding  uppercase  and  lowercase  letters
         * shall be considered distinct.
         */

        if(byteArray.offset < 0 || byteArray.offset >= byteArray.getDataLength()) {
            byteArray.setOffset(-1);
            return EOFToken;
        }
        int i;
        /* skip the WhiteSpace characters */
        skipWhitespace(byteArray);
        if(byteArray.offset >= byteArray.getDataLength()) {
            byteArray.setOffset(-1);
            return EOFToken;
        }

        /* check for delimiter tokens, e.g. { ( [ < ... */
        byte b = byteArray.getByteAt(byteArray.offset);
        for(i = 0; i < DELIMITER_CHARS.length; i++) {
            if(b == DELIMITER_CHARS[i]) {
                PDFToken token = new PDFToken();
                /* check for digraph tokens '<<' and '>>' */
                byte b2 = byteArray.getByteAt(byteArray.offset+1);
                if(b == '<' && b2 == '<') {
                    token.type = TokenType.TOKEN_DBL_LESS_THAN;
                    byteArray.setOffset(byteArray.offset+2);
                } else if(b == '>' && b2 == '>') {
                    token.type = TokenType.TOKEN_DBL_GREATER_THAN;
                    byteArray.setOffset(byteArray.offset+2);
                } else {
                    token.type = DELIMITER_TOKEN_TYPES[i];
                    byteArray.setOffset(byteArray.offset+1);
                }
                return token;
            }
        }

        /* check for Name Objects, starting with '/' */
        if(byteArray.getByteAt(byteArray.offset) == '/') {
            String name = getNameObject(byteArray);
            if(name == null) return null;
            PDFToken token = new PDFToken(TokenType.TOKEN_NAME_OBJECT, name);
            //__DEBUG__("parse", "NAME TOKEN = '" + name + "'");
            return token;
        }

        /* get the token string */
        i = byteArray.offset+1;
        while((i < byteArray.getDataLength()) &&
                !isWhitespaceChar(byteArray.getByteAt(i)) &&
                !isDelimiterChar(byteArray.getByteAt(i)))
            i++;
        byte[] tok = byteArray.copyOfRange(byteArray.offset, i);
        String tokenStr = new String(tok);
        PDFToken token = new PDFToken();
        token.value = tokenStr;
        byteArray.setOffset(i);
        //__DEBUG__("parse", "tokenStr = '" + tokenStr + "'");
        return token;
    }


    /*
     * get the previous line, starting from the current position in data.
     * a line starts from the previous CR, LF or CRLF char.
     */
    private byte[] getPrevLine(PDFByteArray byteArray) {
        int offset = byteArray.offset;
        if(offset < 0 || offset >= byteArray.getDataLength()) {
            byteArray.setOffset(-1);
            return null;
        }
        int i = offset;
        // skip the EOL characters
        try {
            while ((i > 0) && isEOLChar(byteArray.getByteAt(i))) i--;
            offset = i;
            for (; i >= 0; i--) {
                if (isEOLChar(byteArray.getByteAt(i))) {
                    // get the line without the EOL markers
                    byte[] res = byteArray.copyOfRange(i + 1, offset + 1);
                    byteArray.setOffset(i);
                    return res;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        // reached start of data? check we have a line
        if(offset >= 0) {
            // get the line without the EOL markers
            byte[] res = byteArray.copyOfRange(0, offset+1);
            byteArray.setOffset(-1);
            return res;
        }
        // nope. we already milked this array to the max.
        byteArray.setOffset(-1);
        return null;
    }


    public PDFDocument parse(String filePath) {
        try {
            //final FileChannel channel = new FileInputStream(filePath).getChannel();
            //MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            //byte[] bytes = buffer.array();
            //long fileSize = channel.size();

            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            long fileSize = bytes.length;

            /* read the file signature */
            byte[] signature = Arrays.copyOfRange(bytes, 0, 8);
            /* make sure it is a PDF file */
            if(signature[0] != '%' || signature[1] != 'P' || signature[2] != 'D' || signature[3] != 'F') {
                lastError = "This file is not a PDF file";
                //channel.close();
                return null;
            }
            /* then check if the version is supported by this reader */
            String sigStr = new String(signature);
            __DEBUG__("parse", "signature = '" + sigStr + "'");
            boolean accepted = false;
            for(String acceptedVer : acceptedVersions) {
                String s = "%PDF-" + acceptedVer;
                if(s.equals(sigStr)) {
                    accepted = true;
                    break;
                }
            }

            String pdfVer = sigStr.substring(5);
            if(!accepted) {
                lastError = "This PDF file is version " + pdfVer + " which is not supported by this reader";
                //channel.close();
                return null;
            }

            /* create our PDFDocument object */
            PDFDocument pdfDocument = new PDFDocument();
            pdfDocument.version = pdfVer;
            pdfDocument.fileName = filePath;
            pdfDocument.reader = this;
            HashMap<String, PDFObject> trailer = null;

            /***********************************************************
             * Read PDF file Trailer. It looks like this:
             *
             * trailer
             *   << key1 value1
             *      key2 value2
             *      ...
             *      keyn valuen
             *   >>
             * startxref
             * Byte_offset_of_last_cross-reference_section
             * %%EOF
             *
             * The PDF Standard says (See page 42 of PDF Std 1.7):
             * "Conforming readers should read a PDF file from its end"
             ***********************************************************/
            int i;
            PDFByteArray byteArray = new PDFByteArray((int)(fileSize-1), bytes);
            this.byteArray = byteArray;
            pdfDocument.sourceFile = byteArray;

            /* goto end of file and search for %%EOF (EOF marker) */
            byte[] line = getPrevLine(byteArray);
            String s = new String(line);
            if(s == null || !s.equals("%%EOF")) {
                lastError = "PDF file is missing the EOF marker";
                __DEBUG__("parse", "last line = '" + s + "'");
                return null;
            }

            /* get the previous two lines, containing the word 'startxref' and
             * the Byte_offset_of_last_cross-reference_section.
             */
            line = getPrevLine(byteArray);
            s = new String(line);
            line = getPrevLine(byteArray);
            String s2 = new String(line);
            __DEBUG__("parse", "s = '" + s + "'");
            __DEBUG__("parse", "s2 = '" + s2 + "'");
            if(s == null || s2 == null || !s2.equals("startxref")) {
                lastError = "PDF file is corrupt";
                return null;
            }

            XRefStartAt = Integer.parseInt(s);
            __DEBUG__("parse", "XRefStartAt = " + XRefStartAt);
            if(XRefStartAt < 0 || XRefStartAt >= fileSize) {
                lastError = "PDF file is corrupt (invalid XRef offset)";
                return null;
            }

            PDFObjectStream objectStream = getObjectStreamAtOffest(byteArray, (int) XRefStartAt, false, false);
            if(objectStream != null) {
                trailer = new HashMap<>();
                trailer.put("XRefStm", new PDFObject((int)XRefStartAt,
                        PDFObject.OBJECT_TYPE.INTEGER_OBJECT));
                PDFObject prev = objectStream.dictionary.get("Prev");
                if(prev != null) { trailer.put("Prev", prev); }
                PDFObject root = objectStream.dictionary.get("Root");
                if(root != null) { trailer.put("Root", root); }
                PDFObject size = objectStream.dictionary.get("Size");
                if(size != null) { trailer.put("Size", size); }
            } else {
                /* search backwards to find the beginning of the trailer section */
                i = byteArray.offset;
                for (; i > 0; i--) {
                    if (byteArray.getByteAt(i) == '<' &&
                            byteArray.getByteAt(i - 1) == '<') {
                        i -= 2;
                        __DEBUG__("parse", "i = " + i);
                        if (i < 0) {
                            lastError = "PDF file is corrupt";
                            return null;
                        }
                        byteArray.setOffset(i);
                        int j = i + 1;    // remember where the '<<' is located
                        line = getPrevLine(byteArray);
                        s = new String(line);
                        __DEBUG__("parse", "s = '" + s + "'");
                        if (!s.equals("trailer")) {
                            lastError = "PDF file is corrupt";
                            return null;
                        }

                        __DEBUG__("parse", "Reading PDF file trailer");
                        /* now read the trailer */
                        i = byteArray.offset;   // remember where the 'trailer' keyword is.
                        byteArray.setOffset(j);
                        trailer = getDictObject();
                        if (trailer == null) {
                            lastError = "PDF file is corrupt (missing or invalid trailer)";
                            return null;
                        }
                        break;
                    }
                }
            }


            /****************************************************
             * Read PDF file Cross-Reference Table. See page 40.
             ****************************************************/

            /*
             * check for the presence of a cross-reference stream.
             * SEE 7.5.8 Cross-Reference Streams, page 49 of PDF 1.7 Std.
             */
            ArrayList<XRefEntry> xRefEntries;
            PDFObject xrefStreamOffset = trailer.get("XRefStm");

            PDFObject lastObjectNumber = trailer.get("Size");
            if (lastObjectNumber == null ||
                    lastObjectNumber.getType() != PDFObject.OBJECT_TYPE.INTEGER_OBJECT) {
                lastError = "PDF file is corrupt";
                return null;
            }
            int n = (int) lastObjectNumber.getValue();

            if(xrefStreamOffset != null) {
                int n2 = (int) xrefStreamOffset.getValue();
                //byteArray.offset = n;
                byteArray.setOffset(n2);
                xRefEntries = readXRefStream(byteArray, n2);
            } else {
                /*
                 * read the XRef table section and add it to the document
                 */
                xRefEntries = readXRefSection(byteArray, XRefStartAt, n);
            }

            if(xRefEntries == null) {
                lastError = "Failed to read cross reference table";
                return null;
            }
            pdfDocument.xrefTable.addAll(xRefEntries);

            /*
             * look for other trailers (PDF files that have been incrementally updated)
             */
            prev = trailer.get("Prev");
            while (prev != null) {
                int j = (int) prev.getValue();
                __DEBUG__("parse", "Reading prev trailer at " + j);
                //byteArray.offset = j;   // go to the previous trailer.
                byteArray.setOffset(j);
                PDFToken token = getNextToken(byteArray);
                if (token.value.equals("xref")) {
                    // read the XRef table section and add it to the document
                    xRefEntries = readXRefSection(byteArray, j, n);
                    prev = null;
                } else {
                    byteArray.setOffset(j);
                    xRefEntries = readXRefStream(byteArray, j);
                }

                if(xRefEntries == null) {
                    lastError = "Failed to read cross reference table";
                    return null;
                }
                pdfDocument.xrefTable.addAll(xRefEntries);
                //break;
            }


            /*************************************
             * Read PDF file Body. See page 40.
             *************************************/

            /*
             * SEE Figure 5 –  Structure of a PDF document, page 72.
             * SEE also Table 28 –  Entries in the catalog dictionary, page 73.
             */
            ObjectId catalogId = PDFDict.getIndirectRefDictEntry(trailer, "Root");
            if(catalogId == null || catalogId.equals(PDFDict.invalidObjectId)) {
                lastError = "Cannot find document catalog";
                return null;
            }

            XRefEntry catalogRoot = getXRefEntry(pdfDocument.xrefTable, catalogId.getObjectNumber(),
                    catalogId.getGenerationNumber());
            if(catalogRoot == null) {
                lastError = "Failed to find document catalog";
                return null;
            }

            // get the catalog
            __DEBUG__("parse", "Reading document catalog");
            byteArray.setOffset(catalogRoot.getByteOffset());
            PDFObject catalogObj = getNextObject();
            if(catalogObj == null || catalogObj.getType() != PDFObject.OBJECT_TYPE.OBJ_HEADER_OBJECT) {
                lastError = "Corrupt document catalog";
                return null;
            }
            catalogObj = getNextObject();
            if(catalogObj == null || catalogObj.getType() != PDFObject.OBJECT_TYPE.DICTIONARY_OBJECT) {
                lastError = "Corrupt document catalog";
                return null;
            }
            HashMap<String, PDFObject> cat = (HashMap<String, PDFObject>)catalogObj.getValue();
            pdfDocument.catalog = cat;

            //make sure it is a catalog
            String str = PDFDict.getStringDictEntry(cat, "Type");
            if(!str.equals("Catalog")) {
                lastError = "Corrupt document catalog";
                return null;
            }
            // check the second version, if present
            String ver2 = PDFDict.getStringDictEntry(cat, "Version");
            if(!ver2.isEmpty() && Double.parseDouble(ver2) > Double.parseDouble(pdfVer)) {
                pdfDocument.version = ver2;
            }

            /*
             * Get the Pages dictionary (through an indirect reference).
             */
            ObjectId pagesId = PDFDict.getIndirectRefDictEntry(cat, "Pages");
            if(pagesId == null) {
                lastError = "Cannot find document pages dictionary";
                return null;
            }
            pdfDocument.pagesRootNode = pagesId;

            //channel.close();
            return pdfDocument;
        } catch (IOException e) {
            e.printStackTrace();
            lastError = e.getLocalizedMessage();
            return null;
        }
    }


    /*
     * FROM THE PDF STANDARD:
     * ======================
     * The table comprises one or more cross-reference sections.
     * Each cross-reference section shall begin with a line containing the keyword xref.
     * Following this line shall be one  or  more cross-reference  subsections.
     * The subsection shall begin with a line containing two numbers separated by a SPACE (20h),
     * denoting the object number of the first object in this subsection and the number of
     * entries in the subsection.
     * Following  this  line  are  the  cross-reference  entries  themselves,  one  per  line.
     * Each  entry  shall  be  exactly  20 bytes long, including the end-of-line marker.
     *
     * SEE FORMAT OF ENTRY ON PAGE 41 (nnnnnnnnnn ggggg n/f eol).

     * For  a  file  that  has  never  been incrementally updated, the cross-reference section
     * shall contain only one subsection, whose object numbering begins at 0.
     */
    private ArrayList<XRefEntry> readXRefSection(PDFByteArray byteArray, long xrefTableOffset,
                                                 int lastObjectNumber) {
        byte[] bytes = byteArray.data;
        if(xrefTableOffset <= 0 || xrefTableOffset >= bytes.length) {
            byteArray.setOffset(-1);
            return null;
        }
        int savedOffset = byteArray.offset;
        byteArray.setOffset((int)xrefTableOffset);

        PDFToken token = null;
        try {
            token = getNextToken(byteArray);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        if (token == null || !token.value.equals("xref")) {
            /*
             * TODO: handle the case where the Cross-Reference is a stream, not a table.
             *       See 7.5.8 Cross-Reference Streams, on page 49 of PDF 1.7 Std.
             */
            ArrayList<XRefEntry> xref = readXRefStream(byteArray, savedOffset);

            byteArray.setOffset(savedOffset);
            return xref;
        }

        ArrayList<XRefEntry> table = new ArrayList<>();
        int objectNumber = 0;

        try {
            while (objectNumber < lastObjectNumber-1) {
                token = getNextToken(byteArray);
                if (token == null || token.type == TokenType.TOKEN_EOF) {
                    byteArray.setOffset(savedOffset);
                    return null;
                }
                objectNumber = Integer.parseInt(token.value);
                token = getNextToken(byteArray);
                if (token == null || token.type == TokenType.TOKEN_EOF) {
                    byteArray.setOffset(savedOffset);
                    return null;
                }
                int objectCount = Integer.parseInt(token.value);
                __DEBUG__("readXRefSection", "Reading XRef table section (" + objectCount + " objects)");
                skipWhitespace(byteArray);
                int offset = byteArray.offset;

                for (int i = 0; i < objectCount; i++) {
                    XRefEntry xRefEntry;
                    // get the byte offset
                    int byteOffset = (int) getHextDigitValue(bytes[offset++]);
                    for (int j = 0; j < 9; j++) {
                        byteOffset *= 10;
                        byteOffset += (int) getHextDigitValue(bytes[offset++]);
                    }
                    // skip padding
                    offset++;
                    // get the generation number
                    int generationNumber = (int) getHextDigitValue(bytes[offset++]);
                    for (int j = 0; j < 4; j++) {
                        generationNumber *= 10;
                        generationNumber += (int) getHextDigitValue(bytes[offset++]);
                    }
                    // skip padding
                    offset++;
                    // get status: in use (n) or free (f)
                    byte b = bytes[offset++];
                    if (b == 'n')
                        xRefEntry = new XRefEntry(objectNumber, byteOffset, generationNumber, XRefEntry.EntryType.USED_ENTRY);
                    else
                        xRefEntry = new XRefEntry(objectNumber, byteOffset, generationNumber, XRefEntry.EntryType.FREE_ENTRY);
                    System.out.println(xRefEntry.toString());
                    objectNumber++;
                    // skip the eol
                    offset += 2;
                    // add entry to table
                    table.add(xRefEntry);
                }
                byteArray.setOffset(offset);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        byteArray.offset = savedOffset;
        return table;
    }

    private int getIntValFromStream(byte[] bytes, int offset, int count) {
        int val = 0;
        for(int j = 0; j < count; j++) {
            int b = (bytes[offset++] & 0xff);
            val <<= 8;
            val |= b;
        }
        return val;
    }

    private ArrayList<XRefEntry> readXRefStream(PDFByteArray byteArray, int xrefTableOffset) {
        PDFObjectStream xref = getObjectStreamAtOffest(byteArray, xrefTableOffset, true, true);
        if(xref == null) return null;
        HashMap<String, PDFObject> dictionary = xref.dictionary;
        byte[] bytes = xref.stream.data;
        int i, offset = 0;
        String type = PDFDict.getStringDictEntry(dictionary, "Type");

        if(dictionary == null || !type.equals("XRef")) {
            return null;
        }
        prev = dictionary.get("Prev");

        ArrayList<XRefEntry> table = new ArrayList<>();
        int lastObjectNumber = PDFDict.getIntDictEntry(dictionary, "Size");

        __DEBUG__("readXRefStream", "Reading XRef table section (" + lastObjectNumber + " objects)");

        // get subsection indices
        ArrayList<PDFObject> index = PDFDict.getArrayDictEntry(dictionary, "Index");
        // if empty, put the default value of [0 Size] in it
        if(index.size() == 0) {
            index.add(new PDFObject(0, PDFObject.OBJECT_TYPE.INTEGER_OBJECT));
            index.add(new PDFObject(lastObjectNumber, PDFObject.OBJECT_TYPE.INTEGER_OBJECT));
        }

        /*
         * SEE Table 17 –  Additional entries specific to a cross-reference stream dictionary,
         *     on page 50 of PDF 1.7 Std.
         */
        // get entry width
        ArrayList<PDFObject> W = PDFDict.getArrayDictEntry(dictionary, "W");
        if(W.size() < 3) {
            __DEBUG__("readXRefStream", "W size = " + W.size());
            return null;
        }
        int W1 = (int)W.get(0).getValue();
        int W2 = (int)W.get(1).getValue();
        int W3 = (int)W.get(2).getValue();
        __DEBUG__("readXRefStream", "W1 = " + W1);
        __DEBUG__("readXRefStream", "W2 = " + W2);
        __DEBUG__("readXRefStream", "W3 = " + W3);


        // now get the entries
        for(i = 0; i < index.size(); i += 2) {
            int objectNumber = (int)index.get(i  ).getValue();
            int objectCount  = (int)index.get(i+1).getValue();
            //System.out.println(objectCount);

            while(objectCount-- > 0) {
                //skipWhitespace(byteArray);
                int byteOffset = 0, generationNumber = 0;
                int typeField = 1;

                /*
                for(int j = 0; j < W1+W2+W3; j++) {
                    System.out.print("'" + bytes[offset+j] + "'");
                }
                */

                if (W1 > 0) {
                    typeField = getIntValFromStream(bytes, offset, W1);
                    offset += W1;
                }
                if (W2 > 0) {
                    byteOffset = getIntValFromStream(bytes, offset, W2);
                    offset += W2;
                }
                if (W3 > 0) {
                    generationNumber = getIntValFromStream(bytes, offset, W3);
                    offset += W3;
                }
                /*
                 * create entry. SEE Table 18 – Entries in a cross-reference stream, page 51.
                 */
                XRefEntry xRefEntry = null;
                if (typeField == 0)  // free entry
                    xRefEntry = new XRefEntry(objectNumber, byteOffset, generationNumber, XRefEntry.EntryType.FREE_ENTRY);
                else if (typeField == 1) // in use entry
                    xRefEntry = new XRefEntry(objectNumber, byteOffset, generationNumber, XRefEntry.EntryType.USED_ENTRY);
                else if (typeField == 2) { // compressed entry
                    // make a temporary entry for now
                    xRefEntry = new XRefEntry(objectNumber, byteOffset, generationNumber, XRefEntry.EntryType.COMPRESSED_ENTRY);
                }
                if(xRefEntry != null) {
                    System.out.println(xRefEntry.toString());
                    // add entry to table
                    table.add(xRefEntry);
                }
                else {
                    __DEBUG__("readXRefStream", "Skipping object with type: " +
                            typeField + " off: " + byteOffset +
                            " objectNum: " + objectNumber + " gen: " + generationNumber);
                }
                objectNumber++;
            }
        }


        // now go over the entries again, fixing Type 2 entries
        Iterator<XRefEntry> iterator = table.iterator();
        XRefEntry objStr = null;
        while(iterator.hasNext()) {
            XRefEntry entry = iterator.next();
            if(entry.getEntryType() != XRefEntry.EntryType.COMPRESSED_ENTRY) continue;
            __DEBUG__("readXRefStream", "Fixing object: " + entry.toString());
            // field 2 (byteOffset) points to the object stream number,
            //         generation number is 0 by default (PDF Std says so)
            // field 3 (generationNumber) points to the index in this object stream
            /*
             * find the object stream we belong to. save some time by checking if it is
             * the last object stream we used.
             */
            if(objStr == null || objStr.getObjectNumber() != entry.getByteOffset()) {
                for(i = 0; i < table.size(); i++) {
                    if(table.get(i).getObjectNumber() == entry.getByteOffset() &&
                            table.get(i).getGenerationNumber() == 0) {
                        objStr = table.get(i);
                        break;
                    }
                }
            }
            if(objStr == null) {
                __DEBUG__("readXRefStream", "Failed to find object stream. Skipping object");
                continue;
            }

            PDFObjectStream objStream = getObjectStreamAtOffest(byteArray, objStr.getByteOffset(),
                                        true, true);
            if(objStream == null) {
                if(pedantic) return null;
                else {
                    __DEBUG__("readXRefStream", "Failed to read object stream (offset: " + objStr.getByteOffset() + ")");
                    continue;
                }
            }
            PDFObjectStream obj = getObjectFromObjStream(objStream, entry.getGenerationNumber());
            if(obj == null) {
                if(pedantic) return null;
                else {
                    __DEBUG__("readXRefStream", "Failed to read object from stream (offset: " + entry.getByteOffset() + ")");
                    continue;
                }
            }
            entry.setCompressedObject(obj);
            entry.setByteOffset(0);
            entry.setGenerationNumber(0);
        }

        return table;
    }


    public XRefEntry getXRefEntry(ArrayList<XRefEntry> xrefTable,
                                  int objectNumber, int generationNumber) {
        for(XRefEntry entry: xrefTable) {
            if(entry.getObjectNumber() == objectNumber &&
                    entry.getGenerationNumber() == generationNumber)
                return entry;
        }
        return null;
    }


    public static PDFObject getLiteralStringObject(PDFByteArray byteArray) {
        /*
         * PDF standard says:
         * ==================
         * The following are valid literal strings:
         * (  This is a string )
         * (  Strings may contain newlines
         * and such. )
         * (  Strings may contain balanced parentheses ( ) and
         * special characters ( * ! &   } ^ % and so on ). )
         * (  The following is an empty string. )
         * ()
         * (  It has zero ( 0 ) length. )
         *
         * SPLITTING STRINGS ON MULTIPLE LINES
         * ===================================
         * A conforming writer may split a literal string across multiple lines. The REVERSE
         * SOLIDUS (5Ch) (backslash character)  at  the  end  of  a  line  shall  be  used  to
         * indicate  that  the  string  continues  on  the  following  line.  A conforming  reader
         * shall  disregard  the  REVERSE  SOLIDUS and  the  end-of-line  marker  following  it
         * when reading the string; the resulting string value shall be identical to that which would
         * be read if the string were not split.
         *
         * An end-of-line marker appearing within a literal string without a preceding REVERSE
         * SOLIDUS shall be treated as a byte value of (0Ah), irrespective of whether the end-of-line
         * marker was a CARRIAGE RETURN (0Dh), a LINE FEED (0Ah), or both.
         */
        int offset = byteArray.offset;
        if(offset < 0 || offset >= byteArray.getDataLength()) {
            byteArray.offset = -1;
            return null;
        }
        try {
            if(byteArray.getByteAt(offset) != '(') {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        // keep count of opening and closing braces
        int ob = 1;
        int cb = 0;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            while (++offset < byteArray.getDataLength()) {
                if (byteArray.getByteAt(offset) == '(') ob++;
                else if (byteArray.getByteAt(offset) == ')') cb++;
                if (ob == cb) break;
                // check for escaped chars
                if (byteArray.getByteAt(offset) == '\\') {
                    byte b = byteArray.getByteAt(offset + 1);
                    if (b == 'n') {
                        out.write('\n');
                        offset++;
                    } else if (b == 'r') {
                        out.write('\r');
                        offset++;
                    } else if (b == 't') {
                        out.write('\t');
                        offset++;
                    } else if (b == 'b') {
                        out.write('\b');
                        offset++;
                    } else if (b == 'f') {
                        out.write('\f');
                        offset++;
                    } else if (b == '(') {
                        out.write('(');
                        offset++;
                    } else if (b == ')') {
                        out.write(')');
                        offset++;
                    } else if (b == '\\') {
                        out.write('\\');
                        offset++;
                    } else if (b >= '0' && b <= '7') {
                        int n = b - '0';
                        b = byteArray.getByteAt(offset+2);
                        offset++;
                        if (b >= '0' && b <= '7') {
                            n *= 8;
                            n += (b - '0');
                            b = byteArray.getByteAt(offset+2);
                            offset++;
                            if (b >= '0' && b <= '7') {
                                n *= 8;
                                n += (b - '0');
                                offset++;
                            }
                        }
                        out.write(n);
                    } else out.write(byteArray.getByteAt(offset));
                } else out.write(byteArray.getByteAt(offset));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        byteArray.offset = ++offset;
        String str = out.toString();
        PDFObject object = new PDFObject(str, PDFObject.OBJECT_TYPE.STRING_OBJECT);
        object.setBytes(out.toByteArray());
        return object;
    }

    public static byte getHextDigitValue(byte h) {
        if(h >= '0' && h <= '9') return (byte)(h-'0');
        if(h == 'a' || h == 'A') return 10;
        if(h == 'b' || h == 'B') return 11;
        if(h == 'c' || h == 'C') return 12;
        if(h == 'd' || h == 'D') return 13;
        if(h == 'e' || h == 'E') return 14;
        if(h == 'f' || h == 'F') return 15;
        PDFReader.__DEBUG__("getHextDigitValue", "Invalid Hex digit: '" + h + "'");
        return 0;
    }

    public static PDFObject getHexStringObject(PDFByteArray byteArray) {
        /*
         * PDF standard says:
         * ==================
         * Each pair of hexadecimal digits defines one byte of the string. White-space characters
         * (such as SPACE (20h), HORIZONTAL TAB (09h), CARRIAGE RETURN (0Dh), LINEFEED (0Ah), and
         * FORMFEED (0Ch)) shall be ignored.
         *
         * If the final digit of a hexadecimal string is missing—that is, if there is an odd number of
         * digits—the final digit shall be assumed to be 0.
         * EXAMPLE 2   <901FA3>is a 3-byte string consisting of the characters whose hexadecimal codes
         *             are 90, 1F, and A3, but
         *             <901FA> is a 3-byte string containing the characters whose hexadecimal codes
         *             are 90, 1F, and A0.
         */
        int offset = byteArray.offset;
        if(offset < 0 || offset >= byteArray.getDataLength()) {
            byteArray.offset = -1;
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            if (byteArray.getByteAt(offset) != '<') {
                return null;
            }
            int len = byteArray.getDataLength();
            while (++offset < len) {
                if (byteArray.getByteAt(offset) == '>') break;
                int i = getHextDigitValue(byteArray.getByteAt(offset)) * 16;
                if (byteArray.getByteAt(offset + 1) != '>') {
                    i += getHextDigitValue(byteArray.getByteAt(offset + 1));
                    offset++;
                }
                out.write(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        byteArray.offset = ++offset;
        String str = out.toString();
        PDFObject object = new PDFObject(str, PDFObject.OBJECT_TYPE.STRING_OBJECT);
        object.setBytes(out.toByteArray());
        return object;
    }

    public static String getNameObject(PDFByteArray byteArray) {
        /*
         * PDF standard says:
         * ==================
         * When writing a name in a PDF file, a SOLIDUS (2Fh) (/) shall be used to introduce a name.
         * The SOLIDUS is not part of the name but is a prefix indicating that what follows is a
         * sequence of characters representing the name in the PDF file and shall follow these rules:
         * a)    A NUMBER SIGN (23h) (#) in a name shall be written by using its 2-digit hexadecimal
         * code (23), preceded by the NUMBER SIGN.
         * b)    Any character in a name that is a regular character (other than NUMBER SIGN) shall be
         * written as itself or by using its 2-digit hexadecimal code, preceded by the NUMBER SIGN.
         * c)    Any character that is not a regular character shall be written using its 2-digit
         * hexadecimal code, preceded by the NUMBER SIGN only.
         *
         * The token SOLIDUS (a slash followed by no regular characters) introduces a unique valid name
         * defined by the empty sequence of characters.
         *
         * Table 4 –  Examples of literal names (Page 17 in the PDF 1.7 standard)
         *
         * Syntax for Literal name              Resulting Name
         * =======================              ==============
         * /Name1                               Name1
         * /ASomewhatLongerName                 ASomewhatLongerName
         * /A;Name_With-Various***Characters?   A;Name_With-Various***Characters?
         * /1.2                                 1.2
         * /$$                                  $$
         * /@pattern                            @pattern
         * /.notdef                             .notdef
         * /lime#20Green                        Lime Green
         * /paired#28#29parentheses             paired()parentheses
         * /The_Key_of_F#23_Minor               The_Key_of_F#_Minor
         * /A#42                                AB
         */
        int offset = byteArray.offset;
        if(offset < 0 || offset >= byteArray.getDataLength()) {
            byteArray.offset = -1;
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            if (byteArray.getByteAt(offset) != '/') {
                return null;
            }
            while (++offset < byteArray.getDataLength()) {
                byte b = byteArray.getByteAt(offset);
                if (b == '#') {
                    int i = (getHextDigitValue(byteArray.getByteAt(offset + 1)) * 16)
                            + getHextDigitValue(byteArray.getByteAt(offset + 2));
                    out.write(i);
                    offset += 2;
                    continue;
                }
                if (isWhitespaceChar(b)) break;
                if (isDelimiterChar(b)) break;
                out.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        byteArray.setOffset(offset);
        String name = out.toString();
        return name;
    }

    public ArrayList<PDFObject> getArrayObject(PDFByteArray byteArray) {
        /*
         * PDF standard says:
         * ==================
         * An array shall be written as a sequence of objects enclosed in SQUARE BRACKETS (using
         * LEFT SQUARE BRACKET (5Bh) and RIGHT SQUARE BRACKET (5Dh)).
         * EXAMPLE     [ 549  3.14  false  (Ralph)   /SomeName ]
         */
        int offset = byteArray.offset;
        if(offset < 0 || offset >= byteArray.getDataLength()) {
            byteArray.offset = -1;
            return null;
        }
        /* check we indeed have an array */
        PDFToken entry = null;
        ArrayList<PDFObject> arrayList = new ArrayList<>();
        try {
            entry = getNextToken(byteArray);
            if (entry.type != TokenType.TOKEN_LT_BRACKET) {
                // not an array. reset the offset and bail out
                byteArray.offset = offset;
                return null;
            }
            /* read the array entries */
            while (byteArray.offset < byteArray.getDataLength()) {
                // end of array
                if (byteArray.getByteAt(byteArray.offset) == ']') {
                    byteArray.offset++;
                    break;
                }
                // get the value
                PDFObject value = getNextObject();
                if (value != null && value.getValue() != null) {
                    arrayList.add(value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return arrayList;
    }


    public HashMap<String, PDFObject> getDictObject() {
        /*
         * PDF standard says:
         * ==================
         * A dictionary object is an associative table containing pairs of objects, known as the
         * dictionary’s entries. The first element  of  each  entry  is  the key and  the  second
         * element  is  the value.  The  key  shall  be  a  name  (unlike dictionary keys in PostScript,
         * which may be objects of any type). The value may be any kind of object, including another
         * dictionary. A dictionary entry whose value is null (see 7.3.9, "Null Object") shall be
         * treated the same as if the entry does not exist. (This differs from PostScript, where null
         * behaves like any other object as the value of  a  dictionary  entry.)
         *
         * Multiple entries in the same dictionary shall not have the same key.
         *
         * A  dictionary  shall  be  written  as  a  sequence  of  key-value  pairs  enclosed  in
         * double  angle  brackets  (<< ... >>) (using LESS-THAN SIGNs (3Ch) and GREATER-THAN SIGNs (3Eh)).
         * EXAMPLE
         * <<  /Type  /Example
         *     /Subtype  /DictionaryExample
         *     /Version  0.01
         *     /IntegerItem  12
         *     /StringItem  (a string)
         *     /Subdictionary  <<  /Item1  0.4
         *         /Item2  true
         *         /LastItem  (not!)
         *         /VeryLastItem  (OK)
         *     >>
         * >>
         */
        PDFByteArray byteArray = this.byteArray;
        int offset = byteArray.offset;
        if(offset < 0 || offset >= byteArray.getDataLength()) {
            byteArray.offset = -1;
            return null;
        }
        /* check we indeed have a dictionary */
        PDFToken key = null;
        HashMap<String, PDFObject> dictionary = new HashMap<>();
        try {
            key = getNextToken(byteArray);
            if (key.type != TokenType.TOKEN_DBL_LESS_THAN) {
                // not a dictionary. reset the offset and bail out
                byteArray.offset = offset;
                return null;
            }
            /* read the dictionary entries */
            int len = byteArray.getDataLength();
            while (byteArray.offset < len) {
                key = getNextToken(byteArray);
                // end of dictionary
                if (key.type == TokenType.TOKEN_DBL_GREATER_THAN) {
                    break;
                }
                // ensure we have a key that is a string name
                if (key.type != TokenType.TOKEN_NAME_OBJECT) {
                    // nope. try to skip to end of dictionary
                    while (key.type != TokenType.TOKEN_EOF && key.type != TokenType.TOKEN_DBL_GREATER_THAN) {
                        key = getNextToken(byteArray);
                    }
                    return null;
                }

                // get the value
                PDFObject value = getNextObject();
                if (value != null && value.getValue() != null) {
                    dictionary.put(key.value, value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary;
    }

    public PDFObjectStream getObjectStreamById(ObjectId objectId, PDFDocument pdfDocument) {
        PDFByteArray byteArray = new PDFByteArray(0, pdfDocument.sourceFile.data);
        PDFByteArray savedByteArray = this.byteArray;
        this.byteArray = byteArray;
        PDFObjectStream objectStream = getObjectStreamById(objectId.getObjectNumber(),
                objectId.getGenerationNumber(), byteArray, pdfDocument);
        this.byteArray = savedByteArray;
        return objectStream;
    }

    public PDFObjectStream getObjectStreamById(int objectNumber, int generationNumber,
                                                      PDFByteArray byteArray, PDFDocument pdfDocument) {
        XRefEntry obj = getXRefEntry(pdfDocument.xrefTable, objectNumber, generationNumber);
        if(obj == null) return null;
        /*
         * handle the special case of type 2 (compressed) objects.
         */
        if(obj.getEntryType() == XRefEntry.EntryType.COMPRESSED_ENTRY) {
            return obj.getCompressedObject();
        }

        PDFObjectStream obj2 = getObjectStreamAtOffest(byteArray,
                                    obj.getByteOffset(), false, true);
        if(obj2 != null) obj2.pdfDocument = pdfDocument;
        return obj2;
    }

    // our object stream cache. we need this because most object streams will be compressed,
    // often with multiple filters. we don't want to reapply the filters every time we need
    // an object.

    private static ArrayList<PDFObjectStream> objStreamCache = new ArrayList<>();

    // the checkCache flag is needed because when we are reading compressed XRef object entries,
    // we don't have Object offsets (they are read from within another object stream.
    // because the cache depends on offsets to find the requested object, if the flag is false
    // we will not check the cache. every call to this function should set the flag to true,
    // except for when we are reading a compressed (Type 2) XRef object.

    public PDFObjectStream getObjectStreamAtOffest(PDFByteArray byteArray, int offset,
                                                          boolean strict, boolean checkCache) {
        if(offset < 0 || offset >= byteArray.getDataLength()) {
            return null;
        }

        // check the cache first
        if(checkCache) {
            for (PDFObjectStream objectStream : objStreamCache) {
                if (objectStream.offset == offset) {
                    //objectStream.offset = 0;
                    return objectStream;
                }
            }
        }

        // object stream not in the cache. we have to read it
        int savedOffset = byteArray.offset;
        //byteArray.offset = offset;
        byteArray.setOffset(offset);

        // check we are inside an object def
        PDFObject object = getNextObject();
        if(object == null || object.getType() != PDFObject.OBJECT_TYPE.OBJ_HEADER_OBJECT) {
            //byteArray.offset = savedOffset;
            byteArray.setOffset(savedOffset);
            return null;
        }

        // check that there is a stream dictionary
        int i = byteArray.offset;
        PDFToken token = null;
        byte[] bytes;
        try {
            token = getNextToken(byteArray);
            if (token == null || token.type != TokenType.TOKEN_DBL_LESS_THAN) {
                //byteArray.offset = savedOffset;
                byteArray.setOffset(savedOffset);
                return null;
            }

            // get the dictionary
            byteArray.offset = i;
            HashMap<String, PDFObject> dictionary = getDictObject();
            if (dictionary == null) {
                //byteArray.offset = savedOffset;
                byteArray.setOffset(savedOffset);
                return null;
            }

            // check again it is a stream object
            String type = PDFDict.getStringDictEntry(dictionary, "Type");
            if (!type.equals("ObjStm") && !type.equals("XRef") && strict) {
                //byteArray.offset = savedOffset;
                byteArray.setOffset(savedOffset);
                return null;
            }

            // the next token should be the keyword 'stream'
            token = getNextToken(byteArray);
            if (token == null || !token.value.equals("stream")) {
                if(strict) {
                    //byteArray.offset = savedOffset;
                    byteArray.setOffset(savedOffset);
                    return null;
                } else {
                    PDFObjectStream objectStream = new PDFObjectStream();
                    objectStream.stream = null;
                    objectStream.dictionary = dictionary;
                    objectStream.offset = offset;
                    objStreamCache.add(objectStream);
                    //byteArray.offset = savedOffset;
                    byteArray.setOffset(savedOffset);
                    return objectStream;
                }
            }

            // skip the newline after 'stream' keyword
            if (byteArray.getByteAt(byteArray.offset) == '\r') {
                byteArray.getOffsetPostInc();
            }
            if (byteArray.getByteAt(byteArray.offset) == '\n') {
                byteArray.getOffsetPostInc();
            }

            // if the stream is compressed, uncompress it
            PDFObject filters = dictionary.get("Filter");
            int length = PDFDict.getIntDictEntry(dictionary, "Length");
            if (filters != null) {
                PDFObject params = dictionary.get("DecodeParms");
                bytes = PDFDecodeFilter.decode(byteArray, byteArray.offset, length, filters, params);
                if (bytes == null) return null;
            } else {
                bytes = byteArray.copyOfRange(byteArray.offset, byteArray.offset + length);
                if (bytes == null) return null;
            }
            byteArray.setOffset(byteArray.offset + length);

            // the next token should be the keyword 'endstream'
            token = getNextToken(byteArray);
            if (token == null || !token.value.equals("endstream")) {
                byteArray.setOffset(savedOffset);
                return null;
            }

            // the next token should be the keyword 'endobj'
            token = getNextToken(byteArray);
            if (token == null || !token.value.equals("endobj")) {
                byteArray.setOffset(savedOffset);
                return null;
            }

            // we got it now
            PDFObjectStream objectStream = new PDFObjectStream();
            PDFByteArray newByteArray = new PDFByteArray(0, bytes);
            objectStream.stream = newByteArray;
            objectStream.offset = offset;
            objectStream.dictionary = dictionary;
            objStreamCache.add(objectStream);
            byteArray.setOffset(savedOffset);
            return objectStream;
        } catch (IOException e) {
            e.printStackTrace();
            byteArray.setOffset(savedOffset);
            return null;
        }
    }

    public PDFObjectStream getObjectFromObjStream(PDFObjectStream objectStream, int objectNumber) {
        if(objectStream == null) return null;
        HashMap<String, PDFObject> streamDict = objectStream.dictionary;
        int objectCount = PDFDict.getIntDictEntry(streamDict, "N");
        if(objectCount == -1) return null;
        int firstOffest = PDFDict.getIntDictEntry(streamDict, "First");
        if(firstOffest == -1) return null;
        // get the object stream
        PDFByteArray byteArray = objectStream.stream;
        int savedOffset = byteArray.offset;
        byteArray.offset = 0;
        // calculate the requested object's byte offset
        int objectOffset = firstOffest;
        int j = objectNumber;
        try {
            PDFToken token = null;
            // skip over the indices until we land at the requested one
            while (j-- > 0) {
                // the stream contains a pair of numbers for each object. the first number is the
                // object number, and the second number is the offset, relative to the first offset.
                getNextToken(byteArray);
                getNextToken(byteArray);
            }

            token = getNextToken(byteArray);
            //System.out.println(token.value);
            if (token.type == TokenType.TOKEN_EOF) return null;
            int i = Integer.parseInt(token.value);
            if (i < 0) return null;
            token = getNextToken(byteArray);
            i = Integer.parseInt(token.value);
            if (i < 0) return null;
            objectOffset += i;
            int savedOffset2 = byteArray.offset;
            // now get the object
            byteArray.offset = objectOffset;
            // temporarily switch the byteArray as the functions we will call depend on the
            // class-wide byteArray.
            PDFByteArray savedByteArray = this.byteArray;
            this.byteArray = byteArray;
            PDFObjectStream obj2 = getObjectStreamAtOffest(byteArray, objectOffset, false, false);
            if(obj2 != null) {
                byteArray.offset = savedOffset;
                this.byteArray = savedByteArray;
                return obj2;
            } else {
                // maybe it's only a dictionary object?
                byteArray.offset = objectOffset;
                PDFObject object = getNextObject();
                if(object != null && object.getType() == PDFObject.OBJECT_TYPE.DICTIONARY_OBJECT) {
                    obj2 = new PDFObjectStream();
                    obj2.dictionary = object.getDictionaryValue();
                    byteArray.offset = savedOffset;
                    this.byteArray = savedByteArray;
                    return obj2;
                }
                // or maybe it's an array (or any other type of) object?
                if(object != null) {
                    obj2 = new PDFObjectStream();
                    // last object in the stream
                    if(objectNumber == objectCount-1) {
                        byte[] bytes = Arrays.copyOfRange(byteArray.data,
                                objectOffset, byteArray.data.length);
                        obj2.stream = new PDFByteArray(0, bytes);
                    } else {
                        // get the next object's offset
                        byteArray.offset = savedOffset2;
                        token = getNextToken(byteArray);
                        if (token.type == TokenType.TOKEN_EOF) return null;
                        i = Integer.parseInt(token.value);
                        if (i < 0) return null;
                        token = getNextToken(byteArray);
                        i = Integer.parseInt(token.value);
                        if (i < 0) return null;
                        i += firstOffest;
                        byte[] bytes = Arrays.copyOfRange(byteArray.data, objectOffset, i);
                        obj2.stream = new PDFByteArray(0, bytes);
                    }
                    byteArray.offset = savedOffset;
                    this.byteArray = savedByteArray;
                    return obj2;
                }
            }
            this.byteArray = savedByteArray;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PDFObject nullObject = new PDFObject(null, PDFObject.OBJECT_TYPE.NULL_OBJECT);

    public PDFObject getNextObject() {
        PDFByteArray byteArray = this.byteArray;
        if(byteArray.offset < 0 || byteArray.offset >= byteArray.getDataLength()) {
            byteArray.setOffset(-1);
            return null;
        }
        // get the value
        PDFToken value = null;
        int offset = -1;
        try {
            skipWhitespace(byteArray);
            offset = byteArray.offset;
            value = getNextToken(byteArray);
            if (value.type == TokenType.TOKEN_DBL_LESS_THAN) {
                // value is a dictionary
                byteArray.setOffset(offset);
                HashMap<String, PDFObject> val = getDictObject();
                if (val != null) {
                    return new PDFObject(val, PDFObject.OBJECT_TYPE.DICTIONARY_OBJECT);
                }
            } else if (value.type == TokenType.TOKEN_NAME_OBJECT) {
                if (value.value != null) {
                    return new PDFObject(value.value, PDFObject.OBJECT_TYPE.NAME_OBJECT);
                }
            } else if (value.type == TokenType.TOKEN_LESS_THAN) {
                byteArray.setOffset(offset);
                /*
                String val = getHexStringObject(byteArray);
                if (val != null) {
                    return new PDFObject(val, PDFObject.OBJECT_TYPE.STRING_OBJECT);
                }
                */
                return getHexStringObject(byteArray);
            } else if (value.type == TokenType.TOKEN_LT_PAREN) {
                byteArray.setOffset(offset);
                /*
                String val = getLiteralStringObject(byteArray);
                if (val != null) {
                    return new PDFObject(val, PDFObject.OBJECT_TYPE.STRING_OBJECT);
                }
                */
                return getLiteralStringObject(byteArray);
            } else if (value.type == TokenType.TOKEN_LT_BRACKET) {
                byteArray.setOffset(offset);
                ArrayList<PDFObject> val = getArrayObject(byteArray);
                if (val != null) {
                    return new PDFObject(val, PDFObject.OBJECT_TYPE.ARRAY_OBJECT);
                }
            } else if (value.value != null) {
                if (value.value.equals("null")) {
                    return nullObject;
                } else if (value.value.equals("true")) {
                    return new PDFObject(true, PDFObject.OBJECT_TYPE.BOOLEAN_OBJECT);
                } else if (value.value.equals("false")) {
                    return new PDFObject(false, PDFObject.OBJECT_TYPE.BOOLEAN_OBJECT);
                } else if (PDFObject.isInteger(value.value)) {
                    // check for indirect object references
                    offset = byteArray.offset;
                    PDFObject object2 = getNextObject();
                    if (object2 != null && object2.getType() == PDFObject.OBJECT_TYPE.INTEGER_OBJECT) {
                        PDFReader.skipWhitespace(byteArray);
                        if (byteArray.getByteAt(byteArray.offset) == 'R') {
                            byte b = byteArray.getByteAt(byteArray.offset + 1);
                            if (PDFReader.isDelimiterChar(b) || PDFReader.isWhitespaceChar(b)) {
                                byteArray.getOffsetPostInc();
                                // make a simple reference, it will look like 'X Y' without the 'R'.
                                ObjectId val = new ObjectId(Integer.parseInt(value.value), (int) object2.getValue());
                                return new PDFObject(val, PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT);
                            }
                        } else {
                            PDFToken token = getNextToken(byteArray);
                            if (token != null && token.value.equals("obj")) {
                                // make a simple reference, it will look like 'X Y' without the 'obj'.
                                ObjectId val = new ObjectId(Integer.parseInt(value.value), (int) object2.getValue());
                                return new PDFObject(val, PDFObject.OBJECT_TYPE.OBJ_HEADER_OBJECT);
                            }
                        }
                    }
                    // nope. it's just an integer
                    byteArray.setOffset(offset);
                    return new PDFObject(Integer.parseInt(value.value), PDFObject.OBJECT_TYPE.INTEGER_OBJECT);
                } else if (PDFObject.isReal(value.value)) {
                    return new PDFObject(Double.parseDouble(value.value), PDFObject.OBJECT_TYPE.REAL_OBJECT);
                } else if (value.type == TokenType.TOKEN_UNKOWN_WORD) {
                    // for everything else, store value as a string
                    return new PDFObject(value.value, PDFObject.OBJECT_TYPE.STRING_OBJECT);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // restore the offset as where it was, i.e. unroll the change we did
        byteArray.setOffset(offset);
        return null;
    }

    public static PDFReader getReaderInstance(PDFByteArray byteArray) {
        PDFReader reader = new PDFReader();
        reader.byteArray = byteArray;
        reader.byteArray.offset = 0;
        return reader;
    }

    public static void __DEBUG__(String funcName, String msg) {
        System.out.println(funcName + "(): " + msg);
    }
}
