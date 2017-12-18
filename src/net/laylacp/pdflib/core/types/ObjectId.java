/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: ObjectId.java
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

public class ObjectId {
    private int objectNumber;
    private int generationNumber;

    public ObjectId(int objectNumber, int generationNumber) {
        this.objectNumber = objectNumber;
        this.generationNumber = generationNumber;
    }

    @Override
    public String toString() {
        return "obj: " + objectNumber + " gen: " + generationNumber;
    }

    public int getObjectNumber() { return objectNumber; }

    public int getGenerationNumber() { return generationNumber; }

    public void setObjectNumber(int objectNumber) { this.objectNumber = objectNumber; }

    public void setGenerationNumber(int generationNumber) { this.generationNumber = generationNumber; }
}
