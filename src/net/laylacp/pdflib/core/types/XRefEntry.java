/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: XRefEntry.java
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

package net.laylacp.pdflib.core.types;

import net.laylacp.pdflib.core.PDFObjectStream;

public class XRefEntry {
    public enum EntryType {
        FREE_ENTRY,         // type 1
        USED_ENTRY,         // type 2
        COMPRESSED_ENTRY,   // type 3
    }
    private int objectNumber;
    private int byteOffset;
    private int generationNumber;
    //private boolean entryInUse;
    private EntryType entryType;
    private PDFObjectStream compressedObject;

    public XRefEntry(int objectNumber, int byteOffset, int generationNumber, EntryType entryType) {
        this.byteOffset = byteOffset;
        this.objectNumber = objectNumber;
        this.generationNumber = generationNumber;
        this.entryType = entryType;
        this.compressedObject = null;
    }

    public XRefEntry(int objectNumber, int generationNumber, PDFObjectStream compressedObject) {
        this.compressedObject = compressedObject;
        this.byteOffset = -1;
        this.objectNumber = objectNumber;
        this.generationNumber = generationNumber;
        this.entryType = EntryType.COMPRESSED_ENTRY;
    }

    @Override
    public String toString() {
        return "(" + objectNumber + ") off: " + byteOffset + " gen: " + generationNumber + " " +
                ((entryType == EntryType.USED_ENTRY) ? "n" :
                        (entryType == EntryType.FREE_ENTRY) ? "f" : "c");
    }

    public int getObjectNumber() { return objectNumber; }

    public int getByteOffset() { return byteOffset; }

    public int getGenerationNumber() { return generationNumber; }

    //public boolean getEntryInUse() { return entryInUse; }

    public EntryType getEntryType() { return entryType; }

    public PDFObjectStream getCompressedObject() { return compressedObject; }

    public void setObjectNumber(int objectNumber) { this.objectNumber = objectNumber; }

    public void setByteOffset(int byteOffset) { this.byteOffset = byteOffset; }

    public void setGenerationNumber(int generationNumber) { this.generationNumber = generationNumber; }

    //public void setEntryInUse(boolean entryInUse) { this.entryInUse = entryInUse; }

    public void setEntryType(EntryType entryType) { this.entryType = entryType; }

    public void setCompressedObject(PDFObjectStream compressedObject) {
        this.compressedObject = compressedObject;
    }
}
