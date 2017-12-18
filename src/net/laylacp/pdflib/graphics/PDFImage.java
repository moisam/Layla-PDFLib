package net.laylacp.pdflib.graphics;

import java.awt.image.BufferedImage;

public class PDFImage {
    // for Image XObjects
    public int w;          // width
    public int h;          // height
    public int bpc;        // bits-per-component
    public int cps;        // components-per-sample
    public boolean usesJPXDecode;
    public boolean isMask;

    //public AffineTransform at;
    public BufferedImage image;
}
