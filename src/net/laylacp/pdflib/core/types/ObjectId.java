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
