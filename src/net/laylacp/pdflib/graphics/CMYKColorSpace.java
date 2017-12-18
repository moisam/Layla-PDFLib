package net.laylacp.pdflib.graphics;

import java.awt.color.ColorSpace;

public class CMYKColorSpace extends ColorSpace {

    static CMYKColorSpace space = new CMYKColorSpace();

    public static CMYKColorSpace getStaticInstance() { return space; }

    public CMYKColorSpace() {
        super(ColorSpace.TYPE_CMYK, 4);
    }

    @Override
    public float[] fromCIEXYZ(float[] p_colorvalue) {
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.TYPE_RGB);
        float[] rgb = cs.toCIEXYZ(p_colorvalue);
        return fromRGB(rgb);
    }

    @Override
    public float[] fromRGB(float[] p_rgbvalue) {
        float[] res = {0,0,0,0};
        if (p_rgbvalue.length >= 3) {
            res[0] = (float)1.0 - p_rgbvalue[0];
            res[1] = (float)1.0 - p_rgbvalue[1];
            res[2] = (float)1.0 - p_rgbvalue[2];
        }
        return normalize(res);
    }

    @Override
    public float[] toCIEXYZ(float[] p_colorvalue) {
        float[] rgb = toRGB(p_colorvalue);
        ColorSpace cs = ColorSpace.getInstance(ColorSpace.TYPE_RGB);
        return cs.toCIEXYZ(rgb);
    }

    @Override
    public float[] toRGB(float[] p_colorvalue) {
        float[] res = {0,0,0};
        if (p_colorvalue.length >= 4)
        {
            float black = (float)1.0 - p_colorvalue[3];
            res[0] = black * ((float)1.0 - p_colorvalue[0]);
            res[1] = black * ((float)1.0 - p_colorvalue[1]);
            res[2] = black * ((float)1.0 - p_colorvalue[2]);
        }
        return normalize(res);
    }

    private float[] normalize(float[] p_colors) {
        for (int i = 0; i < p_colors.length; i++) {
            if (p_colors[i] > (float)1.0) p_colors[i] = (float)1.0;
            else if (p_colors[i] < (float)0.0) p_colors[i] = (float)0.0;
        }
        return p_colors;
    }
}
