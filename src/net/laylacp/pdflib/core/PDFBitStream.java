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
