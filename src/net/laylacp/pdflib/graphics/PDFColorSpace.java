/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: PDFColorSpace.java
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
import net.laylacp.pdflib.reader.PDFReader;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.util.ArrayList;
import java.util.HashMap;

public class PDFColorSpace implements Cloneable {
    /*
     * SEE Table 62 – Colour Space Families, page 139.
     * SEE ALSO Figure 20 – Colour Specification, page 140.
     */

    /* Device */
    public static final int DeviceGray = 0;
    public static final int DeviceRGB  = 1;
    public static final int DeviceCMYK = 2;
    /* CIE-based */
    public static final int CalGray    = 3;
    public static final int CalRGB     = 4;
    public static final int Lab        = 5;
    public static final int ICCBased   = 6;
    /* Special */
    public static final int Indexed    = 7;
    public static final int Pattern    = 8;
    public static final int Separation = 9;
    public static final int DeviceN    = 10;
    /* Unknown - Error */
    public static final int Unknown    = 11;

    public static Color BLACK_RGB  = new Color(0.0F, 0.0F, 0.0F);

    private int family;
    private HashMap<String, PDFObject> Resources;
    private PDFDocument pdfDocument;
    private int colorComponents;    // usually useless, except for ICCBased color spaces

    // only valid for 'CalGray' color spaces
    private float[] whitePoint; // default = { 1.0F, 1.0F, 1.0F };
    private float[] blackPoint; // default = { 0.0F, 0.0F, 0.0F };
    private float gamma;
    // only valid for 'CalRGB' color spaces
    private float[] gammaRGB;       // default = { 1.0F, 1.0F, 1.0F };
    private float[] calRGBMatrix;   // default = { 1, 0, 0, 0, 1, 0, 0, 0, 1 };
    // only valid for 'ICCBased' color spaces
    private ICC_ColorSpace iccColorSpace;
    // only valid for Separation color spaces
    private int altFamily;
    private PDFFunction tintTransform;


    public PDFColorSpace(int family, HashMap<String, PDFObject> Resources, PDFDocument pdfDocument) {
        this.family = family;
        this.Resources = Resources;
        this.pdfDocument = pdfDocument;
        setComponentCount();
    }

    public PDFColorSpace(PDFDocument pdfDocument) {
        this.pdfDocument = pdfDocument;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object obj = super.clone(); //utilize clone Object method
        PDFColorSpace colorSpace = (PDFColorSpace) obj;
        colorSpace.family = this.family;
        colorSpace.Resources = this.Resources;
        colorSpace.pdfDocument = this.pdfDocument;
        colorSpace.colorComponents = this.colorComponents;
        colorSpace.altFamily = this.altFamily;
        if(this.whitePoint != null) colorSpace.whitePoint = this.whitePoint.clone();
        if(this.blackPoint != null) colorSpace.blackPoint = this.blackPoint.clone();
        colorSpace.gamma = this.gamma;
        if(this.gammaRGB != null) colorSpace.gammaRGB = this.gammaRGB.clone();
        if(this.calRGBMatrix != null) colorSpace.calRGBMatrix = this.calRGBMatrix.clone();
        if(this.iccColorSpace != null)
            colorSpace.iccColorSpace = new ICC_ColorSpace(this.iccColorSpace.getProfile());
        return colorSpace;
    }

    public static int getColorSpaceIndex(String csName) {
        int cs;
        if(csName.equals("DeviceGray")) cs = DeviceGray;
        else if(csName.equals("DeviceRGB")) cs = DeviceRGB;
        else if(csName.equals("DeviceCMYK")) cs = DeviceCMYK;
        else if(csName.equals("CalGray")) cs = CalGray;
        else if(csName.equals("CalRGB")) cs = CalRGB;
        else if(csName.equals("Lab")) cs = Lab;
        else if(csName.equals("ICCBased")) cs = ICCBased;
        else if(csName.equals("Pattern")) cs = Pattern;
        else if(csName.equals("Indexed")) cs = Indexed;
        else if(csName.equals("Separation")) cs = Separation;
        else if(csName.equals("DeviceN")) cs = DeviceN;
        else {
            /*
             * We might need to search the ColorSpace sub-dictionary in Resources.
             * SEE Table 74 – Colour Operators, page 171.
             */
            cs = Unknown;
        }
        return cs;
    }

    public boolean setColorSpaceFamily(String csName) {
        int cs = getColorSpaceIndex(csName);
        // if it is not one of the default Color Spaces, maybe it's something
        // defined in the current Resources dictionary.
        if(cs == Unknown) {
            PDFObject csDictObj = Resources.get("ColorSpace");
            if(csDictObj == null) return false;
            HashMap<String, PDFObject> csDict = csDictObj.getDictionaryValueNoFail(pdfDocument);
            PDFObject csObj = csDict.get(csName);
            if(csObj == null) return false;
            ObjectId csStreamId = csObj.getIdValue();
            PDFObjectStream csStream = pdfDocument.reader.getObjectStreamById(csStreamId, pdfDocument);
            if(csStream == null) return false;
            if(setColorSpaceFamily(csStream)) return true;
            else return false;
        } else if(cs == Pattern) {
            return false;
        }

        family = cs;
        setComponentCount();
        return true;
    }

    private void setComponentCount() {
        if(family == DeviceGray || family == CalGray || family == Indexed) colorComponents = 1;
        else if(family == DeviceRGB || family == CalRGB || family == Lab) colorComponents = 3;
        else if(family == DeviceCMYK) colorComponents = 4;
        // ...other types of color spaces should set their own component counts...
    }

    public boolean setColorSpaceFamily(PDFObject csObject) {
        if(csObject.getType() == PDFObject.OBJECT_TYPE.STRING_OBJECT ||
                csObject.getType() == PDFObject.OBJECT_TYPE.NAME_OBJECT) {
            String csName = csObject.getStringValue();
            return setColorSpaceFamily(csName);
        } else if(csObject.getType() == PDFObject.OBJECT_TYPE.ARRAY_OBJECT) {
                /*
                 * PDF Std says: Colour spaces in the CIE-based families shall be defined by an array
                 *               [name dictionary]
                 */
            ArrayList<PDFObject> op = (ArrayList<PDFObject>) csObject.getValue();
            PDFObject object = op.get(0);
            int csi = getColorSpaceIndex(object.getValue().toString());
            object = op.get(1);
            if(object.getType() == PDFObject.OBJECT_TYPE.DICTIONARY_OBJECT) {
                HashMap<String, PDFObject> dict = (HashMap<String, PDFObject>) object.getValue();
                float[] whitePoint = getCIETristimulusValue(dict, "WhitePoint");
                float[] blackPoint = { 0.0F, 0.0F, 0.0F };
                if(dict.containsKey("BlackPoint"))
                    blackPoint = getCIETristimulusValue(dict, "BlackPoint");
                family = csi;
                setWhitePoint(whitePoint);
                setBlackPoint(blackPoint);

                if(csi == PDFColorSpace.CalGray) {
                    float gamma = 1.0F;
                    if(dict.containsKey("Gamma"))
                        gamma = (float) PDFDict.getRealDictEntry(dict, "Gamma");
                    this.gamma = gamma;
                } else if(csi == PDFColorSpace.CalRGB) {
                    float[] gamma = { 1.0F, 1.0F, 1.0F };
                    if(dict.containsKey("Gamma"))
                        gamma = getCIETristimulusValue(dict, "Gamma");
                    float[] matrix = { 1, 0, 0, 0, 1, 0, 0, 0, 1 };
                    if(dict.containsKey("Matrix")) {
                        gamma = getCIETristimulusValue(dict, "Matrix");
                        ArrayList<PDFObject> array = PDFDict.getArrayDictEntry(dict, "Matrix");
                        if(array.size() >= 9) {
                            float Xa = (float) array.get(0).getNumericValue();
                            float Ya = (float) array.get(1).getNumericValue();
                            float Za = (float) array.get(2).getNumericValue();
                            float Xb = (float) array.get(3).getNumericValue();
                            float Yb = (float) array.get(4).getNumericValue();
                            float Zb = (float) array.get(5).getNumericValue();
                            float Xc = (float) array.get(6).getNumericValue();
                            float Yc = (float) array.get(7).getNumericValue();
                            float Zc = (float) array.get(8).getNumericValue();
                            float f[] = { Xa, Ya, Za, Xb, Yb, Zb, Xc, Yc, Zc };
                            matrix = f;
                        }
                    }
                    this.gammaRGB = gamma;
                    this.calRGBMatrix = matrix;
                    return true;
                } else if(csi == PDFColorSpace.Lab) {
                        /*
                         * TODO: we should read the Range array and apply it's bounds.
                         * SEE Table 65 – Entries in a Lab Colour Space Dictionary, page 148, PDF 1.7.
                         */
                }
            } else if(object.getType() == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
                PDFObjectStream csStream = pdfDocument.reader.
                            getObjectStreamById(object.getIdValue(), pdfDocument);
                if(csStream == null) return false;
                if(setColorSpaceFamily(csStream)) return true;
                else return false;
            }
        }
        return false;
    }

    /*
     * static method that creates a new object and initializes it by calling
     * the function setColorSpace(PDFObject).
     */
    public static PDFColorSpace getColorSpace(PDFObject csObject, PDFDocument pdfDocument) {
        if(csObject == null) return null;
        PDFColorSpace cs = new PDFColorSpace(pdfDocument);
        if(cs.setColorSpaceFamily(csObject)) return cs;
        return null;
    }

    public boolean setColorSpaceFamily(PDFObjectStream objectStream) {
        if(objectStream == null) return false;
        PDFReader reader = PDFReader.getReaderInstance(objectStream.stream);
        PDFObject object = reader.getNextObject();
        if(object == null || object.getType() != PDFObject.OBJECT_TYPE.ARRAY_OBJECT) return false;
        ArrayList<PDFObject> arrayList = object.getArrayValue();
        String type = arrayList.get(0).getStringValue();
        if(type.equalsIgnoreCase("ICCBased")) {
            PDFObject iccStreamObj = arrayList.get(1);
            PDFObjectStream iccStream = reader.getObjectStreamById(iccStreamObj.getIdValue(), pdfDocument);
            if (iccStream == null) return false;

            HashMap<String, PDFObject> iccDict = iccStream.dictionary;
            int N = iccDict.get("N").getIntValue();
            if (N != 1 && N != 3 && N != 4) return false;

            ICC_Profile iccProfile = ICC_Profile.getInstance(iccStream.stream.data);
            if (iccProfile == null) return false;
            ICC_ColorSpace iccColorSpace = new ICC_ColorSpace(iccProfile);
            if (iccColorSpace == null) return false;

            this.iccColorSpace = iccColorSpace;
            family = ICCBased;
            colorComponents = N;
            return true;
        } else if(type.equalsIgnoreCase("Separation")) {
            PDFObject altFamilyObj = arrayList.get(2);
            altFamily = getColorSpaceIndex(altFamilyObj.getStringValue());
            if(altFamily == Unknown) return false;
            family = Separation;
            tintTransform = new PDFFunction(pdfDocument);
            PDFObject funcObj = arrayList.get(3);
            if(funcObj.getType() == PDFObject.OBJECT_TYPE.DICTIONARY_OBJECT) {
                if(!tintTransform.parse(funcObj.getDictionaryValue())) return false;
            } else if(funcObj.getType() == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
                if(!tintTransform.parse(funcObj.getIdValue())) return false;
            } else {
                return false;
            }
            colorComponents = tintTransform.getInputCount();
        }
        return false;
    }

    /*
     * static method that creates a new object and initializes it by calling
     * the function setColorSpace(PDFObject).
     */
    public static PDFColorSpace getColorSpace(PDFObjectStream objectStream, PDFDocument pdfDocument) {
        if(objectStream == null) return null;
        PDFColorSpace cs = new PDFColorSpace(pdfDocument);
        if(cs.setColorSpaceFamily(objectStream)) return cs;
        return null;
    }

    public static float[] getCIETristimulusValue(HashMap<String, PDFObject> dictionary, String key) {
        ArrayList<PDFObject> array = PDFDict.getArrayDictEntry(dictionary, key);
        if(array.size() < 3) return null;
        float x = (float) array.get(0).getNumericValue();
        float y = (float) array.get(1).getNumericValue();
        float z = (float) array.get(2).getNumericValue();
        float[] f = { x, y, z };
        return f;
    }

    public Color getColor(float[] components) {
        if(family == Separation) {
            float[] c = tintTransform.doFunction(components);
            return getColor(c, altFamily);
        } else {
            return getColor(components, family);
        }
    }

    public Color getColor(float[] components, int family) {
        if(family == DeviceGray) {
            Float g = components[0];
            return new Color(g, g, g);
        } else if(family == DeviceRGB) {
            Float b = components[2];
            Float g = components[1];
            Float r = components[0];
            return new Color(r, g, b);
        } else if(family == DeviceCMYK) {
            return new Color(CMYKColorSpace.getStaticInstance(), components, 1.0F);
        } else if(family == CalGray) {
            Float A = components[0];
            return PDFColor.CalGrayToRGB(A, this);
        } else if(family == CalRGB) {
            Float C = components[2];
            Float B = components[1];
            Float A = components[0];
            return PDFColor.CalRGBToRGB(A, B, C, this);
        } else if(family == Lab) {
            Float bs = components[2];
            Float as = components[1];
            Float Ls = components[0];
            return PDFColor.LabToRGB(Ls, as, bs, this);
        } else if(family == ICCBased) {
            if(iccColorSpace == null) return PDFColorSpace.BLACK_RGB;
            float[] rgb = iccColorSpace.toRGB(components);
            return new Color(ColorSpace.getInstance(ColorSpace.CS_sRGB), rgb, 1.0F);
        }
        return PDFColorSpace.BLACK_RGB;
    }



    public int getFamily() { return family; }

    public void setFamily(int family) {
        this.family = family;
    }

    public float getGamma() {
        return gamma;
    }

    public void setGamma(float gamma) {
        this.gamma = gamma;
    }

    public float[] getWhitePoint() {
        return whitePoint;
    }

    public void setWhitePoint(float[] whitePoint) {
        this.whitePoint = whitePoint;
    }

    public float[] getBlackPoint() {
        return blackPoint;
    }

    public void setBlackPoint(float[] blackPoint) {
        this.blackPoint = blackPoint;
    }

    public float[] getGammaRGB() {
        return gammaRGB;
    }

    public void setGammaRGB(float[] gammaRGB) {
        this.gammaRGB = gammaRGB;
    }

    public float[] getCalRGBMatrix() {
        return calRGBMatrix;
    }

    public void setCalRGBMatrix(float[] calRGBMatrix) {
        this.calRGBMatrix = calRGBMatrix;
    }

    public HashMap<String, PDFObject> getResources() {
        return Resources;
    }

    public void setResources(HashMap<String, PDFObject> resources) {
        Resources = resources;
    }

    public int getColorComponents() {
        return colorComponents;
    }

    public void setColorComponents(int colorComponents) {
        this.colorComponents = colorComponents;
    }
}
