/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: ShadingType2.java
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

package net.laylacp.pdflib.graphics.shading;

import net.laylacp.pdflib.core.PDFFunction;
import net.laylacp.pdflib.graphics.PDFColorSpace;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

public class ShadingType2 implements Paint {
    PDFFunction shadingFunc;
    float[] coords;
    float[] domain;
    boolean[] extend;
    PDFColorSpace cs;

    public ShadingType2(PDFFunction shadingFunc, float[] coords, float[] domain,
                        boolean[] extend, PDFColorSpace cs) {
        this.shadingFunc = shadingFunc;
        this.coords = coords;
        this.domain = domain;
        this.extend = extend;
        this.cs = cs;
    }

    public PaintContext createContext(ColorModel cm, Rectangle deviceBounds,
                                      Rectangle2D userBounds, AffineTransform xform, RenderingHints hints) {
        return new AxialShadingContext(shadingFunc, coords, domain, extend, cs, deviceBounds);
    }

    @Override
    public int getTransparency() {
        return 0;
    }
}

class AxialShadingContext implements PaintContext {
    PDFFunction shadingFunc;
    float[] coords;
    float[] domain;
    boolean[] extend;
    PDFColorSpace cs;
    Rectangle deviceBounds;

    public AxialShadingContext(PDFFunction shadingFunc, float[] coords, float[] domain,
                               boolean[] extend, PDFColorSpace cs, Rectangle deviceBounds) {
        this.shadingFunc = shadingFunc;
        this.coords = coords;
        this.domain = domain;
        this.extend = extend;
        this.cs = cs;
        this.deviceBounds = deviceBounds;
    }

    public void dispose() {
    }

    public ColorModel getColorModel() {
        return ColorModel.getRGBdefault();
    }

    public Raster getRaster(int x, int y, int w, int h) {
        float dx = x;
        float dy = y;
        float x0 = deviceBounds.x;
        float y0 = deviceBounds.y;
        float x1 = x0+deviceBounds.width;
        float y1 = y0+deviceBounds.height;
        float x1x0 = x1-x0;
        float y1y0 = y1-y0;
        float denom = (float) (Math.pow(x1x0, 2) + Math.pow(y1y0, 2));
        float t0 = domain[0];
        float t1 = domain[1];
        float t1t0 = t1-t0;

        WritableRaster raster = getColorModel().createCompatibleWritableRaster(w, h);

        int[] data = new int[w * h * 4];
        for (int j = 0; j < h; j++, dy++) {
            dx = x;
            for (int i = 0; i < w; i++, dx++) {
                float t;
                float xs = ((x1x0*(dx-x0))+(y1y0*(dy-y0)))/denom;
                if(xs >= 0.0f && xs <= 1.0f) {
                    t = t0 + (t1t0*xs);
                } else if(xs < 0) {
                    if(extend[0]) t = t0;
                    else continue;
                } else {
                    if(extend[1]) t = t1;
                    else continue;
                }

                float[] f2 = shadingFunc.doFunction(new float[]{ t });
                Color color = cs.getColor(f2);

                int base = (j * w + i) * 4;
                data[base + 0] = color.getRed();
                data[base + 1] = color.getGreen();
                data[base + 2] = color.getBlue();
                data[base + 3] = color.getAlpha();
            }
        }
        raster.setPixels(0, 0, w, h, data);

        return raster;
    }
}
