/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: PDFShading.java
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

package net.laylacp.pdflib.graphics;

import net.laylacp.pdflib.core.*;
import net.laylacp.pdflib.core.types.ObjectId;
import net.laylacp.pdflib.graphics.shading.ShadingType2;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PDFShading {
    // values for shadingType
    public static final int FUNCTION_SHADING    = 1;
    public static final int AXIAL_SHADING       = 2;
    public static final int RADIAL_SHADING      = 3;
    public static final int FREEFORM_SHADING    = 4;
    public static final int LATTFORM_SHADING    = 5;
    public static final int COONSPATCH_SHADING  = 6;
    public static final int TENSORPATCH_SHADING = 7;

    int shadingType;
    PDFColorSpace cs;
    HashMap<String, PDFObject> Resources;
    PDFDocument pdfDocument;
    Color background;
    Rectangle bbox;
    boolean antialias;
    PDFFunction shadingFunc;
    float[] coords;
    float[] domain;
    boolean[] extend;

    ShadingType2 shadingType2;


    public PDFShading(HashMap<String, PDFObject> Resources, PDFDocument pdfDocument) {
        this.Resources = Resources;
        this.pdfDocument = pdfDocument;
    }

    public PDFShading(PDFDocument pdfDocument) {
        this.pdfDocument = pdfDocument;
    }

    public void applyShading(PDFDraw parent) {
        Graphics2D canvas = parent.getCanvas();

        if(shadingType == AXIAL_SHADING) {

            /*
            float[] dist   = new float[10];
            Color[] colors = new Color[10];
            int i = 0;
            float step = (domain[1]-domain[0])/10;

            for(float f = domain[0]; f < domain[1]; f += step, i++) {
                dist[i] = f;
                float[] f2 = shadingFunc.doFunction(new float[]{ f });
                colors[i] = cs.getColor(f2);
            }

            Point2D start = new Point2D.Float(coords[0], coords[1]);
            Point2D end   = new Point2D.Float(coords[2], coords[3]);
            LinearGradientPaint lgp = new LinearGradientPaint(start, end, dist, colors);
            */

            Paint oldPaint = canvas.getPaint();
            canvas.setPaint(shadingType2);

            canvas.fill(canvas.getClip());
            canvas.setPaint(oldPaint);
        }
    }

    public boolean setShading(PDFObjectStream objectStream) {
        if (!setShading(objectStream.dictionary)) return false;

        if(shadingType == 2) {
            return true;
        }

        /*
         * TODO: implement this.
         */

        return false;
    }

    public boolean setShading(HashMap<String, PDFObject> dictionary) {
        shadingType = PDFDict.getIntDictEntry(dictionary, "ShadingType");
        if(shadingType < 1 || shadingType > 7) return false;

        PDFObject object = dictionary.get("ColorSpace");
        cs = new PDFColorSpace(PDFColorSpace.DeviceGray, Resources, pdfDocument);
        cs.setColorSpaceFamily(object);

        background = null;
        object = dictionary.get("Background");
        if(object != null) {
            ArrayList<PDFObject> arrayList = object.getArrayValueNoFail(pdfDocument);
            float[] f = new float[arrayList.size()];
            for(int i = 0; i < arrayList.size(); i++) {
                f[i] = (float) arrayList.get(i).getNumericValue();
            }
            background = cs.getColor(f);
        }

        // get the bounding box (used for clipping)
        ArrayList<PDFObject> bboxArray = PDFDict.getArrayDictEntry(dictionary, "BBox");
        if(bboxArray != null) bbox = PDFPage.arrayToRect(bboxArray);

        antialias = PDFDict.getBooleanDictEntry(dictionary, "AntiAlias");

        /*
         * TODO: implement this.
         */

        if(shadingType == 2) {
            // get axis coordinates
            ArrayList<PDFObject> objects = PDFDict.getArrayDictEntry(dictionary, "Coords");
            if(objects == null || objects.size() != 4) return false;
            coords = PDFFunction.getFloatArray(objects);

            // get domain
            objects = PDFDict.getArrayDictEntry(dictionary, "Domain");
            if(objects == null || objects.size() != 2) {
                domain = new float[] { 0.0f, 1.0f };
            } else {
                domain = PDFFunction.getFloatArray(objects);
            }

            // get function
            PDFObject funcObj = PDFDict.getDictionaryEntry(dictionary, "Function", null);
            if(funcObj == null) return false;
            shadingFunc = new PDFFunction(pdfDocument);
            if(funcObj.getType() == PDFObject.OBJECT_TYPE.DICTIONARY_OBJECT) {
                if(!shadingFunc.parse(funcObj.getDictionaryValue())) return false;
            } else if(funcObj.getType() == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
                if(!shadingFunc.parse(funcObj.getIdValue())) return false;
            } else {
                return false;
            }

            // get extend
            objects = PDFDict.getArrayDictEntry(dictionary, "Extend");
            if(objects == null || objects.size() != 2) {
                extend = new boolean[] { false, false };
            } else {
                extend = new boolean[] { objects.get(0).getBooleanValue(),
                                         objects.get(1).getBooleanValue() };
            }

            shadingType2 = new ShadingType2(shadingFunc, coords, domain, extend, cs);

            return true;
        }

        return false;
    }

    public boolean setShading(String shadingName, HashMap<String, PDFObject> Resources, PDFDraw parent) {
        PDFObject patObject = Resources.get("Shading");
        HashMap<String, PDFObject> patRes = patObject.getDictionaryValueNoFail(pdfDocument);
        if(patRes.size() == 0) return false;
        // get the requested shading object
        patObject = patRes.get(shadingName);
        if(patObject == null) return false;
        if(patObject.getType() == PDFObject.OBJECT_TYPE.DICTIONARY_OBJECT) {
            return setShading(patObject.getDictionaryValue());
        } else if(patObject.getType() == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
            ObjectId id = patObject.getIdValue();
            PDFObjectStream stream = pdfDocument.reader.getObjectStreamById(id, pdfDocument);
            return setShading(stream);
        }
        return false;
    }

}