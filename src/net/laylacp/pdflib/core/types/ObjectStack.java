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
