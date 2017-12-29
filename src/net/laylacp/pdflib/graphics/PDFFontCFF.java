package net.laylacp.pdflib.graphics;

import net.laylacp.pdflib.core.types.ObjectStack;
import net.laylacp.pdflib.reader.PDFByteArray;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

enum OperandType {
    Number, Boolean, SID, Array, Delta
};

class Operand {
    public OperandType type;
    public Object value;

    public Operand(OperandType type, Object value) {
        this.type = type;
        this.value = value;
    }
}

class DictOperator {
    public String name;
    public OperandType type;
    public Object defaultVal;

    public DictOperator(String name, OperandType type, Object defaultVal) {
        this.name = name;
        this.type = type;
        this.defaultVal = defaultVal;
    }
}

class Hint {
    public int x, dx;
    public boolean isVertical;

    public Hint(int x, int dx, boolean isVertical) {
        this.x = x;
        this.dx = dx;
        this.isVertical = isVertical;
    }
}


/*
 * Structure of CFF file (SEE Table 1 CFF Data Layout, page 8 of The Compact Font Format Spec).
 *
 * - Header
 * - Name INDEX
 * - Top DICT INDEX
 * - String INDEX
 * - Global Subr INDEX
 * - Encodings
 * - Charsets
 * - FD Select (CIDFonts only)
 * - CharStrings INDEX (per-font)
 * - Font DICT INDEX (per-font, CIDFonts only)
 * - Private DICT (per-font)
 * - Local Subr INDEX (per-font or per-Private DICT for CIDFonts)
 * - Copyright and Trademark Notices
 *
 */

public class PDFFontCFF {
    private static float[] FontMatrix = { 0.001f, 0f, 0f, 0.001f, 0f, 0f };
    private static float[] Array4 = { 0f, 0f, 0f, 0f };
    private static float[] Array2 = { 0f, 0f };
    private static String[] standardStrings = {
            ".notdef", "space", "exclam", "quotedbl", "numbersign", "dollar", "percent",
            "ampersand", "quoteright", "parenleft", "parenright", "asterisk", "plus",
            "comma", "hyphen", "period", "slash", "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine", "colon", "semicolon", "less",
            "equal", "greater", "question", "at", "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
            "X", "Y", "Z", "bracketleft", "backslash", "bracketright", "asciicircum",
            "underscore", "quoteleft", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y",
            "z", "braceleft", "bar", "braceright", "asciitilde", "exclamdown", "cent",
            "sterling", "fraction", "yen", "florin", "section", "currency", "quotesingle",
            "quotedblleft", "guillemotleft", "guilsinglleft", "guilsinglright", "fi", "fl",
            "endash", "dagger", "daggerdbl", "periodcentered", "paragraph", "bullet",
            "quotesinglbase", "quotedblbase", "quotedblright", "guillemotright",
            "ellipsis", "perthousand", "questiondown", "grave", "acute", "circumflex",
            "tilde", "macron", "breve", "dotaccent", "dieresis", "ring", "cedilla",
            "hungarumlaut", "ogonek", "caron", "emdash", "AE", "ordfeminine", "Lslash",
            "Oslash", "OE", "ordmasculine", "ae", "dotlessi", "lslash", "oslash", "oe",
            "germandbls", "onesuperior", "logicalnot", "mu", "trademark", "Eth", "onehalf",
            "plusminus", "Thorn", "onequarter", "divide", "brokenbar", "degree", "thorn",
            "threequarters", "twosuperior", "registered", "minus", "eth", "multiply",
            "threesuperior", "copyright", "Aacute", "Acircumflex", "Adieresis", "Agrave",
            "Aring", "Atilde", "Ccedilla", "Eacute", "Ecircumflex", "Edieresis", "Egrave",
            "Iacute", "Icircumflex", "Idieresis", "Igrave", "Ntilde", "Oacute",
            "Ocircumflex", "Odieresis", "Ograve", "Otilde", "Scaron", "Uacute",
            "Ucircumflex", "Udieresis", "Ugrave", "Yacute", "Ydieresis", "Zcaron",
            "aacute", "acircumflex", "adieresis", "agrave", "aring", "atilde", "ccedilla",
            "eacute", "ecircumflex", "edieresis", "egrave", "iacute", "icircumflex",
            "idieresis", "igrave", "ntilde", "oacute", "ocircumflex", "odieresis",
            "ograve", "otilde", "scaron", "uacute", "ucircumflex", "udieresis", "ugrave",
            "yacute", "ydieresis", "zcaron", "exclamsmall", "Hungarumlautsmall",
            "dollaroldstyle", "dollarsuperior", "ampersandsmall", "Acutesmall",
            "parenleftsuperior", "parenrightsuperior", "twodotenleader", "onedotenleader",
            "zerooldstyle", "oneoldstyle", "twooldstyle", "threeoldstyle", "fouroldstyle",
            "fiveoldstyle", "sixoldstyle", "sevenoldstyle", "eightoldstyle", "nineoldstyle",
            "commasuperior", "threequartersemdash", "periodsuperior", "questionsmall",
            "asuperior", "bsuperior", "centsuperior", "dsuperior", "esuperior",
            "isuperior", "lsuperior", "msuperior", "nsuperior", "osuperior", "rsuperior",
            "ssuperior", "tsuperior", "ff", "ffi", "ffl", "parenleftinferior",
            "parenrightinferior", "Circumflexsmall", "hyphensuperior", "Gravesmall",
            "Asmall", "Bsmall", "Csmall", "Dsmall", "Esmall", "Fsmall", "Gsmall",
            "Hsmall", "Ismall", "Jsmall", "Ksmall", "Lsmall", "Msmall", "Nsmall",
            "Osmall", "Psmall", "Qsmall", "Rsmall", "Ssmall", "Tsmall", "Usmall",
            "Vsmall", "Wsmall", "Xsmall", "Ysmall", "Zsmall", "colonmonetary",
            "onefitted", "rupiah", "Tildesmall", "exclamdownsmall", "centoldstyle",
            "Lslashsmall", "Scaronsmall", "Zcaronsmall", "Dieresissmall", "Brevesmall",
            "Caronsmall", "Dotaccentsmall", "Macronsmall", "figuredash", "hypheninferior",
            "Ogoneksmall", "Ringsmall", "Cedillasmall", "questiondownsmall", "oneeighth",
            "threeeighths", "fiveeighths", "seveneighths", "onethird", "twothirds",
            "zerosuperior", "foursuperior", "fivesuperior", "sixsuperior", "sevensuperior",
            "eightsuperior", "ninesuperior", "zeroinferior", "oneinferior", "twoinferior",
            "threeinferior", "fourinferior", "fiveinferior", "sixinferior", "seveninferior",
            "eightinferior", "nineinferior", "centinferior", "dollarinferior",
            "periodinferior", "commainferior", "Agravesmall", "Aacutesmall", "Acircumflexsmall",
            "Atildesmall", "Adieresissmall", "Aringsmall", "AEsmall", "Ccedillasmall",
            "Egravesmall", "Eacutesmall", "Ecircumflexsmall", "Edieresissmall",
            "Igravesmall", "Iacutesmall", "Icircumflexsmall", "Idieresissmall", "Ethsmall",
            "Ntildesmall", "Ogravesmall", "Oacutesmall", "Ocircumflexsmall", "Otildesmall",
            "Odieresissmall", "OEsmall", "Oslashsmall", "Ugravesmall", "Uacutesmall",
            "Ucircumflexsmall", "Udieresissmall", "Yacutesmall", "Thornsmall", "Ydieresissmall",
            "001.000", "001.001", "001.002", "001.003", "Black", "Bold", "Book", "Light",
            "Medium", "Regular", "Roman", "Semibold"
    };
    //private static int nStdStrings = standardStrings.length;

    // standard encoding array depends on the standard strings array. so we save
    // some space by defining the std encoding array in terms of the SIDs (offsets)
    // into the std strings array (above).
    private static int[] standardEncoding = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
            17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35,
            36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54,
            55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73,
            74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92,
            93, 94, 95, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 96, 97, 98, 99, 100, 101, 102, 103,
            104, 105, 106, 107, 108, 109, 110, 0, 111, 112, 113, 114, 0, 115, 116, 117,
            118, 119, 120, 121, 122, 0, 123, 0, 124, 125, 126, 127, 128, 129, 130, 131,
            0, 132, 133, 0, 134, 135, 136, 137, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 138, 0, 139, 0, 0, 0, 0, 140, 141, 142, 143, 0, 0, 0, 0, 0, 144,
            0, 0, 0, 145, 0, 0, 146, 147, 148, 149, 0, 0, 0, 0
    };

    // ditto for the expert encoding array
    private static int[] expertEncoding = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 1, 229, 230, 0, 231, 232, 233, 234, 235, 236, 237, 238,
            13, 14, 15, 99, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 27, 28,
            249, 250, 251, 252, 0, 253, 254, 255, 256, 257, 0, 0, 0, 258, 0, 0, 259,
            260, 261, 262, 0, 0, 263, 264, 265, 0, 266, 109, 110, 267, 268, 269, 0,
            270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282, 283, 284,
            285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298, 299,
            300, 301, 302, 303, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 304, 305, 306, 0, 0, 307,
            308, 309, 310, 311, 0, 312, 0, 0, 313, 0, 0, 314, 315, 0, 0, 316, 317, 318,
            0, 0, 0, 158, 155, 163, 319, 320, 321, 322, 323, 324, 325, 0, 0, 326, 150,
            164, 169, 327, 328, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339,
            340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 350, 351, 352, 353, 354,
            355, 356, 357, 358, 359, 360, 361, 362, 363, 364, 365, 366, 367, 368, 369,
            370, 371, 372, 373, 374, 375, 376, 377, 378
    };

    // and the charsets arrays
    private static int[] ExpertCharset = {
            0, 1, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 13, 14, 15, 99,
            239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 27, 28, 249, 250, 251,
            252, 253, 254, 255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266,
            109, 110, 267, 268, 269, 270, 271, 272, 273, 274, 275, 276, 277, 278, 279,
            280, 281, 282, 283, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294,
            295, 296, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 307, 308, 309,
            310, 311, 312, 313, 314, 315, 316, 317, 318, 158, 155, 163, 319, 320, 321,
            322, 323, 324, 325, 326, 150, 164, 169, 327, 328, 329, 330, 331, 332, 333,
            334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348,
            349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 361, 362, 363,
            364, 365, 366, 367, 368, 369, 370, 371, 372, 373, 374, 375, 376, 377, 378
    };

    private static int[] ExpertSubSetCharset = {
            0, 1, 231, 232, 235, 236, 237, 238, 13, 14, 15, 99, 239, 240, 241, 242,
            243, 244, 245, 246, 247, 248, 27, 28, 249, 250, 251, 253, 254, 255, 256,
            257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 109, 110, 267, 268, 269,
            270, 272, 300, 301, 302, 305, 314, 315, 158, 155, 163, 320, 321, 322, 323,
            324, 325, 326, 150, 164, 169, 327, 328, 329, 330, 331, 332, 333, 334, 335,
            336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346
    };

    public PDFByteArray byteArray;
    private byte[] convertedType1 = null;
    private int charStringType, lenIV;

    public PDFFontCFF(PDFByteArray byteArray) {
        this.byteArray = byteArray;
    }

    public byte[] convertToType1() throws IOException {
        if(convertedType1 != null) {
            return convertedType1;
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        byteArray.setOffset(0);
        // read the header
        // skip major & minor numbers
        getCard8();
        getCard8();
        int hdrSize = getCard8();
        int offSize = getCard8();

        byteArray.setOffset(hdrSize);
        long[] nameINDEXOffsets = getINDEXOffsets();
        String[] fontNames = new String[nameINDEXOffsets.length-1];
        ArrayList[] fontTopDicts = new ArrayList[nameINDEXOffsets.length-1];

        // read the Name INDEX
        int i;
        for(i = 0; i < fontNames.length; i++) {
            byte[] bytes = Arrays.copyOfRange(byteArray.data,
                                (int)nameINDEXOffsets[i], (int)nameINDEXOffsets[i+1]);
            if(bytes[0] == 0) fontNames[i] = "";
            else              fontNames[i] = new String(bytes);
        }


        /*
        try (FileOutputStream fos = new FileOutputStream("FONTS/" + fontNames[0] + ".cff")) {
            fos.write(byteArray.data);
            fos.close();
        }
        */

        // read the Top DICT INDEX
        byteArray.setOffset((int) nameINDEXOffsets[i]);
        nameINDEXOffsets = getINDEXOffsets();
        for(i = 0; i < fontTopDicts.length; i++) {
            byteArray.setOffset((int) nameINDEXOffsets[i]);
            fontTopDicts[i] = getDICT(nameINDEXOffsets[i+1]);
        }

        // read the String INDEX
        byteArray.setOffset((int) nameINDEXOffsets[i]);
        nameINDEXOffsets = getINDEXOffsets();
        String[] stringINDEX = new String[nameINDEXOffsets.length-1];
        for(i = 0; i < stringINDEX.length; i++) {
            byte[] bytes = Arrays.copyOfRange(byteArray.data,
                    (int)nameINDEXOffsets[i], (int)nameINDEXOffsets[i+1]);
            if(bytes[0] == 0) stringINDEX[i] = "";
            else              stringINDEX[i] = new String(bytes);
        }

        /////////////////////////////////////
        // parse the first font
        /////////////////////////////////////

        // get the encoding
        int index = 0;
        float f = getFloatDictValue(fontTopDicts[index], "Encoding", 0);
        int[] encoding;
        if(f == 0) {            // standard encoding
            encoding = standardEncoding;
        } else if(f == 1) {     // expert encoding
            encoding = expertEncoding;
        } else {
            byteArray.setOffset((int) f);
            encoding = getEncoding();
        }

        // get the CharStrings INDEX
        f = getFloatDictValue(fontTopDicts[index], "CharStrings", 0);
        byteArray.setOffset((int) f);
        long[] charStringOffsets = getINDEXOffsets();

        f = getFloatDictValue(fontTopDicts[index], "CharstringType", 2);
        charStringType = (int) f;


        // get the charset
        f = getFloatDictValue(fontTopDicts[index], "charset", 0);
        int[] charset;
        if(f == 0) {            // ISOAdobe charset
            charset = new int[229];
            for(i = 0; i < 229; i++) {
                charset[i] = i;
            }
        } else if(f == 1) {     // Expert charset
            charset = ExpertCharset;
        } else if(f == 2) {     // ExpertSubset charset
            charset = ExpertSubSetCharset;
        } else {
            byteArray.setOffset((int) f);
            // The number of glyphs (nGlyphs) is the value of the count field in the CharStrings INDEX.
            charset = getCharset(charStringOffsets.length-1);
        }


        //////////////////////////////////////
        // check for CID fonts
        //////////////////////////////////////
        float[] f2;
        Object object = getDictValue(fontTopDicts[index], "FDArray");
        if(object != null) {
            f = (float) object;
            byteArray.setOffset((int) f);
            nameINDEXOffsets = getINDEXOffsets();
            ArrayList<DictOperator>[] fontDicts = new ArrayList[nameINDEXOffsets.length-1];
            for(i = 0; i < fontDicts.length; i++) {
                byteArray.setOffset((int) nameINDEXOffsets[i]);
                fontDicts[i] = getDICT(nameINDEXOffsets[i+1]);
            }
            // get the Private DICT
            f2 = (float[]) getDictValue(fontDicts[0], "Private");
        } else {
            // get the Private DICT
            f2 = (float[]) getDictValue(fontTopDicts[index], "Private");
        }
        long pdLastByte = (long) (f2[0]+f2[1]);
        byteArray.setOffset((int) f2[1]);
        ArrayList<DictOperator> privateDict = getDICT(pdLastByte);

        // get the offset to the local Subroutines (relative to local dictionary beginning)
        boolean hasSubr = true;
        f = getFloatDictValue(privateDict, "Subrs", 0);
        if(f == 0) hasSubr = false;
        f += f2[0];
        int subrOffset = (int) f;


        /************************************
         * Output the converted Type 1 font
         ************************************/
        String s;
        Object o;
        s = "%!PS-AdobeFont-1.0: " + fontNames[index] + "\n";
        //s = "%!FontType1-1.0: " + fontNames[index] + " " + strVer + "\n";
        out.write(s.getBytes());
        o = getDictValue(fontTopDicts[index], "Copyright");
        if(o != null) {
            i = (int) o;
            s = "% " + getString(i, stringINDEX) + "\n";
            out.write(s.getBytes());
        }
        s = "10 dict begin\n";
        out.write(s.getBytes());

        s = "/FontType 1 def\n";
        out.write(s.getBytes());

        o = getDictValue(fontTopDicts[index], "FontMatrix");
        if(o == null) {
            f2 = FontMatrix;
        } else {
            f2 = (float[]) o;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/FontMatrix [");
        for(i = 0; i < 6; i++) sb.append(formatN(f2[i]) + " ");
        sb.append("] readonly def\n");
        s = sb.toString();
        out.write(s.getBytes());

        s = "/FontName /" + fontNames[index] + " def\n";
        out.write(s.getBytes());

        o = getDictValue(fontTopDicts[index], "FontBBox");
        if(o == null) {
            f2 = Array4;
        } else {
            f2 = (float[]) o;
        }
        sb = new StringBuilder();
        sb.append("/FontBBox {");
        for(i = 0; i < 4; i++) sb.append(formatN(f2[i]) + " ");
        sb.append("} readonly def\n");
        s = sb.toString();
        out.write(s.getBytes());

        i = (int) getFloatDictValue(fontTopDicts[index], "PaintType", 0);
        s = "/PaintType " + i + " def\n";
        out.write(s.getBytes());

        s = "/FontInfo 9 dict dup begin\n";
        out.write(s.getBytes());

        s = getStringDictValue(fontTopDicts[index], "Notice", stringINDEX);
        s = "  /Notice (" + s + ") readonly def\n";
        out.write(s.getBytes());

        s = getStringDictValue(fontTopDicts[index], "FullName", stringINDEX);
        if(s.isEmpty()) s = fontNames[index];
        s = "  /FullName (" + s + ") readonly def\n";
        out.write(s.getBytes());

        s = getStringDictValue(fontTopDicts[index], "FamilyName", stringINDEX);
        if(s.isEmpty()) s = fontNames[index];
        s = "  /FamilyName (" + s + ") readonly def\n";
        out.write(s.getBytes());

        s = getStringDictValue(fontTopDicts[index], "Weight", stringINDEX);
        s = "  /Weight (" + s + ") readonly def\n";
        out.write(s.getBytes());

        s = "  /FSType 0 def\n";
        out.write(s.getBytes());

        i = (int) getFloatDictValue(fontTopDicts[index], "ItalicAngle", 0);
        s = "  /ItalicAngle " + i + " def\n";
        out.write(s.getBytes());

        boolean b = getBoolDictValue(fontTopDicts[index], "isFixedPitch");
        s = "  /isFixedPitch " + b + " def\n";
        out.write(s.getBytes());

        i = (int) getFloatDictValue(fontTopDicts[index], "UnderlinePosition", -100);
        s = "  /UnderlinePosition " + i + " def\n";
        out.write(s.getBytes());

        i = (int) getFloatDictValue(fontTopDicts[index], "UnderlineThickness", 50);
        s = "  /UnderlineThickness " + i + " def\n";
        out.write(s.getBytes());

        s = "end readonly def\n";
        out.write(s.getBytes());

        if(encoding.equals(standardEncoding)) {
            s = "/Encoding StandardEncoding def\n";
            out.write(s.getBytes());
        } else if(encoding.equals(expertEncoding)) {
            s = "/Encoding ExpertEncoding def\n";
            out.write(s.getBytes());
        } else {
            s = "/Encoding " + charset.length + " array\n";
            out.write(s.getBytes());
            s = "0 1 " + (charset.length - 1) + " { 1 index exch /.notdef put } for\n";
            out.write(s.getBytes());

            for (i = 1; i < charset.length; i++) {
                s = getString(charset[i], stringINDEX);
                s = "dup " + i + " /" + s + " put\n";
                out.write(s.getBytes());
            }

            s = "readonly def\n";
            out.write(s.getBytes());
        }

        s = "currentdict end\n" + "currentfile eexec\n";
        out.write(s.getBytes());

        /*******************************
         * Prepare the encrypted part
         *******************************/
        ByteArrayOutputStream out2 = new ByteArrayOutputStream();
        out2.write(0xAD);
        out2.write('L');
        out2.write('I');
        out2.write('L');


        s = "dup\n/Private 16 dict dup begin\n";
        out2.write(s.getBytes());

        s = "/RD{string currentfile exch readstring pop}executeonly def\n";
        out2.write(s.getBytes());

        s = "/ND{noaccess def}executeonly def\n";
        out2.write(s.getBytes());

        s = "/NP{noaccess put}executeonly def\n";
        out2.write(s.getBytes());

        s = "/MinFeature{16 16}ND\n"
                + "/password 5839 def\n";
        out2.write(s.getBytes());

        s = getBlues(privateDict, "BlueValues");
        out2.write(s.getBytes());
        s = getBlues(privateDict, "OtherBlues");
        out2.write(s.getBytes());
        f = getFloatDictValue(privateDict, "BlueScale", 0.039625f);
        s = "/BlueScale " + (int)f + " def\n";
        out2.write(s.getBytes());
        f = getFloatDictValue(privateDict, "BlueShift", 7f);
        s = "/BlueShift " + (int)f + " def\n";
        out2.write(s.getBytes());
        f = getFloatDictValue(privateDict, "StdHW", 0);
        s = "/StdHW [" + (int)f + "] ND\n";
        out2.write(s.getBytes());
        f = getFloatDictValue(privateDict, "StdVW", 0);
        s = "/StdVW [" + (int)f + "] ND\n";
        out2.write(s.getBytes());
        s = getBlues(privateDict, "StemSnapH");
        out2.write(s.getBytes());
        s = getBlues(privateDict, "StemSnapV");
        out2.write(s.getBytes());


        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try {
            byte[] bbb = Files.readAllBytes(Paths.get(classloader.
                                    getResource("type1FontOtherSubrs").toURI()));
            out2.write(bbb);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        ArrayList<byte[]> subrsArray = new ArrayList<>();
        ArrayList<byte[]> charstringsArray = new ArrayList<>();

        /*
         * Add standard Subrs 0 to 3.
         */
        byte[] charstring = encode(new byte[]{ 'L', 'I', 'L', 'Y', (byte) 142, (byte) 139, 12, 16, 12, 17, 12, 17, 12, 33, 11 }, 4330);
        subrsArray.add(charstring);
        charstring = encode(new byte[]{ 'L', 'I', 'L', 'Y', (byte) 139, (byte) 140, 12, 16, 11 }, 4330);
        subrsArray.add(charstring);
        charstring = encode(new byte[]{ 'L', 'I', 'L', 'Y', (byte) 139, (byte) 141, 12, 16, 11 }, 4330);
        subrsArray.add(charstring);
        charstring = encode(new byte[]{ 'L', 'I', 'L', 'Y', 11 }, 4330);
        subrsArray.add(charstring);

        int j = charStringOffsets.length-1;
        for(i = 0; i < j; i++) {
            int len = (int) (charStringOffsets[i+1]-charStringOffsets[i]);
            //System.out.println("i=" + i + ", len=" + len);
            byte[] bytes = byteArray.copyOfRange((int) charStringOffsets[i], (int) (charStringOffsets[i]+len));
            byte[] bytes1 = charString2To1Output(bytes, privateDict, subrsArray);
            charstringsArray.add(bytes1);
        }

        s = "/Subrs " + subrsArray.size() + " array\n";
        out2.write(s.getBytes());
        for(i = 0; i < subrsArray.size(); i++) {
            byte[] bytes = subrsArray.get(i);
            s = "dup " + i + " " + bytes.length + " RD ";
            out2.write(s.getBytes());
            out2.write(bytes);
            s = " NP\n";
            out2.write(s.getBytes());
        }
        s = "ND\n";
        out2.write(s.getBytes());


        if(hasSubr) {
            throw new
                    UnsupportedOperationException("Font has local Subr entries (not implemented yet)");
            /*
            byteArray.setOffset(subrOffset);
            nameINDEXOffsets = getINDEXOffsets();
            for(i = 0; i < nameINDEXOffsets.length-1; i++) {
                int len = (int) (nameINDEXOffsets[i+1]-nameINDEXOffsets[i]);
                s = "dup " + i + " " + len + " RD ";
                out2.write(s.getBytes());
                out2.write(byteArray.data, (int) nameINDEXOffsets[i], len);
                s = " NP\n";
                out2.write(s.getBytes());
            }
            s = "ND";
            out2.write(s.getBytes());
            */
        }


        s = "2 index ";
        out2.write(s.getBytes());

        j = charstringsArray.size();
        s = "/CharStrings " + j + " dict dup begin\n";
        out2.write(s.getBytes());
        for(i = 0; i < j; i++) {
            byte[] bytes1 = charstringsArray.get(i);
            s = "/" + getString(charset[i], stringINDEX) + " " + bytes1.length + " RD ";
            out2.write(s.getBytes());
            out2.write(bytes1);
            s = " ND\n";
            out2.write(s.getBytes());
        }

        s = "end end\n" + "readonly put\n" + "put\n" +
                "dup/FontName get exch definefont pop\n" + " mark currentfile closefile\n";
        out2.write(s.getBytes());

        /*
         * Encode!
         */
        byte[] eexecBytes = encode(out2.toByteArray(), 55665);
        writeBytesToAscii(eexecBytes, out);


        /*
         * Finalize
         */
        out.write("\n".getBytes());
        for(i = 0; i < 8; i++) {
            out.write("0000000000000000000000000000000000000000000000000000000000000000\n".getBytes());
        }
        s = "cleartomark";
        out.write(s.getBytes());


        /*
        try (FileOutputStream fos = new FileOutputStream("FONTS/" + fontNames[index] + ".pfa")) {
            fos.write(out.toByteArray());
            fos.close();
        }
        byte[] bs = decode(eexecBytes, 55665);
        try (FileOutputStream fos = new FileOutputStream("FONTS/" + fontNames[index] + "eexec.txt")) {
            fos.write(bs);
            fos.close();
        }
        */

        convertedType1 = out.toByteArray();
        return convertedType1;
    }

    private String getBlues(ArrayList<DictOperator> privateDict, String name) {
        Object o = getDictValue(privateDict, name);
        float[] f2 = (float[]) o;
        StringBuilder sb = new StringBuilder();
        sb.append("/" + name + " [");
        int i = 0;
        for( ; i < f2.length-1; i++) sb.append(formatN(f2[i]) + " ");
        sb.append(formatN(f2[i]));
        sb.append("] ND\n");
        return sb.toString();
    }


    private byte[] charString2To1Output(byte[] bytes1, ArrayList<DictOperator> privateDict, ArrayList<byte[]> subrsArray) throws IOException {
        if(charStringType == 1) {
            return bytes1;
        }

        ByteArrayOutputStream out2 = new ByteArrayOutputStream();
        ArrayList<Integer> operands = new ArrayList<>();
        int dxa, dxb, dxc, dxd, dya, dyb, dyc, dyd;
        int a1, a2, a3;
        ArrayList<Hint> hintArray = new ArrayList<>();

        int i = 0;
        boolean firstOp = true;
        Integer w = null;
        int hints = 0;

        for ( ; i < bytes1.length; i++) {
            boolean isOp = true;
            int b = (bytes1[i] & 0xff);
            //System.out.println("b = " + b);
            switch (b) {
                case (1):       // hstem (*)
                case (18):      // hstemhm (*)
                    if(firstOp && operands.size() % 2 != 0) {
                        w = operands.remove(0);
                        firstOp = false;
                    }
                    a1 = 0;
                    while (operands.size() != 0) {
                        a1 += operands.remove(0);
                        a2 = operands.remove(0);
                        hintArray.add(new Hint(a1, a2, false));
                        if(b == 1) {
                            out2.write(intToBytes(a1));
                            out2.write(intToBytes(a2));
                            out2.write(1);
                        }
                        hints++;
                    }
                    break;
                case (3):
                case (23):
                    if(firstOp && operands.size() % 2 != 0) {
                        w = operands.remove(0);
                        firstOp = false;
                    }
                    a1 = 0;
                    while (operands.size() != 0) {
                        a1 += operands.remove(0);
                        a2 = operands.remove(0);
                        hintArray.add(new Hint(a1, a2, true));
                        if(b == 3) {
                            out2.write(intToBytes(a1));
                            out2.write(intToBytes(a2));
                            out2.write(3);
                        }
                        hints++;
                    }
                    break;
                case (5):       // rlineto
                    /*
                    System.out.println("firstOp = " + firstOp + ", i=" + i + ", length=" + bytes1.length);
                    for(int j = 0; j < operands.size(); j++) {
                        System.out.println("[" + j + "] " + operands.get(j).toString());
                    }
                    */
                    while (operands.size() != 0) {
                        a1 = operands.remove(0);
                        a2 = operands.remove(0);
                        out2.write(intToBytes(a1));
                        out2.write(intToBytes(a2));
                        out2.write(5);
                    }
                    break;
                case (6):       // hlineto
                    if ((operands.size() % 2) != 0) {
                        a1 = operands.remove(0);
                        out2.write(intToBytes(a1));
                        out2.write(6);
                        while (operands.size() != 0) {
                            a2 = operands.remove(0);
                            a3 = operands.remove(0);
                            out2.write(intToBytes(a2));
                            out2.write(7);
                            out2.write(intToBytes(a3));
                            out2.write(6);
                        }
                    } else {
                        while (operands.size() != 0) {
                            a1 = operands.remove(0);
                            a2 = operands.remove(0);
                            out2.write(intToBytes(a1));
                            out2.write(6);
                            out2.write(intToBytes(a2));
                            out2.write(7);
                        }
                    }
                    break;
                case (7):       // vlineto
                    if ((operands.size() % 2) != 0) {
                        a1 = operands.remove(0);
                        out2.write(intToBytes(a1));
                        out2.write(7);
                        while (operands.size() != 0) {
                            a2 = operands.remove(0);
                            a3 = operands.remove(0);
                            out2.write(intToBytes(a2));
                            out2.write(6);
                            out2.write(intToBytes(a3));
                            out2.write(7);
                        }
                    } else {
                        while (operands.size() != 0) {
                            a1 = operands.remove(0);
                            a2 = operands.remove(0);
                            out2.write(intToBytes(a1));
                            out2.write(7);
                            out2.write(intToBytes(a2));
                            out2.write(6);
                        }
                    }
                    break;
                case (8):       // rrcurveto
                    while (operands.size() != 0) {
                        for (int k = 0; k < 6; k++)
                            out2.write(intToBytes(operands.remove(0)));
                        out2.write(8);
                    }
                    break;
                case (12):
                    b = (bytes1[++i] & 0xff);
                    switch (b) {
                        case(9):
                            a1 = Math.abs(operands.remove(0));
                            out2.write(intToBytes(a1));
                            break;
                        case(10):
                            a1 = operands.remove(0);
                            a2 = operands.remove(0);
                            a3 = a1+a2;
                            out2.write(intToBytes(a3));
                            break;
                        case(11):
                            a1 = operands.remove(0);
                            a2 = operands.remove(0);
                            a3 = a1-a2;
                            out2.write(intToBytes(a3));
                            break;
                        case(12):
                            a1 = operands.remove(0);
                            a2 = operands.remove(0);
                            out2.write(intToBytes(a1));
                            out2.write(intToBytes(a2));
                            out2.write(12);
                            out2.write(12);
                            break;
                        case(14):
                            a1 = operands.remove(0);
                            out2.write(intToBytes(-a1));
                            break;
                        case(18):
                            operands.remove(operands.size()-1);
                            break;
                        case(24):
                            a1 = operands.remove(0);
                            a2 = operands.remove(0);
                            a3 = a1*a2;
                            out2.write(intToBytes(a3));
                            break;
                        case(26):
                            a1 = operands.remove(0);
                            a2 = (int) Math.sqrt(a1);
                            out2.write(intToBytes(a2));
                            break;
                        case(28):
                            a2 = operands.remove(operands.size()-1);
                            a1 = operands.remove(operands.size()-1);
                            operands.add(a2);
                            operands.add(a1);
                            break;
                        case(34):       // hflex
                            dxa = operands.remove(0);
                            dya = 0;
                            dxb = operands.remove(0);
                            dyb = operands.remove(0);
                            dxc = operands.remove(0);
                            dyc = 0;
                            out2.write(intToBytes(dxa));
                            out2.write(intToBytes(dya));
                            out2.write(intToBytes(dxb));
                            out2.write(intToBytes(dyb));
                            out2.write(intToBytes(dxc));
                            out2.write(intToBytes(dyc));
                            out2.write(8);

                            dxa = operands.remove(0);
                            dya = 0;
                            dxb = operands.remove(0);
                            dyb = 0;
                            dxc = operands.remove(0);
                            dyc = 0;
                            out2.write(intToBytes(dxa));
                            out2.write(intToBytes(dya));
                            out2.write(intToBytes(dxb));
                            out2.write(intToBytes(dyb));
                            out2.write(intToBytes(dxc));
                            out2.write(intToBytes(dyc));
                            out2.write(8);
                            break;
                        case(35):       // flex
                            while (operands.size() != 0) {
                                for (int k = 0; k < 6; k++)
                                    out2.write(intToBytes(operands.remove(0)));
                                out2.write(8);
                            }
                            operands.remove(0);
                            break;
                        case(36):       // hflex1
                            dxa = operands.remove(0);
                            dya = operands.remove(0);
                            dxb = operands.remove(0);
                            dyb = operands.remove(0);
                            dxc = operands.remove(0);
                            dyc = 0;
                            out2.write(intToBytes(dxa));
                            out2.write(intToBytes(dya));
                            out2.write(intToBytes(dxb));
                            out2.write(intToBytes(dyb));
                            out2.write(intToBytes(dxc));
                            out2.write(intToBytes(dyc));
                            out2.write(8);

                            dxa = operands.remove(0);
                            dya = 0;
                            dxb = operands.remove(0);
                            dyb = operands.remove(0);
                            dxc = operands.remove(0);
                            dyc = 0;
                            out2.write(intToBytes(dxa));
                            out2.write(intToBytes(dya));
                            out2.write(intToBytes(dxb));
                            out2.write(intToBytes(dyb));
                            out2.write(intToBytes(dxc));
                            out2.write(intToBytes(dyc));
                            out2.write(8);
                            break;
                        case(37):       // flex1
                            throw new UnsupportedOperationException("Got a flex 1 operator (12 37)");
                    }
                    break;
                case (11):
                case (14):      // endchar
                    out2.write(b);
                    break;
                case (19):
                case (20):
                    // if there are operands on the stack, assume they are of a vstem operator
                    // that is not included in the stream (see page 25 of Type 2 Charstring Format).
                    a1 = 0;
                    while(operands.size() >= 2) {
                        a2 = operands.remove(operands.size() - 1);
                        a1 += operands.remove(operands.size() - 1);
                        hintArray.add(new Hint(a1, a2, true));
                        hints++;
                    }
                    // get the hint masks
                    int count = hints; //(hints+7)/8;
                    int bitMask = 1;
                    int index = 0;
                    ByteArrayOutputStream hintsOut = new ByteArrayOutputStream();
                    hintsOut.write('L');
                    hintsOut.write('I');
                    hintsOut.write('L');
                    hintsOut.write('Y');
                    while(count-- > 0) {
                        if(bitMask == 1) {
                            bitMask = (1 << 7);
                            i++;
                        } else {
                            bitMask >>>= 1;
                        }
                        boolean onOff = (bytes1[i] & bitMask) == bitMask;
                        if(onOff) {
                            Hint hint = hintArray.get(index);
                            hintsOut.write(intToBytes(hint.x));
                            hintsOut.write(intToBytes(hint.dx));
                            if(hint.isVertical) hintsOut.write(3);
                            else                hintsOut.write(1);
                        }
                        index++;
                    }
                    hintsOut.write(11);
                    byte[] hintBytes = encode(hintsOut.toByteArray(), 4330);
                    index = subrsArray.size();
                    subrsArray.add(hintBytes);
                    out2.write(intToBytes(index));
                    out2.write(140);
                    out2.write(142);
                    out2.write(12);
                    out2.write(16);
                    out2.write(12);
                    out2.write(17);
                    out2.write(10);

                    break;
                case (21):      // rmoveto (*)
                    if(firstOp && operands.size() > 2) {
                        w = operands.remove(0);
                        firstOp = false;
                    }
                    a2 = operands.remove(operands.size() - 1);
                    a1 = operands.remove(operands.size() - 1);
                    out2.write(intToBytes(a1));
                    out2.write(intToBytes(a2));
                    out2.write(21);
                    break;
                case (4):       // vmoveto (*)
                case (10):
                case (22):      // hmoveto (*)
                    if(firstOp && operands.size() > 1) {
                        w = operands.remove(0);
                        firstOp = false;
                    }
                    a1 = operands.remove(operands.size() - 1);
                    out2.write(intToBytes(a1));
                    out2.write(b);
                    break;
                case (29):
                    throw new UnsupportedOperationException("Got a callgsubr (29)");
                case (24):      // rcurveline
                    a2 = operands.remove(operands.size() - 1);
                    a1 = operands.remove(operands.size() - 1);
                    while (operands.size() != 0) {
                        for (int k = 0; k < 6; k++)
                            out2.write(intToBytes(operands.remove(0)));
                        out2.write(8);
                    }
                    out2.write(intToBytes(a1));
                    out2.write(intToBytes(a2));
                    out2.write(5);
                    break;
                case (25):      // rlinecurve
                    dyd = operands.remove(operands.size() - 1);
                    dxd = operands.remove(operands.size() - 1);
                    dyc = operands.remove(operands.size() - 1);
                    dxc = operands.remove(operands.size() - 1);
                    dyb = operands.remove(operands.size() - 1);
                    dxb = operands.remove(operands.size() - 1);
                    while (operands.size() != 0) {
                        dxa = operands.remove(0);
                        dya = operands.remove(0);
                        out2.write(intToBytes(dxa));
                        out2.write(intToBytes(dya));
                        out2.write(5);
                    }
                    out2.write(intToBytes(dxb));
                    out2.write(intToBytes(dyb));
                    out2.write(intToBytes(dxc));
                    out2.write(intToBytes(dyc));
                    out2.write(intToBytes(dxd));
                    out2.write(intToBytes(dyd));
                    out2.write(8);
                    break;
                case (26):      // vvcurveto
                    int dx1 = 0;
                    if ((operands.size() % 2) != 0) {
                        dx1 = operands.remove(0);
                    }
                    while (operands.size() != 0) {
                        dya = operands.remove(0);
                        dxb = operands.remove(0);
                        dyb = operands.remove(0);
                        dyc = operands.remove(0);
                        out2.write(intToBytes(dx1));
                        out2.write(intToBytes(dya));
                        out2.write(intToBytes(dxb));
                        out2.write(intToBytes(dyb));
                        out2.write(intToBytes(0));
                        out2.write(intToBytes(dyc));
                        dx1 = 0;
                        out2.write(8);
                    }
                    break;
                case (27):      // hhcurveto
                    int dy1 = 0;
                    if ((operands.size() % 2) != 0) {
                        dy1 = operands.remove(0);
                    }
                    while (operands.size() != 0) {
                        dxa = operands.remove(0);
                        dxb = operands.remove(0);
                        dyb = operands.remove(0);
                        dxc = operands.remove(0);
                        out2.write(intToBytes(dxa));
                        out2.write(intToBytes(dy1));
                        out2.write(intToBytes(dxb));
                        out2.write(intToBytes(dyb));
                        out2.write(intToBytes(dxc));
                        out2.write(intToBytes(0));
                        dy1 = 0;
                        out2.write(8);
                    }
                    break;
                case (30):      // vhcurveto
                case (31):      // hvcurveto
                    boolean isVertical = (b == 30);
                    while (operands.size() != 0) {
                        int d1 = operands.remove(0);
                        int d2 = operands.remove(0);
                        int d3 = operands.remove(0);
                        int d4 = operands.remove(0);
                        if(isVertical) {
                            out2.write(intToBytes(0));
                            out2.write(intToBytes(d1));
                            out2.write(intToBytes(d2));
                            out2.write(intToBytes(d3));
                            out2.write(intToBytes(d4));
                            int dyf = 0;
                            if(operands.size() == 1) dyf = operands.remove(0);
                            out2.write(intToBytes(dyf));
                            out2.write(8);
                        } else {
                            out2.write(intToBytes(d1));
                            out2.write(intToBytes(0));
                            out2.write(intToBytes(d2));
                            out2.write(intToBytes(d3));
                            int dxf = 0;
                            if(operands.size() == 1) dxf = operands.remove(0);
                            out2.write(intToBytes(dxf));
                            out2.write(intToBytes(d4));
                            out2.write(8);
                        }
                        isVertical = !isVertical;
                    }
                    break;
                case (28):
                    int j = (bytes1[i + 1] << 8) | bytes1[i + 2];
                    operands.add(j);
                    i += 2;
                    isOp = false;
                    break;
                default:
                    if (b >= 32 && b <= 246) {
                        j = b - 139;
                        operands.add(j);
                    } else if (b >= 247 && b <= 250) {
                        int b2 = (bytes1[i + 1] & 0xff);
                        j = ((b - 247) * 256) + b2 + 108;
                        operands.add(j);
                        i++;
                    } else if (b >= 251 && b <= 254) {
                        int b2 = (bytes1[i + 1] & 0xff);
                        j = -((b - 251) * 256) - b2 - 108;
                        operands.add(j);
                        i++;
                    } else if (b == 255) {
                        byte[] ba = Arrays.copyOfRange(bytes1, i + 1, i + 5);
                        float f = ByteBuffer.wrap(ba).order(ByteOrder.BIG_ENDIAN).getFloat();
                        j = (int) f;
                        operands.add(j);
                        i += 4;
                    } else {
                        throw new UnsupportedOperationException("Got an unknown byte value: '" + b + "'");
                    }
                    isOp = false;
                    break;
            }

            if(firstOp && isOp) {
                firstOp = false;
                if(operands.size() > 0) {
                    w = operands.remove(0);
                }
            }
        }

        // append the width operator to the front of the charstring
        if(w != null) {
            a2 = (int) getFloatDictValue(privateDict, "nominalWidthX", 0);
            a2 = a2+w;
        } else {
            a2 = (int) getFloatDictValue(privateDict, "defaultWidthX", 0);
        }

        byte[] bytes2 = out2.toByteArray();
        byte[] zero = intToBytes(0);
        byte[] a2b = intToBytes(a2);
        byte[] result = new byte[5+zero.length+a2b.length+bytes2.length];
        result[0] = 'L';
        result[1] = 'I';
        result[2] = 'L';
        result[3] = 'Y';
        System.arraycopy(zero, 0, result, 4, zero.length);
        i = 4+zero.length;
        System.arraycopy(a2b , 0, result, i, a2b.length);
        i += a2b.length;
        result[i++] = 13;
        System.arraycopy(bytes2, 0, result, i, bytes2.length);
        result = encode(result, 4330);
        return result;
    }

    private byte[] intToBytes(int i) {
        if(i >= -107 && i <= 107) {
            i += 139;
            return new byte[] { (byte) i };
        } else if(i >= 108 && i <= 1131) {
            int[] factor = { 108, 364, 620, 876 };
            int[] vArray = { 247, 248, 249, 250 };
            for(int j = 0; j < 4; j++) {
                int w = i - factor[j];
                if(w >= 0 && w <= 255) {
                    return new byte[] { (byte) vArray[j], (byte) w };
                }
            }
        } else if(i >= -1131 && i <= -108) {
            int[] factor = { -108, -364, -620, -876 };
            int[] vArray = {  251,  252,  253,  254 };
            for(int j = 0; j < 4; j++) {
                int w = factor[j] - i;
                if(w >= 0 && w <= 255) {
                    return new byte[] { (byte) vArray[j], (byte) w };
                }
            }
        } else {
            byte[] result = new byte[5];
            result[0] = (byte) (255);
            result[1] = (byte) (i >> 24);
            result[2] = (byte) (i >> 16);
            result[3] = (byte) (i >> 8);
            result[4] = (byte) (i);
            return result;
        }
        throw new IllegalArgumentException("Failed to encode integer value: " + i);
    }

    private String formatN(float d) {
        double d2 = Math.ceil(d);
        if(d == d2) return String.valueOf((int)d);
        else return String.valueOf(d);
    }

    private void writeBytesToAscii(byte[] bytes, ByteArrayOutputStream out) {
        int col = 0;
        for(int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            out.write(nibbleToAscii((b >> 4) & 0xf));
            out.write(nibbleToAscii(b & 0xf));
            if(++col == 36) {
                col = 0;
                out.write('\r');
                out.write('\n');
            }
        }
    }

    private byte nibbleToAscii(int b) {
        if(b >= 0 && b <= 9) return (byte) ('0'+b);
        if(b == 10) return 'a';
        if(b == 11) return 'b';
        if(b == 12) return 'c';
        if(b == 13) return 'd';
        if(b == 14) return 'e';
        if(b == 15) return 'f';
        return 0;
    }

    private byte[] encode(byte[] bytes, int R) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int c1 = 52845;
        int c2 = 22719;
        for(int i = 0; i < bytes.length; i++) {
            int plain = bytes[i] & 0xff;
            int r = (R >> 8) & 0xff;
            int cipher = (plain ^ r);
            R = (cipher + R) * c1 + c2;
            out.write((byte) cipher);
        }
        return out.toByteArray();
    }

    private byte[] decode(byte[] bytes, int R) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int c1 = 52845;
        int c2 = 22719;
        for(int i = 0; i < bytes.length; i++) {
            int cipher = bytes[i] & 0xff;
            int r = (R >> 8) & 0xff;
            int plain = (cipher ^ r);
            R = (cipher + R) * c1 + c2;
            out.write((byte) plain);
        }
        return out.toByteArray();
    }

    /*
    private byte[] decode2(byte[] bytes, int R) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        for(int i = 0; i < bytes.length; i += 2) {
            if(bytes[i] == '\r') i++;
            if(bytes[i] == '\n') i++;
            byte b1 = asciiToNibble(bytes[i]);
            byte b2 = asciiToNibble(bytes[i+1]);
            int b = (b1 << 4) | b2;
            out.write((byte) b);
        }
        return decode(out.toByteArray(), R);
    }

    private byte asciiToNibble(byte ascii) {
        if(ascii >= '0' && ascii <= '9') return (byte) (ascii-'0');
        if(ascii >= 'A' && ascii <= 'F') return (byte) (ascii-'A'+10);
        if(ascii >= 'a' && ascii <= 'f') return (byte) (ascii-'a'+10);
        return 0;
    }
    */

    private String getString(int SID, String[] stringINDEX) {
        int stdStrCount = standardStrings.length;
        if(SID < stdStrCount) {
            return standardStrings[SID];
        } else {
            SID -= stdStrCount;
            return stringINDEX[SID];
        }
    }

    private int[] getCharset(int glyphCount) throws IOException {
        int[] charset = new int[glyphCount+1];
        int j = 0, k;
        charset[j++] = 0;        // .notdef glyph
        int i = getCard8();
        if (i == 0) {         // format 0
            while (++i < glyphCount) charset[j++] = getSID();
        } else if (i == 1 || i == 2) {   // formats 1 & 2
            int format = i;
            while (j < glyphCount) {
                i = getSID();   // first code in range
                if(format == 1)
                     k = getCard8();   // codes left in range
                else k = getCard16();
                charset[j++] = i++;
                while (k-- > 0) charset[j++] = i++;
            }
        } else {
            throw new UnsupportedEncodingException("Unknown charset format");
        }
        return charset;
    }

    private int[] getEncoding() throws IOException {
        int[] encoding = new int[256];
        int j = 0, k;
        encoding[j++] = 0;        // .notdef glyph
        int i = getCard8();
        int count;
        if (i == 0) {         // format 0
            count = getCard8();
            while (i++ < count) encoding[j++] = getCard8();
        } else if (i == 1) {   // format 1
            int ranges = getCard8();
            while (ranges-- > 0) {
                i = getCard8(); // first code in range
                k = getCard8(); // codes left in range
                encoding[j++] = i++;
                while (k-- > 0) encoding[j++] = i++;
            }
        } else {
                /*
                 * This might be a supplemental encoding. SEE Table 14 Supplemental Encoding Data,
                 * page 20 of the CFF Spec.
                 *
                 * TODO: implement this.
                 */
            throw new UnsupportedEncodingException("Supplemental Encoding is not supported yet!");
        }
        return encoding;
    }

    /*
     * get the offsets of INDEX entries.
     */
    private long[] getINDEXOffsets() throws IOException {
        int count = getCard16();
        if(count == 0) return new long[] { byteArray.getOffset() };

        int offSize = getCard8();
        long[] offsets = new long[count+1];

        // calculate offset from start of file
        long offFromZero = byteArray.getOffset();
        offFromZero += ((count+1)*offSize);

        for(int i = 0; i <= count; i++) {
            // offsets are biased by +1.
            long j = getOffset(offSize)-1;
            j += offFromZero;
            offsets[i] = j;
        }
        return offsets;
    }

    /*
     * get DICT data.
     */
    private ArrayList<DictOperator> getDICT(long lastByteOffset) throws IOException {
        ObjectStack operands = new ObjectStack();

        ArrayList<DictOperator> dict = new ArrayList<>();

        while(byteArray.getOffset() < lastByteOffset) {
            int i = getCard8();
            int j;
            // is it an operator?
            if (i >= 0 && i <= 21) {
                DictOperator operator = getDictOperator(i);
                parseDictValue(operator, operands);
                dict.add(operator);
            } else if (i == 28) {
                // 3-byte integers
                int b1 = getCard8();
                int b2 = getCard8();
                j = (b1 << 8) | b2;
                //j = getCard16();
                operands.push(new Operand(OperandType.Number, (float) j));
            } else if (i == 29) {
                // 5-byte integers
                int b1 = getCard8();
                int b2 = getCard8();
                int b3 = getCard8();
                int b4 = getCard8();
                j = (b1 << 24) | (b2 << 16) | (b3 << 8) | b4;
                //i = getCard16();
                //j = (i << 16) | getCard16();
                operands.push(new Operand(OperandType.Number, (float) j));
            } else if (i == 30) {
                // real numbers
                float f = getRealNum();
                operands.push(new Operand(OperandType.Number, f));
            } else if (i >= 32 && i <= 246) {
                // 1-byte integers
                j = i - 139;
                operands.push(new Operand(OperandType.Number, (float) j));
            } else if (i >= 247 && i <= 250) {
                // 2-byte integers
                j = getCard8();
                j = ((i - 247) * 256) + j + 108;
                operands.push(new Operand(OperandType.Number, (float) j));
            } else if (i >= 251 && i <= 254) {
                // 2-byte integers
                j = getCard8();
                j = -((i - 251) * 256) - j - 108;
                operands.push(new Operand(OperandType.Number, (float) j));
            } else {
                throw new IllegalArgumentException("Illegal number value for an operand");
            }
        }
        return dict;
    }

    //get the value associated with the given key
    private Object getDictValue(ArrayList<DictOperator> DICT, String key) {
        for(DictOperator operator : DICT) {
            if(operator.name.equalsIgnoreCase(key)) {
                return operator.defaultVal;
            }
        }
        return null;
    }

    private boolean getBoolDictValue(ArrayList<DictOperator> DICT, String key) {
        Object o = getDictValue(DICT, key);
        boolean b;
        if(o == null) b = false;
        else          b = (boolean) o;
        return b;
    }

    private float getFloatDictValue(ArrayList<DictOperator> DICT, String key, float defaultVal) {
        Object o = getDictValue(DICT, key);
        float f;
        if(o == null) f = defaultVal;
        else          f = (float) o;
        return f;
    }

    private String getStringDictValue(ArrayList<DictOperator> DICT, String key, String[] stringINDEX) {
        Object o = getDictValue(DICT, key);
        String s;
        if(o == null) s = "";
        else {
            int i = (int) o;
            s = getString(i, stringINDEX);
        }
        return s;
    }

    private void parseDictValue(DictOperator operator, ObjectStack operands) {
        // if no operands, we will use the default value (if any).
        int count = operands.getObjectCount();
        if(count == 0) return;

        if(operator.type == OperandType.SID) {
            Operand op = (Operand) operands.pop();
            float opv = (float) op.value;
            operator.defaultVal = (int)opv;
        } else if(operator.type == OperandType.Boolean) {
            Operand op = (Operand) operands.pop();
            float opv = (float) op.value;
            int i = (int)opv;
            operator.defaultVal = (i != 0);
        } else if(operator.type == OperandType.Number) {
            Operand op = (Operand) operands.pop();
            float opv = (float) op.value;
            operator.defaultVal = opv;
        } else if(operator.type == OperandType.Array || operator.type == OperandType.Delta) {
            float[] f = new float[count];
            int i;
            for(i = 0; i < count; i++) {
                Operand op = (Operand) operands.pop();
                f[count-i-1] = (float) op.value;
            }
            if(operator.type == OperandType.Delta) {
                for(i = 1; i < count; i++) f[i] += f[i-1];
            }
            operator.defaultVal = f;
        }
    }

    private DictOperator getDictOperator(int val) throws IOException {
        switch (val) {
            case 0:
                return new DictOperator("version", OperandType.SID, null);
            case 1:
                return new DictOperator("Notice", OperandType.SID, null);
            case 2:
                return new DictOperator("FullName", OperandType.SID, null);
            case 3:
                return new DictOperator("FamilyName", OperandType.SID, null);
            case 4:
                return new DictOperator("Weight", OperandType.SID, null);
            case 5:
                return new DictOperator("FontBBox", OperandType.Array, Array4);
            case 6:
                return new DictOperator("BlueValues", OperandType.Delta, null);
            case 7:
                return new DictOperator("OtherBlues", OperandType.Delta, null);
            case 8:
                return new DictOperator("FamilyBlues", OperandType.Delta, null);
            case 9:
                return new DictOperator("FamilyOtherBlues", OperandType.Delta, null);
            case 10:
                return new DictOperator("StdHW", OperandType.Number, null);
            case 11:
                return new DictOperator("StdVW", OperandType.Number, null);
            case 12:
                // two byte operators
                val = getCard8();
                switch (val) {
                    case 0:
                        return new DictOperator("Copyright", OperandType.SID, null);
                    case 1:
                        return new DictOperator("isFixedPitch", OperandType.Boolean, false);
                    case 2:
                        return new DictOperator("ItalicAngle", OperandType.Number, 0f);
                    case 3:
                        return new DictOperator("UnderlinePosition", OperandType.Number, -100f);
                    case 4:
                        return new DictOperator("UnderlineThickness", OperandType.Number, 50f);
                    case 5:
                        return new DictOperator("PaintType", OperandType.Number, 0f);
                    case 6:
                        return new DictOperator("CharstringType", OperandType.Number, 2f);
                    case 7:
                        return new DictOperator("FontMatrix", OperandType.Array, FontMatrix);
                    case 8:
                        return new DictOperator("StrokeWidth", OperandType.Number, 0f);
                    case 9:
                        return new DictOperator("BlueScale", OperandType.Number, 0.039625f);
                    case 10:
                        return new DictOperator("BlueShift", OperandType.Number, 7f);
                    case 11:
                        return new DictOperator("BlueFuzz", OperandType.Number, 1f);
                    case 12:
                        return new DictOperator("StemSnapH", OperandType.Delta, null);
                    case 13:
                        return new DictOperator("StemSnapV", OperandType.Delta, null);
                    case 14:
                        return new DictOperator("ForceBold", OperandType.Boolean, false);
                    case 17:
                        return new DictOperator("LanguageGroup", OperandType.Number, 0f);
                    case 18:
                        return new DictOperator("ExpansionFactor", OperandType.Number, 0.06f);
                    case 19:
                        return new DictOperator("initialRandomSeed", OperandType.Number, 0f);
                    case 20:
                        return new DictOperator("SyntheticBase", OperandType.Number, null);
                    case 21:
                        return new DictOperator("PostScript", OperandType.SID, null);
                    case 22:
                        return new DictOperator("BaseFontName", OperandType.SID, null);
                    case 23:
                        return new DictOperator("BaseFontBlend", OperandType.Delta, null);
                    case 30:
                        /*
                         * TODO: fix this. it should be a triad of: SID SID Number.
                         */
                        return new DictOperator("ROS", OperandType.Array, null);
                    case 31:
                        return new DictOperator("CIDFontVersion", OperandType.Number, 0f);
                    case 32:
                        return new DictOperator("CIDFontRevision", OperandType.Number, 0f);
                    case 33:
                        return new DictOperator("CIDFontType", OperandType.Number, 0f);
                    case 34:
                        return new DictOperator("CIDCount", OperandType.Number, 8720f);
                    case 35:
                        return new DictOperator("UIDBase", OperandType.Number, null);
                    case 36:
                        return new DictOperator("FDArray", OperandType.Number, null);
                    case 37:
                        return new DictOperator("FDSelect", OperandType.Number, null);
                    case 38:
                        return new DictOperator("FontName", OperandType.SID, null);
                    default:
                        throw new IllegalArgumentException("Unknown DICT operator");
                }
            case 13:
                return new DictOperator("UniqueID", OperandType.Number, null);
            case 14:
                return new DictOperator("XUID", OperandType.Array, null);
            case 15:
                return new DictOperator("charset", OperandType.Number, 0f);
            case 16:
                return new DictOperator("Encoding", OperandType.Number, 0f);
            case 17:
                return new DictOperator("CharStrings", OperandType.Number, null);
            case 18:
                return new DictOperator("Private", OperandType.Array, Array2);
            case 19:
                return new DictOperator("Subrs", OperandType.Number, null);
            case 20:
                return new DictOperator("defaultWidthX", OperandType.Number, 0f);
            case 21:
                return new DictOperator("nominalWidthX", OperandType.Number, 0f);
            default:
                throw new IllegalArgumentException("Unknown DICT operator");
        }
    }

    /*
     * get a variable length real number.
     */
    private float getRealNum() throws IOException {
        boolean EoN = false;    // End of Number
        int i, j, k;
        float f;
        StringBuilder stringBuilder = new StringBuilder();
        while(!EoN) {
            i = getCard8();
            for(k = 4; k >= 0; k -= 4) {
                j = (i >> k) & 0xf;
                if(j == 0xf) {
                    EoN = true;
                    break;
                }
                else if(j == 0xe) stringBuilder.append('-');
                else if(j == 0xd)
                    throw new IllegalArgumentException("Unexpected nibble 'd' in a real number object");
                else if(j == 0xc) stringBuilder.append("E-");
                else if(j == 0xb) stringBuilder.append('E');
                else if(j == 0xa) stringBuilder.append('.');
                else stringBuilder.append('0'+j);
            }
        }
        f = Float.parseFloat(stringBuilder.toString());
        return f;
    }

    /*
     * get 1-byte unsigned number (0-255).
     */
    private int getCard8() throws IOException {
        int offset = byteArray.offset;
        int i = byteArray.getByteAt(offset) & 0xff;
        byteArray.setOffset(offset+1);
        return i;
    }

    /*
     * get 2-byte unsigned number (0-65535).
     */
    private int getCard16() throws IOException {
        int offset = byteArray.offset;
        int b1 = byteArray.getByteAt(offset) & 0xff;
        int b2 = byteArray.getByteAt(offset+1) & 0xff;
        int i = (b1 << 8) | b2;
        byteArray.setOffset(offset+2);
        return i;
    }

    /*
     * get 1,2,3 or 4-byte offset.
     */
    private long getOffset(int offSize) throws IOException {
        int offset = byteArray.offset;
        long i = 0;
        for(int j = 0; j < offSize; j++) {
            i <<= 8;
            i |= (byteArray.getByteAt(offset+j) & 0xff);
        }
        byteArray.setOffset(offset+offSize);
        return i;
    }

    /*
     * get 2-byte string identifier - SID (0-64999).
     */
    private int getSID() throws IOException {
        return getCard16();
    }
}
