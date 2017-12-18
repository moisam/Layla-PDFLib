package net.laylacp.pdflib.graphics;

import java.awt.*;
import java.awt.color.ColorSpace;

import static java.awt.color.ColorSpace.CS_CIEXYZ;
import static java.awt.color.ColorSpace.TYPE_CMYK;

public class PDFColor {

    public static Color CalGrayToRGB(float A, PDFColorSpace cs) {
        /*
         * Calculation is detailed in 8.6.5.2 CalGray Colour Spaces, page 145 of PDF Std 1.7.
         */
        float AG = (float) Math.pow(A, cs.getGamma());
        float[] WhitePoint = cs.getWhitePoint();
        float X = WhitePoint[0] * AG;
        float Y = WhitePoint[1] * AG;
        float Z = WhitePoint[2] * AG;
        float[] c = { X, Y, Z };
        return new Color(ColorSpace.getInstance(CS_CIEXYZ), c, 1.0F);
    }

    public static Color CalRGBToRGB(float A, float B, float C, PDFColorSpace cs) {
        /*
         * Calculation is detailed in 8.6.5.3 CalRGB Colour Spaces, page 146 of PDF Std 1.7.
         */
        float[] gamma = cs.getGammaRGB();
        float[] matrix = cs.getCalRGBMatrix();
        float AG = (float) Math.pow(A, gamma[0]);
        float BG = (float) Math.pow(B, gamma[1]);
        float CG = (float) Math.pow(C, gamma[2]);
        float[] WhitePoint = cs.getWhitePoint();
        float X = (matrix[0] * AG) + (matrix[3] * BG) + (matrix[6] * CG);
        float Y = (matrix[1] * AG) + (matrix[4] * BG) + (matrix[7] * CG);
        float Z = (matrix[2] * AG) + (matrix[5] * BG) + (matrix[8] * CG);
        float[] c = { X, Y, Z };
        return new Color(ColorSpace.getInstance(CS_CIEXYZ), c, 1.0F);
    }

    public static Color LabToRGB(float Ls, float as, float bs, PDFColorSpace cs) {
        /*
         * Calculation is detailed in 8.6.5.4 Lab Colour Spaces, page 148 of PDF Std 1.7.
         */
        float[] WhitePoint = cs.getWhitePoint();
        float M = (Ls+16)/116;
        float L = M+(as/500);
        float N = M-(bs/200);
        float X = WhitePoint[0] * g(L);
        float Y = WhitePoint[1] * g(M);
        float Z = WhitePoint[2] * g(N);
        float[] c = { X, Y, Z };
        return new Color(ColorSpace.getInstance(CS_CIEXYZ), c, 1.0F);
    }

    private static float g(float x) {
        if(x >= 0.206896552) return x*x*x;
        return (float) (0.128418549*(x-0.137931034));
    }
}
