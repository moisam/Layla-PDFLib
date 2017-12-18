/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: ObjectStack.java
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

import net.laylacp.pdflib.core.PDFObject;

import java.util.ArrayList;

public class ObjectStack {
    ArrayList<Object> objects;

    public ObjectStack() {
        this.objects = new ArrayList<>();
    }

    public void push(Object object) {
        objects.add(object);
    }

    public Object pop() {
        if(objects.size() == 0) return null;
        return objects.remove(objects.size()-1);
    }

    public void popAll() {
        objects.clear();
    }

    public ArrayList<Object> getObjects() { return objects; }
}
