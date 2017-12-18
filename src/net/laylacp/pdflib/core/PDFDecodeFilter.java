package net.laylacp.pdflib.core;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import net.laylacp.pdflib.reader.PDFByteArray;
import net.laylacp.pdflib.reader.PDFReader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.zip.DataFormatException;

public class PDFDecodeFilter {

    /*
     * Table (6 –  Standard filters) on Page 23 of PDF 32000-1:2008.
     * Types of Filters used to encode/decode stream objects
     */
    public enum FILTER_TYPE {
        UnkownFilter,
        ASCIIHexDecode,     // page 24
        ASCII85Decode,      // page 25
        LZWDecode,          // page 25 & Table 8 (page 27)
        FlateDecode,        // page 25 & Table 8 (page 27)
        RunLengthDecode,    // page 29
        CCITTFaxDecode,     // page 30
        JBIG2Decode,        // page 31
        DCTDecode,          // page 34
        JPXDecode,          // page 35
        Crypt
    };
    
    public static FILTER_TYPE getFilterEnumFromString(String filterName) {
        if(filterName.equals("ASCIIHexDecode")) return FILTER_TYPE.ASCIIHexDecode;
        if(filterName.equals("ASCII85Decode")) return FILTER_TYPE.ASCII85Decode;
        if(filterName.equals("LZWDecode")) return FILTER_TYPE.LZWDecode;
        if(filterName.equals("FlateDecode")) return FILTER_TYPE.FlateDecode;
        if(filterName.equals("RunLengthDecode")) return FILTER_TYPE.RunLengthDecode;
        if(filterName.equals("CCITTFaxDecode")) return FILTER_TYPE.CCITTFaxDecode;
        if(filterName.equals("JBIG2Decode")) return FILTER_TYPE.JBIG2Decode;
        if(filterName.equals("DCTDecode")) return FILTER_TYPE.DCTDecode;
        if(filterName.equals("JPXDecode")) return FILTER_TYPE.JPXDecode;
        if(filterName.equals("Crypt")) return FILTER_TYPE.Crypt;
        return FILTER_TYPE.UnkownFilter;
    }

    public static byte[] decode(PDFByteArray byteArray, int start, int length,
                                PDFObject filter, PDFObject decodeParams) {
        PDFReader.__DEBUG__("decode", "Applying filter");
        if(filter == null) return null;
        FILTER_TYPE filterType;
        byte[] bytes = byteArray.copyOfRange(start, start+length);
        if(bytes == null) {
            return null;
        }

        if(filter.getType() == PDFObject.OBJECT_TYPE.NAME_OBJECT) {
            filterType = getFilterEnumFromString((String)filter.getValue());
            if(decodeParams == null || decodeParams.getType() != PDFObject.OBJECT_TYPE.DICTIONARY_OBJECT) {
                //return applyFilter(byteArray.data, start, length, filterType, null);
                return applyFilter(bytes, 0, length, filterType, null);
            } else {
                HashMap<String, PDFObject> params = (HashMap<String, PDFObject>) decodeParams.getValue();
                //return applyFilter(byteArray.data, start, length, filterType, params);
                return applyFilter(bytes, 0, length, filterType, params);
            }
        } else if(filter.getType() == PDFObject.OBJECT_TYPE.ARRAY_OBJECT) {
            ArrayList<PDFObject> filters = (ArrayList<PDFObject>)filter.getValue();
            //byte[] bytes = byteArray.data;
            for(int i = 0; i < filters.size(); i++) {
                PDFObject f = filters.get(i);
                filterType = getFilterEnumFromString((String)f.getValue());
                if(decodeParams == null) {
                    bytes = applyFilter(bytes, start, length, filterType, null);
                } else {
                    ArrayList<PDFObject> paramsArray = (ArrayList<PDFObject>)decodeParams.getValue();
                    PDFObject params = paramsArray.get(i);
                    if(params.getType() == PDFObject.OBJECT_TYPE.DICTIONARY_OBJECT)
                        bytes = applyFilter(bytes, /* start */ 0, length, filterType,
                                            (HashMap<String, PDFObject>)params.getValue());
                    else
                        bytes = applyFilter(bytes, /* start */ 0, length, filterType, null);
                }
                start = 0;
                length = bytes.length;
            }
            return bytes;
        }
        return null;
    }


    public static byte getHextDigitValue(byte h) throws InvalidParameterException {
        if(h >= '0' && h <= '9') return (byte)(h-'0');
        if(h == 'a' || h == 'A') return 10;
        if(h == 'b' || h == 'B') return 11;
        if(h == 'c' || h == 'C') return 12;
        if(h == 'd' || h == 'D') return 13;
        if(h == 'e' || h == 'E') return 14;
        if(h == 'f' || h == 'F') return 15;
        //PDFReader.__DEBUG__("getHextDigitValue", "Invalid Hex digit: '" + h + "'");
        //return 0;
        throw new InvalidParameterException();
    }

    private static byte[] applyFilter(byte[] bytes, int start, int length,
                                      FILTER_TYPE filterType, HashMap<String, PDFObject> filterParams) {
        PDFReader.__DEBUG__("applyFilter", "Filter = " + filterType);
        if(filterType == FILTER_TYPE.UnkownFilter) return null;

        int end = start+length;
        int i;
        ByteOutputStream out = new ByteOutputStream();
        /********************************
         * 1- ASCII filters (text data)
         ********************************/
        if(filterType == FILTER_TYPE.ASCIIHexDecode) {
            /* no parameters accepted */
            while(start < end) {
                // skip whitespace
                while(start < end && PDFReader.isWhitespaceChar(bytes[start])) start++;
                // get first digit
                byte h = bytes[start++];
                if(h == '>') {  // EOD - End of Data
                    return out.getBytes();
                }

                try {
                    i = getHextDigitValue(h);
                    // skip whitespace
                    while(start < end && PDFReader.isWhitespaceChar(bytes[start])) start++;
                    // get second digit
                    h = bytes[start++];
                    if(h == '>') {  // EOD - End of Data
                        out.write(i*16);
                        return out.getBytes();
                    }
                    i = (i*16) + getHextDigitValue(h);
                    out.write(i);
                } catch (InvalidParameterException e) {
                    return null;
                }
            }
            return out.getBytes();

        } else if(filterType == FILTER_TYPE.ASCII85Decode) {
            /* no parameters accepted */
            while(start < end) {
                i = 0;
                for(int j = 0; j < 5; j++) {
                    // skip whitespace
                    while (start < end && PDFReader.isWhitespaceChar(bytes[start])) start++;
                    if(start >= end) break;     // maybe we have a partial group
                    // get the next digit
                    byte h = bytes[start++];
                    if(h == '~') {  // EOD - End of Data is '~>'
                        if(bytes[start] == '>') {
                            return out.getBytes();
                        } else {
                            return null;
                        }
                    }
                    if(h == 'z') {      // special case of '!!!!!' encoded as 'z'
                        out.write(0);
                        out.write(0);
                        out.write(0);
                        out.write(0);
                        break;
                    } else if(h >= '!' && h <= 'u') {       // decode
                        i = (i*85) + (h-'!');
                    } else {    // error
                        return null;
                    }
                }
                // write out the 4-byte decoded data
                out.write((i >> 24) & 0xff);
                out.write((i >> 16) & 0xff);
                out.write((i >> 8 ) & 0xff);
                out.write((i      ) & 0xff);
            }
            return out.getBytes();

        }

        /******************************************
         * 2- Decompression filters (binary data)
         ******************************************/
        if(filterType == FILTER_TYPE.LZWDecode) {
            /*
             * This filter accepts parameters.
             * TODO: Apply parameters, if any
             */
            PDFDecodeLZW decoder = new PDFDecodeLZW();
            try {
                byte[] resbytes;
                if(start == 0 && end == bytes.length) {
                    resbytes = decoder.decompress(bytes);
                } else {
                    byte[] bytes1 = Arrays.copyOfRange(bytes, start, end);
                    resbytes = decoder.decompress(bytes1);
                }
                if(filterParams != null)
                     return applyPNGFilter(resbytes, filterParams);
                else return resbytes;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

        } else if(filterType == FILTER_TYPE.FlateDecode) {
            /*
             * This filter accepts parameters.
             * TODO: Apply parameters, if any
             */
            PDFDecodeGZip decoder = new PDFDecodeGZip();
            try {
                byte[] resbytes;
                if(start == 0 && end == bytes.length) {
                    resbytes = decoder.decompress(bytes);
                } else {
                    byte[] bytes1 = Arrays.copyOfRange(bytes, start, end);
                    resbytes = decoder.decompress(bytes1);
                }
                if(filterParams != null)
                     return applyPNGFilter(resbytes, filterParams);
                else return resbytes;
            } catch (IOException | DataFormatException e) {
                e.printStackTrace();
                return null;
            }

        } else if(filterType == FILTER_TYPE.RunLengthDecode) {
            /* no parameters accepted */
            while(start < end) {
                // get the runlength
                int runlength = (bytes[start++]) & 0xff;
                if (runlength == 128) {  // EOD - End of Data
                    return out.getBytes();
                }
                if(runlength >=0 && runlength <= 127) {
                    while(runlength-- >= 0) {
                        out.write(bytes[start++]);
                    }
                } else {    // byte value is 129 - 255
                    byte b = bytes[start++];
                    runlength = 257-runlength;  // gives runlength of 2 to 128
                    while(runlength-- > 0) {
                        out.write(b);
                    }
                }
            }
            return out.getBytes();

        } else if(filterType == FILTER_TYPE.CCITTFaxDecode) {
            /*
             * This filter accepts parameters.
             * TODO: Apply parameters, if any
             */

        } else if(filterType == FILTER_TYPE.JBIG2Decode) {
            /*
             * This filter accepts parameters.
             * TODO: Apply parameters, if any
             */

        } else if(filterType == FILTER_TYPE.DCTDecode) {
            /*
             * This filter accepts parameters.
             * TODO: Apply parameters, if any
             */

            /* for now, let the caller handle this mess */
            return Arrays.copyOfRange(bytes, start, end);

        } else if(filterType == FILTER_TYPE.JPXDecode) {
            /* no parameters accepted */

            /* for now, let the caller handle this mess */
            return Arrays.copyOfRange(bytes, start, end);

        } else if(filterType == FILTER_TYPE.Crypt) {
            /*
             * This filter accepts parameters.
             * TODO: Apply parameters, if any
             */

        }

        return null;
    }

    /*
     * SEE 7.4.4.3 LZWDecode and FlateDecode Parameters, page 27 of PDF 1.7 Std.
     */
    private static byte[] applyPNGFilter(byte[] bytes, HashMap<String, PDFObject> filterParams) {
        if(filterParams.size() == 0) return bytes;
        int filter_type = PDFDict.getIntDictEntry(filterParams, "Predictor");
        // no filter
        if(filter_type <= 1) return bytes;
        if(filter_type == 2) {
            /*
             * TODO: implement TIFF Predictor 2 function.
             */
        }
        // bytes per pixel
        int bpp;
        int bit_depth = PDFDict.getIntDictEntry(filterParams, "BitsPerComponent");
        if(bit_depth < 8) bpp = 1;
        else bpp = bit_depth/8;
        // components per pixel
        int colors = PDFDict.getIntDictEntry(filterParams, "Colors");
        if(colors < 1) colors = 1;
        bpp *= colors;
        // samples per row
        int width = PDFDict.getIntDictEntry(filterParams, "Columns");
        if(width < 1) width = 1;
        // row length in bytes
        int scanline_len = width*bpp;

        int i = 0, k;
        int len = bytes.length;
        // save previous unfiltered scanline
        byte[] previous = new byte[scanline_len];
        for(k = 0; k < scanline_len; k++) previous[k] = 0;

        ByteOutputStream out = new ByteOutputStream();

        boolean first_pass = true;
        while(i < len)
        {
            int j = 0;
            filter_type = bytes[i];
            i++;
            switch(filter_type)	//Filter method
            {
                case(0):	//None
                    //i += scanline_len;
                    for(k = 0; k < scanline_len; k++, i++) {
                        out.write(bytes[i]);
                    }
                    break;
                case(1):	//Sub
                    while(j < scanline_len)
                    {
                        if(j >= bpp)
                            bytes[i] += bytes[i-bpp];
                        out.write(bytes[i]);
                        j++;
                        i++;
                    }//i++;
                    break;
                ///////////////////////////////////////////
                case(2):	//Up
                    while(j < scanline_len)
                    {
                        if(!first_pass)
                            bytes[i] += previous[j];
                        out.write(bytes[i]);
                        j++;
                        i++;
                    }//i++;
                    break;
                ///////////////////////////////////////////
                case(3):	//Average
                    while(j < scanline_len)
                    {
                        if(!first_pass) {
                            if (j < bpp)
                                bytes[i] = intToByte(bytes[i] + previous[j] / 2);
                            else
                                bytes[i] = intToByte(bytes[i] + ((bytes[i - bpp] + previous[j]) / 2));
                        } else {
                            if (j >= bpp)
                                bytes[i] = intToByte(bytes[i] + bytes[i - bpp] / 2);
                        }

                        out.write(bytes[i]);
                        j++;
                        i++;
                    }//i++;
                    break;
                ///////////////////////////////////////////
                case(4):	//Paeth
                    while(j < scanline_len)
                    {
                        if(!first_pass) {
                            if (j < bpp)
                                bytes[i] = intToByte(bytes[i] + previous[j]);
                            else
                                bytes[i] = intToByte(bytes[i] +
                                        Paeth_predictor(bytes[i - bpp], previous[j], previous[j - bpp]));
                        } else {
                            if (j >= bpp)
                                bytes[i] = intToByte(bytes[i] + bytes[i - bpp]);
                        }

                        out.write(bytes[i]);
                        j++;
                        i++;
                    }//i++;
                    break;
                default:
                    PDFReader.__DEBUG__("applyPNGFilter",
                            "Unknown filter method: Filter %d: " + filter_type);
                    return null;
            }//end switch
            first_pass = false;
            int start = i-scanline_len;
            for(k = 0; k < scanline_len; k++)
                previous[k] = bytes[start+k];
        }//end while
        return out.getBytes();
    }

    private static byte intToByte(int i) {
         return (byte) (i & 0xff);
    }

    /*
     * Paeth predictor function used in applying filter method 4
     * to the decoded image data, as defined in the PNG specification.
     */
    static byte Paeth_predictor(int a, int b, int c)
    {
        //a = left, b = above, c = upper left
        int p = a+b-c;	//initial estimate
        int pa = Math.abs(p-a);	//distances to a, b, c
        int pb = Math.abs(p-b);
        int pc = Math.abs(p-c);
        //return nearest of a,b,c,
        //breaking ties in order a,b,c.
        if(pa <= pb && pa <= pc)
            return (byte)a;
        if(pb <= pc)
            return (byte)b;
        return (byte)c;
    }

}
