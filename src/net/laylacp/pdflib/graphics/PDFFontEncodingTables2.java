/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: PDFFontEncodingTables2.java
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

import java.util.HashMap;

public class PDFFontEncodingTables2 {

    /*
 * based on http://www.unicode.org/Public/MAPPINGS/VENDORS/APPLE/ROMAN.TXT
 */
    public static String[] MacRomanEncoding = {
            "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "", "", "",
            "\u0020", // SPACE
            "\u0021", // EXCLAMATION MARK
            "\"", // QUOTATION MARK
            "\u0023", // NUMBER SIGN
            "\u0024", // DOLLAR SIGN
            "\u0025", // PERCENT SIGN
            "\u0026", // AMPERSAND
            "\u0027", // APOSTROPHE
            "\u0028", // LEFT PARENTHESIS
            "\u0029", // RIGHT PARENTHESIS
            "\u002A", // ASTERISK
            "\u002B", // PLUS SIGN
            "\u002C", // COMMA
            "\u002D", // HYPHEN-MINUS
            "\u002E", // FULL STOP
            "\u002F", // SOLIDUS
            "\u0030", // DIGIT ZERO
            "\u0031", // DIGIT ONE
            "\u0032", // DIGIT TWO
            "\u0033", // DIGIT THREE
            "\u0034", // DIGIT FOUR
            "\u0035", // DIGIT FIVE
            "\u0036", // DIGIT SIX
            "\u0037", // DIGIT SEVEN
            "\u0038", // DIGIT EIGHT
            "\u0039", // DIGIT NINE
            "\u003A", // COLON
            "\u003B", // SEMICOLON
            "\u003C", // LESS-THAN SIGN
            "\u003D", // EQUALS SIGN
            "\u003E", // GREATER-THAN SIGN
            "\u003F", // QUESTION MARK
            "\u0040", // COMMERCIAL AT
            "\u0041", // LATIN CAPITAL LETTER A
            "\u0042", // LATIN CAPITAL LETTER B
            "\u0043", // LATIN CAPITAL LETTER C
            "\u0044", // LATIN CAPITAL LETTER D
            "\u0045", // LATIN CAPITAL LETTER E
            "\u0046", // LATIN CAPITAL LETTER F
            "\u0047", // LATIN CAPITAL LETTER G
            "\u0048", // LATIN CAPITAL LETTER H
            "\u0049", // LATIN CAPITAL LETTER I
            "\u004A", // LATIN CAPITAL LETTER J
            "\u004B", // LATIN CAPITAL LETTER K
            "\u004C", // LATIN CAPITAL LETTER L
            "\u004D", // LATIN CAPITAL LETTER M
            "\u004E", // LATIN CAPITAL LETTER N
            "\u004F", // LATIN CAPITAL LETTER O
            "\u0050", // LATIN CAPITAL LETTER P
            "\u0051", // LATIN CAPITAL LETTER Q
            "\u0052", // LATIN CAPITAL LETTER R
            "\u0053", // LATIN CAPITAL LETTER S
            "\u0054", // LATIN CAPITAL LETTER T
            "\u0055", // LATIN CAPITAL LETTER U
            "\u0056", // LATIN CAPITAL LETTER V
            "\u0057", // LATIN CAPITAL LETTER W
            "\u0058", // LATIN CAPITAL LETTER X
            "\u0059", // LATIN CAPITAL LETTER Y
            "\u005A", // LATIN CAPITAL LETTER Z
            "\u005B", // LEFT SQUARE BRACKET
            "\\", // REVERSE SOLIDUS
            "\u005D", // RIGHT SQUARE BRACKET
            "\u005E", // CIRCUMFLEX ACCENT
            "\u005F", // LOW LINE
            "\u0060", // GRAVE ACCENT
            "\u0061", // LATIN SMALL LETTER A
            "\u0062", // LATIN SMALL LETTER B
            "\u0063", // LATIN SMALL LETTER C
            "\u0064", // LATIN SMALL LETTER D
            "\u0065", // LATIN SMALL LETTER E
            "\u0066", // LATIN SMALL LETTER F
            "\u0067", // LATIN SMALL LETTER G
            "\u0068", // LATIN SMALL LETTER H
            "\u0069", // LATIN SMALL LETTER I
            "\u006A", // LATIN SMALL LETTER J
            "\u006B", // LATIN SMALL LETTER K
            "\u006C", // LATIN SMALL LETTER L
            "\u006D", // LATIN SMALL LETTER M
            "\u006E", // LATIN SMALL LETTER N
            "\u006F", // LATIN SMALL LETTER O
            "\u0070", // LATIN SMALL LETTER P
            "\u0071", // LATIN SMALL LETTER Q
            "\u0072", // LATIN SMALL LETTER R
            "\u0073", // LATIN SMALL LETTER S
            "\u0074", // LATIN SMALL LETTER T
            "\u0075", // LATIN SMALL LETTER U
            "\u0076", // LATIN SMALL LETTER V
            "\u0077", // LATIN SMALL LETTER W
            "\u0078", // LATIN SMALL LETTER X
            "\u0079", // LATIN SMALL LETTER Y
            "\u007A", // LATIN SMALL LETTER Z
            "\u007B", // LEFT CURLY BRACKET
            "\u007C", // VERTICAL LINE
            "\u007D", // RIGHT CURLY BRACKET
            "\u007E", // TILDE
            "", // 0x7F = UNDEFINED
            "\u00C4", // LATIN CAPITAL LETTER A WITH DIAERESIS
            "\u00C5", // LATIN CAPITAL LETTER A WITH RING ABOVE
            "\u00C7", // LATIN CAPITAL LETTER C WITH CEDILLA
            "\u00C9", // LATIN CAPITAL LETTER E WITH ACUTE
            "\u00D1", // LATIN CAPITAL LETTER N WITH TILDE
            "\u00D6", // LATIN CAPITAL LETTER O WITH DIAERESIS
            "\u00DC", // LATIN CAPITAL LETTER U WITH DIAERESIS
            "\u00E1", // LATIN SMALL LETTER A WITH ACUTE
            "\u00E0", // LATIN SMALL LETTER A WITH GRAVE
            "\u00E2", // LATIN SMALL LETTER A WITH CIRCUMFLEX
            "\u00E4", // LATIN SMALL LETTER A WITH DIAERESIS
            "\u00E3", // LATIN SMALL LETTER A WITH TILDE
            "\u00E5", // LATIN SMALL LETTER A WITH RING ABOVE
            "\u00E7", // LATIN SMALL LETTER C WITH CEDILLA
            "\u00E9", // LATIN SMALL LETTER E WITH ACUTE
            "\u00E8", // LATIN SMALL LETTER E WITH GRAVE
            "\u00EA", // LATIN SMALL LETTER E WITH CIRCUMFLEX
            "\u00EB", // LATIN SMALL LETTER E WITH DIAERESIS
            "\u00ED", // LATIN SMALL LETTER I WITH ACUTE
            "\u00EC", // LATIN SMALL LETTER I WITH GRAVE
            "\u00EE", // LATIN SMALL LETTER I WITH CIRCUMFLEX
            "\u00EF", // LATIN SMALL LETTER I WITH DIAERESIS
            "\u00F1", // LATIN SMALL LETTER N WITH TILDE
            "\u00F3", // LATIN SMALL LETTER O WITH ACUTE
            "\u00F2", // LATIN SMALL LETTER O WITH GRAVE
            "\u00F4", // LATIN SMALL LETTER O WITH CIRCUMFLEX
            "\u00F6", // LATIN SMALL LETTER O WITH DIAERESIS
            "\u00F5", // LATIN SMALL LETTER O WITH TILDE
            "\u00FA", // LATIN SMALL LETTER U WITH ACUTE
            "\u00F9", // LATIN SMALL LETTER U WITH GRAVE
            "\u00FB", // LATIN SMALL LETTER U WITH CIRCUMFLEX
            "\u00FC", // LATIN SMALL LETTER U WITH DIAERESIS
            "\u2020", // DAGGER
            "\u00B0", // DEGREE SIGN
            "\u00A2", // CENT SIGN
            "\u00A3", // POUND SIGN
            "\u00A7", // SECTION SIGN
            "\u2022", // BULLET
            "\u00B6", // PILCROW SIGN
            "\u00DF", // LATIN SMALL LETTER SHARP S
            "\u00AE", // REGISTERED SIGN
            "\u00A9", // COPYRIGHT SIGN
            "\u2122", // TRADE MARK SIGN
            "\u00B4", // ACUTE ACCENT
            "\u00A8", // DIAERESIS
            "\u2260", // NOT EQUAL TO
            "\u00C6", // LATIN CAPITAL LETTER AE
            "\u00D8", // LATIN CAPITAL LETTER O WITH STROKE
            "\u221E", // INFINITY
            "\u00B1", // PLUS-MINUS SIGN
            "\u2264", // LESS-THAN OR EQUAL TO
            "\u2265", // GREATER-THAN OR EQUAL TO
            "\u00A5", // YEN SIGN
            "\u00B5", // MICRO SIGN
            "\u2202", // PARTIAL DIFFERENTIAL
            "\u2211", // N-ARY SUMMATION
            "\u220F", // N-ARY PRODUCT
            "\u03C0", // GREEK SMALL LETTER PI
            "\u222B", // INTEGRAL
            "\u00AA", // FEMININE ORDINAL INDICATOR
            "\u00BA", // MASCULINE ORDINAL INDICATOR
            "\u03A9", // GREEK CAPITAL LETTER OMEGA
            "\u00E6", // LATIN SMALL LETTER AE
            "\u00F8", // LATIN SMALL LETTER O WITH STROKE
            "\u00BF", // INVERTED QUESTION MARK
            "\u00A1", // INVERTED EXCLAMATION MARK
            "\u00AC", // NOT SIGN
            "\u221A", // SQUARE ROOT
            "\u0192", // LATIN SMALL LETTER F WITH HOOK
            "\u2248", // ALMOST EQUAL TO
            "\u2206", // INCREMENT
            "\u00AB", // LEFT-POINTING DOUBLE ANGLE QUOTATION MARK
            "\u00BB", // RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK
            "\u2026", // HORIZONTAL ELLIPSIS
            "\u00A0", // NO-BREAK SPACE
            "\u00C0", // LATIN CAPITAL LETTER A WITH GRAVE
            "\u00C3", // LATIN CAPITAL LETTER A WITH TILDE
            "\u00D5", // LATIN CAPITAL LETTER O WITH TILDE
            "\u0152", // LATIN CAPITAL LIGATURE OE
            "\u0153", // LATIN SMALL LIGATURE OE
            "\u2013", // EN DASH
            "\u2014", // EM DASH
            "\u201C", // LEFT DOUBLE QUOTATION MARK
            "\u201D", // RIGHT DOUBLE QUOTATION MARK
            "\u2018", // LEFT SINGLE QUOTATION MARK
            "\u2019", // RIGHT SINGLE QUOTATION MARK
            "\u00F7", // DIVISION SIGN
            "\u25CA", // LOZENGE
            "\u00FF", // LATIN SMALL LETTER Y WITH DIAERESIS
            "\u0178", // LATIN CAPITAL LETTER Y WITH DIAERESIS
            "\u2044", // FRACTION SLASH
            "\u20AC", // EURO SIGN
            "\u2039", // SINGLE LEFT-POINTING ANGLE QUOTATION MARK
            "\u203A", // SINGLE RIGHT-POINTING ANGLE QUOTATION MARK
            "\uFB01", // LATIN SMALL LIGATURE FI
            "\uFB02", // LATIN SMALL LIGATURE FL
            "\u2021", // DOUBLE DAGGER
            "\u00B7", // MIDDLE DOT
            "\u201A", // SINGLE LOW-9 QUOTATION MARK
            "\u201E", // DOUBLE LOW-9 QUOTATION MARK
            "\u2030", // PER MILLE SIGN
            "\u00C2", // LATIN CAPITAL LETTER A WITH CIRCUMFLEX
            "\u00CA", // LATIN CAPITAL LETTER E WITH CIRCUMFLEX
            "\u00C1", // LATIN CAPITAL LETTER A WITH ACUTE
            "\u00CB", // LATIN CAPITAL LETTER E WITH DIAERESIS
            "\u00C8", // LATIN CAPITAL LETTER E WITH GRAVE
            "\u00CD", // LATIN CAPITAL LETTER I WITH ACUTE
            "\u00CE", // LATIN CAPITAL LETTER I WITH CIRCUMFLEX
            "\u00CF", // LATIN CAPITAL LETTER I WITH DIAERESIS
            "\u00CC", // LATIN CAPITAL LETTER I WITH GRAVE
            "\u00D3", // LATIN CAPITAL LETTER O WITH ACUTE
            "\u00D4", // LATIN CAPITAL LETTER O WITH CIRCUMFLEX
            "\uF8FF", // Apple logo
            "\u00D2", // LATIN CAPITAL LETTER O WITH GRAVE
            "\u00DA", // LATIN CAPITAL LETTER U WITH ACUTE
            "\u00DB", // LATIN CAPITAL LETTER U WITH CIRCUMFLEX
            "\u00D9", // LATIN CAPITAL LETTER U WITH GRAVE
            "\u0131", // LATIN SMALL LETTER DOTLESS I
            "\u02C6", // MODIFIER LETTER CIRCUMFLEX ACCENT
            "\u02DC", // SMALL TILDE
            "\u00AF", // MACRON
            "\u02D8", // BREVE
            "\u02D9", // DOT ABOVE
            "\u02DA", // RING ABOVE
            "\u00B8", // CEDILLA
            "\u02DD", // DOUBLE ACUTE ACCENT
            "\u02DB", // OGONEK
            "\u02C7", // CARON
    };

    /*
     * CP1252, based on https://www.unicode.org/Public/MAPPINGS/VENDORS/MICSFT/WINDOWS/CP1252.TXT
     */
    public static final String[] WinAnsiEncoding = {
            "", //NULL
            "\u0001", //START OF HEADING
            "\u0002", //START OF TEXT
            "\u0003", //END OF TEXT
            "\u0004", //END OF TRANSMISSION
            "\u0005", //ENQUIRY
            "\u0006", //ACKNOWLEDGE
            "\u0007", //BELL
            "\u0008", //BACKSPACE
            "\u0009", //HORIZONTAL TABULATION
            "\n", //LINE FEED
            "\u000B", //VERTICAL TABULATION
            "\u000C", //FORM FEED
            "\r", //CARRIAGE RETURN
            "\u000E", //SHIFT OUT
            "\u000F", //SHIFT IN
            "\u0010", //DATA LINK ESCAPE
            "\u0011", //DEVICE CONTROL ONE
            "\u0012", //DEVICE CONTROL TWO
            "\u0013", //DEVICE CONTROL THREE
            "\u0014", //DEVICE CONTROL FOUR
            "\u0015", //NEGATIVE ACKNOWLEDGE
            "\u0016", //SYNCHRONOUS IDLE
            "\u0017", //END OF TRANSMISSION BLOCK
            "\u0018", //CANCEL
            "\u0019", //END OF MEDIUM
            "\u001A", //SUBSTITUTE
            "\u001B", //ESCAPE
            "\u001C", //FILE SEPARATOR
            "\u001D", //GROUP SEPARATOR
            "\u001E", //RECORD SEPARATOR
            "\u001F", //UNIT SEPARATOR
            "\u0020", //SPACE
            "\u0021", //EXCLAMATION MARK
            "\"", //QUOTATION MARK
            "\u0023", //NUMBER SIGN
            "\u0024", //DOLLAR SIGN
            "\u0025", //PERCENT SIGN
            "\u0026", //AMPERSAND
            "\u0027", //APOSTROPHE
            "\u0028", //LEFT PARENTHESIS
            "\u0029", //RIGHT PARENTHESIS
            "\u002A", //ASTERISK
            "\u002B", //PLUS SIGN
            "\u002C", //COMMA
            "\u002D", //HYPHEN-MINUS
            "\u002E", //FULL STOP
            "\u002F", //SOLIDUS
            "\u0030", //DIGIT ZERO
            "\u0031", //DIGIT ONE
            "\u0032", //DIGIT TWO
            "\u0033", //DIGIT THREE
            "\u0034", //DIGIT FOUR
            "\u0035", //DIGIT FIVE
            "\u0036", //DIGIT SIX
            "\u0037", //DIGIT SEVEN
            "\u0038", //DIGIT EIGHT
            "\u0039", //DIGIT NINE
            "\u003A", //COLON
            "\u003B", //SEMICOLON
            "\u003C", //LESS-THAN SIGN
            "\u003D", //EQUALS SIGN
            "\u003E", //GREATER-THAN SIGN
            "\u003F", //QUESTION MARK
            "\u0040", //COMMERCIAL AT
            "\u0041", //LATIN CAPITAL LETTER A
            "\u0042", //LATIN CAPITAL LETTER B
            "\u0043", //LATIN CAPITAL LETTER C
            "\u0044", //LATIN CAPITAL LETTER D
            "\u0045", //LATIN CAPITAL LETTER E
            "\u0046", //LATIN CAPITAL LETTER F
            "\u0047", //LATIN CAPITAL LETTER G
            "\u0048", //LATIN CAPITAL LETTER H
            "\u0049", //LATIN CAPITAL LETTER I
            "\u004A", //LATIN CAPITAL LETTER J
            "\u004B", //LATIN CAPITAL LETTER K
            "\u004C", //LATIN CAPITAL LETTER L
            "\u004D", //LATIN CAPITAL LETTER M
            "\u004E", //LATIN CAPITAL LETTER N
            "\u004F", //LATIN CAPITAL LETTER O
            "\u0050", //LATIN CAPITAL LETTER P
            "\u0051", //LATIN CAPITAL LETTER Q
            "\u0052", //LATIN CAPITAL LETTER R
            "\u0053", //LATIN CAPITAL LETTER S
            "\u0054", //LATIN CAPITAL LETTER T
            "\u0055", //LATIN CAPITAL LETTER U
            "\u0056", //LATIN CAPITAL LETTER V
            "\u0057", //LATIN CAPITAL LETTER W
            "\u0058", //LATIN CAPITAL LETTER X
            "\u0059", //LATIN CAPITAL LETTER Y
            "\u005A", //LATIN CAPITAL LETTER Z
            "\u005B", //LEFT SQUARE BRACKET
            "\\", //REVERSE SOLIDUS
            "\u005D", //RIGHT SQUARE BRACKET
            "\u005E", //CIRCUMFLEX ACCENT
            "\u005F", //LOW LINE
            "\u0060", //GRAVE ACCENT
            "\u0061", //LATIN SMALL LETTER A
            "\u0062", //LATIN SMALL LETTER B
            "\u0063", //LATIN SMALL LETTER C
            "\u0064", //LATIN SMALL LETTER D
            "\u0065", //LATIN SMALL LETTER E
            "\u0066", //LATIN SMALL LETTER F
            "\u0067", //LATIN SMALL LETTER G
            "\u0068", //LATIN SMALL LETTER H
            "\u0069", //LATIN SMALL LETTER I
            "\u006A", //LATIN SMALL LETTER J
            "\u006B", //LATIN SMALL LETTER K
            "\u006C", //LATIN SMALL LETTER L
            "\u006D", //LATIN SMALL LETTER M
            "\u006E", //LATIN SMALL LETTER N
            "\u006F", //LATIN SMALL LETTER O
            "\u0070", //LATIN SMALL LETTER P
            "\u0071", //LATIN SMALL LETTER Q
            "\u0072", //LATIN SMALL LETTER R
            "\u0073", //LATIN SMALL LETTER S
            "\u0074", //LATIN SMALL LETTER T
            "\u0075", //LATIN SMALL LETTER U
            "\u0076", //LATIN SMALL LETTER V
            "\u0077", //LATIN SMALL LETTER W
            "\u0078", //LATIN SMALL LETTER X
            "\u0079", //LATIN SMALL LETTER Y
            "\u007A", //LATIN SMALL LETTER Z
            "\u007B", //LEFT CURLY BRACKET
            "\u007C", //VERTICAL LINE
            "\u007D", //RIGHT CURLY BRACKET
            "\u007E", //TILDE
            "\u007F", //DELETE
            "\u20AC", //EURO SIGN
            "", // 0x81 = UNDEFINED
            "\u201A", //SINGLE LOW-9 QUOTATION MARK
            "\u0192", //LATIN SMALL LETTER F WITH HOOK
            "\u201E", //DOUBLE LOW-9 QUOTATION MARK
            "\u2026", //HORIZONTAL ELLIPSIS
            "\u2020", //DAGGER
            "\u2021", //DOUBLE DAGGER
            "\u02C6", //MODIFIER LETTER CIRCUMFLEX ACCENT
            "\u2030", //PER MILLE SIGN
            "\u0160", //LATIN CAPITAL LETTER S WITH CARON
            "\u2039", //SINGLE LEFT-POINTING ANGLE QUOTATION MARK
            "\u0152", //LATIN CAPITAL LIGATURE OE
            "", // 0x8D = UNDEFINED
            "\u017D", //LATIN CAPITAL LETTER Z WITH CARON
            "", // 0x8F = UNDEFINED
            "", // 0x90 = UNDEFINED
            "\u2018", //LEFT SINGLE QUOTATION MARK
            "\u2019", //RIGHT SINGLE QUOTATION MARK
            "\u201C", //LEFT DOUBLE QUOTATION MARK
            "\u201D", //RIGHT DOUBLE QUOTATION MARK
            "\u2022", //BULLET
            "\u2013", //EN DASH
            "\u2014", //EM DASH
            "\u02DC", //SMALL TILDE
            "\u2122", //TRADE MARK SIGN
            "\u0161", //LATIN SMALL LETTER S WITH CARON
            "\u203A", //SINGLE RIGHT-POINTING ANGLE QUOTATION MARK
            "\u0153", //LATIN SMALL LIGATURE OE
            "", // 0x9D = UNDEFINED
            "\u017E", //LATIN SMALL LETTER Z WITH CARON
            "\u0178", //LATIN CAPITAL LETTER Y WITH DIAERESIS
            "\u00A0", //NO-BREAK SPACE
            "\u00A1", //INVERTED EXCLAMATION MARK
            "\u00A2", //CENT SIGN
            "\u00A3", //POUND SIGN
            "\u00A4", //CURRENCY SIGN
            "\u00A5", //YEN SIGN
            "\u00A6", //BROKEN BAR
            "\u00A7", //SECTION SIGN
            "\u00A8", //DIAERESIS
            "\u00A9", //COPYRIGHT SIGN
            "\u00AA", //FEMININE ORDINAL INDICATOR
            "\u00AB", //LEFT-POINTING DOUBLE ANGLE QUOTATION MARK
            "\u00AC", //NOT SIGN
            "\u00AD", //SOFT HYPHEN
            "\u00AE", //REGISTERED SIGN
            "\u00AF", //MACRON
            "\u00B0", //DEGREE SIGN
            "\u00B1", //PLUS-MINUS SIGN
            "\u00B2", //SUPERSCRIPT TWO
            "\u00B3", //SUPERSCRIPT THREE
            "\u00B4", //ACUTE ACCENT
            "\u00B5", //MICRO SIGN
            "\u00B6", //PILCROW SIGN
            "\u00B7", //MIDDLE DOT
            "\u00B8", //CEDILLA
            "\u00B9", //SUPERSCRIPT ONE
            "\u00BA", //MASCULINE ORDINAL INDICATOR
            "\u00BB", //RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK
            "\u00BC", //VULGAR FRACTION ONE QUARTER
            "\u00BD", //VULGAR FRACTION ONE HALF
            "\u00BE", //VULGAR FRACTION THREE QUARTERS
            "\u00BF", //INVERTED QUESTION MARK
            "\u00C0", //LATIN CAPITAL LETTER A WITH GRAVE
            "\u00C1", //LATIN CAPITAL LETTER A WITH ACUTE
            "\u00C2", //LATIN CAPITAL LETTER A WITH CIRCUMFLEX
            "\u00C3", //LATIN CAPITAL LETTER A WITH TILDE
            "\u00C4", //LATIN CAPITAL LETTER A WITH DIAERESIS
            "\u00C5", //LATIN CAPITAL LETTER A WITH RING ABOVE
            "\u00C6", //LATIN CAPITAL LETTER AE
            "\u00C7", //LATIN CAPITAL LETTER C WITH CEDILLA
            "\u00C8", //LATIN CAPITAL LETTER E WITH GRAVE
            "\u00C9", //LATIN CAPITAL LETTER E WITH ACUTE
            "\u00CA", //LATIN CAPITAL LETTER E WITH CIRCUMFLEX
            "\u00CB", //LATIN CAPITAL LETTER E WITH DIAERESIS
            "\u00CC", //LATIN CAPITAL LETTER I WITH GRAVE
            "\u00CD", //LATIN CAPITAL LETTER I WITH ACUTE
            "\u00CE", //LATIN CAPITAL LETTER I WITH CIRCUMFLEX
            "\u00CF", //LATIN CAPITAL LETTER I WITH DIAERESIS
            "\u00D0", //LATIN CAPITAL LETTER ETH
            "\u00D1", //LATIN CAPITAL LETTER N WITH TILDE
            "\u00D2", //LATIN CAPITAL LETTER O WITH GRAVE
            "\u00D3", //LATIN CAPITAL LETTER O WITH ACUTE
            "\u00D4", //LATIN CAPITAL LETTER O WITH CIRCUMFLEX
            "\u00D5", //LATIN CAPITAL LETTER O WITH TILDE
            "\u00D6", //LATIN CAPITAL LETTER O WITH DIAERESIS
            "\u00D7", //MULTIPLICATION SIGN
            "\u00D8", //LATIN CAPITAL LETTER O WITH STROKE
            "\u00D9", //LATIN CAPITAL LETTER U WITH GRAVE
            "\u00DA", //LATIN CAPITAL LETTER U WITH ACUTE
            "\u00DB", //LATIN CAPITAL LETTER U WITH CIRCUMFLEX
            "\u00DC", //LATIN CAPITAL LETTER U WITH DIAERESIS
            "\u00DD", //LATIN CAPITAL LETTER Y WITH ACUTE
            "\u00DE", //LATIN CAPITAL LETTER THORN
            "\u00DF", //LATIN SMALL LETTER SHARP S
            "\u00E0", //LATIN SMALL LETTER A WITH GRAVE
            "\u00E1", //LATIN SMALL LETTER A WITH ACUTE
            "\u00E2", //LATIN SMALL LETTER A WITH CIRCUMFLEX
            "\u00E3", //LATIN SMALL LETTER A WITH TILDE
            "\u00E4", //LATIN SMALL LETTER A WITH DIAERESIS
            "\u00E5", //LATIN SMALL LETTER A WITH RING ABOVE
            "\u00E6", //LATIN SMALL LETTER AE
            "\u00E7", //LATIN SMALL LETTER C WITH CEDILLA
            "\u00E8", //LATIN SMALL LETTER E WITH GRAVE
            "\u00E9", //LATIN SMALL LETTER E WITH ACUTE
            "\u00EA", //LATIN SMALL LETTER E WITH CIRCUMFLEX
            "\u00EB", //LATIN SMALL LETTER E WITH DIAERESIS
            "\u00EC", //LATIN SMALL LETTER I WITH GRAVE
            "\u00ED", //LATIN SMALL LETTER I WITH ACUTE
            "\u00EE", //LATIN SMALL LETTER I WITH CIRCUMFLEX
            "\u00EF", //LATIN SMALL LETTER I WITH DIAERESIS
            "\u00F0", //LATIN SMALL LETTER ETH
            "\u00F1", //LATIN SMALL LETTER N WITH TILDE
            "\u00F2", //LATIN SMALL LETTER O WITH GRAVE
            "\u00F3", //LATIN SMALL LETTER O WITH ACUTE
            "\u00F4", //LATIN SMALL LETTER O WITH CIRCUMFLEX
            "\u00F5", //LATIN SMALL LETTER O WITH TILDE
            "\u00F6", //LATIN SMALL LETTER O WITH DIAERESIS
            "\u00F7", //DIVISION SIGN
            "\u00F8", //LATIN SMALL LETTER O WITH STROKE
            "\u00F9", //LATIN SMALL LETTER U WITH GRAVE
            "\u00FA", //LATIN SMALL LETTER U WITH ACUTE
            "\u00FB", //LATIN SMALL LETTER U WITH CIRCUMFLEX
            "\u00FC", //LATIN SMALL LETTER U WITH DIAERESIS
            "\u00FD", //LATIN SMALL LETTER Y WITH ACUTE
            "\u00FE", //LATIN SMALL LETTER THORN
            "\u00FF", //LATIN SMALL LETTER Y WITH DIAERESIS
    };

    /*
     * based on https://www.unicode.org/Public/MAPPINGS/VENDORS/ADOBE/stdenc.txt.
     */
    public static final String[] StandardEncoding = {
            "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "", "", "",
            "\u0020", // SPACE	, space
//00A0	, // NO-BREAK SPACE	, space
            "\u0021", // EXCLAMATION MARK	", // exclam
            "\"", // QUOTATION MARK	", // quotedbl
            "\u0023", // NUMBER SIGN	", // numbersign
            "\u0024", // DOLLAR SIGN	", // dollar
            "\u0025", // PERCENT SIGN	", // percent
            "\u0026", // AMPERSAND	", // ampersand
            "\u2019", // RIGHT SINGLE QUOTATION MARK	", // quoteright
            "\u0028", // LEFT PARENTHESIS	", // parenleft
            "\u0029", // RIGHT PARENTHESIS	", // parenright
            "\u002A", // ASTERISK	", // asterisk
            "\u002B", // PLUS SIGN	", // plus
            "\u002C", // COMMA	", // comma
            "\u002D", // HYPHEN-MINUS	", // hyphen
//00AD		", // SOFT HYPHEN	", // hyphen
            "\u002E", // FULL STOP	", // period
            "\u002F", // SOLIDUS	", // slash
            "\u0030", // DIGIT ZERO	", // zero
            "\u0031", // DIGIT ONE	", // one
            "\u0032", // DIGIT TWO	", // two
            "\u0033", // DIGIT THREE	", // three
            "\u0034", // DIGIT FOUR	", // four
            "\u0035", // DIGIT FIVE	", // five
            "\u0036", // DIGIT SIX	", // six
            "\u0037", // DIGIT SEVEN	", // seven
            "\u0038", // DIGIT EIGHT	", // eight
            "\u0039", // DIGIT NINE	", // nine
            "\u003A", // COLON	", // colon
            "\u003B", // SEMICOLON	", // semicolon
            "\u003C", // LESS-THAN SIGN	", // less
            "\u003D", // EQUALS SIGN	", // equal
            "\u003E", // GREATER-THAN SIGN	", // greater
            "\u003F", // QUESTION MARK	", // question
            "\u0040", // COMMERCIAL AT	", // at
            "\u0041", // LATIN CAPITAL LETTER A	", // A
            "\u0042", // LATIN CAPITAL LETTER B	", // B
            "\u0043", // LATIN CAPITAL LETTER C	", // C
            "\u0044", // LATIN CAPITAL LETTER D	", // D
            "\u0045", // LATIN CAPITAL LETTER E	", // E
            "\u0046", // LATIN CAPITAL LETTER F	", // F
            "\u0047", // LATIN CAPITAL LETTER G	", // G
            "\u0048", // LATIN CAPITAL LETTER H	", // H
            "\u0049", // LATIN CAPITAL LETTER I	", // I
            "\u004A", // LATIN CAPITAL LETTER J	", // J
            "\u004B", // LATIN CAPITAL LETTER K	", // K
            "\u004C", // LATIN CAPITAL LETTER L	", // L
            "\u004D", // LATIN CAPITAL LETTER M	", // M
            "\u004E", // LATIN CAPITAL LETTER N	", // N
            "\u004F", // LATIN CAPITAL LETTER O	", // O
            "\u0050", // LATIN CAPITAL LETTER P	", // P
            "\u0051", // LATIN CAPITAL LETTER Q	", // Q
            "\u0052", // LATIN CAPITAL LETTER R	", // R
            "\u0053", // LATIN CAPITAL LETTER S	", // S
            "\u0054", // LATIN CAPITAL LETTER T	", // T
            "\u0055", // LATIN CAPITAL LETTER U	", // U
            "\u0056", // LATIN CAPITAL LETTER V	", // V
            "\u0057", // LATIN CAPITAL LETTER W	", // W
            "\u0058", // LATIN CAPITAL LETTER X	", // X
            "\u0059", // LATIN CAPITAL LETTER Y	", // Y
            "\u005A", // LATIN CAPITAL LETTER Z	", // Z
            "\u005B", // LEFT SQUARE BRACKET	", // bracketleft
            "\u005C", // REVERSE SOLIDUS	", // backslash
            "\u005D", // RIGHT SQUARE BRACKET	", // bracketright
            "\u005E", // CIRCUMFLEX ACCENT	", // asciicircum
            "\u005F", // LOW LINE	", // underscore
            "\u2018", // LEFT SINGLE QUOTATION MARK	", // quoteleft
            "\u0061", // LATIN SMALL LETTER A	", // a
            "\u0062", // LATIN SMALL LETTER B	", // b
            "\u0063", // LATIN SMALL LETTER C	", // c
            "\u0064", // LATIN SMALL LETTER D	", // d
            "\u0065", // LATIN SMALL LETTER E	", // e
            "\u0066", // LATIN SMALL LETTER F	", // f
            "\u0067", // LATIN SMALL LETTER G	", // g
            "\u0068", // LATIN SMALL LETTER H	", // h
            "\u0069", // LATIN SMALL LETTER I	", // i
            "\u006A", // LATIN SMALL LETTER J	", // j
            "\u006B", // LATIN SMALL LETTER K	", // k
            "\u006C", // LATIN SMALL LETTER L	", // l
            "\u006D", // LATIN SMALL LETTER M	", // m
            "\u006E", // LATIN SMALL LETTER N	", // n
            "\u006F", // LATIN SMALL LETTER O	", // o
            "\u0070", // LATIN SMALL LETTER P	", // p
            "\u0071", // LATIN SMALL LETTER Q	", // q
            "\u0072", // LATIN SMALL LETTER R	", // r
            "\u0073", // LATIN SMALL LETTER S	", // s
            "\u0074", // LATIN SMALL LETTER T	", // t
            "\u0075", // LATIN SMALL LETTER U	", // u
            "\u0076", // LATIN SMALL LETTER V	", // v
            "\u0077", // LATIN SMALL LETTER W	", // w
            "\u0078", // LATIN SMALL LETTER X	", // x
            "\u0079", // LATIN SMALL LETTER Y	", // y
            "\u007A", // LATIN SMALL LETTER Z	", // z
            "\u007B", // LEFT CURLY BRACKET	", // braceleft
            "\u007C", // VERTICAL LINE	", // bar
            "\u007D", // RIGHT CURLY BRACKET	", // braceright
            "\u007E", // TILDE	", // asciitilde
            "", "", "", "", "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "", "", "", "", "", "", "", "", "",
            "", "", "", "", "", "",
            "\u00A1", // INVERTED EXCLAMATION MARK	", // exclamdown
            "\u00A2", // CENT SIGN	", // cent
            "\u00A3", // POUND SIGN	", // sterling
            "\u2044", // FRACTION SLASH	", // fraction
//2215	A4	", // DIVISION SLASH	", // fraction
            "\u00A5", // YEN SIGN	", // yen
            "\u0192", // LATIN SMALL LETTER F WITH HOOK	", // florin
            "\u00A7", // SECTION SIGN	", // section
            "\u00A4", // CURRENCY SIGN	", // currency
            "\u0027", // APOSTROPHE	", // quotesingle
            "\u201C", // LEFT DOUBLE QUOTATION MARK	", // quotedblleft
            "\u00AB", // LEFT-POINTING DOUBLE ANGLE QUOTATION MARK	", // guillemotleft
            "\u2039", // SINGLE LEFT-POINTING ANGLE QUOTATION MARK	", // guilsinglleft
            "\u203A", // SINGLE RIGHT-POINTING ANGLE QUOTATION MARK	", // guilsinglright
            "\uFB01", // LATIN SMALL LIGATURE FI	", // fi
            "\uFB02", // LATIN SMALL LIGATURE FL	", // fl
            "",
            "\u2013", // EN DASH	", // endash
            "\u2020", // DAGGER	", // dagger
            "\u2021", // DOUBLE DAGGER	", // daggerdbl
            "\u00B7", // MIDDLE DOT	", // periodcentered
//2219	B4	", // BULLET OPERATOR	", // periodcentered
            "",
            "\u00B6", // PILCROW SIGN	", // paragraph
            "\u2022", // BULLET	", // bullet
            "\u201A", // SINGLE LOW-9 QUOTATION MARK	", // quotesinglbase
            "\u201E", // DOUBLE LOW-9 QUOTATION MARK	", // quotedblbase
            "\u201D", // RIGHT DOUBLE QUOTATION MARK	", // quotedblright
            "\u00BB", // RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK	", // guillemotright
            "\u2026", // HORIZONTAL ELLIPSIS	", // ellipsis
            "\u2030", // PER MILLE SIGN	", // perthousand
            "",
            "\u00BF", // INVERTED QUESTION MARK	", // questiondown
            "",
            "\u0060", // GRAVE ACCENT	", // grave
            "\u00B4", // ACUTE ACCENT	", // acute
            "\u02C6", // MODIFIER LETTER CIRCUMFLEX ACCENT	", // circumflex
            "\u02DC", // SMALL TILDE	", // tilde
            "\u00AF", // MACRON	", // macron
//02C9	C5	", // MODIFIER LETTER MACRON	", // macron
            "\u02D8", // BREVE	", // breve
            "\u02D9", // DOT ABOVE	", // dotaccent
            "\u00A8", // DIAERESIS	", // dieresis
            "",
            "\u02DA", // RING ABOVE	", // ring
            "\u00B8", // CEDILLA	", // cedilla
            "",
            "\u02DD", // DOUBLE ACUTE ACCENT	", // hungarumlaut
            "\u02DB", // OGONEK	", // ogonek
            "\u02C7", // CARON	", // caron
            "\u2014", // EM DASH	", // emdash
            "", "", "", "", "", "", "", "", "", "", "", "", "", "",
            "", "",
            "\u00C6", // LATIN CAPITAL LETTER AE	", // AE
            "",
            "\u00AA", // FEMININE ORDINAL INDICATOR	", // ordfeminine
            "", "", "", "",
            "\u0141", // LATIN CAPITAL LETTER L WITH STROKE	", // Lslash
            "\u00D8", // LATIN CAPITAL LETTER O WITH STROKE	", // Oslash
            "\u0152", // LATIN CAPITAL LIGATURE OE	", // OE
            "\u00BA", // MASCULINE ORDINAL INDICATOR	", // ordmasculine
            "", "", "", "", "",
            "\u00E6", // LATIN SMALL LETTER AE	", // ae
            "", "", "",
            "\u0131", // LATIN SMALL LETTER DOTLESS I	", // dotlessi
            "", "",
            "\u0142", // LATIN SMALL LETTER L WITH STROKE	", // lslash
            "\u00F8", // LATIN SMALL LETTER O WITH STROKE	", // oslash
            "\u0153", // LATIN SMALL LIGATURE OE	", // oe
            "\u00DF", // LATIN SMALL LETTER SHARP S	", // germandbls
            "", "", "", "",
    };


    public static HashMap<String, String> getAdobeGlyphList() {
      HashMap<String, String> glyphList = new HashMap<>();

      /*
       * based on https://raw.githubusercontent.com/adobe-type-tools/agl-aglfn/master/glyphlist.txt.
       */
      glyphList.put("A", "\u0041");
      glyphList.put("AE", "\u00C6");
      glyphList.put("AEacute", "\u01FC");
      glyphList.put("AEmacron", "\u01E2");
      glyphList.put("AEsmall", "\uF7E6");
      glyphList.put("Aacute", "\u00C1");
      glyphList.put("Aacutesmall", "\uF7E1");
      glyphList.put("Abreve", "\u0102");
      glyphList.put("Abreveacute", "\u1EAE");
      glyphList.put("Abrevecyrillic", "\u04D0");
      glyphList.put("Abrevedotbelow", "\u1EB6");
      glyphList.put("Abrevegrave", "\u1EB0");
      glyphList.put("Abrevehookabove", "\u1EB2");
      glyphList.put("Abrevetilde", "\u1EB4");
      glyphList.put("Acaron", "\u01CD");
      glyphList.put("Acircle", "\u24B6");
      glyphList.put("Acircumflex", "\u00C2");
      glyphList.put("Acircumflexacute", "\u1EA4");
      glyphList.put("Acircumflexdotbelow", "\u1EAC");
      glyphList.put("Acircumflexgrave", "\u1EA6");
      glyphList.put("Acircumflexhookabove", "\u1EA8");
      glyphList.put("Acircumflexsmall", "\uF7E2");
      glyphList.put("Acircumflextilde", "\u1EAA");
      glyphList.put("Acute", "\uF6C9");
      glyphList.put("Acutesmall", "\uF7B4");
      glyphList.put("Acyrillic", "\u0410");
      glyphList.put("Adblgrave", "\u0200");
      glyphList.put("Adieresis", "\u00C4");
      glyphList.put("Adieresiscyrillic", "\u04D2");
      glyphList.put("Adieresismacron", "\u01DE");
      glyphList.put("Adieresissmall", "\uF7E4");
      glyphList.put("Adotbelow", "\u1EA0");
      glyphList.put("Adotmacron", "\u01E0");
      glyphList.put("Agrave", "\u00C0");
      glyphList.put("Agravesmall", "\uF7E0");
      glyphList.put("Ahookabove", "\u1EA2");
      glyphList.put("Aiecyrillic", "\u04D4");
      glyphList.put("Ainvertedbreve", "\u0202");
      glyphList.put("Alpha", "\u0391");
      glyphList.put("Alphatonos", "\u0386");
      glyphList.put("Amacron", "\u0100");
      glyphList.put("Amonospace", "\uFF21");
      glyphList.put("Aogonek", "\u0104");
      glyphList.put("Aring", "\u00C5");
      glyphList.put("Aringacute", "\u01FA");
      glyphList.put("Aringbelow", "\u1E00");
      glyphList.put("Aringsmall", "\uF7E5");
      glyphList.put("Asmall", "\uF761");
      glyphList.put("Atilde", "\u00C3");
      glyphList.put("Atildesmall", "\uF7E3");
      glyphList.put("Aybarmenian", "\u0531");
      glyphList.put("B", "\u0042");
      glyphList.put("Bcircle", "\u24B7");
      glyphList.put("Bdotaccent", "\u1E02");
      glyphList.put("Bdotbelow", "\u1E04");
      glyphList.put("Becyrillic", "\u0411");
      glyphList.put("Benarmenian", "\u0532");
      glyphList.put("Beta", "\u0392");
      glyphList.put("Bhook", "\u0181");
      glyphList.put("Blinebelow", "\u1E06");
      glyphList.put("Bmonospace", "\uFF22");
      glyphList.put("Brevesmall", "\uF6F4");
      glyphList.put("Bsmall", "\uF762");
      glyphList.put("Btopbar", "\u0182");
      glyphList.put("C", "\u0043");
      glyphList.put("Caarmenian", "\u053E");
      glyphList.put("Cacute", "\u0106");
      glyphList.put("Caron", "\uF6CA");
      glyphList.put("Caronsmall", "\uF6F5");
      glyphList.put("Ccaron", "\u010C");
      glyphList.put("Ccedilla", "\u00C7");
      glyphList.put("Ccedillaacute", "\u1E08");
      glyphList.put("Ccedillasmall", "\uF7E7");
      glyphList.put("Ccircle", "\u24B8");
      glyphList.put("Ccircumflex", "\u0108");
      glyphList.put("Cdot", "\u010A");
      glyphList.put("Cdotaccent", "\u010A");
      glyphList.put("Cedillasmall", "\uF7B8");
      glyphList.put("Chaarmenian", "\u0549");
      glyphList.put("Cheabkhasiancyrillic", "\u04BC");
      glyphList.put("Checyrillic", "\u0427");
      glyphList.put("Chedescenderabkhasiancyrillic", "\u04BE");
      glyphList.put("Chedescendercyrillic", "\u04B6");
      glyphList.put("Chedieresiscyrillic", "\u04F4");
      glyphList.put("Cheharmenian", "\u0543");
      glyphList.put("Chekhakassiancyrillic", "\u04CB");
      glyphList.put("Cheverticalstrokecyrillic", "\u04B8");
      glyphList.put("Chi", "\u03A7");
      glyphList.put("Chook", "\u0187");
      glyphList.put("Circumflexsmall", "\uF6F6");
      glyphList.put("Cmonospace", "\uFF23");
      glyphList.put("Coarmenian", "\u0551");
      glyphList.put("Csmall", "\uF763");
      glyphList.put("D", "\u0044");
      glyphList.put("DZ", "\u01F1");
      glyphList.put("DZcaron", "\u01C4");
      glyphList.put("Daarmenian", "\u0534");
      glyphList.put("Dafrican", "\u0189");
      glyphList.put("Dcaron", "\u010E");
      glyphList.put("Dcedilla", "\u1E10");
      glyphList.put("Dcircle", "\u24B9");
      glyphList.put("Dcircumflexbelow", "\u1E12");
      glyphList.put("Dcroat", "\u0110");
      glyphList.put("Ddotaccent", "\u1E0A");
      glyphList.put("Ddotbelow", "\u1E0C");
      glyphList.put("Decyrillic", "\u0414");
      glyphList.put("Deicoptic", "\u03EE");
      glyphList.put("Delta", "\u2206");
      glyphList.put("Deltagreek", "\u0394");
      glyphList.put("Dhook", "\u018A");
      glyphList.put("Dieresis", "\uF6CB");
      glyphList.put("DieresisAcute", "\uF6CC");
      glyphList.put("DieresisGrave", "\uF6CD");
      glyphList.put("Dieresissmall", "\uF7A8");
      glyphList.put("Digammagreek", "\u03DC");
      glyphList.put("Djecyrillic", "\u0402");
      glyphList.put("Dlinebelow", "\u1E0E");
      glyphList.put("Dmonospace", "\uFF24");
      glyphList.put("Dotaccentsmall", "\uF6F7");
      glyphList.put("Dslash", "\u0110");
      glyphList.put("Dsmall", "\uF764");
      glyphList.put("Dtopbar", "\u018B");
      glyphList.put("Dz", "\u01F2");
      glyphList.put("Dzcaron", "\u01C5");
      glyphList.put("Dzeabkhasiancyrillic", "\u04E0");
      glyphList.put("Dzecyrillic", "\u0405");
      glyphList.put("Dzhecyrillic", "\u040F");
      glyphList.put("E", "\u0045");
      glyphList.put("Eacute", "\u00C9");
      glyphList.put("Eacutesmall", "\uF7E9");
      glyphList.put("Ebreve", "\u0114");
      glyphList.put("Ecaron", "\u011A");
      glyphList.put("Ecedillabreve", "\u1E1C");
      glyphList.put("Echarmenian", "\u0535");
      glyphList.put("Ecircle", "\u24BA");
      glyphList.put("Ecircumflex", "\u00CA");
      glyphList.put("Ecircumflexacute", "\u1EBE");
      glyphList.put("Ecircumflexbelow", "\u1E18");
      glyphList.put("Ecircumflexdotbelow", "\u1EC6");
      glyphList.put("Ecircumflexgrave", "\u1EC0");
      glyphList.put("Ecircumflexhookabove", "\u1EC2");
      glyphList.put("Ecircumflexsmall", "\uF7EA");
      glyphList.put("Ecircumflextilde", "\u1EC4");
      glyphList.put("Ecyrillic", "\u0404");
      glyphList.put("Edblgrave", "\u0204");
      glyphList.put("Edieresis", "\u00CB");
      glyphList.put("Edieresissmall", "\uF7EB");
      glyphList.put("Edot", "\u0116");
      glyphList.put("Edotaccent", "\u0116");
      glyphList.put("Edotbelow", "\u1EB8");
      glyphList.put("Efcyrillic", "\u0424");
      glyphList.put("Egrave", "\u00C8");
      glyphList.put("Egravesmall", "\uF7E8");
      glyphList.put("Eharmenian", "\u0537");
      glyphList.put("Ehookabove", "\u1EBA");
      glyphList.put("Eightroman", "\u2167");
      glyphList.put("Einvertedbreve", "\u0206");
      glyphList.put("Eiotifiedcyrillic", "\u0464");
      glyphList.put("Elcyrillic", "\u041B");
      glyphList.put("Elevenroman", "\u216A");
      glyphList.put("Emacron", "\u0112");
      glyphList.put("Emacronacute", "\u1E16");
      glyphList.put("Emacrongrave", "\u1E14");
      glyphList.put("Emcyrillic", "\u041C");
      glyphList.put("Emonospace", "\uFF25");
      glyphList.put("Encyrillic", "\u041D");
      glyphList.put("Endescendercyrillic", "\u04A2");
      glyphList.put("Eng", "\u014A");
      glyphList.put("Enghecyrillic", "\u04A4");
      glyphList.put("Enhookcyrillic", "\u04C7");
      glyphList.put("Eogonek", "\u0118");
      glyphList.put("Eopen", "\u0190");
      glyphList.put("Epsilon", "\u0395");
      glyphList.put("Epsilontonos", "\u0388");
      glyphList.put("Ercyrillic", "\u0420");
      glyphList.put("Ereversed", "\u018E");
      glyphList.put("Ereversedcyrillic", "\u042D");
      glyphList.put("Escyrillic", "\u0421");
      glyphList.put("Esdescendercyrillic", "\u04AA");
      glyphList.put("Esh", "\u01A9");
      glyphList.put("Esmall", "\uF765");
      glyphList.put("Eta", "\u0397");
      glyphList.put("Etarmenian", "\u0538");
      glyphList.put("Etatonos", "\u0389");
      glyphList.put("Eth", "\u00D0");
      glyphList.put("Ethsmall", "\uF7F0");
      glyphList.put("Etilde", "\u1EBC");
      glyphList.put("Etildebelow", "\u1E1A");
      glyphList.put("Euro", "\u20AC");
      glyphList.put("Ezh", "\u01B7");
      glyphList.put("Ezhcaron", "\u01EE");
      glyphList.put("Ezhreversed", "\u01B8");
      glyphList.put("F", "\u0046");
      glyphList.put("Fcircle", "\u24BB");
      glyphList.put("Fdotaccent", "\u1E1E");
      glyphList.put("Feharmenian", "\u0556");
      glyphList.put("Feicoptic", "\u03E4");
      glyphList.put("Fhook", "\u0191");
      glyphList.put("Fitacyrillic", "\u0472");
      glyphList.put("Fiveroman", "\u2164");
      glyphList.put("Fmonospace", "\uFF26");
      glyphList.put("Fourroman", "\u2163");
      glyphList.put("Fsmall", "\uF766");
      glyphList.put("G", "\u0047");
      glyphList.put("GBsquare", "\u3387");
      glyphList.put("Gacute", "\u01F4");
      glyphList.put("Gamma", "\u0393");
      glyphList.put("Gammaafrican", "\u0194");
      glyphList.put("Gangiacoptic", "\u03EA");
      glyphList.put("Gbreve", "\u011E");
      glyphList.put("Gcaron", "\u01E6");
      glyphList.put("Gcedilla", "\u0122");
      glyphList.put("Gcircle", "\u24BC");
      glyphList.put("Gcircumflex", "\u011C");
      glyphList.put("Gcommaaccent", "\u0122");
      glyphList.put("Gdot", "\u0120");
      glyphList.put("Gdotaccent", "\u0120");
      glyphList.put("Gecyrillic", "\u0413");
      glyphList.put("Ghadarmenian", "\u0542");
      glyphList.put("Ghemiddlehookcyrillic", "\u0494");
      glyphList.put("Ghestrokecyrillic", "\u0492");
      glyphList.put("Gheupturncyrillic", "\u0490");
      glyphList.put("Ghook", "\u0193");
      glyphList.put("Gimarmenian", "\u0533");
      glyphList.put("Gjecyrillic", "\u0403");
      glyphList.put("Gmacron", "\u1E20");
      glyphList.put("Gmonospace", "\uFF27");
      glyphList.put("Grave", "\uF6CE");
      glyphList.put("Gravesmall", "\uF760");
      glyphList.put("Gsmall", "\uF767");
      glyphList.put("Gsmallhook", "\u029B");
      glyphList.put("Gstroke", "\u01E4");
      glyphList.put("H", "\u0048");
      glyphList.put("H18533", "\u25CF");
      glyphList.put("H18543", "\u25AA");
      glyphList.put("H18551", "\u25AB");
      glyphList.put("H22073", "\u25A1");
      glyphList.put("HPsquare", "\u33CB");
      glyphList.put("Haabkhasiancyrillic", "\u04A8");
      glyphList.put("Hadescendercyrillic", "\u04B2");
      glyphList.put("Hardsigncyrillic", "\u042A");
      glyphList.put("Hbar", "\u0126");
      glyphList.put("Hbrevebelow", "\u1E2A");
      glyphList.put("Hcedilla", "\u1E28");
      glyphList.put("Hcircle", "\u24BD");
      glyphList.put("Hcircumflex", "\u0124");
      glyphList.put("Hdieresis", "\u1E26");
      glyphList.put("Hdotaccent", "\u1E22");
      glyphList.put("Hdotbelow", "\u1E24");
      glyphList.put("Hmonospace", "\uFF28");
      glyphList.put("Hoarmenian", "\u0540");
      glyphList.put("Horicoptic", "\u03E8");
      glyphList.put("Hsmall", "\uF768");
      glyphList.put("Hungarumlaut", "\uF6CF");
      glyphList.put("Hungarumlautsmall", "\uF6F8");
      glyphList.put("Hzsquare", "\u3390");
      glyphList.put("I", "\u0049");
      glyphList.put("IAcyrillic", "\u042F");
      glyphList.put("IJ", "\u0132");
      glyphList.put("IUcyrillic", "\u042E");
      glyphList.put("Iacute", "\u00CD");
      glyphList.put("Iacutesmall", "\uF7ED");
      glyphList.put("Ibreve", "\u012C");
      glyphList.put("Icaron", "\u01CF");
      glyphList.put("Icircle", "\u24BE");
      glyphList.put("Icircumflex", "\u00CE");
      glyphList.put("Icircumflexsmall", "\uF7EE");
      glyphList.put("Icyrillic", "\u0406");
      glyphList.put("Idblgrave", "\u0208");
      glyphList.put("Idieresis", "\u00CF");
      glyphList.put("Idieresisacute", "\u1E2E");
      glyphList.put("Idieresiscyrillic", "\u04E4");
      glyphList.put("Idieresissmall", "\uF7EF");
      glyphList.put("Idot", "\u0130");
      glyphList.put("Idotaccent", "\u0130");
      glyphList.put("Idotbelow", "\u1ECA");
      glyphList.put("Iebrevecyrillic", "\u04D6");
      glyphList.put("Iecyrillic", "\u0415");
      glyphList.put("Ifraktur", "\u2111");
      glyphList.put("Igrave", "\u00CC");
      glyphList.put("Igravesmall", "\uF7EC");
      glyphList.put("Ihookabove", "\u1EC8");
      glyphList.put("Iicyrillic", "\u0418");
      glyphList.put("Iinvertedbreve", "\u020A");
      glyphList.put("Iishortcyrillic", "\u0419");
      glyphList.put("Imacron", "\u012A");
      glyphList.put("Imacroncyrillic", "\u04E2");
      glyphList.put("Imonospace", "\uFF29");
      glyphList.put("Iniarmenian", "\u053B");
      glyphList.put("Iocyrillic", "\u0401");
      glyphList.put("Iogonek", "\u012E");
      glyphList.put("Iota", "\u0399");
      glyphList.put("Iotaafrican", "\u0196");
      glyphList.put("Iotadieresis", "\u03AA");
      glyphList.put("Iotatonos", "\u038A");
      glyphList.put("Ismall", "\uF769");
      glyphList.put("Istroke", "\u0197");
      glyphList.put("Itilde", "\u0128");
      glyphList.put("Itildebelow", "\u1E2C");
      glyphList.put("Izhitsacyrillic", "\u0474");
      glyphList.put("Izhitsadblgravecyrillic", "\u0476");
      glyphList.put("J", "\u004A");
      glyphList.put("Jaarmenian", "\u0541");
      glyphList.put("Jcircle", "\u24BF");
      glyphList.put("Jcircumflex", "\u0134");
      glyphList.put("Jecyrillic", "\u0408");
      glyphList.put("Jheharmenian", "\u054B");
      glyphList.put("Jmonospace", "\uFF2A");
      glyphList.put("Jsmall", "\uF76A");
      glyphList.put("K", "\u004B");
      glyphList.put("KBsquare", "\u3385");
      glyphList.put("KKsquare", "\u33CD");
      glyphList.put("Kabashkircyrillic", "\u04A0");
      glyphList.put("Kacute", "\u1E30");
      glyphList.put("Kacyrillic", "\u041A");
      glyphList.put("Kadescendercyrillic", "\u049A");
      glyphList.put("Kahookcyrillic", "\u04C3");
      glyphList.put("Kappa", "\u039A");
      glyphList.put("Kastrokecyrillic", "\u049E");
      glyphList.put("Kaverticalstrokecyrillic", "\u049C");
      glyphList.put("Kcaron", "\u01E8");
      glyphList.put("Kcedilla", "\u0136");
      glyphList.put("Kcircle", "\u24C0");
      glyphList.put("Kcommaaccent", "\u0136");
      glyphList.put("Kdotbelow", "\u1E32");
      glyphList.put("Keharmenian", "\u0554");
      glyphList.put("Kenarmenian", "\u053F");
      glyphList.put("Khacyrillic", "\u0425");
      glyphList.put("Kheicoptic", "\u03E6");
      glyphList.put("Khook", "\u0198");
      glyphList.put("Kjecyrillic", "\u040C");
      glyphList.put("Klinebelow", "\u1E34");
      glyphList.put("Kmonospace", "\uFF2B");
      glyphList.put("Koppacyrillic", "\u0480");
      glyphList.put("Koppagreek", "\u03DE");
      glyphList.put("Ksicyrillic", "\u046E");
      glyphList.put("Ksmall", "\uF76B");
      glyphList.put("L", "\u004C");
      glyphList.put("LJ", "\u01C7");
      glyphList.put("LL", "\uF6BF");
      glyphList.put("Lacute", "\u0139");
      glyphList.put("Lambda", "\u039B");
      glyphList.put("Lcaron", "\u013D");
      glyphList.put("Lcedilla", "\u013B");
      glyphList.put("Lcircle", "\u24C1");
      glyphList.put("Lcircumflexbelow", "\u1E3C");
      glyphList.put("Lcommaaccent", "\u013B");
      glyphList.put("Ldot", "\u013F");
      glyphList.put("Ldotaccent", "\u013F");
      glyphList.put("Ldotbelow", "\u1E36");
      glyphList.put("Ldotbelowmacron", "\u1E38");
      glyphList.put("Liwnarmenian", "\u053C");
      glyphList.put("Lj", "\u01C8");
      glyphList.put("Ljecyrillic", "\u0409");
      glyphList.put("Llinebelow", "\u1E3A");
      glyphList.put("Lmonospace", "\uFF2C");
      glyphList.put("Lslash", "\u0141");
      glyphList.put("Lslashsmall", "\uF6F9");
      glyphList.put("Lsmall", "\uF76C");
      glyphList.put("M", "\u004D");
      glyphList.put("MBsquare", "\u3386");
      glyphList.put("Macron", "\uF6D0");
      glyphList.put("Macronsmall", "\uF7AF");
      glyphList.put("Macute", "\u1E3E");
      glyphList.put("Mcircle", "\u24C2");
      glyphList.put("Mdotaccent", "\u1E40");
      glyphList.put("Mdotbelow", "\u1E42");
      glyphList.put("Menarmenian", "\u0544");
      glyphList.put("Mmonospace", "\uFF2D");
      glyphList.put("Msmall", "\uF76D");
      glyphList.put("Mturned", "\u019C");
      glyphList.put("Mu", "\u039C");
      glyphList.put("N", "\u004E");
      glyphList.put("NJ", "\u01CA");
      glyphList.put("Nacute", "\u0143");
      glyphList.put("Ncaron", "\u0147");
      glyphList.put("Ncedilla", "\u0145");
      glyphList.put("Ncircle", "\u24C3");
      glyphList.put("Ncircumflexbelow", "\u1E4A");
      glyphList.put("Ncommaaccent", "\u0145");
      glyphList.put("Ndotaccent", "\u1E44");
      glyphList.put("Ndotbelow", "\u1E46");
      glyphList.put("Nhookleft", "\u019D");
      glyphList.put("Nineroman", "\u2168");
      glyphList.put("Nj", "\u01CB");
      glyphList.put("Njecyrillic", "\u040A");
      glyphList.put("Nlinebelow", "\u1E48");
      glyphList.put("Nmonospace", "\uFF2E");
      glyphList.put("Nowarmenian", "\u0546");
      glyphList.put("Nsmall", "\uF76E");
      glyphList.put("Ntilde", "\u00D1");
      glyphList.put("Ntildesmall", "\uF7F1");
      glyphList.put("Nu", "\u039D");
      glyphList.put("O", "\u004F");
      glyphList.put("OE", "\u0152");
      glyphList.put("OEsmall", "\uF6FA");
      glyphList.put("Oacute", "\u00D3");
      glyphList.put("Oacutesmall", "\uF7F3");
      glyphList.put("Obarredcyrillic", "\u04E8");
      glyphList.put("Obarreddieresiscyrillic", "\u04EA");
      glyphList.put("Obreve", "\u014E");
      glyphList.put("Ocaron", "\u01D1");
      glyphList.put("Ocenteredtilde", "\u019F");
      glyphList.put("Ocircle", "\u24C4");
      glyphList.put("Ocircumflex", "\u00D4");
      glyphList.put("Ocircumflexacute", "\u1ED0");
      glyphList.put("Ocircumflexdotbelow", "\u1ED8");
      glyphList.put("Ocircumflexgrave", "\u1ED2");
      glyphList.put("Ocircumflexhookabove", "\u1ED4");
      glyphList.put("Ocircumflexsmall", "\uF7F4");
      glyphList.put("Ocircumflextilde", "\u1ED6");
      glyphList.put("Ocyrillic", "\u041E");
      glyphList.put("Odblacute", "\u0150");
      glyphList.put("Odblgrave", "\u020C");
      glyphList.put("Odieresis", "\u00D6");
      glyphList.put("Odieresiscyrillic", "\u04E6");
      glyphList.put("Odieresissmall", "\uF7F6");
      glyphList.put("Odotbelow", "\u1ECC");
      glyphList.put("Ogoneksmall", "\uF6FB");
      glyphList.put("Ograve", "\u00D2");
      glyphList.put("Ogravesmall", "\uF7F2");
      glyphList.put("Oharmenian", "\u0555");
      glyphList.put("Ohm", "\u2126");
      glyphList.put("Ohookabove", "\u1ECE");
      glyphList.put("Ohorn", "\u01A0");
      glyphList.put("Ohornacute", "\u1EDA");
      glyphList.put("Ohorndotbelow", "\u1EE2");
      glyphList.put("Ohorngrave", "\u1EDC");
      glyphList.put("Ohornhookabove", "\u1EDE");
      glyphList.put("Ohorntilde", "\u1EE0");
      glyphList.put("Ohungarumlaut", "\u0150");
      glyphList.put("Oi", "\u01A2");
      glyphList.put("Oinvertedbreve", "\u020E");
      glyphList.put("Omacron", "\u014C");
      glyphList.put("Omacronacute", "\u1E52");
      glyphList.put("Omacrongrave", "\u1E50");
      glyphList.put("Omega", "\u2126");
      glyphList.put("Omegacyrillic", "\u0460");
      glyphList.put("Omegagreek", "\u03A9");
      glyphList.put("Omegaroundcyrillic", "\u047A");
      glyphList.put("Omegatitlocyrillic", "\u047C");
      glyphList.put("Omegatonos", "\u038F");
      glyphList.put("Omicron", "\u039F");
      glyphList.put("Omicrontonos", "\u038C");
      glyphList.put("Omonospace", "\uFF2F");
      glyphList.put("Oneroman", "\u2160");
      glyphList.put("Oogonek", "\u01EA");
      glyphList.put("Oogonekmacron", "\u01EC");
      glyphList.put("Oopen", "\u0186");
      glyphList.put("Oslash", "\u00D8");
      glyphList.put("Oslashacute", "\u01FE");
      glyphList.put("Oslashsmall", "\uF7F8");
      glyphList.put("Osmall", "\uF76F");
      glyphList.put("Ostrokeacute", "\u01FE");
      glyphList.put("Otcyrillic", "\u047E");
      glyphList.put("Otilde", "\u00D5");
      glyphList.put("Otildeacute", "\u1E4C");
      glyphList.put("Otildedieresis", "\u1E4E");
      glyphList.put("Otildesmall", "\uF7F5");
      glyphList.put("P", "\u0050");
      glyphList.put("Pacute", "\u1E54");
      glyphList.put("Pcircle", "\u24C5");
      glyphList.put("Pdotaccent", "\u1E56");
      glyphList.put("Pecyrillic", "\u041F");
      glyphList.put("Peharmenian", "\u054A");
      glyphList.put("Pemiddlehookcyrillic", "\u04A6");
      glyphList.put("Phi", "\u03A6");
      glyphList.put("Phook", "\u01A4");
      glyphList.put("Pi", "\u03A0");
      glyphList.put("Piwrarmenian", "\u0553");
      glyphList.put("Pmonospace", "\uFF30");
      glyphList.put("Psi", "\u03A8");
      glyphList.put("Psicyrillic", "\u0470");
      glyphList.put("Psmall", "\uF770");
      glyphList.put("Q", "\u0051");
      glyphList.put("Qcircle", "\u24C6");
      glyphList.put("Qmonospace", "\uFF31");
      glyphList.put("Qsmall", "\uF771");
      glyphList.put("R", "\u0052");
      glyphList.put("Raarmenian", "\u054C");
      glyphList.put("Racute", "\u0154");
      glyphList.put("Rcaron", "\u0158");
      glyphList.put("Rcedilla", "\u0156");
      glyphList.put("Rcircle", "\u24C7");
      glyphList.put("Rcommaaccent", "\u0156");
      glyphList.put("Rdblgrave", "\u0210");
      glyphList.put("Rdotaccent", "\u1E58");
      glyphList.put("Rdotbelow", "\u1E5A");
      glyphList.put("Rdotbelowmacron", "\u1E5C");
      glyphList.put("Reharmenian", "\u0550");
      glyphList.put("Rfraktur", "\u211C");
      glyphList.put("Rho", "\u03A1");
      glyphList.put("Ringsmall", "\uF6FC");
      glyphList.put("Rinvertedbreve", "\u0212");
      glyphList.put("Rlinebelow", "\u1E5E");
      glyphList.put("Rmonospace", "\uFF32");
      glyphList.put("Rsmall", "\uF772");
      glyphList.put("Rsmallinverted", "\u0281");
      glyphList.put("Rsmallinvertedsuperior", "\u02B6");
      glyphList.put("S", "\u0053");
      glyphList.put("SF010000", "\u250C");
      glyphList.put("SF020000", "\u2514");
      glyphList.put("SF030000", "\u2510");
      glyphList.put("SF040000", "\u2518");
      glyphList.put("SF050000", "\u253C");
      glyphList.put("SF060000", "\u252C");
      glyphList.put("SF070000", "\u2534");
      glyphList.put("SF080000", "\u251C");
      glyphList.put("SF090000", "\u2524");
      glyphList.put("SF100000", "\u2500");
      glyphList.put("SF110000", "\u2502");
      glyphList.put("SF190000", "\u2561");
      glyphList.put("SF200000", "\u2562");
      glyphList.put("SF210000", "\u2556");
      glyphList.put("SF220000", "\u2555");
      glyphList.put("SF230000", "\u2563");
      glyphList.put("SF240000", "\u2551");
      glyphList.put("SF250000", "\u2557");
      glyphList.put("SF260000", "\u255D");
      glyphList.put("SF270000", "\u255C");
      glyphList.put("SF280000", "\u255B");
      glyphList.put("SF360000", "\u255E");
      glyphList.put("SF370000", "\u255F");
      glyphList.put("SF380000", "\u255A");
      glyphList.put("SF390000", "\u2554");
      glyphList.put("SF400000", "\u2569");
      glyphList.put("SF410000", "\u2566");
      glyphList.put("SF420000", "\u2560");
      glyphList.put("SF430000", "\u2550");
      glyphList.put("SF440000", "\u256C");
      glyphList.put("SF450000", "\u2567");
      glyphList.put("SF460000", "\u2568");
      glyphList.put("SF470000", "\u2564");
      glyphList.put("SF480000", "\u2565");
      glyphList.put("SF490000", "\u2559");
      glyphList.put("SF500000", "\u2558");
      glyphList.put("SF510000", "\u2552");
      glyphList.put("SF520000", "\u2553");
      glyphList.put("SF530000", "\u256B");
      glyphList.put("SF540000", "\u256A");
      glyphList.put("Sacute", "\u015A");
      glyphList.put("Sacutedotaccent", "\u1E64");
      glyphList.put("Sampigreek", "\u03E0");
      glyphList.put("Scaron", "\u0160");
      glyphList.put("Scarondotaccent", "\u1E66");
      glyphList.put("Scaronsmall", "\uF6FD");
      glyphList.put("Scedilla", "\u015E");
      glyphList.put("Schwa", "\u018F");
      glyphList.put("Schwacyrillic", "\u04D8");
      glyphList.put("Schwadieresiscyrillic", "\u04DA");
      glyphList.put("Scircle", "\u24C8");
      glyphList.put("Scircumflex", "\u015C");
      glyphList.put("Scommaaccent", "\u0218");
      glyphList.put("Sdotaccent", "\u1E60");
      glyphList.put("Sdotbelow", "\u1E62");
      glyphList.put("Sdotbelowdotaccent", "\u1E68");
      glyphList.put("Seharmenian", "\u054D");
      glyphList.put("Sevenroman", "\u2166");
      glyphList.put("Shaarmenian", "\u0547");
      glyphList.put("Shacyrillic", "\u0428");
      glyphList.put("Shchacyrillic", "\u0429");
      glyphList.put("Sheicoptic", "\u03E2");
      glyphList.put("Shhacyrillic", "\u04BA");
      glyphList.put("Shimacoptic", "\u03EC");
      glyphList.put("Sigma", "\u03A3");
      glyphList.put("Sixroman", "\u2165");
      glyphList.put("Smonospace", "\uFF33");
      glyphList.put("Softsigncyrillic", "\u042C");
      glyphList.put("Ssmall", "\uF773");
      glyphList.put("Stigmagreek", "\u03DA");
      glyphList.put("T", "\u0054");
      glyphList.put("Tau", "\u03A4");
      glyphList.put("Tbar", "\u0166");
      glyphList.put("Tcaron", "\u0164");
      glyphList.put("Tcedilla", "\u0162");
      glyphList.put("Tcircle", "\u24C9");
      glyphList.put("Tcircumflexbelow", "\u1E70");
      glyphList.put("Tcommaaccent", "\u0162");
      glyphList.put("Tdotaccent", "\u1E6A");
      glyphList.put("Tdotbelow", "\u1E6C");
      glyphList.put("Tecyrillic", "\u0422");
      glyphList.put("Tedescendercyrillic", "\u04AC");
      glyphList.put("Tenroman", "\u2169");
      glyphList.put("Tetsecyrillic", "\u04B4");
      glyphList.put("Theta", "\u0398");
      glyphList.put("Thook", "\u01AC");
      glyphList.put("Thorn", "\u00DE");
      glyphList.put("Thornsmall", "\uF7FE");
      glyphList.put("Threeroman", "\u2162");
      glyphList.put("Tildesmall", "\uF6FE");
      glyphList.put("Tiwnarmenian", "\u054F");
      glyphList.put("Tlinebelow", "\u1E6E");
      glyphList.put("Tmonospace", "\uFF34");
      glyphList.put("Toarmenian", "\u0539");
      glyphList.put("Tonefive", "\u01BC");
      glyphList.put("Tonesix", "\u0184");
      glyphList.put("Tonetwo", "\u01A7");
      glyphList.put("Tretroflexhook", "\u01AE");
      glyphList.put("Tsecyrillic", "\u0426");
      glyphList.put("Tshecyrillic", "\u040B");
      glyphList.put("Tsmall", "\uF774");
      glyphList.put("Twelveroman", "\u216B");
      glyphList.put("Tworoman", "\u2161");
      glyphList.put("U", "\u0055");
      glyphList.put("Uacute", "\u00DA");
      glyphList.put("Uacutesmall", "\uF7FA");
      glyphList.put("Ubreve", "\u016C");
      glyphList.put("Ucaron", "\u01D3");
      glyphList.put("Ucircle", "\u24CA");
      glyphList.put("Ucircumflex", "\u00DB");
      glyphList.put("Ucircumflexbelow", "\u1E76");
      glyphList.put("Ucircumflexsmall", "\uF7FB");
      glyphList.put("Ucyrillic", "\u0423");
      glyphList.put("Udblacute", "\u0170");
      glyphList.put("Udblgrave", "\u0214");
      glyphList.put("Udieresis", "\u00DC");
      glyphList.put("Udieresisacute", "\u01D7");
      glyphList.put("Udieresisbelow", "\u1E72");
      glyphList.put("Udieresiscaron", "\u01D9");
      glyphList.put("Udieresiscyrillic", "\u04F0");
      glyphList.put("Udieresisgrave", "\u01DB");
      glyphList.put("Udieresismacron", "\u01D5");
      glyphList.put("Udieresissmall", "\uF7FC");
      glyphList.put("Udotbelow", "\u1EE4");
      glyphList.put("Ugrave", "\u00D9");
      glyphList.put("Ugravesmall", "\uF7F9");
      glyphList.put("Uhookabove", "\u1EE6");
      glyphList.put("Uhorn", "\u01AF");
      glyphList.put("Uhornacute", "\u1EE8");
      glyphList.put("Uhorndotbelow", "\u1EF0");
      glyphList.put("Uhorngrave", "\u1EEA");
      glyphList.put("Uhornhookabove", "\u1EEC");
      glyphList.put("Uhorntilde", "\u1EEE");
      glyphList.put("Uhungarumlaut", "\u0170");
      glyphList.put("Uhungarumlautcyrillic", "\u04F2");
      glyphList.put("Uinvertedbreve", "\u0216");
      glyphList.put("Ukcyrillic", "\u0478");
      glyphList.put("Umacron", "\u016A");
      glyphList.put("Umacroncyrillic", "\u04EE");
      glyphList.put("Umacrondieresis", "\u1E7A");
      glyphList.put("Umonospace", "\uFF35");
      glyphList.put("Uogonek", "\u0172");
      glyphList.put("Upsilon", "\u03A5");
      glyphList.put("Upsilon1", "\u03D2");
      glyphList.put("Upsilonacutehooksymbolgreek", "\u03D3");
      glyphList.put("Upsilonafrican", "\u01B1");
      glyphList.put("Upsilondieresis", "\u03AB");
      glyphList.put("Upsilondieresishooksymbolgreek", "\u03D4");
      glyphList.put("Upsilonhooksymbol", "\u03D2");
      glyphList.put("Upsilontonos", "\u038E");
      glyphList.put("Uring", "\u016E");
      glyphList.put("Ushortcyrillic", "\u040E");
      glyphList.put("Usmall", "\uF775");
      glyphList.put("Ustraightcyrillic", "\u04AE");
      glyphList.put("Ustraightstrokecyrillic", "\u04B0");
      glyphList.put("Utilde", "\u0168");
      glyphList.put("Utildeacute", "\u1E78");
      glyphList.put("Utildebelow", "\u1E74");
      glyphList.put("V", "\u0056");
      glyphList.put("Vcircle", "\u24CB");
      glyphList.put("Vdotbelow", "\u1E7E");
      glyphList.put("Vecyrillic", "\u0412");
      glyphList.put("Vewarmenian", "\u054E");
      glyphList.put("Vhook", "\u01B2");
      glyphList.put("Vmonospace", "\uFF36");
      glyphList.put("Voarmenian", "\u0548");
      glyphList.put("Vsmall", "\uF776");
      glyphList.put("Vtilde", "\u1E7C");
      glyphList.put("W", "\u0057");
      glyphList.put("Wacute", "\u1E82");
      glyphList.put("Wcircle", "\u24CC");
      glyphList.put("Wcircumflex", "\u0174");
      glyphList.put("Wdieresis", "\u1E84");
      glyphList.put("Wdotaccent", "\u1E86");
      glyphList.put("Wdotbelow", "\u1E88");
      glyphList.put("Wgrave", "\u1E80");
      glyphList.put("Wmonospace", "\uFF37");
      glyphList.put("Wsmall", "\uF777");
      glyphList.put("X", "\u0058");
      glyphList.put("Xcircle", "\u24CD");
      glyphList.put("Xdieresis", "\u1E8C");
      glyphList.put("Xdotaccent", "\u1E8A");
      glyphList.put("Xeharmenian", "\u053D");
      glyphList.put("Xi", "\u039E");
      glyphList.put("Xmonospace", "\uFF38");
      glyphList.put("Xsmall", "\uF778");
      glyphList.put("Y", "\u0059");
      glyphList.put("Yacute", "\u00DD");
      glyphList.put("Yacutesmall", "\uF7FD");
      glyphList.put("Yatcyrillic", "\u0462");
      glyphList.put("Ycircle", "\u24CE");
      glyphList.put("Ycircumflex", "\u0176");
      glyphList.put("Ydieresis", "\u0178");
      glyphList.put("Ydieresissmall", "\uF7FF");
      glyphList.put("Ydotaccent", "\u1E8E");
      glyphList.put("Ydotbelow", "\u1EF4");
      glyphList.put("Yericyrillic", "\u042B");
      glyphList.put("Yerudieresiscyrillic", "\u04F8");
      glyphList.put("Ygrave", "\u1EF2");
      glyphList.put("Yhook", "\u01B3");
      glyphList.put("Yhookabove", "\u1EF6");
      glyphList.put("Yiarmenian", "\u0545");
      glyphList.put("Yicyrillic", "\u0407");
      glyphList.put("Yiwnarmenian", "\u0552");
      glyphList.put("Ymonospace", "\uFF39");
      glyphList.put("Ysmall", "\uF779");
      glyphList.put("Ytilde", "\u1EF8");
      glyphList.put("Yusbigcyrillic", "\u046A");
      glyphList.put("Yusbigiotifiedcyrillic", "\u046C");
      glyphList.put("Yuslittlecyrillic", "\u0466");
      glyphList.put("Yuslittleiotifiedcyrillic", "\u0468");
      glyphList.put("Z", "\u005A");
      glyphList.put("Zaarmenian", "\u0536");
      glyphList.put("Zacute", "\u0179");
      glyphList.put("Zcaron", "\u017D");
      glyphList.put("Zcaronsmall", "\uF6FF");
      glyphList.put("Zcircle", "\u24CF");
      glyphList.put("Zcircumflex", "\u1E90");
      glyphList.put("Zdot", "\u017B");
      glyphList.put("Zdotaccent", "\u017B");
      glyphList.put("Zdotbelow", "\u1E92");
      glyphList.put("Zecyrillic", "\u0417");
      glyphList.put("Zedescendercyrillic", "\u0498");
      glyphList.put("Zedieresiscyrillic", "\u04DE");
      glyphList.put("Zeta", "\u0396");
      glyphList.put("Zhearmenian", "\u053A");
      glyphList.put("Zhebrevecyrillic", "\u04C1");
      glyphList.put("Zhecyrillic", "\u0416");
      glyphList.put("Zhedescendercyrillic", "\u0496");
      glyphList.put("Zhedieresiscyrillic", "\u04DC");
      glyphList.put("Zlinebelow", "\u1E94");
      glyphList.put("Zmonospace", "\uFF3A");
      glyphList.put("Zsmall", "\uF77A");
      glyphList.put("Zstroke", "\u01B5");
      glyphList.put("a", "\u0061");
      glyphList.put("aabengali", "\u0986");
      glyphList.put("aacute", "\u00E1");
      glyphList.put("aadeva", "\u0906");
      glyphList.put("aagujarati", "\u0A86");
      glyphList.put("aagurmukhi", "\u0A06");
      glyphList.put("aamatragurmukhi", "\u0A3E");
      glyphList.put("aarusquare", "\u3303");
      glyphList.put("aavowelsignbengali", "\u09BE");
      glyphList.put("aavowelsigndeva", "\u093E");
      glyphList.put("aavowelsigngujarati", "\u0ABE");
      glyphList.put("abbreviationmarkarmenian", "\u055F");
      glyphList.put("abbreviationsigndeva", "\u0970");
      glyphList.put("abengali", "\u0985");
      glyphList.put("abopomofo", "\u311A");
      glyphList.put("abreve", "\u0103");
      glyphList.put("abreveacute", "\u1EAF");
      glyphList.put("abrevecyrillic", "\u04D1");
      glyphList.put("abrevedotbelow", "\u1EB7");
      glyphList.put("abrevegrave", "\u1EB1");
      glyphList.put("abrevehookabove", "\u1EB3");
      glyphList.put("abrevetilde", "\u1EB5");
      glyphList.put("acaron", "\u01CE");
      glyphList.put("acircle", "\u24D0");
      glyphList.put("acircumflex", "\u00E2");
      glyphList.put("acircumflexacute", "\u1EA5");
      glyphList.put("acircumflexdotbelow", "\u1EAD");
      glyphList.put("acircumflexgrave", "\u1EA7");
      glyphList.put("acircumflexhookabove", "\u1EA9");
      glyphList.put("acircumflextilde", "\u1EAB");
      glyphList.put("acute", "\u00B4");
      glyphList.put("acutebelowcmb", "\u0317");
      glyphList.put("acutecmb", "\u0301");
      glyphList.put("acutecomb", "\u0301");
      glyphList.put("acutedeva", "\u0954");
      glyphList.put("acutelowmod", "\u02CF");
      glyphList.put("acutetonecmb", "\u0341");
      glyphList.put("acyrillic", "\u0430");
      glyphList.put("adblgrave", "\u0201");
      glyphList.put("addakgurmukhi", "\u0A71");
      glyphList.put("adeva", "\u0905");
      glyphList.put("adieresis", "\u00E4");
      glyphList.put("adieresiscyrillic", "\u04D3");
      glyphList.put("adieresismacron", "\u01DF");
      glyphList.put("adotbelow", "\u1EA1");
      glyphList.put("adotmacron", "\u01E1");
      glyphList.put("ae", "\u00E6");
      glyphList.put("aeacute", "\u01FD");
      glyphList.put("aekorean", "\u3150");
      glyphList.put("aemacron", "\u01E3");
      glyphList.put("afii00208", "\u2015");
      glyphList.put("afii08941", "\u20A4");
      glyphList.put("afii10017", "\u0410");
      glyphList.put("afii10018", "\u0411");
      glyphList.put("afii10019", "\u0412");
      glyphList.put("afii10020", "\u0413");
      glyphList.put("afii10021", "\u0414");
      glyphList.put("afii10022", "\u0415");
      glyphList.put("afii10023", "\u0401");
      glyphList.put("afii10024", "\u0416");
      glyphList.put("afii10025", "\u0417");
      glyphList.put("afii10026", "\u0418");
      glyphList.put("afii10027", "\u0419");
      glyphList.put("afii10028", "\u041A");
      glyphList.put("afii10029", "\u041B");
      glyphList.put("afii10030", "\u041C");
      glyphList.put("afii10031", "\u041D");
      glyphList.put("afii10032", "\u041E");
      glyphList.put("afii10033", "\u041F");
      glyphList.put("afii10034", "\u0420");
      glyphList.put("afii10035", "\u0421");
      glyphList.put("afii10036", "\u0422");
      glyphList.put("afii10037", "\u0423");
      glyphList.put("afii10038", "\u0424");
      glyphList.put("afii10039", "\u0425");
      glyphList.put("afii10040", "\u0426");
      glyphList.put("afii10041", "\u0427");
      glyphList.put("afii10042", "\u0428");
      glyphList.put("afii10043", "\u0429");
      glyphList.put("afii10044", "\u042A");
      glyphList.put("afii10045", "\u042B");
      glyphList.put("afii10046", "\u042C");
      glyphList.put("afii10047", "\u042D");
      glyphList.put("afii10048", "\u042E");
      glyphList.put("afii10049", "\u042F");
      glyphList.put("afii10050", "\u0490");
      glyphList.put("afii10051", "\u0402");
      glyphList.put("afii10052", "\u0403");
      glyphList.put("afii10053", "\u0404");
      glyphList.put("afii10054", "\u0405");
      glyphList.put("afii10055", "\u0406");
      glyphList.put("afii10056", "\u0407");
      glyphList.put("afii10057", "\u0408");
      glyphList.put("afii10058", "\u0409");
      glyphList.put("afii10059", "\u040A");
      glyphList.put("afii10060", "\u040B");
      glyphList.put("afii10061", "\u040C");
      glyphList.put("afii10062", "\u040E");
      glyphList.put("afii10063", "\uF6C4");
      glyphList.put("afii10064", "\uF6C5");
      glyphList.put("afii10065", "\u0430");
      glyphList.put("afii10066", "\u0431");
      glyphList.put("afii10067", "\u0432");
      glyphList.put("afii10068", "\u0433");
      glyphList.put("afii10069", "\u0434");
      glyphList.put("afii10070", "\u0435");
      glyphList.put("afii10071", "\u0451");
      glyphList.put("afii10072", "\u0436");
      glyphList.put("afii10073", "\u0437");
      glyphList.put("afii10074", "\u0438");
      glyphList.put("afii10075", "\u0439");
      glyphList.put("afii10076", "\u043A");
      glyphList.put("afii10077", "\u043B");
      glyphList.put("afii10078", "\u043C");
      glyphList.put("afii10079", "\u043D");
      glyphList.put("afii10080", "\u043E");
      glyphList.put("afii10081", "\u043F");
      glyphList.put("afii10082", "\u0440");
      glyphList.put("afii10083", "\u0441");
      glyphList.put("afii10084", "\u0442");
      glyphList.put("afii10085", "\u0443");
      glyphList.put("afii10086", "\u0444");
      glyphList.put("afii10087", "\u0445");
      glyphList.put("afii10088", "\u0446");
      glyphList.put("afii10089", "\u0447");
      glyphList.put("afii10090", "\u0448");
      glyphList.put("afii10091", "\u0449");
      glyphList.put("afii10092", "\u044A");
      glyphList.put("afii10093", "\u044B");
      glyphList.put("afii10094", "\u044C");
      glyphList.put("afii10095", "\u044D");
      glyphList.put("afii10096", "\u044E");
      glyphList.put("afii10097", "\u044F");
      glyphList.put("afii10098", "\u0491");
      glyphList.put("afii10099", "\u0452");
      glyphList.put("afii10100", "\u0453");
      glyphList.put("afii10101", "\u0454");
      glyphList.put("afii10102", "\u0455");
      glyphList.put("afii10103", "\u0456");
      glyphList.put("afii10104", "\u0457");
      glyphList.put("afii10105", "\u0458");
      glyphList.put("afii10106", "\u0459");
      glyphList.put("afii10107", "\u045A");
      glyphList.put("afii10108", "\u045B");
      glyphList.put("afii10109", "\u045C");
      glyphList.put("afii10110", "\u045E");
      glyphList.put("afii10145", "\u040F");
      glyphList.put("afii10146", "\u0462");
      glyphList.put("afii10147", "\u0472");
      glyphList.put("afii10148", "\u0474");
      glyphList.put("afii10192", "\uF6C6");
      glyphList.put("afii10193", "\u045F");
      glyphList.put("afii10194", "\u0463");
      glyphList.put("afii10195", "\u0473");
      glyphList.put("afii10196", "\u0475");
      glyphList.put("afii10831", "\uF6C7");
      glyphList.put("afii10832", "\uF6C8");
      glyphList.put("afii10846", "\u04D9");
      glyphList.put("afii299", "\u200E");
      glyphList.put("afii300", "\u200F");
      glyphList.put("afii301", "\u200D");
      glyphList.put("afii57381", "\u066A");
      glyphList.put("afii57388", "\u060C");
      glyphList.put("afii57392", "\u0660");
      glyphList.put("afii57393", "\u0661");
      glyphList.put("afii57394", "\u0662");
      glyphList.put("afii57395", "\u0663");
      glyphList.put("afii57396", "\u0664");
      glyphList.put("afii57397", "\u0665");
      glyphList.put("afii57398", "\u0666");
      glyphList.put("afii57399", "\u0667");
      glyphList.put("afii57400", "\u0668");
      glyphList.put("afii57401", "\u0669");
      glyphList.put("afii57403", "\u061B");
      glyphList.put("afii57407", "\u061F");
      glyphList.put("afii57409", "\u0621");
      glyphList.put("afii57410", "\u0622");
      glyphList.put("afii57411", "\u0623");
      glyphList.put("afii57412", "\u0624");
      glyphList.put("afii57413", "\u0625");
      glyphList.put("afii57414", "\u0626");
      glyphList.put("afii57415", "\u0627");
      glyphList.put("afii57416", "\u0628");
      glyphList.put("afii57417", "\u0629");
      glyphList.put("afii57418", "\u062A");
      glyphList.put("afii57419", "\u062B");
      glyphList.put("afii57420", "\u062C");
      glyphList.put("afii57421", "\u062D");
      glyphList.put("afii57422", "\u062E");
      glyphList.put("afii57423", "\u062F");
      glyphList.put("afii57424", "\u0630");
      glyphList.put("afii57425", "\u0631");
      glyphList.put("afii57426", "\u0632");
      glyphList.put("afii57427", "\u0633");
      glyphList.put("afii57428", "\u0634");
      glyphList.put("afii57429", "\u0635");
      glyphList.put("afii57430", "\u0636");
      glyphList.put("afii57431", "\u0637");
      glyphList.put("afii57432", "\u0638");
      glyphList.put("afii57433", "\u0639");
      glyphList.put("afii57434", "\u063A");
      glyphList.put("afii57440", "\u0640");
      glyphList.put("afii57441", "\u0641");
      glyphList.put("afii57442", "\u0642");
      glyphList.put("afii57443", "\u0643");
      glyphList.put("afii57444", "\u0644");
      glyphList.put("afii57445", "\u0645");
      glyphList.put("afii57446", "\u0646");
      glyphList.put("afii57448", "\u0648");
      glyphList.put("afii57449", "\u0649");
      glyphList.put("afii57450", "\u064A");
      glyphList.put("afii57451", "\u064B");
      glyphList.put("afii57452", "\u064C");
      glyphList.put("afii57453", "\u064D");
      glyphList.put("afii57454", "\u064E");
      glyphList.put("afii57455", "\u064F");
      glyphList.put("afii57456", "\u0650");
      glyphList.put("afii57457", "\u0651");
      glyphList.put("afii57458", "\u0652");
      glyphList.put("afii57470", "\u0647");
      glyphList.put("afii57505", "\u06A4");
      glyphList.put("afii57506", "\u067E");
      glyphList.put("afii57507", "\u0686");
      glyphList.put("afii57508", "\u0698");
      glyphList.put("afii57509", "\u06AF");
      glyphList.put("afii57511", "\u0679");
      glyphList.put("afii57512", "\u0688");
      glyphList.put("afii57513", "\u0691");
      glyphList.put("afii57514", "\u06BA");
      glyphList.put("afii57519", "\u06D2");
      glyphList.put("afii57534", "\u06D5");
      glyphList.put("afii57636", "\u20AA");
      glyphList.put("afii57645", "\u05BE");
      glyphList.put("afii57658", "\u05C3");
      glyphList.put("afii57664", "\u05D0");
      glyphList.put("afii57665", "\u05D1");
      glyphList.put("afii57666", "\u05D2");
      glyphList.put("afii57667", "\u05D3");
      glyphList.put("afii57668", "\u05D4");
      glyphList.put("afii57669", "\u05D5");
      glyphList.put("afii57670", "\u05D6");
      glyphList.put("afii57671", "\u05D7");
      glyphList.put("afii57672", "\u05D8");
      glyphList.put("afii57673", "\u05D9");
      glyphList.put("afii57674", "\u05DA");
      glyphList.put("afii57675", "\u05DB");
      glyphList.put("afii57676", "\u05DC");
      glyphList.put("afii57677", "\u05DD");
      glyphList.put("afii57678", "\u05DE");
      glyphList.put("afii57679", "\u05DF");
      glyphList.put("afii57680", "\u05E0");
      glyphList.put("afii57681", "\u05E1");
      glyphList.put("afii57682", "\u05E2");
      glyphList.put("afii57683", "\u05E3");
      glyphList.put("afii57684", "\u05E4");
      glyphList.put("afii57685", "\u05E5");
      glyphList.put("afii57686", "\u05E6");
      glyphList.put("afii57687", "\u05E7");
      glyphList.put("afii57688", "\u05E8");
      glyphList.put("afii57689", "\u05E9");
      glyphList.put("afii57690", "\u05EA");
      glyphList.put("afii57694", "\uFB2A");
      glyphList.put("afii57695", "\uFB2B");
      glyphList.put("afii57700", "\uFB4B");
      glyphList.put("afii57705", "\uFB1F");
      glyphList.put("afii57716", "\u05F0");
      glyphList.put("afii57717", "\u05F1");
      glyphList.put("afii57718", "\u05F2");
      glyphList.put("afii57723", "\uFB35");
      glyphList.put("afii57793", "\u05B4");
      glyphList.put("afii57794", "\u05B5");
      glyphList.put("afii57795", "\u05B6");
      glyphList.put("afii57796", "\u05BB");
      glyphList.put("afii57797", "\u05B8");
      glyphList.put("afii57798", "\u05B7");
      glyphList.put("afii57799", "\u05B0");
      glyphList.put("afii57800", "\u05B2");
      glyphList.put("afii57801", "\u05B1");
      glyphList.put("afii57802", "\u05B3");
      glyphList.put("afii57803", "\u05C2");
      glyphList.put("afii57804", "\u05C1");
      glyphList.put("afii57806", "\u05B9");
      glyphList.put("afii57807", "\u05BC");
      glyphList.put("afii57839", "\u05BD");
      glyphList.put("afii57841", "\u05BF");
      glyphList.put("afii57842", "\u05C0");
      glyphList.put("afii57929", "\u02BC");
      glyphList.put("afii61248", "\u2105");
      glyphList.put("afii61289", "\u2113");
      glyphList.put("afii61352", "\u2116");
      glyphList.put("afii61573", "\u202C");
      glyphList.put("afii61574", "\u202D");
      glyphList.put("afii61575", "\u202E");
      glyphList.put("afii61664", "\u200C");
      glyphList.put("afii63167", "\u066D");
      glyphList.put("afii64937", "\u02BD");
      glyphList.put("agrave", "\u00E0");
      glyphList.put("agujarati", "\u0A85");
      glyphList.put("agurmukhi", "\u0A05");
      glyphList.put("ahiragana", "\u3042");
      glyphList.put("ahookabove", "\u1EA3");
      glyphList.put("aibengali", "\u0990");
      glyphList.put("aibopomofo", "\u311E");
      glyphList.put("aideva", "\u0910");
      glyphList.put("aiecyrillic", "\u04D5");
      glyphList.put("aigujarati", "\u0A90");
      glyphList.put("aigurmukhi", "\u0A10");
      glyphList.put("aimatragurmukhi", "\u0A48");
      glyphList.put("ainarabic", "\u0639");
      glyphList.put("ainfinalarabic", "\uFECA");
      glyphList.put("aininitialarabic", "\uFECB");
      glyphList.put("ainmedialarabic", "\uFECC");
      glyphList.put("ainvertedbreve", "\u0203");
      glyphList.put("aivowelsignbengali", "\u09C8");
      glyphList.put("aivowelsigndeva", "\u0948");
      glyphList.put("aivowelsigngujarati", "\u0AC8");
      glyphList.put("akatakana", "\u30A2");
      glyphList.put("akatakanahalfwidth", "\uFF71");
      glyphList.put("akorean", "\u314F");
      glyphList.put("alef", "\u05D0");
      glyphList.put("alefarabic", "\u0627");
      glyphList.put("alefdageshhebrew", "\uFB30");
      glyphList.put("aleffinalarabic", "\uFE8E");
      glyphList.put("alefhamzaabovearabic", "\u0623");
      glyphList.put("alefhamzaabovefinalarabic", "\uFE84");
      glyphList.put("alefhamzabelowarabic", "\u0625");
      glyphList.put("alefhamzabelowfinalarabic", "\uFE88");
      glyphList.put("alefhebrew", "\u05D0");
      glyphList.put("aleflamedhebrew", "\uFB4F");
      glyphList.put("alefmaddaabovearabic", "\u0622");
      glyphList.put("alefmaddaabovefinalarabic", "\uFE82");
      glyphList.put("alefmaksuraarabic", "\u0649");
      glyphList.put("alefmaksurafinalarabic", "\uFEF0");
      glyphList.put("alefmaksurainitialarabic", "\uFEF3");
      glyphList.put("alefmaksuramedialarabic", "\uFEF4");
      glyphList.put("alefpatahhebrew", "\uFB2E");
      glyphList.put("alefqamatshebrew", "\uFB2F");
      glyphList.put("aleph", "\u2135");
      glyphList.put("allequal", "\u224C");
      glyphList.put("alpha", "\u03B1");
      glyphList.put("alphatonos", "\u03AC");
      glyphList.put("amacron", "\u0101");
      glyphList.put("amonospace", "\uFF41");
      glyphList.put("ampersand", "\u0026");
      glyphList.put("ampersandmonospace", "\uFF06");
      glyphList.put("ampersandsmall", "\uF726");
      glyphList.put("amsquare", "\u33C2");
      glyphList.put("anbopomofo", "\u3122");
      glyphList.put("angbopomofo", "\u3124");
      glyphList.put("angkhankhuthai", "\u0E5A");
      glyphList.put("angle", "\u2220");
      glyphList.put("anglebracketleft", "\u3008");
      glyphList.put("anglebracketleftvertical", "\uFE3F");
      glyphList.put("anglebracketright", "\u3009");
      glyphList.put("anglebracketrightvertical", "\uFE40");
      glyphList.put("angleleft", "\u2329");
      glyphList.put("angleright", "\u232A");
      glyphList.put("angstrom", "\u212B");
      glyphList.put("anoteleia", "\u0387");
      glyphList.put("anudattadeva", "\u0952");
      glyphList.put("anusvarabengali", "\u0982");
      glyphList.put("anusvaradeva", "\u0902");
      glyphList.put("anusvaragujarati", "\u0A82");
      glyphList.put("aogonek", "\u0105");
      glyphList.put("apaatosquare", "\u3300");
      glyphList.put("aparen", "\u249C");
      glyphList.put("apostrophearmenian", "\u055A");
      glyphList.put("apostrophemod", "\u02BC");
      glyphList.put("apple", "\uF8FF");
      glyphList.put("approaches", "\u2250");
      glyphList.put("approxequal", "\u2248");
      glyphList.put("approxequalorimage", "\u2252");
      glyphList.put("approximatelyequal", "\u2245");
      glyphList.put("araeaekorean", "\u318E");
      glyphList.put("araeakorean", "\u318D");
      glyphList.put("arc", "\u2312");
      glyphList.put("arighthalfring", "\u1E9A");
      glyphList.put("aring", "\u00E5");
      glyphList.put("aringacute", "\u01FB");
      glyphList.put("aringbelow", "\u1E01");
      glyphList.put("arrowboth", "\u2194");
      glyphList.put("arrowdashdown", "\u21E3");
      glyphList.put("arrowdashleft", "\u21E0");
      glyphList.put("arrowdashright", "\u21E2");
      glyphList.put("arrowdashup", "\u21E1");
      glyphList.put("arrowdblboth", "\u21D4");
      glyphList.put("arrowdbldown", "\u21D3");
      glyphList.put("arrowdblleft", "\u21D0");
      glyphList.put("arrowdblright", "\u21D2");
      glyphList.put("arrowdblup", "\u21D1");
      glyphList.put("arrowdown", "\u2193");
      glyphList.put("arrowdownleft", "\u2199");
      glyphList.put("arrowdownright", "\u2198");
      glyphList.put("arrowdownwhite", "\u21E9");
      glyphList.put("arrowheaddownmod", "\u02C5");
      glyphList.put("arrowheadleftmod", "\u02C2");
      glyphList.put("arrowheadrightmod", "\u02C3");
      glyphList.put("arrowheadupmod", "\u02C4");
      glyphList.put("arrowhorizex", "\uF8E7");
      glyphList.put("arrowleft", "\u2190");
      glyphList.put("arrowleftdbl", "\u21D0");
      glyphList.put("arrowleftdblstroke", "\u21CD");
      glyphList.put("arrowleftoverright", "\u21C6");
      glyphList.put("arrowleftwhite", "\u21E6");
      glyphList.put("arrowright", "\u2192");
      glyphList.put("arrowrightdblstroke", "\u21CF");
      glyphList.put("arrowrightheavy", "\u279E");
      glyphList.put("arrowrightoverleft", "\u21C4");
      glyphList.put("arrowrightwhite", "\u21E8");
      glyphList.put("arrowtableft", "\u21E4");
      glyphList.put("arrowtabright", "\u21E5");
      glyphList.put("arrowup", "\u2191");
      glyphList.put("arrowupdn", "\u2195");
      glyphList.put("arrowupdnbse", "\u21A8");
      glyphList.put("arrowupdownbase", "\u21A8");
      glyphList.put("arrowupleft", "\u2196");
      glyphList.put("arrowupleftofdown", "\u21C5");
      glyphList.put("arrowupright", "\u2197");
      glyphList.put("arrowupwhite", "\u21E7");
      glyphList.put("arrowvertex", "\uF8E6");
      glyphList.put("asciicircum", "\u005E");
      glyphList.put("asciicircummonospace", "\uFF3E");
      glyphList.put("asciitilde", "\u007E");
      glyphList.put("asciitildemonospace", "\uFF5E");
      glyphList.put("ascript", "\u0251");
      glyphList.put("ascriptturned", "\u0252");
      glyphList.put("asmallhiragana", "\u3041");
      glyphList.put("asmallkatakana", "\u30A1");
      glyphList.put("asmallkatakanahalfwidth", "\uFF67");
      glyphList.put("asterisk", "\u002A");
      glyphList.put("asteriskaltonearabic", "\u066D");
      glyphList.put("asteriskarabic", "\u066D");
      glyphList.put("asteriskmath", "\u2217");
      glyphList.put("asteriskmonospace", "\uFF0A");
      glyphList.put("asterisksmall", "\uFE61");
      glyphList.put("asterism", "\u2042");
      glyphList.put("asuperior", "\uF6E9");
      glyphList.put("asymptoticallyequal", "\u2243");
      glyphList.put("at", "\u0040");
      glyphList.put("atilde", "\u00E3");
      glyphList.put("atmonospace", "\uFF20");
      glyphList.put("atsmall", "\uFE6B");
      glyphList.put("aturned", "\u0250");
      glyphList.put("aubengali", "\u0994");
      glyphList.put("aubopomofo", "\u3120");
      glyphList.put("audeva", "\u0914");
      glyphList.put("augujarati", "\u0A94");
      glyphList.put("augurmukhi", "\u0A14");
      glyphList.put("aulengthmarkbengali", "\u09D7");
      glyphList.put("aumatragurmukhi", "\u0A4C");
      glyphList.put("auvowelsignbengali", "\u09CC");
      glyphList.put("auvowelsigndeva", "\u094C");
      glyphList.put("auvowelsigngujarati", "\u0ACC");
      glyphList.put("avagrahadeva", "\u093D");
      glyphList.put("aybarmenian", "\u0561");
      glyphList.put("ayin", "\u05E2");
      glyphList.put("ayinaltonehebrew", "\uFB20");
      glyphList.put("ayinhebrew", "\u05E2");
      glyphList.put("b", "\u0062");
      glyphList.put("babengali", "\u09AC");
      glyphList.put("backslash", "\\");
      glyphList.put("backslashmonospace", "\uFF3C");
      glyphList.put("badeva", "\u092C");
      glyphList.put("bagujarati", "\u0AAC");
      glyphList.put("bagurmukhi", "\u0A2C");
      glyphList.put("bahiragana", "\u3070");
      glyphList.put("bahtthai", "\u0E3F");
      glyphList.put("bakatakana", "\u30D0");
      glyphList.put("bar", "\u007C");
      glyphList.put("barmonospace", "\uFF5C");
      glyphList.put("bbopomofo", "\u3105");
      glyphList.put("bcircle", "\u24D1");
      glyphList.put("bdotaccent", "\u1E03");
      glyphList.put("bdotbelow", "\u1E05");
      glyphList.put("beamedsixteenthnotes", "\u266C");
      glyphList.put("because", "\u2235");
      glyphList.put("becyrillic", "\u0431");
      glyphList.put("beharabic", "\u0628");
      glyphList.put("behfinalarabic", "\uFE90");
      glyphList.put("behinitialarabic", "\uFE91");
      glyphList.put("behiragana", "\u3079");
      glyphList.put("behmedialarabic", "\uFE92");
      glyphList.put("behmeeminitialarabic", "\uFC9F");
      glyphList.put("behmeemisolatedarabic", "\uFC08");
      glyphList.put("behnoonfinalarabic", "\uFC6D");
      glyphList.put("bekatakana", "\u30D9");
      glyphList.put("benarmenian", "\u0562");
      glyphList.put("bet", "\u05D1");
      glyphList.put("beta", "\u03B2");
      glyphList.put("betasymbolgreek", "\u03D0");
      glyphList.put("betdagesh", "\uFB31");
      glyphList.put("betdageshhebrew", "\uFB31");
      glyphList.put("bethebrew", "\u05D1");
      glyphList.put("betrafehebrew", "\uFB4C");
      glyphList.put("bhabengali", "\u09AD");
      glyphList.put("bhadeva", "\u092D");
      glyphList.put("bhagujarati", "\u0AAD");
      glyphList.put("bhagurmukhi", "\u0A2D");
      glyphList.put("bhook", "\u0253");
      glyphList.put("bihiragana", "\u3073");
      glyphList.put("bikatakana", "\u30D3");
      glyphList.put("bilabialclick", "\u0298");
      glyphList.put("bindigurmukhi", "\u0A02");
      glyphList.put("birusquare", "\u3331");
      glyphList.put("blackcircle", "\u25CF");
      glyphList.put("blackdiamond", "\u25C6");
      glyphList.put("blackdownpointingtriangle", "\u25BC");
      glyphList.put("blackleftpointingpointer", "\u25C4");
      glyphList.put("blackleftpointingtriangle", "\u25C0");
      glyphList.put("blacklenticularbracketleft", "\u3010");
      glyphList.put("blacklenticularbracketleftvertical", "\uFE3B");
      glyphList.put("blacklenticularbracketright", "\u3011");
      glyphList.put("blacklenticularbracketrightvertical", "\uFE3C");
      glyphList.put("blacklowerlefttriangle", "\u25E3");
      glyphList.put("blacklowerrighttriangle", "\u25E2");
      glyphList.put("blackrectangle", "\u25AC");
      glyphList.put("blackrightpointingpointer", "\u25BA");
      glyphList.put("blackrightpointingtriangle", "\u25B6");
      glyphList.put("blacksmallsquare", "\u25AA");
      glyphList.put("blacksmilingface", "\u263B");
      glyphList.put("blacksquare", "\u25A0");
      glyphList.put("blackstar", "\u2605");
      glyphList.put("blackupperlefttriangle", "\u25E4");
      glyphList.put("blackupperrighttriangle", "\u25E5");
      glyphList.put("blackuppointingsmalltriangle", "\u25B4");
      glyphList.put("blackuppointingtriangle", "\u25B2");
      glyphList.put("blank", "\u2423");
      glyphList.put("blinebelow", "\u1E07");
      glyphList.put("block", "\u2588");
      glyphList.put("bmonospace", "\uFF42");
      glyphList.put("bobaimaithai", "\u0E1A");
      glyphList.put("bohiragana", "\u307C");
      glyphList.put("bokatakana", "\u30DC");
      glyphList.put("bparen", "\u249D");
      glyphList.put("bqsquare", "\u33C3");
      glyphList.put("braceex", "\uF8F4");
      glyphList.put("braceleft", "\u007B");
      glyphList.put("braceleftbt", "\uF8F3");
      glyphList.put("braceleftmid", "\uF8F2");
      glyphList.put("braceleftmonospace", "\uFF5B");
      glyphList.put("braceleftsmall", "\uFE5B");
      glyphList.put("bracelefttp", "\uF8F1");
      glyphList.put("braceleftvertical", "\uFE37");
      glyphList.put("braceright", "\u007D");
      glyphList.put("bracerightbt", "\uF8FE");
      glyphList.put("bracerightmid", "\uF8FD");
      glyphList.put("bracerightmonospace", "\uFF5D");
      glyphList.put("bracerightsmall", "\uFE5C");
      glyphList.put("bracerighttp", "\uF8FC");
      glyphList.put("bracerightvertical", "\uFE38");
      glyphList.put("bracketleft", "\u005B");
      glyphList.put("bracketleftbt", "\uF8F0");
      glyphList.put("bracketleftex", "\uF8EF");
      glyphList.put("bracketleftmonospace", "\uFF3B");
      glyphList.put("bracketlefttp", "\uF8EE");
      glyphList.put("bracketright", "\u005D");
      glyphList.put("bracketrightbt", "\uF8FB");
      glyphList.put("bracketrightex", "\uF8FA");
      glyphList.put("bracketrightmonospace", "\uFF3D");
      glyphList.put("bracketrighttp", "\uF8F9");
      glyphList.put("breve", "\u02D8");
      glyphList.put("brevebelowcmb", "\u032E");
      glyphList.put("brevecmb", "\u0306");
      glyphList.put("breveinvertedbelowcmb", "\u032F");
      glyphList.put("breveinvertedcmb", "\u0311");
      glyphList.put("breveinverteddoublecmb", "\u0361");
      glyphList.put("bridgebelowcmb", "\u032A");
      glyphList.put("bridgeinvertedbelowcmb", "\u033A");
      glyphList.put("brokenbar", "\u00A6");
      glyphList.put("bstroke", "\u0180");
      glyphList.put("bsuperior", "\uF6EA");
      glyphList.put("btopbar", "\u0183");
      glyphList.put("buhiragana", "\u3076");
      glyphList.put("bukatakana", "\u30D6");
      glyphList.put("bullet", "\u2022");
      glyphList.put("bulletinverse", "\u25D8");
      glyphList.put("bulletoperator", "\u2219");
      glyphList.put("bullseye", "\u25CE");
      glyphList.put("c", "\u0063");
      glyphList.put("caarmenian", "\u056E");
      glyphList.put("cabengali", "\u099A");
      glyphList.put("cacute", "\u0107");
      glyphList.put("cadeva", "\u091A");
      glyphList.put("cagujarati", "\u0A9A");
      glyphList.put("cagurmukhi", "\u0A1A");
      glyphList.put("calsquare", "\u3388");
      glyphList.put("candrabindubengali", "\u0981");
      glyphList.put("candrabinducmb", "\u0310");
      glyphList.put("candrabindudeva", "\u0901");
      glyphList.put("candrabindugujarati", "\u0A81");
      glyphList.put("capslock", "\u21EA");
      glyphList.put("careof", "\u2105");
      glyphList.put("caron", "\u02C7");
      glyphList.put("caronbelowcmb", "\u032C");
      glyphList.put("caroncmb", "\u030C");
      glyphList.put("carriagereturn", "\u21B5");
      glyphList.put("cbopomofo", "\u3118");
      glyphList.put("ccaron", "\u010D");
      glyphList.put("ccedilla", "\u00E7");
      glyphList.put("ccedillaacute", "\u1E09");
      glyphList.put("ccircle", "\u24D2");
      glyphList.put("ccircumflex", "\u0109");
      glyphList.put("ccurl", "\u0255");
      glyphList.put("cdot", "\u010B");
      glyphList.put("cdotaccent", "\u010B");
      glyphList.put("cdsquare", "\u33C5");
      glyphList.put("cedilla", "\u00B8");
      glyphList.put("cedillacmb", "\u0327");
      glyphList.put("cent", "\u00A2");
      glyphList.put("centigrade", "\u2103");
      glyphList.put("centinferior", "\uF6DF");
      glyphList.put("centmonospace", "\uFFE0");
      glyphList.put("centoldstyle", "\uF7A2");
      glyphList.put("centsuperior", "\uF6E0");
      glyphList.put("chaarmenian", "\u0579");
      glyphList.put("chabengali", "\u099B");
      glyphList.put("chadeva", "\u091B");
      glyphList.put("chagujarati", "\u0A9B");
      glyphList.put("chagurmukhi", "\u0A1B");
      glyphList.put("chbopomofo", "\u3114");
      glyphList.put("cheabkhasiancyrillic", "\u04BD");
      glyphList.put("checkmark", "\u2713");
      glyphList.put("checyrillic", "\u0447");
      glyphList.put("chedescenderabkhasiancyrillic", "\u04BF");
      glyphList.put("chedescendercyrillic", "\u04B7");
      glyphList.put("chedieresiscyrillic", "\u04F5");
      glyphList.put("cheharmenian", "\u0573");
      glyphList.put("chekhakassiancyrillic", "\u04CC");
      glyphList.put("cheverticalstrokecyrillic", "\u04B9");
      glyphList.put("chi", "\u03C7");
      glyphList.put("chieuchacirclekorean", "\u3277");
      glyphList.put("chieuchaparenkorean", "\u3217");
      glyphList.put("chieuchcirclekorean", "\u3269");
      glyphList.put("chieuchkorean", "\u314A");
      glyphList.put("chieuchparenkorean", "\u3209");
      glyphList.put("chochangthai", "\u0E0A");
      glyphList.put("chochanthai", "\u0E08");
      glyphList.put("chochingthai", "\u0E09");
      glyphList.put("chochoethai", "\u0E0C");
      glyphList.put("chook", "\u0188");
      glyphList.put("cieucacirclekorean", "\u3276");
      glyphList.put("cieucaparenkorean", "\u3216");
      glyphList.put("cieuccirclekorean", "\u3268");
      glyphList.put("cieuckorean", "\u3148");
      glyphList.put("cieucparenkorean", "\u3208");
      glyphList.put("cieucuparenkorean", "\u321C");
      glyphList.put("circle", "\u25CB");
      glyphList.put("circlemultiply", "\u2297");
      glyphList.put("circleot", "\u2299");
      glyphList.put("circleplus", "\u2295");
      glyphList.put("circlepostalmark", "\u3036");
      glyphList.put("circlewithlefthalfblack", "\u25D0");
      glyphList.put("circlewithrighthalfblack", "\u25D1");
      glyphList.put("circumflex", "\u02C6");
      glyphList.put("circumflexbelowcmb", "\u032D");
      glyphList.put("circumflexcmb", "\u0302");
      glyphList.put("clear", "\u2327");
      glyphList.put("clickalveolar", "\u01C2");
      glyphList.put("clickdental", "\u01C0");
      glyphList.put("clicklateral", "\u01C1");
      glyphList.put("clickretroflex", "\u01C3");
      glyphList.put("club", "\u2663");
      glyphList.put("clubsuitblack", "\u2663");
      glyphList.put("clubsuitwhite", "\u2667");
      glyphList.put("cmcubedsquare", "\u33A4");
      glyphList.put("cmonospace", "\uFF43");
      glyphList.put("cmsquaredsquare", "\u33A0");
      glyphList.put("coarmenian", "\u0581");
      glyphList.put("colon", "\u003A");
      glyphList.put("colonmonetary", "\u20A1");
      glyphList.put("colonmonospace", "\uFF1A");
      glyphList.put("colonsign", "\u20A1");
      glyphList.put("colonsmall", "\uFE55");
      glyphList.put("colontriangularhalfmod", "\u02D1");
      glyphList.put("colontriangularmod", "\u02D0");
      glyphList.put("comma", "\u002C");
      glyphList.put("commaabovecmb", "\u0313");
      glyphList.put("commaaboverightcmb", "\u0315");
      glyphList.put("commaaccent", "\uF6C3");
      glyphList.put("commaarabic", "\u060C");
      glyphList.put("commaarmenian", "\u055D");
      glyphList.put("commainferior", "\uF6E1");
      glyphList.put("commamonospace", "\uFF0C");
      glyphList.put("commareversedabovecmb", "\u0314");
      glyphList.put("commareversedmod", "\u02BD");
      glyphList.put("commasmall", "\uFE50");
      glyphList.put("commasuperior", "\uF6E2");
      glyphList.put("commaturnedabovecmb", "\u0312");
      glyphList.put("commaturnedmod", "\u02BB");
      glyphList.put("compass", "\u263C");
      glyphList.put("congruent", "\u2245");
      glyphList.put("contourintegral", "\u222E");
      glyphList.put("control", "\u2303");
      glyphList.put("controlACK", "\u0006");
      glyphList.put("controlBEL", "\u0007");
      glyphList.put("controlBS", "\u0008");
      glyphList.put("controlCAN", "\u0018");
      glyphList.put("controlCR", "\r");
      glyphList.put("controlDC1", "\u0011");
      glyphList.put("controlDC2", "\u0012");
      glyphList.put("controlDC3", "\u0013");
      glyphList.put("controlDC4", "\u0014");
      glyphList.put("controlDEL", "\u007F");
      glyphList.put("controlDLE", "\u0010");
      glyphList.put("controlEM", "\u0019");
      glyphList.put("controlENQ", "\u0005");
      glyphList.put("controlEOT", "\u0004");
      glyphList.put("controlESC", "\u001B");
      glyphList.put("controlETB", "\u0017");
      glyphList.put("controlETX", "\u0003");
      glyphList.put("controlFF", "\u000C");
      glyphList.put("controlFS", "\u001C");
      glyphList.put("controlGS", "\u001D");
      glyphList.put("controlHT", "\u0009");
      glyphList.put("controlLF", "\n");
      glyphList.put("controlNAK", "\u0015");
      glyphList.put("controlRS", "\u001E");
      glyphList.put("controlSI", "\u000F");
      glyphList.put("controlSO", "\u000E");
      glyphList.put("controlSOT", "\u0002");
      glyphList.put("controlSTX", "\u0001");
      glyphList.put("controlSUB", "\u001A");
      glyphList.put("controlSYN", "\u0016");
      glyphList.put("controlUS", "\u001F");
      glyphList.put("controlVT", "\u000B");
      glyphList.put("copyright", "\u00A9");
      glyphList.put("copyrightsans", "\uF8E9");
      glyphList.put("copyrightserif", "\uF6D9");
      glyphList.put("cornerbracketleft", "\u300C");
      glyphList.put("cornerbracketlefthalfwidth", "\uFF62");
      glyphList.put("cornerbracketleftvertical", "\uFE41");
      glyphList.put("cornerbracketright", "\u300D");
      glyphList.put("cornerbracketrighthalfwidth", "\uFF63");
      glyphList.put("cornerbracketrightvertical", "\uFE42");
      glyphList.put("corporationsquare", "\u337F");
      glyphList.put("cosquare", "\u33C7");
      glyphList.put("coverkgsquare", "\u33C6");
      glyphList.put("cparen", "\u249E");
      glyphList.put("cruzeiro", "\u20A2");
      glyphList.put("cstretched", "\u0297");
      glyphList.put("curlyand", "\u22CF");
      glyphList.put("curlyor", "\u22CE");
      glyphList.put("currency", "\u00A4");
      glyphList.put("cyrBreve", "\uF6D1");
      glyphList.put("cyrFlex", "\uF6D2");
      glyphList.put("cyrbreve", "\uF6D4");
      glyphList.put("cyrflex", "\uF6D5");
      glyphList.put("d", "\u0064");
      glyphList.put("daarmenian", "\u0564");
      glyphList.put("dabengali", "\u09A6");
      glyphList.put("dadarabic", "\u0636");
      glyphList.put("dadeva", "\u0926");
      glyphList.put("dadfinalarabic", "\uFEBE");
      glyphList.put("dadinitialarabic", "\uFEBF");
      glyphList.put("dadmedialarabic", "\uFEC0");
      glyphList.put("dagesh", "\u05BC");
      glyphList.put("dageshhebrew", "\u05BC");
      glyphList.put("dagger", "\u2020");
      glyphList.put("daggerdbl", "\u2021");
      glyphList.put("dagujarati", "\u0AA6");
      glyphList.put("dagurmukhi", "\u0A26");
      glyphList.put("dahiragana", "\u3060");
      glyphList.put("dakatakana", "\u30C0");
      glyphList.put("dalarabic", "\u062F");
      glyphList.put("dalet", "\u05D3");
      glyphList.put("daletdagesh", "\uFB33");
      glyphList.put("daletdageshhebrew", "\uFB33");
      glyphList.put("dalethatafpatah", "\u05D3\u05B2");
      glyphList.put("dalethatafpatahhebrew", "\u05D3\u05B2");
      glyphList.put("dalethatafsegol", "\u05D3\u05B1");
      glyphList.put("dalethatafsegolhebrew", "\u05D3\u05B1");
      glyphList.put("dalethebrew", "\u05D3");
      glyphList.put("dalethiriq", "\u05D3\u05B4");
      glyphList.put("dalethiriqhebrew", "\u05D3\u05B4");
      glyphList.put("daletholam", "\u05D3\u05B9");
      glyphList.put("daletholamhebrew", "\u05D3\u05B9");
      glyphList.put("daletpatah", "\u05D3\u05B7");
      glyphList.put("daletpatahhebrew", "\u05D3\u05B7");
      glyphList.put("daletqamats", "\u05D3\u05B8");
      glyphList.put("daletqamatshebrew", "\u05D3\u05B8");
      glyphList.put("daletqubuts", "\u05D3\u05BB");
      glyphList.put("daletqubutshebrew", "\u05D3\u05BB");
      glyphList.put("daletsegol", "\u05D3\u05B6");
      glyphList.put("daletsegolhebrew", "\u05D3\u05B6");
      glyphList.put("daletsheva", "\u05D3\u05B0");
      glyphList.put("daletshevahebrew", "\u05D3\u05B0");
      glyphList.put("dalettsere", "\u05D3\u05B5");
      glyphList.put("dalettserehebrew", "\u05D3\u05B5");
      glyphList.put("dalfinalarabic", "\uFEAA");
      glyphList.put("dammaarabic", "\u064F");
      glyphList.put("dammalowarabic", "\u064F");
      glyphList.put("dammatanaltonearabic", "\u064C");
      glyphList.put("dammatanarabic", "\u064C");
      glyphList.put("danda", "\u0964");
      glyphList.put("dargahebrew", "\u05A7");
      glyphList.put("dargalefthebrew", "\u05A7");
      glyphList.put("dasiapneumatacyrilliccmb", "\u0485");
      glyphList.put("dblGrave", "\uF6D3");
      glyphList.put("dblanglebracketleft", "\u300A");
      glyphList.put("dblanglebracketleftvertical", "\uFE3D");
      glyphList.put("dblanglebracketright", "\u300B");
      glyphList.put("dblanglebracketrightvertical", "\uFE3E");
      glyphList.put("dblarchinvertedbelowcmb", "\u032B");
      glyphList.put("dblarrowleft", "\u21D4");
      glyphList.put("dblarrowright", "\u21D2");
      glyphList.put("dbldanda", "\u0965");
      glyphList.put("dblgrave", "\uF6D6");
      glyphList.put("dblgravecmb", "\u030F");
      glyphList.put("dblintegral", "\u222C");
      glyphList.put("dbllowline", "\u2017");
      glyphList.put("dbllowlinecmb", "\u0333");
      glyphList.put("dbloverlinecmb", "\u033F");
      glyphList.put("dblprimemod", "\u02BA");
      glyphList.put("dblverticalbar", "\u2016");
      glyphList.put("dblverticallineabovecmb", "\u030E");
      glyphList.put("dbopomofo", "\u3109");
      glyphList.put("dbsquare", "\u33C8");
      glyphList.put("dcaron", "\u010F");
      glyphList.put("dcedilla", "\u1E11");
      glyphList.put("dcircle", "\u24D3");
      glyphList.put("dcircumflexbelow", "\u1E13");
      glyphList.put("dcroat", "\u0111");
      glyphList.put("ddabengali", "\u09A1");
      glyphList.put("ddadeva", "\u0921");
      glyphList.put("ddagujarati", "\u0AA1");
      glyphList.put("ddagurmukhi", "\u0A21");
      glyphList.put("ddalarabic", "\u0688");
      glyphList.put("ddalfinalarabic", "\uFB89");
      glyphList.put("dddhadeva", "\u095C");
      glyphList.put("ddhabengali", "\u09A2");
      glyphList.put("ddhadeva", "\u0922");
      glyphList.put("ddhagujarati", "\u0AA2");
      glyphList.put("ddhagurmukhi", "\u0A22");
      glyphList.put("ddotaccent", "\u1E0B");
      glyphList.put("ddotbelow", "\u1E0D");
      glyphList.put("decimalseparatorarabic", "\u066B");
      glyphList.put("decimalseparatorpersian", "\u066B");
      glyphList.put("decyrillic", "\u0434");
      glyphList.put("degree", "\u00B0");
      glyphList.put("dehihebrew", "\u05AD");
      glyphList.put("dehiragana", "\u3067");
      glyphList.put("deicoptic", "\u03EF");
      glyphList.put("dekatakana", "\u30C7");
      glyphList.put("deleteleft", "\u232B");
      glyphList.put("deleteright", "\u2326");
      glyphList.put("delta", "\u03B4");
      glyphList.put("deltaturned", "\u018D");
      glyphList.put("denominatorminusonenumeratorbengali", "\u09F8");
      glyphList.put("dezh", "\u02A4");
      glyphList.put("dhabengali", "\u09A7");
      glyphList.put("dhadeva", "\u0927");
      glyphList.put("dhagujarati", "\u0AA7");
      glyphList.put("dhagurmukhi", "\u0A27");
      glyphList.put("dhook", "\u0257");
      glyphList.put("dialytikatonos", "\u0385");
      glyphList.put("dialytikatonoscmb", "\u0344");
      glyphList.put("diamond", "\u2666");
      glyphList.put("diamondsuitwhite", "\u2662");
      glyphList.put("dieresis", "\u00A8");
      glyphList.put("dieresisacute", "\uF6D7");
      glyphList.put("dieresisbelowcmb", "\u0324");
      glyphList.put("dieresiscmb", "\u0308");
      glyphList.put("dieresisgrave", "\uF6D8");
      glyphList.put("dieresistonos", "\u0385");
      glyphList.put("dihiragana", "\u3062");
      glyphList.put("dikatakana", "\u30C2");
      glyphList.put("dittomark", "\u3003");
      glyphList.put("divide", "\u00F7");
      glyphList.put("divides", "\u2223");
      glyphList.put("divisionslash", "\u2215");
      glyphList.put("djecyrillic", "\u0452");
      glyphList.put("dkshade", "\u2593");
      glyphList.put("dlinebelow", "\u1E0F");
      glyphList.put("dlsquare", "\u3397");
      glyphList.put("dmacron", "\u0111");
      glyphList.put("dmonospace", "\uFF44");
      glyphList.put("dnblock", "\u2584");
      glyphList.put("dochadathai", "\u0E0E");
      glyphList.put("dodekthai", "\u0E14");
      glyphList.put("dohiragana", "\u3069");
      glyphList.put("dokatakana", "\u30C9");
      glyphList.put("dollar", "\u0024");
      glyphList.put("dollarinferior", "\uF6E3");
      glyphList.put("dollarmonospace", "\uFF04");
      glyphList.put("dollaroldstyle", "\uF724");
      glyphList.put("dollarsmall", "\uFE69");
      glyphList.put("dollarsuperior", "\uF6E4");
      glyphList.put("dong", "\u20AB");
      glyphList.put("dorusquare", "\u3326");
      glyphList.put("dotaccent", "\u02D9");
      glyphList.put("dotaccentcmb", "\u0307");
      glyphList.put("dotbelowcmb", "\u0323");
      glyphList.put("dotbelowcomb", "\u0323");
      glyphList.put("dotkatakana", "\u30FB");
      glyphList.put("dotlessi", "\u0131");
      glyphList.put("dotlessj", "\uF6BE");
      glyphList.put("dotlessjstrokehook", "\u0284");
      glyphList.put("dotmath", "\u22C5");
      glyphList.put("dottedcircle", "\u25CC");
      glyphList.put("doubleyodpatah", "\uFB1F");
      glyphList.put("doubleyodpatahhebrew", "\uFB1F");
      glyphList.put("downtackbelowcmb", "\u031E");
      glyphList.put("downtackmod", "\u02D5");
      glyphList.put("dparen", "\u249F");
      glyphList.put("dsuperior", "\uF6EB");
      glyphList.put("dtail", "\u0256");
      glyphList.put("dtopbar", "\u018C");
      glyphList.put("duhiragana", "\u3065");
      glyphList.put("dukatakana", "\u30C5");
      glyphList.put("dz", "\u01F3");
      glyphList.put("dzaltone", "\u02A3");
      glyphList.put("dzcaron", "\u01C6");
      glyphList.put("dzcurl", "\u02A5");
      glyphList.put("dzeabkhasiancyrillic", "\u04E1");
      glyphList.put("dzecyrillic", "\u0455");
      glyphList.put("dzhecyrillic", "\u045F");
      glyphList.put("e", "\u0065");
      glyphList.put("eacute", "\u00E9");
      glyphList.put("earth", "\u2641");
      glyphList.put("ebengali", "\u098F");
      glyphList.put("ebopomofo", "\u311C");
      glyphList.put("ebreve", "\u0115");
      glyphList.put("ecandradeva", "\u090D");
      glyphList.put("ecandragujarati", "\u0A8D");
      glyphList.put("ecandravowelsigndeva", "\u0945");
      glyphList.put("ecandravowelsigngujarati", "\u0AC5");
      glyphList.put("ecaron", "\u011B");
      glyphList.put("ecedillabreve", "\u1E1D");
      glyphList.put("echarmenian", "\u0565");
      glyphList.put("echyiwnarmenian", "\u0587");
      glyphList.put("ecircle", "\u24D4");
      glyphList.put("ecircumflex", "\u00EA");
      glyphList.put("ecircumflexacute", "\u1EBF");
      glyphList.put("ecircumflexbelow", "\u1E19");
      glyphList.put("ecircumflexdotbelow", "\u1EC7");
      glyphList.put("ecircumflexgrave", "\u1EC1");
      glyphList.put("ecircumflexhookabove", "\u1EC3");
      glyphList.put("ecircumflextilde", "\u1EC5");
      glyphList.put("ecyrillic", "\u0454");
      glyphList.put("edblgrave", "\u0205");
      glyphList.put("edeva", "\u090F");
      glyphList.put("edieresis", "\u00EB");
      glyphList.put("edot", "\u0117");
      glyphList.put("edotaccent", "\u0117");
      glyphList.put("edotbelow", "\u1EB9");
      glyphList.put("eegurmukhi", "\u0A0F");
      glyphList.put("eematragurmukhi", "\u0A47");
      glyphList.put("efcyrillic", "\u0444");
      glyphList.put("egrave", "\u00E8");
      glyphList.put("egujarati", "\u0A8F");
      glyphList.put("eharmenian", "\u0567");
      glyphList.put("ehbopomofo", "\u311D");
      glyphList.put("ehiragana", "\u3048");
      glyphList.put("ehookabove", "\u1EBB");
      glyphList.put("eibopomofo", "\u311F");
      glyphList.put("eight", "\u0038");
      glyphList.put("eightarabic", "\u0668");
      glyphList.put("eightbengali", "\u09EE");
      glyphList.put("eightcircle", "\u2467");
      glyphList.put("eightcircleinversesansserif", "\u2791");
      glyphList.put("eightdeva", "\u096E");
      glyphList.put("eighteencircle", "\u2471");
      glyphList.put("eighteenparen", "\u2485");
      glyphList.put("eighteenperiod", "\u2499");
      glyphList.put("eightgujarati", "\u0AEE");
      glyphList.put("eightgurmukhi", "\u0A6E");
      glyphList.put("eighthackarabic", "\u0668");
      glyphList.put("eighthangzhou", "\u3028");
      glyphList.put("eighthnotebeamed", "\u266B");
      glyphList.put("eightideographicparen", "\u3227");
      glyphList.put("eightinferior", "\u2088");
      glyphList.put("eightmonospace", "\uFF18");
      glyphList.put("eightoldstyle", "\uF738");
      glyphList.put("eightparen", "\u247B");
      glyphList.put("eightperiod", "\u248F");
      glyphList.put("eightpersian", "\u06F8");
      glyphList.put("eightroman", "\u2177");
      glyphList.put("eightsuperior", "\u2078");
      glyphList.put("eightthai", "\u0E58");
      glyphList.put("einvertedbreve", "\u0207");
      glyphList.put("eiotifiedcyrillic", "\u0465");
      glyphList.put("ekatakana", "\u30A8");
      glyphList.put("ekatakanahalfwidth", "\uFF74");
      glyphList.put("ekonkargurmukhi", "\u0A74");
      glyphList.put("ekorean", "\u3154");
      glyphList.put("elcyrillic", "\u043B");
      glyphList.put("element", "\u2208");
      glyphList.put("elevencircle", "\u246A");
      glyphList.put("elevenparen", "\u247E");
      glyphList.put("elevenperiod", "\u2492");
      glyphList.put("elevenroman", "\u217A");
      glyphList.put("ellipsis", "\u2026");
      glyphList.put("ellipsisvertical", "\u22EE");
      glyphList.put("emacron", "\u0113");
      glyphList.put("emacronacute", "\u1E17");
      glyphList.put("emacrongrave", "\u1E15");
      glyphList.put("emcyrillic", "\u043C");
      glyphList.put("emdash", "\u2014");
      glyphList.put("emdashvertical", "\uFE31");
      glyphList.put("emonospace", "\uFF45");
      glyphList.put("emphasismarkarmenian", "\u055B");
      glyphList.put("emptyset", "\u2205");
      glyphList.put("enbopomofo", "\u3123");
      glyphList.put("encyrillic", "\u043D");
      glyphList.put("endash", "\u2013");
      glyphList.put("endashvertical", "\uFE32");
      glyphList.put("endescendercyrillic", "\u04A3");
      glyphList.put("eng", "\u014B");
      glyphList.put("engbopomofo", "\u3125");
      glyphList.put("enghecyrillic", "\u04A5");
      glyphList.put("enhookcyrillic", "\u04C8");
      glyphList.put("enspace", "\u2002");
      glyphList.put("eogonek", "\u0119");
      glyphList.put("eokorean", "\u3153");
      glyphList.put("eopen", "\u025B");
      glyphList.put("eopenclosed", "\u029A");
      glyphList.put("eopenreversed", "\u025C");
      glyphList.put("eopenreversedclosed", "\u025E");
      glyphList.put("eopenreversedhook", "\u025D");
      glyphList.put("eparen", "\u24A0");
      glyphList.put("epsilon", "\u03B5");
      glyphList.put("epsilontonos", "\u03AD");
      glyphList.put("equal", "\u003D");
      glyphList.put("equalmonospace", "\uFF1D");
      glyphList.put("equalsmall", "\uFE66");
      glyphList.put("equalsuperior", "\u207C");
      glyphList.put("equivalence", "\u2261");
      glyphList.put("erbopomofo", "\u3126");
      glyphList.put("ercyrillic", "\u0440");
      glyphList.put("ereversed", "\u0258");
      glyphList.put("ereversedcyrillic", "\u044D");
      glyphList.put("escyrillic", "\u0441");
      glyphList.put("esdescendercyrillic", "\u04AB");
      glyphList.put("esh", "\u0283");
      glyphList.put("eshcurl", "\u0286");
      glyphList.put("eshortdeva", "\u090E");
      glyphList.put("eshortvowelsigndeva", "\u0946");
      glyphList.put("eshreversedloop", "\u01AA");
      glyphList.put("eshsquatreversed", "\u0285");
      glyphList.put("esmallhiragana", "\u3047");
      glyphList.put("esmallkatakana", "\u30A7");
      glyphList.put("esmallkatakanahalfwidth", "\uFF6A");
      glyphList.put("estimated", "\u212E");
      glyphList.put("esuperior", "\uF6EC");
      glyphList.put("eta", "\u03B7");
      glyphList.put("etarmenian", "\u0568");
      glyphList.put("etatonos", "\u03AE");
      glyphList.put("eth", "\u00F0");
      glyphList.put("etilde", "\u1EBD");
      glyphList.put("etildebelow", "\u1E1B");
      glyphList.put("etnahtafoukhhebrew", "\u0591");
      glyphList.put("etnahtafoukhlefthebrew", "\u0591");
      glyphList.put("etnahtahebrew", "\u0591");
      glyphList.put("etnahtalefthebrew", "\u0591");
      glyphList.put("eturned", "\u01DD");
      glyphList.put("eukorean", "\u3161");
      glyphList.put("euro", "\u20AC");
      glyphList.put("evowelsignbengali", "\u09C7");
      glyphList.put("evowelsigndeva", "\u0947");
      glyphList.put("evowelsigngujarati", "\u0AC7");
      glyphList.put("exclam", "\u0021");
      glyphList.put("exclamarmenian", "\u055C");
      glyphList.put("exclamdbl", "\u203C");
      glyphList.put("exclamdown", "\u00A1");
      glyphList.put("exclamdownsmall", "\uF7A1");
      glyphList.put("exclammonospace", "\uFF01");
      glyphList.put("exclamsmall", "\uF721");
      glyphList.put("existential", "\u2203");
      glyphList.put("ezh", "\u0292");
      glyphList.put("ezhcaron", "\u01EF");
      glyphList.put("ezhcurl", "\u0293");
      glyphList.put("ezhreversed", "\u01B9");
      glyphList.put("ezhtail", "\u01BA");
      glyphList.put("f", "\u0066");
      glyphList.put("fadeva", "\u095E");
      glyphList.put("fagurmukhi", "\u0A5E");
      glyphList.put("fahrenheit", "\u2109");
      glyphList.put("fathaarabic", "\u064E");
      glyphList.put("fathalowarabic", "\u064E");
      glyphList.put("fathatanarabic", "\u064B");
      glyphList.put("fbopomofo", "\u3108");
      glyphList.put("fcircle", "\u24D5");
      glyphList.put("fdotaccent", "\u1E1F");
      glyphList.put("feharabic", "\u0641");
      glyphList.put("feharmenian", "\u0586");
      glyphList.put("fehfinalarabic", "\uFED2");
      glyphList.put("fehinitialarabic", "\uFED3");
      glyphList.put("fehmedialarabic", "\uFED4");
      glyphList.put("feicoptic", "\u03E5");
      glyphList.put("female", "\u2640");
      glyphList.put("ff", "\uFB00");
      glyphList.put("ffi", "\uFB03");
      glyphList.put("ffl", "\uFB04");
      glyphList.put("fi", "\uFB01");
      glyphList.put("fifteencircle", "\u246E");
      glyphList.put("fifteenparen", "\u2482");
      glyphList.put("fifteenperiod", "\u2496");
      glyphList.put("figuredash", "\u2012");
      glyphList.put("filledbox", "\u25A0");
      glyphList.put("filledrect", "\u25AC");
      glyphList.put("finalkaf", "\u05DA");
      glyphList.put("finalkafdagesh", "\uFB3A");
      glyphList.put("finalkafdageshhebrew", "\uFB3A");
      glyphList.put("finalkafhebrew", "\u05DA");
      glyphList.put("finalkafqamats", "\u05DA\u05B8");
      glyphList.put("finalkafqamatshebrew", "\u05DA\u05B8");
      glyphList.put("finalkafsheva", "\u05DA\u05B0");
      glyphList.put("finalkafshevahebrew", "\u05DA\u05B0");
      glyphList.put("finalmem", "\u05DD");
      glyphList.put("finalmemhebrew", "\u05DD");
      glyphList.put("finalnun", "\u05DF");
      glyphList.put("finalnunhebrew", "\u05DF");
      glyphList.put("finalpe", "\u05E3");
      glyphList.put("finalpehebrew", "\u05E3");
      glyphList.put("finaltsadi", "\u05E5");
      glyphList.put("finaltsadihebrew", "\u05E5");
      glyphList.put("firsttonechinese", "\u02C9");
      glyphList.put("fisheye", "\u25C9");
      glyphList.put("fitacyrillic", "\u0473");
      glyphList.put("five", "\u0035");
      glyphList.put("fivearabic", "\u0665");
      glyphList.put("fivebengali", "\u09EB");
      glyphList.put("fivecircle", "\u2464");
      glyphList.put("fivecircleinversesansserif", "\u278E");
      glyphList.put("fivedeva", "\u096B");
      glyphList.put("fiveeighths", "\u215D");
      glyphList.put("fivegujarati", "\u0AEB");
      glyphList.put("fivegurmukhi", "\u0A6B");
      glyphList.put("fivehackarabic", "\u0665");
      glyphList.put("fivehangzhou", "\u3025");
      glyphList.put("fiveideographicparen", "\u3224");
      glyphList.put("fiveinferior", "\u2085");
      glyphList.put("fivemonospace", "\uFF15");
      glyphList.put("fiveoldstyle", "\uF735");
      glyphList.put("fiveparen", "\u2478");
      glyphList.put("fiveperiod", "\u248C");
      glyphList.put("fivepersian", "\u06F5");
      glyphList.put("fiveroman", "\u2174");
      glyphList.put("fivesuperior", "\u2075");
      glyphList.put("fivethai", "\u0E55");
      glyphList.put("fl", "\uFB02");
      glyphList.put("florin", "\u0192");
      glyphList.put("fmonospace", "\uFF46");
      glyphList.put("fmsquare", "\u3399");
      glyphList.put("fofanthai", "\u0E1F");
      glyphList.put("fofathai", "\u0E1D");
      glyphList.put("fongmanthai", "\u0E4F");
      glyphList.put("forall", "\u2200");
      glyphList.put("four", "\u0034");
      glyphList.put("fourarabic", "\u0664");
      glyphList.put("fourbengali", "\u09EA");
      glyphList.put("fourcircle", "\u2463");
      glyphList.put("fourcircleinversesansserif", "\u278D");
      glyphList.put("fourdeva", "\u096A");
      glyphList.put("fourgujarati", "\u0AEA");
      glyphList.put("fourgurmukhi", "\u0A6A");
      glyphList.put("fourhackarabic", "\u0664");
      glyphList.put("fourhangzhou", "\u3024");
      glyphList.put("fourideographicparen", "\u3223");
      glyphList.put("fourinferior", "\u2084");
      glyphList.put("fourmonospace", "\uFF14");
      glyphList.put("fournumeratorbengali", "\u09F7");
      glyphList.put("fouroldstyle", "\uF734");
      glyphList.put("fourparen", "\u2477");
      glyphList.put("fourperiod", "\u248B");
      glyphList.put("fourpersian", "\u06F4");
      glyphList.put("fourroman", "\u2173");
      glyphList.put("foursuperior", "\u2074");
      glyphList.put("fourteencircle", "\u246D");
      glyphList.put("fourteenparen", "\u2481");
      glyphList.put("fourteenperiod", "\u2495");
      glyphList.put("fourthai", "\u0E54");
      glyphList.put("fourthtonechinese", "\u02CB");
      glyphList.put("fparen", "\u24A1");
      glyphList.put("fraction", "\u2044");
      glyphList.put("franc", "\u20A3");
      glyphList.put("g", "\u0067");
      glyphList.put("gabengali", "\u0997");
      glyphList.put("gacute", "\u01F5");
      glyphList.put("gadeva", "\u0917");
      glyphList.put("gafarabic", "\u06AF");
      glyphList.put("gaffinalarabic", "\uFB93");
      glyphList.put("gafinitialarabic", "\uFB94");
      glyphList.put("gafmedialarabic", "\uFB95");
      glyphList.put("gagujarati", "\u0A97");
      glyphList.put("gagurmukhi", "\u0A17");
      glyphList.put("gahiragana", "\u304C");
      glyphList.put("gakatakana", "\u30AC");
      glyphList.put("gamma", "\u03B3");
      glyphList.put("gammalatinsmall", "\u0263");
      glyphList.put("gammasuperior", "\u02E0");
      glyphList.put("gangiacoptic", "\u03EB");
      glyphList.put("gbopomofo", "\u310D");
      glyphList.put("gbreve", "\u011F");
      glyphList.put("gcaron", "\u01E7");
      glyphList.put("gcedilla", "\u0123");
      glyphList.put("gcircle", "\u24D6");
      glyphList.put("gcircumflex", "\u011D");
      glyphList.put("gcommaaccent", "\u0123");
      glyphList.put("gdot", "\u0121");
      glyphList.put("gdotaccent", "\u0121");
      glyphList.put("gecyrillic", "\u0433");
      glyphList.put("gehiragana", "\u3052");
      glyphList.put("gekatakana", "\u30B2");
      glyphList.put("geometricallyequal", "\u2251");
      glyphList.put("gereshaccenthebrew", "\u059C");
      glyphList.put("gereshhebrew", "\u05F3");
      glyphList.put("gereshmuqdamhebrew", "\u059D");
      glyphList.put("germandbls", "\u00DF");
      glyphList.put("gershayimaccenthebrew", "\u059E");
      glyphList.put("gershayimhebrew", "\u05F4");
      glyphList.put("getamark", "\u3013");
      glyphList.put("ghabengali", "\u0998");
      glyphList.put("ghadarmenian", "\u0572");
      glyphList.put("ghadeva", "\u0918");
      glyphList.put("ghagujarati", "\u0A98");
      glyphList.put("ghagurmukhi", "\u0A18");
      glyphList.put("ghainarabic", "\u063A");
      glyphList.put("ghainfinalarabic", "\uFECE");
      glyphList.put("ghaininitialarabic", "\uFECF");
      glyphList.put("ghainmedialarabic", "\uFED0");
      glyphList.put("ghemiddlehookcyrillic", "\u0495");
      glyphList.put("ghestrokecyrillic", "\u0493");
      glyphList.put("gheupturncyrillic", "\u0491");
      glyphList.put("ghhadeva", "\u095A");
      glyphList.put("ghhagurmukhi", "\u0A5A");
      glyphList.put("ghook", "\u0260");
      glyphList.put("ghzsquare", "\u3393");
      glyphList.put("gihiragana", "\u304E");
      glyphList.put("gikatakana", "\u30AE");
      glyphList.put("gimarmenian", "\u0563");
      glyphList.put("gimel", "\u05D2");
      glyphList.put("gimeldagesh", "\uFB32");
      glyphList.put("gimeldageshhebrew", "\uFB32");
      glyphList.put("gimelhebrew", "\u05D2");
      glyphList.put("gjecyrillic", "\u0453");
      glyphList.put("glottalinvertedstroke", "\u01BE");
      glyphList.put("glottalstop", "\u0294");
      glyphList.put("glottalstopinverted", "\u0296");
      glyphList.put("glottalstopmod", "\u02C0");
      glyphList.put("glottalstopreversed", "\u0295");
      glyphList.put("glottalstopreversedmod", "\u02C1");
      glyphList.put("glottalstopreversedsuperior", "\u02E4");
      glyphList.put("glottalstopstroke", "\u02A1");
      glyphList.put("glottalstopstrokereversed", "\u02A2");
      glyphList.put("gmacron", "\u1E21");
      glyphList.put("gmonospace", "\uFF47");
      glyphList.put("gohiragana", "\u3054");
      glyphList.put("gokatakana", "\u30B4");
      glyphList.put("gparen", "\u24A2");
      glyphList.put("gpasquare", "\u33AC");
      glyphList.put("gradient", "\u2207");
      glyphList.put("grave", "\u0060");
      glyphList.put("gravebelowcmb", "\u0316");
      glyphList.put("gravecmb", "\u0300");
      glyphList.put("gravecomb", "\u0300");
      glyphList.put("gravedeva", "\u0953");
      glyphList.put("gravelowmod", "\u02CE");
      glyphList.put("gravemonospace", "\uFF40");
      glyphList.put("gravetonecmb", "\u0340");
      glyphList.put("greater", "\u003E");
      glyphList.put("greaterequal", "\u2265");
      glyphList.put("greaterequalorless", "\u22DB");
      glyphList.put("greatermonospace", "\uFF1E");
      glyphList.put("greaterorequivalent", "\u2273");
      glyphList.put("greaterorless", "\u2277");
      glyphList.put("greateroverequal", "\u2267");
      glyphList.put("greatersmall", "\uFE65");
      glyphList.put("gscript", "\u0261");
      glyphList.put("gstroke", "\u01E5");
      glyphList.put("guhiragana", "\u3050");
      glyphList.put("guillemotleft", "\u00AB");
      glyphList.put("guillemotright", "\u00BB");
      glyphList.put("guilsinglleft", "\u2039");
      glyphList.put("guilsinglright", "\u203A");
      glyphList.put("gukatakana", "\u30B0");
      glyphList.put("guramusquare", "\u3318");
      glyphList.put("gysquare", "\u33C9");
      glyphList.put("h", "\u0068");
      glyphList.put("haabkhasiancyrillic", "\u04A9");
      glyphList.put("haaltonearabic", "\u06C1");
      glyphList.put("habengali", "\u09B9");
      glyphList.put("hadescendercyrillic", "\u04B3");
      glyphList.put("hadeva", "\u0939");
      glyphList.put("hagujarati", "\u0AB9");
      glyphList.put("hagurmukhi", "\u0A39");
      glyphList.put("haharabic", "\u062D");
      glyphList.put("hahfinalarabic", "\uFEA2");
      glyphList.put("hahinitialarabic", "\uFEA3");
      glyphList.put("hahiragana", "\u306F");
      glyphList.put("hahmedialarabic", "\uFEA4");
      glyphList.put("haitusquare", "\u332A");
      glyphList.put("hakatakana", "\u30CF");
      glyphList.put("hakatakanahalfwidth", "\uFF8A");
      glyphList.put("halantgurmukhi", "\u0A4D");
      glyphList.put("hamzaarabic", "\u0621");
      glyphList.put("hamzadammaarabic", "\u0621\u064F");
      glyphList.put("hamzadammatanarabic", "\u0621\u064C");
      glyphList.put("hamzafathaarabic", "\u0621\u064E");
      glyphList.put("hamzafathatanarabic", "\u0621\u064B");
      glyphList.put("hamzalowarabic", "\u0621");
      glyphList.put("hamzalowkasraarabic", "\u0621\u0650");
      glyphList.put("hamzalowkasratanarabic", "\u0621\u064D");
      glyphList.put("hamzasukunarabic", "\u0621\u0652");
      glyphList.put("hangulfiller", "\u3164");
      glyphList.put("hardsigncyrillic", "\u044A");
      glyphList.put("harpoonleftbarbup", "\u21BC");
      glyphList.put("harpoonrightbarbup", "\u21C0");
      glyphList.put("hasquare", "\u33CA");
      glyphList.put("hatafpatah", "\u05B2");
      glyphList.put("hatafpatah16", "\u05B2");
      glyphList.put("hatafpatah23", "\u05B2");
      glyphList.put("hatafpatah2f", "\u05B2");
      glyphList.put("hatafpatahhebrew", "\u05B2");
      glyphList.put("hatafpatahnarrowhebrew", "\u05B2");
      glyphList.put("hatafpatahquarterhebrew", "\u05B2");
      glyphList.put("hatafpatahwidehebrew", "\u05B2");
      glyphList.put("hatafqamats", "\u05B3");
      glyphList.put("hatafqamats1b", "\u05B3");
      glyphList.put("hatafqamats28", "\u05B3");
      glyphList.put("hatafqamats34", "\u05B3");
      glyphList.put("hatafqamatshebrew", "\u05B3");
      glyphList.put("hatafqamatsnarrowhebrew", "\u05B3");
      glyphList.put("hatafqamatsquarterhebrew", "\u05B3");
      glyphList.put("hatafqamatswidehebrew", "\u05B3");
      glyphList.put("hatafsegol", "\u05B1");
      glyphList.put("hatafsegol17", "\u05B1");
      glyphList.put("hatafsegol24", "\u05B1");
      glyphList.put("hatafsegol30", "\u05B1");
      glyphList.put("hatafsegolhebrew", "\u05B1");
      glyphList.put("hatafsegolnarrowhebrew", "\u05B1");
      glyphList.put("hatafsegolquarterhebrew", "\u05B1");
      glyphList.put("hatafsegolwidehebrew", "\u05B1");
      glyphList.put("hbar", "\u0127");
      glyphList.put("hbopomofo", "\u310F");
      glyphList.put("hbrevebelow", "\u1E2B");
      glyphList.put("hcedilla", "\u1E29");
      glyphList.put("hcircle", "\u24D7");
      glyphList.put("hcircumflex", "\u0125");
      glyphList.put("hdieresis", "\u1E27");
      glyphList.put("hdotaccent", "\u1E23");
      glyphList.put("hdotbelow", "\u1E25");
      glyphList.put("he", "\u05D4");
      glyphList.put("heart", "\u2665");
      glyphList.put("heartsuitblack", "\u2665");
      glyphList.put("heartsuitwhite", "\u2661");
      glyphList.put("hedagesh", "\uFB34");
      glyphList.put("hedageshhebrew", "\uFB34");
      glyphList.put("hehaltonearabic", "\u06C1");
      glyphList.put("heharabic", "\u0647");
      glyphList.put("hehebrew", "\u05D4");
      glyphList.put("hehfinalaltonearabic", "\uFBA7");
      glyphList.put("hehfinalalttwoarabic", "\uFEEA");
      glyphList.put("hehfinalarabic", "\uFEEA");
      glyphList.put("hehhamzaabovefinalarabic", "\uFBA5");
      glyphList.put("hehhamzaaboveisolatedarabic", "\uFBA4");
      glyphList.put("hehinitialaltonearabic", "\uFBA8");
      glyphList.put("hehinitialarabic", "\uFEEB");
      glyphList.put("hehiragana", "\u3078");
      glyphList.put("hehmedialaltonearabic", "\uFBA9");
      glyphList.put("hehmedialarabic", "\uFEEC");
      glyphList.put("heiseierasquare", "\u337B");
      glyphList.put("hekatakana", "\u30D8");
      glyphList.put("hekatakanahalfwidth", "\uFF8D");
      glyphList.put("hekutaarusquare", "\u3336");
      glyphList.put("henghook", "\u0267");
      glyphList.put("herutusquare", "\u3339");
      glyphList.put("het", "\u05D7");
      glyphList.put("hethebrew", "\u05D7");
      glyphList.put("hhook", "\u0266");
      glyphList.put("hhooksuperior", "\u02B1");
      glyphList.put("hieuhacirclekorean", "\u327B");
      glyphList.put("hieuhaparenkorean", "\u321B");
      glyphList.put("hieuhcirclekorean", "\u326D");
      glyphList.put("hieuhkorean", "\u314E");
      glyphList.put("hieuhparenkorean", "\u320D");
      glyphList.put("hihiragana", "\u3072");
      glyphList.put("hikatakana", "\u30D2");
      glyphList.put("hikatakanahalfwidth", "\uFF8B");
      glyphList.put("hiriq", "\u05B4");
      glyphList.put("hiriq14", "\u05B4");
      glyphList.put("hiriq21", "\u05B4");
      glyphList.put("hiriq2d", "\u05B4");
      glyphList.put("hiriqhebrew", "\u05B4");
      glyphList.put("hiriqnarrowhebrew", "\u05B4");
      glyphList.put("hiriqquarterhebrew", "\u05B4");
      glyphList.put("hiriqwidehebrew", "\u05B4");
      glyphList.put("hlinebelow", "\u1E96");
      glyphList.put("hmonospace", "\uFF48");
      glyphList.put("hoarmenian", "\u0570");
      glyphList.put("hohipthai", "\u0E2B");
      glyphList.put("hohiragana", "\u307B");
      glyphList.put("hokatakana", "\u30DB");
      glyphList.put("hokatakanahalfwidth", "\uFF8E");
      glyphList.put("holam", "\u05B9");
      glyphList.put("holam19", "\u05B9");
      glyphList.put("holam26", "\u05B9");
      glyphList.put("holam32", "\u05B9");
      glyphList.put("holamhebrew", "\u05B9");
      glyphList.put("holamnarrowhebrew", "\u05B9");
      glyphList.put("holamquarterhebrew", "\u05B9");
      glyphList.put("holamwidehebrew", "\u05B9");
      glyphList.put("honokhukthai", "\u0E2E");
      glyphList.put("hookabovecomb", "\u0309");
      glyphList.put("hookcmb", "\u0309");
      glyphList.put("hookpalatalizedbelowcmb", "\u0321");
      glyphList.put("hookretroflexbelowcmb", "\u0322");
      glyphList.put("hoonsquare", "\u3342");
      glyphList.put("horicoptic", "\u03E9");
      glyphList.put("horizontalbar", "\u2015");
      glyphList.put("horncmb", "\u031B");
      glyphList.put("hotsprings", "\u2668");
      glyphList.put("house", "\u2302");
      glyphList.put("hparen", "\u24A3");
      glyphList.put("hsuperior", "\u02B0");
      glyphList.put("hturned", "\u0265");
      glyphList.put("huhiragana", "\u3075");
      glyphList.put("huiitosquare", "\u3333");
      glyphList.put("hukatakana", "\u30D5");
      glyphList.put("hukatakanahalfwidth", "\uFF8C");
      glyphList.put("hungarumlaut", "\u02DD");
      glyphList.put("hungarumlautcmb", "\u030B");
      glyphList.put("hv", "\u0195");
      glyphList.put("hyphen", "\u002D");
      glyphList.put("hypheninferior", "\uF6E5");
      glyphList.put("hyphenmonospace", "\uFF0D");
      glyphList.put("hyphensmall", "\uFE63");
      glyphList.put("hyphensuperior", "\uF6E6");
      glyphList.put("hyphentwo", "\u2010");
      glyphList.put("i", "\u0069");
      glyphList.put("iacute", "\u00ED");
      glyphList.put("iacyrillic", "\u044F");
      glyphList.put("ibengali", "\u0987");
      glyphList.put("ibopomofo", "\u3127");
      glyphList.put("ibreve", "\u012D");
      glyphList.put("icaron", "\u01D0");
      glyphList.put("icircle", "\u24D8");
      glyphList.put("icircumflex", "\u00EE");
      glyphList.put("icyrillic", "\u0456");
      glyphList.put("idblgrave", "\u0209");
      glyphList.put("ideographearthcircle", "\u328F");
      glyphList.put("ideographfirecircle", "\u328B");
      glyphList.put("ideographicallianceparen", "\u323F");
      glyphList.put("ideographiccallparen", "\u323A");
      glyphList.put("ideographiccentrecircle", "\u32A5");
      glyphList.put("ideographicclose", "\u3006");
      glyphList.put("ideographiccomma", "\u3001");
      glyphList.put("ideographiccommaleft", "\uFF64");
      glyphList.put("ideographiccongratulationparen", "\u3237");
      glyphList.put("ideographiccorrectcircle", "\u32A3");
      glyphList.put("ideographicearthparen", "\u322F");
      glyphList.put("ideographicenterpriseparen", "\u323D");
      glyphList.put("ideographicexcellentcircle", "\u329D");
      glyphList.put("ideographicfestivalparen", "\u3240");
      glyphList.put("ideographicfinancialcircle", "\u3296");
      glyphList.put("ideographicfinancialparen", "\u3236");
      glyphList.put("ideographicfireparen", "\u322B");
      glyphList.put("ideographichaveparen", "\u3232");
      glyphList.put("ideographichighcircle", "\u32A4");
      glyphList.put("ideographiciterationmark", "\u3005");
      glyphList.put("ideographiclaborcircle", "\u3298");
      glyphList.put("ideographiclaborparen", "\u3238");
      glyphList.put("ideographicleftcircle", "\u32A7");
      glyphList.put("ideographiclowcircle", "\u32A6");
      glyphList.put("ideographicmedicinecircle", "\u32A9");
      glyphList.put("ideographicmetalparen", "\u322E");
      glyphList.put("ideographicmoonparen", "\u322A");
      glyphList.put("ideographicnameparen", "\u3234");
      glyphList.put("ideographicperiod", "\u3002");
      glyphList.put("ideographicprintcircle", "\u329E");
      glyphList.put("ideographicreachparen", "\u3243");
      glyphList.put("ideographicrepresentparen", "\u3239");
      glyphList.put("ideographicresourceparen", "\u323E");
      glyphList.put("ideographicrightcircle", "\u32A8");
      glyphList.put("ideographicsecretcircle", "\u3299");
      glyphList.put("ideographicselfparen", "\u3242");
      glyphList.put("ideographicsocietyparen", "\u3233");
      glyphList.put("ideographicspace", "\u3000");
      glyphList.put("ideographicspecialparen", "\u3235");
      glyphList.put("ideographicstockparen", "\u3231");
      glyphList.put("ideographicstudyparen", "\u323B");
      glyphList.put("ideographicsunparen", "\u3230");
      glyphList.put("ideographicsuperviseparen", "\u323C");
      glyphList.put("ideographicwaterparen", "\u322C");
      glyphList.put("ideographicwoodparen", "\u322D");
      glyphList.put("ideographiczero", "\u3007");
      glyphList.put("ideographmetalcircle", "\u328E");
      glyphList.put("ideographmooncircle", "\u328A");
      glyphList.put("ideographnamecircle", "\u3294");
      glyphList.put("ideographsuncircle", "\u3290");
      glyphList.put("ideographwatercircle", "\u328C");
      glyphList.put("ideographwoodcircle", "\u328D");
      glyphList.put("ideva", "\u0907");
      glyphList.put("idieresis", "\u00EF");
      glyphList.put("idieresisacute", "\u1E2F");
      glyphList.put("idieresiscyrillic", "\u04E5");
      glyphList.put("idotbelow", "\u1ECB");
      glyphList.put("iebrevecyrillic", "\u04D7");
      glyphList.put("iecyrillic", "\u0435");
      glyphList.put("ieungacirclekorean", "\u3275");
      glyphList.put("ieungaparenkorean", "\u3215");
      glyphList.put("ieungcirclekorean", "\u3267");
      glyphList.put("ieungkorean", "\u3147");
      glyphList.put("ieungparenkorean", "\u3207");
      glyphList.put("igrave", "\u00EC");
      glyphList.put("igujarati", "\u0A87");
      glyphList.put("igurmukhi", "\u0A07");
      glyphList.put("ihiragana", "\u3044");
      glyphList.put("ihookabove", "\u1EC9");
      glyphList.put("iibengali", "\u0988");
      glyphList.put("iicyrillic", "\u0438");
      glyphList.put("iideva", "\u0908");
      glyphList.put("iigujarati", "\u0A88");
      glyphList.put("iigurmukhi", "\u0A08");
      glyphList.put("iimatragurmukhi", "\u0A40");
      glyphList.put("iinvertedbreve", "\u020B");
      glyphList.put("iishortcyrillic", "\u0439");
      glyphList.put("iivowelsignbengali", "\u09C0");
      glyphList.put("iivowelsigndeva", "\u0940");
      glyphList.put("iivowelsigngujarati", "\u0AC0");
      glyphList.put("ij", "\u0133");
      glyphList.put("ikatakana", "\u30A4");
      glyphList.put("ikatakanahalfwidth", "\uFF72");
      glyphList.put("ikorean", "\u3163");
      glyphList.put("ilde", "\u02DC");
      glyphList.put("iluyhebrew", "\u05AC");
      glyphList.put("imacron", "\u012B");
      glyphList.put("imacroncyrillic", "\u04E3");
      glyphList.put("imageorapproximatelyequal", "\u2253");
      glyphList.put("imatragurmukhi", "\u0A3F");
      glyphList.put("imonospace", "\uFF49");
      glyphList.put("increment", "\u2206");
      glyphList.put("infinity", "\u221E");
      glyphList.put("iniarmenian", "\u056B");
      glyphList.put("integral", "\u222B");
      glyphList.put("integralbottom", "\u2321");
      glyphList.put("integralbt", "\u2321");
      glyphList.put("integralex", "\uF8F5");
      glyphList.put("integraltop", "\u2320");
      glyphList.put("integraltp", "\u2320");
      glyphList.put("intersection", "\u2229");
      glyphList.put("intisquare", "\u3305");
      glyphList.put("invbullet", "\u25D8");
      glyphList.put("invcircle", "\u25D9");
      glyphList.put("invsmileface", "\u263B");
      glyphList.put("iocyrillic", "\u0451");
      glyphList.put("iogonek", "\u012F");
      glyphList.put("iota", "\u03B9");
      glyphList.put("iotadieresis", "\u03CA");
      glyphList.put("iotadieresistonos", "\u0390");
      glyphList.put("iotalatin", "\u0269");
      glyphList.put("iotatonos", "\u03AF");
      glyphList.put("iparen", "\u24A4");
      glyphList.put("irigurmukhi", "\u0A72");
      glyphList.put("ismallhiragana", "\u3043");
      glyphList.put("ismallkatakana", "\u30A3");
      glyphList.put("ismallkatakanahalfwidth", "\uFF68");
      glyphList.put("issharbengali", "\u09FA");
      glyphList.put("istroke", "\u0268");
      glyphList.put("isuperior", "\uF6ED");
      glyphList.put("iterationhiragana", "\u309D");
      glyphList.put("iterationkatakana", "\u30FD");
      glyphList.put("itilde", "\u0129");
      glyphList.put("itildebelow", "\u1E2D");
      glyphList.put("iubopomofo", "\u3129");
      glyphList.put("iucyrillic", "\u044E");
      glyphList.put("ivowelsignbengali", "\u09BF");
      glyphList.put("ivowelsigndeva", "\u093F");
      glyphList.put("ivowelsigngujarati", "\u0ABF");
      glyphList.put("izhitsacyrillic", "\u0475");
      glyphList.put("izhitsadblgravecyrillic", "\u0477");
      glyphList.put("j", "\u006A");
      glyphList.put("jaarmenian", "\u0571");
      glyphList.put("jabengali", "\u099C");
      glyphList.put("jadeva", "\u091C");
      glyphList.put("jagujarati", "\u0A9C");
      glyphList.put("jagurmukhi", "\u0A1C");
      glyphList.put("jbopomofo", "\u3110");
      glyphList.put("jcaron", "\u01F0");
      glyphList.put("jcircle", "\u24D9");
      glyphList.put("jcircumflex", "\u0135");
      glyphList.put("jcrossedtail", "\u029D");
      glyphList.put("jdotlessstroke", "\u025F");
      glyphList.put("jecyrillic", "\u0458");
      glyphList.put("jeemarabic", "\u062C");
      glyphList.put("jeemfinalarabic", "\uFE9E");
      glyphList.put("jeeminitialarabic", "\uFE9F");
      glyphList.put("jeemmedialarabic", "\uFEA0");
      glyphList.put("jeharabic", "\u0698");
      glyphList.put("jehfinalarabic", "\uFB8B");
      glyphList.put("jhabengali", "\u099D");
      glyphList.put("jhadeva", "\u091D");
      glyphList.put("jhagujarati", "\u0A9D");
      glyphList.put("jhagurmukhi", "\u0A1D");
      glyphList.put("jheharmenian", "\u057B");
      glyphList.put("jis", "\u3004");
      glyphList.put("jmonospace", "\uFF4A");
      glyphList.put("jparen", "\u24A5");
      glyphList.put("jsuperior", "\u02B2");
      glyphList.put("k", "\u006B");
      glyphList.put("kabashkircyrillic", "\u04A1");
      glyphList.put("kabengali", "\u0995");
      glyphList.put("kacute", "\u1E31");
      glyphList.put("kacyrillic", "\u043A");
      glyphList.put("kadescendercyrillic", "\u049B");
      glyphList.put("kadeva", "\u0915");
      glyphList.put("kaf", "\u05DB");
      glyphList.put("kafarabic", "\u0643");
      glyphList.put("kafdagesh", "\uFB3B");
      glyphList.put("kafdageshhebrew", "\uFB3B");
      glyphList.put("kaffinalarabic", "\uFEDA");
      glyphList.put("kafhebrew", "\u05DB");
      glyphList.put("kafinitialarabic", "\uFEDB");
      glyphList.put("kafmedialarabic", "\uFEDC");
      glyphList.put("kafrafehebrew", "\uFB4D");
      glyphList.put("kagujarati", "\u0A95");
      glyphList.put("kagurmukhi", "\u0A15");
      glyphList.put("kahiragana", "\u304B");
      glyphList.put("kahookcyrillic", "\u04C4");
      glyphList.put("kakatakana", "\u30AB");
      glyphList.put("kakatakanahalfwidth", "\uFF76");
      glyphList.put("kappa", "\u03BA");
      glyphList.put("kappasymbolgreek", "\u03F0");
      glyphList.put("kapyeounmieumkorean", "\u3171");
      glyphList.put("kapyeounphieuphkorean", "\u3184");
      glyphList.put("kapyeounpieupkorean", "\u3178");
      glyphList.put("kapyeounssangpieupkorean", "\u3179");
      glyphList.put("karoriisquare", "\u330D");
      glyphList.put("kashidaautoarabic", "\u0640");
      glyphList.put("kashidaautonosidebearingarabic", "\u0640");
      glyphList.put("kasmallkatakana", "\u30F5");
      glyphList.put("kasquare", "\u3384");
      glyphList.put("kasraarabic", "\u0650");
      glyphList.put("kasratanarabic", "\u064D");
      glyphList.put("kastrokecyrillic", "\u049F");
      glyphList.put("katahiraprolongmarkhalfwidth", "\uFF70");
      glyphList.put("kaverticalstrokecyrillic", "\u049D");
      glyphList.put("kbopomofo", "\u310E");
      glyphList.put("kcalsquare", "\u3389");
      glyphList.put("kcaron", "\u01E9");
      glyphList.put("kcedilla", "\u0137");
      glyphList.put("kcircle", "\u24DA");
      glyphList.put("kcommaaccent", "\u0137");
      glyphList.put("kdotbelow", "\u1E33");
      glyphList.put("keharmenian", "\u0584");
      glyphList.put("kehiragana", "\u3051");
      glyphList.put("kekatakana", "\u30B1");
      glyphList.put("kekatakanahalfwidth", "\uFF79");
      glyphList.put("kenarmenian", "\u056F");
      glyphList.put("kesmallkatakana", "\u30F6");
      glyphList.put("kgreenlandic", "\u0138");
      glyphList.put("khabengali", "\u0996");
      glyphList.put("khacyrillic", "\u0445");
      glyphList.put("khadeva", "\u0916");
      glyphList.put("khagujarati", "\u0A96");
      glyphList.put("khagurmukhi", "\u0A16");
      glyphList.put("khaharabic", "\u062E");
      glyphList.put("khahfinalarabic", "\uFEA6");
      glyphList.put("khahinitialarabic", "\uFEA7");
      glyphList.put("khahmedialarabic", "\uFEA8");
      glyphList.put("kheicoptic", "\u03E7");
      glyphList.put("khhadeva", "\u0959");
      glyphList.put("khhagurmukhi", "\u0A59");
      glyphList.put("khieukhacirclekorean", "\u3278");
      glyphList.put("khieukhaparenkorean", "\u3218");
      glyphList.put("khieukhcirclekorean", "\u326A");
      glyphList.put("khieukhkorean", "\u314B");
      glyphList.put("khieukhparenkorean", "\u320A");
      glyphList.put("khokhaithai", "\u0E02");
      glyphList.put("khokhonthai", "\u0E05");
      glyphList.put("khokhuatthai", "\u0E03");
      glyphList.put("khokhwaithai", "\u0E04");
      glyphList.put("khomutthai", "\u0E5B");
      glyphList.put("khook", "\u0199");
      glyphList.put("khorakhangthai", "\u0E06");
      glyphList.put("khzsquare", "\u3391");
      glyphList.put("kihiragana", "\u304D");
      glyphList.put("kikatakana", "\u30AD");
      glyphList.put("kikatakanahalfwidth", "\uFF77");
      glyphList.put("kiroguramusquare", "\u3315");
      glyphList.put("kiromeetorusquare", "\u3316");
      glyphList.put("kirosquare", "\u3314");
      glyphList.put("kiyeokacirclekorean", "\u326E");
      glyphList.put("kiyeokaparenkorean", "\u320E");
      glyphList.put("kiyeokcirclekorean", "\u3260");
      glyphList.put("kiyeokkorean", "\u3131");
      glyphList.put("kiyeokparenkorean", "\u3200");
      glyphList.put("kiyeoksioskorean", "\u3133");
      glyphList.put("kjecyrillic", "\u045C");
      glyphList.put("klinebelow", "\u1E35");
      glyphList.put("klsquare", "\u3398");
      glyphList.put("kmcubedsquare", "\u33A6");
      glyphList.put("kmonospace", "\uFF4B");
      glyphList.put("kmsquaredsquare", "\u33A2");
      glyphList.put("kohiragana", "\u3053");
      glyphList.put("kohmsquare", "\u33C0");
      glyphList.put("kokaithai", "\u0E01");
      glyphList.put("kokatakana", "\u30B3");
      glyphList.put("kokatakanahalfwidth", "\uFF7A");
      glyphList.put("kooposquare", "\u331E");
      glyphList.put("koppacyrillic", "\u0481");
      glyphList.put("koreanstandardsymbol", "\u327F");
      glyphList.put("koroniscmb", "\u0343");
      glyphList.put("kparen", "\u24A6");
      glyphList.put("kpasquare", "\u33AA");
      glyphList.put("ksicyrillic", "\u046F");
      glyphList.put("ktsquare", "\u33CF");
      glyphList.put("kturned", "\u029E");
      glyphList.put("kuhiragana", "\u304F");
      glyphList.put("kukatakana", "\u30AF");
      glyphList.put("kukatakanahalfwidth", "\uFF78");
      glyphList.put("kvsquare", "\u33B8");
      glyphList.put("kwsquare", "\u33BE");
      glyphList.put("l", "\u006C");
      glyphList.put("labengali", "\u09B2");
      glyphList.put("lacute", "\u013A");
      glyphList.put("ladeva", "\u0932");
      glyphList.put("lagujarati", "\u0AB2");
      glyphList.put("lagurmukhi", "\u0A32");
      glyphList.put("lakkhangyaothai", "\u0E45");
      glyphList.put("lamaleffinalarabic", "\uFEFC");
      glyphList.put("lamalefhamzaabovefinalarabic", "\uFEF8");
      glyphList.put("lamalefhamzaaboveisolatedarabic", "\uFEF7");
      glyphList.put("lamalefhamzabelowfinalarabic", "\uFEFA");
      glyphList.put("lamalefhamzabelowisolatedarabic", "\uFEF9");
      glyphList.put("lamalefisolatedarabic", "\uFEFB");
      glyphList.put("lamalefmaddaabovefinalarabic", "\uFEF6");
      glyphList.put("lamalefmaddaaboveisolatedarabic", "\uFEF5");
      glyphList.put("lamarabic", "\u0644");
      glyphList.put("lambda", "\u03BB");
      glyphList.put("lambdastroke", "\u019B");
      glyphList.put("lamed", "\u05DC");
      glyphList.put("lameddagesh", "\uFB3C");
      glyphList.put("lameddageshhebrew", "\uFB3C");
      glyphList.put("lamedhebrew", "\u05DC");
      glyphList.put("lamedholam", "\u05DC\u05B9");
      glyphList.put("lamedholamdagesh", "\u05DC\u05B9\u05BC");
      glyphList.put("lamedholamdageshhebrew", "\u05DC\u05B9\u05BC");
      glyphList.put("lamedholamhebrew", "\u05DC\u05B9");
      glyphList.put("lamfinalarabic", "\uFEDE");
      glyphList.put("lamhahinitialarabic", "\uFCCA");
      glyphList.put("laminitialarabic", "\uFEDF");
      glyphList.put("lamjeeminitialarabic", "\uFCC9");
      glyphList.put("lamkhahinitialarabic", "\uFCCB");
      glyphList.put("lamlamhehisolatedarabic", "\uFDF2");
      glyphList.put("lammedialarabic", "\uFEE0");
      glyphList.put("lammeemhahinitialarabic", "\uFD88");
      glyphList.put("lammeeminitialarabic", "\uFCCC");
      glyphList.put("lammeemjeeminitialarabic", "\uFEDF\uFEE4\uFEA0");
      glyphList.put("lammeemkhahinitialarabic", "\uFEDF\uFEE4\uFEA8");
      glyphList.put("largecircle", "\u25EF");
      glyphList.put("lbar", "\u019A");
      glyphList.put("lbelt", "\u026C");
      glyphList.put("lbopomofo", "\u310C");
      glyphList.put("lcaron", "\u013E");
      glyphList.put("lcedilla", "\u013C");
      glyphList.put("lcircle", "\u24DB");
      glyphList.put("lcircumflexbelow", "\u1E3D");
      glyphList.put("lcommaaccent", "\u013C");
      glyphList.put("ldot", "\u0140");
      glyphList.put("ldotaccent", "\u0140");
      glyphList.put("ldotbelow", "\u1E37");
      glyphList.put("ldotbelowmacron", "\u1E39");
      glyphList.put("leftangleabovecmb", "\u031A");
      glyphList.put("lefttackbelowcmb", "\u0318");
      glyphList.put("less", "\u003C");
      glyphList.put("lessequal", "\u2264");
      glyphList.put("lessequalorgreater", "\u22DA");
      glyphList.put("lessmonospace", "\uFF1C");
      glyphList.put("lessorequivalent", "\u2272");
      glyphList.put("lessorgreater", "\u2276");
      glyphList.put("lessoverequal", "\u2266");
      glyphList.put("lesssmall", "\uFE64");
      glyphList.put("lezh", "\u026E");
      glyphList.put("lfblock", "\u258C");
      glyphList.put("lhookretroflex", "\u026D");
      glyphList.put("lira", "\u20A4");
      glyphList.put("liwnarmenian", "\u056C");
      glyphList.put("lj", "\u01C9");
      glyphList.put("ljecyrillic", "\u0459");
      glyphList.put("ll", "\uF6C0");
      glyphList.put("lladeva", "\u0933");
      glyphList.put("llagujarati", "\u0AB3");
      glyphList.put("llinebelow", "\u1E3B");
      glyphList.put("llladeva", "\u0934");
      glyphList.put("llvocalicbengali", "\u09E1");
      glyphList.put("llvocalicdeva", "\u0961");
      glyphList.put("llvocalicvowelsignbengali", "\u09E3");
      glyphList.put("llvocalicvowelsigndeva", "\u0963");
      glyphList.put("lmiddletilde", "\u026B");
      glyphList.put("lmonospace", "\uFF4C");
      glyphList.put("lmsquare", "\u33D0");
      glyphList.put("lochulathai", "\u0E2C");
      glyphList.put("logicaland", "\u2227");
      glyphList.put("logicalnot", "\u00AC");
      glyphList.put("logicalnotreversed", "\u2310");
      glyphList.put("logicalor", "\u2228");
      glyphList.put("lolingthai", "\u0E25");
      glyphList.put("longs", "\u017F");
      glyphList.put("lowlinecenterline", "\uFE4E");
      glyphList.put("lowlinecmb", "\u0332");
      glyphList.put("lowlinedashed", "\uFE4D");
      glyphList.put("lozenge", "\u25CA");
      glyphList.put("lparen", "\u24A7");
      glyphList.put("lslash", "\u0142");
      glyphList.put("lsquare", "\u2113");
      glyphList.put("lsuperior", "\uF6EE");
      glyphList.put("ltshade", "\u2591");
      glyphList.put("luthai", "\u0E26");
      glyphList.put("lvocalicbengali", "\u098C");
      glyphList.put("lvocalicdeva", "\u090C");
      glyphList.put("lvocalicvowelsignbengali", "\u09E2");
      glyphList.put("lvocalicvowelsigndeva", "\u0962");
      glyphList.put("lxsquare", "\u33D3");
      glyphList.put("m", "\u006D");
      glyphList.put("mabengali", "\u09AE");
      glyphList.put("macron", "\u00AF");
      glyphList.put("macronbelowcmb", "\u0331");
      glyphList.put("macroncmb", "\u0304");
      glyphList.put("macronlowmod", "\u02CD");
      glyphList.put("macronmonospace", "\uFFE3");
      glyphList.put("macute", "\u1E3F");
      glyphList.put("madeva", "\u092E");
      glyphList.put("magujarati", "\u0AAE");
      glyphList.put("magurmukhi", "\u0A2E");
      glyphList.put("mahapakhhebrew", "\u05A4");
      glyphList.put("mahapakhlefthebrew", "\u05A4");
      glyphList.put("mahiragana", "\u307E");
      glyphList.put("maichattawalowleftthai", "\uF895");
      glyphList.put("maichattawalowrightthai", "\uF894");
      glyphList.put("maichattawathai", "\u0E4B");
      glyphList.put("maichattawaupperleftthai", "\uF893");
      glyphList.put("maieklowleftthai", "\uF88C");
      glyphList.put("maieklowrightthai", "\uF88B");
      glyphList.put("maiekthai", "\u0E48");
      glyphList.put("maiekupperleftthai", "\uF88A");
      glyphList.put("maihanakatleftthai", "\uF884");
      glyphList.put("maihanakatthai", "\u0E31");
      glyphList.put("maitaikhuleftthai", "\uF889");
      glyphList.put("maitaikhuthai", "\u0E47");
      glyphList.put("maitholowleftthai", "\uF88F");
      glyphList.put("maitholowrightthai", "\uF88E");
      glyphList.put("maithothai", "\u0E49");
      glyphList.put("maithoupperleftthai", "\uF88D");
      glyphList.put("maitrilowleftthai", "\uF892");
      glyphList.put("maitrilowrightthai", "\uF891");
      glyphList.put("maitrithai", "\u0E4A");
      glyphList.put("maitriupperleftthai", "\uF890");
      glyphList.put("maiyamokthai", "\u0E46");
      glyphList.put("makatakana", "\u30DE");
      glyphList.put("makatakanahalfwidth", "\uFF8F");
      glyphList.put("male", "\u2642");
      glyphList.put("mansyonsquare", "\u3347");
      glyphList.put("maqafhebrew", "\u05BE");
      glyphList.put("mars", "\u2642");
      glyphList.put("masoracirclehebrew", "\u05AF");
      glyphList.put("masquare", "\u3383");
      glyphList.put("mbopomofo", "\u3107");
      glyphList.put("mbsquare", "\u33D4");
      glyphList.put("mcircle", "\u24DC");
      glyphList.put("mcubedsquare", "\u33A5");
      glyphList.put("mdotaccent", "\u1E41");
      glyphList.put("mdotbelow", "\u1E43");
      glyphList.put("meemarabic", "\u0645");
      glyphList.put("meemfinalarabic", "\uFEE2");
      glyphList.put("meeminitialarabic", "\uFEE3");
      glyphList.put("meemmedialarabic", "\uFEE4");
      glyphList.put("meemmeeminitialarabic", "\uFCD1");
      glyphList.put("meemmeemisolatedarabic", "\uFC48");
      glyphList.put("meetorusquare", "\u334D");
      glyphList.put("mehiragana", "\u3081");
      glyphList.put("meizierasquare", "\u337E");
      glyphList.put("mekatakana", "\u30E1");
      glyphList.put("mekatakanahalfwidth", "\uFF92");
      glyphList.put("mem", "\u05DE");
      glyphList.put("memdagesh", "\uFB3E");
      glyphList.put("memdageshhebrew", "\uFB3E");
      glyphList.put("memhebrew", "\u05DE");
      glyphList.put("menarmenian", "\u0574");
      glyphList.put("merkhahebrew", "\u05A5");
      glyphList.put("merkhakefulahebrew", "\u05A6");
      glyphList.put("merkhakefulalefthebrew", "\u05A6");
      glyphList.put("merkhalefthebrew", "\u05A5");
      glyphList.put("mhook", "\u0271");
      glyphList.put("mhzsquare", "\u3392");
      glyphList.put("middledotkatakanahalfwidth", "\uFF65");
      glyphList.put("middot", "\u00B7");
      glyphList.put("mieumacirclekorean", "\u3272");
      glyphList.put("mieumaparenkorean", "\u3212");
      glyphList.put("mieumcirclekorean", "\u3264");
      glyphList.put("mieumkorean", "\u3141");
      glyphList.put("mieumpansioskorean", "\u3170");
      glyphList.put("mieumparenkorean", "\u3204");
      glyphList.put("mieumpieupkorean", "\u316E");
      glyphList.put("mieumsioskorean", "\u316F");
      glyphList.put("mihiragana", "\u307F");
      glyphList.put("mikatakana", "\u30DF");
      glyphList.put("mikatakanahalfwidth", "\uFF90");
      glyphList.put("minus", "\u2212");
      glyphList.put("minusbelowcmb", "\u0320");
      glyphList.put("minuscircle", "\u2296");
      glyphList.put("minusmod", "\u02D7");
      glyphList.put("minusplus", "\u2213");
      glyphList.put("minute", "\u2032");
      glyphList.put("miribaarusquare", "\u334A");
      glyphList.put("mirisquare", "\u3349");
      glyphList.put("mlonglegturned", "\u0270");
      glyphList.put("mlsquare", "\u3396");
      glyphList.put("mmcubedsquare", "\u33A3");
      glyphList.put("mmonospace", "\uFF4D");
      glyphList.put("mmsquaredsquare", "\u339F");
      glyphList.put("mohiragana", "\u3082");
      glyphList.put("mohmsquare", "\u33C1");
      glyphList.put("mokatakana", "\u30E2");
      glyphList.put("mokatakanahalfwidth", "\uFF93");
      glyphList.put("molsquare", "\u33D6");
      glyphList.put("momathai", "\u0E21");
      glyphList.put("moverssquare", "\u33A7");
      glyphList.put("moverssquaredsquare", "\u33A8");
      glyphList.put("mparen", "\u24A8");
      glyphList.put("mpasquare", "\u33AB");
      glyphList.put("mssquare", "\u33B3");
      glyphList.put("msuperior", "\uF6EF");
      glyphList.put("mturned", "\u026F");
      glyphList.put("mu", "\u00B5");
      glyphList.put("mu1", "\u00B5");
      glyphList.put("muasquare", "\u3382");
      glyphList.put("muchgreater", "\u226B");
      glyphList.put("muchless", "\u226A");
      glyphList.put("mufsquare", "\u338C");
      glyphList.put("mugreek", "\u03BC");
      glyphList.put("mugsquare", "\u338D");
      glyphList.put("muhiragana", "\u3080");
      glyphList.put("mukatakana", "\u30E0");
      glyphList.put("mukatakanahalfwidth", "\uFF91");
      glyphList.put("mulsquare", "\u3395");
      glyphList.put("multiply", "\u00D7");
      glyphList.put("mumsquare", "\u339B");
      glyphList.put("munahhebrew", "\u05A3");
      glyphList.put("munahlefthebrew", "\u05A3");
      glyphList.put("musicalnote", "\u266A");
      glyphList.put("musicalnotedbl", "\u266B");
      glyphList.put("musicflatsign", "\u266D");
      glyphList.put("musicsharpsign", "\u266F");
      glyphList.put("mussquare", "\u33B2");
      glyphList.put("muvsquare", "\u33B6");
      glyphList.put("muwsquare", "\u33BC");
      glyphList.put("mvmegasquare", "\u33B9");
      glyphList.put("mvsquare", "\u33B7");
      glyphList.put("mwmegasquare", "\u33BF");
      glyphList.put("mwsquare", "\u33BD");
      glyphList.put("n", "\u006E");
      glyphList.put("nabengali", "\u09A8");
      glyphList.put("nabla", "\u2207");
      glyphList.put("nacute", "\u0144");
      glyphList.put("nadeva", "\u0928");
      glyphList.put("nagujarati", "\u0AA8");
      glyphList.put("nagurmukhi", "\u0A28");
      glyphList.put("nahiragana", "\u306A");
      glyphList.put("nakatakana", "\u30CA");
      glyphList.put("nakatakanahalfwidth", "\uFF85");
      glyphList.put("napostrophe", "\u0149");
      glyphList.put("nasquare", "\u3381");
      glyphList.put("nbopomofo", "\u310B");
      glyphList.put("nbspace", "\u00A0");
      glyphList.put("ncaron", "\u0148");
      glyphList.put("ncedilla", "\u0146");
      glyphList.put("ncircle", "\u24DD");
      glyphList.put("ncircumflexbelow", "\u1E4B");
      glyphList.put("ncommaaccent", "\u0146");
      glyphList.put("ndotaccent", "\u1E45");
      glyphList.put("ndotbelow", "\u1E47");
      glyphList.put("nehiragana", "\u306D");
      glyphList.put("nekatakana", "\u30CD");
      glyphList.put("nekatakanahalfwidth", "\uFF88");
      glyphList.put("newsheqelsign", "\u20AA");
      glyphList.put("nfsquare", "\u338B");
      glyphList.put("ngabengali", "\u0999");
      glyphList.put("ngadeva", "\u0919");
      glyphList.put("ngagujarati", "\u0A99");
      glyphList.put("ngagurmukhi", "\u0A19");
      glyphList.put("ngonguthai", "\u0E07");
      glyphList.put("nhiragana", "\u3093");
      glyphList.put("nhookleft", "\u0272");
      glyphList.put("nhookretroflex", "\u0273");
      glyphList.put("nieunacirclekorean", "\u326F");
      glyphList.put("nieunaparenkorean", "\u320F");
      glyphList.put("nieuncieuckorean", "\u3135");
      glyphList.put("nieuncirclekorean", "\u3261");
      glyphList.put("nieunhieuhkorean", "\u3136");
      glyphList.put("nieunkorean", "\u3134");
      glyphList.put("nieunpansioskorean", "\u3168");
      glyphList.put("nieunparenkorean", "\u3201");
      glyphList.put("nieunsioskorean", "\u3167");
      glyphList.put("nieuntikeutkorean", "\u3166");
      glyphList.put("nihiragana", "\u306B");
      glyphList.put("nikatakana", "\u30CB");
      glyphList.put("nikatakanahalfwidth", "\uFF86");
      glyphList.put("nikhahitleftthai", "\uF899");
      glyphList.put("nikhahitthai", "\u0E4D");
      glyphList.put("nine", "\u0039");
      glyphList.put("ninearabic", "\u0669");
      glyphList.put("ninebengali", "\u09EF");
      glyphList.put("ninecircle", "\u2468");
      glyphList.put("ninecircleinversesansserif", "\u2792");
      glyphList.put("ninedeva", "\u096F");
      glyphList.put("ninegujarati", "\u0AEF");
      glyphList.put("ninegurmukhi", "\u0A6F");
      glyphList.put("ninehackarabic", "\u0669");
      glyphList.put("ninehangzhou", "\u3029");
      glyphList.put("nineideographicparen", "\u3228");
      glyphList.put("nineinferior", "\u2089");
      glyphList.put("ninemonospace", "\uFF19");
      glyphList.put("nineoldstyle", "\uF739");
      glyphList.put("nineparen", "\u247C");
      glyphList.put("nineperiod", "\u2490");
      glyphList.put("ninepersian", "\u06F9");
      glyphList.put("nineroman", "\u2178");
      glyphList.put("ninesuperior", "\u2079");
      glyphList.put("nineteencircle", "\u2472");
      glyphList.put("nineteenparen", "\u2486");
      glyphList.put("nineteenperiod", "\u249A");
      glyphList.put("ninethai", "\u0E59");
      glyphList.put("nj", "\u01CC");
      glyphList.put("njecyrillic", "\u045A");
      glyphList.put("nkatakana", "\u30F3");
      glyphList.put("nkatakanahalfwidth", "\uFF9D");
      glyphList.put("nlegrightlong", "\u019E");
      glyphList.put("nlinebelow", "\u1E49");
      glyphList.put("nmonospace", "\uFF4E");
      glyphList.put("nmsquare", "\u339A");
      glyphList.put("nnabengali", "\u09A3");
      glyphList.put("nnadeva", "\u0923");
      glyphList.put("nnagujarati", "\u0AA3");
      glyphList.put("nnagurmukhi", "\u0A23");
      glyphList.put("nnnadeva", "\u0929");
      glyphList.put("nohiragana", "\u306E");
      glyphList.put("nokatakana", "\u30CE");
      glyphList.put("nokatakanahalfwidth", "\uFF89");
      glyphList.put("nonbreakingspace", "\u00A0");
      glyphList.put("nonenthai", "\u0E13");
      glyphList.put("nonuthai", "\u0E19");
      glyphList.put("noonarabic", "\u0646");
      glyphList.put("noonfinalarabic", "\uFEE6");
      glyphList.put("noonghunnaarabic", "\u06BA");
      glyphList.put("noonghunnafinalarabic", "\uFB9F");
      glyphList.put("noonhehinitialarabic", "\uFEE7FEEC");
      glyphList.put("nooninitialarabic", "\uFEE7");
      glyphList.put("noonjeeminitialarabic", "\uFCD2");
      glyphList.put("noonjeemisolatedarabic", "\uFC4B");
      glyphList.put("noonmedialarabic", "\uFEE8");
      glyphList.put("noonmeeminitialarabic", "\uFCD5");
      glyphList.put("noonmeemisolatedarabic", "\uFC4E");
      glyphList.put("noonnoonfinalarabic", "\uFC8D");
      glyphList.put("notcontains", "\u220C");
      glyphList.put("notelement", "\u2209");
      glyphList.put("notelementof", "\u2209");
      glyphList.put("notequal", "\u2260");
      glyphList.put("notgreater", "\u226F");
      glyphList.put("notgreaternorequal", "\u2271");
      glyphList.put("notgreaternorless", "\u2279");
      glyphList.put("notidentical", "\u2262");
      glyphList.put("notless", "\u226E");
      glyphList.put("notlessnorequal", "\u2270");
      glyphList.put("notparallel", "\u2226");
      glyphList.put("notprecedes", "\u2280");
      glyphList.put("notsubset", "\u2284");
      glyphList.put("notsucceeds", "\u2281");
      glyphList.put("notsuperset", "\u2285");
      glyphList.put("nowarmenian", "\u0576");
      glyphList.put("nparen", "\u24A9");
      glyphList.put("nssquare", "\u33B1");
      glyphList.put("nsuperior", "\u207F");
      glyphList.put("ntilde", "\u00F1");
      glyphList.put("nu", "\u03BD");
      glyphList.put("nuhiragana", "\u306C");
      glyphList.put("nukatakana", "\u30CC");
      glyphList.put("nukatakanahalfwidth", "\uFF87");
      glyphList.put("nuktabengali", "\u09BC");
      glyphList.put("nuktadeva", "\u093C");
      glyphList.put("nuktagujarati", "\u0ABC");
      glyphList.put("nuktagurmukhi", "\u0A3C");
      glyphList.put("numbersign", "\u0023");
      glyphList.put("numbersignmonospace", "\uFF03");
      glyphList.put("numbersignsmall", "\uFE5F");
      glyphList.put("numeralsigngreek", "\u0374");
      glyphList.put("numeralsignlowergreek", "\u0375");
      glyphList.put("numero", "\u2116");
      glyphList.put("nun", "\u05E0");
      glyphList.put("nundagesh", "\uFB40");
      glyphList.put("nundageshhebrew", "\uFB40");
      glyphList.put("nunhebrew", "\u05E0");
      glyphList.put("nvsquare", "\u33B5");
      glyphList.put("nwsquare", "\u33BB");
      glyphList.put("nyabengali", "\u099E");
      glyphList.put("nyadeva", "\u091E");
      glyphList.put("nyagujarati", "\u0A9E");
      glyphList.put("nyagurmukhi", "\u0A1E");
      glyphList.put("o", "\u006F");
      glyphList.put("oacute", "\u00F3");
      glyphList.put("oangthai", "\u0E2D");
      glyphList.put("obarred", "\u0275");
      glyphList.put("obarredcyrillic", "\u04E9");
      glyphList.put("obarreddieresiscyrillic", "\u04EB");
      glyphList.put("obengali", "\u0993");
      glyphList.put("obopomofo", "\u311B");
      glyphList.put("obreve", "\u014F");
      glyphList.put("ocandradeva", "\u0911");
      glyphList.put("ocandragujarati", "\u0A91");
      glyphList.put("ocandravowelsigndeva", "\u0949");
      glyphList.put("ocandravowelsigngujarati", "\u0AC9");
      glyphList.put("ocaron", "\u01D2");
      glyphList.put("ocircle", "\u24DE");
      glyphList.put("ocircumflex", "\u00F4");
      glyphList.put("ocircumflexacute", "\u1ED1");
      glyphList.put("ocircumflexdotbelow", "\u1ED9");
      glyphList.put("ocircumflexgrave", "\u1ED3");
      glyphList.put("ocircumflexhookabove", "\u1ED5");
      glyphList.put("ocircumflextilde", "\u1ED7");
      glyphList.put("ocyrillic", "\u043E");
      glyphList.put("odblacute", "\u0151");
      glyphList.put("odblgrave", "\u020D");
      glyphList.put("odeva", "\u0913");
      glyphList.put("odieresis", "\u00F6");
      glyphList.put("odieresiscyrillic", "\u04E7");
      glyphList.put("odotbelow", "\u1ECD");
      glyphList.put("oe", "\u0153");
      glyphList.put("oekorean", "\u315A");
      glyphList.put("ogonek", "\u02DB");
      glyphList.put("ogonekcmb", "\u0328");
      glyphList.put("ograve", "\u00F2");
      glyphList.put("ogujarati", "\u0A93");
      glyphList.put("oharmenian", "\u0585");
      glyphList.put("ohiragana", "\u304A");
      glyphList.put("ohookabove", "\u1ECF");
      glyphList.put("ohorn", "\u01A1");
      glyphList.put("ohornacute", "\u1EDB");
      glyphList.put("ohorndotbelow", "\u1EE3");
      glyphList.put("ohorngrave", "\u1EDD");
      glyphList.put("ohornhookabove", "\u1EDF");
      glyphList.put("ohorntilde", "\u1EE1");
      glyphList.put("ohungarumlaut", "\u0151");
      glyphList.put("oi", "\u01A3");
      glyphList.put("oinvertedbreve", "\u020F");
      glyphList.put("okatakana", "\u30AA");
      glyphList.put("okatakanahalfwidth", "\uFF75");
      glyphList.put("okorean", "\u3157");
      glyphList.put("olehebrew", "\u05AB");
      glyphList.put("omacron", "\u014D");
      glyphList.put("omacronacute", "\u1E53");
      glyphList.put("omacrongrave", "\u1E51");
      glyphList.put("omdeva", "\u0950");
      glyphList.put("omega", "\u03C9");
      glyphList.put("omega1", "\u03D6");
      glyphList.put("omegacyrillic", "\u0461");
      glyphList.put("omegalatinclosed", "\u0277");
      glyphList.put("omegaroundcyrillic", "\u047B");
      glyphList.put("omegatitlocyrillic", "\u047D");
      glyphList.put("omegatonos", "\u03CE");
      glyphList.put("omgujarati", "\u0AD0");
      glyphList.put("omicron", "\u03BF");
      glyphList.put("omicrontonos", "\u03CC");
      glyphList.put("omonospace", "\uFF4F");
      glyphList.put("one", "\u0031");
      glyphList.put("onearabic", "\u0661");
      glyphList.put("onebengali", "\u09E7");
      glyphList.put("onecircle", "\u2460");
      glyphList.put("onecircleinversesansserif", "\u278A");
      glyphList.put("onedeva", "\u0967");
      glyphList.put("onedotenleader", "\u2024");
      glyphList.put("oneeighth", "\u215B");
      glyphList.put("onefitted", "\uF6DC");
      glyphList.put("onegujarati", "\u0AE7");
      glyphList.put("onegurmukhi", "\u0A67");
      glyphList.put("onehackarabic", "\u0661");
      glyphList.put("onehalf", "\u00BD");
      glyphList.put("onehangzhou", "\u3021");
      glyphList.put("oneideographicparen", "\u3220");
      glyphList.put("oneinferior", "\u2081");
      glyphList.put("onemonospace", "\uFF11");
      glyphList.put("onenumeratorbengali", "\u09F4");
      glyphList.put("oneoldstyle", "\uF731");
      glyphList.put("oneparen", "\u2474");
      glyphList.put("oneperiod", "\u2488");
      glyphList.put("onepersian", "\u06F1");
      glyphList.put("onequarter", "\u00BC");
      glyphList.put("oneroman", "\u2170");
      glyphList.put("onesuperior", "\u00B9");
      glyphList.put("onethai", "\u0E51");
      glyphList.put("onethird", "\u2153");
      glyphList.put("oogonek", "\u01EB");
      glyphList.put("oogonekmacron", "\u01ED");
      glyphList.put("oogurmukhi", "\u0A13");
      glyphList.put("oomatragurmukhi", "\u0A4B");
      glyphList.put("oopen", "\u0254");
      glyphList.put("oparen", "\u24AA");
      glyphList.put("openbullet", "\u25E6");
      glyphList.put("option", "\u2325");
      glyphList.put("ordfeminine", "\u00AA");
      glyphList.put("ordmasculine", "\u00BA");
      glyphList.put("orthogonal", "\u221F");
      glyphList.put("oshortdeva", "\u0912");
      glyphList.put("oshortvowelsigndeva", "\u094A");
      glyphList.put("oslash", "\u00F8");
      glyphList.put("oslashacute", "\u01FF");
      glyphList.put("osmallhiragana", "\u3049");
      glyphList.put("osmallkatakana", "\u30A9");
      glyphList.put("osmallkatakanahalfwidth", "\uFF6B");
      glyphList.put("ostrokeacute", "\u01FF");
      glyphList.put("osuperior", "\uF6F0");
      glyphList.put("otcyrillic", "\u047F");
      glyphList.put("otilde", "\u00F5");
      glyphList.put("otildeacute", "\u1E4D");
      glyphList.put("otildedieresis", "\u1E4F");
      glyphList.put("oubopomofo", "\u3121");
      glyphList.put("overline", "\u203E");
      glyphList.put("overlinecenterline", "\uFE4A");
      glyphList.put("overlinecmb", "\u0305");
      glyphList.put("overlinedashed", "\uFE49");
      glyphList.put("overlinedblwavy", "\uFE4C");
      glyphList.put("overlinewavy", "\uFE4B");
      glyphList.put("overscore", "\u00AF");
      glyphList.put("ovowelsignbengali", "\u09CB");
      glyphList.put("ovowelsigndeva", "\u094B");
      glyphList.put("ovowelsigngujarati", "\u0ACB");
      glyphList.put("p", "\u0070");
      glyphList.put("paampssquare", "\u3380");
      glyphList.put("paasentosquare", "\u332B");
      glyphList.put("pabengali", "\u09AA");
      glyphList.put("pacute", "\u1E55");
      glyphList.put("padeva", "\u092A");
      glyphList.put("pagedown", "\u21DF");
      glyphList.put("pageup", "\u21DE");
      glyphList.put("pagujarati", "\u0AAA");
      glyphList.put("pagurmukhi", "\u0A2A");
      glyphList.put("pahiragana", "\u3071");
      glyphList.put("paiyannoithai", "\u0E2F");
      glyphList.put("pakatakana", "\u30D1");
      glyphList.put("palatalizationcyrilliccmb", "\u0484");
      glyphList.put("palochkacyrillic", "\u04C0");
      glyphList.put("pansioskorean", "\u317F");
      glyphList.put("paragraph", "\u00B6");
      glyphList.put("parallel", "\u2225");
      glyphList.put("parenleft", "\u0028");
      glyphList.put("parenleftaltonearabic", "\uFD3E");
      glyphList.put("parenleftbt", "\uF8ED");
      glyphList.put("parenleftex", "\uF8EC");
      glyphList.put("parenleftinferior", "\u208D");
      glyphList.put("parenleftmonospace", "\uFF08");
      glyphList.put("parenleftsmall", "\uFE59");
      glyphList.put("parenleftsuperior", "\u207D");
      glyphList.put("parenlefttp", "\uF8EB");
      glyphList.put("parenleftvertical", "\uFE35");
      glyphList.put("parenright", "\u0029");
      glyphList.put("parenrightaltonearabic", "\uFD3F");
      glyphList.put("parenrightbt", "\uF8F8");
      glyphList.put("parenrightex", "\uF8F7");
      glyphList.put("parenrightinferior", "\u208E");
      glyphList.put("parenrightmonospace", "\uFF09");
      glyphList.put("parenrightsmall", "\uFE5A");
      glyphList.put("parenrightsuperior", "\u207E");
      glyphList.put("parenrighttp", "\uF8F6");
      glyphList.put("parenrightvertical", "\uFE36");
      glyphList.put("partialdiff", "\u2202");
      glyphList.put("paseqhebrew", "\u05C0");
      glyphList.put("pashtahebrew", "\u0599");
      glyphList.put("pasquare", "\u33A9");
      glyphList.put("patah", "\u05B7");
      glyphList.put("patah11", "\u05B7");
      glyphList.put("patah1d", "\u05B7");
      glyphList.put("patah2a", "\u05B7");
      glyphList.put("patahhebrew", "\u05B7");
      glyphList.put("patahnarrowhebrew", "\u05B7");
      glyphList.put("patahquarterhebrew", "\u05B7");
      glyphList.put("patahwidehebrew", "\u05B7");
      glyphList.put("pazerhebrew", "\u05A1");
      glyphList.put("pbopomofo", "\u3106");
      glyphList.put("pcircle", "\u24DF");
      glyphList.put("pdotaccent", "\u1E57");
      glyphList.put("pe", "\u05E4");
      glyphList.put("pecyrillic", "\u043F");
      glyphList.put("pedagesh", "\uFB44");
      glyphList.put("pedageshhebrew", "\uFB44");
      glyphList.put("peezisquare", "\u333B");
      glyphList.put("pefinaldageshhebrew", "\uFB43");
      glyphList.put("peharabic", "\u067E");
      glyphList.put("peharmenian", "\u057A");
      glyphList.put("pehebrew", "\u05E4");
      glyphList.put("pehfinalarabic", "\uFB57");
      glyphList.put("pehinitialarabic", "\uFB58");
      glyphList.put("pehiragana", "\u307A");
      glyphList.put("pehmedialarabic", "\uFB59");
      glyphList.put("pekatakana", "\u30DA");
      glyphList.put("pemiddlehookcyrillic", "\u04A7");
      glyphList.put("perafehebrew", "\uFB4E");
      glyphList.put("percent", "\u0025");
      glyphList.put("percentarabic", "\u066A");
      glyphList.put("percentmonospace", "\uFF05");
      glyphList.put("percentsmall", "\uFE6A");
      glyphList.put("period", "\u002E");
      glyphList.put("periodarmenian", "\u0589");
      glyphList.put("periodcentered", "\u00B7");
      glyphList.put("periodhalfwidth", "\uFF61");
      glyphList.put("periodinferior", "\uF6E7");
      glyphList.put("periodmonospace", "\uFF0E");
      glyphList.put("periodsmall", "\uFE52");
      glyphList.put("periodsuperior", "\uF6E8");
      glyphList.put("perispomenigreekcmb", "\u0342");
      glyphList.put("perpendicular", "\u22A5");
      glyphList.put("perthousand", "\u2030");
      glyphList.put("peseta", "\u20A7");
      glyphList.put("pfsquare", "\u338A");
      glyphList.put("phabengali", "\u09AB");
      glyphList.put("phadeva", "\u092B");
      glyphList.put("phagujarati", "\u0AAB");
      glyphList.put("phagurmukhi", "\u0A2B");
      glyphList.put("phi", "\u03C6");
      glyphList.put("phi1", "\u03D5");
      glyphList.put("phieuphacirclekorean", "\u327A");
      glyphList.put("phieuphaparenkorean", "\u321A");
      glyphList.put("phieuphcirclekorean", "\u326C");
      glyphList.put("phieuphkorean", "\u314D");
      glyphList.put("phieuphparenkorean", "\u320C");
      glyphList.put("philatin", "\u0278");
      glyphList.put("phinthuthai", "\u0E3A");
      glyphList.put("phisymbolgreek", "\u03D5");
      glyphList.put("phook", "\u01A5");
      glyphList.put("phophanthai", "\u0E1E");
      glyphList.put("phophungthai", "\u0E1C");
      glyphList.put("phosamphaothai", "\u0E20");
      glyphList.put("pi", "\u03C0");
      glyphList.put("pieupacirclekorean", "\u3273");
      glyphList.put("pieupaparenkorean", "\u3213");
      glyphList.put("pieupcieuckorean", "\u3176");
      glyphList.put("pieupcirclekorean", "\u3265");
      glyphList.put("pieupkiyeokkorean", "\u3172");
      glyphList.put("pieupkorean", "\u3142");
      glyphList.put("pieupparenkorean", "\u3205");
      glyphList.put("pieupsioskiyeokkorean", "\u3174");
      glyphList.put("pieupsioskorean", "\u3144");
      glyphList.put("pieupsiostikeutkorean", "\u3175");
      glyphList.put("pieupthieuthkorean", "\u3177");
      glyphList.put("pieuptikeutkorean", "\u3173");
      glyphList.put("pihiragana", "\u3074");
      glyphList.put("pikatakana", "\u30D4");
      glyphList.put("pisymbolgreek", "\u03D6");
      glyphList.put("piwrarmenian", "\u0583");
      glyphList.put("plus", "\u002B");
      glyphList.put("plusbelowcmb", "\u031F");
      glyphList.put("pluscircle", "\u2295");
      glyphList.put("plusminus", "\u00B1");
      glyphList.put("plusmod", "\u02D6");
      glyphList.put("plusmonospace", "\uFF0B");
      glyphList.put("plussmall", "\uFE62");
      glyphList.put("plussuperior", "\u207A");
      glyphList.put("pmonospace", "\uFF50");
      glyphList.put("pmsquare", "\u33D8");
      glyphList.put("pohiragana", "\u307D");
      glyphList.put("pointingindexdownwhite", "\u261F");
      glyphList.put("pointingindexleftwhite", "\u261C");
      glyphList.put("pointingindexrightwhite", "\u261E");
      glyphList.put("pointingindexupwhite", "\u261D");
      glyphList.put("pokatakana", "\u30DD");
      glyphList.put("poplathai", "\u0E1B");
      glyphList.put("postalmark", "\u3012");
      glyphList.put("postalmarkface", "\u3020");
      glyphList.put("pparen", "\u24AB");
      glyphList.put("precedes", "\u227A");
      glyphList.put("prescription", "\u211E");
      glyphList.put("primemod", "\u02B9");
      glyphList.put("primereversed", "\u2035");
      glyphList.put("product", "\u220F");
      glyphList.put("projective", "\u2305");
      glyphList.put("prolongedkana", "\u30FC");
      glyphList.put("propellor", "\u2318");
      glyphList.put("propersubset", "\u2282");
      glyphList.put("propersuperset", "\u2283");
      glyphList.put("proportion", "\u2237");
      glyphList.put("proportional", "\u221D");
      glyphList.put("psi", "\u03C8");
      glyphList.put("psicyrillic", "\u0471");
      glyphList.put("psilipneumatacyrilliccmb", "\u0486");
      glyphList.put("pssquare", "\u33B0");
      glyphList.put("puhiragana", "\u3077");
      glyphList.put("pukatakana", "\u30D7");
      glyphList.put("pvsquare", "\u33B4");
      glyphList.put("pwsquare", "\u33BA");
      glyphList.put("q", "\u0071");
      glyphList.put("qadeva", "\u0958");
      glyphList.put("qadmahebrew", "\u05A8");
      glyphList.put("qafarabic", "\u0642");
      glyphList.put("qaffinalarabic", "\uFED6");
      glyphList.put("qafinitialarabic", "\uFED7");
      glyphList.put("qafmedialarabic", "\uFED8");
      glyphList.put("qamats", "\u05B8");
      glyphList.put("qamats10", "\u05B8");
      glyphList.put("qamats1a", "\u05B8");
      glyphList.put("qamats1c", "\u05B8");
      glyphList.put("qamats27", "\u05B8");
      glyphList.put("qamats29", "\u05B8");
      glyphList.put("qamats33", "\u05B8");
      glyphList.put("qamatsde", "\u05B8");
      glyphList.put("qamatshebrew", "\u05B8");
      glyphList.put("qamatsnarrowhebrew", "\u05B8");
      glyphList.put("qamatsqatanhebrew", "\u05B8");
      glyphList.put("qamatsqatannarrowhebrew", "\u05B8");
      glyphList.put("qamatsqatanquarterhebrew", "\u05B8");
      glyphList.put("qamatsqatanwidehebrew", "\u05B8");
      glyphList.put("qamatsquarterhebrew", "\u05B8");
      glyphList.put("qamatswidehebrew", "\u05B8");
      glyphList.put("qarneyparahebrew", "\u059F");
      glyphList.put("qbopomofo", "\u3111");
      glyphList.put("qcircle", "\u24E0");
      glyphList.put("qhook", "\u02A0");
      glyphList.put("qmonospace", "\uFF51");
      glyphList.put("qof", "\u05E7");
      glyphList.put("qofdagesh", "\uFB47");
      glyphList.put("qofdageshhebrew", "\uFB47");
      /*
      glyphList.put("qofhatafpatah", "\u05E7 05B2");
      glyphList.put("qofhatafpatahhebrew", "\u05E7 05B2");
      glyphList.put("qofhatafsegol", "\u05E7 05B1");
      glyphList.put("qofhatafsegolhebrew", "\u05E7 05B1");
      */
      glyphList.put("qofhebrew", "\u05E7");
      /*
      glyphList.put("qofhiriq", "\u05E7 05B4");
      glyphList.put("qofhiriqhebrew", "\u05E7 05B4");
      glyphList.put("qofholam", "\u05E7 05B9");
      glyphList.put("qofholamhebrew", "\u05E7 05B9");
      glyphList.put("qofpatah", "\u05E7 05B7");
      glyphList.put("qofpatahhebrew", "\u05E7 05B7");
      glyphList.put("qofqamats", "\u05E7 05B8");
      glyphList.put("qofqamatshebrew", "\u05E7 05B8");
      glyphList.put("qofqubuts", "\u05E7 05BB");
      glyphList.put("qofqubutshebrew", "\u05E7 05BB");
      glyphList.put("qofsegol", "\u05E7 05B6");
      glyphList.put("qofsegolhebrew", "\u05E7 05B6");
      glyphList.put("qofsheva", "\u05E7 05B0");
      glyphList.put("qofshevahebrew", "\u05E7 05B0");
      glyphList.put("qoftsere", "\u05E7 05B5");
      glyphList.put("qoftserehebrew", "\u05E7 05B5");
      */
      glyphList.put("qparen", "\u24AC");
      glyphList.put("quarternote", "\u2669");
      glyphList.put("qubuts", "\u05BB");
      glyphList.put("qubuts18", "\u05BB");
      glyphList.put("qubuts25", "\u05BB");
      glyphList.put("qubuts31", "\u05BB");
      glyphList.put("qubutshebrew", "\u05BB");
      glyphList.put("qubutsnarrowhebrew", "\u05BB");
      glyphList.put("qubutsquarterhebrew", "\u05BB");
      glyphList.put("qubutswidehebrew", "\u05BB");
      glyphList.put("question", "\u003F");
      glyphList.put("questionarabic", "\u061F");
      glyphList.put("questionarmenian", "\u055E");
      glyphList.put("questiondown", "\u00BF");
      glyphList.put("questiondownsmall", "\uF7BF");
      glyphList.put("questiongreek", "\u037E");
      glyphList.put("questionmonospace", "\uFF1F");
      glyphList.put("questionsmall", "\uF73F");
      glyphList.put("quotedbl", "\"");
      glyphList.put("quotedblbase", "\u201E");
      glyphList.put("quotedblleft", "\u201C");
      glyphList.put("quotedblmonospace", "\uFF02");
      glyphList.put("quotedblprime", "\u301E");
      glyphList.put("quotedblprimereversed", "\u301D");
      glyphList.put("quotedblright", "\u201D");
      glyphList.put("quoteleft", "\u2018");
      glyphList.put("quoteleftreversed", "\u201B");
      glyphList.put("quotereversed", "\u201B");
      glyphList.put("quoteright", "\u2019");
      glyphList.put("quoterightn", "\u0149");
      glyphList.put("quotesinglbase", "\u201A");
      glyphList.put("quotesingle", "\u0027");
      glyphList.put("quotesinglemonospace", "\uFF07");
      glyphList.put("r", "\u0072");
      glyphList.put("raarmenian", "\u057C");
      glyphList.put("rabengali", "\u09B0");
      glyphList.put("racute", "\u0155");
      glyphList.put("radeva", "\u0930");
      glyphList.put("radical", "\u221A");
      glyphList.put("radicalex", "\uF8E5");
      glyphList.put("radoverssquare", "\u33AE");
      glyphList.put("radoverssquaredsquare", "\u33AF");
      glyphList.put("radsquare", "\u33AD");
      glyphList.put("rafe", "\u05BF");
      glyphList.put("rafehebrew", "\u05BF");
      glyphList.put("ragujarati", "\u0AB0");
      glyphList.put("ragurmukhi", "\u0A30");
      glyphList.put("rahiragana", "\u3089");
      glyphList.put("rakatakana", "\u30E9");
      glyphList.put("rakatakanahalfwidth", "\uFF97");
      glyphList.put("ralowerdiagonalbengali", "\u09F1");
      glyphList.put("ramiddlediagonalbengali", "\u09F0");
      glyphList.put("ramshorn", "\u0264");
      glyphList.put("ratio", "\u2236");
      glyphList.put("rbopomofo", "\u3116");
      glyphList.put("rcaron", "\u0159");
      glyphList.put("rcedilla", "\u0157");
      glyphList.put("rcircle", "\u24E1");
      glyphList.put("rcommaaccent", "\u0157");
      glyphList.put("rdblgrave", "\u0211");
      glyphList.put("rdotaccent", "\u1E59");
      glyphList.put("rdotbelow", "\u1E5B");
      glyphList.put("rdotbelowmacron", "\u1E5D");
      glyphList.put("referencemark", "\u203B");
      glyphList.put("reflexsubset", "\u2286");
      glyphList.put("reflexsuperset", "\u2287");
      glyphList.put("registered", "\u00AE");
      glyphList.put("registersans", "\uF8E8");
      glyphList.put("registerserif", "\uF6DA");
      glyphList.put("reharabic", "\u0631");
      glyphList.put("reharmenian", "\u0580");
      glyphList.put("rehfinalarabic", "\uFEAE");
      glyphList.put("rehiragana", "\u308C");
      //glyphList.put("rehyehaleflamarabic", "\u0631 FEF3 FE8E 0644");
      glyphList.put("rekatakana", "\u30EC");
      glyphList.put("rekatakanahalfwidth", "\uFF9A");
      glyphList.put("resh", "\u05E8");
      glyphList.put("reshdageshhebrew", "\uFB48");
      /*
      glyphList.put("reshhatafpatah", "\u05E8 05B2");
      glyphList.put("reshhatafpatahhebrew", "\u05E8 05B2");
      glyphList.put("reshhatafsegol", "\u05E8 05B1");
      glyphList.put("reshhatafsegolhebrew", "\u05E8 05B1");
      */
      glyphList.put("reshhebrew", "\u05E8");
      /*
      glyphList.put("reshhiriq", "\u05E8 05B4");
      glyphList.put("reshhiriqhebrew", "\u05E8 05B4");
      glyphList.put("reshholam", "\u05E8 05B9");
      glyphList.put("reshholamhebrew", "\u05E8 05B9");
      glyphList.put("reshpatah", "\u05E8 05B7");
      glyphList.put("reshpatahhebrew", "\u05E8 05B7");
      glyphList.put("reshqamats", "\u05E8 05B8");
      glyphList.put("reshqamatshebrew", "\u05E8 05B8");
      glyphList.put("reshqubuts", "\u05E8 05BB");
      glyphList.put("reshqubutshebrew", "\u05E8 05BB");
      glyphList.put("reshsegol", "\u05E8 05B6");
      glyphList.put("reshsegolhebrew", "\u05E8 05B6");
      glyphList.put("reshsheva", "\u05E8 05B0");
      glyphList.put("reshshevahebrew", "\u05E8 05B0");
      glyphList.put("reshtsere", "\u05E8 05B5");
      glyphList.put("reshtserehebrew", "\u05E8 05B5");
      */
      glyphList.put("reversedtilde", "\u223D");
      glyphList.put("reviahebrew", "\u0597");
      glyphList.put("reviamugrashhebrew", "\u0597");
      glyphList.put("revlogicalnot", "\u2310");
      glyphList.put("rfishhook", "\u027E");
      glyphList.put("rfishhookreversed", "\u027F");
      glyphList.put("rhabengali", "\u09DD");
      glyphList.put("rhadeva", "\u095D");
      glyphList.put("rho", "\u03C1");
      glyphList.put("rhook", "\u027D");
      glyphList.put("rhookturned", "\u027B");
      glyphList.put("rhookturnedsuperior", "\u02B5");
      glyphList.put("rhosymbolgreek", "\u03F1");
      glyphList.put("rhotichookmod", "\u02DE");
      glyphList.put("rieulacirclekorean", "\u3271");
      glyphList.put("rieulaparenkorean", "\u3211");
      glyphList.put("rieulcirclekorean", "\u3263");
      glyphList.put("rieulhieuhkorean", "\u3140");
      glyphList.put("rieulkiyeokkorean", "\u313A");
      glyphList.put("rieulkiyeoksioskorean", "\u3169");
      glyphList.put("rieulkorean", "\u3139");
      glyphList.put("rieulmieumkorean", "\u313B");
      glyphList.put("rieulpansioskorean", "\u316C");
      glyphList.put("rieulparenkorean", "\u3203");
      glyphList.put("rieulphieuphkorean", "\u313F");
      glyphList.put("rieulpieupkorean", "\u313C");
      glyphList.put("rieulpieupsioskorean", "\u316B");
      glyphList.put("rieulsioskorean", "\u313D");
      glyphList.put("rieulthieuthkorean", "\u313E");
      glyphList.put("rieultikeutkorean", "\u316A");
      glyphList.put("rieulyeorinhieuhkorean", "\u316D");
      glyphList.put("rightangle", "\u221F");
      glyphList.put("righttackbelowcmb", "\u0319");
      glyphList.put("righttriangle", "\u22BF");
      glyphList.put("rihiragana", "\u308A");
      glyphList.put("rikatakana", "\u30EA");
      glyphList.put("rikatakanahalfwidth", "\uFF98");
      glyphList.put("ring", "\u02DA");
      glyphList.put("ringbelowcmb", "\u0325");
      glyphList.put("ringcmb", "\u030A");
      glyphList.put("ringhalfleft", "\u02BF");
      glyphList.put("ringhalfleftarmenian", "\u0559");
      glyphList.put("ringhalfleftbelowcmb", "\u031C");
      glyphList.put("ringhalfleftcentered", "\u02D3");
      glyphList.put("ringhalfright", "\u02BE");
      glyphList.put("ringhalfrightbelowcmb", "\u0339");
      glyphList.put("ringhalfrightcentered", "\u02D2");
      glyphList.put("rinvertedbreve", "\u0213");
      glyphList.put("rittorusquare", "\u3351");
      glyphList.put("rlinebelow", "\u1E5F");
      glyphList.put("rlongleg", "\u027C");
      glyphList.put("rlonglegturned", "\u027A");
      glyphList.put("rmonospace", "\uFF52");
      glyphList.put("rohiragana", "\u308D");
      glyphList.put("rokatakana", "\u30ED");
      glyphList.put("rokatakanahalfwidth", "\uFF9B");
      glyphList.put("roruathai", "\u0E23");
      glyphList.put("rparen", "\u24AD");
      glyphList.put("rrabengali", "\u09DC");
      glyphList.put("rradeva", "\u0931");
      glyphList.put("rragurmukhi", "\u0A5C");
      glyphList.put("rreharabic", "\u0691");
      glyphList.put("rrehfinalarabic", "\uFB8D");
      glyphList.put("rrvocalicbengali", "\u09E0");
      glyphList.put("rrvocalicdeva", "\u0960");
      glyphList.put("rrvocalicgujarati", "\u0AE0");
      glyphList.put("rrvocalicvowelsignbengali", "\u09C4");
      glyphList.put("rrvocalicvowelsigndeva", "\u0944");
      glyphList.put("rrvocalicvowelsigngujarati", "\u0AC4");
      glyphList.put("rsuperior", "\uF6F1");
      glyphList.put("rtblock", "\u2590");
      glyphList.put("rturned", "\u0279");
      glyphList.put("rturnedsuperior", "\u02B4");
      glyphList.put("ruhiragana", "\u308B");
      glyphList.put("rukatakana", "\u30EB");
      glyphList.put("rukatakanahalfwidth", "\uFF99");
      glyphList.put("rupeemarkbengali", "\u09F2");
      glyphList.put("rupeesignbengali", "\u09F3");
      glyphList.put("rupiah", "\uF6DD");
      glyphList.put("ruthai", "\u0E24");
      glyphList.put("rvocalicbengali", "\u098B");
      glyphList.put("rvocalicdeva", "\u090B");
      glyphList.put("rvocalicgujarati", "\u0A8B");
      glyphList.put("rvocalicvowelsignbengali", "\u09C3");
      glyphList.put("rvocalicvowelsigndeva", "\u0943");
      glyphList.put("rvocalicvowelsigngujarati", "\u0AC3");
      glyphList.put("s", "\u0073");
      glyphList.put("sabengali", "\u09B8");
      glyphList.put("sacute", "\u015B");
      glyphList.put("sacutedotaccent", "\u1E65");
      glyphList.put("sadarabic", "\u0635");
      glyphList.put("sadeva", "\u0938");
      glyphList.put("sadfinalarabic", "\uFEBA");
      glyphList.put("sadinitialarabic", "\uFEBB");
      glyphList.put("sadmedialarabic", "\uFEBC");
      glyphList.put("sagujarati", "\u0AB8");
      glyphList.put("sagurmukhi", "\u0A38");
      glyphList.put("sahiragana", "\u3055");
      glyphList.put("sakatakana", "\u30B5");
      glyphList.put("sakatakanahalfwidth", "\uFF7B");
      glyphList.put("sallallahoualayhewasallamarabic", "\uFDFA");
      glyphList.put("samekh", "\u05E1");
      glyphList.put("samekhdagesh", "\uFB41");
      glyphList.put("samekhdageshhebrew", "\uFB41");
      glyphList.put("samekhhebrew", "\u05E1");
      glyphList.put("saraaathai", "\u0E32");
      glyphList.put("saraaethai", "\u0E41");
      glyphList.put("saraaimaimalaithai", "\u0E44");
      glyphList.put("saraaimaimuanthai", "\u0E43");
      glyphList.put("saraamthai", "\u0E33");
      glyphList.put("saraathai", "\u0E30");
      glyphList.put("saraethai", "\u0E40");
      glyphList.put("saraiileftthai", "\uF886");
      glyphList.put("saraiithai", "\u0E35");
      glyphList.put("saraileftthai", "\uF885");
      glyphList.put("saraithai", "\u0E34");
      glyphList.put("saraothai", "\u0E42");
      glyphList.put("saraueeleftthai", "\uF888");
      glyphList.put("saraueethai", "\u0E37");
      glyphList.put("saraueleftthai", "\uF887");
      glyphList.put("sarauethai", "\u0E36");
      glyphList.put("sarauthai", "\u0E38");
      glyphList.put("sarauuthai", "\u0E39");
      glyphList.put("sbopomofo", "\u3119");
      glyphList.put("scaron", "\u0161");
      glyphList.put("scarondotaccent", "\u1E67");
      glyphList.put("scedilla", "\u015F");
      glyphList.put("schwa", "\u0259");
      glyphList.put("schwacyrillic", "\u04D9");
      glyphList.put("schwadieresiscyrillic", "\u04DB");
      glyphList.put("schwahook", "\u025A");
      glyphList.put("scircle", "\u24E2");
      glyphList.put("scircumflex", "\u015D");
      glyphList.put("scommaaccent", "\u0219");
      glyphList.put("sdotaccent", "\u1E61");
      glyphList.put("sdotbelow", "\u1E63");
      glyphList.put("sdotbelowdotaccent", "\u1E69");
      glyphList.put("seagullbelowcmb", "\u033C");
      glyphList.put("second", "\u2033");
      glyphList.put("secondtonechinese", "\u02CA");
      glyphList.put("section", "\u00A7");
      glyphList.put("seenarabic", "\u0633");
      glyphList.put("seenfinalarabic", "\uFEB2");
      glyphList.put("seeninitialarabic", "\uFEB3");
      glyphList.put("seenmedialarabic", "\uFEB4");
      glyphList.put("segol", "\u05B6");
      glyphList.put("segol13", "\u05B6");
      glyphList.put("segol1f", "\u05B6");
      glyphList.put("segol2c", "\u05B6");
      glyphList.put("segolhebrew", "\u05B6");
      glyphList.put("segolnarrowhebrew", "\u05B6");
      glyphList.put("segolquarterhebrew", "\u05B6");
      glyphList.put("segoltahebrew", "\u0592");
      glyphList.put("segolwidehebrew", "\u05B6");
      glyphList.put("seharmenian", "\u057D");
      glyphList.put("sehiragana", "\u305B");
      glyphList.put("sekatakana", "\u30BB");
      glyphList.put("sekatakanahalfwidth", "\uFF7E");
      glyphList.put("semicolon", "\u003B");
      glyphList.put("semicolonarabic", "\u061B");
      glyphList.put("semicolonmonospace", "\uFF1B");
      glyphList.put("semicolonsmall", "\uFE54");
      glyphList.put("semivoicedmarkkana", "\u309C");
      glyphList.put("semivoicedmarkkanahalfwidth", "\uFF9F");
      glyphList.put("sentisquare", "\u3322");
      glyphList.put("sentosquare", "\u3323");
      glyphList.put("seven", "\u0037");
      glyphList.put("sevenarabic", "\u0667");
      glyphList.put("sevenbengali", "\u09ED");
      glyphList.put("sevencircle", "\u2466");
      glyphList.put("sevencircleinversesansserif", "\u2790");
      glyphList.put("sevendeva", "\u096D");
      glyphList.put("seveneighths", "\u215E");
      glyphList.put("sevengujarati", "\u0AED");
      glyphList.put("sevengurmukhi", "\u0A6D");
      glyphList.put("sevenhackarabic", "\u0667");
      glyphList.put("sevenhangzhou", "\u3027");
      glyphList.put("sevenideographicparen", "\u3226");
      glyphList.put("seveninferior", "\u2087");
      glyphList.put("sevenmonospace", "\uFF17");
      glyphList.put("sevenoldstyle", "\uF737");
      glyphList.put("sevenparen", "\u247A");
      glyphList.put("sevenperiod", "\u248E");
      glyphList.put("sevenpersian", "\u06F7");
      glyphList.put("sevenroman", "\u2176");
      glyphList.put("sevensuperior", "\u2077");
      glyphList.put("seventeencircle", "\u2470");
      glyphList.put("seventeenparen", "\u2484");
      glyphList.put("seventeenperiod", "\u2498");
      glyphList.put("seventhai", "\u0E57");
      glyphList.put("sfthyphen", "\u00AD");
      glyphList.put("shaarmenian", "\u0577");
      glyphList.put("shabengali", "\u09B6");
      glyphList.put("shacyrillic", "\u0448");
      glyphList.put("shaddaarabic", "\u0651");
      glyphList.put("shaddadammaarabic", "\uFC61");
      glyphList.put("shaddadammatanarabic", "\uFC5E");
      glyphList.put("shaddafathaarabic", "\uFC60");
      //glyphList.put("shaddafathatanarabic", "\u0651 064B");
      glyphList.put("shaddakasraarabic", "\uFC62");
      glyphList.put("shaddakasratanarabic", "\uFC5F");
      glyphList.put("shade", "\u2592");
      glyphList.put("shadedark", "\u2593");
      glyphList.put("shadelight", "\u2591");
      glyphList.put("shademedium", "\u2592");
      glyphList.put("shadeva", "\u0936");
      glyphList.put("shagujarati", "\u0AB6");
      glyphList.put("shagurmukhi", "\u0A36");
      glyphList.put("shalshelethebrew", "\u0593");
      glyphList.put("shbopomofo", "\u3115");
      glyphList.put("shchacyrillic", "\u0449");
      glyphList.put("sheenarabic", "\u0634");
      glyphList.put("sheenfinalarabic", "\uFEB6");
      glyphList.put("sheeninitialarabic", "\uFEB7");
      glyphList.put("sheenmedialarabic", "\uFEB8");
      glyphList.put("sheicoptic", "\u03E3");
      glyphList.put("sheqel", "\u20AA");
      glyphList.put("sheqelhebrew", "\u20AA");
      glyphList.put("sheva", "\u05B0");
      glyphList.put("sheva115", "\u05B0");
      glyphList.put("sheva15", "\u05B0");
      glyphList.put("sheva22", "\u05B0");
      glyphList.put("sheva2e", "\u05B0");
      glyphList.put("shevahebrew", "\u05B0");
      glyphList.put("shevanarrowhebrew", "\u05B0");
      glyphList.put("shevaquarterhebrew", "\u05B0");
      glyphList.put("shevawidehebrew", "\u05B0");
      glyphList.put("shhacyrillic", "\u04BB");
      glyphList.put("shimacoptic", "\u03ED");
      glyphList.put("shin", "\u05E9");
      glyphList.put("shindagesh", "\uFB49");
      glyphList.put("shindageshhebrew", "\uFB49");
      glyphList.put("shindageshshindot", "\uFB2C");
      glyphList.put("shindageshshindothebrew", "\uFB2C");
      glyphList.put("shindageshsindot", "\uFB2D");
      glyphList.put("shindageshsindothebrew", "\uFB2D");
      glyphList.put("shindothebrew", "\u05C1");
      glyphList.put("shinhebrew", "\u05E9");
      glyphList.put("shinshindot", "\uFB2A");
      glyphList.put("shinshindothebrew", "\uFB2A");
      glyphList.put("shinsindot", "\uFB2B");
      glyphList.put("shinsindothebrew", "\uFB2B");
      glyphList.put("shook", "\u0282");
      glyphList.put("sigma", "\u03C3");
      glyphList.put("sigma1", "\u03C2");
      glyphList.put("sigmafinal", "\u03C2");
      glyphList.put("sigmalunatesymbolgreek", "\u03F2");
      glyphList.put("sihiragana", "\u3057");
      glyphList.put("sikatakana", "\u30B7");
      glyphList.put("sikatakanahalfwidth", "\uFF7C");
      glyphList.put("siluqhebrew", "\u05BD");
      glyphList.put("siluqlefthebrew", "\u05BD");
      glyphList.put("similar", "\u223C");
      glyphList.put("sindothebrew", "\u05C2");
      glyphList.put("siosacirclekorean", "\u3274");
      glyphList.put("siosaparenkorean", "\u3214");
      glyphList.put("sioscieuckorean", "\u317E");
      glyphList.put("sioscirclekorean", "\u3266");
      glyphList.put("sioskiyeokkorean", "\u317A");
      glyphList.put("sioskorean", "\u3145");
      glyphList.put("siosnieunkorean", "\u317B");
      glyphList.put("siosparenkorean", "\u3206");
      glyphList.put("siospieupkorean", "\u317D");
      glyphList.put("siostikeutkorean", "\u317C");
      glyphList.put("six", "\u0036");
      glyphList.put("sixarabic", "\u0666");
      glyphList.put("sixbengali", "\u09EC");
      glyphList.put("sixcircle", "\u2465");
      glyphList.put("sixcircleinversesansserif", "\u278F");
      glyphList.put("sixdeva", "\u096C");
      glyphList.put("sixgujarati", "\u0AEC");
      glyphList.put("sixgurmukhi", "\u0A6C");
      glyphList.put("sixhackarabic", "\u0666");
      glyphList.put("sixhangzhou", "\u3026");
      glyphList.put("sixideographicparen", "\u3225");
      glyphList.put("sixinferior", "\u2086");
      glyphList.put("sixmonospace", "\uFF16");
      glyphList.put("sixoldstyle", "\uF736");
      glyphList.put("sixparen", "\u2479");
      glyphList.put("sixperiod", "\u248D");
      glyphList.put("sixpersian", "\u06F6");
      glyphList.put("sixroman", "\u2175");
      glyphList.put("sixsuperior", "\u2076");
      glyphList.put("sixteencircle", "\u246F");
      glyphList.put("sixteencurrencydenominatorbengali", "\u09F9");
      glyphList.put("sixteenparen", "\u2483");
      glyphList.put("sixteenperiod", "\u2497");
      glyphList.put("sixthai", "\u0E56");
      glyphList.put("slash", "\u002F");
      glyphList.put("slashmonospace", "\uFF0F");
      glyphList.put("slong", "\u017F");
      glyphList.put("slongdotaccent", "\u1E9B");
      glyphList.put("smileface", "\u263A");
      glyphList.put("smonospace", "\uFF53");
      glyphList.put("sofpasuqhebrew", "\u05C3");
      glyphList.put("softhyphen", "\u00AD");
      glyphList.put("softsigncyrillic", "\u044C");
      glyphList.put("sohiragana", "\u305D");
      glyphList.put("sokatakana", "\u30BD");
      glyphList.put("sokatakanahalfwidth", "\uFF7F");
      glyphList.put("soliduslongoverlaycmb", "\u0338");
      glyphList.put("solidusshortoverlaycmb", "\u0337");
      glyphList.put("sorusithai", "\u0E29");
      glyphList.put("sosalathai", "\u0E28");
      glyphList.put("sosothai", "\u0E0B");
      glyphList.put("sosuathai", "\u0E2A");
      glyphList.put("space", "\u0020");
      glyphList.put("spacehackarabic", "\u0020");
      glyphList.put("spade", "\u2660");
      glyphList.put("spadesuitblack", "\u2660");
      glyphList.put("spadesuitwhite", "\u2664");
      glyphList.put("sparen", "\u24AE");
      glyphList.put("squarebelowcmb", "\u033B");
      glyphList.put("squarecc", "\u33C4");
      glyphList.put("squarecm", "\u339D");
      glyphList.put("squarediagonalcrosshatchfill", "\u25A9");
      glyphList.put("squarehorizontalfill", "\u25A4");
      glyphList.put("squarekg", "\u338F");
      glyphList.put("squarekm", "\u339E");
      glyphList.put("squarekmcapital", "\u33CE");
      glyphList.put("squareln", "\u33D1");
      glyphList.put("squarelog", "\u33D2");
      glyphList.put("squaremg", "\u338E");
      glyphList.put("squaremil", "\u33D5");
      glyphList.put("squaremm", "\u339C");
      glyphList.put("squaremsquared", "\u33A1");
      glyphList.put("squareorthogonalcrosshatchfill", "\u25A6");
      glyphList.put("squareupperlefttolowerrightfill", "\u25A7");
      glyphList.put("squareupperrighttolowerleftfill", "\u25A8");
      glyphList.put("squareverticalfill", "\u25A5");
      glyphList.put("squarewhitewithsmallblack", "\u25A3");
      glyphList.put("srsquare", "\u33DB");
      glyphList.put("ssabengali", "\u09B7");
      glyphList.put("ssadeva", "\u0937");
      glyphList.put("ssagujarati", "\u0AB7");
      glyphList.put("ssangcieuckorean", "\u3149");
      glyphList.put("ssanghieuhkorean", "\u3185");
      glyphList.put("ssangieungkorean", "\u3180");
      glyphList.put("ssangkiyeokkorean", "\u3132");
      glyphList.put("ssangnieunkorean", "\u3165");
      glyphList.put("ssangpieupkorean", "\u3143");
      glyphList.put("ssangsioskorean", "\u3146");
      glyphList.put("ssangtikeutkorean", "\u3138");
      glyphList.put("ssuperior", "\uF6F2");
      glyphList.put("sterling", "\u00A3");
      glyphList.put("sterlingmonospace", "\uFFE1");
      glyphList.put("strokelongoverlaycmb", "\u0336");
      glyphList.put("strokeshortoverlaycmb", "\u0335");
      glyphList.put("subset", "\u2282");
      glyphList.put("subsetnotequal", "\u228A");
      glyphList.put("subsetorequal", "\u2286");
      glyphList.put("succeeds", "\u227B");
      glyphList.put("suchthat", "\u220B");
      glyphList.put("suhiragana", "\u3059");
      glyphList.put("sukatakana", "\u30B9");
      glyphList.put("sukatakanahalfwidth", "\uFF7D");
      glyphList.put("sukunarabic", "\u0652");
      glyphList.put("summation", "\u2211");
      glyphList.put("sun", "\u263C");
      glyphList.put("superset", "\u2283");
      glyphList.put("supersetnotequal", "\u228B");
      glyphList.put("supersetorequal", "\u2287");
      glyphList.put("svsquare", "\u33DC");
      glyphList.put("syouwaerasquare", "\u337C");
      glyphList.put("t", "\u0074");
      glyphList.put("tabengali", "\u09A4");
      glyphList.put("tackdown", "\u22A4");
      glyphList.put("tackleft", "\u22A3");
      glyphList.put("tadeva", "\u0924");
      glyphList.put("tagujarati", "\u0AA4");
      glyphList.put("tagurmukhi", "\u0A24");
      glyphList.put("taharabic", "\u0637");
      glyphList.put("tahfinalarabic", "\uFEC2");
      glyphList.put("tahinitialarabic", "\uFEC3");
      glyphList.put("tahiragana", "\u305F");
      glyphList.put("tahmedialarabic", "\uFEC4");
      glyphList.put("taisyouerasquare", "\u337D");
      glyphList.put("takatakana", "\u30BF");
      glyphList.put("takatakanahalfwidth", "\uFF80");
      glyphList.put("tatweelarabic", "\u0640");
      glyphList.put("tau", "\u03C4");
      glyphList.put("tav", "\u05EA");
      glyphList.put("tavdages", "\uFB4A");
      glyphList.put("tavdagesh", "\uFB4A");
      glyphList.put("tavdageshhebrew", "\uFB4A");
      glyphList.put("tavhebrew", "\u05EA");
      glyphList.put("tbar", "\u0167");
      glyphList.put("tbopomofo", "\u310A");
      glyphList.put("tcaron", "\u0165");
      glyphList.put("tccurl", "\u02A8");
      glyphList.put("tcedilla", "\u0163");
      glyphList.put("tcheharabic", "\u0686");
      glyphList.put("tchehfinalarabic", "\uFB7B");
      glyphList.put("tchehinitialarabic", "\uFB7C");
      glyphList.put("tchehmedialarabic", "\uFB7D");
      //glyphList.put("tchehmeeminitialarabic", "\uFB7CFEE4");
      glyphList.put("tcircle", "\u24E3");
      glyphList.put("tcircumflexbelow", "\u1E71");
      glyphList.put("tcommaaccent", "\u0163");
      glyphList.put("tdieresis", "\u1E97");
      glyphList.put("tdotaccent", "\u1E6B");
      glyphList.put("tdotbelow", "\u1E6D");
      glyphList.put("tecyrillic", "\u0442");
      glyphList.put("tedescendercyrillic", "\u04AD");
      glyphList.put("teharabic", "\u062A");
      glyphList.put("tehfinalarabic", "\uFE96");
      glyphList.put("tehhahinitialarabic", "\uFCA2");
      glyphList.put("tehhahisolatedarabic", "\uFC0C");
      glyphList.put("tehinitialarabic", "\uFE97");
      glyphList.put("tehiragana", "\u3066");
      glyphList.put("tehjeeminitialarabic", "\uFCA1");
      glyphList.put("tehjeemisolatedarabic", "\uFC0B");
      glyphList.put("tehmarbutaarabic", "\u0629");
      glyphList.put("tehmarbutafinalarabic", "\uFE94");
      glyphList.put("tehmedialarabic", "\uFE98");
      glyphList.put("tehmeeminitialarabic", "\uFCA4");
      glyphList.put("tehmeemisolatedarabic", "\uFC0E");
      glyphList.put("tehnoonfinalarabic", "\uFC73");
      glyphList.put("tekatakana", "\u30C6");
      glyphList.put("tekatakanahalfwidth", "\uFF83");
      glyphList.put("telephone", "\u2121");
      glyphList.put("telephoneblack", "\u260E");
      glyphList.put("telishagedolahebrew", "\u05A0");
      glyphList.put("telishaqetanahebrew", "\u05A9");
      glyphList.put("tencircle", "\u2469");
      glyphList.put("tenideographicparen", "\u3229");
      glyphList.put("tenparen", "\u247D");
      glyphList.put("tenperiod", "\u2491");
      glyphList.put("tenroman", "\u2179");
      glyphList.put("tesh", "\u02A7");
      glyphList.put("tet", "\u05D8");
      glyphList.put("tetdagesh", "\uFB38");
      glyphList.put("tetdageshhebrew", "\uFB38");
      glyphList.put("tethebrew", "\u05D8");
      glyphList.put("tetsecyrillic", "\u04B5");
      glyphList.put("tevirhebrew", "\u059B");
      glyphList.put("tevirlefthebrew", "\u059B");
      glyphList.put("thabengali", "\u09A5");
      glyphList.put("thadeva", "\u0925");
      glyphList.put("thagujarati", "\u0AA5");
      glyphList.put("thagurmukhi", "\u0A25");
      glyphList.put("thalarabic", "\u0630");
      glyphList.put("thalfinalarabic", "\uFEAC");
      glyphList.put("thanthakhatlowleftthai", "\uF898");
      glyphList.put("thanthakhatlowrightthai", "\uF897");
      glyphList.put("thanthakhatthai", "\u0E4C");
      glyphList.put("thanthakhatupperleftthai", "\uF896");
      glyphList.put("theharabic", "\u062B");
      glyphList.put("thehfinalarabic", "\uFE9A");
      glyphList.put("thehinitialarabic", "\uFE9B");
      glyphList.put("thehmedialarabic", "\uFE9C");
      glyphList.put("thereexists", "\u2203");
      glyphList.put("therefore", "\u2234");
      glyphList.put("theta", "\u03B8");
      glyphList.put("theta1", "\u03D1");
      glyphList.put("thetasymbolgreek", "\u03D1");
      glyphList.put("thieuthacirclekorean", "\u3279");
      glyphList.put("thieuthaparenkorean", "\u3219");
      glyphList.put("thieuthcirclekorean", "\u326B");
      glyphList.put("thieuthkorean", "\u314C");
      glyphList.put("thieuthparenkorean", "\u320B");
      glyphList.put("thirteencircle", "\u246C");
      glyphList.put("thirteenparen", "\u2480");
      glyphList.put("thirteenperiod", "\u2494");
      glyphList.put("thonangmonthothai", "\u0E11");
      glyphList.put("thook", "\u01AD");
      glyphList.put("thophuthaothai", "\u0E12");
      glyphList.put("thorn", "\u00FE");
      glyphList.put("thothahanthai", "\u0E17");
      glyphList.put("thothanthai", "\u0E10");
      glyphList.put("thothongthai", "\u0E18");
      glyphList.put("thothungthai", "\u0E16");
      glyphList.put("thousandcyrillic", "\u0482");
      glyphList.put("thousandsseparatorarabic", "\u066C");
      glyphList.put("thousandsseparatorpersian", "\u066C");
      glyphList.put("three", "\u0033");
      glyphList.put("threearabic", "\u0663");
      glyphList.put("threebengali", "\u09E9");
      glyphList.put("threecircle", "\u2462");
      glyphList.put("threecircleinversesansserif", "\u278C");
      glyphList.put("threedeva", "\u0969");
      glyphList.put("threeeighths", "\u215C");
      glyphList.put("threegujarati", "\u0AE9");
      glyphList.put("threegurmukhi", "\u0A69");
      glyphList.put("threehackarabic", "\u0663");
      glyphList.put("threehangzhou", "\u3023");
      glyphList.put("threeideographicparen", "\u3222");
      glyphList.put("threeinferior", "\u2083");
      glyphList.put("threemonospace", "\uFF13");
      glyphList.put("threenumeratorbengali", "\u09F6");
      glyphList.put("threeoldstyle", "\uF733");
      glyphList.put("threeparen", "\u2476");
      glyphList.put("threeperiod", "\u248A");
      glyphList.put("threepersian", "\u06F3");
      glyphList.put("threequarters", "\u00BE");
      glyphList.put("threequartersemdash", "\uF6DE");
      glyphList.put("threeroman", "\u2172");
      glyphList.put("threesuperior", "\u00B3");
      glyphList.put("threethai", "\u0E53");
      glyphList.put("thzsquare", "\u3394");
      glyphList.put("tihiragana", "\u3061");
      glyphList.put("tikatakana", "\u30C1");
      glyphList.put("tikatakanahalfwidth", "\uFF81");
      glyphList.put("tikeutacirclekorean", "\u3270");
      glyphList.put("tikeutaparenkorean", "\u3210");
      glyphList.put("tikeutcirclekorean", "\u3262");
      glyphList.put("tikeutkorean", "\u3137");
      glyphList.put("tikeutparenkorean", "\u3202");
      glyphList.put("tilde", "\u02DC");
      glyphList.put("tildebelowcmb", "\u0330");
      glyphList.put("tildecmb", "\u0303");
      glyphList.put("tildecomb", "\u0303");
      glyphList.put("tildedoublecmb", "\u0360");
      glyphList.put("tildeoperator", "\u223C");
      glyphList.put("tildeoverlaycmb", "\u0334");
      glyphList.put("tildeverticalcmb", "\u033E");
      glyphList.put("timescircle", "\u2297");
      glyphList.put("tipehahebrew", "\u0596");
      glyphList.put("tipehalefthebrew", "\u0596");
      glyphList.put("tippigurmukhi", "\u0A70");
      glyphList.put("titlocyrilliccmb", "\u0483");
      glyphList.put("tiwnarmenian", "\u057F");
      glyphList.put("tlinebelow", "\u1E6F");
      glyphList.put("tmonospace", "\uFF54");
      glyphList.put("toarmenian", "\u0569");
      glyphList.put("tohiragana", "\u3068");
      glyphList.put("tokatakana", "\u30C8");
      glyphList.put("tokatakanahalfwidth", "\uFF84");
      glyphList.put("tonebarextrahighmod", "\u02E5");
      glyphList.put("tonebarextralowmod", "\u02E9");
      glyphList.put("tonebarhighmod", "\u02E6");
      glyphList.put("tonebarlowmod", "\u02E8");
      glyphList.put("tonebarmidmod", "\u02E7");
      glyphList.put("tonefive", "\u01BD");
      glyphList.put("tonesix", "\u0185");
      glyphList.put("tonetwo", "\u01A8");
      glyphList.put("tonos", "\u0384");
      glyphList.put("tonsquare", "\u3327");
      glyphList.put("topatakthai", "\u0E0F");
      glyphList.put("tortoiseshellbracketleft", "\u3014");
      glyphList.put("tortoiseshellbracketleftsmall", "\uFE5D");
      glyphList.put("tortoiseshellbracketleftvertical", "\uFE39");
      glyphList.put("tortoiseshellbracketright", "\u3015");
      glyphList.put("tortoiseshellbracketrightsmall", "\uFE5E");
      glyphList.put("tortoiseshellbracketrightvertical", "\uFE3A");
      glyphList.put("totaothai", "\u0E15");
      glyphList.put("tpalatalhook", "\u01AB");
      glyphList.put("tparen", "\u24AF");
      glyphList.put("trademark", "\u2122");
      glyphList.put("trademarksans", "\uF8EA");
      glyphList.put("trademarkserif", "\uF6DB");
      glyphList.put("tretroflexhook", "\u0288");
      glyphList.put("triagdn", "\u25BC");
      glyphList.put("triaglf", "\u25C4");
      glyphList.put("triagrt", "\u25BA");
      glyphList.put("triagup", "\u25B2");
      glyphList.put("ts", "\u02A6");
      glyphList.put("tsadi", "\u05E6");
      glyphList.put("tsadidagesh", "\uFB46");
      glyphList.put("tsadidageshhebrew", "\uFB46");
      glyphList.put("tsadihebrew", "\u05E6");
      glyphList.put("tsecyrillic", "\u0446");
      glyphList.put("tsere", "\u05B5");
      glyphList.put("tsere12", "\u05B5");
      glyphList.put("tsere1e", "\u05B5");
      glyphList.put("tsere2b", "\u05B5");
      glyphList.put("tserehebrew", "\u05B5");
      glyphList.put("tserenarrowhebrew", "\u05B5");
      glyphList.put("tserequarterhebrew", "\u05B5");
      glyphList.put("tserewidehebrew", "\u05B5");
      glyphList.put("tshecyrillic", "\u045B");
      glyphList.put("tsuperior", "\uF6F3");
      glyphList.put("ttabengali", "\u099F");
      glyphList.put("ttadeva", "\u091F");
      glyphList.put("ttagujarati", "\u0A9F");
      glyphList.put("ttagurmukhi", "\u0A1F");
      glyphList.put("tteharabic", "\u0679");
      glyphList.put("ttehfinalarabic", "\uFB67");
      glyphList.put("ttehinitialarabic", "\uFB68");
      glyphList.put("ttehmedialarabic", "\uFB69");
      glyphList.put("tthabengali", "\u09A0");
      glyphList.put("tthadeva", "\u0920");
      glyphList.put("tthagujarati", "\u0AA0");
      glyphList.put("tthagurmukhi", "\u0A20");
      glyphList.put("tturned", "\u0287");
      glyphList.put("tuhiragana", "\u3064");
      glyphList.put("tukatakana", "\u30C4");
      glyphList.put("tukatakanahalfwidth", "\uFF82");
      glyphList.put("tusmallhiragana", "\u3063");
      glyphList.put("tusmallkatakana", "\u30C3");
      glyphList.put("tusmallkatakanahalfwidth", "\uFF6F");
      glyphList.put("twelvecircle", "\u246B");
      glyphList.put("twelveparen", "\u247F");
      glyphList.put("twelveperiod", "\u2493");
      glyphList.put("twelveroman", "\u217B");
      glyphList.put("twentycircle", "\u2473");
      glyphList.put("twentyhangzhou", "\u5344");
      glyphList.put("twentyparen", "\u2487");
      glyphList.put("twentyperiod", "\u249B");
      glyphList.put("two", "\u0032");
      glyphList.put("twoarabic", "\u0662");
      glyphList.put("twobengali", "\u09E8");
      glyphList.put("twocircle", "\u2461");
      glyphList.put("twocircleinversesansserif", "\u278B");
      glyphList.put("twodeva", "\u0968");
      glyphList.put("twodotenleader", "\u2025");
      glyphList.put("twodotleader", "\u2025");
      glyphList.put("twodotleadervertical", "\uFE30");
      glyphList.put("twogujarati", "\u0AE8");
      glyphList.put("twogurmukhi", "\u0A68");
      glyphList.put("twohackarabic", "\u0662");
      glyphList.put("twohangzhou", "\u3022");
      glyphList.put("twoideographicparen", "\u3221");
      glyphList.put("twoinferior", "\u2082");
      glyphList.put("twomonospace", "\uFF12");
      glyphList.put("twonumeratorbengali", "\u09F5");
      glyphList.put("twooldstyle", "\uF732");
      glyphList.put("twoparen", "\u2475");
      glyphList.put("twoperiod", "\u2489");
      glyphList.put("twopersian", "\u06F2");
      glyphList.put("tworoman", "\u2171");
      glyphList.put("twostroke", "\u01BB");
      glyphList.put("twosuperior", "\u00B2");
      glyphList.put("twothai", "\u0E52");
      glyphList.put("twothirds", "\u2154");
      glyphList.put("u", "\u0075");
      glyphList.put("uacute", "\u00FA");
      glyphList.put("ubar", "\u0289");
      glyphList.put("ubengali", "\u0989");
      glyphList.put("ubopomofo", "\u3128");
      glyphList.put("ubreve", "\u016D");
      glyphList.put("ucaron", "\u01D4");
      glyphList.put("ucircle", "\u24E4");
      glyphList.put("ucircumflex", "\u00FB");
      glyphList.put("ucircumflexbelow", "\u1E77");
      glyphList.put("ucyrillic", "\u0443");
      glyphList.put("udattadeva", "\u0951");
      glyphList.put("udblacute", "\u0171");
      glyphList.put("udblgrave", "\u0215");
      glyphList.put("udeva", "\u0909");
      glyphList.put("udieresis", "\u00FC");
      glyphList.put("udieresisacute", "\u01D8");
      glyphList.put("udieresisbelow", "\u1E73");
      glyphList.put("udieresiscaron", "\u01DA");
      glyphList.put("udieresiscyrillic", "\u04F1");
      glyphList.put("udieresisgrave", "\u01DC");
      glyphList.put("udieresismacron", "\u01D6");
      glyphList.put("udotbelow", "\u1EE5");
      glyphList.put("ugrave", "\u00F9");
      glyphList.put("ugujarati", "\u0A89");
      glyphList.put("ugurmukhi", "\u0A09");
      glyphList.put("uhiragana", "\u3046");
      glyphList.put("uhookabove", "\u1EE7");
      glyphList.put("uhorn", "\u01B0");
      glyphList.put("uhornacute", "\u1EE9");
      glyphList.put("uhorndotbelow", "\u1EF1");
      glyphList.put("uhorngrave", "\u1EEB");
      glyphList.put("uhornhookabove", "\u1EED");
      glyphList.put("uhorntilde", "\u1EEF");
      glyphList.put("uhungarumlaut", "\u0171");
      glyphList.put("uhungarumlautcyrillic", "\u04F3");
      glyphList.put("uinvertedbreve", "\u0217");
      glyphList.put("ukatakana", "\u30A6");
      glyphList.put("ukatakanahalfwidth", "\uFF73");
      glyphList.put("ukcyrillic", "\u0479");
      glyphList.put("ukorean", "\u315C");
      glyphList.put("umacron", "\u016B");
      glyphList.put("umacroncyrillic", "\u04EF");
      glyphList.put("umacrondieresis", "\u1E7B");
      glyphList.put("umatragurmukhi", "\u0A41");
      glyphList.put("umonospace", "\uFF55");
      glyphList.put("underscore", "\u005F");
      glyphList.put("underscoredbl", "\u2017");
      glyphList.put("underscoremonospace", "\uFF3F");
      glyphList.put("underscorevertical", "\uFE33");
      glyphList.put("underscorewavy", "\uFE4F");
      glyphList.put("union", "\u222A");
      glyphList.put("universal", "\u2200");
      glyphList.put("uogonek", "\u0173");
      glyphList.put("uparen", "\u24B0");
      glyphList.put("upblock", "\u2580");
      glyphList.put("upperdothebrew", "\u05C4");
      glyphList.put("upsilon", "\u03C5");
      glyphList.put("upsilondieresis", "\u03CB");
      glyphList.put("upsilondieresistonos", "\u03B0");
      glyphList.put("upsilonlatin", "\u028A");
      glyphList.put("upsilontonos", "\u03CD");
      glyphList.put("uptackbelowcmb", "\u031D");
      glyphList.put("uptackmod", "\u02D4");
      glyphList.put("uragurmukhi", "\u0A73");
      glyphList.put("uring", "\u016F");
      glyphList.put("ushortcyrillic", "\u045E");
      glyphList.put("usmallhiragana", "\u3045");
      glyphList.put("usmallkatakana", "\u30A5");
      glyphList.put("usmallkatakanahalfwidth", "\uFF69");
      glyphList.put("ustraightcyrillic", "\u04AF");
      glyphList.put("ustraightstrokecyrillic", "\u04B1");
      glyphList.put("utilde", "\u0169");
      glyphList.put("utildeacute", "\u1E79");
      glyphList.put("utildebelow", "\u1E75");
      glyphList.put("uubengali", "\u098A");
      glyphList.put("uudeva", "\u090A");
      glyphList.put("uugujarati", "\u0A8A");
      glyphList.put("uugurmukhi", "\u0A0A");
      glyphList.put("uumatragurmukhi", "\u0A42");
      glyphList.put("uuvowelsignbengali", "\u09C2");
      glyphList.put("uuvowelsigndeva", "\u0942");
      glyphList.put("uuvowelsigngujarati", "\u0AC2");
      glyphList.put("uvowelsignbengali", "\u09C1");
      glyphList.put("uvowelsigndeva", "\u0941");
      glyphList.put("uvowelsigngujarati", "\u0AC1");
      glyphList.put("v", "\u0076");
      glyphList.put("vadeva", "\u0935");
      glyphList.put("vagujarati", "\u0AB5");
      glyphList.put("vagurmukhi", "\u0A35");
      glyphList.put("vakatakana", "\u30F7");
      glyphList.put("vav", "\u05D5");
      glyphList.put("vavdagesh", "\uFB35");
      glyphList.put("vavdagesh65", "\uFB35");
      glyphList.put("vavdageshhebrew", "\uFB35");
      glyphList.put("vavhebrew", "\u05D5");
      glyphList.put("vavholam", "\uFB4B");
      glyphList.put("vavholamhebrew", "\uFB4B");
      glyphList.put("vavvavhebrew", "\u05F0");
      glyphList.put("vavyodhebrew", "\u05F1");
      glyphList.put("vcircle", "\u24E5");
      glyphList.put("vdotbelow", "\u1E7F");
      glyphList.put("vecyrillic", "\u0432");
      glyphList.put("veharabic", "\u06A4");
      glyphList.put("vehfinalarabic", "\uFB6B");
      glyphList.put("vehinitialarabic", "\uFB6C");
      glyphList.put("vehmedialarabic", "\uFB6D");
      glyphList.put("vekatakana", "\u30F9");
      glyphList.put("venus", "\u2640");
      glyphList.put("verticalbar", "\u007C");
      glyphList.put("verticallineabovecmb", "\u030D");
      glyphList.put("verticallinebelowcmb", "\u0329");
      glyphList.put("verticallinelowmod", "\u02CC");
      glyphList.put("verticallinemod", "\u02C8");
      glyphList.put("vewarmenian", "\u057E");
      glyphList.put("vhook", "\u028B");
      glyphList.put("vikatakana", "\u30F8");
      glyphList.put("viramabengali", "\u09CD");
      glyphList.put("viramadeva", "\u094D");
      glyphList.put("viramagujarati", "\u0ACD");
      glyphList.put("visargabengali", "\u0983");
      glyphList.put("visargadeva", "\u0903");
      glyphList.put("visargagujarati", "\u0A83");
      glyphList.put("vmonospace", "\uFF56");
      glyphList.put("voarmenian", "\u0578");
      glyphList.put("voicediterationhiragana", "\u309E");
      glyphList.put("voicediterationkatakana", "\u30FE");
      glyphList.put("voicedmarkkana", "\u309B");
      glyphList.put("voicedmarkkanahalfwidth", "\uFF9E");
      glyphList.put("vokatakana", "\u30FA");
      glyphList.put("vparen", "\u24B1");
      glyphList.put("vtilde", "\u1E7D");
      glyphList.put("vturned", "\u028C");
      glyphList.put("vuhiragana", "\u3094");
      glyphList.put("vukatakana", "\u30F4");
      glyphList.put("w", "\u0077");
      glyphList.put("wacute", "\u1E83");
      glyphList.put("waekorean", "\u3159");
      glyphList.put("wahiragana", "\u308F");
      glyphList.put("wakatakana", "\u30EF");
      glyphList.put("wakatakanahalfwidth", "\uFF9C");
      glyphList.put("wakorean", "\u3158");
      glyphList.put("wasmallhiragana", "\u308E");
      glyphList.put("wasmallkatakana", "\u30EE");
      glyphList.put("wattosquare", "\u3357");
      glyphList.put("wavedash", "\u301C");
      glyphList.put("wavyunderscorevertical", "\uFE34");
      glyphList.put("wawarabic", "\u0648");
      glyphList.put("wawfinalarabic", "\uFEEE");
      glyphList.put("wawhamzaabovearabic", "\u0624");
      glyphList.put("wawhamzaabovefinalarabic", "\uFE86");
      glyphList.put("wbsquare", "\u33DD");
      glyphList.put("wcircle", "\u24E6");
      glyphList.put("wcircumflex", "\u0175");
      glyphList.put("wdieresis", "\u1E85");
      glyphList.put("wdotaccent", "\u1E87");
      glyphList.put("wdotbelow", "\u1E89");
      glyphList.put("wehiragana", "\u3091");
      glyphList.put("weierstrass", "\u2118");
      glyphList.put("wekatakana", "\u30F1");
      glyphList.put("wekorean", "\u315E");
      glyphList.put("weokorean", "\u315D");
      glyphList.put("wgrave", "\u1E81");
      glyphList.put("whitebullet", "\u25E6");
      glyphList.put("whitecircle", "\u25CB");
      glyphList.put("whitecircleinverse", "\u25D9");
      glyphList.put("whitecornerbracketleft", "\u300E");
      glyphList.put("whitecornerbracketleftvertical", "\uFE43");
      glyphList.put("whitecornerbracketright", "\u300F");
      glyphList.put("whitecornerbracketrightvertical", "\uFE44");
      glyphList.put("whitediamond", "\u25C7");
      glyphList.put("whitediamondcontainingblacksmalldiamond", "\u25C8");
      glyphList.put("whitedownpointingsmalltriangle", "\u25BF");
      glyphList.put("whitedownpointingtriangle", "\u25BD");
      glyphList.put("whiteleftpointingsmalltriangle", "\u25C3");
      glyphList.put("whiteleftpointingtriangle", "\u25C1");
      glyphList.put("whitelenticularbracketleft", "\u3016");
      glyphList.put("whitelenticularbracketright", "\u3017");
      glyphList.put("whiterightpointingsmalltriangle", "\u25B9");
      glyphList.put("whiterightpointingtriangle", "\u25B7");
      glyphList.put("whitesmallsquare", "\u25AB");
      glyphList.put("whitesmilingface", "\u263A");
      glyphList.put("whitesquare", "\u25A1");
      glyphList.put("whitestar", "\u2606");
      glyphList.put("whitetelephone", "\u260F");
      glyphList.put("whitetortoiseshellbracketleft", "\u3018");
      glyphList.put("whitetortoiseshellbracketright", "\u3019");
      glyphList.put("whiteuppointingsmalltriangle", "\u25B5");
      glyphList.put("whiteuppointingtriangle", "\u25B3");
      glyphList.put("wihiragana", "\u3090");
      glyphList.put("wikatakana", "\u30F0");
      glyphList.put("wikorean", "\u315F");
      glyphList.put("wmonospace", "\uFF57");
      glyphList.put("wohiragana", "\u3092");
      glyphList.put("wokatakana", "\u30F2");
      glyphList.put("wokatakanahalfwidth", "\uFF66");
      glyphList.put("won", "\u20A9");
      glyphList.put("wonmonospace", "\uFFE6");
      glyphList.put("wowaenthai", "\u0E27");
      glyphList.put("wparen", "\u24B2");
      glyphList.put("wring", "\u1E98");
      glyphList.put("wsuperior", "\u02B7");
      glyphList.put("wturned", "\u028D");
      glyphList.put("wynn", "\u01BF");
      glyphList.put("x", "\u0078");
      glyphList.put("xabovecmb", "\u033D");
      glyphList.put("xbopomofo", "\u3112");
      glyphList.put("xcircle", "\u24E7");
      glyphList.put("xdieresis", "\u1E8D");
      glyphList.put("xdotaccent", "\u1E8B");
      glyphList.put("xeharmenian", "\u056D");
      glyphList.put("xi", "\u03BE");
      glyphList.put("xmonospace", "\uFF58");
      glyphList.put("xparen", "\u24B3");
      glyphList.put("xsuperior", "\u02E3");
      glyphList.put("y", "\u0079");
      glyphList.put("yaadosquare", "\u334E");
      glyphList.put("yabengali", "\u09AF");
      glyphList.put("yacute", "\u00FD");
      glyphList.put("yadeva", "\u092F");
      glyphList.put("yaekorean", "\u3152");
      glyphList.put("yagujarati", "\u0AAF");
      glyphList.put("yagurmukhi", "\u0A2F");
      glyphList.put("yahiragana", "\u3084");
      glyphList.put("yakatakana", "\u30E4");
      glyphList.put("yakatakanahalfwidth", "\uFF94");
      glyphList.put("yakorean", "\u3151");
      glyphList.put("yamakkanthai", "\u0E4E");
      glyphList.put("yasmallhiragana", "\u3083");
      glyphList.put("yasmallkatakana", "\u30E3");
      glyphList.put("yasmallkatakanahalfwidth", "\uFF6C");
      glyphList.put("yatcyrillic", "\u0463");
      glyphList.put("ycircle", "\u24E8");
      glyphList.put("ycircumflex", "\u0177");
      glyphList.put("ydieresis", "\u00FF");
      glyphList.put("ydotaccent", "\u1E8F");
      glyphList.put("ydotbelow", "\u1EF5");
      glyphList.put("yeharabic", "\u064A");
      glyphList.put("yehbarreearabic", "\u06D2");
      glyphList.put("yehbarreefinalarabic", "\uFBAF");
      glyphList.put("yehfinalarabic", "\uFEF2");
      glyphList.put("yehhamzaabovearabic", "\u0626");
      glyphList.put("yehhamzaabovefinalarabic", "\uFE8A");
      glyphList.put("yehhamzaaboveinitialarabic", "\uFE8B");
      glyphList.put("yehhamzaabovemedialarabic", "\uFE8C");
      glyphList.put("yehinitialarabic", "\uFEF3");
      glyphList.put("yehmedialarabic", "\uFEF4");
      glyphList.put("yehmeeminitialarabic", "\uFCDD");
      glyphList.put("yehmeemisolatedarabic", "\uFC58");
      glyphList.put("yehnoonfinalarabic", "\uFC94");
      glyphList.put("yehthreedotsbelowarabic", "\u06D1");
      glyphList.put("yekorean", "\u3156");
      glyphList.put("yen", "\u00A5");
      glyphList.put("yenmonospace", "\uFFE5");
      glyphList.put("yeokorean", "\u3155");
      glyphList.put("yeorinhieuhkorean", "\u3186");
      glyphList.put("yerahbenyomohebrew", "\u05AA");
      glyphList.put("yerahbenyomolefthebrew", "\u05AA");
      glyphList.put("yericyrillic", "\u044B");
      glyphList.put("yerudieresiscyrillic", "\u04F9");
      glyphList.put("yesieungkorean", "\u3181");
      glyphList.put("yesieungpansioskorean", "\u3183");
      glyphList.put("yesieungsioskorean", "\u3182");
      glyphList.put("yetivhebrew", "\u059A");
      glyphList.put("ygrave", "\u1EF3");
      glyphList.put("yhook", "\u01B4");
      glyphList.put("yhookabove", "\u1EF7");
      glyphList.put("yiarmenian", "\u0575");
      glyphList.put("yicyrillic", "\u0457");
      glyphList.put("yikorean", "\u3162");
      glyphList.put("yinyang", "\u262F");
      glyphList.put("yiwnarmenian", "\u0582");
      glyphList.put("ymonospace", "\uFF59");
      glyphList.put("yod", "\u05D9");
      glyphList.put("yoddagesh", "\uFB39");
      glyphList.put("yoddageshhebrew", "\uFB39");
      glyphList.put("yodhebrew", "\u05D9");
      glyphList.put("yodyodhebrew", "\u05F2");
      glyphList.put("yodyodpatahhebrew", "\uFB1F");
      glyphList.put("yohiragana", "\u3088");
      glyphList.put("yoikorean", "\u3189");
      glyphList.put("yokatakana", "\u30E8");
      glyphList.put("yokatakanahalfwidth", "\uFF96");
      glyphList.put("yokorean", "\u315B");
      glyphList.put("yosmallhiragana", "\u3087");
      glyphList.put("yosmallkatakana", "\u30E7");
      glyphList.put("yosmallkatakanahalfwidth", "\uFF6E");
      glyphList.put("yotgreek", "\u03F3");
      glyphList.put("yoyaekorean", "\u3188");
      glyphList.put("yoyakorean", "\u3187");
      glyphList.put("yoyakthai", "\u0E22");
      glyphList.put("yoyingthai", "\u0E0D");
      glyphList.put("yparen", "\u24B4");
      glyphList.put("ypogegrammeni", "\u037A");
      glyphList.put("ypogegrammenigreekcmb", "\u0345");
      glyphList.put("yr", "\u01A6");
      glyphList.put("yring", "\u1E99");
      glyphList.put("ysuperior", "\u02B8");
      glyphList.put("ytilde", "\u1EF9");
      glyphList.put("yturned", "\u028E");
      glyphList.put("yuhiragana", "\u3086");
      glyphList.put("yuikorean", "\u318C");
      glyphList.put("yukatakana", "\u30E6");
      glyphList.put("yukatakanahalfwidth", "\uFF95");
      glyphList.put("yukorean", "\u3160");
      glyphList.put("yusbigcyrillic", "\u046B");
      glyphList.put("yusbigiotifiedcyrillic", "\u046D");
      glyphList.put("yuslittlecyrillic", "\u0467");
      glyphList.put("yuslittleiotifiedcyrillic", "\u0469");
      glyphList.put("yusmallhiragana", "\u3085");
      glyphList.put("yusmallkatakana", "\u30E5");
      glyphList.put("yusmallkatakanahalfwidth", "\uFF6D");
      glyphList.put("yuyekorean", "\u318B");
      glyphList.put("yuyeokorean", "\u318A");
      glyphList.put("yyabengali", "\u09DF");
      glyphList.put("yyadeva", "\u095F");
      glyphList.put("z", "\u007A");
      glyphList.put("zaarmenian", "\u0566");
      glyphList.put("zacute", "\u017A");
      glyphList.put("zadeva", "\u095B");
      glyphList.put("zagurmukhi", "\u0A5B");
      glyphList.put("zaharabic", "\u0638");
      glyphList.put("zahfinalarabic", "\uFEC6");
      glyphList.put("zahinitialarabic", "\uFEC7");
      glyphList.put("zahiragana", "\u3056");
      glyphList.put("zahmedialarabic", "\uFEC8");
      glyphList.put("zainarabic", "\u0632");
      glyphList.put("zainfinalarabic", "\uFEB0");
      glyphList.put("zakatakana", "\u30B6");
      glyphList.put("zaqefgadolhebrew", "\u0595");
      glyphList.put("zaqefqatanhebrew", "\u0594");
      glyphList.put("zarqahebrew", "\u0598");
      glyphList.put("zayin", "\u05D6");
      glyphList.put("zayindagesh", "\uFB36");
      glyphList.put("zayindageshhebrew", "\uFB36");
      glyphList.put("zayinhebrew", "\u05D6");
      glyphList.put("zbopomofo", "\u3117");
      glyphList.put("zcaron", "\u017E");
      glyphList.put("zcircle", "\u24E9");
      glyphList.put("zcircumflex", "\u1E91");
      glyphList.put("zcurl", "\u0291");
      glyphList.put("zdot", "\u017C");
      glyphList.put("zdotaccent", "\u017C");
      glyphList.put("zdotbelow", "\u1E93");
      glyphList.put("zecyrillic", "\u0437");
      glyphList.put("zedescendercyrillic", "\u0499");
      glyphList.put("zedieresiscyrillic", "\u04DF");
      glyphList.put("zehiragana", "\u305C");
      glyphList.put("zekatakana", "\u30BC");
      glyphList.put("zero", "\u0030");
      glyphList.put("zeroarabic", "\u0660");
      glyphList.put("zerobengali", "\u09E6");
      glyphList.put("zerodeva", "\u0966");
      glyphList.put("zerogujarati", "\u0AE6");
      glyphList.put("zerogurmukhi", "\u0A66");
      glyphList.put("zerohackarabic", "\u0660");
      glyphList.put("zeroinferior", "\u2080");
      glyphList.put("zeromonospace", "\uFF10");
      glyphList.put("zerooldstyle", "\uF730");
      glyphList.put("zeropersian", "\u06F0");
      glyphList.put("zerosuperior", "\u2070");
      glyphList.put("zerothai", "\u0E50");
      glyphList.put("zerowidthjoiner", "\uFEFF");
      glyphList.put("zerowidthnonjoiner", "\u200C");
      glyphList.put("zerowidthspace", "\u200B");
      glyphList.put("zeta", "\u03B6");
      glyphList.put("zhbopomofo", "\u3113");
      glyphList.put("zhearmenian", "\u056A");
      glyphList.put("zhebrevecyrillic", "\u04C2");
      glyphList.put("zhecyrillic", "\u0436");
      glyphList.put("zhedescendercyrillic", "\u0497");
      glyphList.put("zhedieresiscyrillic", "\u04DD");
      glyphList.put("zihiragana", "\u3058");
      glyphList.put("zikatakana", "\u30B8");
      glyphList.put("zinorhebrew", "\u05AE");
      glyphList.put("zlinebelow", "\u1E95");
      glyphList.put("zmonospace", "\uFF5A");
      glyphList.put("zohiragana", "\u305E");
      glyphList.put("zokatakana", "\u30BE");
      glyphList.put("zparen", "\u24B5");
      glyphList.put("zretroflexhook", "\u0290");
      glyphList.put("zstroke", "\u01B6");
      glyphList.put("zuhiragana", "\u305A");
      glyphList.put("zukatakana", "\u30BA");

      return glyphList;
    }
}
