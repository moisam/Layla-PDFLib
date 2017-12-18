/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: PDFDecodeLZW.java
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

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PDFDecodeLZW {

    /*
     * Code taken from: https://github.com/gauthamk89/LZW-Compression
     *
     * TODO: Test is it actually working
     */

    // Define a HashMap and other variables that will be used in the program
    public HashMap<Integer, String> dictionary = new HashMap<>();
    public String[] Array_char;
    public int dictSize = 256;
    public int currword;
    public int priorword;
    public byte[] buffer = new byte[3];
    public boolean onleft = true;

    /**
     * Decompress Method that takes in input, output as a file path Then
     * decompress the input to same file as the one passed to compress method
     * without loosing any information. In the decompression method it reads in
     * 3 bytes of information and write 2 characters corresponding to the bits
     * read.
     *
     * @param input - Name of input file path
     * @throws java.io.IOException - File input/output failure
     */
    public byte[] decompress(byte[] input) throws IOException {
        // DictSize builds up to 4k, Array_Char holds these values
        Array_char = new String[4096];

        for (int i = 0; i < 256; i++) {
            dictionary.put(i, Character.toString((char) i));
            Array_char[i] = Character.toString((char) i);
        }

        // Read input as uncompressed file & Write out compressed file
        ByteArrayInputStream bin = new ByteArrayInputStream(input);
        ByteArrayOutputStream bout = new ByteArrayOutputStream();

        try {
            // Gets the first word in code and outputs its corresponding char
            buffer[0] = (byte)bin.read();
            buffer[1] = (byte)bin.read();
            priorword = getvalue(buffer[0], buffer[1], onleft);
            onleft = !onleft;
            bout.write(Array_char[priorword].getBytes());

            // Reads every 3 bytes and generates corresponding characters
            while (true) {
                if (onleft) {
                    buffer[0] = (byte)bin.read();
                    buffer[1] = (byte)bin.read();
                    currword = getvalue(buffer[0], buffer[1], onleft);
                } else {
                    buffer[2] = (byte)bin.read();
                    currword = getvalue(buffer[1], buffer[2], onleft);
                }
                onleft = !onleft;

                if (currword >= dictSize) {
                    if (dictSize < 4096) {
                        Array_char[dictSize] = Array_char[priorword]
                                + Array_char[priorword].charAt(0);
                    }
                    dictSize++;
                    bout.write((Array_char[priorword]
                            + Array_char[priorword].charAt(0)).getBytes());
                } else {
                    if (dictSize < 4096) {
                        Array_char[dictSize] = Array_char[priorword]
                                + Array_char[currword].charAt(0);
                    }
                    dictSize++;
                    bout.write(Array_char[currword].getBytes());
                }
                priorword = currword;
            }
        } catch (EOFException e) {
            bin.close();
            //bout.close();
            return bout.toByteArray();
        }
    }

    /**
     * Extract the 12 bit key from 2 bytes and gets the integer value of the key
     *
     * @param b1 - First byte
     * @param b2 - Second byte
     * @param onleft - True if on left, false if not
     * @return - An Integer which holds the value of the key
     */
    public int getvalue(byte b1, byte b2, boolean onleft) {
        String temp1 = Integer.toBinaryString(b1);
        String temp2 = Integer.toBinaryString(b2);

        while (temp1.length() < 8) {
            temp1 = "0" + temp1;
        }
        if (temp1.length() == 32) {
            temp1 = temp1.substring(24, 32);
        }
        while (temp2.length() < 8) {
            temp2 = "0" + temp2;
        }
        if (temp2.length() == 32) {
            temp2 = temp2.substring(24, 32);
        }

        if (onleft) {
            return Integer.parseInt(temp1 + temp2.substring(0, 4), 2);
        } else {
            return Integer.parseInt(temp1.substring(4, 8) + temp2, 2);
        }
    }
}
