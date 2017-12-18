package net.laylacp.pdflib.graphics;

import net.laylacp.pdflib.core.PDFDict;
import net.laylacp.pdflib.core.PDFDocument;
import net.laylacp.pdflib.core.PDFObject;
import net.laylacp.pdflib.core.PDFObjectStream;
import net.laylacp.pdflib.core.types.ObjectId;
import net.laylacp.pdflib.reader.PDFByteArray;
import net.laylacp.pdflib.reader.PDFReader;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class PDFFont {
    /*
     * Fonts are distinguished by their Subtypes, not Types.
     * SEE Table 110 – Font types, page 253.
     */
    public static final int TYPE0_FONT = 0;
    public static final int TYPE1_FONT = 1;
    public static final int MMTYPE1_FONT = 2;
    public static final int TYPE3_FONT = 3;
    public static final int TRUETYPE_FONT = 4;
    public static final int CIDTYPE0_FONT = 5;
    public static final int CIDTYPE2_FONT = 6;
    public static final int UNKNOWN_FONT = 7;

    /*
     * Standard Type 1 fonts (14 of them). SEE page 256 of PDF 1.7 Std.
     */
    public static String[] stdFontNames = {
            "Times-Roman", "Helvetica",  "Courier",  "Symbol",  "Times-Bold",
            "Helvetica-Bold",  "Courier-Bold",  "ZapfDingbats",  "Times-Italic",
            "Helvetica-Oblique", "Courier-Oblique", "Times-BoldItalic",
            "Helvetica-BoldOblique", "Courier-BoldOblique"
    };

    // some member vars
    private PDFDocument pdfDocument;
    private int type;
    private int size;
    private String baseFont;
    //private String encoding;
    private PDFFontEncoding encoding;
    private int firstChar;
    private int lastChar;
    private int[] widthArray;
    private HashMap<Integer, Integer> widthArrayType0Font;
    private PDFFontDescriptor fontDescriptor;
    //specific for Type 3 fonts
    private AffineTransform fontMatrix;
    private HashMap<String, PDFObject> charProcs;
    // cache for fonts (of different sizes) we created from this one
    private HashMap<Integer, Font> fontOfSize = new HashMap<>();
    // this is obsolete field as per PDF standard, but we use it to sort out the cache
    private String fontName;

    public int getType() { return type; }

    public static PDFFont getPDFFont(String fontName, HashMap<String, PDFObject> resources,
                                     PDFDocument pdfDocument) {
        // get the Fonts dictionary from Resources
        PDFObject object = PDFDict.getDictionaryEntry(resources, "Font", null);
        if(object == null) return null;
        HashMap<String, PDFObject> fonts;
        fonts = object.getDictionaryValueNoFail(pdfDocument);
        // now get the font object
        object = fonts.get(fontName);
        if(object != null) {
            return readFontDictionary(fontName,
                        object.getDictionaryValueNoFail(pdfDocument), pdfDocument);
        }
        return null;
    }

    private static ArrayList<PDFFont> fontCache = new ArrayList<>();

    private static PDFFont readFontDictionary(String fontName,
                                              HashMap<String, PDFObject> dictionary,
                                              PDFDocument pdfDocument) {
        // get the BaseFont name (PS name)
        String baseFont = PDFDict.getStringDictEntry(dictionary, "BaseFont");
        // get the subtype
        String subtype = PDFDict.getStringDictEntry(dictionary, "Subtype");
        int type = UNKNOWN_FONT;
        if(subtype.equals("Type0")) type = TYPE0_FONT;
        else if(subtype.equals("Type1")) type = TYPE1_FONT;
        else if(subtype.equals("MMType1")) type = MMTYPE1_FONT;
        else if(subtype.equals("Type3")) type = TYPE3_FONT;
        else if(subtype.equals("TrueType")) type = TRUETYPE_FONT;
        else if(subtype.equals("CIDFontType0")) type = CIDTYPE0_FONT;
        else if(subtype.equals("CIDFontType2")) type = CIDTYPE2_FONT;
        else type = UNKNOWN_FONT;

        for(PDFFont font : fontCache) {
            if(font.baseFont.equalsIgnoreCase(baseFont) && font.type == type &&
                    font.fontName.equalsIgnoreCase(fontName))
                return font;
        }

        PDFFont pdfFont = new PDFFont();
        pdfFont.pdfDocument = pdfDocument;
        pdfFont.baseFont = baseFont;
        pdfFont.fontName =fontName;
        pdfFont.type = type;
        if(type == TYPE3_FONT) {
            ArrayList<PDFObject> matrix = PDFDict.getArrayDictEntry(dictionary, "FontMatrix");
            if(matrix.size() >= 6) {
                float[] m = new float[6];
                for(int i = 0; i < 6; i++)
                    m[i] = (float) matrix.get(i).getNumericValue();
                pdfFont.fontMatrix = new AffineTransform(m);
            } else {
                pdfFont.fontMatrix = new AffineTransform(0.001, 0, 0, 0.001, 0, 0);
            }
            PDFObject charProcsObj = dictionary.get("CharProcs");
            if(charProcsObj.getType() == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
                PDFObjectStream charProcsStream = pdfDocument.reader.
                        getObjectStreamById(charProcsObj.getIdValue(), pdfDocument);
                pdfFont.charProcs = charProcsStream.dictionary;
            } else if(charProcsObj.getType() == PDFObject.OBJECT_TYPE.DICTIONARY_OBJECT) {
                pdfFont.charProcs = (HashMap<String, PDFObject>) charProcsObj.getValue();
            }
        }

        // first char in the Widths array
        pdfFont.firstChar = PDFDict.getIntDictEntry(dictionary, "FirstChar");
        // last char in the Widths array
        pdfFont.lastChar = PDFDict.getIntDictEntry(dictionary, "LastChar");

        /*
         * TODO: we should check the Flags and if font is Symbolic, ignore Encoding entirely.
         *       SEE page 267 of PDF 1.7.
         */
        // Font encoding:
        // do we have a CMap stream that maps char codes to Unicode?
        // if so, use it to directly map char codes to UTF16.
        // otherwise, look at the encoding entry, if present.
        // SEE 9.10.2 Mapping Character Codes to Unicode Values, page 292.
        ObjectId toUnicodeId = PDFDict.getIndirectRefDictEntry(dictionary, "ToUnicode");
        if (!toUnicodeId.equals(PDFDict.invalidObjectId)) {
            pdfFont.encoding = new PDFFontEncoding(toUnicodeId, pdfDocument);
        } else {
            PDFObject encObj = dictionary.get("Encoding");
            if (encObj == null) {
                pdfFont.encoding = new PDFFontEncoding("StandardEncoding");
            } else {
                if (type == TYPE0_FONT) {
                    /*
                     * get CMap and CIDFont (see 9.7 Composite Fonts, page 267).
                     * SEE also Table 121 – Entries in a Type 0 font dictionary, page 280.
                     */
                    pdfFont.encoding = new PDFFontEncoding(encObj, pdfDocument);
                    ArrayList<PDFObject> array = PDFDict.getArrayDictEntry(dictionary, "DescendantFonts");
                    ObjectId descFontId = array.get(0).getIdValue();

                } else {
                    PDFObject.OBJECT_TYPE encType = encObj.getType();
                    if (encType == PDFObject.OBJECT_TYPE.STRING_OBJECT ||
                            encType == PDFObject.OBJECT_TYPE.NAME_OBJECT) {
                        // name of a predefined encoding, e.g. WinAnsiEncoding
                        pdfFont.encoding = new PDFFontEncoding(encObj.getStringValue());
                    } else if (encType == PDFObject.OBJECT_TYPE.DICTIONARY_OBJECT ||
                            encType == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
                        // dictionary that contains the Differences array
                        pdfFont.encoding = new PDFFontEncoding(encObj.getDictionaryValueNoFail(pdfDocument),
                                (pdfFont.type == TYPE3_FONT), pdfDocument);
                    } else {
                        // failsafe. but it is safe?
                        pdfFont.encoding = new PDFFontEncoding("StandardEncoding");
                    }
                }
            }
        }

        if(type == TYPE0_FONT) {
            ObjectId descFontId = null;
            PDFObject object = dictionary.get("DescendantFonts");
            if(object != null) {
                ArrayList<PDFObject> array = object.getArrayValueNoFail(pdfDocument);
                descFontId = array.get(0).getIdValue();
                PDFObjectStream descFont = pdfDocument.reader.getObjectStreamById(descFontId, pdfDocument);
                HashMap<String, PDFObject> cidFontDict = descFont.dictionary;

                object = PDFDict.getDictionaryEntry(cidFontDict, "FontDescriptor", null);
                if (object != null) {
                    HashMap<String, PDFObject> fontDescriptor = object.getDictionaryValueNoFail(pdfDocument);
                    pdfFont.readFontDescriptor(fontDescriptor);
                    if(pdfFont.fontDescriptor.fontFile != null) {
                        String descFontType = PDFDict.getStringDictEntry(cidFontDict, "Subtype");
                        if(descFontType.equalsIgnoreCase("CIDFontType2")) {
                            pdfFont.fontDescriptor.fontFileFormat = TRUETYPE_FONT;
                        } else {
                            /*
                             * TODO: handle Type 0 (which are CCF-based) fonts
                             */
                        }
                    }
                } else {
                    PDFFontDescriptor pdfFontDescriptor = new PDFFontDescriptor();
                    pdfFont.fontDescriptor = pdfFontDescriptor;
                    pdfFont.fontDescriptor.fontFamily = baseFont;
                    if (baseFont.contains("Italic"))
                        pdfFont.fontDescriptor.flags |= PDFFontDescriptor.FLAG_ITALIC;
                    if (baseFont.contains("Bold"))
                        pdfFont.fontDescriptor.flags |= PDFFontDescriptor.FLAG_FORCEBOLD;
                }

                int DW = PDFDict.getIntDictEntry(cidFontDict, "DW");
                if (DW == -1) DW = 1000;
                pdfFont.fontDescriptor.missingWidth = DW;

                object = cidFontDict.get("W");
                if(object != null) {
                    ArrayList<PDFObject> W = object.getArrayValueNoFail(pdfDocument);
                    int len = W.size();
                    pdfFont.widthArrayType0Font = new HashMap<>();
                    for(int i = 0; i < len; i++) {
                        object = W.get(i);
                        PDFObject object1 = W.get(i+1);
                        int cid = object.getIntValue();
                        if(object1.getType() == PDFObject.OBJECT_TYPE.ARRAY_OBJECT) {
                            // first format
                            ArrayList<PDFObject> lengths = object1.getArrayValue();
                            int len2 = lengths.size();
                            for(int j = 0; j < len2; j++) {
                                PDFObject object2 = lengths.get(j);
                                pdfFont.widthArrayType0Font.put(cid, object2.getIntValue());
                                cid++;
                            }
                            i++;
                        } else {
                            // second format
                            int cid2 = object1.getIntValue();
                            PDFObject object2 = W.get(i+2);
                            int width = object2.getIntValue();
                            for(int j = cid; j <= cid2; j++) {
                                pdfFont.widthArrayType0Font.put(j, width);
                            }
                            i += 2;
                        }
                    }
                }

            }
        } else {
            // get the Widths array
            PDFObject widths = PDFDict.getDictionaryEntry(dictionary, "Widths", null);
            if (widths != null) {
                ArrayList<PDFObject> array = widths.getArrayValueNoFail(pdfDocument);
                if (array.size() != pdfFont.lastChar - pdfFont.firstChar + 1) return null;
                pdfFont.widthArray = new int[array.size()];
                int i = 0;
                for (PDFObject object : array) {
                    pdfFont.widthArray[i++] = object.getIntValue();
                }
            }
        /*
         * TODO: Finish this.
         * SEE Table 111 – Entries in a Type 1 font dictionary, page 254-255.
         */
            PDFObject object = PDFDict.getDictionaryEntry(dictionary, "FontDescriptor", null);
            if (object != null) {
                HashMap<String, PDFObject> fontDescriptor = object.getDictionaryValueNoFail(pdfDocument);
                if (fontDescriptor.size() == 0) {
                    if (pdfFont.type == TYPE1_FONT || pdfFont.type == MMTYPE1_FONT) {
                        for (int i = 0; i < stdFontNames.length; i++) {
                            if (baseFont.equalsIgnoreCase(stdFontNames[i])) {
                                /*
                                 * TODO: load standard font metrics.
                                 */
                            }
                        }
                    }
                } else pdfFont.readFontDescriptor(fontDescriptor);
            } else {
                /*
                 * TODO: do something!!!
                 */
                PDFFontDescriptor pdfFontDescriptor = new PDFFontDescriptor();
                pdfFont.fontDescriptor = pdfFontDescriptor;
            }
        }
        fontCache.add(pdfFont);
        return pdfFont;
    }

    private void readFontDescriptor(HashMap<String, PDFObject> dictionary) {
        PDFFontDescriptor pdfFontDescriptor = new PDFFontDescriptor();
        pdfFontDescriptor.fontName = PDFDict.getStringDictEntry(dictionary, "FontName");
        pdfFontDescriptor.fontFamily = PDFDict.getStringDictEntry(dictionary, "FontFamily");

        String s = PDFDict.getStringDictEntry(dictionary, "FontStretch");
        if(s.equalsIgnoreCase("UltraCondensed"))
            pdfFontDescriptor.fontStretch = TextAttribute.WIDTH_CONDENSED;
        else if(s.equalsIgnoreCase("ExtraCondensed"))
            pdfFontDescriptor.fontStretch = TextAttribute.WIDTH_CONDENSED;
        else if(s.equalsIgnoreCase("Condensed") ||
                s.equalsIgnoreCase("SemiCondensed"))
            pdfFontDescriptor.fontStretch = TextAttribute.WIDTH_SEMI_CONDENSED;
        else if(s.equalsIgnoreCase("Normal"))
            pdfFontDescriptor.fontStretch = TextAttribute.WIDTH_REGULAR;
        else if(s.equalsIgnoreCase("SemiExpanded"))
            pdfFontDescriptor.fontStretch = TextAttribute.WIDTH_SEMI_EXTENDED;
        else if(s.equalsIgnoreCase("Expanded"))
            pdfFontDescriptor.fontStretch = TextAttribute.WIDTH_SEMI_EXTENDED;
        else if(s.equalsIgnoreCase("ExtraExpanded"))
            pdfFontDescriptor.fontStretch = TextAttribute.WIDTH_EXTENDED;
        else if(s.equalsIgnoreCase("UltraExpanded"))
            pdfFontDescriptor.fontStretch = TextAttribute.WIDTH_EXTENDED;
        else pdfFontDescriptor.fontStretch = TextAttribute.WIDTH_REGULAR;

        int i = PDFDict.getIntDictEntry(dictionary, "FontWeight");
        if(i == 100) pdfFontDescriptor.fontWeight = TextAttribute.WEIGHT_EXTRA_LIGHT;
        else if(i == 200) pdfFontDescriptor.fontWeight = TextAttribute.WEIGHT_LIGHT;
        else if(i == 300) pdfFontDescriptor.fontWeight = TextAttribute.WEIGHT_DEMILIGHT;
        else if(i == 400) pdfFontDescriptor.fontWeight = TextAttribute.WEIGHT_REGULAR;
        else if(i == 500) pdfFontDescriptor.fontWeight = TextAttribute.WEIGHT_SEMIBOLD;
        else if(i == 600) pdfFontDescriptor.fontWeight = TextAttribute.WEIGHT_MEDIUM;
        else if(i == 700) pdfFontDescriptor.fontWeight = TextAttribute.WEIGHT_BOLD;
        else if(i == 800) pdfFontDescriptor.fontWeight = TextAttribute.WEIGHT_HEAVY;
        else if(i == 900) pdfFontDescriptor.fontWeight = TextAttribute.WEIGHT_ULTRABOLD;
        else pdfFontDescriptor.fontWeight = TextAttribute.WEIGHT_REGULAR;

        pdfFontDescriptor.flags = PDFDict.getIntDictEntry(dictionary, "Flags");
        pdfFontDescriptor.fontBBox = PDFDict.getRectangleDictEntry(dictionary, "FontBBox");
        pdfFontDescriptor.italicAngle = (float)PDFDict.getRealDictEntry(dictionary, "ItalicAngle");
        pdfFontDescriptor.ascent = (float)PDFDict.getRealDictEntry(dictionary, "Ascent");
        pdfFontDescriptor.descent = (float)PDFDict.getRealDictEntry(dictionary, "Descent");
        pdfFontDescriptor.leading = (float)PDFDict.getRealDictEntry(dictionary, "Leading");
        pdfFontDescriptor.capHeight = (float)PDFDict.getRealDictEntry(dictionary, "CapHeight");
        pdfFontDescriptor.xHeight = (float)PDFDict.getRealDictEntry(dictionary, "XHeight");
        pdfFontDescriptor.stemV = (float)PDFDict.getRealDictEntry(dictionary, "StemV");
        pdfFontDescriptor.stemH = (float)PDFDict.getRealDictEntry(dictionary, "StemH");
        pdfFontDescriptor.avgWidth = (float)PDFDict.getRealDictEntry(dictionary, "AvgWidth");
        pdfFontDescriptor.maxWidth = (float)PDFDict.getRealDictEntry(dictionary, "MaxWidth");
        pdfFontDescriptor.missingWidth = (float)PDFDict.getRealDictEntry(dictionary, "MissingWidth");

        /*
         * SEE Table 126 – Embedded font organization for various font types, page 289.
         */
        ObjectId fileId = PDFDict.getIndirectRefDictEntry(dictionary, "FontFile");
        if(fileId.equals(PDFDict.invalidObjectId)) {
            fileId = PDFDict.getIndirectRefDictEntry(dictionary, "FontFile2");
            if(fileId.equals(PDFDict.invalidObjectId)) {
                fileId = PDFDict.getIndirectRefDictEntry(dictionary, "FontFile3");
            } else pdfFontDescriptor.fontFileFormat = TRUETYPE_FONT;
        } else pdfFontDescriptor.fontFileFormat = TYPE1_FONT;

        // check if it is one of the Standard 14 fonts
        if(fileId.equals(PDFDict.invalidObjectId)) {
            if(baseFont.startsWith("Times-Roman") || baseFont.startsWith("Times-") ||
                    baseFont.startsWith("Times New Roman")) {
                pdfFontDescriptor.fontFamily = "Times New Roman";
            } else if(baseFont.startsWith("Courier")) {
                pdfFontDescriptor.fontFamily = "Courier";
            } else if(baseFont.startsWith("Helvetica")) {
                pdfFontDescriptor.fontFamily = "Helvetica";
            } else if(baseFont.startsWith("Symbol")) {
                pdfFontDescriptor.fontFamily = "Symbol";
            } else if(baseFont.startsWith("ZapfDingbats")) {
                pdfFontDescriptor.fontFamily = "ZapfDingbats";
            } else {
                pdfFontDescriptor.fontFamily = "Times New Roman";
            }

            if (baseFont.contains("Italic"))
                pdfFontDescriptor.flags |= PDFFontDescriptor.FLAG_ITALIC;
            if (baseFont.contains("Bold"))
                pdfFontDescriptor.flags |= PDFFontDescriptor.FLAG_FORCEBOLD;

        } else /* if(type != TYPE0_FONT) */ {
            pdfFontDescriptor.fontFile = pdfDocument.reader.getObjectStreamById(fileId, pdfDocument);
        }
        pdfFontDescriptor.charSet = PDFDict.getStringDictEntry(dictionary, "CharSet");
        this.fontDescriptor = pdfFontDescriptor;
    }

    public Font getFont(int size) {
        // check the cache first
        Font f = fontOfSize.get(size);
        if(f != null) return f;

        //size = 1;
        if(fontDescriptor.fontFile != null) {
            InputStream is = new ByteArrayInputStream(fontDescriptor.fontFile.stream.data);
                try {
                    Font font = null;
                    if (fontDescriptor.fontFileFormat == TYPE1_FONT) {
                        font = Font.createFont(Font.TYPE1_FONT, is);
                    } else if (fontDescriptor.fontFileFormat == TRUETYPE_FONT) {
                        font = Font.createFont(Font.TRUETYPE_FONT, is);
                        // flip the font upside down
                        AffineTransform newCTM = AffineTransform.getScaleInstance(1, -1);
                        font = font.deriveFont(newCTM);
                    }
                    if(font != null) {
                        font = font.deriveFont((float) size);
                        fontOfSize.put(size, font);
                        return font;
                    }
                } catch (FontFormatException | IOException e) {
                    e.printStackTrace();
                }
        }
        /*
         * TODO: other types of fonts.
         * SEE FontFile3 entry on Table 122 – Entries common to all font descriptors,
         *     page 283.
         */
        Map<TextAttribute, Object> attributes = new HashMap<>();
        attributes.put(TextAttribute.FAMILY, fontDescriptor.fontFamily);
        if(fontDescriptor.isFlagSet(fontDescriptor.FLAG_FIXEDPITCH))
            attributes.put(TextAttribute.FAMILY, Font.MONOSPACED);
        else if(fontDescriptor.isFlagSet(fontDescriptor.FLAG_SERIF))
            attributes.put(TextAttribute.FAMILY, Font.SERIF);

        attributes.put(TextAttribute.WIDTH, fontDescriptor.fontStretch);
        if(fontDescriptor.isFlagSet(fontDescriptor.FLAG_FORCEBOLD) &&
                fontDescriptor.fontWeight <= TextAttribute.WEIGHT_REGULAR)
             attributes.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_DEMIBOLD);
        else attributes.put(TextAttribute.WEIGHT, fontDescriptor.fontWeight);

        if(fontDescriptor.italicAngle != 0)
            attributes.put(TextAttribute.POSTURE, 1/fontDescriptor.italicAngle);
        else if(fontDescriptor.isFlagSet(fontDescriptor.FLAG_ITALIC))
            attributes.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);

        attributes.put(TextAttribute.SIZE, size);
        //attributes.put(TextAttribute.TRACKING, textState.getCharSpace());
        Font font = Font.getFont(attributes);

        // flip the font upside down
        AffineTransform newCTM = AffineTransform.getScaleInstance(1, -1);
        font = font.deriveFont(newCTM);

        fontOfSize.put(size, font);
        return font;
    }

    public int getCharWidth(int charCode) {
        if(type == TYPE0_FONT) {
            return widthArrayType0Font.get(charCode);
        }

        System.out.println("charCode = " + charCode + ", firstChar = " + firstChar + ", lastChar = " + lastChar);
        if(charCode < firstChar || charCode > lastChar)
            return (int) fontDescriptor.missingWidth;
        // type 3 widths are expressed in the glyph space, not text space. we should use the
        // font martix to make our conversion, not blindly divide by 1000.
        // SEE Table 112 – Entries in a Type 3 font dictionary, page 259.
        if(type == TYPE3_FONT)
            return widthArray[charCode-firstChar]/1000;
        System.out.println("charWidth = " + widthArray[charCode-firstChar]);
        if(widthArray[charCode-firstChar] == 0) {
            widthArray[charCode-firstChar] = widthArray[charCode-firstChar];
        }
        return widthArray[charCode-firstChar];
    }

    public int getHeight() {
        return (int) (fontDescriptor.ascent+fontDescriptor.descent);
    }

    public float getAscent() {
        return fontDescriptor.ascent;
    }

    public void setFontSize(int size) {
        //this.size = 1;
        this.size = size;
    }

    /*
    public int getUtf(int charCode) {
        int charUtf = encoding.charCodeToUtf(charCode);
        return charUtf;
    }
    */

    public String getUtf(int charCode) {
        String charUtf = encoding.charCodeToUtf(charCode);
        return charUtf;
    }

    public Shape glyphDraw(PDFDraw pdfDraw, int charCode, int renderMode) {
        Graphics2D canvas = pdfDraw.getCanvas();
        if(type == TYPE3_FONT) {
            //glyphDrawType3Font(pdfDraw, charCode);
            return null;
        }

        String s = encoding.charCodeToUtf(charCode);

        //PDFReader.__DEBUG__("getGlyphShape", "s = '" + s + "', at = " + canvas.getTransform().toString());
        PDFReader.__DEBUG__("glyphDraw", "s = '" + s + "', code = " + charCode
                /* + ", utf = " + charUtf */);

        Shape result = null;

        if(renderMode == TextState.RENDER_FILL) {
            canvas.drawString(s, 0, 0);
            //Shape glyph = getGlyphShape(pdfDraw, charCode);
            //canvas.fill(glyph);
        } else if(renderMode == TextState.RENDER_STROKE) {
            //Shape glyph = getGlyphShape(pdfDraw, charCode);
            Shape glyph = getGlyphShape(pdfDraw, s);
            canvas.draw(glyph);
        } else if(renderMode == TextState.RENDER_FILL_STROKE) {
            //Shape glyph = getGlyphShape(pdfDraw, charCode);
            Shape glyph = getGlyphShape(pdfDraw, s);
            canvas.drawString(s, 0, 0);
            //canvas.fill(glyph);
            canvas.draw(glyph);
        } else if(renderMode == TextState.RENDER_NONE) {
            ;
        } else if(renderMode == TextState.RENDER_FILL_CLIP) {
            //Shape glyph = getGlyphShape(pdfDraw, charCode);
            Shape glyph = getGlyphShape(pdfDraw, s);
            canvas.drawString(s, 0, 0);
            //canvas.fill(glyph);
            //clip.append(glyph, true);
            result = glyph;
        } else if(renderMode == TextState.RENDER_STROKE_CLIP) {
            //Shape glyph = getGlyphShape(pdfDraw, charCode);
            Shape glyph = getGlyphShape(pdfDraw, s);
            canvas.draw(glyph);
            //clip.append(glyph, true);
            result = glyph;
        } else if(renderMode == TextState.RENDER_FILL_STROKE_CLIP) {
            //Shape glyph = getGlyphShape(pdfDraw, charCode);
            Shape glyph = getGlyphShape(pdfDraw, s);
            canvas.drawString(s, 0, 0);
            //canvas.fill(glyph);
            canvas.draw(glyph);
            //clip.append(glyph, true);
            result = glyph;
        } else if(renderMode == TextState.RENDER_CLIP) {
            //Shape glyph = getGlyphShape(pdfDraw, charCode);
            Shape glyph = getGlyphShape(pdfDraw, s);
            //clip.append(glyph, true);
            result = glyph;
        }

        return result;
    }

    public Shape getGlyphShape(PDFDraw pdfDraw, String s /* int charCode */) {
        Graphics2D canvas = pdfDraw.getCanvas();
        if(type == TYPE3_FONT) {
            return getGlyphShapeType3Font(pdfDraw, s /* charCode */);
        }
        //int charUtf = encoding.charCodeToUtf(charCode);
        Font font = getFont(size);
        FontRenderContext frc = canvas.getFontRenderContext();
        PDFReader.__DEBUG__("getGlyphShape", "s = '" + s + "', at = " + canvas.getTransform().toString());
        TextLayout textTl = new TextLayout(s, font, frc);
        Shape outline = textTl.getOutline(null);
        return outline;
    }

    /*
     * SEE Table 113 – Type 3 font operators, page 260.
     */
    private Shape getGlyphShapeType3Font(PDFDraw pdfDraw, String s /* int charCode */) {
        return null;
        /*
        String glyphName = encoding.charCodeToGlyphName(charCode);
        if(glyphName.isEmpty()) return null;

        // get the content stream associated with this glyph
        ObjectId streamId = PDFDict.getIndirectRefDictEntry(charProcs, glyphName);
        if(streamId.equals(PDFDict.invalidObjectId)) return null;
        PDFObjectStream glyphStream = pdfDocument.reader.getObjectStreamById(streamId, pdfDocument);
        if(glyphStream == null) return null;

        // draw the glyph
        pdfDraw.pushGraphicsState();

        PDFByteArray oldByteArray = pdfDocument.reader.byteArray;
        pdfDocument.reader.byteArray = glyphStream.stream;

        AffineTransform at = pdfDraw.getCurState().getCTM();
        at.concatenate(fontMatrix);
        pdfDraw.setCurSubPath(null);
        pdfDraw.setCurPoint(null);
        pdfDraw.setCurPath(new Path2D.Double());
        pdfDraw.parse(pdfDocument.reader);
        Shape glyph = pdfDraw.getCurPath();

        // restore everything
        pdfDraw.popGraphicsState();
        pdfDocument.reader.byteArray = oldByteArray;
        return glyph;
        */
    }
}
