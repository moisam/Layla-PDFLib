/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: PDFBitStream.java
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

import java.io.EOFException;

public class PDFBitStream {
    private byte[] in;
    private int curBit;
    private int curByte;
    private static int[] bitMask = { 0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80 };

    public PDFBitStream(byte[] in) {
        this.in = in;
        this.curBit = 7;
        this.curByte = 0;
    }

    public int getBits(int count) throws EOFException {
        if(curByte >= in.length && curBit >= 7)
            throw new EOFException("Reading past end of stream");

        int j = 0;
        while(count-- > 0) {
            int i = ((in[curByte] & bitMask[curBit]) >> curBit);
            i = (i << count) & 0xff;
            j |= i;
            if(--curBit < 0) {
                curBit = 7;
                curByte++;
            }
        }
        return j;
    }

    public void skipPadding() {
        if(curBit < 7) {
            curBit = 7;
            curByte++;
        }
    }
}
