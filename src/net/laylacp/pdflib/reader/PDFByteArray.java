package net.laylacp.pdflib.reader;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class PDFByteArray {
    public int offset;
    public byte[] data;
    RandomAccessFile file;

    public PDFByteArray(int offset, byte[] data) {
        this.offset = offset;
        this.data = data;
        this.file = null;
    }

    public PDFByteArray(int offset, String filePath) throws IOException {
        this.offset = offset;
        this.data = null;
        this.file = new RandomAccessFile(filePath, "r");
        file.seek(offset);
    }

    public int getOffset() {
        return this.offset;
    }

    public int getOffsetPostInc() {
        int i = this.offset;
        this.offset++;
        return i;
    }

    public void setOffset(int offset) {
        this.offset = offset;
        if(file != null) {
            try {
                file.seek(offset);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int getDataLength() {
        if(data != null) return data.length;
        if(file != null) try {
            return (int) file.length();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public byte getByteAt(int index) throws IOException {
        if(data != null) return data[index];
        if(file != null) {
            if(file.getFilePointer() != index)
                file.seek(index);
            return file.readByte();
        }
        throw new IOException();
    }

    public byte[] copyOfRange(int from, int to) {
        if(from < 0 || to > getDataLength() || to <= from) return null;
        if(data != null) {
            return Arrays.copyOfRange(data, from, to);
        } else if(file != null) {
            byte[] bytes = new byte[to-from];
            try {
                //System.out.println("from = " + from + ", to = " + to);
                file.seek(from);
                file.read(bytes, 0, to-from);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return bytes;
        } else {
            return null;
        }
    }
}
