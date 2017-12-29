/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: PDFFontDescriptor.java
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

import net.laylacp.pdflib.core.PDFObjectStream;

import java.awt.font.TextAttribute;

public class PDFFontDescriptor implements Cloneable {
    /*
     * SEE Table 122 – Entries common to all font descriptors, page 281.
     */
    public String fontName;     // PS font name
    public String fontFamily;
    public Float fontStretch;
    public Float fontWeight;      // 100, 200, 300, 400,  500,  600,  700,  800, or 900
    public int flags;
    public Rectangle fontBBox;
    public Float italicAngle;
    public float ascent;
    public float descent;
    public float leading;
    public float capHeight;
    public float xHeight;
    public float stemV;
    public float stemH;
    public float avgWidth;
    public float maxWidth;
    public float missingWidth;
    public PDFObjectStream fontFile;
    public int fontFileFormat;
    public String charSet;

    /*
     * values for the 'flags' field (SEE Table 123 – Font flags).
     */
    public static final int FLAG_FIXEDPITCH = (1 << 0);
    public static final int FLAG_SERIF = (1 << 1);
    public static final int FLAG_SYMBOLIC = (1 << 2);
    public static final int FLAG_SCRIPT = (1 << 3);
    public static final int FLAG_NONSYMBOLIC = (1 << 5);
    public static final int FLAG_ITALIC = (1 << 6);
    public static final int FLAG_ALLCAP = (1 << 16);
    public static final int FLAG_SMALLCAP = (1 << 17);
    public static final int FLAG_FORCEBOLD = (1 << 18);


    public PDFFontDescriptor() {
        this.italicAngle = 0.0F;
        this.ascent = 0;
        this.descent = 0;
        this.leading = 0;
        this.capHeight = 0;
        this.xHeight = 0;
        this.stemH = 0;
        this.stemV = 0;
        this.flags = 0;
        this.fontBBox = new Rectangle(0, 0, 0, 0);
        this.fontWeight = TextAttribute.WEIGHT_REGULAR;
        this.fontStretch = TextAttribute.WEIGHT_REGULAR;
        this.fontFamily = "";
        this.fontName = "";
        this.avgWidth = 0;
        this.maxWidth = 0;
        this.missingWidth = 0;
        this.charSet = "";
        this.fontFile = null;
    }

    public boolean isFlagSet(int flag) {
        return (flags & flag) == flag;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object obj = super.clone(); //utilize clone Object method
        PDFFontDescriptor pdfFontDescriptor = (PDFFontDescriptor) obj;

        pdfFontDescriptor.italicAngle = this.italicAngle;
        pdfFontDescriptor.ascent = this.ascent;
        pdfFontDescriptor.descent = this.descent;
        pdfFontDescriptor.leading = this.leading;
        pdfFontDescriptor.capHeight = this.capHeight;
        pdfFontDescriptor.xHeight = this.xHeight;
        pdfFontDescriptor.stemH = this.stemH;
        pdfFontDescriptor.stemV = this.stemV;
        pdfFontDescriptor.flags = this.flags;
        pdfFontDescriptor.fontBBox = this.fontBBox;
        pdfFontDescriptor.fontWeight = this.fontWeight;
        pdfFontDescriptor.fontStretch = this.fontStretch;
        pdfFontDescriptor.fontFamily = this.fontFamily;
        pdfFontDescriptor.fontName = this.fontName;
        pdfFontDescriptor.avgWidth = this.avgWidth;
        pdfFontDescriptor.maxWidth = this.maxWidth;
        pdfFontDescriptor.missingWidth = this.missingWidth;
        pdfFontDescriptor.charSet = this.charSet;
        pdfFontDescriptor.fontFile = this.fontFile;
        pdfFontDescriptor.fontFileFormat = this.fontFileFormat;

        return pdfFontDescriptor;
    }
}