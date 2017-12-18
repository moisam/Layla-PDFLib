package net.laylacp.pdflib.graphics;

import java.util.HashMap;

public class PDFFontEncodingTables {

    /*
 * based on http://www.unicode.org/Public/MAPPINGS/VENDORS/APPLE/ROMAN.TXT
 */
    public static int[] MacRomanEncoding = {
            0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
            0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
            0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
            0x0020, // SPACE
            0x0021, // EXCLAMATION MARK
            0x0022, // QUOTATION MARK
            0x0023, // NUMBER SIGN
            0x0024, // DOLLAR SIGN
            0x0025, // PERCENT SIGN
            0x0026, // AMPERSAND
            0x0027, // APOSTROPHE
            0x0028, // LEFT PARENTHESIS
            0x0029, // RIGHT PARENTHESIS
            0x002A, // ASTERISK
            0x002B, // PLUS SIGN
            0x002C, // COMMA
            0x002D, // HYPHEN-MINUS
            0x002E, // FULL STOP
            0x002F, // SOLIDUS
            0x0030, // DIGIT ZERO
            0x0031, // DIGIT ONE
            0x0032, // DIGIT TWO
            0x0033, // DIGIT THREE
            0x0034, // DIGIT FOUR
            0x0035, // DIGIT FIVE
            0x0036, // DIGIT SIX
            0x0037, // DIGIT SEVEN
            0x0038, // DIGIT EIGHT
            0x0039, // DIGIT NINE
            0x003A, // COLON
            0x003B, // SEMICOLON
            0x003C, // LESS-THAN SIGN
            0x003D, // EQUALS SIGN
            0x003E, // GREATER-THAN SIGN
            0x003F, // QUESTION MARK
            0x0040, // COMMERCIAL AT
            0x0041, // LATIN CAPITAL LETTER A
            0x0042, // LATIN CAPITAL LETTER B
            0x0043, // LATIN CAPITAL LETTER C
            0x0044, // LATIN CAPITAL LETTER D
            0x0045, // LATIN CAPITAL LETTER E
            0x0046, // LATIN CAPITAL LETTER F
            0x0047, // LATIN CAPITAL LETTER G
            0x0048, // LATIN CAPITAL LETTER H
            0x0049, // LATIN CAPITAL LETTER I
            0x004A, // LATIN CAPITAL LETTER J
            0x004B, // LATIN CAPITAL LETTER K
            0x004C, // LATIN CAPITAL LETTER L
            0x004D, // LATIN CAPITAL LETTER M
            0x004E, // LATIN CAPITAL LETTER N
            0x004F, // LATIN CAPITAL LETTER O
            0x0050, // LATIN CAPITAL LETTER P
            0x0051, // LATIN CAPITAL LETTER Q
            0x0052, // LATIN CAPITAL LETTER R
            0x0053, // LATIN CAPITAL LETTER S
            0x0054, // LATIN CAPITAL LETTER T
            0x0055, // LATIN CAPITAL LETTER U
            0x0056, // LATIN CAPITAL LETTER V
            0x0057, // LATIN CAPITAL LETTER W
            0x0058, // LATIN CAPITAL LETTER X
            0x0059, // LATIN CAPITAL LETTER Y
            0x005A, // LATIN CAPITAL LETTER Z
            0x005B, // LEFT SQUARE BRACKET
            0x005C, // REVERSE SOLIDUS
            0x005D, // RIGHT SQUARE BRACKET
            0x005E, // CIRCUMFLEX ACCENT
            0x005F, // LOW LINE
            0x0060, // GRAVE ACCENT
            0x0061, // LATIN SMALL LETTER A
            0x0062, // LATIN SMALL LETTER B
            0x0063, // LATIN SMALL LETTER C
            0x0064, // LATIN SMALL LETTER D
            0x0065, // LATIN SMALL LETTER E
            0x0066, // LATIN SMALL LETTER F
            0x0067, // LATIN SMALL LETTER G
            0x0068, // LATIN SMALL LETTER H
            0x0069, // LATIN SMALL LETTER I
            0x006A, // LATIN SMALL LETTER J
            0x006B, // LATIN SMALL LETTER K
            0x006C, // LATIN SMALL LETTER L
            0x006D, // LATIN SMALL LETTER M
            0x006E, // LATIN SMALL LETTER N
            0x006F, // LATIN SMALL LETTER O
            0x0070, // LATIN SMALL LETTER P
            0x0071, // LATIN SMALL LETTER Q
            0x0072, // LATIN SMALL LETTER R
            0x0073, // LATIN SMALL LETTER S
            0x0074, // LATIN SMALL LETTER T
            0x0075, // LATIN SMALL LETTER U
            0x0076, // LATIN SMALL LETTER V
            0x0077, // LATIN SMALL LETTER W
            0x0078, // LATIN SMALL LETTER X
            0x0079, // LATIN SMALL LETTER Y
            0x007A, // LATIN SMALL LETTER Z
            0x007B, // LEFT CURLY BRACKET
            0x007C, // VERTICAL LINE
            0x007D, // RIGHT CURLY BRACKET
            0x007E, // TILDE
            0x00, // 0x7F = UNDEFINED
            0x00C4, // LATIN CAPITAL LETTER A WITH DIAERESIS
            0x00C5, // LATIN CAPITAL LETTER A WITH RING ABOVE
            0x00C7, // LATIN CAPITAL LETTER C WITH CEDILLA
            0x00C9, // LATIN CAPITAL LETTER E WITH ACUTE
            0x00D1, // LATIN CAPITAL LETTER N WITH TILDE
            0x00D6, // LATIN CAPITAL LETTER O WITH DIAERESIS
            0x00DC, // LATIN CAPITAL LETTER U WITH DIAERESIS
            0x00E1, // LATIN SMALL LETTER A WITH ACUTE
            0x00E0, // LATIN SMALL LETTER A WITH GRAVE
            0x00E2, // LATIN SMALL LETTER A WITH CIRCUMFLEX
            0x00E4, // LATIN SMALL LETTER A WITH DIAERESIS
            0x00E3, // LATIN SMALL LETTER A WITH TILDE
            0x00E5, // LATIN SMALL LETTER A WITH RING ABOVE
            0x00E7, // LATIN SMALL LETTER C WITH CEDILLA
            0x00E9, // LATIN SMALL LETTER E WITH ACUTE
            0x00E8, // LATIN SMALL LETTER E WITH GRAVE
            0x00EA, // LATIN SMALL LETTER E WITH CIRCUMFLEX
            0x00EB, // LATIN SMALL LETTER E WITH DIAERESIS
            0x00ED, // LATIN SMALL LETTER I WITH ACUTE
            0x00EC, // LATIN SMALL LETTER I WITH GRAVE
            0x00EE, // LATIN SMALL LETTER I WITH CIRCUMFLEX
            0x00EF, // LATIN SMALL LETTER I WITH DIAERESIS
            0x00F1, // LATIN SMALL LETTER N WITH TILDE
            0x00F3, // LATIN SMALL LETTER O WITH ACUTE
            0x00F2, // LATIN SMALL LETTER O WITH GRAVE
            0x00F4, // LATIN SMALL LETTER O WITH CIRCUMFLEX
            0x00F6, // LATIN SMALL LETTER O WITH DIAERESIS
            0x00F5, // LATIN SMALL LETTER O WITH TILDE
            0x00FA, // LATIN SMALL LETTER U WITH ACUTE
            0x00F9, // LATIN SMALL LETTER U WITH GRAVE
            0x00FB, // LATIN SMALL LETTER U WITH CIRCUMFLEX
            0x00FC, // LATIN SMALL LETTER U WITH DIAERESIS
            0x2020, // DAGGER
            0x00B0, // DEGREE SIGN
            0x00A2, // CENT SIGN
            0x00A3, // POUND SIGN
            0x00A7, // SECTION SIGN
            0x2022, // BULLET
            0x00B6, // PILCROW SIGN
            0x00DF, // LATIN SMALL LETTER SHARP S
            0x00AE, // REGISTERED SIGN
            0x00A9, // COPYRIGHT SIGN
            0x2122, // TRADE MARK SIGN
            0x00B4, // ACUTE ACCENT
            0x00A8, // DIAERESIS
            0x2260, // NOT EQUAL TO
            0x00C6, // LATIN CAPITAL LETTER AE
            0x00D8, // LATIN CAPITAL LETTER O WITH STROKE
            0x221E, // INFINITY
            0x00B1, // PLUS-MINUS SIGN
            0x2264, // LESS-THAN OR EQUAL TO
            0x2265, // GREATER-THAN OR EQUAL TO
            0x00A5, // YEN SIGN
            0x00B5, // MICRO SIGN
            0x2202, // PARTIAL DIFFERENTIAL
            0x2211, // N-ARY SUMMATION
            0x220F, // N-ARY PRODUCT
            0x03C0, // GREEK SMALL LETTER PI
            0x222B, // INTEGRAL
            0x00AA, // FEMININE ORDINAL INDICATOR
            0x00BA, // MASCULINE ORDINAL INDICATOR
            0x03A9, // GREEK CAPITAL LETTER OMEGA
            0x00E6, // LATIN SMALL LETTER AE
            0x00F8, // LATIN SMALL LETTER O WITH STROKE
            0x00BF, // INVERTED QUESTION MARK
            0x00A1, // INVERTED EXCLAMATION MARK
            0x00AC, // NOT SIGN
            0x221A, // SQUARE ROOT
            0x0192, // LATIN SMALL LETTER F WITH HOOK
            0x2248, // ALMOST EQUAL TO
            0x2206, // INCREMENT
            0x00AB, // LEFT-POINTING DOUBLE ANGLE QUOTATION MARK
            0x00BB, // RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK
            0x2026, // HORIZONTAL ELLIPSIS
            0x00A0, // NO-BREAK SPACE
            0x00C0, // LATIN CAPITAL LETTER A WITH GRAVE
            0x00C3, // LATIN CAPITAL LETTER A WITH TILDE
            0x00D5, // LATIN CAPITAL LETTER O WITH TILDE
            0x0152, // LATIN CAPITAL LIGATURE OE
            0x0153, // LATIN SMALL LIGATURE OE
            0x2013, // EN DASH
            0x2014, // EM DASH
            0x201C, // LEFT DOUBLE QUOTATION MARK
            0x201D, // RIGHT DOUBLE QUOTATION MARK
            0x2018, // LEFT SINGLE QUOTATION MARK
            0x2019, // RIGHT SINGLE QUOTATION MARK
            0x00F7, // DIVISION SIGN
            0x25CA, // LOZENGE
            0x00FF, // LATIN SMALL LETTER Y WITH DIAERESIS
            0x0178, // LATIN CAPITAL LETTER Y WITH DIAERESIS
            0x2044, // FRACTION SLASH
            0x20AC, // EURO SIGN
            0x2039, // SINGLE LEFT-POINTING ANGLE QUOTATION MARK
            0x203A, // SINGLE RIGHT-POINTING ANGLE QUOTATION MARK
            0xFB01, // LATIN SMALL LIGATURE FI
            0xFB02, // LATIN SMALL LIGATURE FL
            0x2021, // DOUBLE DAGGER
            0x00B7, // MIDDLE DOT
            0x201A, // SINGLE LOW-9 QUOTATION MARK
            0x201E, // DOUBLE LOW-9 QUOTATION MARK
            0x2030, // PER MILLE SIGN
            0x00C2, // LATIN CAPITAL LETTER A WITH CIRCUMFLEX
            0x00CA, // LATIN CAPITAL LETTER E WITH CIRCUMFLEX
            0x00C1, // LATIN CAPITAL LETTER A WITH ACUTE
            0x00CB, // LATIN CAPITAL LETTER E WITH DIAERESIS
            0x00C8, // LATIN CAPITAL LETTER E WITH GRAVE
            0x00CD, // LATIN CAPITAL LETTER I WITH ACUTE
            0x00CE, // LATIN CAPITAL LETTER I WITH CIRCUMFLEX
            0x00CF, // LATIN CAPITAL LETTER I WITH DIAERESIS
            0x00CC, // LATIN CAPITAL LETTER I WITH GRAVE
            0x00D3, // LATIN CAPITAL LETTER O WITH ACUTE
            0x00D4, // LATIN CAPITAL LETTER O WITH CIRCUMFLEX
            0xF8FF, // Apple logo
            0x00D2, // LATIN CAPITAL LETTER O WITH GRAVE
            0x00DA, // LATIN CAPITAL LETTER U WITH ACUTE
            0x00DB, // LATIN CAPITAL LETTER U WITH CIRCUMFLEX
            0x00D9, // LATIN CAPITAL LETTER U WITH GRAVE
            0x0131, // LATIN SMALL LETTER DOTLESS I
            0x02C6, // MODIFIER LETTER CIRCUMFLEX ACCENT
            0x02DC, // SMALL TILDE
            0x00AF, // MACRON
            0x02D8, // BREVE
            0x02D9, // DOT ABOVE
            0x02DA, // RING ABOVE
            0x00B8, // CEDILLA
            0x02DD, // DOUBLE ACUTE ACCENT
            0x02DB, // OGONEK
            0x02C7, // CARON
    };

    /*
     * CP1252, based on https://www.unicode.org/Public/MAPPINGS/VENDORS/MICSFT/WINDOWS/CP1252.TXT
     */
    public static final int[] WinAnsiEncoding = {
            0x0000, //NULL
            0x0001, //START OF HEADING
            0x0002, //START OF TEXT
            0x0003, //END OF TEXT
            0x0004, //END OF TRANSMISSION
            0x0005, //ENQUIRY
            0x0006, //ACKNOWLEDGE
            0x0007, //BELL
            0x0008, //BACKSPACE
            0x0009, //HORIZONTAL TABULATION
            0x000A, //LINE FEED
            0x000B, //VERTICAL TABULATION
            0x000C, //FORM FEED
            0x000D, //CARRIAGE RETURN
            0x000E, //SHIFT OUT
            0x000F, //SHIFT IN
            0x0010, //DATA LINK ESCAPE
            0x0011, //DEVICE CONTROL ONE
            0x0012, //DEVICE CONTROL TWO
            0x0013, //DEVICE CONTROL THREE
            0x0014, //DEVICE CONTROL FOUR
            0x0015, //NEGATIVE ACKNOWLEDGE
            0x0016, //SYNCHRONOUS IDLE
            0x0017, //END OF TRANSMISSION BLOCK
            0x0018, //CANCEL
            0x0019, //END OF MEDIUM
            0x001A, //SUBSTITUTE
            0x001B, //ESCAPE
            0x001C, //FILE SEPARATOR
            0x001D, //GROUP SEPARATOR
            0x001E, //RECORD SEPARATOR
            0x001F, //UNIT SEPARATOR
            0x0020, //SPACE
            0x0021, //EXCLAMATION MARK
            0x0022, //QUOTATION MARK
            0x0023, //NUMBER SIGN
            0x0024, //DOLLAR SIGN
            0x0025, //PERCENT SIGN
            0x0026, //AMPERSAND
            0x0027, //APOSTROPHE
            0x0028, //LEFT PARENTHESIS
            0x0029, //RIGHT PARENTHESIS
            0x002A, //ASTERISK
            0x002B, //PLUS SIGN
            0x002C, //COMMA
            0x002D, //HYPHEN-MINUS
            0x002E, //FULL STOP
            0x002F, //SOLIDUS
            0x0030, //DIGIT ZERO
            0x0031, //DIGIT ONE
            0x0032, //DIGIT TWO
            0x0033, //DIGIT THREE
            0x0034, //DIGIT FOUR
            0x0035, //DIGIT FIVE
            0x0036, //DIGIT SIX
            0x0037, //DIGIT SEVEN
            0x0038, //DIGIT EIGHT
            0x0039, //DIGIT NINE
            0x003A, //COLON
            0x003B, //SEMICOLON
            0x003C, //LESS-THAN SIGN
            0x003D, //EQUALS SIGN
            0x003E, //GREATER-THAN SIGN
            0x003F, //QUESTION MARK
            0x0040, //COMMERCIAL AT
            0x0041, //LATIN CAPITAL LETTER A
            0x0042, //LATIN CAPITAL LETTER B
            0x0043, //LATIN CAPITAL LETTER C
            0x0044, //LATIN CAPITAL LETTER D
            0x0045, //LATIN CAPITAL LETTER E
            0x0046, //LATIN CAPITAL LETTER F
            0x0047, //LATIN CAPITAL LETTER G
            0x0048, //LATIN CAPITAL LETTER H
            0x0049, //LATIN CAPITAL LETTER I
            0x004A, //LATIN CAPITAL LETTER J
            0x004B, //LATIN CAPITAL LETTER K
            0x004C, //LATIN CAPITAL LETTER L
            0x004D, //LATIN CAPITAL LETTER M
            0x004E, //LATIN CAPITAL LETTER N
            0x004F, //LATIN CAPITAL LETTER O
            0x0050, //LATIN CAPITAL LETTER P
            0x0051, //LATIN CAPITAL LETTER Q
            0x0052, //LATIN CAPITAL LETTER R
            0x0053, //LATIN CAPITAL LETTER S
            0x0054, //LATIN CAPITAL LETTER T
            0x0055, //LATIN CAPITAL LETTER U
            0x0056, //LATIN CAPITAL LETTER V
            0x0057, //LATIN CAPITAL LETTER W
            0x0058, //LATIN CAPITAL LETTER X
            0x0059, //LATIN CAPITAL LETTER Y
            0x005A, //LATIN CAPITAL LETTER Z
            0x005B, //LEFT SQUARE BRACKET
            0x005C, //REVERSE SOLIDUS
            0x005D, //RIGHT SQUARE BRACKET
            0x005E, //CIRCUMFLEX ACCENT
            0x005F, //LOW LINE
            0x0060, //GRAVE ACCENT
            0x0061, //LATIN SMALL LETTER A
            0x0062, //LATIN SMALL LETTER B
            0x0063, //LATIN SMALL LETTER C
            0x0064, //LATIN SMALL LETTER D
            0x0065, //LATIN SMALL LETTER E
            0x0066, //LATIN SMALL LETTER F
            0x0067, //LATIN SMALL LETTER G
            0x0068, //LATIN SMALL LETTER H
            0x0069, //LATIN SMALL LETTER I
            0x006A, //LATIN SMALL LETTER J
            0x006B, //LATIN SMALL LETTER K
            0x006C, //LATIN SMALL LETTER L
            0x006D, //LATIN SMALL LETTER M
            0x006E, //LATIN SMALL LETTER N
            0x006F, //LATIN SMALL LETTER O
            0x0070, //LATIN SMALL LETTER P
            0x0071, //LATIN SMALL LETTER Q
            0x0072, //LATIN SMALL LETTER R
            0x0073, //LATIN SMALL LETTER S
            0x0074, //LATIN SMALL LETTER T
            0x0075, //LATIN SMALL LETTER U
            0x0076, //LATIN SMALL LETTER V
            0x0077, //LATIN SMALL LETTER W
            0x0078, //LATIN SMALL LETTER X
            0x0079, //LATIN SMALL LETTER Y
            0x007A, //LATIN SMALL LETTER Z
            0x007B, //LEFT CURLY BRACKET
            0x007C, //VERTICAL LINE
            0x007D, //RIGHT CURLY BRACKET
            0x007E, //TILDE
            0x007F, //DELETE
            0x20AC, //EURO SIGN
            0x00, // 0x81 = UNDEFINED
            0x201A, //SINGLE LOW-9 QUOTATION MARK
            0x0192, //LATIN SMALL LETTER F WITH HOOK
            0x201E, //DOUBLE LOW-9 QUOTATION MARK
            0x2026, //HORIZONTAL ELLIPSIS
            0x2020, //DAGGER
            0x2021, //DOUBLE DAGGER
            0x02C6, //MODIFIER LETTER CIRCUMFLEX ACCENT
            0x2030, //PER MILLE SIGN
            0x0160, //LATIN CAPITAL LETTER S WITH CARON
            0x2039, //SINGLE LEFT-POINTING ANGLE QUOTATION MARK
            0x0152, //LATIN CAPITAL LIGATURE OE
            0x00, // 0x8D = UNDEFINED
            0x017D, //LATIN CAPITAL LETTER Z WITH CARON
            0x00, // 0x8F = UNDEFINED
            0x00, // 0x90 = UNDEFINED
            0x2018, //LEFT SINGLE QUOTATION MARK
            0x2019, //RIGHT SINGLE QUOTATION MARK
            0x201C, //LEFT DOUBLE QUOTATION MARK
            0x201D, //RIGHT DOUBLE QUOTATION MARK
            0x2022, //BULLET
            0x2013, //EN DASH
            0x2014, //EM DASH
            0x02DC, //SMALL TILDE
            0x2122, //TRADE MARK SIGN
            0x0161, //LATIN SMALL LETTER S WITH CARON
            0x203A, //SINGLE RIGHT-POINTING ANGLE QUOTATION MARK
            0x0153, //LATIN SMALL LIGATURE OE
            0x00, // 0x9D = UNDEFINED
            0x017E, //LATIN SMALL LETTER Z WITH CARON
            0x0178, //LATIN CAPITAL LETTER Y WITH DIAERESIS
            0x00A0, //NO-BREAK SPACE
            0x00A1, //INVERTED EXCLAMATION MARK
            0x00A2, //CENT SIGN
            0x00A3, //POUND SIGN
            0x00A4, //CURRENCY SIGN
            0x00A5, //YEN SIGN
            0x00A6, //BROKEN BAR
            0x00A7, //SECTION SIGN
            0x00A8, //DIAERESIS
            0x00A9, //COPYRIGHT SIGN
            0x00AA, //FEMININE ORDINAL INDICATOR
            0x00AB, //LEFT-POINTING DOUBLE ANGLE QUOTATION MARK
            0x00AC, //NOT SIGN
            0x00AD, //SOFT HYPHEN
            0x00AE, //REGISTERED SIGN
            0x00AF, //MACRON
            0x00B0, //DEGREE SIGN
            0x00B1, //PLUS-MINUS SIGN
            0x00B2, //SUPERSCRIPT TWO
            0x00B3, //SUPERSCRIPT THREE
            0x00B4, //ACUTE ACCENT
            0x00B5, //MICRO SIGN
            0x00B6, //PILCROW SIGN
            0x00B7, //MIDDLE DOT
            0x00B8, //CEDILLA
            0x00B9, //SUPERSCRIPT ONE
            0x00BA, //MASCULINE ORDINAL INDICATOR
            0x00BB, //RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK
            0x00BC, //VULGAR FRACTION ONE QUARTER
            0x00BD, //VULGAR FRACTION ONE HALF
            0x00BE, //VULGAR FRACTION THREE QUARTERS
            0x00BF, //INVERTED QUESTION MARK
            0x00C0, //LATIN CAPITAL LETTER A WITH GRAVE
            0x00C1, //LATIN CAPITAL LETTER A WITH ACUTE
            0x00C2, //LATIN CAPITAL LETTER A WITH CIRCUMFLEX
            0x00C3, //LATIN CAPITAL LETTER A WITH TILDE
            0x00C4, //LATIN CAPITAL LETTER A WITH DIAERESIS
            0x00C5, //LATIN CAPITAL LETTER A WITH RING ABOVE
            0x00C6, //LATIN CAPITAL LETTER AE
            0x00C7, //LATIN CAPITAL LETTER C WITH CEDILLA
            0x00C8, //LATIN CAPITAL LETTER E WITH GRAVE
            0x00C9, //LATIN CAPITAL LETTER E WITH ACUTE
            0x00CA, //LATIN CAPITAL LETTER E WITH CIRCUMFLEX
            0x00CB, //LATIN CAPITAL LETTER E WITH DIAERESIS
            0x00CC, //LATIN CAPITAL LETTER I WITH GRAVE
            0x00CD, //LATIN CAPITAL LETTER I WITH ACUTE
            0x00CE, //LATIN CAPITAL LETTER I WITH CIRCUMFLEX
            0x00CF, //LATIN CAPITAL LETTER I WITH DIAERESIS
            0x00D0, //LATIN CAPITAL LETTER ETH
            0x00D1, //LATIN CAPITAL LETTER N WITH TILDE
            0x00D2, //LATIN CAPITAL LETTER O WITH GRAVE
            0x00D3, //LATIN CAPITAL LETTER O WITH ACUTE
            0x00D4, //LATIN CAPITAL LETTER O WITH CIRCUMFLEX
            0x00D5, //LATIN CAPITAL LETTER O WITH TILDE
            0x00D6, //LATIN CAPITAL LETTER O WITH DIAERESIS
            0x00D7, //MULTIPLICATION SIGN
            0x00D8, //LATIN CAPITAL LETTER O WITH STROKE
            0x00D9, //LATIN CAPITAL LETTER U WITH GRAVE
            0x00DA, //LATIN CAPITAL LETTER U WITH ACUTE
            0x00DB, //LATIN CAPITAL LETTER U WITH CIRCUMFLEX
            0x00DC, //LATIN CAPITAL LETTER U WITH DIAERESIS
            0x00DD, //LATIN CAPITAL LETTER Y WITH ACUTE
            0x00DE, //LATIN CAPITAL LETTER THORN
            0x00DF, //LATIN SMALL LETTER SHARP S
            0x00E0, //LATIN SMALL LETTER A WITH GRAVE
            0x00E1, //LATIN SMALL LETTER A WITH ACUTE
            0x00E2, //LATIN SMALL LETTER A WITH CIRCUMFLEX
            0x00E3, //LATIN SMALL LETTER A WITH TILDE
            0x00E4, //LATIN SMALL LETTER A WITH DIAERESIS
            0x00E5, //LATIN SMALL LETTER A WITH RING ABOVE
            0x00E6, //LATIN SMALL LETTER AE
            0x00E7, //LATIN SMALL LETTER C WITH CEDILLA
            0x00E8, //LATIN SMALL LETTER E WITH GRAVE
            0x00E9, //LATIN SMALL LETTER E WITH ACUTE
            0x00EA, //LATIN SMALL LETTER E WITH CIRCUMFLEX
            0x00EB, //LATIN SMALL LETTER E WITH DIAERESIS
            0x00EC, //LATIN SMALL LETTER I WITH GRAVE
            0x00ED, //LATIN SMALL LETTER I WITH ACUTE
            0x00EE, //LATIN SMALL LETTER I WITH CIRCUMFLEX
            0x00EF, //LATIN SMALL LETTER I WITH DIAERESIS
            0x00F0, //LATIN SMALL LETTER ETH
            0x00F1, //LATIN SMALL LETTER N WITH TILDE
            0x00F2, //LATIN SMALL LETTER O WITH GRAVE
            0x00F3, //LATIN SMALL LETTER O WITH ACUTE
            0x00F4, //LATIN SMALL LETTER O WITH CIRCUMFLEX
            0x00F5, //LATIN SMALL LETTER O WITH TILDE
            0x00F6, //LATIN SMALL LETTER O WITH DIAERESIS
            0x00F7, //DIVISION SIGN
            0x00F8, //LATIN SMALL LETTER O WITH STROKE
            0x00F9, //LATIN SMALL LETTER U WITH GRAVE
            0x00FA, //LATIN SMALL LETTER U WITH ACUTE
            0x00FB, //LATIN SMALL LETTER U WITH CIRCUMFLEX
            0x00FC, //LATIN SMALL LETTER U WITH DIAERESIS
            0x00FD, //LATIN SMALL LETTER Y WITH ACUTE
            0x00FE, //LATIN SMALL LETTER THORN
            0x00FF, //LATIN SMALL LETTER Y WITH DIAERESIS
    };

    /*
     * based on https://www.unicode.org/Public/MAPPINGS/VENDORS/ADOBE/stdenc.txt.
     */
    public static final int[] StandardEncoding = {
            0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
            0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
            0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
            0x0020, // SPACE	, // space
//00A0	, // NO-BREAK SPACE	, // space
            0x0021, // EXCLAMATION MARK	, // exclam
            0x0022, // QUOTATION MARK	, // quotedbl
            0x0023, // NUMBER SIGN	, // numbersign
            0x0024, // DOLLAR SIGN	, // dollar
            0x0025, // PERCENT SIGN	, // percent
            0x0026, // AMPERSAND	, // ampersand
            0x2019, // RIGHT SINGLE QUOTATION MARK	, // quoteright
            0x0028, // LEFT PARENTHESIS	, // parenleft
            0x0029, // RIGHT PARENTHESIS	, // parenright
            0x002A, // ASTERISK	, // asterisk
            0x002B, // PLUS SIGN	, // plus
            0x002C, // COMMA	, // comma
            0x002D, // HYPHEN-MINUS	, // hyphen
//00AD		, // SOFT HYPHEN	, // hyphen
            0x002E, // FULL STOP	, // period
            0x002F, // SOLIDUS	, // slash
            0x0030, // DIGIT ZERO	, // zero
            0x0031, // DIGIT ONE	, // one
            0x0032, // DIGIT TWO	, // two
            0x0033, // DIGIT THREE	, // three
            0x0034, // DIGIT FOUR	, // four
            0x0035, // DIGIT FIVE	, // five
            0x0036, // DIGIT SIX	, // six
            0x0037, // DIGIT SEVEN	, // seven
            0x0038, // DIGIT EIGHT	, // eight
            0x0039, // DIGIT NINE	, // nine
            0x003A, // COLON	, // colon
            0x003B, // SEMICOLON	, // semicolon
            0x003C, // LESS-THAN SIGN	, // less
            0x003D, // EQUALS SIGN	, // equal
            0x003E, // GREATER-THAN SIGN	, // greater
            0x003F, // QUESTION MARK	, // question
            0x0040, // COMMERCIAL AT	, // at
            0x0041, // LATIN CAPITAL LETTER A	, // A
            0x0042, // LATIN CAPITAL LETTER B	, // B
            0x0043, // LATIN CAPITAL LETTER C	, // C
            0x0044, // LATIN CAPITAL LETTER D	, // D
            0x0045, // LATIN CAPITAL LETTER E	, // E
            0x0046, // LATIN CAPITAL LETTER F	, // F
            0x0047, // LATIN CAPITAL LETTER G	, // G
            0x0048, // LATIN CAPITAL LETTER H	, // H
            0x0049, // LATIN CAPITAL LETTER I	, // I
            0x004A, // LATIN CAPITAL LETTER J	, // J
            0x004B, // LATIN CAPITAL LETTER K	, // K
            0x004C, // LATIN CAPITAL LETTER L	, // L
            0x004D, // LATIN CAPITAL LETTER M	, // M
            0x004E, // LATIN CAPITAL LETTER N	, // N
            0x004F, // LATIN CAPITAL LETTER O	, // O
            0x0050, // LATIN CAPITAL LETTER P	, // P
            0x0051, // LATIN CAPITAL LETTER Q	, // Q
            0x0052, // LATIN CAPITAL LETTER R	, // R
            0x0053, // LATIN CAPITAL LETTER S	, // S
            0x0054, // LATIN CAPITAL LETTER T	, // T
            0x0055, // LATIN CAPITAL LETTER U	, // U
            0x0056, // LATIN CAPITAL LETTER V	, // V
            0x0057, // LATIN CAPITAL LETTER W	, // W
            0x0058, // LATIN CAPITAL LETTER X	, // X
            0x0059, // LATIN CAPITAL LETTER Y	, // Y
            0x005A, // LATIN CAPITAL LETTER Z	, // Z
            0x005B, // LEFT SQUARE BRACKET	, // bracketleft
            0x005C, // REVERSE SOLIDUS	, // backslash
            0x005D, // RIGHT SQUARE BRACKET	, // bracketright
            0x005E, // CIRCUMFLEX ACCENT	, // asciicircum
            0x005F, // LOW LINE	, // underscore
            0x2018, // LEFT SINGLE QUOTATION MARK	, // quoteleft
            0x0061, // LATIN SMALL LETTER A	, // a
            0x0062, // LATIN SMALL LETTER B	, // b
            0x0063, // LATIN SMALL LETTER C	, // c
            0x0064, // LATIN SMALL LETTER D	, // d
            0x0065, // LATIN SMALL LETTER E	, // e
            0x0066, // LATIN SMALL LETTER F	, // f
            0x0067, // LATIN SMALL LETTER G	, // g
            0x0068, // LATIN SMALL LETTER H	, // h
            0x0069, // LATIN SMALL LETTER I	, // i
            0x006A, // LATIN SMALL LETTER J	, // j
            0x006B, // LATIN SMALL LETTER K	, // k
            0x006C, // LATIN SMALL LETTER L	, // l
            0x006D, // LATIN SMALL LETTER M	, // m
            0x006E, // LATIN SMALL LETTER N	, // n
            0x006F, // LATIN SMALL LETTER O	, // o
            0x0070, // LATIN SMALL LETTER P	, // p
            0x0071, // LATIN SMALL LETTER Q	, // q
            0x0072, // LATIN SMALL LETTER R	, // r
            0x0073, // LATIN SMALL LETTER S	, // s
            0x0074, // LATIN SMALL LETTER T	, // t
            0x0075, // LATIN SMALL LETTER U	, // u
            0x0076, // LATIN SMALL LETTER V	, // v
            0x0077, // LATIN SMALL LETTER W	, // w
            0x0078, // LATIN SMALL LETTER X	, // x
            0x0079, // LATIN SMALL LETTER Y	, // y
            0x007A, // LATIN SMALL LETTER Z	, // z
            0x007B, // LEFT CURLY BRACKET	, // braceleft
            0x007C, // VERTICAL LINE	, // bar
            0x007D, // RIGHT CURLY BRACKET	, // braceright
            0x007E, // TILDE	, // asciitilde
            0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
            0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
            0x00A1, // INVERTED EXCLAMATION MARK	, // exclamdown
            0x00A2, // CENT SIGN	, // cent
            0x00A3, // POUND SIGN	, // sterling
            2044, // FRACTION SLASH	, // fraction
//2215	A4	, // DIVISION SLASH	, // fraction
            0x00A5, // YEN SIGN	, // yen
            0x0192, // LATIN SMALL LETTER F WITH HOOK	, // florin
            0x00A7, // SECTION SIGN	, // section
            0x00A4, // CURRENCY SIGN	, // currency
            0x0027, // APOSTROPHE	, // quotesingle
            0x201C, // LEFT DOUBLE QUOTATION MARK	, // quotedblleft
            0x00AB, // LEFT-POINTING DOUBLE ANGLE QUOTATION MARK	, // guillemotleft
            0x2039, // SINGLE LEFT-POINTING ANGLE QUOTATION MARK	, // guilsinglleft
            0x203A, // SINGLE RIGHT-POINTING ANGLE QUOTATION MARK	, // guilsinglright
            0xFB01, // LATIN SMALL LIGATURE FI	, // fi
            0xFB02, // LATIN SMALL LIGATURE FL	, // fl
            0x00,
            0x2013, // EN DASH	, // endash
            0x2020, // DAGGER	, // dagger
            0x2021, // DOUBLE DAGGER	, // daggerdbl
            0x00B7, // MIDDLE DOT	, // periodcentered
//2219	B4	, // BULLET OPERATOR	, // periodcentered
            0x00,
            0x00B6, // PILCROW SIGN	, // paragraph
            0x2022, // BULLET	, // bullet
            0x201A, // SINGLE LOW-9 QUOTATION MARK	, // quotesinglbase
            0x201E, // DOUBLE LOW-9 QUOTATION MARK	, // quotedblbase
            0x201D, // RIGHT DOUBLE QUOTATION MARK	, // quotedblright
            0x00BB, // RIGHT-POINTING DOUBLE ANGLE QUOTATION MARK	, // guillemotright
            0x2026, // HORIZONTAL ELLIPSIS	, // ellipsis
            0x2030, // PER MILLE SIGN	, // perthousand
            0x00,
            0x00BF, // INVERTED QUESTION MARK	, // questiondown
            0x00,
            0x0060, // GRAVE ACCENT	, // grave
            0x00B4, // ACUTE ACCENT	, // acute
            0x02C6, // MODIFIER LETTER CIRCUMFLEX ACCENT	, // circumflex
            0x02DC, // SMALL TILDE	, // tilde
            0x00AF, // MACRON	, // macron
//02C9	C5	, // MODIFIER LETTER MACRON	, // macron
            0x02D8, // BREVE	, // breve
            0x02D9, // DOT ABOVE	, // dotaccent
            0x00A8, // DIAERESIS	, // dieresis
            0x00,
            0x02DA, // RING ABOVE	, // ring
            0x00B8, // CEDILLA	, // cedilla
            0x00,
            0x02DD, // DOUBLE ACUTE ACCENT	, // hungarumlaut
            0x02DB, // OGONEK	, // ogonek
            0x02C7, // CARON	, // caron
            0x2014, // EM DASH	, // emdash
            0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
            0x00, 0x00,
            0x00C6, // LATIN CAPITAL LETTER AE	, // AE
            0x00,
            0x00AA, // FEMININE ORDINAL INDICATOR	, // ordfeminine
            0x00, 0x00, 0x00, 0x00,
            0x0141, // LATIN CAPITAL LETTER L WITH STROKE	, // Lslash
            0x00D8, // LATIN CAPITAL LETTER O WITH STROKE	, // Oslash
            0x0152, // LATIN CAPITAL LIGATURE OE	, // OE
            0x00BA, // MASCULINE ORDINAL INDICATOR	, // ordmasculine
            0x00, 0x00, 0x00, 0x00, 0x00,
            0x00E6, // LATIN SMALL LETTER AE	, // ae
            0x00, 0x00, 0x00,
            0x0131, // LATIN SMALL LETTER DOTLESS I	, // dotlessi
            0x00, 0x00,
            0x0142, // LATIN SMALL LETTER L WITH STROKE	, // lslash
            0x00F8, // LATIN SMALL LETTER O WITH STROKE	, // oslash
            0x0153, // LATIN SMALL LIGATURE OE	, // oe
            0x00DF, // LATIN SMALL LETTER SHARP S	, // germandbls
            0x00, 0x00, 0x00, 0x00,
    };


    public static HashMap<String, Integer> getAdobeGlyphList() {
      HashMap<String, Integer> glyphList = new HashMap<>();

      /*
       * based on https://raw.githubusercontent.com/adobe-type-tools/agl-aglfn/master/glyphlist.txt.
       */
      glyphList.put("A", 0x0041);
      glyphList.put("AE", 0x00C6);
      glyphList.put("AEacute", 0x01FC);
      glyphList.put("AEmacron", 0x01E2);
      glyphList.put("AEsmall", 0xF7E6);
      glyphList.put("Aacute", 0x00C1);
      glyphList.put("Aacutesmall", 0xF7E1);
      glyphList.put("Abreve", 0x0102);
      glyphList.put("Abreveacute", 0x1EAE);
      glyphList.put("Abrevecyrillic", 0x04D0);
      glyphList.put("Abrevedotbelow", 0x1EB6);
      glyphList.put("Abrevegrave", 0x1EB0);
      glyphList.put("Abrevehookabove", 0x1EB2);
      glyphList.put("Abrevetilde", 0x1EB4);
      glyphList.put("Acaron", 0x01CD);
      glyphList.put("Acircle", 0x24B6);
      glyphList.put("Acircumflex", 0x00C2);
      glyphList.put("Acircumflexacute", 0x1EA4);
      glyphList.put("Acircumflexdotbelow", 0x1EAC);
      glyphList.put("Acircumflexgrave", 0x1EA6);
      glyphList.put("Acircumflexhookabove", 0x1EA8);
      glyphList.put("Acircumflexsmall", 0xF7E2);
      glyphList.put("Acircumflextilde", 0x1EAA);
      glyphList.put("Acute", 0xF6C9);
      glyphList.put("Acutesmall", 0xF7B4);
      glyphList.put("Acyrillic", 0x0410);
      glyphList.put("Adblgrave", 0x0200);
      glyphList.put("Adieresis", 0x00C4);
      glyphList.put("Adieresiscyrillic", 0x04D2);
      glyphList.put("Adieresismacron", 0x01DE);
      glyphList.put("Adieresissmall", 0xF7E4);
      glyphList.put("Adotbelow", 0x1EA0);
      glyphList.put("Adotmacron", 0x01E0);
      glyphList.put("Agrave", 0x00C0);
      glyphList.put("Agravesmall", 0xF7E0);
      glyphList.put("Ahookabove", 0x1EA2);
      glyphList.put("Aiecyrillic", 0x04D4);
      glyphList.put("Ainvertedbreve", 0x0202);
      glyphList.put("Alpha", 0x0391);
      glyphList.put("Alphatonos", 0x0386);
      glyphList.put("Amacron", 0x0100);
      glyphList.put("Amonospace", 0xFF21);
      glyphList.put("Aogonek", 0x0104);
      glyphList.put("Aring", 0x00C5);
      glyphList.put("Aringacute", 0x01FA);
      glyphList.put("Aringbelow", 0x1E00);
      glyphList.put("Aringsmall", 0xF7E5);
      glyphList.put("Asmall", 0xF761);
      glyphList.put("Atilde", 0x00C3);
      glyphList.put("Atildesmall", 0xF7E3);
      glyphList.put("Aybarmenian", 0x0531);
      glyphList.put("B", 0x0042);
      glyphList.put("Bcircle", 0x24B7);
      glyphList.put("Bdotaccent", 0x1E02);
      glyphList.put("Bdotbelow", 0x1E04);
      glyphList.put("Becyrillic", 0x0411);
      glyphList.put("Benarmenian", 0x0532);
      glyphList.put("Beta", 0x0392);
      glyphList.put("Bhook", 0x0181);
      glyphList.put("Blinebelow", 0x1E06);
      glyphList.put("Bmonospace", 0xFF22);
      glyphList.put("Brevesmall", 0xF6F4);
      glyphList.put("Bsmall", 0xF762);
      glyphList.put("Btopbar", 0x0182);
      glyphList.put("C", 0x0043);
      glyphList.put("Caarmenian", 0x053E);
      glyphList.put("Cacute", 0x0106);
      glyphList.put("Caron", 0xF6CA);
      glyphList.put("Caronsmall", 0xF6F5);
      glyphList.put("Ccaron", 0x010C);
      glyphList.put("Ccedilla", 0x00C7);
      glyphList.put("Ccedillaacute", 0x1E08);
      glyphList.put("Ccedillasmall", 0xF7E7);
      glyphList.put("Ccircle", 0x24B8);
      glyphList.put("Ccircumflex", 0x0108);
      glyphList.put("Cdot", 0x010A);
      glyphList.put("Cdotaccent", 0x010A);
      glyphList.put("Cedillasmall", 0xF7B8);
      glyphList.put("Chaarmenian", 0x0549);
      glyphList.put("Cheabkhasiancyrillic", 0x04BC);
      glyphList.put("Checyrillic", 0x0427);
      glyphList.put("Chedescenderabkhasiancyrillic", 0x04BE);
      glyphList.put("Chedescendercyrillic", 0x04B6);
      glyphList.put("Chedieresiscyrillic", 0x04F4);
      glyphList.put("Cheharmenian", 0x0543);
      glyphList.put("Chekhakassiancyrillic", 0x04CB);
      glyphList.put("Cheverticalstrokecyrillic", 0x04B8);
      glyphList.put("Chi", 0x03A7);
      glyphList.put("Chook", 0x0187);
      glyphList.put("Circumflexsmall", 0xF6F6);
      glyphList.put("Cmonospace", 0xFF23);
      glyphList.put("Coarmenian", 0x0551);
      glyphList.put("Csmall", 0xF763);
      glyphList.put("D", 0x0044);
      glyphList.put("DZ", 0x01F1);
      glyphList.put("DZcaron", 0x01C4);
      glyphList.put("Daarmenian", 0x0534);
      glyphList.put("Dafrican", 0x0189);
      glyphList.put("Dcaron", 0x010E);
      glyphList.put("Dcedilla", 0x1E10);
      glyphList.put("Dcircle", 0x24B9);
      glyphList.put("Dcircumflexbelow", 0x1E12);
      glyphList.put("Dcroat", 0x0110);
      glyphList.put("Ddotaccent", 0x1E0A);
      glyphList.put("Ddotbelow", 0x1E0C);
      glyphList.put("Decyrillic", 0x0414);
      glyphList.put("Deicoptic", 0x03EE);
      glyphList.put("Delta", 0x2206);
      glyphList.put("Deltagreek", 0x0394);
      glyphList.put("Dhook", 0x018A);
      glyphList.put("Dieresis", 0xF6CB);
      glyphList.put("DieresisAcute", 0xF6CC);
      glyphList.put("DieresisGrave", 0xF6CD);
      glyphList.put("Dieresissmall", 0xF7A8);
      glyphList.put("Digammagreek", 0x03DC);
      glyphList.put("Djecyrillic", 0x0402);
      glyphList.put("Dlinebelow", 0x1E0E);
      glyphList.put("Dmonospace", 0xFF24);
      glyphList.put("Dotaccentsmall", 0xF6F7);
      glyphList.put("Dslash", 0x0110);
      glyphList.put("Dsmall", 0xF764);
      glyphList.put("Dtopbar", 0x018B);
      glyphList.put("Dz", 0x01F2);
      glyphList.put("Dzcaron", 0x01C5);
      glyphList.put("Dzeabkhasiancyrillic", 0x04E0);
      glyphList.put("Dzecyrillic", 0x0405);
      glyphList.put("Dzhecyrillic", 0x040F);
      glyphList.put("E", 0x0045);
      glyphList.put("Eacute", 0x00C9);
      glyphList.put("Eacutesmall", 0xF7E9);
      glyphList.put("Ebreve", 0x0114);
      glyphList.put("Ecaron", 0x011A);
      glyphList.put("Ecedillabreve", 0x1E1C);
      glyphList.put("Echarmenian", 0x0535);
      glyphList.put("Ecircle", 0x24BA);
      glyphList.put("Ecircumflex", 0x00CA);
      glyphList.put("Ecircumflexacute", 0x1EBE);
      glyphList.put("Ecircumflexbelow", 0x1E18);
      glyphList.put("Ecircumflexdotbelow", 0x1EC6);
      glyphList.put("Ecircumflexgrave", 0x1EC0);
      glyphList.put("Ecircumflexhookabove", 0x1EC2);
      glyphList.put("Ecircumflexsmall", 0xF7EA);
      glyphList.put("Ecircumflextilde", 0x1EC4);
      glyphList.put("Ecyrillic", 0x0404);
      glyphList.put("Edblgrave", 0x0204);
      glyphList.put("Edieresis", 0x00CB);
      glyphList.put("Edieresissmall", 0xF7EB);
      glyphList.put("Edot", 0x0116);
      glyphList.put("Edotaccent", 0x0116);
      glyphList.put("Edotbelow", 0x1EB8);
      glyphList.put("Efcyrillic", 0x0424);
      glyphList.put("Egrave", 0x00C8);
      glyphList.put("Egravesmall", 0xF7E8);
      glyphList.put("Eharmenian", 0x0537);
      glyphList.put("Ehookabove", 0x1EBA);
      glyphList.put("Eightroman", 0x2167);
      glyphList.put("Einvertedbreve", 0x0206);
      glyphList.put("Eiotifiedcyrillic", 0x0464);
      glyphList.put("Elcyrillic", 0x041B);
      glyphList.put("Elevenroman", 0x216A);
      glyphList.put("Emacron", 0x0112);
      glyphList.put("Emacronacute", 0x1E16);
      glyphList.put("Emacrongrave", 0x1E14);
      glyphList.put("Emcyrillic", 0x041C);
      glyphList.put("Emonospace", 0xFF25);
      glyphList.put("Encyrillic", 0x041D);
      glyphList.put("Endescendercyrillic", 0x04A2);
      glyphList.put("Eng", 0x014A);
      glyphList.put("Enghecyrillic", 0x04A4);
      glyphList.put("Enhookcyrillic", 0x04C7);
      glyphList.put("Eogonek", 0x0118);
      glyphList.put("Eopen", 0x0190);
      glyphList.put("Epsilon", 0x0395);
      glyphList.put("Epsilontonos", 0x0388);
      glyphList.put("Ercyrillic", 0x0420);
      glyphList.put("Ereversed", 0x018E);
      glyphList.put("Ereversedcyrillic", 0x042D);
      glyphList.put("Escyrillic", 0x0421);
      glyphList.put("Esdescendercyrillic", 0x04AA);
      glyphList.put("Esh", 0x01A9);
      glyphList.put("Esmall", 0xF765);
      glyphList.put("Eta", 0x0397);
      glyphList.put("Etarmenian", 0x0538);
      glyphList.put("Etatonos", 0x0389);
      glyphList.put("Eth", 0x00D0);
      glyphList.put("Ethsmall", 0xF7F0);
      glyphList.put("Etilde", 0x1EBC);
      glyphList.put("Etildebelow", 0x1E1A);
      glyphList.put("Euro", 0x20AC);
      glyphList.put("Ezh", 0x01B7);
      glyphList.put("Ezhcaron", 0x01EE);
      glyphList.put("Ezhreversed", 0x01B8);
      glyphList.put("F", 0x0046);
      glyphList.put("Fcircle", 0x24BB);
      glyphList.put("Fdotaccent", 0x1E1E);
      glyphList.put("Feharmenian", 0x0556);
      glyphList.put("Feicoptic", 0x03E4);
      glyphList.put("Fhook", 0x0191);
      glyphList.put("Fitacyrillic", 0x0472);
      glyphList.put("Fiveroman", 0x2164);
      glyphList.put("Fmonospace", 0xFF26);
      glyphList.put("Fourroman", 0x2163);
      glyphList.put("Fsmall", 0xF766);
      glyphList.put("G", 0x0047);
      glyphList.put("GBsquare", 0x3387);
      glyphList.put("Gacute", 0x01F4);
      glyphList.put("Gamma", 0x0393);
      glyphList.put("Gammaafrican", 0x0194);
      glyphList.put("Gangiacoptic", 0x03EA);
      glyphList.put("Gbreve", 0x011E);
      glyphList.put("Gcaron", 0x01E6);
      glyphList.put("Gcedilla", 0x0122);
      glyphList.put("Gcircle", 0x24BC);
      glyphList.put("Gcircumflex", 0x011C);
      glyphList.put("Gcommaaccent", 0x0122);
      glyphList.put("Gdot", 0x0120);
      glyphList.put("Gdotaccent", 0x0120);
      glyphList.put("Gecyrillic", 0x0413);
      glyphList.put("Ghadarmenian", 0x0542);
      glyphList.put("Ghemiddlehookcyrillic", 0x0494);
      glyphList.put("Ghestrokecyrillic", 0x0492);
      glyphList.put("Gheupturncyrillic", 0x0490);
      glyphList.put("Ghook", 0x0193);
      glyphList.put("Gimarmenian", 0x0533);
      glyphList.put("Gjecyrillic", 0x0403);
      glyphList.put("Gmacron", 0x1E20);
      glyphList.put("Gmonospace", 0xFF27);
      glyphList.put("Grave", 0xF6CE);
      glyphList.put("Gravesmall", 0xF760);
      glyphList.put("Gsmall", 0xF767);
      glyphList.put("Gsmallhook", 0x029B);
      glyphList.put("Gstroke", 0x01E4);
      glyphList.put("H", 0x0048);
      glyphList.put("H18533", 0x25CF);
      glyphList.put("H18543", 0x25AA);
      glyphList.put("H18551", 0x25AB);
      glyphList.put("H22073", 0x25A1);
      glyphList.put("HPsquare", 0x33CB);
      glyphList.put("Haabkhasiancyrillic", 0x04A8);
      glyphList.put("Hadescendercyrillic", 0x04B2);
      glyphList.put("Hardsigncyrillic", 0x042A);
      glyphList.put("Hbar", 0x0126);
      glyphList.put("Hbrevebelow", 0x1E2A);
      glyphList.put("Hcedilla", 0x1E28);
      glyphList.put("Hcircle", 0x24BD);
      glyphList.put("Hcircumflex", 0x0124);
      glyphList.put("Hdieresis", 0x1E26);
      glyphList.put("Hdotaccent", 0x1E22);
      glyphList.put("Hdotbelow", 0x1E24);
      glyphList.put("Hmonospace", 0xFF28);
      glyphList.put("Hoarmenian", 0x0540);
      glyphList.put("Horicoptic", 0x03E8);
      glyphList.put("Hsmall", 0xF768);
      glyphList.put("Hungarumlaut", 0xF6CF);
      glyphList.put("Hungarumlautsmall", 0xF6F8);
      glyphList.put("Hzsquare", 0x3390);
      glyphList.put("I", 0x0049);
      glyphList.put("IAcyrillic", 0x042F);
      glyphList.put("IJ", 0x0132);
      glyphList.put("IUcyrillic", 0x042E);
      glyphList.put("Iacute", 0x00CD);
      glyphList.put("Iacutesmall", 0xF7ED);
      glyphList.put("Ibreve", 0x012C);
      glyphList.put("Icaron", 0x01CF);
      glyphList.put("Icircle", 0x24BE);
      glyphList.put("Icircumflex", 0x00CE);
      glyphList.put("Icircumflexsmall", 0xF7EE);
      glyphList.put("Icyrillic", 0x0406);
      glyphList.put("Idblgrave", 0x0208);
      glyphList.put("Idieresis", 0x00CF);
      glyphList.put("Idieresisacute", 0x1E2E);
      glyphList.put("Idieresiscyrillic", 0x04E4);
      glyphList.put("Idieresissmall", 0xF7EF);
      glyphList.put("Idot", 0x0130);
      glyphList.put("Idotaccent", 0x0130);
      glyphList.put("Idotbelow", 0x1ECA);
      glyphList.put("Iebrevecyrillic", 0x04D6);
      glyphList.put("Iecyrillic", 0x0415);
      glyphList.put("Ifraktur", 0x2111);
      glyphList.put("Igrave", 0x00CC);
      glyphList.put("Igravesmall", 0xF7EC);
      glyphList.put("Ihookabove", 0x1EC8);
      glyphList.put("Iicyrillic", 0x0418);
      glyphList.put("Iinvertedbreve", 0x020A);
      glyphList.put("Iishortcyrillic", 0x0419);
      glyphList.put("Imacron", 0x012A);
      glyphList.put("Imacroncyrillic", 0x04E2);
      glyphList.put("Imonospace", 0xFF29);
      glyphList.put("Iniarmenian", 0x053B);
      glyphList.put("Iocyrillic", 0x0401);
      glyphList.put("Iogonek", 0x012E);
      glyphList.put("Iota", 0x0399);
      glyphList.put("Iotaafrican", 0x0196);
      glyphList.put("Iotadieresis", 0x03AA);
      glyphList.put("Iotatonos", 0x038A);
      glyphList.put("Ismall", 0xF769);
      glyphList.put("Istroke", 0x0197);
      glyphList.put("Itilde", 0x0128);
      glyphList.put("Itildebelow", 0x1E2C);
      glyphList.put("Izhitsacyrillic", 0x0474);
      glyphList.put("Izhitsadblgravecyrillic", 0x0476);
      glyphList.put("J", 0x004A);
      glyphList.put("Jaarmenian", 0x0541);
      glyphList.put("Jcircle", 0x24BF);
      glyphList.put("Jcircumflex", 0x0134);
      glyphList.put("Jecyrillic", 0x0408);
      glyphList.put("Jheharmenian", 0x054B);
      glyphList.put("Jmonospace", 0xFF2A);
      glyphList.put("Jsmall", 0xF76A);
      glyphList.put("K", 0x004B);
      glyphList.put("KBsquare", 0x3385);
      glyphList.put("KKsquare", 0x33CD);
      glyphList.put("Kabashkircyrillic", 0x04A0);
      glyphList.put("Kacute", 0x1E30);
      glyphList.put("Kacyrillic", 0x041A);
      glyphList.put("Kadescendercyrillic", 0x049A);
      glyphList.put("Kahookcyrillic", 0x04C3);
      glyphList.put("Kappa", 0x039A);
      glyphList.put("Kastrokecyrillic", 0x049E);
      glyphList.put("Kaverticalstrokecyrillic", 0x049C);
      glyphList.put("Kcaron", 0x01E8);
      glyphList.put("Kcedilla", 0x0136);
      glyphList.put("Kcircle", 0x24C0);
      glyphList.put("Kcommaaccent", 0x0136);
      glyphList.put("Kdotbelow", 0x1E32);
      glyphList.put("Keharmenian", 0x0554);
      glyphList.put("Kenarmenian", 0x053F);
      glyphList.put("Khacyrillic", 0x0425);
      glyphList.put("Kheicoptic", 0x03E6);
      glyphList.put("Khook", 0x0198);
      glyphList.put("Kjecyrillic", 0x040C);
      glyphList.put("Klinebelow", 0x1E34);
      glyphList.put("Kmonospace", 0xFF2B);
      glyphList.put("Koppacyrillic", 0x0480);
      glyphList.put("Koppagreek", 0x03DE);
      glyphList.put("Ksicyrillic", 0x046E);
      glyphList.put("Ksmall", 0xF76B);
      glyphList.put("L", 0x004C);
      glyphList.put("LJ", 0x01C7);
      glyphList.put("LL", 0xF6BF);
      glyphList.put("Lacute", 0x0139);
      glyphList.put("Lambda", 0x039B);
      glyphList.put("Lcaron", 0x013D);
      glyphList.put("Lcedilla", 0x013B);
      glyphList.put("Lcircle", 0x24C1);
      glyphList.put("Lcircumflexbelow", 0x1E3C);
      glyphList.put("Lcommaaccent", 0x013B);
      glyphList.put("Ldot", 0x013F);
      glyphList.put("Ldotaccent", 0x013F);
      glyphList.put("Ldotbelow", 0x1E36);
      glyphList.put("Ldotbelowmacron", 0x1E38);
      glyphList.put("Liwnarmenian", 0x053C);
      glyphList.put("Lj", 0x01C8);
      glyphList.put("Ljecyrillic", 0x0409);
      glyphList.put("Llinebelow", 0x1E3A);
      glyphList.put("Lmonospace", 0xFF2C);
      glyphList.put("Lslash", 0x0141);
      glyphList.put("Lslashsmall", 0xF6F9);
      glyphList.put("Lsmall", 0xF76C);
      glyphList.put("M", 0x004D);
      glyphList.put("MBsquare", 0x3386);
      glyphList.put("Macron", 0xF6D0);
      glyphList.put("Macronsmall", 0xF7AF);
      glyphList.put("Macute", 0x1E3E);
      glyphList.put("Mcircle", 0x24C2);
      glyphList.put("Mdotaccent", 0x1E40);
      glyphList.put("Mdotbelow", 0x1E42);
      glyphList.put("Menarmenian", 0x0544);
      glyphList.put("Mmonospace", 0xFF2D);
      glyphList.put("Msmall", 0xF76D);
      glyphList.put("Mturned", 0x019C);
      glyphList.put("Mu", 0x039C);
      glyphList.put("N", 0x004E);
      glyphList.put("NJ", 0x01CA);
      glyphList.put("Nacute", 0x0143);
      glyphList.put("Ncaron", 0x0147);
      glyphList.put("Ncedilla", 0x0145);
      glyphList.put("Ncircle", 0x24C3);
      glyphList.put("Ncircumflexbelow", 0x1E4A);
      glyphList.put("Ncommaaccent", 0x0145);
      glyphList.put("Ndotaccent", 0x1E44);
      glyphList.put("Ndotbelow", 0x1E46);
      glyphList.put("Nhookleft", 0x019D);
      glyphList.put("Nineroman", 0x2168);
      glyphList.put("Nj", 0x01CB);
      glyphList.put("Njecyrillic", 0x040A);
      glyphList.put("Nlinebelow", 0x1E48);
      glyphList.put("Nmonospace", 0xFF2E);
      glyphList.put("Nowarmenian", 0x0546);
      glyphList.put("Nsmall", 0xF76E);
      glyphList.put("Ntilde", 0x00D1);
      glyphList.put("Ntildesmall", 0xF7F1);
      glyphList.put("Nu", 0x039D);
      glyphList.put("O", 0x004F);
      glyphList.put("OE", 0x0152);
      glyphList.put("OEsmall", 0xF6FA);
      glyphList.put("Oacute", 0x00D3);
      glyphList.put("Oacutesmall", 0xF7F3);
      glyphList.put("Obarredcyrillic", 0x04E8);
      glyphList.put("Obarreddieresiscyrillic", 0x04EA);
      glyphList.put("Obreve", 0x014E);
      glyphList.put("Ocaron", 0x01D1);
      glyphList.put("Ocenteredtilde", 0x019F);
      glyphList.put("Ocircle", 0x24C4);
      glyphList.put("Ocircumflex", 0x00D4);
      glyphList.put("Ocircumflexacute", 0x1ED0);
      glyphList.put("Ocircumflexdotbelow", 0x1ED8);
      glyphList.put("Ocircumflexgrave", 0x1ED2);
      glyphList.put("Ocircumflexhookabove", 0x1ED4);
      glyphList.put("Ocircumflexsmall", 0xF7F4);
      glyphList.put("Ocircumflextilde", 0x1ED6);
      glyphList.put("Ocyrillic", 0x041E);
      glyphList.put("Odblacute", 0x0150);
      glyphList.put("Odblgrave", 0x020C);
      glyphList.put("Odieresis", 0x00D6);
      glyphList.put("Odieresiscyrillic", 0x04E6);
      glyphList.put("Odieresissmall", 0xF7F6);
      glyphList.put("Odotbelow", 0x1ECC);
      glyphList.put("Ogoneksmall", 0xF6FB);
      glyphList.put("Ograve", 0x00D2);
      glyphList.put("Ogravesmall", 0xF7F2);
      glyphList.put("Oharmenian", 0x0555);
      glyphList.put("Ohm", 0x2126);
      glyphList.put("Ohookabove", 0x1ECE);
      glyphList.put("Ohorn", 0x01A0);
      glyphList.put("Ohornacute", 0x1EDA);
      glyphList.put("Ohorndotbelow", 0x1EE2);
      glyphList.put("Ohorngrave", 0x1EDC);
      glyphList.put("Ohornhookabove", 0x1EDE);
      glyphList.put("Ohorntilde", 0x1EE0);
      glyphList.put("Ohungarumlaut", 0x0150);
      glyphList.put("Oi", 0x01A2);
      glyphList.put("Oinvertedbreve", 0x020E);
      glyphList.put("Omacron", 0x014C);
      glyphList.put("Omacronacute", 0x1E52);
      glyphList.put("Omacrongrave", 0x1E50);
      glyphList.put("Omega", 0x2126);
      glyphList.put("Omegacyrillic", 0x0460);
      glyphList.put("Omegagreek", 0x03A9);
      glyphList.put("Omegaroundcyrillic", 0x047A);
      glyphList.put("Omegatitlocyrillic", 0x047C);
      glyphList.put("Omegatonos", 0x038F);
      glyphList.put("Omicron", 0x039F);
      glyphList.put("Omicrontonos", 0x038C);
      glyphList.put("Omonospace", 0xFF2F);
      glyphList.put("Oneroman", 0x2160);
      glyphList.put("Oogonek", 0x01EA);
      glyphList.put("Oogonekmacron", 0x01EC);
      glyphList.put("Oopen", 0x0186);
      glyphList.put("Oslash", 0x00D8);
      glyphList.put("Oslashacute", 0x01FE);
      glyphList.put("Oslashsmall", 0xF7F8);
      glyphList.put("Osmall", 0xF76F);
      glyphList.put("Ostrokeacute", 0x01FE);
      glyphList.put("Otcyrillic", 0x047E);
      glyphList.put("Otilde", 0x00D5);
      glyphList.put("Otildeacute", 0x1E4C);
      glyphList.put("Otildedieresis", 0x1E4E);
      glyphList.put("Otildesmall", 0xF7F5);
      glyphList.put("P", 0x0050);
      glyphList.put("Pacute", 0x1E54);
      glyphList.put("Pcircle", 0x24C5);
      glyphList.put("Pdotaccent", 0x1E56);
      glyphList.put("Pecyrillic", 0x041F);
      glyphList.put("Peharmenian", 0x054A);
      glyphList.put("Pemiddlehookcyrillic", 0x04A6);
      glyphList.put("Phi", 0x03A6);
      glyphList.put("Phook", 0x01A4);
      glyphList.put("Pi", 0x03A0);
      glyphList.put("Piwrarmenian", 0x0553);
      glyphList.put("Pmonospace", 0xFF30);
      glyphList.put("Psi", 0x03A8);
      glyphList.put("Psicyrillic", 0x0470);
      glyphList.put("Psmall", 0xF770);
      glyphList.put("Q", 0x0051);
      glyphList.put("Qcircle", 0x24C6);
      glyphList.put("Qmonospace", 0xFF31);
      glyphList.put("Qsmall", 0xF771);
      glyphList.put("R", 0x0052);
      glyphList.put("Raarmenian", 0x054C);
      glyphList.put("Racute", 0x0154);
      glyphList.put("Rcaron", 0x0158);
      glyphList.put("Rcedilla", 0x0156);
      glyphList.put("Rcircle", 0x24C7);
      glyphList.put("Rcommaaccent", 0x0156);
      glyphList.put("Rdblgrave", 0x0210);
      glyphList.put("Rdotaccent", 0x1E58);
      glyphList.put("Rdotbelow", 0x1E5A);
      glyphList.put("Rdotbelowmacron", 0x1E5C);
      glyphList.put("Reharmenian", 0x0550);
      glyphList.put("Rfraktur", 0x211C);
      glyphList.put("Rho", 0x03A1);
      glyphList.put("Ringsmall", 0xF6FC);
      glyphList.put("Rinvertedbreve", 0x0212);
      glyphList.put("Rlinebelow", 0x1E5E);
      glyphList.put("Rmonospace", 0xFF32);
      glyphList.put("Rsmall", 0xF772);
      glyphList.put("Rsmallinverted", 0x0281);
      glyphList.put("Rsmallinvertedsuperior", 0x02B6);
      glyphList.put("S", 0x0053);
      glyphList.put("SF010000", 0x250C);
      glyphList.put("SF020000", 0x2514);
      glyphList.put("SF030000", 0x2510);
      glyphList.put("SF040000", 0x2518);
      glyphList.put("SF050000", 0x253C);
      glyphList.put("SF060000", 0x252C);
      glyphList.put("SF070000", 0x2534);
      glyphList.put("SF080000", 0x251C);
      glyphList.put("SF090000", 0x2524);
      glyphList.put("SF100000", 0x2500);
      glyphList.put("SF110000", 0x2502);
      glyphList.put("SF190000", 0x2561);
      glyphList.put("SF200000", 0x2562);
      glyphList.put("SF210000", 0x2556);
      glyphList.put("SF220000", 0x2555);
      glyphList.put("SF230000", 0x2563);
      glyphList.put("SF240000", 0x2551);
      glyphList.put("SF250000", 0x2557);
      glyphList.put("SF260000", 0x255D);
      glyphList.put("SF270000", 0x255C);
      glyphList.put("SF280000", 0x255B);
      glyphList.put("SF360000", 0x255E);
      glyphList.put("SF370000", 0x255F);
      glyphList.put("SF380000", 0x255A);
      glyphList.put("SF390000", 0x2554);
      glyphList.put("SF400000", 0x2569);
      glyphList.put("SF410000", 0x2566);
      glyphList.put("SF420000", 0x2560);
      glyphList.put("SF430000", 0x2550);
      glyphList.put("SF440000", 0x256C);
      glyphList.put("SF450000", 0x2567);
      glyphList.put("SF460000", 0x2568);
      glyphList.put("SF470000", 0x2564);
      glyphList.put("SF480000", 0x2565);
      glyphList.put("SF490000", 0x2559);
      glyphList.put("SF500000", 0x2558);
      glyphList.put("SF510000", 0x2552);
      glyphList.put("SF520000", 0x2553);
      glyphList.put("SF530000", 0x256B);
      glyphList.put("SF540000", 0x256A);
      glyphList.put("Sacute", 0x015A);
      glyphList.put("Sacutedotaccent", 0x1E64);
      glyphList.put("Sampigreek", 0x03E0);
      glyphList.put("Scaron", 0x0160);
      glyphList.put("Scarondotaccent", 0x1E66);
      glyphList.put("Scaronsmall", 0xF6FD);
      glyphList.put("Scedilla", 0x015E);
      glyphList.put("Schwa", 0x018F);
      glyphList.put("Schwacyrillic", 0x04D8);
      glyphList.put("Schwadieresiscyrillic", 0x04DA);
      glyphList.put("Scircle", 0x24C8);
      glyphList.put("Scircumflex", 0x015C);
      glyphList.put("Scommaaccent", 0x0218);
      glyphList.put("Sdotaccent", 0x1E60);
      glyphList.put("Sdotbelow", 0x1E62);
      glyphList.put("Sdotbelowdotaccent", 0x1E68);
      glyphList.put("Seharmenian", 0x054D);
      glyphList.put("Sevenroman", 0x2166);
      glyphList.put("Shaarmenian", 0x0547);
      glyphList.put("Shacyrillic", 0x0428);
      glyphList.put("Shchacyrillic", 0x0429);
      glyphList.put("Sheicoptic", 0x03E2);
      glyphList.put("Shhacyrillic", 0x04BA);
      glyphList.put("Shimacoptic", 0x03EC);
      glyphList.put("Sigma", 0x03A3);
      glyphList.put("Sixroman", 0x2165);
      glyphList.put("Smonospace", 0xFF33);
      glyphList.put("Softsigncyrillic", 0x042C);
      glyphList.put("Ssmall", 0xF773);
      glyphList.put("Stigmagreek", 0x03DA);
      glyphList.put("T", 0x0054);
      glyphList.put("Tau", 0x03A4);
      glyphList.put("Tbar", 0x0166);
      glyphList.put("Tcaron", 0x0164);
      glyphList.put("Tcedilla", 0x0162);
      glyphList.put("Tcircle", 0x24C9);
      glyphList.put("Tcircumflexbelow", 0x1E70);
      glyphList.put("Tcommaaccent", 0x0162);
      glyphList.put("Tdotaccent", 0x1E6A);
      glyphList.put("Tdotbelow", 0x1E6C);
      glyphList.put("Tecyrillic", 0x0422);
      glyphList.put("Tedescendercyrillic", 0x04AC);
      glyphList.put("Tenroman", 0x2169);
      glyphList.put("Tetsecyrillic", 0x04B4);
      glyphList.put("Theta", 0x0398);
      glyphList.put("Thook", 0x01AC);
      glyphList.put("Thorn", 0x00DE);
      glyphList.put("Thornsmall", 0xF7FE);
      glyphList.put("Threeroman", 0x2162);
      glyphList.put("Tildesmall", 0xF6FE);
      glyphList.put("Tiwnarmenian", 0x054F);
      glyphList.put("Tlinebelow", 0x1E6E);
      glyphList.put("Tmonospace", 0xFF34);
      glyphList.put("Toarmenian", 0x0539);
      glyphList.put("Tonefive", 0x01BC);
      glyphList.put("Tonesix", 0x0184);
      glyphList.put("Tonetwo", 0x01A7);
      glyphList.put("Tretroflexhook", 0x01AE);
      glyphList.put("Tsecyrillic", 0x0426);
      glyphList.put("Tshecyrillic", 0x040B);
      glyphList.put("Tsmall", 0xF774);
      glyphList.put("Twelveroman", 0x216B);
      glyphList.put("Tworoman", 0x2161);
      glyphList.put("U", 0x0055);
      glyphList.put("Uacute", 0x00DA);
      glyphList.put("Uacutesmall", 0xF7FA);
      glyphList.put("Ubreve", 0x016C);
      glyphList.put("Ucaron", 0x01D3);
      glyphList.put("Ucircle", 0x24CA);
      glyphList.put("Ucircumflex", 0x00DB);
      glyphList.put("Ucircumflexbelow", 0x1E76);
      glyphList.put("Ucircumflexsmall", 0xF7FB);
      glyphList.put("Ucyrillic", 0x0423);
      glyphList.put("Udblacute", 0x0170);
      glyphList.put("Udblgrave", 0x0214);
      glyphList.put("Udieresis", 0x00DC);
      glyphList.put("Udieresisacute", 0x01D7);
      glyphList.put("Udieresisbelow", 0x1E72);
      glyphList.put("Udieresiscaron", 0x01D9);
      glyphList.put("Udieresiscyrillic", 0x04F0);
      glyphList.put("Udieresisgrave", 0x01DB);
      glyphList.put("Udieresismacron", 0x01D5);
      glyphList.put("Udieresissmall", 0xF7FC);
      glyphList.put("Udotbelow", 0x1EE4);
      glyphList.put("Ugrave", 0x00D9);
      glyphList.put("Ugravesmall", 0xF7F9);
      glyphList.put("Uhookabove", 0x1EE6);
      glyphList.put("Uhorn", 0x01AF);
      glyphList.put("Uhornacute", 0x1EE8);
      glyphList.put("Uhorndotbelow", 0x1EF0);
      glyphList.put("Uhorngrave", 0x1EEA);
      glyphList.put("Uhornhookabove", 0x1EEC);
      glyphList.put("Uhorntilde", 0x1EEE);
      glyphList.put("Uhungarumlaut", 0x0170);
      glyphList.put("Uhungarumlautcyrillic", 0x04F2);
      glyphList.put("Uinvertedbreve", 0x0216);
      glyphList.put("Ukcyrillic", 0x0478);
      glyphList.put("Umacron", 0x016A);
      glyphList.put("Umacroncyrillic", 0x04EE);
      glyphList.put("Umacrondieresis", 0x1E7A);
      glyphList.put("Umonospace", 0xFF35);
      glyphList.put("Uogonek", 0x0172);
      glyphList.put("Upsilon", 0x03A5);
      glyphList.put("Upsilon1", 0x03D2);
      glyphList.put("Upsilonacutehooksymbolgreek", 0x03D3);
      glyphList.put("Upsilonafrican", 0x01B1);
      glyphList.put("Upsilondieresis", 0x03AB);
      glyphList.put("Upsilondieresishooksymbolgreek", 0x03D4);
      glyphList.put("Upsilonhooksymbol", 0x03D2);
      glyphList.put("Upsilontonos", 0x038E);
      glyphList.put("Uring", 0x016E);
      glyphList.put("Ushortcyrillic", 0x040E);
      glyphList.put("Usmall", 0xF775);
      glyphList.put("Ustraightcyrillic", 0x04AE);
      glyphList.put("Ustraightstrokecyrillic", 0x04B0);
      glyphList.put("Utilde", 0x0168);
      glyphList.put("Utildeacute", 0x1E78);
      glyphList.put("Utildebelow", 0x1E74);
      glyphList.put("V", 0x0056);
      glyphList.put("Vcircle", 0x24CB);
      glyphList.put("Vdotbelow", 0x1E7E);
      glyphList.put("Vecyrillic", 0x0412);
      glyphList.put("Vewarmenian", 0x054E);
      glyphList.put("Vhook", 0x01B2);
      glyphList.put("Vmonospace", 0xFF36);
      glyphList.put("Voarmenian", 0x0548);
      glyphList.put("Vsmall", 0xF776);
      glyphList.put("Vtilde", 0x1E7C);
      glyphList.put("W", 0x0057);
      glyphList.put("Wacute", 0x1E82);
      glyphList.put("Wcircle", 0x24CC);
      glyphList.put("Wcircumflex", 0x0174);
      glyphList.put("Wdieresis", 0x1E84);
      glyphList.put("Wdotaccent", 0x1E86);
      glyphList.put("Wdotbelow", 0x1E88);
      glyphList.put("Wgrave", 0x1E80);
      glyphList.put("Wmonospace", 0xFF37);
      glyphList.put("Wsmall", 0xF777);
      glyphList.put("X", 0x0058);
      glyphList.put("Xcircle", 0x24CD);
      glyphList.put("Xdieresis", 0x1E8C);
      glyphList.put("Xdotaccent", 0x1E8A);
      glyphList.put("Xeharmenian", 0x053D);
      glyphList.put("Xi", 0x039E);
      glyphList.put("Xmonospace", 0xFF38);
      glyphList.put("Xsmall", 0xF778);
      glyphList.put("Y", 0x0059);
      glyphList.put("Yacute", 0x00DD);
      glyphList.put("Yacutesmall", 0xF7FD);
      glyphList.put("Yatcyrillic", 0x0462);
      glyphList.put("Ycircle", 0x24CE);
      glyphList.put("Ycircumflex", 0x0176);
      glyphList.put("Ydieresis", 0x0178);
      glyphList.put("Ydieresissmall", 0xF7FF);
      glyphList.put("Ydotaccent", 0x1E8E);
      glyphList.put("Ydotbelow", 0x1EF4);
      glyphList.put("Yericyrillic", 0x042B);
      glyphList.put("Yerudieresiscyrillic", 0x04F8);
      glyphList.put("Ygrave", 0x1EF2);
      glyphList.put("Yhook", 0x01B3);
      glyphList.put("Yhookabove", 0x1EF6);
      glyphList.put("Yiarmenian", 0x0545);
      glyphList.put("Yicyrillic", 0x0407);
      glyphList.put("Yiwnarmenian", 0x0552);
      glyphList.put("Ymonospace", 0xFF39);
      glyphList.put("Ysmall", 0xF779);
      glyphList.put("Ytilde", 0x1EF8);
      glyphList.put("Yusbigcyrillic", 0x046A);
      glyphList.put("Yusbigiotifiedcyrillic", 0x046C);
      glyphList.put("Yuslittlecyrillic", 0x0466);
      glyphList.put("Yuslittleiotifiedcyrillic", 0x0468);
      glyphList.put("Z", 0x005A);
      glyphList.put("Zaarmenian", 0x0536);
      glyphList.put("Zacute", 0x0179);
      glyphList.put("Zcaron", 0x017D);
      glyphList.put("Zcaronsmall", 0xF6FF);
      glyphList.put("Zcircle", 0x24CF);
      glyphList.put("Zcircumflex", 0x1E90);
      glyphList.put("Zdot", 0x017B);
      glyphList.put("Zdotaccent", 0x017B);
      glyphList.put("Zdotbelow", 0x1E92);
      glyphList.put("Zecyrillic", 0x0417);
      glyphList.put("Zedescendercyrillic", 0x0498);
      glyphList.put("Zedieresiscyrillic", 0x04DE);
      glyphList.put("Zeta", 0x0396);
      glyphList.put("Zhearmenian", 0x053A);
      glyphList.put("Zhebrevecyrillic", 0x04C1);
      glyphList.put("Zhecyrillic", 0x0416);
      glyphList.put("Zhedescendercyrillic", 0x0496);
      glyphList.put("Zhedieresiscyrillic", 0x04DC);
      glyphList.put("Zlinebelow", 0x1E94);
      glyphList.put("Zmonospace", 0xFF3A);
      glyphList.put("Zsmall", 0xF77A);
      glyphList.put("Zstroke", 0x01B5);
      glyphList.put("a", 0x0061);
      glyphList.put("aabengali", 0x0986);
      glyphList.put("aacute", 0x00E1);
      glyphList.put("aadeva", 0x0906);
      glyphList.put("aagujarati", 0x0A86);
      glyphList.put("aagurmukhi", 0x0A06);
      glyphList.put("aamatragurmukhi", 0x0A3E);
      glyphList.put("aarusquare", 0x3303);
      glyphList.put("aavowelsignbengali", 0x09BE);
      glyphList.put("aavowelsigndeva", 0x093E);
      glyphList.put("aavowelsigngujarati", 0x0ABE);
      glyphList.put("abbreviationmarkarmenian", 0x055F);
      glyphList.put("abbreviationsigndeva", 0x0970);
      glyphList.put("abengali", 0x0985);
      glyphList.put("abopomofo", 0x311A);
      glyphList.put("abreve", 0x0103);
      glyphList.put("abreveacute", 0x1EAF);
      glyphList.put("abrevecyrillic", 0x04D1);
      glyphList.put("abrevedotbelow", 0x1EB7);
      glyphList.put("abrevegrave", 0x1EB1);
      glyphList.put("abrevehookabove", 0x1EB3);
      glyphList.put("abrevetilde", 0x1EB5);
      glyphList.put("acaron", 0x01CE);
      glyphList.put("acircle", 0x24D0);
      glyphList.put("acircumflex", 0x00E2);
      glyphList.put("acircumflexacute", 0x1EA5);
      glyphList.put("acircumflexdotbelow", 0x1EAD);
      glyphList.put("acircumflexgrave", 0x1EA7);
      glyphList.put("acircumflexhookabove", 0x1EA9);
      glyphList.put("acircumflextilde", 0x1EAB);
      glyphList.put("acute", 0x00B4);
      glyphList.put("acutebelowcmb", 0x0317);
      glyphList.put("acutecmb", 0x0301);
      glyphList.put("acutecomb", 0x0301);
      glyphList.put("acutedeva", 0x0954);
      glyphList.put("acutelowmod", 0x02CF);
      glyphList.put("acutetonecmb", 0x0341);
      glyphList.put("acyrillic", 0x0430);
      glyphList.put("adblgrave", 0x0201);
      glyphList.put("addakgurmukhi", 0x0A71);
      glyphList.put("adeva", 0x0905);
      glyphList.put("adieresis", 0x00E4);
      glyphList.put("adieresiscyrillic", 0x04D3);
      glyphList.put("adieresismacron", 0x01DF);
      glyphList.put("adotbelow", 0x1EA1);
      glyphList.put("adotmacron", 0x01E1);
      glyphList.put("ae", 0x00E6);
      glyphList.put("aeacute", 0x01FD);
      glyphList.put("aekorean", 0x3150);
      glyphList.put("aemacron", 0x01E3);
      glyphList.put("afii00208", 0x2015);
      glyphList.put("afii08941", 0x20A4);
      glyphList.put("afii10017", 0x0410);
      glyphList.put("afii10018", 0x0411);
      glyphList.put("afii10019", 0x0412);
      glyphList.put("afii10020", 0x0413);
      glyphList.put("afii10021", 0x0414);
      glyphList.put("afii10022", 0x0415);
      glyphList.put("afii10023", 0x0401);
      glyphList.put("afii10024", 0x0416);
      glyphList.put("afii10025", 0x0417);
      glyphList.put("afii10026", 0x0418);
      glyphList.put("afii10027", 0x0419);
      glyphList.put("afii10028", 0x041A);
      glyphList.put("afii10029", 0x041B);
      glyphList.put("afii10030", 0x041C);
      glyphList.put("afii10031", 0x041D);
      glyphList.put("afii10032", 0x041E);
      glyphList.put("afii10033", 0x041F);
      glyphList.put("afii10034", 0x0420);
      glyphList.put("afii10035", 0x0421);
      glyphList.put("afii10036", 0x0422);
      glyphList.put("afii10037", 0x0423);
      glyphList.put("afii10038", 0x0424);
      glyphList.put("afii10039", 0x0425);
      glyphList.put("afii10040", 0x0426);
      glyphList.put("afii10041", 0x0427);
      glyphList.put("afii10042", 0x0428);
      glyphList.put("afii10043", 0x0429);
      glyphList.put("afii10044", 0x042A);
      glyphList.put("afii10045", 0x042B);
      glyphList.put("afii10046", 0x042C);
      glyphList.put("afii10047", 0x042D);
      glyphList.put("afii10048", 0x042E);
      glyphList.put("afii10049", 0x042F);
      glyphList.put("afii10050", 0x0490);
      glyphList.put("afii10051", 0x0402);
      glyphList.put("afii10052", 0x0403);
      glyphList.put("afii10053", 0x0404);
      glyphList.put("afii10054", 0x0405);
      glyphList.put("afii10055", 0x0406);
      glyphList.put("afii10056", 0x0407);
      glyphList.put("afii10057", 0x0408);
      glyphList.put("afii10058", 0x0409);
      glyphList.put("afii10059", 0x040A);
      glyphList.put("afii10060", 0x040B);
      glyphList.put("afii10061", 0x040C);
      glyphList.put("afii10062", 0x040E);
      glyphList.put("afii10063", 0xF6C4);
      glyphList.put("afii10064", 0xF6C5);
      glyphList.put("afii10065", 0x0430);
      glyphList.put("afii10066", 0x0431);
      glyphList.put("afii10067", 0x0432);
      glyphList.put("afii10068", 0x0433);
      glyphList.put("afii10069", 0x0434);
      glyphList.put("afii10070", 0x0435);
      glyphList.put("afii10071", 0x0451);
      glyphList.put("afii10072", 0x0436);
      glyphList.put("afii10073", 0x0437);
      glyphList.put("afii10074", 0x0438);
      glyphList.put("afii10075", 0x0439);
      glyphList.put("afii10076", 0x043A);
      glyphList.put("afii10077", 0x043B);
      glyphList.put("afii10078", 0x043C);
      glyphList.put("afii10079", 0x043D);
      glyphList.put("afii10080", 0x043E);
      glyphList.put("afii10081", 0x043F);
      glyphList.put("afii10082", 0x0440);
      glyphList.put("afii10083", 0x0441);
      glyphList.put("afii10084", 0x0442);
      glyphList.put("afii10085", 0x0443);
      glyphList.put("afii10086", 0x0444);
      glyphList.put("afii10087", 0x0445);
      glyphList.put("afii10088", 0x0446);
      glyphList.put("afii10089", 0x0447);
      glyphList.put("afii10090", 0x0448);
      glyphList.put("afii10091", 0x0449);
      glyphList.put("afii10092", 0x044A);
      glyphList.put("afii10093", 0x044B);
      glyphList.put("afii10094", 0x044C);
      glyphList.put("afii10095", 0x044D);
      glyphList.put("afii10096", 0x044E);
      glyphList.put("afii10097", 0x044F);
      glyphList.put("afii10098", 0x0491);
      glyphList.put("afii10099", 0x0452);
      glyphList.put("afii10100", 0x0453);
      glyphList.put("afii10101", 0x0454);
      glyphList.put("afii10102", 0x0455);
      glyphList.put("afii10103", 0x0456);
      glyphList.put("afii10104", 0x0457);
      glyphList.put("afii10105", 0x0458);
      glyphList.put("afii10106", 0x0459);
      glyphList.put("afii10107", 0x045A);
      glyphList.put("afii10108", 0x045B);
      glyphList.put("afii10109", 0x045C);
      glyphList.put("afii10110", 0x045E);
      glyphList.put("afii10145", 0x040F);
      glyphList.put("afii10146", 0x0462);
      glyphList.put("afii10147", 0x0472);
      glyphList.put("afii10148", 0x0474);
      glyphList.put("afii10192", 0xF6C6);
      glyphList.put("afii10193", 0x045F);
      glyphList.put("afii10194", 0x0463);
      glyphList.put("afii10195", 0x0473);
      glyphList.put("afii10196", 0x0475);
      glyphList.put("afii10831", 0xF6C7);
      glyphList.put("afii10832", 0xF6C8);
      glyphList.put("afii10846", 0x04D9);
      glyphList.put("afii299", 0x200E);
      glyphList.put("afii300", 0x200F);
      glyphList.put("afii301", 0x200D);
      glyphList.put("afii57381", 0x066A);
      glyphList.put("afii57388", 0x060C);
      glyphList.put("afii57392", 0x0660);
      glyphList.put("afii57393", 0x0661);
      glyphList.put("afii57394", 0x0662);
      glyphList.put("afii57395", 0x0663);
      glyphList.put("afii57396", 0x0664);
      glyphList.put("afii57397", 0x0665);
      glyphList.put("afii57398", 0x0666);
      glyphList.put("afii57399", 0x0667);
      glyphList.put("afii57400", 0x0668);
      glyphList.put("afii57401", 0x0669);
      glyphList.put("afii57403", 0x061B);
      glyphList.put("afii57407", 0x061F);
      glyphList.put("afii57409", 0x0621);
      glyphList.put("afii57410", 0x0622);
      glyphList.put("afii57411", 0x0623);
      glyphList.put("afii57412", 0x0624);
      glyphList.put("afii57413", 0x0625);
      glyphList.put("afii57414", 0x0626);
      glyphList.put("afii57415", 0x0627);
      glyphList.put("afii57416", 0x0628);
      glyphList.put("afii57417", 0x0629);
      glyphList.put("afii57418", 0x062A);
      glyphList.put("afii57419", 0x062B);
      glyphList.put("afii57420", 0x062C);
      glyphList.put("afii57421", 0x062D);
      glyphList.put("afii57422", 0x062E);
      glyphList.put("afii57423", 0x062F);
      glyphList.put("afii57424", 0x0630);
      glyphList.put("afii57425", 0x0631);
      glyphList.put("afii57426", 0x0632);
      glyphList.put("afii57427", 0x0633);
      glyphList.put("afii57428", 0x0634);
      glyphList.put("afii57429", 0x0635);
      glyphList.put("afii57430", 0x0636);
      glyphList.put("afii57431", 0x0637);
      glyphList.put("afii57432", 0x0638);
      glyphList.put("afii57433", 0x0639);
      glyphList.put("afii57434", 0x063A);
      glyphList.put("afii57440", 0x0640);
      glyphList.put("afii57441", 0x0641);
      glyphList.put("afii57442", 0x0642);
      glyphList.put("afii57443", 0x0643);
      glyphList.put("afii57444", 0x0644);
      glyphList.put("afii57445", 0x0645);
      glyphList.put("afii57446", 0x0646);
      glyphList.put("afii57448", 0x0648);
      glyphList.put("afii57449", 0x0649);
      glyphList.put("afii57450", 0x064A);
      glyphList.put("afii57451", 0x064B);
      glyphList.put("afii57452", 0x064C);
      glyphList.put("afii57453", 0x064D);
      glyphList.put("afii57454", 0x064E);
      glyphList.put("afii57455", 0x064F);
      glyphList.put("afii57456", 0x0650);
      glyphList.put("afii57457", 0x0651);
      glyphList.put("afii57458", 0x0652);
      glyphList.put("afii57470", 0x0647);
      glyphList.put("afii57505", 0x06A4);
      glyphList.put("afii57506", 0x067E);
      glyphList.put("afii57507", 0x0686);
      glyphList.put("afii57508", 0x0698);
      glyphList.put("afii57509", 0x06AF);
      glyphList.put("afii57511", 0x0679);
      glyphList.put("afii57512", 0x0688);
      glyphList.put("afii57513", 0x0691);
      glyphList.put("afii57514", 0x06BA);
      glyphList.put("afii57519", 0x06D2);
      glyphList.put("afii57534", 0x06D5);
      glyphList.put("afii57636", 0x20AA);
      glyphList.put("afii57645", 0x05BE);
      glyphList.put("afii57658", 0x05C3);
      glyphList.put("afii57664", 0x05D0);
      glyphList.put("afii57665", 0x05D1);
      glyphList.put("afii57666", 0x05D2);
      glyphList.put("afii57667", 0x05D3);
      glyphList.put("afii57668", 0x05D4);
      glyphList.put("afii57669", 0x05D5);
      glyphList.put("afii57670", 0x05D6);
      glyphList.put("afii57671", 0x05D7);
      glyphList.put("afii57672", 0x05D8);
      glyphList.put("afii57673", 0x05D9);
      glyphList.put("afii57674", 0x05DA);
      glyphList.put("afii57675", 0x05DB);
      glyphList.put("afii57676", 0x05DC);
      glyphList.put("afii57677", 0x05DD);
      glyphList.put("afii57678", 0x05DE);
      glyphList.put("afii57679", 0x05DF);
      glyphList.put("afii57680", 0x05E0);
      glyphList.put("afii57681", 0x05E1);
      glyphList.put("afii57682", 0x05E2);
      glyphList.put("afii57683", 0x05E3);
      glyphList.put("afii57684", 0x05E4);
      glyphList.put("afii57685", 0x05E5);
      glyphList.put("afii57686", 0x05E6);
      glyphList.put("afii57687", 0x05E7);
      glyphList.put("afii57688", 0x05E8);
      glyphList.put("afii57689", 0x05E9);
      glyphList.put("afii57690", 0x05EA);
      glyphList.put("afii57694", 0xFB2A);
      glyphList.put("afii57695", 0xFB2B);
      glyphList.put("afii57700", 0xFB4B);
      glyphList.put("afii57705", 0xFB1F);
      glyphList.put("afii57716", 0x05F0);
      glyphList.put("afii57717", 0x05F1);
      glyphList.put("afii57718", 0x05F2);
      glyphList.put("afii57723", 0xFB35);
      glyphList.put("afii57793", 0x05B4);
      glyphList.put("afii57794", 0x05B5);
      glyphList.put("afii57795", 0x05B6);
      glyphList.put("afii57796", 0x05BB);
      glyphList.put("afii57797", 0x05B8);
      glyphList.put("afii57798", 0x05B7);
      glyphList.put("afii57799", 0x05B0);
      glyphList.put("afii57800", 0x05B2);
      glyphList.put("afii57801", 0x05B1);
      glyphList.put("afii57802", 0x05B3);
      glyphList.put("afii57803", 0x05C2);
      glyphList.put("afii57804", 0x05C1);
      glyphList.put("afii57806", 0x05B9);
      glyphList.put("afii57807", 0x05BC);
      glyphList.put("afii57839", 0x05BD);
      glyphList.put("afii57841", 0x05BF);
      glyphList.put("afii57842", 0x05C0);
      glyphList.put("afii57929", 0x02BC);
      glyphList.put("afii61248", 0x2105);
      glyphList.put("afii61289", 0x2113);
      glyphList.put("afii61352", 0x2116);
      glyphList.put("afii61573", 0x202C);
      glyphList.put("afii61574", 0x202D);
      glyphList.put("afii61575", 0x202E);
      glyphList.put("afii61664", 0x200C);
      glyphList.put("afii63167", 0x066D);
      glyphList.put("afii64937", 0x02BD);
      glyphList.put("agrave", 0x00E0);
      glyphList.put("agujarati", 0x0A85);
      glyphList.put("agurmukhi", 0x0A05);
      glyphList.put("ahiragana", 0x3042);
      glyphList.put("ahookabove", 0x1EA3);
      glyphList.put("aibengali", 0x0990);
      glyphList.put("aibopomofo", 0x311E);
      glyphList.put("aideva", 0x0910);
      glyphList.put("aiecyrillic", 0x04D5);
      glyphList.put("aigujarati", 0x0A90);
      glyphList.put("aigurmukhi", 0x0A10);
      glyphList.put("aimatragurmukhi", 0x0A48);
      glyphList.put("ainarabic", 0x0639);
      glyphList.put("ainfinalarabic", 0xFECA);
      glyphList.put("aininitialarabic", 0xFECB);
      glyphList.put("ainmedialarabic", 0xFECC);
      glyphList.put("ainvertedbreve", 0x0203);
      glyphList.put("aivowelsignbengali", 0x09C8);
      glyphList.put("aivowelsigndeva", 0x0948);
      glyphList.put("aivowelsigngujarati", 0x0AC8);
      glyphList.put("akatakana", 0x30A2);
      glyphList.put("akatakanahalfwidth", 0xFF71);
      glyphList.put("akorean", 0x314F);
      glyphList.put("alef", 0x05D0);
      glyphList.put("alefarabic", 0x0627);
      glyphList.put("alefdageshhebrew", 0xFB30);
      glyphList.put("aleffinalarabic", 0xFE8E);
      glyphList.put("alefhamzaabovearabic", 0x0623);
      glyphList.put("alefhamzaabovefinalarabic", 0xFE84);
      glyphList.put("alefhamzabelowarabic", 0x0625);
      glyphList.put("alefhamzabelowfinalarabic", 0xFE88);
      glyphList.put("alefhebrew", 0x05D0);
      glyphList.put("aleflamedhebrew", 0xFB4F);
      glyphList.put("alefmaddaabovearabic", 0x0622);
      glyphList.put("alefmaddaabovefinalarabic", 0xFE82);
      glyphList.put("alefmaksuraarabic", 0x0649);
      glyphList.put("alefmaksurafinalarabic", 0xFEF0);
      glyphList.put("alefmaksurainitialarabic", 0xFEF3);
      glyphList.put("alefmaksuramedialarabic", 0xFEF4);
      glyphList.put("alefpatahhebrew", 0xFB2E);
      glyphList.put("alefqamatshebrew", 0xFB2F);
      glyphList.put("aleph", 0x2135);
      glyphList.put("allequal", 0x224C);
      glyphList.put("alpha", 0x03B1);
      glyphList.put("alphatonos", 0x03AC);
      glyphList.put("amacron", 0x0101);
      glyphList.put("amonospace", 0xFF41);
      glyphList.put("ampersand", 0x0026);
      glyphList.put("ampersandmonospace", 0xFF06);
      glyphList.put("ampersandsmall", 0xF726);
      glyphList.put("amsquare", 0x33C2);
      glyphList.put("anbopomofo", 0x3122);
      glyphList.put("angbopomofo", 0x3124);
      glyphList.put("angkhankhuthai", 0x0E5A);
      glyphList.put("angle", 0x2220);
      glyphList.put("anglebracketleft", 0x3008);
      glyphList.put("anglebracketleftvertical", 0xFE3F);
      glyphList.put("anglebracketright", 0x3009);
      glyphList.put("anglebracketrightvertical", 0xFE40);
      glyphList.put("angleleft", 0x2329);
      glyphList.put("angleright", 0x232A);
      glyphList.put("angstrom", 0x212B);
      glyphList.put("anoteleia", 0x0387);
      glyphList.put("anudattadeva", 0x0952);
      glyphList.put("anusvarabengali", 0x0982);
      glyphList.put("anusvaradeva", 0x0902);
      glyphList.put("anusvaragujarati", 0x0A82);
      glyphList.put("aogonek", 0x0105);
      glyphList.put("apaatosquare", 0x3300);
      glyphList.put("aparen", 0x249C);
      glyphList.put("apostrophearmenian", 0x055A);
      glyphList.put("apostrophemod", 0x02BC);
      glyphList.put("apple", 0xF8FF);
      glyphList.put("approaches", 0x2250);
      glyphList.put("approxequal", 0x2248);
      glyphList.put("approxequalorimage", 0x2252);
      glyphList.put("approximatelyequal", 0x2245);
      glyphList.put("araeaekorean", 0x318E);
      glyphList.put("araeakorean", 0x318D);
      glyphList.put("arc", 0x2312);
      glyphList.put("arighthalfring", 0x1E9A);
      glyphList.put("aring", 0x00E5);
      glyphList.put("aringacute", 0x01FB);
      glyphList.put("aringbelow", 0x1E01);
      glyphList.put("arrowboth", 0x2194);
      glyphList.put("arrowdashdown", 0x21E3);
      glyphList.put("arrowdashleft", 0x21E0);
      glyphList.put("arrowdashright", 0x21E2);
      glyphList.put("arrowdashup", 0x21E1);
      glyphList.put("arrowdblboth", 0x21D4);
      glyphList.put("arrowdbldown", 0x21D3);
      glyphList.put("arrowdblleft", 0x21D0);
      glyphList.put("arrowdblright", 0x21D2);
      glyphList.put("arrowdblup", 0x21D1);
      glyphList.put("arrowdown", 0x2193);
      glyphList.put("arrowdownleft", 0x2199);
      glyphList.put("arrowdownright", 0x2198);
      glyphList.put("arrowdownwhite", 0x21E9);
      glyphList.put("arrowheaddownmod", 0x02C5);
      glyphList.put("arrowheadleftmod", 0x02C2);
      glyphList.put("arrowheadrightmod", 0x02C3);
      glyphList.put("arrowheadupmod", 0x02C4);
      glyphList.put("arrowhorizex", 0xF8E7);
      glyphList.put("arrowleft", 0x2190);
      glyphList.put("arrowleftdbl", 0x21D0);
      glyphList.put("arrowleftdblstroke", 0x21CD);
      glyphList.put("arrowleftoverright", 0x21C6);
      glyphList.put("arrowleftwhite", 0x21E6);
      glyphList.put("arrowright", 0x2192);
      glyphList.put("arrowrightdblstroke", 0x21CF);
      glyphList.put("arrowrightheavy", 0x279E);
      glyphList.put("arrowrightoverleft", 0x21C4);
      glyphList.put("arrowrightwhite", 0x21E8);
      glyphList.put("arrowtableft", 0x21E4);
      glyphList.put("arrowtabright", 0x21E5);
      glyphList.put("arrowup", 0x2191);
      glyphList.put("arrowupdn", 0x2195);
      glyphList.put("arrowupdnbse", 0x21A8);
      glyphList.put("arrowupdownbase", 0x21A8);
      glyphList.put("arrowupleft", 0x2196);
      glyphList.put("arrowupleftofdown", 0x21C5);
      glyphList.put("arrowupright", 0x2197);
      glyphList.put("arrowupwhite", 0x21E7);
      glyphList.put("arrowvertex", 0xF8E6);
      glyphList.put("asciicircum", 0x005E);
      glyphList.put("asciicircummonospace", 0xFF3E);
      glyphList.put("asciitilde", 0x007E);
      glyphList.put("asciitildemonospace", 0xFF5E);
      glyphList.put("ascript", 0x0251);
      glyphList.put("ascriptturned", 0x0252);
      glyphList.put("asmallhiragana", 0x3041);
      glyphList.put("asmallkatakana", 0x30A1);
      glyphList.put("asmallkatakanahalfwidth", 0xFF67);
      glyphList.put("asterisk", 0x002A);
      glyphList.put("asteriskaltonearabic", 0x066D);
      glyphList.put("asteriskarabic", 0x066D);
      glyphList.put("asteriskmath", 0x2217);
      glyphList.put("asteriskmonospace", 0xFF0A);
      glyphList.put("asterisksmall", 0xFE61);
      glyphList.put("asterism", 0x2042);
      glyphList.put("asuperior", 0xF6E9);
      glyphList.put("asymptoticallyequal", 0x2243);
      glyphList.put("at", 0x0040);
      glyphList.put("atilde", 0x00E3);
      glyphList.put("atmonospace", 0xFF20);
      glyphList.put("atsmall", 0xFE6B);
      glyphList.put("aturned", 0x0250);
      glyphList.put("aubengali", 0x0994);
      glyphList.put("aubopomofo", 0x3120);
      glyphList.put("audeva", 0x0914);
      glyphList.put("augujarati", 0x0A94);
      glyphList.put("augurmukhi", 0x0A14);
      glyphList.put("aulengthmarkbengali", 0x09D7);
      glyphList.put("aumatragurmukhi", 0x0A4C);
      glyphList.put("auvowelsignbengali", 0x09CC);
      glyphList.put("auvowelsigndeva", 0x094C);
      glyphList.put("auvowelsigngujarati", 0x0ACC);
      glyphList.put("avagrahadeva", 0x093D);
      glyphList.put("aybarmenian", 0x0561);
      glyphList.put("ayin", 0x05E2);
      glyphList.put("ayinaltonehebrew", 0xFB20);
      glyphList.put("ayinhebrew", 0x05E2);
      glyphList.put("b", 0x0062);
      glyphList.put("babengali", 0x09AC);
      glyphList.put("backslash", 0x005C);
      glyphList.put("backslashmonospace", 0xFF3C);
      glyphList.put("badeva", 0x092C);
      glyphList.put("bagujarati", 0x0AAC);
      glyphList.put("bagurmukhi", 0x0A2C);
      glyphList.put("bahiragana", 0x3070);
      glyphList.put("bahtthai", 0x0E3F);
      glyphList.put("bakatakana", 0x30D0);
      glyphList.put("bar", 0x007C);
      glyphList.put("barmonospace", 0xFF5C);
      glyphList.put("bbopomofo", 0x3105);
      glyphList.put("bcircle", 0x24D1);
      glyphList.put("bdotaccent", 0x1E03);
      glyphList.put("bdotbelow", 0x1E05);
      glyphList.put("beamedsixteenthnotes", 0x266C);
      glyphList.put("because", 0x2235);
      glyphList.put("becyrillic", 0x0431);
      glyphList.put("beharabic", 0x0628);
      glyphList.put("behfinalarabic", 0xFE90);
      glyphList.put("behinitialarabic", 0xFE91);
      glyphList.put("behiragana", 0x3079);
      glyphList.put("behmedialarabic", 0xFE92);
      glyphList.put("behmeeminitialarabic", 0xFC9F);
      glyphList.put("behmeemisolatedarabic", 0xFC08);
      glyphList.put("behnoonfinalarabic", 0xFC6D);
      glyphList.put("bekatakana", 0x30D9);
      glyphList.put("benarmenian", 0x0562);
      glyphList.put("bet", 0x05D1);
      glyphList.put("beta", 0x03B2);
      glyphList.put("betasymbolgreek", 0x03D0);
      glyphList.put("betdagesh", 0xFB31);
      glyphList.put("betdageshhebrew", 0xFB31);
      glyphList.put("bethebrew", 0x05D1);
      glyphList.put("betrafehebrew", 0xFB4C);
      glyphList.put("bhabengali", 0x09AD);
      glyphList.put("bhadeva", 0x092D);
      glyphList.put("bhagujarati", 0x0AAD);
      glyphList.put("bhagurmukhi", 0x0A2D);
      glyphList.put("bhook", 0x0253);
      glyphList.put("bihiragana", 0x3073);
      glyphList.put("bikatakana", 0x30D3);
      glyphList.put("bilabialclick", 0x0298);
      glyphList.put("bindigurmukhi", 0x0A02);
      glyphList.put("birusquare", 0x3331);
      glyphList.put("blackcircle", 0x25CF);
      glyphList.put("blackdiamond", 0x25C6);
      glyphList.put("blackdownpointingtriangle", 0x25BC);
      glyphList.put("blackleftpointingpointer", 0x25C4);
      glyphList.put("blackleftpointingtriangle", 0x25C0);
      glyphList.put("blacklenticularbracketleft", 0x3010);
      glyphList.put("blacklenticularbracketleftvertical", 0xFE3B);
      glyphList.put("blacklenticularbracketright", 0x3011);
      glyphList.put("blacklenticularbracketrightvertical", 0xFE3C);
      glyphList.put("blacklowerlefttriangle", 0x25E3);
      glyphList.put("blacklowerrighttriangle", 0x25E2);
      glyphList.put("blackrectangle", 0x25AC);
      glyphList.put("blackrightpointingpointer", 0x25BA);
      glyphList.put("blackrightpointingtriangle", 0x25B6);
      glyphList.put("blacksmallsquare", 0x25AA);
      glyphList.put("blacksmilingface", 0x263B);
      glyphList.put("blacksquare", 0x25A0);
      glyphList.put("blackstar", 0x2605);
      glyphList.put("blackupperlefttriangle", 0x25E4);
      glyphList.put("blackupperrighttriangle", 0x25E5);
      glyphList.put("blackuppointingsmalltriangle", 0x25B4);
      glyphList.put("blackuppointingtriangle", 0x25B2);
      glyphList.put("blank", 0x2423);
      glyphList.put("blinebelow", 0x1E07);
      glyphList.put("block", 0x2588);
      glyphList.put("bmonospace", 0xFF42);
      glyphList.put("bobaimaithai", 0x0E1A);
      glyphList.put("bohiragana", 0x307C);
      glyphList.put("bokatakana", 0x30DC);
      glyphList.put("bparen", 0x249D);
      glyphList.put("bqsquare", 0x33C3);
      glyphList.put("braceex", 0xF8F4);
      glyphList.put("braceleft", 0x007B);
      glyphList.put("braceleftbt", 0xF8F3);
      glyphList.put("braceleftmid", 0xF8F2);
      glyphList.put("braceleftmonospace", 0xFF5B);
      glyphList.put("braceleftsmall", 0xFE5B);
      glyphList.put("bracelefttp", 0xF8F1);
      glyphList.put("braceleftvertical", 0xFE37);
      glyphList.put("braceright", 0x007D);
      glyphList.put("bracerightbt", 0xF8FE);
      glyphList.put("bracerightmid", 0xF8FD);
      glyphList.put("bracerightmonospace", 0xFF5D);
      glyphList.put("bracerightsmall", 0xFE5C);
      glyphList.put("bracerighttp", 0xF8FC);
      glyphList.put("bracerightvertical", 0xFE38);
      glyphList.put("bracketleft", 0x005B);
      glyphList.put("bracketleftbt", 0xF8F0);
      glyphList.put("bracketleftex", 0xF8EF);
      glyphList.put("bracketleftmonospace", 0xFF3B);
      glyphList.put("bracketlefttp", 0xF8EE);
      glyphList.put("bracketright", 0x005D);
      glyphList.put("bracketrightbt", 0xF8FB);
      glyphList.put("bracketrightex", 0xF8FA);
      glyphList.put("bracketrightmonospace", 0xFF3D);
      glyphList.put("bracketrighttp", 0xF8F9);
      glyphList.put("breve", 0x02D8);
      glyphList.put("brevebelowcmb", 0x032E);
      glyphList.put("brevecmb", 0x0306);
      glyphList.put("breveinvertedbelowcmb", 0x032F);
      glyphList.put("breveinvertedcmb", 0x0311);
      glyphList.put("breveinverteddoublecmb", 0x0361);
      glyphList.put("bridgebelowcmb", 0x032A);
      glyphList.put("bridgeinvertedbelowcmb", 0x033A);
      glyphList.put("brokenbar", 0x00A6);
      glyphList.put("bstroke", 0x0180);
      glyphList.put("bsuperior", 0xF6EA);
      glyphList.put("btopbar", 0x0183);
      glyphList.put("buhiragana", 0x3076);
      glyphList.put("bukatakana", 0x30D6);
      glyphList.put("bullet", 0x2022);
      glyphList.put("bulletinverse", 0x25D8);
      glyphList.put("bulletoperator", 0x2219);
      glyphList.put("bullseye", 0x25CE);
      glyphList.put("c", 0x0063);
      glyphList.put("caarmenian", 0x056E);
      glyphList.put("cabengali", 0x099A);
      glyphList.put("cacute", 0x0107);
      glyphList.put("cadeva", 0x091A);
      glyphList.put("cagujarati", 0x0A9A);
      glyphList.put("cagurmukhi", 0x0A1A);
      glyphList.put("calsquare", 0x3388);
      glyphList.put("candrabindubengali", 0x0981);
      glyphList.put("candrabinducmb", 0x0310);
      glyphList.put("candrabindudeva", 0x0901);
      glyphList.put("candrabindugujarati", 0x0A81);
      glyphList.put("capslock", 0x21EA);
      glyphList.put("careof", 0x2105);
      glyphList.put("caron", 0x02C7);
      glyphList.put("caronbelowcmb", 0x032C);
      glyphList.put("caroncmb", 0x030C);
      glyphList.put("carriagereturn", 0x21B5);
      glyphList.put("cbopomofo", 0x3118);
      glyphList.put("ccaron", 0x010D);
      glyphList.put("ccedilla", 0x00E7);
      glyphList.put("ccedillaacute", 0x1E09);
      glyphList.put("ccircle", 0x24D2);
      glyphList.put("ccircumflex", 0x0109);
      glyphList.put("ccurl", 0x0255);
      glyphList.put("cdot", 0x010B);
      glyphList.put("cdotaccent", 0x010B);
      glyphList.put("cdsquare", 0x33C5);
      glyphList.put("cedilla", 0x00B8);
      glyphList.put("cedillacmb", 0x0327);
      glyphList.put("cent", 0x00A2);
      glyphList.put("centigrade", 0x2103);
      glyphList.put("centinferior", 0xF6DF);
      glyphList.put("centmonospace", 0xFFE0);
      glyphList.put("centoldstyle", 0xF7A2);
      glyphList.put("centsuperior", 0xF6E0);
      glyphList.put("chaarmenian", 0x0579);
      glyphList.put("chabengali", 0x099B);
      glyphList.put("chadeva", 0x091B);
      glyphList.put("chagujarati", 0x0A9B);
      glyphList.put("chagurmukhi", 0x0A1B);
      glyphList.put("chbopomofo", 0x3114);
      glyphList.put("cheabkhasiancyrillic", 0x04BD);
      glyphList.put("checkmark", 0x2713);
      glyphList.put("checyrillic", 0x0447);
      glyphList.put("chedescenderabkhasiancyrillic", 0x04BF);
      glyphList.put("chedescendercyrillic", 0x04B7);
      glyphList.put("chedieresiscyrillic", 0x04F5);
      glyphList.put("cheharmenian", 0x0573);
      glyphList.put("chekhakassiancyrillic", 0x04CC);
      glyphList.put("cheverticalstrokecyrillic", 0x04B9);
      glyphList.put("chi", 0x03C7);
      glyphList.put("chieuchacirclekorean", 0x3277);
      glyphList.put("chieuchaparenkorean", 0x3217);
      glyphList.put("chieuchcirclekorean", 0x3269);
      glyphList.put("chieuchkorean", 0x314A);
      glyphList.put("chieuchparenkorean", 0x3209);
      glyphList.put("chochangthai", 0x0E0A);
      glyphList.put("chochanthai", 0x0E08);
      glyphList.put("chochingthai", 0x0E09);
      glyphList.put("chochoethai", 0x0E0C);
      glyphList.put("chook", 0x0188);
      glyphList.put("cieucacirclekorean", 0x3276);
      glyphList.put("cieucaparenkorean", 0x3216);
      glyphList.put("cieuccirclekorean", 0x3268);
      glyphList.put("cieuckorean", 0x3148);
      glyphList.put("cieucparenkorean", 0x3208);
      glyphList.put("cieucuparenkorean", 0x321C);
      glyphList.put("circle", 0x25CB);
      glyphList.put("circlemultiply", 0x2297);
      glyphList.put("circleot", 0x2299);
      glyphList.put("circleplus", 0x2295);
      glyphList.put("circlepostalmark", 0x3036);
      glyphList.put("circlewithlefthalfblack", 0x25D0);
      glyphList.put("circlewithrighthalfblack", 0x25D1);
      glyphList.put("circumflex", 0x02C6);
      glyphList.put("circumflexbelowcmb", 0x032D);
      glyphList.put("circumflexcmb", 0x0302);
      glyphList.put("clear", 0x2327);
      glyphList.put("clickalveolar", 0x01C2);
      glyphList.put("clickdental", 0x01C0);
      glyphList.put("clicklateral", 0x01C1);
      glyphList.put("clickretroflex", 0x01C3);
      glyphList.put("club", 0x2663);
      glyphList.put("clubsuitblack", 0x2663);
      glyphList.put("clubsuitwhite", 0x2667);
      glyphList.put("cmcubedsquare", 0x33A4);
      glyphList.put("cmonospace", 0xFF43);
      glyphList.put("cmsquaredsquare", 0x33A0);
      glyphList.put("coarmenian", 0x0581);
      glyphList.put("colon", 0x003A);
      glyphList.put("colonmonetary", 0x20A1);
      glyphList.put("colonmonospace", 0xFF1A);
      glyphList.put("colonsign", 0x20A1);
      glyphList.put("colonsmall", 0xFE55);
      glyphList.put("colontriangularhalfmod", 0x02D1);
      glyphList.put("colontriangularmod", 0x02D0);
      glyphList.put("comma", 0x002C);
      glyphList.put("commaabovecmb", 0x0313);
      glyphList.put("commaaboverightcmb", 0x0315);
      glyphList.put("commaaccent", 0xF6C3);
      glyphList.put("commaarabic", 0x060C);
      glyphList.put("commaarmenian", 0x055D);
      glyphList.put("commainferior", 0xF6E1);
      glyphList.put("commamonospace", 0xFF0C);
      glyphList.put("commareversedabovecmb", 0x0314);
      glyphList.put("commareversedmod", 0x02BD);
      glyphList.put("commasmall", 0xFE50);
      glyphList.put("commasuperior", 0xF6E2);
      glyphList.put("commaturnedabovecmb", 0x0312);
      glyphList.put("commaturnedmod", 0x02BB);
      glyphList.put("compass", 0x263C);
      glyphList.put("congruent", 0x2245);
      glyphList.put("contourintegral", 0x222E);
      glyphList.put("control", 0x2303);
      glyphList.put("controlACK", 0x0006);
      glyphList.put("controlBEL", 0x0007);
      glyphList.put("controlBS", 0x0008);
      glyphList.put("controlCAN", 0x0018);
      glyphList.put("controlCR", 0x000D);
      glyphList.put("controlDC1", 0x0011);
      glyphList.put("controlDC2", 0x0012);
      glyphList.put("controlDC3", 0x0013);
      glyphList.put("controlDC4", 0x0014);
      glyphList.put("controlDEL", 0x007F);
      glyphList.put("controlDLE", 0x0010);
      glyphList.put("controlEM", 0x0019);
      glyphList.put("controlENQ", 0x0005);
      glyphList.put("controlEOT", 0x0004);
      glyphList.put("controlESC", 0x001B);
      glyphList.put("controlETB", 0x0017);
      glyphList.put("controlETX", 0x0003);
      glyphList.put("controlFF", 0x000C);
      glyphList.put("controlFS", 0x001C);
      glyphList.put("controlGS", 0x001D);
      glyphList.put("controlHT", 0x0009);
      glyphList.put("controlLF", 0x000A);
      glyphList.put("controlNAK", 0x0015);
      glyphList.put("controlRS", 0x001E);
      glyphList.put("controlSI", 0x000F);
      glyphList.put("controlSO", 0x000E);
      glyphList.put("controlSOT", 0x0002);
      glyphList.put("controlSTX", 0x0001);
      glyphList.put("controlSUB", 0x001A);
      glyphList.put("controlSYN", 0x0016);
      glyphList.put("controlUS", 0x001F);
      glyphList.put("controlVT", 0x000B);
      glyphList.put("copyright", 0x00A9);
      glyphList.put("copyrightsans", 0xF8E9);
      glyphList.put("copyrightserif", 0xF6D9);
      glyphList.put("cornerbracketleft", 0x300C);
      glyphList.put("cornerbracketlefthalfwidth", 0xFF62);
      glyphList.put("cornerbracketleftvertical", 0xFE41);
      glyphList.put("cornerbracketright", 0x300D);
      glyphList.put("cornerbracketrighthalfwidth", 0xFF63);
      glyphList.put("cornerbracketrightvertical", 0xFE42);
      glyphList.put("corporationsquare", 0x337F);
      glyphList.put("cosquare", 0x33C7);
      glyphList.put("coverkgsquare", 0x33C6);
      glyphList.put("cparen", 0x249E);
      glyphList.put("cruzeiro", 0x20A2);
      glyphList.put("cstretched", 0x0297);
      glyphList.put("curlyand", 0x22CF);
      glyphList.put("curlyor", 0x22CE);
      glyphList.put("currency", 0x00A4);
      glyphList.put("cyrBreve", 0xF6D1);
      glyphList.put("cyrFlex", 0xF6D2);
      glyphList.put("cyrbreve", 0xF6D4);
      glyphList.put("cyrflex", 0xF6D5);
      glyphList.put("d", 0x0064);
      glyphList.put("daarmenian", 0x0564);
      glyphList.put("dabengali", 0x09A6);
      glyphList.put("dadarabic", 0x0636);
      glyphList.put("dadeva", 0x0926);
      glyphList.put("dadfinalarabic", 0xFEBE);
      glyphList.put("dadinitialarabic", 0xFEBF);
      glyphList.put("dadmedialarabic", 0xFEC0);
      glyphList.put("dagesh", 0x05BC);
      glyphList.put("dageshhebrew", 0x05BC);
      glyphList.put("dagger", 0x2020);
      glyphList.put("daggerdbl", 0x2021);
      glyphList.put("dagujarati", 0x0AA6);
      glyphList.put("dagurmukhi", 0x0A26);
      glyphList.put("dahiragana", 0x3060);
      glyphList.put("dakatakana", 0x30C0);
      glyphList.put("dalarabic", 0x062F);
      glyphList.put("dalet", 0x05D3);
      glyphList.put("daletdagesh", 0xFB33);
      glyphList.put("daletdageshhebrew", 0xFB33);
      //glyphList.put("dalethatafpatah", 0x05D3 05B2);
      //glyphList.put("dalethatafpatahhebrew", 0x05D3 05B2);
      //glyphList.put("dalethatafsegol", 0x05D3 05B1);
        //glyphList.put("dalethatafsegolhebrew", 0x05D3 05B1);
      glyphList.put("dalethebrew", 0x05D3);
        //glyphList.put("dalethiriq", 0x05D3 05B4);
        //glyphList.put("dalethiriqhebrew", 0x05D3 05B4);
        //glyphList.put("daletholam", 0x05D3 05B9);
        //glyphList.put("daletholamhebrew", 0x05D3 05B9);
        //glyphList.put("daletpatah", 0x05D3 05B7);
        //glyphList.put("daletpatahhebrew", 0x05D3 05B7);
        //glyphList.put("daletqamats", 0x05D3 05B8);
        //glyphList.put("daletqamatshebrew", 0x05D3 05B8);
        //glyphList.put("daletqubuts", 0x05D3 05BB);
        //glyphList.put("daletqubutshebrew", 0x05D3 05BB);
        //glyphList.put("daletsegol", 0x05D3 05B6);
        //glyphList.put("daletsegolhebrew", 0x05D3 05B6);
        //glyphList.put("daletsheva", 0x05D3 05B0);
        //glyphList.put("daletshevahebrew", 0x05D3 05B0);
        //glyphList.put("dalettsere", 0x05D3 05B5);
        //glyphList.put("dalettserehebrew", 0x05D3 05B5);
      glyphList.put("dalfinalarabic", 0xFEAA);
      glyphList.put("dammaarabic", 0x064F);
      glyphList.put("dammalowarabic", 0x064F);
      glyphList.put("dammatanaltonearabic", 0x064C);
      glyphList.put("dammatanarabic", 0x064C);
      glyphList.put("danda", 0x0964);
      glyphList.put("dargahebrew", 0x05A7);
      glyphList.put("dargalefthebrew", 0x05A7);
      glyphList.put("dasiapneumatacyrilliccmb", 0x0485);
      glyphList.put("dblGrave", 0xF6D3);
      glyphList.put("dblanglebracketleft", 0x300A);
      glyphList.put("dblanglebracketleftvertical", 0xFE3D);
      glyphList.put("dblanglebracketright", 0x300B);
      glyphList.put("dblanglebracketrightvertical", 0xFE3E);
      glyphList.put("dblarchinvertedbelowcmb", 0x032B);
      glyphList.put("dblarrowleft", 0x21D4);
      glyphList.put("dblarrowright", 0x21D2);
      glyphList.put("dbldanda", 0x0965);
      glyphList.put("dblgrave", 0xF6D6);
      glyphList.put("dblgravecmb", 0x030F);
      glyphList.put("dblintegral", 0x222C);
      glyphList.put("dbllowline", 0x2017);
      glyphList.put("dbllowlinecmb", 0x0333);
      glyphList.put("dbloverlinecmb", 0x033F);
      glyphList.put("dblprimemod", 0x02BA);
      glyphList.put("dblverticalbar", 0x2016);
      glyphList.put("dblverticallineabovecmb", 0x030E);
      glyphList.put("dbopomofo", 0x3109);
      glyphList.put("dbsquare", 0x33C8);
      glyphList.put("dcaron", 0x010F);
      glyphList.put("dcedilla", 0x1E11);
      glyphList.put("dcircle", 0x24D3);
      glyphList.put("dcircumflexbelow", 0x1E13);
      glyphList.put("dcroat", 0x0111);
      glyphList.put("ddabengali", 0x09A1);
      glyphList.put("ddadeva", 0x0921);
      glyphList.put("ddagujarati", 0x0AA1);
      glyphList.put("ddagurmukhi", 0x0A21);
      glyphList.put("ddalarabic", 0x0688);
      glyphList.put("ddalfinalarabic", 0xFB89);
      glyphList.put("dddhadeva", 0x095C);
      glyphList.put("ddhabengali", 0x09A2);
      glyphList.put("ddhadeva", 0x0922);
      glyphList.put("ddhagujarati", 0x0AA2);
      glyphList.put("ddhagurmukhi", 0x0A22);
      glyphList.put("ddotaccent", 0x1E0B);
      glyphList.put("ddotbelow", 0x1E0D);
      glyphList.put("decimalseparatorarabic", 0x066B);
      glyphList.put("decimalseparatorpersian", 0x066B);
      glyphList.put("decyrillic", 0x0434);
      glyphList.put("degree", 0x00B0);
      glyphList.put("dehihebrew", 0x05AD);
      glyphList.put("dehiragana", 0x3067);
      glyphList.put("deicoptic", 0x03EF);
      glyphList.put("dekatakana", 0x30C7);
      glyphList.put("deleteleft", 0x232B);
      glyphList.put("deleteright", 0x2326);
      glyphList.put("delta", 0x03B4);
      glyphList.put("deltaturned", 0x018D);
      glyphList.put("denominatorminusonenumeratorbengali", 0x09F8);
      glyphList.put("dezh", 0x02A4);
      glyphList.put("dhabengali", 0x09A7);
      glyphList.put("dhadeva", 0x0927);
      glyphList.put("dhagujarati", 0x0AA7);
      glyphList.put("dhagurmukhi", 0x0A27);
      glyphList.put("dhook", 0x0257);
      glyphList.put("dialytikatonos", 0x0385);
      glyphList.put("dialytikatonoscmb", 0x0344);
      glyphList.put("diamond", 0x2666);
      glyphList.put("diamondsuitwhite", 0x2662);
      glyphList.put("dieresis", 0x00A8);
      glyphList.put("dieresisacute", 0xF6D7);
      glyphList.put("dieresisbelowcmb", 0x0324);
      glyphList.put("dieresiscmb", 0x0308);
      glyphList.put("dieresisgrave", 0xF6D8);
      glyphList.put("dieresistonos", 0x0385);
      glyphList.put("dihiragana", 0x3062);
      glyphList.put("dikatakana", 0x30C2);
      glyphList.put("dittomark", 0x3003);
      glyphList.put("divide", 0x00F7);
      glyphList.put("divides", 0x2223);
      glyphList.put("divisionslash", 0x2215);
      glyphList.put("djecyrillic", 0x0452);
      glyphList.put("dkshade", 0x2593);
      glyphList.put("dlinebelow", 0x1E0F);
      glyphList.put("dlsquare", 0x3397);
      glyphList.put("dmacron", 0x0111);
      glyphList.put("dmonospace", 0xFF44);
      glyphList.put("dnblock", 0x2584);
      glyphList.put("dochadathai", 0x0E0E);
      glyphList.put("dodekthai", 0x0E14);
      glyphList.put("dohiragana", 0x3069);
      glyphList.put("dokatakana", 0x30C9);
      glyphList.put("dollar", 0x0024);
      glyphList.put("dollarinferior", 0xF6E3);
      glyphList.put("dollarmonospace", 0xFF04);
      glyphList.put("dollaroldstyle", 0xF724);
      glyphList.put("dollarsmall", 0xFE69);
      glyphList.put("dollarsuperior", 0xF6E4);
      glyphList.put("dong", 0x20AB);
      glyphList.put("dorusquare", 0x3326);
      glyphList.put("dotaccent", 0x02D9);
      glyphList.put("dotaccentcmb", 0x0307);
      glyphList.put("dotbelowcmb", 0x0323);
      glyphList.put("dotbelowcomb", 0x0323);
      glyphList.put("dotkatakana", 0x30FB);
      glyphList.put("dotlessi", 0x0131);
      glyphList.put("dotlessj", 0xF6BE);
      glyphList.put("dotlessjstrokehook", 0x0284);
      glyphList.put("dotmath", 0x22C5);
      glyphList.put("dottedcircle", 0x25CC);
      glyphList.put("doubleyodpatah", 0xFB1F);
      glyphList.put("doubleyodpatahhebrew", 0xFB1F);
      glyphList.put("downtackbelowcmb", 0x031E);
      glyphList.put("downtackmod", 0x02D5);
      glyphList.put("dparen", 0x249F);
      glyphList.put("dsuperior", 0xF6EB);
      glyphList.put("dtail", 0x0256);
      glyphList.put("dtopbar", 0x018C);
      glyphList.put("duhiragana", 0x3065);
      glyphList.put("dukatakana", 0x30C5);
      glyphList.put("dz", 0x01F3);
      glyphList.put("dzaltone", 0x02A3);
      glyphList.put("dzcaron", 0x01C6);
      glyphList.put("dzcurl", 0x02A5);
      glyphList.put("dzeabkhasiancyrillic", 0x04E1);
      glyphList.put("dzecyrillic", 0x0455);
      glyphList.put("dzhecyrillic", 0x045F);
      glyphList.put("e", 0x0065);
      glyphList.put("eacute", 0x00E9);
      glyphList.put("earth", 0x2641);
      glyphList.put("ebengali", 0x098F);
      glyphList.put("ebopomofo", 0x311C);
      glyphList.put("ebreve", 0x0115);
      glyphList.put("ecandradeva", 0x090D);
      glyphList.put("ecandragujarati", 0x0A8D);
      glyphList.put("ecandravowelsigndeva", 0x0945);
      glyphList.put("ecandravowelsigngujarati", 0x0AC5);
      glyphList.put("ecaron", 0x011B);
      glyphList.put("ecedillabreve", 0x1E1D);
      glyphList.put("echarmenian", 0x0565);
      glyphList.put("echyiwnarmenian", 0x0587);
      glyphList.put("ecircle", 0x24D4);
      glyphList.put("ecircumflex", 0x00EA);
      glyphList.put("ecircumflexacute", 0x1EBF);
      glyphList.put("ecircumflexbelow", 0x1E19);
      glyphList.put("ecircumflexdotbelow", 0x1EC7);
      glyphList.put("ecircumflexgrave", 0x1EC1);
      glyphList.put("ecircumflexhookabove", 0x1EC3);
      glyphList.put("ecircumflextilde", 0x1EC5);
      glyphList.put("ecyrillic", 0x0454);
      glyphList.put("edblgrave", 0x0205);
      glyphList.put("edeva", 0x090F);
      glyphList.put("edieresis", 0x00EB);
      glyphList.put("edot", 0x0117);
      glyphList.put("edotaccent", 0x0117);
      glyphList.put("edotbelow", 0x1EB9);
      glyphList.put("eegurmukhi", 0x0A0F);
      glyphList.put("eematragurmukhi", 0x0A47);
      glyphList.put("efcyrillic", 0x0444);
      glyphList.put("egrave", 0x00E8);
      glyphList.put("egujarati", 0x0A8F);
      glyphList.put("eharmenian", 0x0567);
      glyphList.put("ehbopomofo", 0x311D);
      glyphList.put("ehiragana", 0x3048);
      glyphList.put("ehookabove", 0x1EBB);
      glyphList.put("eibopomofo", 0x311F);
      glyphList.put("eight", 0x0038);
      glyphList.put("eightarabic", 0x0668);
      glyphList.put("eightbengali", 0x09EE);
      glyphList.put("eightcircle", 0x2467);
      glyphList.put("eightcircleinversesansserif", 0x2791);
      glyphList.put("eightdeva", 0x096E);
      glyphList.put("eighteencircle", 0x2471);
      glyphList.put("eighteenparen", 0x2485);
      glyphList.put("eighteenperiod", 0x2499);
      glyphList.put("eightgujarati", 0x0AEE);
      glyphList.put("eightgurmukhi", 0x0A6E);
      glyphList.put("eighthackarabic", 0x0668);
      glyphList.put("eighthangzhou", 0x3028);
      glyphList.put("eighthnotebeamed", 0x266B);
      glyphList.put("eightideographicparen", 0x3227);
      glyphList.put("eightinferior", 0x2088);
      glyphList.put("eightmonospace", 0xFF18);
      glyphList.put("eightoldstyle", 0xF738);
      glyphList.put("eightparen", 0x247B);
      glyphList.put("eightperiod", 0x248F);
      glyphList.put("eightpersian", 0x06F8);
      glyphList.put("eightroman", 0x2177);
      glyphList.put("eightsuperior", 0x2078);
      glyphList.put("eightthai", 0x0E58);
      glyphList.put("einvertedbreve", 0x0207);
      glyphList.put("eiotifiedcyrillic", 0x0465);
      glyphList.put("ekatakana", 0x30A8);
      glyphList.put("ekatakanahalfwidth", 0xFF74);
      glyphList.put("ekonkargurmukhi", 0x0A74);
      glyphList.put("ekorean", 0x3154);
      glyphList.put("elcyrillic", 0x043B);
      glyphList.put("element", 0x2208);
      glyphList.put("elevencircle", 0x246A);
      glyphList.put("elevenparen", 0x247E);
      glyphList.put("elevenperiod", 0x2492);
      glyphList.put("elevenroman", 0x217A);
      glyphList.put("ellipsis", 0x2026);
      glyphList.put("ellipsisvertical", 0x22EE);
      glyphList.put("emacron", 0x0113);
      glyphList.put("emacronacute", 0x1E17);
      glyphList.put("emacrongrave", 0x1E15);
      glyphList.put("emcyrillic", 0x043C);
      glyphList.put("emdash", 0x2014);
      glyphList.put("emdashvertical", 0xFE31);
      glyphList.put("emonospace", 0xFF45);
      glyphList.put("emphasismarkarmenian", 0x055B);
      glyphList.put("emptyset", 0x2205);
      glyphList.put("enbopomofo", 0x3123);
      glyphList.put("encyrillic", 0x043D);
      glyphList.put("endash", 0x2013);
      glyphList.put("endashvertical", 0xFE32);
      glyphList.put("endescendercyrillic", 0x04A3);
      glyphList.put("eng", 0x014B);
      glyphList.put("engbopomofo", 0x3125);
      glyphList.put("enghecyrillic", 0x04A5);
      glyphList.put("enhookcyrillic", 0x04C8);
      glyphList.put("enspace", 0x2002);
      glyphList.put("eogonek", 0x0119);
      glyphList.put("eokorean", 0x3153);
      glyphList.put("eopen", 0x025B);
      glyphList.put("eopenclosed", 0x029A);
      glyphList.put("eopenreversed", 0x025C);
      glyphList.put("eopenreversedclosed", 0x025E);
      glyphList.put("eopenreversedhook", 0x025D);
      glyphList.put("eparen", 0x24A0);
      glyphList.put("epsilon", 0x03B5);
      glyphList.put("epsilontonos", 0x03AD);
      glyphList.put("equal", 0x003D);
      glyphList.put("equalmonospace", 0xFF1D);
      glyphList.put("equalsmall", 0xFE66);
      glyphList.put("equalsuperior", 0x207C);
      glyphList.put("equivalence", 0x2261);
      glyphList.put("erbopomofo", 0x3126);
      glyphList.put("ercyrillic", 0x0440);
      glyphList.put("ereversed", 0x0258);
      glyphList.put("ereversedcyrillic", 0x044D);
      glyphList.put("escyrillic", 0x0441);
      glyphList.put("esdescendercyrillic", 0x04AB);
      glyphList.put("esh", 0x0283);
      glyphList.put("eshcurl", 0x0286);
      glyphList.put("eshortdeva", 0x090E);
      glyphList.put("eshortvowelsigndeva", 0x0946);
      glyphList.put("eshreversedloop", 0x01AA);
      glyphList.put("eshsquatreversed", 0x0285);
      glyphList.put("esmallhiragana", 0x3047);
      glyphList.put("esmallkatakana", 0x30A7);
      glyphList.put("esmallkatakanahalfwidth", 0xFF6A);
      glyphList.put("estimated", 0x212E);
      glyphList.put("esuperior", 0xF6EC);
      glyphList.put("eta", 0x03B7);
      glyphList.put("etarmenian", 0x0568);
      glyphList.put("etatonos", 0x03AE);
      glyphList.put("eth", 0x00F0);
      glyphList.put("etilde", 0x1EBD);
      glyphList.put("etildebelow", 0x1E1B);
      glyphList.put("etnahtafoukhhebrew", 0x0591);
      glyphList.put("etnahtafoukhlefthebrew", 0x0591);
      glyphList.put("etnahtahebrew", 0x0591);
      glyphList.put("etnahtalefthebrew", 0x0591);
      glyphList.put("eturned", 0x01DD);
      glyphList.put("eukorean", 0x3161);
      glyphList.put("euro", 0x20AC);
      glyphList.put("evowelsignbengali", 0x09C7);
      glyphList.put("evowelsigndeva", 0x0947);
      glyphList.put("evowelsigngujarati", 0x0AC7);
      glyphList.put("exclam", 0x0021);
      glyphList.put("exclamarmenian", 0x055C);
      glyphList.put("exclamdbl", 0x203C);
      glyphList.put("exclamdown", 0x00A1);
      glyphList.put("exclamdownsmall", 0xF7A1);
      glyphList.put("exclammonospace", 0xFF01);
      glyphList.put("exclamsmall", 0xF721);
      glyphList.put("existential", 0x2203);
      glyphList.put("ezh", 0x0292);
      glyphList.put("ezhcaron", 0x01EF);
      glyphList.put("ezhcurl", 0x0293);
      glyphList.put("ezhreversed", 0x01B9);
      glyphList.put("ezhtail", 0x01BA);
      glyphList.put("f", 0x0066);
      glyphList.put("fadeva", 0x095E);
      glyphList.put("fagurmukhi", 0x0A5E);
      glyphList.put("fahrenheit", 0x2109);
      glyphList.put("fathaarabic", 0x064E);
      glyphList.put("fathalowarabic", 0x064E);
      glyphList.put("fathatanarabic", 0x064B);
      glyphList.put("fbopomofo", 0x3108);
      glyphList.put("fcircle", 0x24D5);
      glyphList.put("fdotaccent", 0x1E1F);
      glyphList.put("feharabic", 0x0641);
      glyphList.put("feharmenian", 0x0586);
      glyphList.put("fehfinalarabic", 0xFED2);
      glyphList.put("fehinitialarabic", 0xFED3);
      glyphList.put("fehmedialarabic", 0xFED4);
      glyphList.put("feicoptic", 0x03E5);
      glyphList.put("female", 0x2640);
      glyphList.put("ff", 0xFB00);
      glyphList.put("ffi", 0xFB03);
      glyphList.put("ffl", 0xFB04);
      glyphList.put("fi", 0xFB01);
      glyphList.put("fifteencircle", 0x246E);
      glyphList.put("fifteenparen", 0x2482);
      glyphList.put("fifteenperiod", 0x2496);
      glyphList.put("figuredash", 0x2012);
      glyphList.put("filledbox", 0x25A0);
      glyphList.put("filledrect", 0x25AC);
      glyphList.put("finalkaf", 0x05DA);
      glyphList.put("finalkafdagesh", 0xFB3A);
      glyphList.put("finalkafdageshhebrew", 0xFB3A);
      glyphList.put("finalkafhebrew", 0x05DA);
        //glyphList.put("finalkafqamats", 0x05DA 05B8);
        //glyphList.put("finalkafqamatshebrew", 0x05DA 05B8);
        //glyphList.put("finalkafsheva", 0x05DA 05B0);
        //glyphList.put("finalkafshevahebrew", 0x05DA 05B0);
      glyphList.put("finalmem", 0x05DD);
      glyphList.put("finalmemhebrew", 0x05DD);
      glyphList.put("finalnun", 0x05DF);
      glyphList.put("finalnunhebrew", 0x05DF);
      glyphList.put("finalpe", 0x05E3);
      glyphList.put("finalpehebrew", 0x05E3);
      glyphList.put("finaltsadi", 0x05E5);
      glyphList.put("finaltsadihebrew", 0x05E5);
      glyphList.put("firsttonechinese", 0x02C9);
      glyphList.put("fisheye", 0x25C9);
      glyphList.put("fitacyrillic", 0x0473);
      glyphList.put("five", 0x0035);
      glyphList.put("fivearabic", 0x0665);
      glyphList.put("fivebengali", 0x09EB);
      glyphList.put("fivecircle", 0x2464);
      glyphList.put("fivecircleinversesansserif", 0x278E);
      glyphList.put("fivedeva", 0x096B);
      glyphList.put("fiveeighths", 0x215D);
      glyphList.put("fivegujarati", 0x0AEB);
      glyphList.put("fivegurmukhi", 0x0A6B);
      glyphList.put("fivehackarabic", 0x0665);
      glyphList.put("fivehangzhou", 0x3025);
      glyphList.put("fiveideographicparen", 0x3224);
      glyphList.put("fiveinferior", 0x2085);
      glyphList.put("fivemonospace", 0xFF15);
      glyphList.put("fiveoldstyle", 0xF735);
      glyphList.put("fiveparen", 0x2478);
      glyphList.put("fiveperiod", 0x248C);
      glyphList.put("fivepersian", 0x06F5);
      glyphList.put("fiveroman", 0x2174);
      glyphList.put("fivesuperior", 0x2075);
      glyphList.put("fivethai", 0x0E55);
      glyphList.put("fl", 0xFB02);
      glyphList.put("florin", 0x0192);
      glyphList.put("fmonospace", 0xFF46);
      glyphList.put("fmsquare", 0x3399);
      glyphList.put("fofanthai", 0x0E1F);
      glyphList.put("fofathai", 0x0E1D);
      glyphList.put("fongmanthai", 0x0E4F);
      glyphList.put("forall", 0x2200);
      glyphList.put("four", 0x0034);
      glyphList.put("fourarabic", 0x0664);
      glyphList.put("fourbengali", 0x09EA);
      glyphList.put("fourcircle", 0x2463);
      glyphList.put("fourcircleinversesansserif", 0x278D);
      glyphList.put("fourdeva", 0x096A);
      glyphList.put("fourgujarati", 0x0AEA);
      glyphList.put("fourgurmukhi", 0x0A6A);
      glyphList.put("fourhackarabic", 0x0664);
      glyphList.put("fourhangzhou", 0x3024);
      glyphList.put("fourideographicparen", 0x3223);
      glyphList.put("fourinferior", 0x2084);
      glyphList.put("fourmonospace", 0xFF14);
      glyphList.put("fournumeratorbengali", 0x09F7);
      glyphList.put("fouroldstyle", 0xF734);
      glyphList.put("fourparen", 0x2477);
      glyphList.put("fourperiod", 0x248B);
      glyphList.put("fourpersian", 0x06F4);
      glyphList.put("fourroman", 0x2173);
      glyphList.put("foursuperior", 0x2074);
      glyphList.put("fourteencircle", 0x246D);
      glyphList.put("fourteenparen", 0x2481);
      glyphList.put("fourteenperiod", 0x2495);
      glyphList.put("fourthai", 0x0E54);
      glyphList.put("fourthtonechinese", 0x02CB);
      glyphList.put("fparen", 0x24A1);
      glyphList.put("fraction", 0x2044);
      glyphList.put("franc", 0x20A3);
      glyphList.put("g", 0x0067);
      glyphList.put("gabengali", 0x0997);
      glyphList.put("gacute", 0x01F5);
      glyphList.put("gadeva", 0x0917);
      glyphList.put("gafarabic", 0x06AF);
      glyphList.put("gaffinalarabic", 0xFB93);
      glyphList.put("gafinitialarabic", 0xFB94);
      glyphList.put("gafmedialarabic", 0xFB95);
      glyphList.put("gagujarati", 0x0A97);
      glyphList.put("gagurmukhi", 0x0A17);
      glyphList.put("gahiragana", 0x304C);
      glyphList.put("gakatakana", 0x30AC);
      glyphList.put("gamma", 0x03B3);
      glyphList.put("gammalatinsmall", 0x0263);
      glyphList.put("gammasuperior", 0x02E0);
      glyphList.put("gangiacoptic", 0x03EB);
      glyphList.put("gbopomofo", 0x310D);
      glyphList.put("gbreve", 0x011F);
      glyphList.put("gcaron", 0x01E7);
      glyphList.put("gcedilla", 0x0123);
      glyphList.put("gcircle", 0x24D6);
      glyphList.put("gcircumflex", 0x011D);
      glyphList.put("gcommaaccent", 0x0123);
      glyphList.put("gdot", 0x0121);
      glyphList.put("gdotaccent", 0x0121);
      glyphList.put("gecyrillic", 0x0433);
      glyphList.put("gehiragana", 0x3052);
      glyphList.put("gekatakana", 0x30B2);
      glyphList.put("geometricallyequal", 0x2251);
      glyphList.put("gereshaccenthebrew", 0x059C);
      glyphList.put("gereshhebrew", 0x05F3);
      glyphList.put("gereshmuqdamhebrew", 0x059D);
      glyphList.put("germandbls", 0x00DF);
      glyphList.put("gershayimaccenthebrew", 0x059E);
      glyphList.put("gershayimhebrew", 0x05F4);
      glyphList.put("getamark", 0x3013);
      glyphList.put("ghabengali", 0x0998);
      glyphList.put("ghadarmenian", 0x0572);
      glyphList.put("ghadeva", 0x0918);
      glyphList.put("ghagujarati", 0x0A98);
      glyphList.put("ghagurmukhi", 0x0A18);
      glyphList.put("ghainarabic", 0x063A);
      glyphList.put("ghainfinalarabic", 0xFECE);
      glyphList.put("ghaininitialarabic", 0xFECF);
      glyphList.put("ghainmedialarabic", 0xFED0);
      glyphList.put("ghemiddlehookcyrillic", 0x0495);
      glyphList.put("ghestrokecyrillic", 0x0493);
      glyphList.put("gheupturncyrillic", 0x0491);
      glyphList.put("ghhadeva", 0x095A);
      glyphList.put("ghhagurmukhi", 0x0A5A);
      glyphList.put("ghook", 0x0260);
      glyphList.put("ghzsquare", 0x3393);
      glyphList.put("gihiragana", 0x304E);
      glyphList.put("gikatakana", 0x30AE);
      glyphList.put("gimarmenian", 0x0563);
      glyphList.put("gimel", 0x05D2);
      glyphList.put("gimeldagesh", 0xFB32);
      glyphList.put("gimeldageshhebrew", 0xFB32);
      glyphList.put("gimelhebrew", 0x05D2);
      glyphList.put("gjecyrillic", 0x0453);
      glyphList.put("glottalinvertedstroke", 0x01BE);
      glyphList.put("glottalstop", 0x0294);
      glyphList.put("glottalstopinverted", 0x0296);
      glyphList.put("glottalstopmod", 0x02C0);
      glyphList.put("glottalstopreversed", 0x0295);
      glyphList.put("glottalstopreversedmod", 0x02C1);
      glyphList.put("glottalstopreversedsuperior", 0x02E4);
      glyphList.put("glottalstopstroke", 0x02A1);
      glyphList.put("glottalstopstrokereversed", 0x02A2);
      glyphList.put("gmacron", 0x1E21);
      glyphList.put("gmonospace", 0xFF47);
      glyphList.put("gohiragana", 0x3054);
      glyphList.put("gokatakana", 0x30B4);
      glyphList.put("gparen", 0x24A2);
      glyphList.put("gpasquare", 0x33AC);
      glyphList.put("gradient", 0x2207);
      glyphList.put("grave", 0x0060);
      glyphList.put("gravebelowcmb", 0x0316);
      glyphList.put("gravecmb", 0x0300);
      glyphList.put("gravecomb", 0x0300);
      glyphList.put("gravedeva", 0x0953);
      glyphList.put("gravelowmod", 0x02CE);
      glyphList.put("gravemonospace", 0xFF40);
      glyphList.put("gravetonecmb", 0x0340);
      glyphList.put("greater", 0x003E);
      glyphList.put("greaterequal", 0x2265);
      glyphList.put("greaterequalorless", 0x22DB);
      glyphList.put("greatermonospace", 0xFF1E);
      glyphList.put("greaterorequivalent", 0x2273);
      glyphList.put("greaterorless", 0x2277);
      glyphList.put("greateroverequal", 0x2267);
      glyphList.put("greatersmall", 0xFE65);
      glyphList.put("gscript", 0x0261);
      glyphList.put("gstroke", 0x01E5);
      glyphList.put("guhiragana", 0x3050);
      glyphList.put("guillemotleft", 0x00AB);
      glyphList.put("guillemotright", 0x00BB);
      glyphList.put("guilsinglleft", 0x2039);
      glyphList.put("guilsinglright", 0x203A);
      glyphList.put("gukatakana", 0x30B0);
      glyphList.put("guramusquare", 0x3318);
      glyphList.put("gysquare", 0x33C9);
      glyphList.put("h", 0x0068);
      glyphList.put("haabkhasiancyrillic", 0x04A9);
      glyphList.put("haaltonearabic", 0x06C1);
      glyphList.put("habengali", 0x09B9);
      glyphList.put("hadescendercyrillic", 0x04B3);
      glyphList.put("hadeva", 0x0939);
      glyphList.put("hagujarati", 0x0AB9);
      glyphList.put("hagurmukhi", 0x0A39);
      glyphList.put("haharabic", 0x062D);
      glyphList.put("hahfinalarabic", 0xFEA2);
      glyphList.put("hahinitialarabic", 0xFEA3);
      glyphList.put("hahiragana", 0x306F);
      glyphList.put("hahmedialarabic", 0xFEA4);
      glyphList.put("haitusquare", 0x332A);
      glyphList.put("hakatakana", 0x30CF);
      glyphList.put("hakatakanahalfwidth", 0xFF8A);
      glyphList.put("halantgurmukhi", 0x0A4D);
      glyphList.put("hamzaarabic", 0x0621);
      //glyphList.put("hamzadammaarabic", 0x0621 064F);
      //glyphList.put("hamzadammatanarabic", 0x0621 064C);
      //glyphList.put("hamzafathaarabic", 0x0621 064E);
      //glyphList.put("hamzafathatanarabic", 0x0621 064B);
      glyphList.put("hamzalowarabic", 0x0621);
      //glyphList.put("hamzalowkasraarabic", 0x0621 0650);
      //glyphList.put("hamzalowkasratanarabic", 0x0621 064D);
      //glyphList.put("hamzasukunarabic", 0x0621 0652);
      glyphList.put("hangulfiller", 0x3164);
      glyphList.put("hardsigncyrillic", 0x044A);
      glyphList.put("harpoonleftbarbup", 0x21BC);
      glyphList.put("harpoonrightbarbup", 0x21C0);
      glyphList.put("hasquare", 0x33CA);
      glyphList.put("hatafpatah", 0x05B2);
      glyphList.put("hatafpatah16", 0x05B2);
      glyphList.put("hatafpatah23", 0x05B2);
      glyphList.put("hatafpatah2f", 0x05B2);
      glyphList.put("hatafpatahhebrew", 0x05B2);
      glyphList.put("hatafpatahnarrowhebrew", 0x05B2);
      glyphList.put("hatafpatahquarterhebrew", 0x05B2);
      glyphList.put("hatafpatahwidehebrew", 0x05B2);
      glyphList.put("hatafqamats", 0x05B3);
      glyphList.put("hatafqamats1b", 0x05B3);
      glyphList.put("hatafqamats28", 0x05B3);
      glyphList.put("hatafqamats34", 0x05B3);
      glyphList.put("hatafqamatshebrew", 0x05B3);
      glyphList.put("hatafqamatsnarrowhebrew", 0x05B3);
      glyphList.put("hatafqamatsquarterhebrew", 0x05B3);
      glyphList.put("hatafqamatswidehebrew", 0x05B3);
      glyphList.put("hatafsegol", 0x05B1);
      glyphList.put("hatafsegol17", 0x05B1);
      glyphList.put("hatafsegol24", 0x05B1);
      glyphList.put("hatafsegol30", 0x05B1);
      glyphList.put("hatafsegolhebrew", 0x05B1);
      glyphList.put("hatafsegolnarrowhebrew", 0x05B1);
      glyphList.put("hatafsegolquarterhebrew", 0x05B1);
      glyphList.put("hatafsegolwidehebrew", 0x05B1);
      glyphList.put("hbar", 0x0127);
      glyphList.put("hbopomofo", 0x310F);
      glyphList.put("hbrevebelow", 0x1E2B);
      glyphList.put("hcedilla", 0x1E29);
      glyphList.put("hcircle", 0x24D7);
      glyphList.put("hcircumflex", 0x0125);
      glyphList.put("hdieresis", 0x1E27);
      glyphList.put("hdotaccent", 0x1E23);
      glyphList.put("hdotbelow", 0x1E25);
      glyphList.put("he", 0x05D4);
      glyphList.put("heart", 0x2665);
      glyphList.put("heartsuitblack", 0x2665);
      glyphList.put("heartsuitwhite", 0x2661);
      glyphList.put("hedagesh", 0xFB34);
      glyphList.put("hedageshhebrew", 0xFB34);
      glyphList.put("hehaltonearabic", 0x06C1);
      glyphList.put("heharabic", 0x0647);
      glyphList.put("hehebrew", 0x05D4);
      glyphList.put("hehfinalaltonearabic", 0xFBA7);
      glyphList.put("hehfinalalttwoarabic", 0xFEEA);
      glyphList.put("hehfinalarabic", 0xFEEA);
      glyphList.put("hehhamzaabovefinalarabic", 0xFBA5);
      glyphList.put("hehhamzaaboveisolatedarabic", 0xFBA4);
      glyphList.put("hehinitialaltonearabic", 0xFBA8);
      glyphList.put("hehinitialarabic", 0xFEEB);
      glyphList.put("hehiragana", 0x3078);
      glyphList.put("hehmedialaltonearabic", 0xFBA9);
      glyphList.put("hehmedialarabic", 0xFEEC);
      glyphList.put("heiseierasquare", 0x337B);
      glyphList.put("hekatakana", 0x30D8);
      glyphList.put("hekatakanahalfwidth", 0xFF8D);
      glyphList.put("hekutaarusquare", 0x3336);
      glyphList.put("henghook", 0x0267);
      glyphList.put("herutusquare", 0x3339);
      glyphList.put("het", 0x05D7);
      glyphList.put("hethebrew", 0x05D7);
      glyphList.put("hhook", 0x0266);
      glyphList.put("hhooksuperior", 0x02B1);
      glyphList.put("hieuhacirclekorean", 0x327B);
      glyphList.put("hieuhaparenkorean", 0x321B);
      glyphList.put("hieuhcirclekorean", 0x326D);
      glyphList.put("hieuhkorean", 0x314E);
      glyphList.put("hieuhparenkorean", 0x320D);
      glyphList.put("hihiragana", 0x3072);
      glyphList.put("hikatakana", 0x30D2);
      glyphList.put("hikatakanahalfwidth", 0xFF8B);
      glyphList.put("hiriq", 0x05B4);
      glyphList.put("hiriq14", 0x05B4);
      glyphList.put("hiriq21", 0x05B4);
      glyphList.put("hiriq2d", 0x05B4);
      glyphList.put("hiriqhebrew", 0x05B4);
      glyphList.put("hiriqnarrowhebrew", 0x05B4);
      glyphList.put("hiriqquarterhebrew", 0x05B4);
      glyphList.put("hiriqwidehebrew", 0x05B4);
      glyphList.put("hlinebelow", 0x1E96);
      glyphList.put("hmonospace", 0xFF48);
      glyphList.put("hoarmenian", 0x0570);
      glyphList.put("hohipthai", 0x0E2B);
      glyphList.put("hohiragana", 0x307B);
      glyphList.put("hokatakana", 0x30DB);
      glyphList.put("hokatakanahalfwidth", 0xFF8E);
      glyphList.put("holam", 0x05B9);
      glyphList.put("holam19", 0x05B9);
      glyphList.put("holam26", 0x05B9);
      glyphList.put("holam32", 0x05B9);
      glyphList.put("holamhebrew", 0x05B9);
      glyphList.put("holamnarrowhebrew", 0x05B9);
      glyphList.put("holamquarterhebrew", 0x05B9);
      glyphList.put("holamwidehebrew", 0x05B9);
      glyphList.put("honokhukthai", 0x0E2E);
      glyphList.put("hookabovecomb", 0x0309);
      glyphList.put("hookcmb", 0x0309);
      glyphList.put("hookpalatalizedbelowcmb", 0x0321);
      glyphList.put("hookretroflexbelowcmb", 0x0322);
      glyphList.put("hoonsquare", 0x3342);
      glyphList.put("horicoptic", 0x03E9);
      glyphList.put("horizontalbar", 0x2015);
      glyphList.put("horncmb", 0x031B);
      glyphList.put("hotsprings", 0x2668);
      glyphList.put("house", 0x2302);
      glyphList.put("hparen", 0x24A3);
      glyphList.put("hsuperior", 0x02B0);
      glyphList.put("hturned", 0x0265);
      glyphList.put("huhiragana", 0x3075);
      glyphList.put("huiitosquare", 0x3333);
      glyphList.put("hukatakana", 0x30D5);
      glyphList.put("hukatakanahalfwidth", 0xFF8C);
      glyphList.put("hungarumlaut", 0x02DD);
      glyphList.put("hungarumlautcmb", 0x030B);
      glyphList.put("hv", 0x0195);
      glyphList.put("hyphen", 0x002D);
      glyphList.put("hypheninferior", 0xF6E5);
      glyphList.put("hyphenmonospace", 0xFF0D);
      glyphList.put("hyphensmall", 0xFE63);
      glyphList.put("hyphensuperior", 0xF6E6);
      glyphList.put("hyphentwo", 0x2010);
      glyphList.put("i", 0x0069);
      glyphList.put("iacute", 0x00ED);
      glyphList.put("iacyrillic", 0x044F);
      glyphList.put("ibengali", 0x0987);
      glyphList.put("ibopomofo", 0x3127);
      glyphList.put("ibreve", 0x012D);
      glyphList.put("icaron", 0x01D0);
      glyphList.put("icircle", 0x24D8);
      glyphList.put("icircumflex", 0x00EE);
      glyphList.put("icyrillic", 0x0456);
      glyphList.put("idblgrave", 0x0209);
      glyphList.put("ideographearthcircle", 0x328F);
      glyphList.put("ideographfirecircle", 0x328B);
      glyphList.put("ideographicallianceparen", 0x323F);
      glyphList.put("ideographiccallparen", 0x323A);
      glyphList.put("ideographiccentrecircle", 0x32A5);
      glyphList.put("ideographicclose", 0x3006);
      glyphList.put("ideographiccomma", 0x3001);
      glyphList.put("ideographiccommaleft", 0xFF64);
      glyphList.put("ideographiccongratulationparen", 0x3237);
      glyphList.put("ideographiccorrectcircle", 0x32A3);
      glyphList.put("ideographicearthparen", 0x322F);
      glyphList.put("ideographicenterpriseparen", 0x323D);
      glyphList.put("ideographicexcellentcircle", 0x329D);
      glyphList.put("ideographicfestivalparen", 0x3240);
      glyphList.put("ideographicfinancialcircle", 0x3296);
      glyphList.put("ideographicfinancialparen", 0x3236);
      glyphList.put("ideographicfireparen", 0x322B);
      glyphList.put("ideographichaveparen", 0x3232);
      glyphList.put("ideographichighcircle", 0x32A4);
      glyphList.put("ideographiciterationmark", 0x3005);
      glyphList.put("ideographiclaborcircle", 0x3298);
      glyphList.put("ideographiclaborparen", 0x3238);
      glyphList.put("ideographicleftcircle", 0x32A7);
      glyphList.put("ideographiclowcircle", 0x32A6);
      glyphList.put("ideographicmedicinecircle", 0x32A9);
      glyphList.put("ideographicmetalparen", 0x322E);
      glyphList.put("ideographicmoonparen", 0x322A);
      glyphList.put("ideographicnameparen", 0x3234);
      glyphList.put("ideographicperiod", 0x3002);
      glyphList.put("ideographicprintcircle", 0x329E);
      glyphList.put("ideographicreachparen", 0x3243);
      glyphList.put("ideographicrepresentparen", 0x3239);
      glyphList.put("ideographicresourceparen", 0x323E);
      glyphList.put("ideographicrightcircle", 0x32A8);
      glyphList.put("ideographicsecretcircle", 0x3299);
      glyphList.put("ideographicselfparen", 0x3242);
      glyphList.put("ideographicsocietyparen", 0x3233);
      glyphList.put("ideographicspace", 0x3000);
      glyphList.put("ideographicspecialparen", 0x3235);
      glyphList.put("ideographicstockparen", 0x3231);
      glyphList.put("ideographicstudyparen", 0x323B);
      glyphList.put("ideographicsunparen", 0x3230);
      glyphList.put("ideographicsuperviseparen", 0x323C);
      glyphList.put("ideographicwaterparen", 0x322C);
      glyphList.put("ideographicwoodparen", 0x322D);
      glyphList.put("ideographiczero", 0x3007);
      glyphList.put("ideographmetalcircle", 0x328E);
      glyphList.put("ideographmooncircle", 0x328A);
      glyphList.put("ideographnamecircle", 0x3294);
      glyphList.put("ideographsuncircle", 0x3290);
      glyphList.put("ideographwatercircle", 0x328C);
      glyphList.put("ideographwoodcircle", 0x328D);
      glyphList.put("ideva", 0x0907);
      glyphList.put("idieresis", 0x00EF);
      glyphList.put("idieresisacute", 0x1E2F);
      glyphList.put("idieresiscyrillic", 0x04E5);
      glyphList.put("idotbelow", 0x1ECB);
      glyphList.put("iebrevecyrillic", 0x04D7);
      glyphList.put("iecyrillic", 0x0435);
      glyphList.put("ieungacirclekorean", 0x3275);
      glyphList.put("ieungaparenkorean", 0x3215);
      glyphList.put("ieungcirclekorean", 0x3267);
      glyphList.put("ieungkorean", 0x3147);
      glyphList.put("ieungparenkorean", 0x3207);
      glyphList.put("igrave", 0x00EC);
      glyphList.put("igujarati", 0x0A87);
      glyphList.put("igurmukhi", 0x0A07);
      glyphList.put("ihiragana", 0x3044);
      glyphList.put("ihookabove", 0x1EC9);
      glyphList.put("iibengali", 0x0988);
      glyphList.put("iicyrillic", 0x0438);
      glyphList.put("iideva", 0x0908);
      glyphList.put("iigujarati", 0x0A88);
      glyphList.put("iigurmukhi", 0x0A08);
      glyphList.put("iimatragurmukhi", 0x0A40);
      glyphList.put("iinvertedbreve", 0x020B);
      glyphList.put("iishortcyrillic", 0x0439);
      glyphList.put("iivowelsignbengali", 0x09C0);
      glyphList.put("iivowelsigndeva", 0x0940);
      glyphList.put("iivowelsigngujarati", 0x0AC0);
      glyphList.put("ij", 0x0133);
      glyphList.put("ikatakana", 0x30A4);
      glyphList.put("ikatakanahalfwidth", 0xFF72);
      glyphList.put("ikorean", 0x3163);
      glyphList.put("ilde", 0x02DC);
      glyphList.put("iluyhebrew", 0x05AC);
      glyphList.put("imacron", 0x012B);
      glyphList.put("imacroncyrillic", 0x04E3);
      glyphList.put("imageorapproximatelyequal", 0x2253);
      glyphList.put("imatragurmukhi", 0x0A3F);
      glyphList.put("imonospace", 0xFF49);
      glyphList.put("increment", 0x2206);
      glyphList.put("infinity", 0x221E);
      glyphList.put("iniarmenian", 0x056B);
      glyphList.put("integral", 0x222B);
      glyphList.put("integralbottom", 0x2321);
      glyphList.put("integralbt", 0x2321);
      glyphList.put("integralex", 0xF8F5);
      glyphList.put("integraltop", 0x2320);
      glyphList.put("integraltp", 0x2320);
      glyphList.put("intersection", 0x2229);
      glyphList.put("intisquare", 0x3305);
      glyphList.put("invbullet", 0x25D8);
      glyphList.put("invcircle", 0x25D9);
      glyphList.put("invsmileface", 0x263B);
      glyphList.put("iocyrillic", 0x0451);
      glyphList.put("iogonek", 0x012F);
      glyphList.put("iota", 0x03B9);
      glyphList.put("iotadieresis", 0x03CA);
      glyphList.put("iotadieresistonos", 0x0390);
      glyphList.put("iotalatin", 0x0269);
      glyphList.put("iotatonos", 0x03AF);
      glyphList.put("iparen", 0x24A4);
      glyphList.put("irigurmukhi", 0x0A72);
      glyphList.put("ismallhiragana", 0x3043);
      glyphList.put("ismallkatakana", 0x30A3);
      glyphList.put("ismallkatakanahalfwidth", 0xFF68);
      glyphList.put("issharbengali", 0x09FA);
      glyphList.put("istroke", 0x0268);
      glyphList.put("isuperior", 0xF6ED);
      glyphList.put("iterationhiragana", 0x309D);
      glyphList.put("iterationkatakana", 0x30FD);
      glyphList.put("itilde", 0x0129);
      glyphList.put("itildebelow", 0x1E2D);
      glyphList.put("iubopomofo", 0x3129);
      glyphList.put("iucyrillic", 0x044E);
      glyphList.put("ivowelsignbengali", 0x09BF);
      glyphList.put("ivowelsigndeva", 0x093F);
      glyphList.put("ivowelsigngujarati", 0x0ABF);
      glyphList.put("izhitsacyrillic", 0x0475);
      glyphList.put("izhitsadblgravecyrillic", 0x0477);
      glyphList.put("j", 0x006A);
      glyphList.put("jaarmenian", 0x0571);
      glyphList.put("jabengali", 0x099C);
      glyphList.put("jadeva", 0x091C);
      glyphList.put("jagujarati", 0x0A9C);
      glyphList.put("jagurmukhi", 0x0A1C);
      glyphList.put("jbopomofo", 0x3110);
      glyphList.put("jcaron", 0x01F0);
      glyphList.put("jcircle", 0x24D9);
      glyphList.put("jcircumflex", 0x0135);
      glyphList.put("jcrossedtail", 0x029D);
      glyphList.put("jdotlessstroke", 0x025F);
      glyphList.put("jecyrillic", 0x0458);
      glyphList.put("jeemarabic", 0x062C);
      glyphList.put("jeemfinalarabic", 0xFE9E);
      glyphList.put("jeeminitialarabic", 0xFE9F);
      glyphList.put("jeemmedialarabic", 0xFEA0);
      glyphList.put("jeharabic", 0x0698);
      glyphList.put("jehfinalarabic", 0xFB8B);
      glyphList.put("jhabengali", 0x099D);
      glyphList.put("jhadeva", 0x091D);
      glyphList.put("jhagujarati", 0x0A9D);
      glyphList.put("jhagurmukhi", 0x0A1D);
      glyphList.put("jheharmenian", 0x057B);
      glyphList.put("jis", 0x3004);
      glyphList.put("jmonospace", 0xFF4A);
      glyphList.put("jparen", 0x24A5);
      glyphList.put("jsuperior", 0x02B2);
      glyphList.put("k", 0x006B);
      glyphList.put("kabashkircyrillic", 0x04A1);
      glyphList.put("kabengali", 0x0995);
      glyphList.put("kacute", 0x1E31);
      glyphList.put("kacyrillic", 0x043A);
      glyphList.put("kadescendercyrillic", 0x049B);
      glyphList.put("kadeva", 0x0915);
      glyphList.put("kaf", 0x05DB);
      glyphList.put("kafarabic", 0x0643);
      glyphList.put("kafdagesh", 0xFB3B);
      glyphList.put("kafdageshhebrew", 0xFB3B);
      glyphList.put("kaffinalarabic", 0xFEDA);
      glyphList.put("kafhebrew", 0x05DB);
      glyphList.put("kafinitialarabic", 0xFEDB);
      glyphList.put("kafmedialarabic", 0xFEDC);
      glyphList.put("kafrafehebrew", 0xFB4D);
      glyphList.put("kagujarati", 0x0A95);
      glyphList.put("kagurmukhi", 0x0A15);
      glyphList.put("kahiragana", 0x304B);
      glyphList.put("kahookcyrillic", 0x04C4);
      glyphList.put("kakatakana", 0x30AB);
      glyphList.put("kakatakanahalfwidth", 0xFF76);
      glyphList.put("kappa", 0x03BA);
      glyphList.put("kappasymbolgreek", 0x03F0);
      glyphList.put("kapyeounmieumkorean", 0x3171);
      glyphList.put("kapyeounphieuphkorean", 0x3184);
      glyphList.put("kapyeounpieupkorean", 0x3178);
      glyphList.put("kapyeounssangpieupkorean", 0x3179);
      glyphList.put("karoriisquare", 0x330D);
      glyphList.put("kashidaautoarabic", 0x0640);
      glyphList.put("kashidaautonosidebearingarabic", 0x0640);
      glyphList.put("kasmallkatakana", 0x30F5);
      glyphList.put("kasquare", 0x3384);
      glyphList.put("kasraarabic", 0x0650);
      glyphList.put("kasratanarabic", 0x064D);
      glyphList.put("kastrokecyrillic", 0x049F);
      glyphList.put("katahiraprolongmarkhalfwidth", 0xFF70);
      glyphList.put("kaverticalstrokecyrillic", 0x049D);
      glyphList.put("kbopomofo", 0x310E);
      glyphList.put("kcalsquare", 0x3389);
      glyphList.put("kcaron", 0x01E9);
      glyphList.put("kcedilla", 0x0137);
      glyphList.put("kcircle", 0x24DA);
      glyphList.put("kcommaaccent", 0x0137);
      glyphList.put("kdotbelow", 0x1E33);
      glyphList.put("keharmenian", 0x0584);
      glyphList.put("kehiragana", 0x3051);
      glyphList.put("kekatakana", 0x30B1);
      glyphList.put("kekatakanahalfwidth", 0xFF79);
      glyphList.put("kenarmenian", 0x056F);
      glyphList.put("kesmallkatakana", 0x30F6);
      glyphList.put("kgreenlandic", 0x0138);
      glyphList.put("khabengali", 0x0996);
      glyphList.put("khacyrillic", 0x0445);
      glyphList.put("khadeva", 0x0916);
      glyphList.put("khagujarati", 0x0A96);
      glyphList.put("khagurmukhi", 0x0A16);
      glyphList.put("khaharabic", 0x062E);
      glyphList.put("khahfinalarabic", 0xFEA6);
      glyphList.put("khahinitialarabic", 0xFEA7);
      glyphList.put("khahmedialarabic", 0xFEA8);
      glyphList.put("kheicoptic", 0x03E7);
      glyphList.put("khhadeva", 0x0959);
      glyphList.put("khhagurmukhi", 0x0A59);
      glyphList.put("khieukhacirclekorean", 0x3278);
      glyphList.put("khieukhaparenkorean", 0x3218);
      glyphList.put("khieukhcirclekorean", 0x326A);
      glyphList.put("khieukhkorean", 0x314B);
      glyphList.put("khieukhparenkorean", 0x320A);
      glyphList.put("khokhaithai", 0x0E02);
      glyphList.put("khokhonthai", 0x0E05);
      glyphList.put("khokhuatthai", 0x0E03);
      glyphList.put("khokhwaithai", 0x0E04);
      glyphList.put("khomutthai", 0x0E5B);
      glyphList.put("khook", 0x0199);
      glyphList.put("khorakhangthai", 0x0E06);
      glyphList.put("khzsquare", 0x3391);
      glyphList.put("kihiragana", 0x304D);
      glyphList.put("kikatakana", 0x30AD);
      glyphList.put("kikatakanahalfwidth", 0xFF77);
      glyphList.put("kiroguramusquare", 0x3315);
      glyphList.put("kiromeetorusquare", 0x3316);
      glyphList.put("kirosquare", 0x3314);
      glyphList.put("kiyeokacirclekorean", 0x326E);
      glyphList.put("kiyeokaparenkorean", 0x320E);
      glyphList.put("kiyeokcirclekorean", 0x3260);
      glyphList.put("kiyeokkorean", 0x3131);
      glyphList.put("kiyeokparenkorean", 0x3200);
      glyphList.put("kiyeoksioskorean", 0x3133);
      glyphList.put("kjecyrillic", 0x045C);
      glyphList.put("klinebelow", 0x1E35);
      glyphList.put("klsquare", 0x3398);
      glyphList.put("kmcubedsquare", 0x33A6);
      glyphList.put("kmonospace", 0xFF4B);
      glyphList.put("kmsquaredsquare", 0x33A2);
      glyphList.put("kohiragana", 0x3053);
      glyphList.put("kohmsquare", 0x33C0);
      glyphList.put("kokaithai", 0x0E01);
      glyphList.put("kokatakana", 0x30B3);
      glyphList.put("kokatakanahalfwidth", 0xFF7A);
      glyphList.put("kooposquare", 0x331E);
      glyphList.put("koppacyrillic", 0x0481);
      glyphList.put("koreanstandardsymbol", 0x327F);
      glyphList.put("koroniscmb", 0x0343);
      glyphList.put("kparen", 0x24A6);
      glyphList.put("kpasquare", 0x33AA);
      glyphList.put("ksicyrillic", 0x046F);
      glyphList.put("ktsquare", 0x33CF);
      glyphList.put("kturned", 0x029E);
      glyphList.put("kuhiragana", 0x304F);
      glyphList.put("kukatakana", 0x30AF);
      glyphList.put("kukatakanahalfwidth", 0xFF78);
      glyphList.put("kvsquare", 0x33B8);
      glyphList.put("kwsquare", 0x33BE);
      glyphList.put("l", 0x006C);
      glyphList.put("labengali", 0x09B2);
      glyphList.put("lacute", 0x013A);
      glyphList.put("ladeva", 0x0932);
      glyphList.put("lagujarati", 0x0AB2);
      glyphList.put("lagurmukhi", 0x0A32);
      glyphList.put("lakkhangyaothai", 0x0E45);
      glyphList.put("lamaleffinalarabic", 0xFEFC);
      glyphList.put("lamalefhamzaabovefinalarabic", 0xFEF8);
      glyphList.put("lamalefhamzaaboveisolatedarabic", 0xFEF7);
      glyphList.put("lamalefhamzabelowfinalarabic", 0xFEFA);
      glyphList.put("lamalefhamzabelowisolatedarabic", 0xFEF9);
      glyphList.put("lamalefisolatedarabic", 0xFEFB);
      glyphList.put("lamalefmaddaabovefinalarabic", 0xFEF6);
      glyphList.put("lamalefmaddaaboveisolatedarabic", 0xFEF5);
      glyphList.put("lamarabic", 0x0644);
      glyphList.put("lambda", 0x03BB);
      glyphList.put("lambdastroke", 0x019B);
      glyphList.put("lamed", 0x05DC);
      glyphList.put("lameddagesh", 0xFB3C);
      glyphList.put("lameddageshhebrew", 0xFB3C);
      glyphList.put("lamedhebrew", 0x05DC);
      /*
      glyphList.put("lamedholam", 0x05DC 05B9);
      glyphList.put("lamedholamdagesh", 0x05DC 05B9 05BC);
      glyphList.put("lamedholamdageshhebrew", 0x05DC 05B9 05BC);
      glyphList.put("lamedholamhebrew", 0x05DC 05B9);
      */
      glyphList.put("lamfinalarabic", 0xFEDE);
      glyphList.put("lamhahinitialarabic", 0xFCCA);
      glyphList.put("laminitialarabic", 0xFEDF);
      glyphList.put("lamjeeminitialarabic", 0xFCC9);
      glyphList.put("lamkhahinitialarabic", 0xFCCB);
      glyphList.put("lamlamhehisolatedarabic", 0xFDF2);
      glyphList.put("lammedialarabic", 0xFEE0);
      glyphList.put("lammeemhahinitialarabic", 0xFD88);
      glyphList.put("lammeeminitialarabic", 0xFCCC);
      //glyphList.put("lammeemjeeminitialarabic", 0xFEDFFEE4 FEA0);
      //glyphList.put("lammeemkhahinitialarabic", 0xFEDFFEE4 FEA8);
      glyphList.put("largecircle", 0x25EF);
      glyphList.put("lbar", 0x019A);
      glyphList.put("lbelt", 0x026C);
      glyphList.put("lbopomofo", 0x310C);
      glyphList.put("lcaron", 0x013E);
      glyphList.put("lcedilla", 0x013C);
      glyphList.put("lcircle", 0x24DB);
      glyphList.put("lcircumflexbelow", 0x1E3D);
      glyphList.put("lcommaaccent", 0x013C);
      glyphList.put("ldot", 0x0140);
      glyphList.put("ldotaccent", 0x0140);
      glyphList.put("ldotbelow", 0x1E37);
      glyphList.put("ldotbelowmacron", 0x1E39);
      glyphList.put("leftangleabovecmb", 0x031A);
      glyphList.put("lefttackbelowcmb", 0x0318);
      glyphList.put("less", 0x003C);
      glyphList.put("lessequal", 0x2264);
      glyphList.put("lessequalorgreater", 0x22DA);
      glyphList.put("lessmonospace", 0xFF1C);
      glyphList.put("lessorequivalent", 0x2272);
      glyphList.put("lessorgreater", 0x2276);
      glyphList.put("lessoverequal", 0x2266);
      glyphList.put("lesssmall", 0xFE64);
      glyphList.put("lezh", 0x026E);
      glyphList.put("lfblock", 0x258C);
      glyphList.put("lhookretroflex", 0x026D);
      glyphList.put("lira", 0x20A4);
      glyphList.put("liwnarmenian", 0x056C);
      glyphList.put("lj", 0x01C9);
      glyphList.put("ljecyrillic", 0x0459);
      glyphList.put("ll", 0xF6C0);
      glyphList.put("lladeva", 0x0933);
      glyphList.put("llagujarati", 0x0AB3);
      glyphList.put("llinebelow", 0x1E3B);
      glyphList.put("llladeva", 0x0934);
      glyphList.put("llvocalicbengali", 0x09E1);
      glyphList.put("llvocalicdeva", 0x0961);
      glyphList.put("llvocalicvowelsignbengali", 0x09E3);
      glyphList.put("llvocalicvowelsigndeva", 0x0963);
      glyphList.put("lmiddletilde", 0x026B);
      glyphList.put("lmonospace", 0xFF4C);
      glyphList.put("lmsquare", 0x33D0);
      glyphList.put("lochulathai", 0x0E2C);
      glyphList.put("logicaland", 0x2227);
      glyphList.put("logicalnot", 0x00AC);
      glyphList.put("logicalnotreversed", 0x2310);
      glyphList.put("logicalor", 0x2228);
      glyphList.put("lolingthai", 0x0E25);
      glyphList.put("longs", 0x017F);
      glyphList.put("lowlinecenterline", 0xFE4E);
      glyphList.put("lowlinecmb", 0x0332);
      glyphList.put("lowlinedashed", 0xFE4D);
      glyphList.put("lozenge", 0x25CA);
      glyphList.put("lparen", 0x24A7);
      glyphList.put("lslash", 0x0142);
      glyphList.put("lsquare", 0x2113);
      glyphList.put("lsuperior", 0xF6EE);
      glyphList.put("ltshade", 0x2591);
      glyphList.put("luthai", 0x0E26);
      glyphList.put("lvocalicbengali", 0x098C);
      glyphList.put("lvocalicdeva", 0x090C);
      glyphList.put("lvocalicvowelsignbengali", 0x09E2);
      glyphList.put("lvocalicvowelsigndeva", 0x0962);
      glyphList.put("lxsquare", 0x33D3);
      glyphList.put("m", 0x006D);
      glyphList.put("mabengali", 0x09AE);
      glyphList.put("macron", 0x00AF);
      glyphList.put("macronbelowcmb", 0x0331);
      glyphList.put("macroncmb", 0x0304);
      glyphList.put("macronlowmod", 0x02CD);
      glyphList.put("macronmonospace", 0xFFE3);
      glyphList.put("macute", 0x1E3F);
      glyphList.put("madeva", 0x092E);
      glyphList.put("magujarati", 0x0AAE);
      glyphList.put("magurmukhi", 0x0A2E);
      glyphList.put("mahapakhhebrew", 0x05A4);
      glyphList.put("mahapakhlefthebrew", 0x05A4);
      glyphList.put("mahiragana", 0x307E);
      glyphList.put("maichattawalowleftthai", 0xF895);
      glyphList.put("maichattawalowrightthai", 0xF894);
      glyphList.put("maichattawathai", 0x0E4B);
      glyphList.put("maichattawaupperleftthai", 0xF893);
      glyphList.put("maieklowleftthai", 0xF88C);
      glyphList.put("maieklowrightthai", 0xF88B);
      glyphList.put("maiekthai", 0x0E48);
      glyphList.put("maiekupperleftthai", 0xF88A);
      glyphList.put("maihanakatleftthai", 0xF884);
      glyphList.put("maihanakatthai", 0x0E31);
      glyphList.put("maitaikhuleftthai", 0xF889);
      glyphList.put("maitaikhuthai", 0x0E47);
      glyphList.put("maitholowleftthai", 0xF88F);
      glyphList.put("maitholowrightthai", 0xF88E);
      glyphList.put("maithothai", 0x0E49);
      glyphList.put("maithoupperleftthai", 0xF88D);
      glyphList.put("maitrilowleftthai", 0xF892);
      glyphList.put("maitrilowrightthai", 0xF891);
      glyphList.put("maitrithai", 0x0E4A);
      glyphList.put("maitriupperleftthai", 0xF890);
      glyphList.put("maiyamokthai", 0x0E46);
      glyphList.put("makatakana", 0x30DE);
      glyphList.put("makatakanahalfwidth", 0xFF8F);
      glyphList.put("male", 0x2642);
      glyphList.put("mansyonsquare", 0x3347);
      glyphList.put("maqafhebrew", 0x05BE);
      glyphList.put("mars", 0x2642);
      glyphList.put("masoracirclehebrew", 0x05AF);
      glyphList.put("masquare", 0x3383);
      glyphList.put("mbopomofo", 0x3107);
      glyphList.put("mbsquare", 0x33D4);
      glyphList.put("mcircle", 0x24DC);
      glyphList.put("mcubedsquare", 0x33A5);
      glyphList.put("mdotaccent", 0x1E41);
      glyphList.put("mdotbelow", 0x1E43);
      glyphList.put("meemarabic", 0x0645);
      glyphList.put("meemfinalarabic", 0xFEE2);
      glyphList.put("meeminitialarabic", 0xFEE3);
      glyphList.put("meemmedialarabic", 0xFEE4);
      glyphList.put("meemmeeminitialarabic", 0xFCD1);
      glyphList.put("meemmeemisolatedarabic", 0xFC48);
      glyphList.put("meetorusquare", 0x334D);
      glyphList.put("mehiragana", 0x3081);
      glyphList.put("meizierasquare", 0x337E);
      glyphList.put("mekatakana", 0x30E1);
      glyphList.put("mekatakanahalfwidth", 0xFF92);
      glyphList.put("mem", 0x05DE);
      glyphList.put("memdagesh", 0xFB3E);
      glyphList.put("memdageshhebrew", 0xFB3E);
      glyphList.put("memhebrew", 0x05DE);
      glyphList.put("menarmenian", 0x0574);
      glyphList.put("merkhahebrew", 0x05A5);
      glyphList.put("merkhakefulahebrew", 0x05A6);
      glyphList.put("merkhakefulalefthebrew", 0x05A6);
      glyphList.put("merkhalefthebrew", 0x05A5);
      glyphList.put("mhook", 0x0271);
      glyphList.put("mhzsquare", 0x3392);
      glyphList.put("middledotkatakanahalfwidth", 0xFF65);
      glyphList.put("middot", 0x00B7);
      glyphList.put("mieumacirclekorean", 0x3272);
      glyphList.put("mieumaparenkorean", 0x3212);
      glyphList.put("mieumcirclekorean", 0x3264);
      glyphList.put("mieumkorean", 0x3141);
      glyphList.put("mieumpansioskorean", 0x3170);
      glyphList.put("mieumparenkorean", 0x3204);
      glyphList.put("mieumpieupkorean", 0x316E);
      glyphList.put("mieumsioskorean", 0x316F);
      glyphList.put("mihiragana", 0x307F);
      glyphList.put("mikatakana", 0x30DF);
      glyphList.put("mikatakanahalfwidth", 0xFF90);
      glyphList.put("minus", 0x2212);
      glyphList.put("minusbelowcmb", 0x0320);
      glyphList.put("minuscircle", 0x2296);
      glyphList.put("minusmod", 0x02D7);
      glyphList.put("minusplus", 0x2213);
      glyphList.put("minute", 0x2032);
      glyphList.put("miribaarusquare", 0x334A);
      glyphList.put("mirisquare", 0x3349);
      glyphList.put("mlonglegturned", 0x0270);
      glyphList.put("mlsquare", 0x3396);
      glyphList.put("mmcubedsquare", 0x33A3);
      glyphList.put("mmonospace", 0xFF4D);
      glyphList.put("mmsquaredsquare", 0x339F);
      glyphList.put("mohiragana", 0x3082);
      glyphList.put("mohmsquare", 0x33C1);
      glyphList.put("mokatakana", 0x30E2);
      glyphList.put("mokatakanahalfwidth", 0xFF93);
      glyphList.put("molsquare", 0x33D6);
      glyphList.put("momathai", 0x0E21);
      glyphList.put("moverssquare", 0x33A7);
      glyphList.put("moverssquaredsquare", 0x33A8);
      glyphList.put("mparen", 0x24A8);
      glyphList.put("mpasquare", 0x33AB);
      glyphList.put("mssquare", 0x33B3);
      glyphList.put("msuperior", 0xF6EF);
      glyphList.put("mturned", 0x026F);
      glyphList.put("mu", 0x00B5);
      glyphList.put("mu1", 0x00B5);
      glyphList.put("muasquare", 0x3382);
      glyphList.put("muchgreater", 0x226B);
      glyphList.put("muchless", 0x226A);
      glyphList.put("mufsquare", 0x338C);
      glyphList.put("mugreek", 0x03BC);
      glyphList.put("mugsquare", 0x338D);
      glyphList.put("muhiragana", 0x3080);
      glyphList.put("mukatakana", 0x30E0);
      glyphList.put("mukatakanahalfwidth", 0xFF91);
      glyphList.put("mulsquare", 0x3395);
      glyphList.put("multiply", 0x00D7);
      glyphList.put("mumsquare", 0x339B);
      glyphList.put("munahhebrew", 0x05A3);
      glyphList.put("munahlefthebrew", 0x05A3);
      glyphList.put("musicalnote", 0x266A);
      glyphList.put("musicalnotedbl", 0x266B);
      glyphList.put("musicflatsign", 0x266D);
      glyphList.put("musicsharpsign", 0x266F);
      glyphList.put("mussquare", 0x33B2);
      glyphList.put("muvsquare", 0x33B6);
      glyphList.put("muwsquare", 0x33BC);
      glyphList.put("mvmegasquare", 0x33B9);
      glyphList.put("mvsquare", 0x33B7);
      glyphList.put("mwmegasquare", 0x33BF);
      glyphList.put("mwsquare", 0x33BD);
      glyphList.put("n", 0x006E);
      glyphList.put("nabengali", 0x09A8);
      glyphList.put("nabla", 0x2207);
      glyphList.put("nacute", 0x0144);
      glyphList.put("nadeva", 0x0928);
      glyphList.put("nagujarati", 0x0AA8);
      glyphList.put("nagurmukhi", 0x0A28);
      glyphList.put("nahiragana", 0x306A);
      glyphList.put("nakatakana", 0x30CA);
      glyphList.put("nakatakanahalfwidth", 0xFF85);
      glyphList.put("napostrophe", 0x0149);
      glyphList.put("nasquare", 0x3381);
      glyphList.put("nbopomofo", 0x310B);
      glyphList.put("nbspace", 0x00A0);
      glyphList.put("ncaron", 0x0148);
      glyphList.put("ncedilla", 0x0146);
      glyphList.put("ncircle", 0x24DD);
      glyphList.put("ncircumflexbelow", 0x1E4B);
      glyphList.put("ncommaaccent", 0x0146);
      glyphList.put("ndotaccent", 0x1E45);
      glyphList.put("ndotbelow", 0x1E47);
      glyphList.put("nehiragana", 0x306D);
      glyphList.put("nekatakana", 0x30CD);
      glyphList.put("nekatakanahalfwidth", 0xFF88);
      glyphList.put("newsheqelsign", 0x20AA);
      glyphList.put("nfsquare", 0x338B);
      glyphList.put("ngabengali", 0x0999);
      glyphList.put("ngadeva", 0x0919);
      glyphList.put("ngagujarati", 0x0A99);
      glyphList.put("ngagurmukhi", 0x0A19);
      glyphList.put("ngonguthai", 0x0E07);
      glyphList.put("nhiragana", 0x3093);
      glyphList.put("nhookleft", 0x0272);
      glyphList.put("nhookretroflex", 0x0273);
      glyphList.put("nieunacirclekorean", 0x326F);
      glyphList.put("nieunaparenkorean", 0x320F);
      glyphList.put("nieuncieuckorean", 0x3135);
      glyphList.put("nieuncirclekorean", 0x3261);
      glyphList.put("nieunhieuhkorean", 0x3136);
      glyphList.put("nieunkorean", 0x3134);
      glyphList.put("nieunpansioskorean", 0x3168);
      glyphList.put("nieunparenkorean", 0x3201);
      glyphList.put("nieunsioskorean", 0x3167);
      glyphList.put("nieuntikeutkorean", 0x3166);
      glyphList.put("nihiragana", 0x306B);
      glyphList.put("nikatakana", 0x30CB);
      glyphList.put("nikatakanahalfwidth", 0xFF86);
      glyphList.put("nikhahitleftthai", 0xF899);
      glyphList.put("nikhahitthai", 0x0E4D);
      glyphList.put("nine", 0x0039);
      glyphList.put("ninearabic", 0x0669);
      glyphList.put("ninebengali", 0x09EF);
      glyphList.put("ninecircle", 0x2468);
      glyphList.put("ninecircleinversesansserif", 0x2792);
      glyphList.put("ninedeva", 0x096F);
      glyphList.put("ninegujarati", 0x0AEF);
      glyphList.put("ninegurmukhi", 0x0A6F);
      glyphList.put("ninehackarabic", 0x0669);
      glyphList.put("ninehangzhou", 0x3029);
      glyphList.put("nineideographicparen", 0x3228);
      glyphList.put("nineinferior", 0x2089);
      glyphList.put("ninemonospace", 0xFF19);
      glyphList.put("nineoldstyle", 0xF739);
      glyphList.put("nineparen", 0x247C);
      glyphList.put("nineperiod", 0x2490);
      glyphList.put("ninepersian", 0x06F9);
      glyphList.put("nineroman", 0x2178);
      glyphList.put("ninesuperior", 0x2079);
      glyphList.put("nineteencircle", 0x2472);
      glyphList.put("nineteenparen", 0x2486);
      glyphList.put("nineteenperiod", 0x249A);
      glyphList.put("ninethai", 0x0E59);
      glyphList.put("nj", 0x01CC);
      glyphList.put("njecyrillic", 0x045A);
      glyphList.put("nkatakana", 0x30F3);
      glyphList.put("nkatakanahalfwidth", 0xFF9D);
      glyphList.put("nlegrightlong", 0x019E);
      glyphList.put("nlinebelow", 0x1E49);
      glyphList.put("nmonospace", 0xFF4E);
      glyphList.put("nmsquare", 0x339A);
      glyphList.put("nnabengali", 0x09A3);
      glyphList.put("nnadeva", 0x0923);
      glyphList.put("nnagujarati", 0x0AA3);
      glyphList.put("nnagurmukhi", 0x0A23);
      glyphList.put("nnnadeva", 0x0929);
      glyphList.put("nohiragana", 0x306E);
      glyphList.put("nokatakana", 0x30CE);
      glyphList.put("nokatakanahalfwidth", 0xFF89);
      glyphList.put("nonbreakingspace", 0x00A0);
      glyphList.put("nonenthai", 0x0E13);
      glyphList.put("nonuthai", 0x0E19);
      glyphList.put("noonarabic", 0x0646);
      glyphList.put("noonfinalarabic", 0xFEE6);
      glyphList.put("noonghunnaarabic", 0x06BA);
      glyphList.put("noonghunnafinalarabic", 0xFB9F);
      glyphList.put("noonhehinitialarabic", 0xFEE7FEEC);
      glyphList.put("nooninitialarabic", 0xFEE7);
      glyphList.put("noonjeeminitialarabic", 0xFCD2);
      glyphList.put("noonjeemisolatedarabic", 0xFC4B);
      glyphList.put("noonmedialarabic", 0xFEE8);
      glyphList.put("noonmeeminitialarabic", 0xFCD5);
      glyphList.put("noonmeemisolatedarabic", 0xFC4E);
      glyphList.put("noonnoonfinalarabic", 0xFC8D);
      glyphList.put("notcontains", 0x220C);
      glyphList.put("notelement", 0x2209);
      glyphList.put("notelementof", 0x2209);
      glyphList.put("notequal", 0x2260);
      glyphList.put("notgreater", 0x226F);
      glyphList.put("notgreaternorequal", 0x2271);
      glyphList.put("notgreaternorless", 0x2279);
      glyphList.put("notidentical", 0x2262);
      glyphList.put("notless", 0x226E);
      glyphList.put("notlessnorequal", 0x2270);
      glyphList.put("notparallel", 0x2226);
      glyphList.put("notprecedes", 0x2280);
      glyphList.put("notsubset", 0x2284);
      glyphList.put("notsucceeds", 0x2281);
      glyphList.put("notsuperset", 0x2285);
      glyphList.put("nowarmenian", 0x0576);
      glyphList.put("nparen", 0x24A9);
      glyphList.put("nssquare", 0x33B1);
      glyphList.put("nsuperior", 0x207F);
      glyphList.put("ntilde", 0x00F1);
      glyphList.put("nu", 0x03BD);
      glyphList.put("nuhiragana", 0x306C);
      glyphList.put("nukatakana", 0x30CC);
      glyphList.put("nukatakanahalfwidth", 0xFF87);
      glyphList.put("nuktabengali", 0x09BC);
      glyphList.put("nuktadeva", 0x093C);
      glyphList.put("nuktagujarati", 0x0ABC);
      glyphList.put("nuktagurmukhi", 0x0A3C);
      glyphList.put("numbersign", 0x0023);
      glyphList.put("numbersignmonospace", 0xFF03);
      glyphList.put("numbersignsmall", 0xFE5F);
      glyphList.put("numeralsigngreek", 0x0374);
      glyphList.put("numeralsignlowergreek", 0x0375);
      glyphList.put("numero", 0x2116);
      glyphList.put("nun", 0x05E0);
      glyphList.put("nundagesh", 0xFB40);
      glyphList.put("nundageshhebrew", 0xFB40);
      glyphList.put("nunhebrew", 0x05E0);
      glyphList.put("nvsquare", 0x33B5);
      glyphList.put("nwsquare", 0x33BB);
      glyphList.put("nyabengali", 0x099E);
      glyphList.put("nyadeva", 0x091E);
      glyphList.put("nyagujarati", 0x0A9E);
      glyphList.put("nyagurmukhi", 0x0A1E);
      glyphList.put("o", 0x006F);
      glyphList.put("oacute", 0x00F3);
      glyphList.put("oangthai", 0x0E2D);
      glyphList.put("obarred", 0x0275);
      glyphList.put("obarredcyrillic", 0x04E9);
      glyphList.put("obarreddieresiscyrillic", 0x04EB);
      glyphList.put("obengali", 0x0993);
      glyphList.put("obopomofo", 0x311B);
      glyphList.put("obreve", 0x014F);
      glyphList.put("ocandradeva", 0x0911);
      glyphList.put("ocandragujarati", 0x0A91);
      glyphList.put("ocandravowelsigndeva", 0x0949);
      glyphList.put("ocandravowelsigngujarati", 0x0AC9);
      glyphList.put("ocaron", 0x01D2);
      glyphList.put("ocircle", 0x24DE);
      glyphList.put("ocircumflex", 0x00F4);
      glyphList.put("ocircumflexacute", 0x1ED1);
      glyphList.put("ocircumflexdotbelow", 0x1ED9);
      glyphList.put("ocircumflexgrave", 0x1ED3);
      glyphList.put("ocircumflexhookabove", 0x1ED5);
      glyphList.put("ocircumflextilde", 0x1ED7);
      glyphList.put("ocyrillic", 0x043E);
      glyphList.put("odblacute", 0x0151);
      glyphList.put("odblgrave", 0x020D);
      glyphList.put("odeva", 0x0913);
      glyphList.put("odieresis", 0x00F6);
      glyphList.put("odieresiscyrillic", 0x04E7);
      glyphList.put("odotbelow", 0x1ECD);
      glyphList.put("oe", 0x0153);
      glyphList.put("oekorean", 0x315A);
      glyphList.put("ogonek", 0x02DB);
      glyphList.put("ogonekcmb", 0x0328);
      glyphList.put("ograve", 0x00F2);
      glyphList.put("ogujarati", 0x0A93);
      glyphList.put("oharmenian", 0x0585);
      glyphList.put("ohiragana", 0x304A);
      glyphList.put("ohookabove", 0x1ECF);
      glyphList.put("ohorn", 0x01A1);
      glyphList.put("ohornacute", 0x1EDB);
      glyphList.put("ohorndotbelow", 0x1EE3);
      glyphList.put("ohorngrave", 0x1EDD);
      glyphList.put("ohornhookabove", 0x1EDF);
      glyphList.put("ohorntilde", 0x1EE1);
      glyphList.put("ohungarumlaut", 0x0151);
      glyphList.put("oi", 0x01A3);
      glyphList.put("oinvertedbreve", 0x020F);
      glyphList.put("okatakana", 0x30AA);
      glyphList.put("okatakanahalfwidth", 0xFF75);
      glyphList.put("okorean", 0x3157);
      glyphList.put("olehebrew", 0x05AB);
      glyphList.put("omacron", 0x014D);
      glyphList.put("omacronacute", 0x1E53);
      glyphList.put("omacrongrave", 0x1E51);
      glyphList.put("omdeva", 0x0950);
      glyphList.put("omega", 0x03C9);
      glyphList.put("omega1", 0x03D6);
      glyphList.put("omegacyrillic", 0x0461);
      glyphList.put("omegalatinclosed", 0x0277);
      glyphList.put("omegaroundcyrillic", 0x047B);
      glyphList.put("omegatitlocyrillic", 0x047D);
      glyphList.put("omegatonos", 0x03CE);
      glyphList.put("omgujarati", 0x0AD0);
      glyphList.put("omicron", 0x03BF);
      glyphList.put("omicrontonos", 0x03CC);
      glyphList.put("omonospace", 0xFF4F);
      glyphList.put("one", 0x0031);
      glyphList.put("onearabic", 0x0661);
      glyphList.put("onebengali", 0x09E7);
      glyphList.put("onecircle", 0x2460);
      glyphList.put("onecircleinversesansserif", 0x278A);
      glyphList.put("onedeva", 0x0967);
      glyphList.put("onedotenleader", 0x2024);
      glyphList.put("oneeighth", 0x215B);
      glyphList.put("onefitted", 0xF6DC);
      glyphList.put("onegujarati", 0x0AE7);
      glyphList.put("onegurmukhi", 0x0A67);
      glyphList.put("onehackarabic", 0x0661);
      glyphList.put("onehalf", 0x00BD);
      glyphList.put("onehangzhou", 0x3021);
      glyphList.put("oneideographicparen", 0x3220);
      glyphList.put("oneinferior", 0x2081);
      glyphList.put("onemonospace", 0xFF11);
      glyphList.put("onenumeratorbengali", 0x09F4);
      glyphList.put("oneoldstyle", 0xF731);
      glyphList.put("oneparen", 0x2474);
      glyphList.put("oneperiod", 0x2488);
      glyphList.put("onepersian", 0x06F1);
      glyphList.put("onequarter", 0x00BC);
      glyphList.put("oneroman", 0x2170);
      glyphList.put("onesuperior", 0x00B9);
      glyphList.put("onethai", 0x0E51);
      glyphList.put("onethird", 0x2153);
      glyphList.put("oogonek", 0x01EB);
      glyphList.put("oogonekmacron", 0x01ED);
      glyphList.put("oogurmukhi", 0x0A13);
      glyphList.put("oomatragurmukhi", 0x0A4B);
      glyphList.put("oopen", 0x0254);
      glyphList.put("oparen", 0x24AA);
      glyphList.put("openbullet", 0x25E6);
      glyphList.put("option", 0x2325);
      glyphList.put("ordfeminine", 0x00AA);
      glyphList.put("ordmasculine", 0x00BA);
      glyphList.put("orthogonal", 0x221F);
      glyphList.put("oshortdeva", 0x0912);
      glyphList.put("oshortvowelsigndeva", 0x094A);
      glyphList.put("oslash", 0x00F8);
      glyphList.put("oslashacute", 0x01FF);
      glyphList.put("osmallhiragana", 0x3049);
      glyphList.put("osmallkatakana", 0x30A9);
      glyphList.put("osmallkatakanahalfwidth", 0xFF6B);
      glyphList.put("ostrokeacute", 0x01FF);
      glyphList.put("osuperior", 0xF6F0);
      glyphList.put("otcyrillic", 0x047F);
      glyphList.put("otilde", 0x00F5);
      glyphList.put("otildeacute", 0x1E4D);
      glyphList.put("otildedieresis", 0x1E4F);
      glyphList.put("oubopomofo", 0x3121);
      glyphList.put("overline", 0x203E);
      glyphList.put("overlinecenterline", 0xFE4A);
      glyphList.put("overlinecmb", 0x0305);
      glyphList.put("overlinedashed", 0xFE49);
      glyphList.put("overlinedblwavy", 0xFE4C);
      glyphList.put("overlinewavy", 0xFE4B);
      glyphList.put("overscore", 0x00AF);
      glyphList.put("ovowelsignbengali", 0x09CB);
      glyphList.put("ovowelsigndeva", 0x094B);
      glyphList.put("ovowelsigngujarati", 0x0ACB);
      glyphList.put("p", 0x0070);
      glyphList.put("paampssquare", 0x3380);
      glyphList.put("paasentosquare", 0x332B);
      glyphList.put("pabengali", 0x09AA);
      glyphList.put("pacute", 0x1E55);
      glyphList.put("padeva", 0x092A);
      glyphList.put("pagedown", 0x21DF);
      glyphList.put("pageup", 0x21DE);
      glyphList.put("pagujarati", 0x0AAA);
      glyphList.put("pagurmukhi", 0x0A2A);
      glyphList.put("pahiragana", 0x3071);
      glyphList.put("paiyannoithai", 0x0E2F);
      glyphList.put("pakatakana", 0x30D1);
      glyphList.put("palatalizationcyrilliccmb", 0x0484);
      glyphList.put("palochkacyrillic", 0x04C0);
      glyphList.put("pansioskorean", 0x317F);
      glyphList.put("paragraph", 0x00B6);
      glyphList.put("parallel", 0x2225);
      glyphList.put("parenleft", 0x0028);
      glyphList.put("parenleftaltonearabic", 0xFD3E);
      glyphList.put("parenleftbt", 0xF8ED);
      glyphList.put("parenleftex", 0xF8EC);
      glyphList.put("parenleftinferior", 0x208D);
      glyphList.put("parenleftmonospace", 0xFF08);
      glyphList.put("parenleftsmall", 0xFE59);
      glyphList.put("parenleftsuperior", 0x207D);
      glyphList.put("parenlefttp", 0xF8EB);
      glyphList.put("parenleftvertical", 0xFE35);
      glyphList.put("parenright", 0x0029);
      glyphList.put("parenrightaltonearabic", 0xFD3F);
      glyphList.put("parenrightbt", 0xF8F8);
      glyphList.put("parenrightex", 0xF8F7);
      glyphList.put("parenrightinferior", 0x208E);
      glyphList.put("parenrightmonospace", 0xFF09);
      glyphList.put("parenrightsmall", 0xFE5A);
      glyphList.put("parenrightsuperior", 0x207E);
      glyphList.put("parenrighttp", 0xF8F6);
      glyphList.put("parenrightvertical", 0xFE36);
      glyphList.put("partialdiff", 0x2202);
      glyphList.put("paseqhebrew", 0x05C0);
      glyphList.put("pashtahebrew", 0x0599);
      glyphList.put("pasquare", 0x33A9);
      glyphList.put("patah", 0x05B7);
      glyphList.put("patah11", 0x05B7);
      glyphList.put("patah1d", 0x05B7);
      glyphList.put("patah2a", 0x05B7);
      glyphList.put("patahhebrew", 0x05B7);
      glyphList.put("patahnarrowhebrew", 0x05B7);
      glyphList.put("patahquarterhebrew", 0x05B7);
      glyphList.put("patahwidehebrew", 0x05B7);
      glyphList.put("pazerhebrew", 0x05A1);
      glyphList.put("pbopomofo", 0x3106);
      glyphList.put("pcircle", 0x24DF);
      glyphList.put("pdotaccent", 0x1E57);
      glyphList.put("pe", 0x05E4);
      glyphList.put("pecyrillic", 0x043F);
      glyphList.put("pedagesh", 0xFB44);
      glyphList.put("pedageshhebrew", 0xFB44);
      glyphList.put("peezisquare", 0x333B);
      glyphList.put("pefinaldageshhebrew", 0xFB43);
      glyphList.put("peharabic", 0x067E);
      glyphList.put("peharmenian", 0x057A);
      glyphList.put("pehebrew", 0x05E4);
      glyphList.put("pehfinalarabic", 0xFB57);
      glyphList.put("pehinitialarabic", 0xFB58);
      glyphList.put("pehiragana", 0x307A);
      glyphList.put("pehmedialarabic", 0xFB59);
      glyphList.put("pekatakana", 0x30DA);
      glyphList.put("pemiddlehookcyrillic", 0x04A7);
      glyphList.put("perafehebrew", 0xFB4E);
      glyphList.put("percent", 0x0025);
      glyphList.put("percentarabic", 0x066A);
      glyphList.put("percentmonospace", 0xFF05);
      glyphList.put("percentsmall", 0xFE6A);
      glyphList.put("period", 0x002E);
      glyphList.put("periodarmenian", 0x0589);
      glyphList.put("periodcentered", 0x00B7);
      glyphList.put("periodhalfwidth", 0xFF61);
      glyphList.put("periodinferior", 0xF6E7);
      glyphList.put("periodmonospace", 0xFF0E);
      glyphList.put("periodsmall", 0xFE52);
      glyphList.put("periodsuperior", 0xF6E8);
      glyphList.put("perispomenigreekcmb", 0x0342);
      glyphList.put("perpendicular", 0x22A5);
      glyphList.put("perthousand", 0x2030);
      glyphList.put("peseta", 0x20A7);
      glyphList.put("pfsquare", 0x338A);
      glyphList.put("phabengali", 0x09AB);
      glyphList.put("phadeva", 0x092B);
      glyphList.put("phagujarati", 0x0AAB);
      glyphList.put("phagurmukhi", 0x0A2B);
      glyphList.put("phi", 0x03C6);
      glyphList.put("phi1", 0x03D5);
      glyphList.put("phieuphacirclekorean", 0x327A);
      glyphList.put("phieuphaparenkorean", 0x321A);
      glyphList.put("phieuphcirclekorean", 0x326C);
      glyphList.put("phieuphkorean", 0x314D);
      glyphList.put("phieuphparenkorean", 0x320C);
      glyphList.put("philatin", 0x0278);
      glyphList.put("phinthuthai", 0x0E3A);
      glyphList.put("phisymbolgreek", 0x03D5);
      glyphList.put("phook", 0x01A5);
      glyphList.put("phophanthai", 0x0E1E);
      glyphList.put("phophungthai", 0x0E1C);
      glyphList.put("phosamphaothai", 0x0E20);
      glyphList.put("pi", 0x03C0);
      glyphList.put("pieupacirclekorean", 0x3273);
      glyphList.put("pieupaparenkorean", 0x3213);
      glyphList.put("pieupcieuckorean", 0x3176);
      glyphList.put("pieupcirclekorean", 0x3265);
      glyphList.put("pieupkiyeokkorean", 0x3172);
      glyphList.put("pieupkorean", 0x3142);
      glyphList.put("pieupparenkorean", 0x3205);
      glyphList.put("pieupsioskiyeokkorean", 0x3174);
      glyphList.put("pieupsioskorean", 0x3144);
      glyphList.put("pieupsiostikeutkorean", 0x3175);
      glyphList.put("pieupthieuthkorean", 0x3177);
      glyphList.put("pieuptikeutkorean", 0x3173);
      glyphList.put("pihiragana", 0x3074);
      glyphList.put("pikatakana", 0x30D4);
      glyphList.put("pisymbolgreek", 0x03D6);
      glyphList.put("piwrarmenian", 0x0583);
      glyphList.put("plus", 0x002B);
      glyphList.put("plusbelowcmb", 0x031F);
      glyphList.put("pluscircle", 0x2295);
      glyphList.put("plusminus", 0x00B1);
      glyphList.put("plusmod", 0x02D6);
      glyphList.put("plusmonospace", 0xFF0B);
      glyphList.put("plussmall", 0xFE62);
      glyphList.put("plussuperior", 0x207A);
      glyphList.put("pmonospace", 0xFF50);
      glyphList.put("pmsquare", 0x33D8);
      glyphList.put("pohiragana", 0x307D);
      glyphList.put("pointingindexdownwhite", 0x261F);
      glyphList.put("pointingindexleftwhite", 0x261C);
      glyphList.put("pointingindexrightwhite", 0x261E);
      glyphList.put("pointingindexupwhite", 0x261D);
      glyphList.put("pokatakana", 0x30DD);
      glyphList.put("poplathai", 0x0E1B);
      glyphList.put("postalmark", 0x3012);
      glyphList.put("postalmarkface", 0x3020);
      glyphList.put("pparen", 0x24AB);
      glyphList.put("precedes", 0x227A);
      glyphList.put("prescription", 0x211E);
      glyphList.put("primemod", 0x02B9);
      glyphList.put("primereversed", 0x2035);
      glyphList.put("product", 0x220F);
      glyphList.put("projective", 0x2305);
      glyphList.put("prolongedkana", 0x30FC);
      glyphList.put("propellor", 0x2318);
      glyphList.put("propersubset", 0x2282);
      glyphList.put("propersuperset", 0x2283);
      glyphList.put("proportion", 0x2237);
      glyphList.put("proportional", 0x221D);
      glyphList.put("psi", 0x03C8);
      glyphList.put("psicyrillic", 0x0471);
      glyphList.put("psilipneumatacyrilliccmb", 0x0486);
      glyphList.put("pssquare", 0x33B0);
      glyphList.put("puhiragana", 0x3077);
      glyphList.put("pukatakana", 0x30D7);
      glyphList.put("pvsquare", 0x33B4);
      glyphList.put("pwsquare", 0x33BA);
      glyphList.put("q", 0x0071);
      glyphList.put("qadeva", 0x0958);
      glyphList.put("qadmahebrew", 0x05A8);
      glyphList.put("qafarabic", 0x0642);
      glyphList.put("qaffinalarabic", 0xFED6);
      glyphList.put("qafinitialarabic", 0xFED7);
      glyphList.put("qafmedialarabic", 0xFED8);
      glyphList.put("qamats", 0x05B8);
      glyphList.put("qamats10", 0x05B8);
      glyphList.put("qamats1a", 0x05B8);
      glyphList.put("qamats1c", 0x05B8);
      glyphList.put("qamats27", 0x05B8);
      glyphList.put("qamats29", 0x05B8);
      glyphList.put("qamats33", 0x05B8);
      glyphList.put("qamatsde", 0x05B8);
      glyphList.put("qamatshebrew", 0x05B8);
      glyphList.put("qamatsnarrowhebrew", 0x05B8);
      glyphList.put("qamatsqatanhebrew", 0x05B8);
      glyphList.put("qamatsqatannarrowhebrew", 0x05B8);
      glyphList.put("qamatsqatanquarterhebrew", 0x05B8);
      glyphList.put("qamatsqatanwidehebrew", 0x05B8);
      glyphList.put("qamatsquarterhebrew", 0x05B8);
      glyphList.put("qamatswidehebrew", 0x05B8);
      glyphList.put("qarneyparahebrew", 0x059F);
      glyphList.put("qbopomofo", 0x3111);
      glyphList.put("qcircle", 0x24E0);
      glyphList.put("qhook", 0x02A0);
      glyphList.put("qmonospace", 0xFF51);
      glyphList.put("qof", 0x05E7);
      glyphList.put("qofdagesh", 0xFB47);
      glyphList.put("qofdageshhebrew", 0xFB47);
      /*
      glyphList.put("qofhatafpatah", 0x05E7 05B2);
      glyphList.put("qofhatafpatahhebrew", 0x05E7 05B2);
      glyphList.put("qofhatafsegol", 0x05E7 05B1);
      glyphList.put("qofhatafsegolhebrew", 0x05E7 05B1);
      */
      glyphList.put("qofhebrew", 0x05E7);
      /*
      glyphList.put("qofhiriq", 0x05E7 05B4);
      glyphList.put("qofhiriqhebrew", 0x05E7 05B4);
      glyphList.put("qofholam", 0x05E7 05B9);
      glyphList.put("qofholamhebrew", 0x05E7 05B9);
      glyphList.put("qofpatah", 0x05E7 05B7);
      glyphList.put("qofpatahhebrew", 0x05E7 05B7);
      glyphList.put("qofqamats", 0x05E7 05B8);
      glyphList.put("qofqamatshebrew", 0x05E7 05B8);
      glyphList.put("qofqubuts", 0x05E7 05BB);
      glyphList.put("qofqubutshebrew", 0x05E7 05BB);
      glyphList.put("qofsegol", 0x05E7 05B6);
      glyphList.put("qofsegolhebrew", 0x05E7 05B6);
      glyphList.put("qofsheva", 0x05E7 05B0);
      glyphList.put("qofshevahebrew", 0x05E7 05B0);
      glyphList.put("qoftsere", 0x05E7 05B5);
      glyphList.put("qoftserehebrew", 0x05E7 05B5);
      */
      glyphList.put("qparen", 0x24AC);
      glyphList.put("quarternote", 0x2669);
      glyphList.put("qubuts", 0x05BB);
      glyphList.put("qubuts18", 0x05BB);
      glyphList.put("qubuts25", 0x05BB);
      glyphList.put("qubuts31", 0x05BB);
      glyphList.put("qubutshebrew", 0x05BB);
      glyphList.put("qubutsnarrowhebrew", 0x05BB);
      glyphList.put("qubutsquarterhebrew", 0x05BB);
      glyphList.put("qubutswidehebrew", 0x05BB);
      glyphList.put("question", 0x003F);
      glyphList.put("questionarabic", 0x061F);
      glyphList.put("questionarmenian", 0x055E);
      glyphList.put("questiondown", 0x00BF);
      glyphList.put("questiondownsmall", 0xF7BF);
      glyphList.put("questiongreek", 0x037E);
      glyphList.put("questionmonospace", 0xFF1F);
      glyphList.put("questionsmall", 0xF73F);
      glyphList.put("quotedbl", 0x0022);
      glyphList.put("quotedblbase", 0x201E);
      glyphList.put("quotedblleft", 0x201C);
      glyphList.put("quotedblmonospace", 0xFF02);
      glyphList.put("quotedblprime", 0x301E);
      glyphList.put("quotedblprimereversed", 0x301D);
      glyphList.put("quotedblright", 0x201D);
      glyphList.put("quoteleft", 0x2018);
      glyphList.put("quoteleftreversed", 0x201B);
      glyphList.put("quotereversed", 0x201B);
      glyphList.put("quoteright", 0x2019);
      glyphList.put("quoterightn", 0x0149);
      glyphList.put("quotesinglbase", 0x201A);
      glyphList.put("quotesingle", 0x0027);
      glyphList.put("quotesinglemonospace", 0xFF07);
      glyphList.put("r", 0x0072);
      glyphList.put("raarmenian", 0x057C);
      glyphList.put("rabengali", 0x09B0);
      glyphList.put("racute", 0x0155);
      glyphList.put("radeva", 0x0930);
      glyphList.put("radical", 0x221A);
      glyphList.put("radicalex", 0xF8E5);
      glyphList.put("radoverssquare", 0x33AE);
      glyphList.put("radoverssquaredsquare", 0x33AF);
      glyphList.put("radsquare", 0x33AD);
      glyphList.put("rafe", 0x05BF);
      glyphList.put("rafehebrew", 0x05BF);
      glyphList.put("ragujarati", 0x0AB0);
      glyphList.put("ragurmukhi", 0x0A30);
      glyphList.put("rahiragana", 0x3089);
      glyphList.put("rakatakana", 0x30E9);
      glyphList.put("rakatakanahalfwidth", 0xFF97);
      glyphList.put("ralowerdiagonalbengali", 0x09F1);
      glyphList.put("ramiddlediagonalbengali", 0x09F0);
      glyphList.put("ramshorn", 0x0264);
      glyphList.put("ratio", 0x2236);
      glyphList.put("rbopomofo", 0x3116);
      glyphList.put("rcaron", 0x0159);
      glyphList.put("rcedilla", 0x0157);
      glyphList.put("rcircle", 0x24E1);
      glyphList.put("rcommaaccent", 0x0157);
      glyphList.put("rdblgrave", 0x0211);
      glyphList.put("rdotaccent", 0x1E59);
      glyphList.put("rdotbelow", 0x1E5B);
      glyphList.put("rdotbelowmacron", 0x1E5D);
      glyphList.put("referencemark", 0x203B);
      glyphList.put("reflexsubset", 0x2286);
      glyphList.put("reflexsuperset", 0x2287);
      glyphList.put("registered", 0x00AE);
      glyphList.put("registersans", 0xF8E8);
      glyphList.put("registerserif", 0xF6DA);
      glyphList.put("reharabic", 0x0631);
      glyphList.put("reharmenian", 0x0580);
      glyphList.put("rehfinalarabic", 0xFEAE);
      glyphList.put("rehiragana", 0x308C);
      //glyphList.put("rehyehaleflamarabic", 0x0631 FEF3 FE8E 0644);
      glyphList.put("rekatakana", 0x30EC);
      glyphList.put("rekatakanahalfwidth", 0xFF9A);
      glyphList.put("resh", 0x05E8);
      glyphList.put("reshdageshhebrew", 0xFB48);
      /*
      glyphList.put("reshhatafpatah", 0x05E8 05B2);
      glyphList.put("reshhatafpatahhebrew", 0x05E8 05B2);
      glyphList.put("reshhatafsegol", 0x05E8 05B1);
      glyphList.put("reshhatafsegolhebrew", 0x05E8 05B1);
      */
      glyphList.put("reshhebrew", 0x05E8);
      /*
      glyphList.put("reshhiriq", 0x05E8 05B4);
      glyphList.put("reshhiriqhebrew", 0x05E8 05B4);
      glyphList.put("reshholam", 0x05E8 05B9);
      glyphList.put("reshholamhebrew", 0x05E8 05B9);
      glyphList.put("reshpatah", 0x05E8 05B7);
      glyphList.put("reshpatahhebrew", 0x05E8 05B7);
      glyphList.put("reshqamats", 0x05E8 05B8);
      glyphList.put("reshqamatshebrew", 0x05E8 05B8);
      glyphList.put("reshqubuts", 0x05E8 05BB);
      glyphList.put("reshqubutshebrew", 0x05E8 05BB);
      glyphList.put("reshsegol", 0x05E8 05B6);
      glyphList.put("reshsegolhebrew", 0x05E8 05B6);
      glyphList.put("reshsheva", 0x05E8 05B0);
      glyphList.put("reshshevahebrew", 0x05E8 05B0);
      glyphList.put("reshtsere", 0x05E8 05B5);
      glyphList.put("reshtserehebrew", 0x05E8 05B5);
      */
      glyphList.put("reversedtilde", 0x223D);
      glyphList.put("reviahebrew", 0x0597);
      glyphList.put("reviamugrashhebrew", 0x0597);
      glyphList.put("revlogicalnot", 0x2310);
      glyphList.put("rfishhook", 0x027E);
      glyphList.put("rfishhookreversed", 0x027F);
      glyphList.put("rhabengali", 0x09DD);
      glyphList.put("rhadeva", 0x095D);
      glyphList.put("rho", 0x03C1);
      glyphList.put("rhook", 0x027D);
      glyphList.put("rhookturned", 0x027B);
      glyphList.put("rhookturnedsuperior", 0x02B5);
      glyphList.put("rhosymbolgreek", 0x03F1);
      glyphList.put("rhotichookmod", 0x02DE);
      glyphList.put("rieulacirclekorean", 0x3271);
      glyphList.put("rieulaparenkorean", 0x3211);
      glyphList.put("rieulcirclekorean", 0x3263);
      glyphList.put("rieulhieuhkorean", 0x3140);
      glyphList.put("rieulkiyeokkorean", 0x313A);
      glyphList.put("rieulkiyeoksioskorean", 0x3169);
      glyphList.put("rieulkorean", 0x3139);
      glyphList.put("rieulmieumkorean", 0x313B);
      glyphList.put("rieulpansioskorean", 0x316C);
      glyphList.put("rieulparenkorean", 0x3203);
      glyphList.put("rieulphieuphkorean", 0x313F);
      glyphList.put("rieulpieupkorean", 0x313C);
      glyphList.put("rieulpieupsioskorean", 0x316B);
      glyphList.put("rieulsioskorean", 0x313D);
      glyphList.put("rieulthieuthkorean", 0x313E);
      glyphList.put("rieultikeutkorean", 0x316A);
      glyphList.put("rieulyeorinhieuhkorean", 0x316D);
      glyphList.put("rightangle", 0x221F);
      glyphList.put("righttackbelowcmb", 0x0319);
      glyphList.put("righttriangle", 0x22BF);
      glyphList.put("rihiragana", 0x308A);
      glyphList.put("rikatakana", 0x30EA);
      glyphList.put("rikatakanahalfwidth", 0xFF98);
      glyphList.put("ring", 0x02DA);
      glyphList.put("ringbelowcmb", 0x0325);
      glyphList.put("ringcmb", 0x030A);
      glyphList.put("ringhalfleft", 0x02BF);
      glyphList.put("ringhalfleftarmenian", 0x0559);
      glyphList.put("ringhalfleftbelowcmb", 0x031C);
      glyphList.put("ringhalfleftcentered", 0x02D3);
      glyphList.put("ringhalfright", 0x02BE);
      glyphList.put("ringhalfrightbelowcmb", 0x0339);
      glyphList.put("ringhalfrightcentered", 0x02D2);
      glyphList.put("rinvertedbreve", 0x0213);
      glyphList.put("rittorusquare", 0x3351);
      glyphList.put("rlinebelow", 0x1E5F);
      glyphList.put("rlongleg", 0x027C);
      glyphList.put("rlonglegturned", 0x027A);
      glyphList.put("rmonospace", 0xFF52);
      glyphList.put("rohiragana", 0x308D);
      glyphList.put("rokatakana", 0x30ED);
      glyphList.put("rokatakanahalfwidth", 0xFF9B);
      glyphList.put("roruathai", 0x0E23);
      glyphList.put("rparen", 0x24AD);
      glyphList.put("rrabengali", 0x09DC);
      glyphList.put("rradeva", 0x0931);
      glyphList.put("rragurmukhi", 0x0A5C);
      glyphList.put("rreharabic", 0x0691);
      glyphList.put("rrehfinalarabic", 0xFB8D);
      glyphList.put("rrvocalicbengali", 0x09E0);
      glyphList.put("rrvocalicdeva", 0x0960);
      glyphList.put("rrvocalicgujarati", 0x0AE0);
      glyphList.put("rrvocalicvowelsignbengali", 0x09C4);
      glyphList.put("rrvocalicvowelsigndeva", 0x0944);
      glyphList.put("rrvocalicvowelsigngujarati", 0x0AC4);
      glyphList.put("rsuperior", 0xF6F1);
      glyphList.put("rtblock", 0x2590);
      glyphList.put("rturned", 0x0279);
      glyphList.put("rturnedsuperior", 0x02B4);
      glyphList.put("ruhiragana", 0x308B);
      glyphList.put("rukatakana", 0x30EB);
      glyphList.put("rukatakanahalfwidth", 0xFF99);
      glyphList.put("rupeemarkbengali", 0x09F2);
      glyphList.put("rupeesignbengali", 0x09F3);
      glyphList.put("rupiah", 0xF6DD);
      glyphList.put("ruthai", 0x0E24);
      glyphList.put("rvocalicbengali", 0x098B);
      glyphList.put("rvocalicdeva", 0x090B);
      glyphList.put("rvocalicgujarati", 0x0A8B);
      glyphList.put("rvocalicvowelsignbengali", 0x09C3);
      glyphList.put("rvocalicvowelsigndeva", 0x0943);
      glyphList.put("rvocalicvowelsigngujarati", 0x0AC3);
      glyphList.put("s", 0x0073);
      glyphList.put("sabengali", 0x09B8);
      glyphList.put("sacute", 0x015B);
      glyphList.put("sacutedotaccent", 0x1E65);
      glyphList.put("sadarabic", 0x0635);
      glyphList.put("sadeva", 0x0938);
      glyphList.put("sadfinalarabic", 0xFEBA);
      glyphList.put("sadinitialarabic", 0xFEBB);
      glyphList.put("sadmedialarabic", 0xFEBC);
      glyphList.put("sagujarati", 0x0AB8);
      glyphList.put("sagurmukhi", 0x0A38);
      glyphList.put("sahiragana", 0x3055);
      glyphList.put("sakatakana", 0x30B5);
      glyphList.put("sakatakanahalfwidth", 0xFF7B);
      glyphList.put("sallallahoualayhewasallamarabic", 0xFDFA);
      glyphList.put("samekh", 0x05E1);
      glyphList.put("samekhdagesh", 0xFB41);
      glyphList.put("samekhdageshhebrew", 0xFB41);
      glyphList.put("samekhhebrew", 0x05E1);
      glyphList.put("saraaathai", 0x0E32);
      glyphList.put("saraaethai", 0x0E41);
      glyphList.put("saraaimaimalaithai", 0x0E44);
      glyphList.put("saraaimaimuanthai", 0x0E43);
      glyphList.put("saraamthai", 0x0E33);
      glyphList.put("saraathai", 0x0E30);
      glyphList.put("saraethai", 0x0E40);
      glyphList.put("saraiileftthai", 0xF886);
      glyphList.put("saraiithai", 0x0E35);
      glyphList.put("saraileftthai", 0xF885);
      glyphList.put("saraithai", 0x0E34);
      glyphList.put("saraothai", 0x0E42);
      glyphList.put("saraueeleftthai", 0xF888);
      glyphList.put("saraueethai", 0x0E37);
      glyphList.put("saraueleftthai", 0xF887);
      glyphList.put("sarauethai", 0x0E36);
      glyphList.put("sarauthai", 0x0E38);
      glyphList.put("sarauuthai", 0x0E39);
      glyphList.put("sbopomofo", 0x3119);
      glyphList.put("scaron", 0x0161);
      glyphList.put("scarondotaccent", 0x1E67);
      glyphList.put("scedilla", 0x015F);
      glyphList.put("schwa", 0x0259);
      glyphList.put("schwacyrillic", 0x04D9);
      glyphList.put("schwadieresiscyrillic", 0x04DB);
      glyphList.put("schwahook", 0x025A);
      glyphList.put("scircle", 0x24E2);
      glyphList.put("scircumflex", 0x015D);
      glyphList.put("scommaaccent", 0x0219);
      glyphList.put("sdotaccent", 0x1E61);
      glyphList.put("sdotbelow", 0x1E63);
      glyphList.put("sdotbelowdotaccent", 0x1E69);
      glyphList.put("seagullbelowcmb", 0x033C);
      glyphList.put("second", 0x2033);
      glyphList.put("secondtonechinese", 0x02CA);
      glyphList.put("section", 0x00A7);
      glyphList.put("seenarabic", 0x0633);
      glyphList.put("seenfinalarabic", 0xFEB2);
      glyphList.put("seeninitialarabic", 0xFEB3);
      glyphList.put("seenmedialarabic", 0xFEB4);
      glyphList.put("segol", 0x05B6);
      glyphList.put("segol13", 0x05B6);
      glyphList.put("segol1f", 0x05B6);
      glyphList.put("segol2c", 0x05B6);
      glyphList.put("segolhebrew", 0x05B6);
      glyphList.put("segolnarrowhebrew", 0x05B6);
      glyphList.put("segolquarterhebrew", 0x05B6);
      glyphList.put("segoltahebrew", 0x0592);
      glyphList.put("segolwidehebrew", 0x05B6);
      glyphList.put("seharmenian", 0x057D);
      glyphList.put("sehiragana", 0x305B);
      glyphList.put("sekatakana", 0x30BB);
      glyphList.put("sekatakanahalfwidth", 0xFF7E);
      glyphList.put("semicolon", 0x003B);
      glyphList.put("semicolonarabic", 0x061B);
      glyphList.put("semicolonmonospace", 0xFF1B);
      glyphList.put("semicolonsmall", 0xFE54);
      glyphList.put("semivoicedmarkkana", 0x309C);
      glyphList.put("semivoicedmarkkanahalfwidth", 0xFF9F);
      glyphList.put("sentisquare", 0x3322);
      glyphList.put("sentosquare", 0x3323);
      glyphList.put("seven", 0x0037);
      glyphList.put("sevenarabic", 0x0667);
      glyphList.put("sevenbengali", 0x09ED);
      glyphList.put("sevencircle", 0x2466);
      glyphList.put("sevencircleinversesansserif", 0x2790);
      glyphList.put("sevendeva", 0x096D);
      glyphList.put("seveneighths", 0x215E);
      glyphList.put("sevengujarati", 0x0AED);
      glyphList.put("sevengurmukhi", 0x0A6D);
      glyphList.put("sevenhackarabic", 0x0667);
      glyphList.put("sevenhangzhou", 0x3027);
      glyphList.put("sevenideographicparen", 0x3226);
      glyphList.put("seveninferior", 0x2087);
      glyphList.put("sevenmonospace", 0xFF17);
      glyphList.put("sevenoldstyle", 0xF737);
      glyphList.put("sevenparen", 0x247A);
      glyphList.put("sevenperiod", 0x248E);
      glyphList.put("sevenpersian", 0x06F7);
      glyphList.put("sevenroman", 0x2176);
      glyphList.put("sevensuperior", 0x2077);
      glyphList.put("seventeencircle", 0x2470);
      glyphList.put("seventeenparen", 0x2484);
      glyphList.put("seventeenperiod", 0x2498);
      glyphList.put("seventhai", 0x0E57);
      glyphList.put("sfthyphen", 0x00AD);
      glyphList.put("shaarmenian", 0x0577);
      glyphList.put("shabengali", 0x09B6);
      glyphList.put("shacyrillic", 0x0448);
      glyphList.put("shaddaarabic", 0x0651);
      glyphList.put("shaddadammaarabic", 0xFC61);
      glyphList.put("shaddadammatanarabic", 0xFC5E);
      glyphList.put("shaddafathaarabic", 0xFC60);
      //glyphList.put("shaddafathatanarabic", 0x0651 064B);
      glyphList.put("shaddakasraarabic", 0xFC62);
      glyphList.put("shaddakasratanarabic", 0xFC5F);
      glyphList.put("shade", 0x2592);
      glyphList.put("shadedark", 0x2593);
      glyphList.put("shadelight", 0x2591);
      glyphList.put("shademedium", 0x2592);
      glyphList.put("shadeva", 0x0936);
      glyphList.put("shagujarati", 0x0AB6);
      glyphList.put("shagurmukhi", 0x0A36);
      glyphList.put("shalshelethebrew", 0x0593);
      glyphList.put("shbopomofo", 0x3115);
      glyphList.put("shchacyrillic", 0x0449);
      glyphList.put("sheenarabic", 0x0634);
      glyphList.put("sheenfinalarabic", 0xFEB6);
      glyphList.put("sheeninitialarabic", 0xFEB7);
      glyphList.put("sheenmedialarabic", 0xFEB8);
      glyphList.put("sheicoptic", 0x03E3);
      glyphList.put("sheqel", 0x20AA);
      glyphList.put("sheqelhebrew", 0x20AA);
      glyphList.put("sheva", 0x05B0);
      glyphList.put("sheva115", 0x05B0);
      glyphList.put("sheva15", 0x05B0);
      glyphList.put("sheva22", 0x05B0);
      glyphList.put("sheva2e", 0x05B0);
      glyphList.put("shevahebrew", 0x05B0);
      glyphList.put("shevanarrowhebrew", 0x05B0);
      glyphList.put("shevaquarterhebrew", 0x05B0);
      glyphList.put("shevawidehebrew", 0x05B0);
      glyphList.put("shhacyrillic", 0x04BB);
      glyphList.put("shimacoptic", 0x03ED);
      glyphList.put("shin", 0x05E9);
      glyphList.put("shindagesh", 0xFB49);
      glyphList.put("shindageshhebrew", 0xFB49);
      glyphList.put("shindageshshindot", 0xFB2C);
      glyphList.put("shindageshshindothebrew", 0xFB2C);
      glyphList.put("shindageshsindot", 0xFB2D);
      glyphList.put("shindageshsindothebrew", 0xFB2D);
      glyphList.put("shindothebrew", 0x05C1);
      glyphList.put("shinhebrew", 0x05E9);
      glyphList.put("shinshindot", 0xFB2A);
      glyphList.put("shinshindothebrew", 0xFB2A);
      glyphList.put("shinsindot", 0xFB2B);
      glyphList.put("shinsindothebrew", 0xFB2B);
      glyphList.put("shook", 0x0282);
      glyphList.put("sigma", 0x03C3);
      glyphList.put("sigma1", 0x03C2);
      glyphList.put("sigmafinal", 0x03C2);
      glyphList.put("sigmalunatesymbolgreek", 0x03F2);
      glyphList.put("sihiragana", 0x3057);
      glyphList.put("sikatakana", 0x30B7);
      glyphList.put("sikatakanahalfwidth", 0xFF7C);
      glyphList.put("siluqhebrew", 0x05BD);
      glyphList.put("siluqlefthebrew", 0x05BD);
      glyphList.put("similar", 0x223C);
      glyphList.put("sindothebrew", 0x05C2);
      glyphList.put("siosacirclekorean", 0x3274);
      glyphList.put("siosaparenkorean", 0x3214);
      glyphList.put("sioscieuckorean", 0x317E);
      glyphList.put("sioscirclekorean", 0x3266);
      glyphList.put("sioskiyeokkorean", 0x317A);
      glyphList.put("sioskorean", 0x3145);
      glyphList.put("siosnieunkorean", 0x317B);
      glyphList.put("siosparenkorean", 0x3206);
      glyphList.put("siospieupkorean", 0x317D);
      glyphList.put("siostikeutkorean", 0x317C);
      glyphList.put("six", 0x0036);
      glyphList.put("sixarabic", 0x0666);
      glyphList.put("sixbengali", 0x09EC);
      glyphList.put("sixcircle", 0x2465);
      glyphList.put("sixcircleinversesansserif", 0x278F);
      glyphList.put("sixdeva", 0x096C);
      glyphList.put("sixgujarati", 0x0AEC);
      glyphList.put("sixgurmukhi", 0x0A6C);
      glyphList.put("sixhackarabic", 0x0666);
      glyphList.put("sixhangzhou", 0x3026);
      glyphList.put("sixideographicparen", 0x3225);
      glyphList.put("sixinferior", 0x2086);
      glyphList.put("sixmonospace", 0xFF16);
      glyphList.put("sixoldstyle", 0xF736);
      glyphList.put("sixparen", 0x2479);
      glyphList.put("sixperiod", 0x248D);
      glyphList.put("sixpersian", 0x06F6);
      glyphList.put("sixroman", 0x2175);
      glyphList.put("sixsuperior", 0x2076);
      glyphList.put("sixteencircle", 0x246F);
      glyphList.put("sixteencurrencydenominatorbengali", 0x09F9);
      glyphList.put("sixteenparen", 0x2483);
      glyphList.put("sixteenperiod", 0x2497);
      glyphList.put("sixthai", 0x0E56);
      glyphList.put("slash", 0x002F);
      glyphList.put("slashmonospace", 0xFF0F);
      glyphList.put("slong", 0x017F);
      glyphList.put("slongdotaccent", 0x1E9B);
      glyphList.put("smileface", 0x263A);
      glyphList.put("smonospace", 0xFF53);
      glyphList.put("sofpasuqhebrew", 0x05C3);
      glyphList.put("softhyphen", 0x00AD);
      glyphList.put("softsigncyrillic", 0x044C);
      glyphList.put("sohiragana", 0x305D);
      glyphList.put("sokatakana", 0x30BD);
      glyphList.put("sokatakanahalfwidth", 0xFF7F);
      glyphList.put("soliduslongoverlaycmb", 0x0338);
      glyphList.put("solidusshortoverlaycmb", 0x0337);
      glyphList.put("sorusithai", 0x0E29);
      glyphList.put("sosalathai", 0x0E28);
      glyphList.put("sosothai", 0x0E0B);
      glyphList.put("sosuathai", 0x0E2A);
      glyphList.put("space", 0x0020);
      glyphList.put("spacehackarabic", 0x0020);
      glyphList.put("spade", 0x2660);
      glyphList.put("spadesuitblack", 0x2660);
      glyphList.put("spadesuitwhite", 0x2664);
      glyphList.put("sparen", 0x24AE);
      glyphList.put("squarebelowcmb", 0x033B);
      glyphList.put("squarecc", 0x33C4);
      glyphList.put("squarecm", 0x339D);
      glyphList.put("squarediagonalcrosshatchfill", 0x25A9);
      glyphList.put("squarehorizontalfill", 0x25A4);
      glyphList.put("squarekg", 0x338F);
      glyphList.put("squarekm", 0x339E);
      glyphList.put("squarekmcapital", 0x33CE);
      glyphList.put("squareln", 0x33D1);
      glyphList.put("squarelog", 0x33D2);
      glyphList.put("squaremg", 0x338E);
      glyphList.put("squaremil", 0x33D5);
      glyphList.put("squaremm", 0x339C);
      glyphList.put("squaremsquared", 0x33A1);
      glyphList.put("squareorthogonalcrosshatchfill", 0x25A6);
      glyphList.put("squareupperlefttolowerrightfill", 0x25A7);
      glyphList.put("squareupperrighttolowerleftfill", 0x25A8);
      glyphList.put("squareverticalfill", 0x25A5);
      glyphList.put("squarewhitewithsmallblack", 0x25A3);
      glyphList.put("srsquare", 0x33DB);
      glyphList.put("ssabengali", 0x09B7);
      glyphList.put("ssadeva", 0x0937);
      glyphList.put("ssagujarati", 0x0AB7);
      glyphList.put("ssangcieuckorean", 0x3149);
      glyphList.put("ssanghieuhkorean", 0x3185);
      glyphList.put("ssangieungkorean", 0x3180);
      glyphList.put("ssangkiyeokkorean", 0x3132);
      glyphList.put("ssangnieunkorean", 0x3165);
      glyphList.put("ssangpieupkorean", 0x3143);
      glyphList.put("ssangsioskorean", 0x3146);
      glyphList.put("ssangtikeutkorean", 0x3138);
      glyphList.put("ssuperior", 0xF6F2);
      glyphList.put("sterling", 0x00A3);
      glyphList.put("sterlingmonospace", 0xFFE1);
      glyphList.put("strokelongoverlaycmb", 0x0336);
      glyphList.put("strokeshortoverlaycmb", 0x0335);
      glyphList.put("subset", 0x2282);
      glyphList.put("subsetnotequal", 0x228A);
      glyphList.put("subsetorequal", 0x2286);
      glyphList.put("succeeds", 0x227B);
      glyphList.put("suchthat", 0x220B);
      glyphList.put("suhiragana", 0x3059);
      glyphList.put("sukatakana", 0x30B9);
      glyphList.put("sukatakanahalfwidth", 0xFF7D);
      glyphList.put("sukunarabic", 0x0652);
      glyphList.put("summation", 0x2211);
      glyphList.put("sun", 0x263C);
      glyphList.put("superset", 0x2283);
      glyphList.put("supersetnotequal", 0x228B);
      glyphList.put("supersetorequal", 0x2287);
      glyphList.put("svsquare", 0x33DC);
      glyphList.put("syouwaerasquare", 0x337C);
      glyphList.put("t", 0x0074);
      glyphList.put("tabengali", 0x09A4);
      glyphList.put("tackdown", 0x22A4);
      glyphList.put("tackleft", 0x22A3);
      glyphList.put("tadeva", 0x0924);
      glyphList.put("tagujarati", 0x0AA4);
      glyphList.put("tagurmukhi", 0x0A24);
      glyphList.put("taharabic", 0x0637);
      glyphList.put("tahfinalarabic", 0xFEC2);
      glyphList.put("tahinitialarabic", 0xFEC3);
      glyphList.put("tahiragana", 0x305F);
      glyphList.put("tahmedialarabic", 0xFEC4);
      glyphList.put("taisyouerasquare", 0x337D);
      glyphList.put("takatakana", 0x30BF);
      glyphList.put("takatakanahalfwidth", 0xFF80);
      glyphList.put("tatweelarabic", 0x0640);
      glyphList.put("tau", 0x03C4);
      glyphList.put("tav", 0x05EA);
      glyphList.put("tavdages", 0xFB4A);
      glyphList.put("tavdagesh", 0xFB4A);
      glyphList.put("tavdageshhebrew", 0xFB4A);
      glyphList.put("tavhebrew", 0x05EA);
      glyphList.put("tbar", 0x0167);
      glyphList.put("tbopomofo", 0x310A);
      glyphList.put("tcaron", 0x0165);
      glyphList.put("tccurl", 0x02A8);
      glyphList.put("tcedilla", 0x0163);
      glyphList.put("tcheharabic", 0x0686);
      glyphList.put("tchehfinalarabic", 0xFB7B);
      glyphList.put("tchehinitialarabic", 0xFB7C);
      glyphList.put("tchehmedialarabic", 0xFB7D);
      //glyphList.put("tchehmeeminitialarabic", 0xFB7CFEE4);
      glyphList.put("tcircle", 0x24E3);
      glyphList.put("tcircumflexbelow", 0x1E71);
      glyphList.put("tcommaaccent", 0x0163);
      glyphList.put("tdieresis", 0x1E97);
      glyphList.put("tdotaccent", 0x1E6B);
      glyphList.put("tdotbelow", 0x1E6D);
      glyphList.put("tecyrillic", 0x0442);
      glyphList.put("tedescendercyrillic", 0x04AD);
      glyphList.put("teharabic", 0x062A);
      glyphList.put("tehfinalarabic", 0xFE96);
      glyphList.put("tehhahinitialarabic", 0xFCA2);
      glyphList.put("tehhahisolatedarabic", 0xFC0C);
      glyphList.put("tehinitialarabic", 0xFE97);
      glyphList.put("tehiragana", 0x3066);
      glyphList.put("tehjeeminitialarabic", 0xFCA1);
      glyphList.put("tehjeemisolatedarabic", 0xFC0B);
      glyphList.put("tehmarbutaarabic", 0x0629);
      glyphList.put("tehmarbutafinalarabic", 0xFE94);
      glyphList.put("tehmedialarabic", 0xFE98);
      glyphList.put("tehmeeminitialarabic", 0xFCA4);
      glyphList.put("tehmeemisolatedarabic", 0xFC0E);
      glyphList.put("tehnoonfinalarabic", 0xFC73);
      glyphList.put("tekatakana", 0x30C6);
      glyphList.put("tekatakanahalfwidth", 0xFF83);
      glyphList.put("telephone", 0x2121);
      glyphList.put("telephoneblack", 0x260E);
      glyphList.put("telishagedolahebrew", 0x05A0);
      glyphList.put("telishaqetanahebrew", 0x05A9);
      glyphList.put("tencircle", 0x2469);
      glyphList.put("tenideographicparen", 0x3229);
      glyphList.put("tenparen", 0x247D);
      glyphList.put("tenperiod", 0x2491);
      glyphList.put("tenroman", 0x2179);
      glyphList.put("tesh", 0x02A7);
      glyphList.put("tet", 0x05D8);
      glyphList.put("tetdagesh", 0xFB38);
      glyphList.put("tetdageshhebrew", 0xFB38);
      glyphList.put("tethebrew", 0x05D8);
      glyphList.put("tetsecyrillic", 0x04B5);
      glyphList.put("tevirhebrew", 0x059B);
      glyphList.put("tevirlefthebrew", 0x059B);
      glyphList.put("thabengali", 0x09A5);
      glyphList.put("thadeva", 0x0925);
      glyphList.put("thagujarati", 0x0AA5);
      glyphList.put("thagurmukhi", 0x0A25);
      glyphList.put("thalarabic", 0x0630);
      glyphList.put("thalfinalarabic", 0xFEAC);
      glyphList.put("thanthakhatlowleftthai", 0xF898);
      glyphList.put("thanthakhatlowrightthai", 0xF897);
      glyphList.put("thanthakhatthai", 0x0E4C);
      glyphList.put("thanthakhatupperleftthai", 0xF896);
      glyphList.put("theharabic", 0x062B);
      glyphList.put("thehfinalarabic", 0xFE9A);
      glyphList.put("thehinitialarabic", 0xFE9B);
      glyphList.put("thehmedialarabic", 0xFE9C);
      glyphList.put("thereexists", 0x2203);
      glyphList.put("therefore", 0x2234);
      glyphList.put("theta", 0x03B8);
      glyphList.put("theta1", 0x03D1);
      glyphList.put("thetasymbolgreek", 0x03D1);
      glyphList.put("thieuthacirclekorean", 0x3279);
      glyphList.put("thieuthaparenkorean", 0x3219);
      glyphList.put("thieuthcirclekorean", 0x326B);
      glyphList.put("thieuthkorean", 0x314C);
      glyphList.put("thieuthparenkorean", 0x320B);
      glyphList.put("thirteencircle", 0x246C);
      glyphList.put("thirteenparen", 0x2480);
      glyphList.put("thirteenperiod", 0x2494);
      glyphList.put("thonangmonthothai", 0x0E11);
      glyphList.put("thook", 0x01AD);
      glyphList.put("thophuthaothai", 0x0E12);
      glyphList.put("thorn", 0x00FE);
      glyphList.put("thothahanthai", 0x0E17);
      glyphList.put("thothanthai", 0x0E10);
      glyphList.put("thothongthai", 0x0E18);
      glyphList.put("thothungthai", 0x0E16);
      glyphList.put("thousandcyrillic", 0x0482);
      glyphList.put("thousandsseparatorarabic", 0x066C);
      glyphList.put("thousandsseparatorpersian", 0x066C);
      glyphList.put("three", 0x0033);
      glyphList.put("threearabic", 0x0663);
      glyphList.put("threebengali", 0x09E9);
      glyphList.put("threecircle", 0x2462);
      glyphList.put("threecircleinversesansserif", 0x278C);
      glyphList.put("threedeva", 0x0969);
      glyphList.put("threeeighths", 0x215C);
      glyphList.put("threegujarati", 0x0AE9);
      glyphList.put("threegurmukhi", 0x0A69);
      glyphList.put("threehackarabic", 0x0663);
      glyphList.put("threehangzhou", 0x3023);
      glyphList.put("threeideographicparen", 0x3222);
      glyphList.put("threeinferior", 0x2083);
      glyphList.put("threemonospace", 0xFF13);
      glyphList.put("threenumeratorbengali", 0x09F6);
      glyphList.put("threeoldstyle", 0xF733);
      glyphList.put("threeparen", 0x2476);
      glyphList.put("threeperiod", 0x248A);
      glyphList.put("threepersian", 0x06F3);
      glyphList.put("threequarters", 0x00BE);
      glyphList.put("threequartersemdash", 0xF6DE);
      glyphList.put("threeroman", 0x2172);
      glyphList.put("threesuperior", 0x00B3);
      glyphList.put("threethai", 0x0E53);
      glyphList.put("thzsquare", 0x3394);
      glyphList.put("tihiragana", 0x3061);
      glyphList.put("tikatakana", 0x30C1);
      glyphList.put("tikatakanahalfwidth", 0xFF81);
      glyphList.put("tikeutacirclekorean", 0x3270);
      glyphList.put("tikeutaparenkorean", 0x3210);
      glyphList.put("tikeutcirclekorean", 0x3262);
      glyphList.put("tikeutkorean", 0x3137);
      glyphList.put("tikeutparenkorean", 0x3202);
      glyphList.put("tilde", 0x02DC);
      glyphList.put("tildebelowcmb", 0x0330);
      glyphList.put("tildecmb", 0x0303);
      glyphList.put("tildecomb", 0x0303);
      glyphList.put("tildedoublecmb", 0x0360);
      glyphList.put("tildeoperator", 0x223C);
      glyphList.put("tildeoverlaycmb", 0x0334);
      glyphList.put("tildeverticalcmb", 0x033E);
      glyphList.put("timescircle", 0x2297);
      glyphList.put("tipehahebrew", 0x0596);
      glyphList.put("tipehalefthebrew", 0x0596);
      glyphList.put("tippigurmukhi", 0x0A70);
      glyphList.put("titlocyrilliccmb", 0x0483);
      glyphList.put("tiwnarmenian", 0x057F);
      glyphList.put("tlinebelow", 0x1E6F);
      glyphList.put("tmonospace", 0xFF54);
      glyphList.put("toarmenian", 0x0569);
      glyphList.put("tohiragana", 0x3068);
      glyphList.put("tokatakana", 0x30C8);
      glyphList.put("tokatakanahalfwidth", 0xFF84);
      glyphList.put("tonebarextrahighmod", 0x02E5);
      glyphList.put("tonebarextralowmod", 0x02E9);
      glyphList.put("tonebarhighmod", 0x02E6);
      glyphList.put("tonebarlowmod", 0x02E8);
      glyphList.put("tonebarmidmod", 0x02E7);
      glyphList.put("tonefive", 0x01BD);
      glyphList.put("tonesix", 0x0185);
      glyphList.put("tonetwo", 0x01A8);
      glyphList.put("tonos", 0x0384);
      glyphList.put("tonsquare", 0x3327);
      glyphList.put("topatakthai", 0x0E0F);
      glyphList.put("tortoiseshellbracketleft", 0x3014);
      glyphList.put("tortoiseshellbracketleftsmall", 0xFE5D);
      glyphList.put("tortoiseshellbracketleftvertical", 0xFE39);
      glyphList.put("tortoiseshellbracketright", 0x3015);
      glyphList.put("tortoiseshellbracketrightsmall", 0xFE5E);
      glyphList.put("tortoiseshellbracketrightvertical", 0xFE3A);
      glyphList.put("totaothai", 0x0E15);
      glyphList.put("tpalatalhook", 0x01AB);
      glyphList.put("tparen", 0x24AF);
      glyphList.put("trademark", 0x2122);
      glyphList.put("trademarksans", 0xF8EA);
      glyphList.put("trademarkserif", 0xF6DB);
      glyphList.put("tretroflexhook", 0x0288);
      glyphList.put("triagdn", 0x25BC);
      glyphList.put("triaglf", 0x25C4);
      glyphList.put("triagrt", 0x25BA);
      glyphList.put("triagup", 0x25B2);
      glyphList.put("ts", 0x02A6);
      glyphList.put("tsadi", 0x05E6);
      glyphList.put("tsadidagesh", 0xFB46);
      glyphList.put("tsadidageshhebrew", 0xFB46);
      glyphList.put("tsadihebrew", 0x05E6);
      glyphList.put("tsecyrillic", 0x0446);
      glyphList.put("tsere", 0x05B5);
      glyphList.put("tsere12", 0x05B5);
      glyphList.put("tsere1e", 0x05B5);
      glyphList.put("tsere2b", 0x05B5);
      glyphList.put("tserehebrew", 0x05B5);
      glyphList.put("tserenarrowhebrew", 0x05B5);
      glyphList.put("tserequarterhebrew", 0x05B5);
      glyphList.put("tserewidehebrew", 0x05B5);
      glyphList.put("tshecyrillic", 0x045B);
      glyphList.put("tsuperior", 0xF6F3);
      glyphList.put("ttabengali", 0x099F);
      glyphList.put("ttadeva", 0x091F);
      glyphList.put("ttagujarati", 0x0A9F);
      glyphList.put("ttagurmukhi", 0x0A1F);
      glyphList.put("tteharabic", 0x0679);
      glyphList.put("ttehfinalarabic", 0xFB67);
      glyphList.put("ttehinitialarabic", 0xFB68);
      glyphList.put("ttehmedialarabic", 0xFB69);
      glyphList.put("tthabengali", 0x09A0);
      glyphList.put("tthadeva", 0x0920);
      glyphList.put("tthagujarati", 0x0AA0);
      glyphList.put("tthagurmukhi", 0x0A20);
      glyphList.put("tturned", 0x0287);
      glyphList.put("tuhiragana", 0x3064);
      glyphList.put("tukatakana", 0x30C4);
      glyphList.put("tukatakanahalfwidth", 0xFF82);
      glyphList.put("tusmallhiragana", 0x3063);
      glyphList.put("tusmallkatakana", 0x30C3);
      glyphList.put("tusmallkatakanahalfwidth", 0xFF6F);
      glyphList.put("twelvecircle", 0x246B);
      glyphList.put("twelveparen", 0x247F);
      glyphList.put("twelveperiod", 0x2493);
      glyphList.put("twelveroman", 0x217B);
      glyphList.put("twentycircle", 0x2473);
      glyphList.put("twentyhangzhou", 0x5344);
      glyphList.put("twentyparen", 0x2487);
      glyphList.put("twentyperiod", 0x249B);
      glyphList.put("two", 0x0032);
      glyphList.put("twoarabic", 0x0662);
      glyphList.put("twobengali", 0x09E8);
      glyphList.put("twocircle", 0x2461);
      glyphList.put("twocircleinversesansserif", 0x278B);
      glyphList.put("twodeva", 0x0968);
      glyphList.put("twodotenleader", 0x2025);
      glyphList.put("twodotleader", 0x2025);
      glyphList.put("twodotleadervertical", 0xFE30);
      glyphList.put("twogujarati", 0x0AE8);
      glyphList.put("twogurmukhi", 0x0A68);
      glyphList.put("twohackarabic", 0x0662);
      glyphList.put("twohangzhou", 0x3022);
      glyphList.put("twoideographicparen", 0x3221);
      glyphList.put("twoinferior", 0x2082);
      glyphList.put("twomonospace", 0xFF12);
      glyphList.put("twonumeratorbengali", 0x09F5);
      glyphList.put("twooldstyle", 0xF732);
      glyphList.put("twoparen", 0x2475);
      glyphList.put("twoperiod", 0x2489);
      glyphList.put("twopersian", 0x06F2);
      glyphList.put("tworoman", 0x2171);
      glyphList.put("twostroke", 0x01BB);
      glyphList.put("twosuperior", 0x00B2);
      glyphList.put("twothai", 0x0E52);
      glyphList.put("twothirds", 0x2154);
      glyphList.put("u", 0x0075);
      glyphList.put("uacute", 0x00FA);
      glyphList.put("ubar", 0x0289);
      glyphList.put("ubengali", 0x0989);
      glyphList.put("ubopomofo", 0x3128);
      glyphList.put("ubreve", 0x016D);
      glyphList.put("ucaron", 0x01D4);
      glyphList.put("ucircle", 0x24E4);
      glyphList.put("ucircumflex", 0x00FB);
      glyphList.put("ucircumflexbelow", 0x1E77);
      glyphList.put("ucyrillic", 0x0443);
      glyphList.put("udattadeva", 0x0951);
      glyphList.put("udblacute", 0x0171);
      glyphList.put("udblgrave", 0x0215);
      glyphList.put("udeva", 0x0909);
      glyphList.put("udieresis", 0x00FC);
      glyphList.put("udieresisacute", 0x01D8);
      glyphList.put("udieresisbelow", 0x1E73);
      glyphList.put("udieresiscaron", 0x01DA);
      glyphList.put("udieresiscyrillic", 0x04F1);
      glyphList.put("udieresisgrave", 0x01DC);
      glyphList.put("udieresismacron", 0x01D6);
      glyphList.put("udotbelow", 0x1EE5);
      glyphList.put("ugrave", 0x00F9);
      glyphList.put("ugujarati", 0x0A89);
      glyphList.put("ugurmukhi", 0x0A09);
      glyphList.put("uhiragana", 0x3046);
      glyphList.put("uhookabove", 0x1EE7);
      glyphList.put("uhorn", 0x01B0);
      glyphList.put("uhornacute", 0x1EE9);
      glyphList.put("uhorndotbelow", 0x1EF1);
      glyphList.put("uhorngrave", 0x1EEB);
      glyphList.put("uhornhookabove", 0x1EED);
      glyphList.put("uhorntilde", 0x1EEF);
      glyphList.put("uhungarumlaut", 0x0171);
      glyphList.put("uhungarumlautcyrillic", 0x04F3);
      glyphList.put("uinvertedbreve", 0x0217);
      glyphList.put("ukatakana", 0x30A6);
      glyphList.put("ukatakanahalfwidth", 0xFF73);
      glyphList.put("ukcyrillic", 0x0479);
      glyphList.put("ukorean", 0x315C);
      glyphList.put("umacron", 0x016B);
      glyphList.put("umacroncyrillic", 0x04EF);
      glyphList.put("umacrondieresis", 0x1E7B);
      glyphList.put("umatragurmukhi", 0x0A41);
      glyphList.put("umonospace", 0xFF55);
      glyphList.put("underscore", 0x005F);
      glyphList.put("underscoredbl", 0x2017);
      glyphList.put("underscoremonospace", 0xFF3F);
      glyphList.put("underscorevertical", 0xFE33);
      glyphList.put("underscorewavy", 0xFE4F);
      glyphList.put("union", 0x222A);
      glyphList.put("universal", 0x2200);
      glyphList.put("uogonek", 0x0173);
      glyphList.put("uparen", 0x24B0);
      glyphList.put("upblock", 0x2580);
      glyphList.put("upperdothebrew", 0x05C4);
      glyphList.put("upsilon", 0x03C5);
      glyphList.put("upsilondieresis", 0x03CB);
      glyphList.put("upsilondieresistonos", 0x03B0);
      glyphList.put("upsilonlatin", 0x028A);
      glyphList.put("upsilontonos", 0x03CD);
      glyphList.put("uptackbelowcmb", 0x031D);
      glyphList.put("uptackmod", 0x02D4);
      glyphList.put("uragurmukhi", 0x0A73);
      glyphList.put("uring", 0x016F);
      glyphList.put("ushortcyrillic", 0x045E);
      glyphList.put("usmallhiragana", 0x3045);
      glyphList.put("usmallkatakana", 0x30A5);
      glyphList.put("usmallkatakanahalfwidth", 0xFF69);
      glyphList.put("ustraightcyrillic", 0x04AF);
      glyphList.put("ustraightstrokecyrillic", 0x04B1);
      glyphList.put("utilde", 0x0169);
      glyphList.put("utildeacute", 0x1E79);
      glyphList.put("utildebelow", 0x1E75);
      glyphList.put("uubengali", 0x098A);
      glyphList.put("uudeva", 0x090A);
      glyphList.put("uugujarati", 0x0A8A);
      glyphList.put("uugurmukhi", 0x0A0A);
      glyphList.put("uumatragurmukhi", 0x0A42);
      glyphList.put("uuvowelsignbengali", 0x09C2);
      glyphList.put("uuvowelsigndeva", 0x0942);
      glyphList.put("uuvowelsigngujarati", 0x0AC2);
      glyphList.put("uvowelsignbengali", 0x09C1);
      glyphList.put("uvowelsigndeva", 0x0941);
      glyphList.put("uvowelsigngujarati", 0x0AC1);
      glyphList.put("v", 0x0076);
      glyphList.put("vadeva", 0x0935);
      glyphList.put("vagujarati", 0x0AB5);
      glyphList.put("vagurmukhi", 0x0A35);
      glyphList.put("vakatakana", 0x30F7);
      glyphList.put("vav", 0x05D5);
      glyphList.put("vavdagesh", 0xFB35);
      glyphList.put("vavdagesh65", 0xFB35);
      glyphList.put("vavdageshhebrew", 0xFB35);
      glyphList.put("vavhebrew", 0x05D5);
      glyphList.put("vavholam", 0xFB4B);
      glyphList.put("vavholamhebrew", 0xFB4B);
      glyphList.put("vavvavhebrew", 0x05F0);
      glyphList.put("vavyodhebrew", 0x05F1);
      glyphList.put("vcircle", 0x24E5);
      glyphList.put("vdotbelow", 0x1E7F);
      glyphList.put("vecyrillic", 0x0432);
      glyphList.put("veharabic", 0x06A4);
      glyphList.put("vehfinalarabic", 0xFB6B);
      glyphList.put("vehinitialarabic", 0xFB6C);
      glyphList.put("vehmedialarabic", 0xFB6D);
      glyphList.put("vekatakana", 0x30F9);
      glyphList.put("venus", 0x2640);
      glyphList.put("verticalbar", 0x007C);
      glyphList.put("verticallineabovecmb", 0x030D);
      glyphList.put("verticallinebelowcmb", 0x0329);
      glyphList.put("verticallinelowmod", 0x02CC);
      glyphList.put("verticallinemod", 0x02C8);
      glyphList.put("vewarmenian", 0x057E);
      glyphList.put("vhook", 0x028B);
      glyphList.put("vikatakana", 0x30F8);
      glyphList.put("viramabengali", 0x09CD);
      glyphList.put("viramadeva", 0x094D);
      glyphList.put("viramagujarati", 0x0ACD);
      glyphList.put("visargabengali", 0x0983);
      glyphList.put("visargadeva", 0x0903);
      glyphList.put("visargagujarati", 0x0A83);
      glyphList.put("vmonospace", 0xFF56);
      glyphList.put("voarmenian", 0x0578);
      glyphList.put("voicediterationhiragana", 0x309E);
      glyphList.put("voicediterationkatakana", 0x30FE);
      glyphList.put("voicedmarkkana", 0x309B);
      glyphList.put("voicedmarkkanahalfwidth", 0xFF9E);
      glyphList.put("vokatakana", 0x30FA);
      glyphList.put("vparen", 0x24B1);
      glyphList.put("vtilde", 0x1E7D);
      glyphList.put("vturned", 0x028C);
      glyphList.put("vuhiragana", 0x3094);
      glyphList.put("vukatakana", 0x30F4);
      glyphList.put("w", 0x0077);
      glyphList.put("wacute", 0x1E83);
      glyphList.put("waekorean", 0x3159);
      glyphList.put("wahiragana", 0x308F);
      glyphList.put("wakatakana", 0x30EF);
      glyphList.put("wakatakanahalfwidth", 0xFF9C);
      glyphList.put("wakorean", 0x3158);
      glyphList.put("wasmallhiragana", 0x308E);
      glyphList.put("wasmallkatakana", 0x30EE);
      glyphList.put("wattosquare", 0x3357);
      glyphList.put("wavedash", 0x301C);
      glyphList.put("wavyunderscorevertical", 0xFE34);
      glyphList.put("wawarabic", 0x0648);
      glyphList.put("wawfinalarabic", 0xFEEE);
      glyphList.put("wawhamzaabovearabic", 0x0624);
      glyphList.put("wawhamzaabovefinalarabic", 0xFE86);
      glyphList.put("wbsquare", 0x33DD);
      glyphList.put("wcircle", 0x24E6);
      glyphList.put("wcircumflex", 0x0175);
      glyphList.put("wdieresis", 0x1E85);
      glyphList.put("wdotaccent", 0x1E87);
      glyphList.put("wdotbelow", 0x1E89);
      glyphList.put("wehiragana", 0x3091);
      glyphList.put("weierstrass", 0x2118);
      glyphList.put("wekatakana", 0x30F1);
      glyphList.put("wekorean", 0x315E);
      glyphList.put("weokorean", 0x315D);
      glyphList.put("wgrave", 0x1E81);
      glyphList.put("whitebullet", 0x25E6);
      glyphList.put("whitecircle", 0x25CB);
      glyphList.put("whitecircleinverse", 0x25D9);
      glyphList.put("whitecornerbracketleft", 0x300E);
      glyphList.put("whitecornerbracketleftvertical", 0xFE43);
      glyphList.put("whitecornerbracketright", 0x300F);
      glyphList.put("whitecornerbracketrightvertical", 0xFE44);
      glyphList.put("whitediamond", 0x25C7);
      glyphList.put("whitediamondcontainingblacksmalldiamond", 0x25C8);
      glyphList.put("whitedownpointingsmalltriangle", 0x25BF);
      glyphList.put("whitedownpointingtriangle", 0x25BD);
      glyphList.put("whiteleftpointingsmalltriangle", 0x25C3);
      glyphList.put("whiteleftpointingtriangle", 0x25C1);
      glyphList.put("whitelenticularbracketleft", 0x3016);
      glyphList.put("whitelenticularbracketright", 0x3017);
      glyphList.put("whiterightpointingsmalltriangle", 0x25B9);
      glyphList.put("whiterightpointingtriangle", 0x25B7);
      glyphList.put("whitesmallsquare", 0x25AB);
      glyphList.put("whitesmilingface", 0x263A);
      glyphList.put("whitesquare", 0x25A1);
      glyphList.put("whitestar", 0x2606);
      glyphList.put("whitetelephone", 0x260F);
      glyphList.put("whitetortoiseshellbracketleft", 0x3018);
      glyphList.put("whitetortoiseshellbracketright", 0x3019);
      glyphList.put("whiteuppointingsmalltriangle", 0x25B5);
      glyphList.put("whiteuppointingtriangle", 0x25B3);
      glyphList.put("wihiragana", 0x3090);
      glyphList.put("wikatakana", 0x30F0);
      glyphList.put("wikorean", 0x315F);
      glyphList.put("wmonospace", 0xFF57);
      glyphList.put("wohiragana", 0x3092);
      glyphList.put("wokatakana", 0x30F2);
      glyphList.put("wokatakanahalfwidth", 0xFF66);
      glyphList.put("won", 0x20A9);
      glyphList.put("wonmonospace", 0xFFE6);
      glyphList.put("wowaenthai", 0x0E27);
      glyphList.put("wparen", 0x24B2);
      glyphList.put("wring", 0x1E98);
      glyphList.put("wsuperior", 0x02B7);
      glyphList.put("wturned", 0x028D);
      glyphList.put("wynn", 0x01BF);
      glyphList.put("x", 0x0078);
      glyphList.put("xabovecmb", 0x033D);
      glyphList.put("xbopomofo", 0x3112);
      glyphList.put("xcircle", 0x24E7);
      glyphList.put("xdieresis", 0x1E8D);
      glyphList.put("xdotaccent", 0x1E8B);
      glyphList.put("xeharmenian", 0x056D);
      glyphList.put("xi", 0x03BE);
      glyphList.put("xmonospace", 0xFF58);
      glyphList.put("xparen", 0x24B3);
      glyphList.put("xsuperior", 0x02E3);
      glyphList.put("y", 0x0079);
      glyphList.put("yaadosquare", 0x334E);
      glyphList.put("yabengali", 0x09AF);
      glyphList.put("yacute", 0x00FD);
      glyphList.put("yadeva", 0x092F);
      glyphList.put("yaekorean", 0x3152);
      glyphList.put("yagujarati", 0x0AAF);
      glyphList.put("yagurmukhi", 0x0A2F);
      glyphList.put("yahiragana", 0x3084);
      glyphList.put("yakatakana", 0x30E4);
      glyphList.put("yakatakanahalfwidth", 0xFF94);
      glyphList.put("yakorean", 0x3151);
      glyphList.put("yamakkanthai", 0x0E4E);
      glyphList.put("yasmallhiragana", 0x3083);
      glyphList.put("yasmallkatakana", 0x30E3);
      glyphList.put("yasmallkatakanahalfwidth", 0xFF6C);
      glyphList.put("yatcyrillic", 0x0463);
      glyphList.put("ycircle", 0x24E8);
      glyphList.put("ycircumflex", 0x0177);
      glyphList.put("ydieresis", 0x00FF);
      glyphList.put("ydotaccent", 0x1E8F);
      glyphList.put("ydotbelow", 0x1EF5);
      glyphList.put("yeharabic", 0x064A);
      glyphList.put("yehbarreearabic", 0x06D2);
      glyphList.put("yehbarreefinalarabic", 0xFBAF);
      glyphList.put("yehfinalarabic", 0xFEF2);
      glyphList.put("yehhamzaabovearabic", 0x0626);
      glyphList.put("yehhamzaabovefinalarabic", 0xFE8A);
      glyphList.put("yehhamzaaboveinitialarabic", 0xFE8B);
      glyphList.put("yehhamzaabovemedialarabic", 0xFE8C);
      glyphList.put("yehinitialarabic", 0xFEF3);
      glyphList.put("yehmedialarabic", 0xFEF4);
      glyphList.put("yehmeeminitialarabic", 0xFCDD);
      glyphList.put("yehmeemisolatedarabic", 0xFC58);
      glyphList.put("yehnoonfinalarabic", 0xFC94);
      glyphList.put("yehthreedotsbelowarabic", 0x06D1);
      glyphList.put("yekorean", 0x3156);
      glyphList.put("yen", 0x00A5);
      glyphList.put("yenmonospace", 0xFFE5);
      glyphList.put("yeokorean", 0x3155);
      glyphList.put("yeorinhieuhkorean", 0x3186);
      glyphList.put("yerahbenyomohebrew", 0x05AA);
      glyphList.put("yerahbenyomolefthebrew", 0x05AA);
      glyphList.put("yericyrillic", 0x044B);
      glyphList.put("yerudieresiscyrillic", 0x04F9);
      glyphList.put("yesieungkorean", 0x3181);
      glyphList.put("yesieungpansioskorean", 0x3183);
      glyphList.put("yesieungsioskorean", 0x3182);
      glyphList.put("yetivhebrew", 0x059A);
      glyphList.put("ygrave", 0x1EF3);
      glyphList.put("yhook", 0x01B4);
      glyphList.put("yhookabove", 0x1EF7);
      glyphList.put("yiarmenian", 0x0575);
      glyphList.put("yicyrillic", 0x0457);
      glyphList.put("yikorean", 0x3162);
      glyphList.put("yinyang", 0x262F);
      glyphList.put("yiwnarmenian", 0x0582);
      glyphList.put("ymonospace", 0xFF59);
      glyphList.put("yod", 0x05D9);
      glyphList.put("yoddagesh", 0xFB39);
      glyphList.put("yoddageshhebrew", 0xFB39);
      glyphList.put("yodhebrew", 0x05D9);
      glyphList.put("yodyodhebrew", 0x05F2);
      glyphList.put("yodyodpatahhebrew", 0xFB1F);
      glyphList.put("yohiragana", 0x3088);
      glyphList.put("yoikorean", 0x3189);
      glyphList.put("yokatakana", 0x30E8);
      glyphList.put("yokatakanahalfwidth", 0xFF96);
      glyphList.put("yokorean", 0x315B);
      glyphList.put("yosmallhiragana", 0x3087);
      glyphList.put("yosmallkatakana", 0x30E7);
      glyphList.put("yosmallkatakanahalfwidth", 0xFF6E);
      glyphList.put("yotgreek", 0x03F3);
      glyphList.put("yoyaekorean", 0x3188);
      glyphList.put("yoyakorean", 0x3187);
      glyphList.put("yoyakthai", 0x0E22);
      glyphList.put("yoyingthai", 0x0E0D);
      glyphList.put("yparen", 0x24B4);
      glyphList.put("ypogegrammeni", 0x037A);
      glyphList.put("ypogegrammenigreekcmb", 0x0345);
      glyphList.put("yr", 0x01A6);
      glyphList.put("yring", 0x1E99);
      glyphList.put("ysuperior", 0x02B8);
      glyphList.put("ytilde", 0x1EF9);
      glyphList.put("yturned", 0x028E);
      glyphList.put("yuhiragana", 0x3086);
      glyphList.put("yuikorean", 0x318C);
      glyphList.put("yukatakana", 0x30E6);
      glyphList.put("yukatakanahalfwidth", 0xFF95);
      glyphList.put("yukorean", 0x3160);
      glyphList.put("yusbigcyrillic", 0x046B);
      glyphList.put("yusbigiotifiedcyrillic", 0x046D);
      glyphList.put("yuslittlecyrillic", 0x0467);
      glyphList.put("yuslittleiotifiedcyrillic", 0x0469);
      glyphList.put("yusmallhiragana", 0x3085);
      glyphList.put("yusmallkatakana", 0x30E5);
      glyphList.put("yusmallkatakanahalfwidth", 0xFF6D);
      glyphList.put("yuyekorean", 0x318B);
      glyphList.put("yuyeokorean", 0x318A);
      glyphList.put("yyabengali", 0x09DF);
      glyphList.put("yyadeva", 0x095F);
      glyphList.put("z", 0x007A);
      glyphList.put("zaarmenian", 0x0566);
      glyphList.put("zacute", 0x017A);
      glyphList.put("zadeva", 0x095B);
      glyphList.put("zagurmukhi", 0x0A5B);
      glyphList.put("zaharabic", 0x0638);
      glyphList.put("zahfinalarabic", 0xFEC6);
      glyphList.put("zahinitialarabic", 0xFEC7);
      glyphList.put("zahiragana", 0x3056);
      glyphList.put("zahmedialarabic", 0xFEC8);
      glyphList.put("zainarabic", 0x0632);
      glyphList.put("zainfinalarabic", 0xFEB0);
      glyphList.put("zakatakana", 0x30B6);
      glyphList.put("zaqefgadolhebrew", 0x0595);
      glyphList.put("zaqefqatanhebrew", 0x0594);
      glyphList.put("zarqahebrew", 0x0598);
      glyphList.put("zayin", 0x05D6);
      glyphList.put("zayindagesh", 0xFB36);
      glyphList.put("zayindageshhebrew", 0xFB36);
      glyphList.put("zayinhebrew", 0x05D6);
      glyphList.put("zbopomofo", 0x3117);
      glyphList.put("zcaron", 0x017E);
      glyphList.put("zcircle", 0x24E9);
      glyphList.put("zcircumflex", 0x1E91);
      glyphList.put("zcurl", 0x0291);
      glyphList.put("zdot", 0x017C);
      glyphList.put("zdotaccent", 0x017C);
      glyphList.put("zdotbelow", 0x1E93);
      glyphList.put("zecyrillic", 0x0437);
      glyphList.put("zedescendercyrillic", 0x0499);
      glyphList.put("zedieresiscyrillic", 0x04DF);
      glyphList.put("zehiragana", 0x305C);
      glyphList.put("zekatakana", 0x30BC);
      glyphList.put("zero", 0x0030);
      glyphList.put("zeroarabic", 0x0660);
      glyphList.put("zerobengali", 0x09E6);
      glyphList.put("zerodeva", 0x0966);
      glyphList.put("zerogujarati", 0x0AE6);
      glyphList.put("zerogurmukhi", 0x0A66);
      glyphList.put("zerohackarabic", 0x0660);
      glyphList.put("zeroinferior", 0x2080);
      glyphList.put("zeromonospace", 0xFF10);
      glyphList.put("zerooldstyle", 0xF730);
      glyphList.put("zeropersian", 0x06F0);
      glyphList.put("zerosuperior", 0x2070);
      glyphList.put("zerothai", 0x0E50);
      glyphList.put("zerowidthjoiner", 0xFEFF);
      glyphList.put("zerowidthnonjoiner", 0x200C);
      glyphList.put("zerowidthspace", 0x200B);
      glyphList.put("zeta", 0x03B6);
      glyphList.put("zhbopomofo", 0x3113);
      glyphList.put("zhearmenian", 0x056A);
      glyphList.put("zhebrevecyrillic", 0x04C2);
      glyphList.put("zhecyrillic", 0x0436);
      glyphList.put("zhedescendercyrillic", 0x0497);
      glyphList.put("zhedieresiscyrillic", 0x04DD);
      glyphList.put("zihiragana", 0x3058);
      glyphList.put("zikatakana", 0x30B8);
      glyphList.put("zinorhebrew", 0x05AE);
      glyphList.put("zlinebelow", 0x1E95);
      glyphList.put("zmonospace", 0xFF5A);
      glyphList.put("zohiragana", 0x305E);
      glyphList.put("zokatakana", 0x30BE);
      glyphList.put("zparen", 0x24B5);
      glyphList.put("zretroflexhook", 0x0290);
      glyphList.put("zstroke", 0x01B6);
      glyphList.put("zuhiragana", 0x305A);
      glyphList.put("zukatakana", 0x30BA);

      return glyphList;
    }
}
