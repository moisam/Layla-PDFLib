/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: PDFXObject.java
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

package net.laylacp.pdflib.core;

import net.laylacp.pdflib.core.types.ObjectId;
import net.laylacp.pdflib.graphics.*;
import net.laylacp.pdflib.graphics.Rectangle;
import net.laylacp.pdflib.reader.PDFByteArray;
import net.laylacp.pdflib.reader.PDFReader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

class DecodeRange {
    public float Dmin;
    public float Dmax;

    public DecodeRange(float Dmin, float Dmax) {
        this.Dmin = Dmin;
        this.Dmax = Dmax;
    }
}

class DecodeArray {
    public DecodeRange[] ranges;

    public DecodeArray(DecodeRange[] ranges) {
        this.ranges = ranges;
    }
}

public class PDFXObject {
    // indirect reference to the object in the PDF file (e.g. '2 0 R').
    private ObjectId objectId;
    PDFDocument pdfDocument;
    private HashMap<String, PDFObject> Resources;
    // type of XObject
    private int type;
    private Object XObject;
    private Graphics2D canvas;
    private PDFDraw parent;
    public static final int IMAGE_XOBJECT = 0;
    public static final int FORM_XOBJECT  = 1;
    public static final int PS_XOBJECT    = 2;


    public PDFXObject(PDFDocument pdfDocument, HashMap<String, PDFObject> Resources, PDFDraw parent) {
        this.pdfDocument = pdfDocument;
        this.Resources = Resources;
        this.parent = parent;
        this.canvas = parent.getCanvas();
    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean parse(ObjectId objectId) {
        if(objectId == null) return false;
        this.objectId = objectId;
        PDFReader reader = pdfDocument.reader;
        PDFObjectStream objectStream = reader.getObjectStreamById(objectId, pdfDocument);
        if(objectStream == null) return false;
        // some sanity checks
        String type = PDFDict.getStringDictEntry(objectStream.dictionary, "Type");
        if(!type.isEmpty() && !type.equals("XObject")) return false;
        String subtype = PDFDict.getStringDictEntry(objectStream.dictionary, "Subtype");
        if(subtype.equals("Image")) {
            this.type = IMAGE_XOBJECT;
            /*
             * SEE Table 89 – Additional Entries Specific to an Image Dictionary.
             */
            PDFImage image = new PDFImage();
            HashMap<String, PDFObject> imgDictionary = objectStream.dictionary;
            image.w = PDFDict.getIntDictEntry(imgDictionary, "Width");
            image.h = PDFDict.getIntDictEntry(imgDictionary, "Height");
            if(image.w == -1 || image.h == -1) return false;

            // check if it uses JPXDecode filter
            image.usesJPXDecode = false;
            boolean usesDCTDecode = false;
            ArrayList<String> filterList = objectStream.getFilterList();
            for (String filter : filterList) {
                if (filter.equalsIgnoreCase("JPXDecode")) {
                    image.usesJPXDecode = true;
                    break;
                } else if(filter.equalsIgnoreCase("DCTDecode")) {
                    usesDCTDecode = true;
                }
            }

            Object cso = PDFDict.getDictionaryEntry(imgDictionary, "ColorSpace", null);
            int cs = PDFColorSpace.DeviceRGB;
            PDFColorSpace colorSpace;
            if(cso == null) {
                if(!image.usesJPXDecode && !image.isMask)
                    return false;
                if(image.isMask) cs = PDFColorSpace.DeviceGray;
                colorSpace = new PDFColorSpace(cs, Resources, pdfDocument);
            } else {
                PDFObject csObject = (PDFObject) cso;
                if(csObject.getType() == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
                    PDFObjectStream objectStream1 = reader.getObjectStreamById(
                                                        csObject.getIdValue(), pdfDocument);
                    colorSpace = PDFColorSpace.getColorSpace(objectStream1, pdfDocument);
                } else {
                    colorSpace = PDFColorSpace.getColorSpace(csObject, pdfDocument);
                }
                cs = colorSpace.getFamily();
            }

            if(cs == PDFColorSpace.DeviceGray)
                image.cps = 1;
            else if(cs == PDFColorSpace.DeviceRGB)
                image.cps = 3;
            else if(cs == PDFColorSpace.DeviceCMYK)
                image.cps = 4;
            else return false;

            // BitsPerComponent is optional only in case of JPXDecode filter
            image.bpc = PDFDict.getIntDictEntry(imgDictionary, "BitsPerComponent");
            if (image.bpc != 1 && image.bpc != 2 && image.bpc != 4 &&
                    image.bpc != 8 && image.bpc != 16) {
                if (!image.usesJPXDecode) return false;
            }

            image.isMask = PDFDict.getBooleanDictEntry(imgDictionary, "ImageMask");
            if (image.isMask && image.bpc != 1) {
                image.bpc = 1;
            }

            float N = (float) Math.pow(2, image.bpc);

            /*
             * can be a stream or an array
             */
            PDFObject masko = PDFDict.getDictionaryEntry(imgDictionary, "Mask", null);
            if(masko != null) {
                HashMap<String, PDFObject> mask = masko.getDictionaryValueNoFail(pdfDocument);
            }

            PDFObject decodeo = PDFDict.getDictionaryEntry(imgDictionary, "Decode", null);
            ArrayList<PDFObject> decode = null;
            if(decodeo != null) decodeo.getArrayValueNoFail(pdfDocument);
            DecodeArray decodeArray;
            if(decode == null || decode.size() == 0) {
                /*
                 * use default according to color space.
                 * SEE Table 90 – Default Decode Arrays, page 210.
                 */
                if(cs == PDFColorSpace.DeviceGray || cs == PDFColorSpace.CalGray ||
                        cs == PDFColorSpace.Separation) {
                    DecodeRange[] range = { new DecodeRange(0.0F, 1.0F) };
                    decodeArray = new DecodeArray(range);
                } else if(cs == PDFColorSpace.DeviceRGB || cs == PDFColorSpace.CalRGB) {
                    DecodeRange[] ranges = {
                            new DecodeRange(0.0F, 1.0F),
                            new DecodeRange(0.0F, 1.0F),
                            new DecodeRange(0.0F, 1.0F)
                    };
                    decodeArray = new DecodeArray(ranges);
                } else if(cs == PDFColorSpace.DeviceCMYK) {
                    DecodeRange[] ranges = {
                            new DecodeRange(0.0F, 1.0F),
                            new DecodeRange(0.0F, 1.0F),
                            new DecodeRange(0.0F, 1.0F),
                            new DecodeRange(0.0F, 1.0F)
                    };
                    decodeArray = new DecodeArray(ranges);
                } else if(cs == PDFColorSpace.Indexed) {
                    DecodeRange[] range = { new DecodeRange(0.0F, N) };
                    decodeArray = new DecodeArray(range);
                } else {
                    /*
                     * TODO: finish this.
                     */
                    return false;
                }

            } else {
                int count = decode.size();
                int i = 0;
                DecodeRange[] ranges = new DecodeRange[count/2];
                for(int j = 0; j < count; j += 2) {
                    PDFObject Dmin = decode.get(j  );
                    PDFObject Dmax = decode.get(j+1);
                    ranges[i++] = new DecodeRange((float)Dmin.getNumericValue(),
                                                    (float)Dmax.getNumericValue());
                }
                decodeArray = new DecodeArray(ranges);
            }

            float[] t = new float[decodeArray.ranges.length];
            int i = 0;
            for(DecodeRange range : decodeArray.ranges) {
                float ti = (range.Dmax - range.Dmin) / (N - 1);
                t[i++] = ti;
            }


            int imgType = BufferedImage.TYPE_INT_RGB;
            if (image.cps == 1) {
                imgType = BufferedImage.TYPE_BYTE_GRAY;
            } else if (image.cps == 4) {
                imgType = BufferedImage.TYPE_INT_ARGB;
            }


            /*
             * We're cheating a little bit. We just let Java own machinery handle the image loading,
             * and we just take this result and return it to the caller.
             */
            if(usesDCTDecode || image.usesJPXDecode) {
                BufferedImage bufImg;
                try {
                    bufImg = ImageIO.read(new ByteArrayInputStream(objectStream.stream.data));
                    image.image = bufImg;
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }

            } else {

                BufferedImage bufferedImage = new BufferedImage(image.w, image.h, imgType);
                PDFBitStream bitStream = new PDFBitStream(objectStream.stream.data);

                for (i = 0; i < image.h; i++) {
                    for (int j = 0; j < image.w; j++) {
                        float[] components = new float[image.cps];
                        for (int k = 0; k < image.cps; k++) {
                            try {
                                components[k] = bitStream.getBits(image.bpc);
                                components[k] = decodeArray.ranges[k].Dmin + (components[k] * t[k]);
                            } catch (EOFException e) {
                                e.printStackTrace();
                                return false;
                            }
                        }
                        Color c = colorSpace.getColor(components);
                        bufferedImage.setRGB(j, i, c.getRGB());
                    }
                    bitStream.skipPadding();
                }

                image.image = bufferedImage;
            }

            this.XObject = image;

            AffineTransform savedAT = canvas.getTransform();
            canvas.scale(1, -1);
            canvas.translate(0, -1);
            canvas.drawImage(image.image, 0, 0, 1, 1, null);
            canvas.setTransform(savedAT);

            return true;

        } else if(subtype.equals("Form")) {
            int i;
            float f;
            // get the transformation matrix
            HashMap<String, PDFObject> formDictionary = objectStream.dictionary;
            ArrayList<PDFObject> matrixArray = PDFDict.getArrayDictEntry(formDictionary, "Matrix");
            float[] matrix = { 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f };
            if(matrixArray != null && matrixArray.size() != 0) {
                for(i = 0; i < 6; i++) {
                    f = (float) matrixArray.get(i).getNumericValue();
                    matrix[i] = f;
                }
            }
            AffineTransform at = new AffineTransform(matrix);

            // get the bounding box (used for clipping)
            ArrayList<PDFObject> bboxArray = PDFDict.getArrayDictEntry(formDictionary, "BBox");
            if(bboxArray == null || bboxArray.size() != 4) return false;
            Rectangle bbox = PDFPage.arrayToRect(bboxArray);

            // save the current graphics state
            parent.pushGraphicsState();

            // apply the Tx matrix
            GraphicsState curState = parent.getCurState();
            AffineTransform CTM = curState.getCTM();
            CTM.concatenate(at);
            canvas.transform(at);

            // do the clipping
            Path2D clipPath = new Path2D.Double();
            clipPath.moveTo(bbox.x1, bbox.y1);
            clipPath.lineTo(bbox.x1, bbox.y2);
            clipPath.lineTo(bbox.x2, bbox.y2);
            clipPath.lineTo(bbox.x2, bbox.y1);
            clipPath.closePath();
            curState.setCurClippingPath(clipPath);
            curState.setDelayedClipping(false);
            canvas.setClip(clipPath);

            PDFObject groupDictObj = formDictionary.get("Group");
            if(groupDictObj != null) {
                HashMap<String, PDFObject> groupDict = groupDictObj.getDictionaryValueNoFail(pdfDocument);
                if(groupDict.size() != 0) {
                    String S = PDFDict.getStringDictEntry(groupDict, "S");
                    if(S.equalsIgnoreCase("Transparency")) {
                        //curState.setBlendMode(AlphaComposite.Src);
                        curState.setBlendMode(null);
                        curState.setAlphaStroke(1.0f);
                        curState.setAlphaOthers(1.0f);
                        /*
                         * TODO: set SMask to Null;
                         */
                    }
                }
            }

            // set the current resources, if any
            HashMap<String, PDFObject> savedResources = parent.getResources();
            Resources = objectStream.getResourcesDict();
            if(Resources == null || Resources.size() == 0) Resources = savedResources;
            parent.setResources(Resources);
            curState.getCurColorSpaceStroke().setResources(Resources);
            curState.getCurColorSpaceOthers().setResources(Resources);

            // switch byte sources and parse the contents of this Form
            PDFByteArray savedByteArray = reader.byteArray;
            reader.byteArray = objectStream.stream;
            objectStream.offset = 0;
            parent.parse(reader);

            // restore everything and go home
            reader.byteArray = savedByteArray;
            parent.setResources(savedResources);
            curState.getCurColorSpaceStroke().setResources(savedResources);
            curState.getCurColorSpaceOthers().setResources(savedResources);
            parent.popGraphicsState();

            return true;

        } else if(subtype.equals("PS")) {

        }

        return false;
    }

    public Object getXObject() {
        return XObject;
    }

    public void setXObject(Object XObject) {
        this.XObject = XObject;
    }
}
