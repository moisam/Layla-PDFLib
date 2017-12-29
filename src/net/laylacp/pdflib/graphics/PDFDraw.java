/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: PDFDraw.java
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

import com.sun.media.sound.InvalidFormatException;
import net.laylacp.pdflib.core.*;
import net.laylacp.pdflib.core.types.ObjectId;
import net.laylacp.pdflib.core.types.ObjectStack;
import net.laylacp.pdflib.reader.PDFReader;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;


public class PDFDraw {
    private PDFDocument pdfDocument;
    private double zoomFactor = 1.0;

    private GraphicsState curState;
    private PDFObjectStream page;
    private HashMap<String, PDFObject> Resources;
    private ObjectStack graphicsStateStack;
    private Path2D curPath;
    private Path2D curSubPath;
    private Point.Double curPoint;     // last point added to curPath
    private PDFPattern curPattern;
    private ObjectStack operands;

    private BufferedImage canvasImg;
    private Graphics2D canvas;
    private Point2D.Double canvasSize;

    public PDFDraw(PDFDocument pdfDocument, PDFObjectStream page) {
        curState = new GraphicsState();
        graphicsStateStack = new ObjectStack();
        this.pdfDocument = pdfDocument;
        this.page = page;
    }

    public boolean initCurState() {
        if(!initUserSpace()) return false;
        if(!initObjectStack()) return false;
        return true;
    }

    public boolean initObjectStack() {
        operands = new ObjectStack();
        try {
            graphicsStateStack.popAll();
            graphicsStateStack.push(curState.clone());
            return true;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void parse(PDFReader reader) {
        while(true) {
            PDFObject obj = reader.getNextObject();
            if(obj== null) break;
            int operatorIndex = -1;
            if((operatorIndex = isOperator(obj)) >= 0) {
                PDFReader.__DEBUG__("getPageObject", "Got operator: '" + Operator.PDFOperators[operatorIndex].name + "'");
                try {
                    /* PDF Std says operators return no values */
                    doOperation(operatorIndex, operands);
                } catch (InvalidFormatException e) {
                    e.printStackTrace();
                }
                //operands.popAll();
            } else {
                operands.push(obj);
            }
        }
    }


    private void doOperation(int operatorIndex, ObjectStack operands) throws InvalidFormatException {
        //String op = Operator.PDFOperators[operatorIndex].name;
        float Tj = 0, f2;
        int i;
        switch (operatorIndex) {
            case (0):                         // w
                Float wi = Float.parseFloat(operands.pop().toString());
                curState.setLineWidth(wi);
                //updateCanvasStroke();
                break;
            case (1):                         // J
                i = Integer.parseInt(operands.pop().toString());
                curState.setLineCap(i);
                //updateCanvasStroke();
                break;
            case (2):                         // j
                i = Integer.parseInt(operands.pop().toString());
                curState.setLineJoin(i);
                //updateCanvasStroke();
                break;
            case (3):                         // M
                Float m = Float.parseFloat(operands.pop().toString());
                curState.setMiterLimit(m);
                //updateCanvasStroke();
                break;
            case (4):                         // d
                // get the dash phase
                int dPhase = Integer.parseInt(operands.pop().toString());
                // get the dash array
                PDFObject dArrayObj = (PDFObject) operands.pop();
                setDashPattern(dArrayObj, dPhase);
                break;
            case (5):                         // ri
                String intent = operands.pop().toString();
                setRenderingIntent(intent);
                break;
            case (6):                         // i
                /*
                 * TODO: flatness tolerance, page 316.
                 */

                break;
            case (7):                         // gs
                /*
                 * SEE 8.4.5 Graphics State Parameter Dictionaries, page 128.
                 * SEE ALSO Table 58 – Entries in a Graphics State Parameter Dictionary, page 128.
                 */
                String dictName = operands.pop().toString();
                PDFObject ExtGStateObject = Resources.get("ExtGState");
                HashMap<String, PDFObject> ExtGState = ExtGStateObject.getDictionaryValueNoFail(pdfDocument);
                PDFObject gsDict = ExtGState.get(dictName);
                if (gsDict != null && gsDict.getType() == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
                    PDFObjectStream gsObj = pdfDocument.reader.getObjectStreamById(gsDict.getIdValue(), pdfDocument);
                    HashMap<String, PDFObject> gs = gsObj.dictionary;
                    if (gs.get("Type").getStringValue().equalsIgnoreCase("ExtGState")) {
                        PDFObject object = gs.get("LW");
                        if (object != null) curState.setLineWidth((float) object.getNumericValue());
                        object = gs.get("LC");
                        if (object != null) curState.setLineCap(object.getIntValue());
                        object = gs.get("LJ");
                        if (object != null) curState.setLineJoin(object.getIntValue());
                        object = gs.get("ML");
                        if (object != null) curState.setLineWidth((float) object.getNumericValue());
                        object = gs.get("D");
                        if (object != null && object.getType() == PDFObject.OBJECT_TYPE.ARRAY_OBJECT) {
                            ArrayList<PDFObject> arrayList = object.getArrayValueNoFail(pdfDocument);
                            PDFObject dArray = arrayList.get(0);
                            dPhase = arrayList.get(1).getIntValue();
                            setDashPattern(dArray, dPhase);
                        }
                        object = gs.get("RI");
                        if (object != null) setRenderingIntent(object.getStringValue());
                        object = gs.get("CA");
                        if (object != null) {
                            //curState.setAlphaStroke((float) object.getNumericValue());
                            float f = (float) object.getNumericValue();
                            f *= curState.getAlphaStroke();
                            curState.setAlphaStroke(f);
                        }
                        object = gs.get("ca");
                        if (object != null) {
                            //curState.setAlphaOthers((float) object.getNumericValue());
                            float f = (float) object.getNumericValue();
                            f *= curState.getAlphaOthers();
                            curState.setAlphaOthers(f);
                        }
                        object = gs.get("AIS");
                        if (object != null) curState.setAlphaIsShape(object.getBooleanValue());
                        object = gs.get("BM");
                        if (object != null) {
                            if (object.getType() == PDFObject.OBJECT_TYPE.NAME_OBJECT) {
                                String blendStr = object.getStringValue();
                                BlendComposite.BlendingMode blendingMode = getBlendComposite(blendStr);
                                curState.setBlendMode(blendingMode);
                            } else if (object.getType() == PDFObject.OBJECT_TYPE.ARRAY_OBJECT) {
                                ArrayList<PDFObject> arrayList = object.getArrayValue();
                                for (PDFObject pdfObject : arrayList) {
                                    String blendStr = pdfObject.getStringValue();
                                    BlendComposite.BlendingMode blendingMode = getBlendComposite(blendStr);
                                    if (blendingMode != null) {
                                        curState.setBlendMode(blendingMode);
                                        break;
                                    }
                                }
                            }
                        }
                    /*
                     * SEE Table 144 – Entries in a soft-mask dictionary, page 347.
                     */
                        object = gs.get("SMask");
                        if (object != null) {
                            if (object.getType() == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
                                PDFObjectStream smaskObjStr =
                                        pdfDocument.reader.getObjectStreamById(object.getIdValue(),
                                                pdfDocument);
                                if (smaskObjStr == null) return;
                                HashMap<String, PDFObject> smaskDict = smaskObjStr.dictionary;
                                String type = PDFDict.getStringDictEntry(smaskDict, "Type");
                                if (!type.isEmpty() && !type.equalsIgnoreCase("Mask")) return;

                            }
                        }
                    }

                }

                break;
            case (8):                         // q
                pushGraphicsState();
                break;
            case (9):                         // Q
                popGraphicsState();
                break;
            case (10):                        // cm
                Double f = Double.parseDouble(operands.pop().toString());
                Double e = Double.parseDouble(operands.pop().toString());
                Double d = Double.parseDouble(operands.pop().toString());
                Double c = Double.parseDouble(operands.pop().toString());
                Double b = Double.parseDouble(operands.pop().toString());
                Double a = Double.parseDouble(operands.pop().toString());
                AffineTransform newMatrix = new AffineTransform(a, b, c, d, e, f);
                AffineTransform CTM = curState.getCTM();
                CTM.concatenate(newMatrix);
                canvas.transform(newMatrix);
                break;
            case (11):                        // m
                Double y = Double.parseDouble(operands.pop().toString());
                Double x = Double.parseDouble(operands.pop().toString());
                curPoint = new Point.Double(x, y);
                if (curSubPath == null) curSubPath = new Path2D.Double();
                curSubPath.moveTo(x, y);
                curState.setCurState(GraphicsState.State.PATH_OBJECT);
                break;
            case (12):                        // l
                if (curPoint == null) {
                    return;
                }
                if (curSubPath == null) createNewSubPath();
                y = Double.parseDouble(operands.pop().toString());
                x = Double.parseDouble(operands.pop().toString());
                curSubPath.lineTo(x, y);
                curPoint.setLocation(x, y);
                break;
            case (13):                        // c
                if (curPoint == null) {
                    return;
                }
                if (curSubPath == null) createNewSubPath();
                Double y3 = Double.parseDouble(operands.pop().toString());
                Double x3 = Double.parseDouble(operands.pop().toString());
                Double y2 = Double.parseDouble(operands.pop().toString());
                Double x2 = Double.parseDouble(operands.pop().toString());
                Double y1 = Double.parseDouble(operands.pop().toString());
                Double x1 = Double.parseDouble(operands.pop().toString());
                curSubPath.curveTo(x1, y1, x2, y2, x3, y3);
                curPoint.setLocation(x3, y3);
                break;
            case (14):                        // v
                if (curPoint == null) {
                    return;
                }
                if (curSubPath == null) createNewSubPath();
                y3 = Double.parseDouble(operands.pop().toString());
                x3 = Double.parseDouble(operands.pop().toString());
                y2 = Double.parseDouble(operands.pop().toString());
                x2 = Double.parseDouble(operands.pop().toString());
                curSubPath.curveTo(curPoint.getX(), curPoint.getY(), x2, y2, x3, y3);
                curPoint.setLocation(x3, y3);
                break;
            case (15):                        // y
                if (curPoint == null) {
                    return;
                }
                if (curSubPath == null) createNewSubPath();
                y3 = Double.parseDouble(operands.pop().toString());
                x3 = Double.parseDouble(operands.pop().toString());
                y1 = Double.parseDouble(operands.pop().toString());
                x1 = Double.parseDouble(operands.pop().toString());
                curSubPath.curveTo(x1, y1, x3, y3, x3, y3);
                curPoint.setLocation(x3, y3);
                break;
            case (16):                        // h
                closeCurSubPath();
                break;
            case (17):                        // re
                Double h = Double.parseDouble(operands.pop().toString());
                Double w = Double.parseDouble(operands.pop().toString());
                y = Double.parseDouble(operands.pop().toString());
                x = Double.parseDouble(operands.pop().toString());
                // Java rect is (top,left,w,h) while PDF rect is (bottom,left,w,h).
                // so we have to mirror y. OR NOT...
                Rectangle2D rect;
                if (h < 0) {
                    rect = new Rectangle2D.Double(x, y + h, w, -h);
                } else {
                    rect = new Rectangle2D.Double(x, y, w, h);
                }
                curPath.append(rect, false);
                curState.setCurState(GraphicsState.State.PATH_OBJECT);
                break;
            case (18):                        // S
                strokeCurPath(true);
                break;
            case (19):                        // s
                closeCurSubPath();
                strokeCurPath(true);
                break;
            case (20):                        // f
                closeCurSubPath();
                fillCurPath(Path2D.WIND_NON_ZERO);
                break;
            case (21):                        // F
                closeCurSubPath();
                fillCurPath(Path2D.WIND_NON_ZERO);
                break;
            case (22):                        // f*
                closeCurSubPath();
                fillCurPath(Path2D.WIND_EVEN_ODD);
                break;
            case (23):                        // B
                fillCurPath(Path2D.WIND_NON_ZERO);
                strokeCurPath(true);
                break;
            case (24):                        // B*
                fillCurPath(Path2D.WIND_EVEN_ODD);
                strokeCurPath(true);
                break;
            case (25):                        // b
                closeCurSubPath();
                fillCurPath(Path2D.WIND_NON_ZERO);
                strokeCurPath(true);
                break;
            case (26):                        // b*
                closeCurSubPath();
                fillCurPath(Path2D.WIND_EVEN_ODD);
                strokeCurPath(true);
                break;
            case (27):                        // n
                closeCurSubPath();
                strokeCurPath(false);
                break;
            case (28):                        // W
                curState.setDelayedClipping(true);
                curState.setDelayedClippingMode(Path2D.WIND_NON_ZERO);
                curState.setCurState(GraphicsState.State.CLIPPING_PATH_OBJECT);
                break;
            case (29):                        // W*
                curState.setDelayedClipping(true);
                curState.setDelayedClippingMode(Path2D.WIND_EVEN_ODD);
                curState.setCurState(GraphicsState.State.CLIPPING_PATH_OBJECT);
                break;
            case (30):                        // BT
                // Text objects cannot be nested
                ASSERT_NOT_STATE(GraphicsState.State.TEXT_OBJECT);
                // set the Tm and Tlm to identity matrices
                TextState textState = curState.getTextState();
                textState.setTm(new AffineTransform());
                textState.setTlm(new AffineTransform());
                curState.setCurState(GraphicsState.State.TEXT_OBJECT);
                //curState.setCTM(new AffineTransform(canvas.getTransform()));
                break;
            case (31):                        // ET
                // discard the text matrix
                textState = curState.getTextState();
                textState.setTm(null);
                textState.setTlm(null);
                curState.setCurState(GraphicsState.State.PAGE_DESCRIPTION_LEVEL);
                //canvas.setTransform(curState.getCTM());
                Tj = 0;
                break;
            case (32):                        // Tc
                f2 = Float.parseFloat(operands.pop().toString());
                curState.getTextState().setCharSpace(f2);
                break;
            case (33):                        // Tw
                f2 = Float.parseFloat(operands.pop().toString());
                curState.getTextState().setWordSpace(f2);
                break;
            case (34):                        // Tz
                f2 = Float.parseFloat(operands.pop().toString());
                curState.getTextState().setHorzScale(f2 / 100);
                break;
            case (35):                        // TL
                f2 = Float.parseFloat(operands.pop().toString());
                curState.getTextState().setTextLeading(f2);
                break;
            case (36):                        // Tf
                f2 = Float.parseFloat(operands.pop().toString());
                String n = operands.pop().toString();
                curState.getTextState().setFontSize(f2);
                curState.getTextState().setFontName(n);
                break;
            case (37):                        // Tr
                i = Integer.parseInt(operands.pop().toString());
                curState.getTextState().setRenderMode(i);
                break;
            case (38):                        // Ts
                f2 = Float.parseFloat(operands.pop().toString());
                curState.getTextState().setTextRise(f2);
                break;
            case (39):                        // Td
                ASSERT_STATE(GraphicsState.State.TEXT_OBJECT);
                Float ty = Float.parseFloat(operands.pop().toString());
                Float tx = Float.parseFloat(operands.pop().toString());
                textMoveToNextLine(tx, ty);
                break;
            case (40):                        // TD
                ASSERT_STATE(GraphicsState.State.TEXT_OBJECT);
                ty = Float.parseFloat(operands.pop().toString());
                tx = Float.parseFloat(operands.pop().toString());
                curState.getTextState().setTextLeading(-ty);
                textMoveToNextLine(tx, ty);
                break;
            case (41):                        // Tm
                ASSERT_STATE(GraphicsState.State.TEXT_OBJECT);
                f = Double.parseDouble(operands.pop().toString());
                e = Double.parseDouble(operands.pop().toString());
                d = Double.parseDouble(operands.pop().toString());
                c = Double.parseDouble(operands.pop().toString());
                b = Double.parseDouble(operands.pop().toString());
                a = Double.parseDouble(operands.pop().toString());
                AffineTransform Tlm = new AffineTransform(a, b, c, d, e, f);
                textState = curState.getTextState();
                textState.setTlm(Tlm);
                textState.setTm(new AffineTransform(Tlm));
                break;
            case (42):                        // T*
                ASSERT_STATE(GraphicsState.State.TEXT_OBJECT);
                textMoveToNextLine(0, -curState.getTextState().getTextLeading());
                break;
            case (43):                        // Tj
                ASSERT_STATE(GraphicsState.State.TEXT_OBJECT);
                CTM = curState.getCTM();    // canvas.getTransform();
                canvas.setTransform(CTM);
                //canvas.transform(curState.getTextState().getTm());
                PDFObject object = (PDFObject) operands.pop();
                byte[] bytes = object.getBytes();
                if (bytes != null) textShow(bytes, Tj);
                else textShow(object.getStringValue().getBytes(), Tj);
                canvas.setTransform(CTM);
                break;
            case (44):                        // TJ
            /*
             * SEE Table 109 – Text-showing operators, page 251.
             */
                ASSERT_STATE(GraphicsState.State.TEXT_OBJECT);
                PDFObject array = (PDFObject) operands.pop();
                CTM = curState.getCTM();    // canvas.getTransform();
                canvas.setTransform(CTM);
                //canvas.transform(curState.getTextState().getTm());
                ArrayList<PDFObject> arrayList = array.getArrayValue();
                int len = arrayList.size();
                for (int j = 0; j < len; j++) {
                    object = arrayList.get(j);
                    if (object.getType() == PDFObject.OBJECT_TYPE.STRING_OBJECT) {
                        PDFObject object1;
                        if (j + 1 < len) {
                            object1 = arrayList.get(j + 1);
                            if (object1.getType() == PDFObject.OBJECT_TYPE.INTEGER_OBJECT ||
                                    object1.getType() == PDFObject.OBJECT_TYPE.REAL_OBJECT) {
                                Tj = (float) object1.getNumericValue();
                                j++;
                            }
                        }
                        bytes = object.getBytes();
                        if (bytes != null) textShow(bytes, Tj);
                        else textShow(object.getStringValue().getBytes(), Tj);
                        Tj = 0;
                    }
                }
                canvas.setTransform(CTM);
                break;
            case (45):                        // '
                ASSERT_STATE(GraphicsState.State.TEXT_OBJECT);
                CTM = curState.getCTM();    // canvas.getTransform();
                canvas.setTransform(CTM);
                textMoveToNextLine(0, -curState.getTextState().getTextLeading());
                //canvas.transform(curState.getTextState().getTm());
                object = (PDFObject) operands.pop();
                bytes = object.getBytes();
                if (bytes != null) textShow(bytes, Tj);
                else textShow(object.getStringValue().getBytes(), Tj);
                canvas.setTransform(CTM);
                break;
            case (46):                        // "
                ASSERT_STATE(GraphicsState.State.TEXT_OBJECT);
                //String str = operands.pop().toString();
                object = (PDFObject) operands.pop();
                Float ac = Float.parseFloat(operands.pop().toString());
                Float aw = Float.parseFloat(operands.pop().toString());
                CTM = curState.getCTM();    // canvas.getTransform();
                canvas.setTransform(CTM);
                curState.getTextState().setCharSpace(ac);
                curState.getTextState().setWordSpace(aw);
                //canvas.transform(curState.getTextState().getTm());
                textMoveToNextLine(0, -curState.getTextState().getTextLeading());
                bytes = object.getBytes();
                if (bytes != null) textShow(bytes, Tj);
                else textShow(object.getStringValue().getBytes(), Tj);
                canvas.setTransform(CTM);
                break;
            case (47):                        // d0
            /*
             * TODO:
             */
                break;
            case (48):                        // d1
            /*
             * TODO:
             */
                break;
            case (49):                        // CS
                setColorSpace(null, operands, true, true);
                break;
            case (50):                        // cs
                setColorSpace(null, operands, false, true);
                break;
            case (51):                        // SC
                Color color = getColor(curState.getCurColorSpaceStroke(), operands);
                curState.setCurColorStroke(color);
                break;
            case (52):                        // SCN
                color = getColor(curState.getCurColorSpaceStroke(), operands);
                curState.setCurColorStroke(color);
                break;
            case (53):                        // sc
                color = getColor(curState.getCurColorSpaceOthers(), operands);
                curState.setCurColorOthers(color);
                break;
            case (54):                        // scn
                color = getColor(curState.getCurColorSpaceOthers(), operands);
                curState.setCurColorOthers(color);
                break;
            case (55):                        // G
                setColorSpace("DeviceGray", null, true, false);
                color = getColor(curState.getCurColorSpaceStroke(), operands);
                curState.setCurColorStroke(color);
                break;
            case (56):                        // g
                setColorSpace("DeviceGray", null, false, false);
                color = getColor(curState.getCurColorSpaceOthers(), operands);
                curState.setCurColorOthers(color);
                break;
            case (57):                        // RG
                setColorSpace("DeviceRGB", null, true, false);
                color = getColor(curState.getCurColorSpaceStroke(), operands);
                curState.setCurColorStroke(color);
                break;
            case (58):                        // rg
                setColorSpace("DeviceRGB", null, false, false);
                color = getColor(curState.getCurColorSpaceOthers(), operands);
                curState.setCurColorOthers(color);
                break;
            case (59):                        // K
                setColorSpace("DeviceCMYK", null, true, false);
                color = getColor(curState.getCurColorSpaceStroke(), operands);
                curState.setCurColorStroke(color);
                break;
            case (60):                        // k
                setColorSpace("DeviceCMYK", null, false, false);
                color = getColor(curState.getCurColorSpaceOthers(), operands);
                curState.setCurColorOthers(color);
                break;
            case (61):                        // sh
                String shadeName = operands.pop().toString();
                PDFShading shading = new PDFShading(pdfDocument);
                if(shading.setShading(shadeName, Resources, this)) {
                    shading.applyShading(this);
                } else {
                    PDFReader.__DEBUG__("doOperation", "Failed to apply 'sh' operator");
                }
                break;
            case (62):                        // BI
                throw new UnsupportedOperationException("Unimplemented Operator: 'BI'");
            case (63):                        // ID
                throw new UnsupportedOperationException("Unimplemented Operator: 'ID'");
            case (64):                        // EI
                throw new UnsupportedOperationException("Unimplemented Operator: 'EI'");
            case (65):                        // Do
            /*
             * SEE Table 87 – XObject Operator, page 202.
             */
                curState.setCurState(GraphicsState.State.EXTERNAL_OBJECT);
                HashMap<String, PDFObject> xObjects = PDFDict.getDictionaryDictEntry(Resources, "XObject");
                if (xObjects != null) {
                    String xs = operands.pop().toString();
                    ObjectId objectId = PDFDict.getIndirectRefDictEntry(xObjects, xs);
                    PDFXObject xo = new PDFXObject(pdfDocument, Resources, this);
                    xo.parse(objectId);
                }
                curState.setCurState(GraphicsState.State.PAGE_DESCRIPTION_LEVEL);
                break;
            case (66):                        // MP
                // TODO: handle marked content points
                break;
            case (67):                        // DP
                // TODO: handle marked content points
                break;
            case (68):                        // BMC
                // TODO: handle marked content sequences
                break;
            case (69):                        // BDC
                // TODO: handle marked content sequences
                break;
            case (70):                        // EMC
                // TODO: handle marked content sequences
                break;
            case (71):                        // BX
                break;
            case (72):                        // EX
                break;
        }
    }

    private void setRenderingIntent(String intent) {
        /*
         * TODO: IMPLEMENT THIS.
         * SEE 8.6.5.8 Rendering Intents, page 154, PDF Std 1.7.
         */
        curState.setRenderingIntent(intent);
    }

    private void setDashPattern(PDFObject dArrayObj, int dPhase) {
        if(dArrayObj.getType() != PDFObject.OBJECT_TYPE.ARRAY_OBJECT) { return; }
        ArrayList<PDFObject> dArray = (ArrayList<PDFObject>) dArrayObj.getValue();
        float[] fArray = new float[dArray.size()];
        for(int j = 0; j < dArray.size(); j++) {
            Float i = Float.parseFloat(dArray.get(j).toString());
            fArray[j] = i;
        }
        // set the new dash style
        curState.setDashArray(fArray);
        curState.setDashPhase(dPhase);
        //updateCanvasStroke();
    }

    public void popGraphicsState() {
        curState = (GraphicsState) graphicsStateStack.pop();
        updateCanvasStroke();
        canvas.setTransform(curState.getCTM());
        canvas.setClip(curState.getCurClippingPath());
        //canvas.setComposite(curState.getBlendMode());
    }

    public void pushGraphicsState() {
        try {
            graphicsStateStack.push(curState.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private void ASSERT_STATE(GraphicsState.State state) throws InvalidFormatException {
        if(curState.getCurState() != state) {
            throw new InvalidFormatException("Operator encountered in an invalid state");
        }
    }

    private void ASSERT_NOT_STATE(GraphicsState.State state) throws InvalidFormatException {
        if(curState.getCurState() == state) {
            throw new InvalidFormatException("Operator encountered in an invalid state");
        }
    }


    private void textShow(byte[] bytes, float Tj) {
        // get the CTM
        AffineTransform CTM = new AffineTransform(canvas.getTransform());
        // concatenate Tm
        AffineTransform Tm = curState.getTextState().getTm();
        canvas.transform(Tm);
        TextState textState = curState.getTextState();
        float Tfs = textState.getFontSize();
        float Tc = textState.getCharSpace();
        float Tw = textState.getWordSpace();
        float Th = textState.getHorzScale();
        float Trise = textState.getTextRise();
        PDFFont pdfFont = PDFFont.getPDFFont(textState.getFontName(), Resources, pdfDocument);
        if(pdfFont == null) return;
        pdfFont.setFontSize((int) textState.getFontSize());
        //AffineTransform Ttemp = new AffineTransform(Tfs*Th, 0, 0, Tfs, 0, Trise);
        PDFReader.__DEBUG__("textShow", "Tfs = " + Tfs + ", Th = " + Th +
                ", Trise = " + Trise + ", Tj = " + Tj);

        int renderMode = curState.getTextState().getRenderMode();
        Path2D clip = new Path2D.Double();
        updateCanvasStroke();
        updateCanvasPaintColor();

        //PDFReader.__DEBUG__("textShow", "renderMode = " + renderMode);
        canvas.setFont(pdfFont.getFont((int) curState.getTextState().getFontSize()));

        /*
         * SEE 9.4.4 Text Space Details, page 252.
         */
        boolean isType0 = (pdfFont.getType() == PDFFont.TYPE0_FONT) ? true : false;

        for(int index = 0; index < bytes.length; index++) {
            int b2;
            if(isType0) {
                byte ba = bytes[index++];
                byte bb = bytes[index  ];
                b2  = (ba << 8) & 0xff00;
                b2 |= (bb     ) & 0x00ff;
            } else {
                byte b = bytes[index];
                b2 = b & 0xff;
            }

            Shape glyphClip = pdfFont.glyphDraw(this, b2, renderMode);
            if(renderMode >= TextState.RENDER_FILL_CLIP) clip.append(glyphClip, false);

            /* w0 and w1 denote the glyph’s horizontal and vertical displacements */
            float w1 = pdfFont.getHeight();
            float w0 = pdfFont.getCharWidth(b2);

            // update Tm
            //float tx = ((w0-Tj)/1000*Tfs+Tc+Tw)*Th;
            float tx;
            String utf = pdfFont.getUtf(b2);
            if(utf.equalsIgnoreCase(" ")) tx = ((w0-Tj)/1000*Tfs+Tc+Tw)*Th;
            else tx = ((w0-Tj)/1000*Tfs+Tc)*Th;

            float ty = (w1-Tj)*Tfs+Tc+Tw;
            /*
             * TODO: we assume horizontal writing mode. Fix this.
             */
            ty = 0;
            //Tm.translate(tx, ty);
            PDFReader.__DEBUG__("textShow","tx = " + tx + ", w0 = " + w0 + ", Tfs = " +Tfs + ", Tc = " + Tc + ", Tw = " + Tw + ", Th = " + Th);
            canvas.translate(tx, ty);
            Tm.translate(tx, ty);
            Tj = 0;
            PDFReader.__DEBUG__("textShow", "CTM    = " + canvas.getTransform().toString());
        }
        // restore CTM
        canvas.setTransform(CTM);
        // add new clipping path (if any) to current clipping path
        if(renderMode >= TextState.RENDER_FILL_CLIP) canvas.clip(clip);
    }

    private void textMoveToNextLine(float tx, float ty) {
        PDFReader.__DEBUG__("textMoveToNextLine", "tx=" + tx + ", ty=" + ty);
        TextState textState = curState.getTextState();
        AffineTransform Tlm = textState.getTlm();
        Tlm.translate(tx, ty);
        textState.setTlm(Tlm);
        textState.setTm(new AffineTransform(Tlm));
    }

    private Color getColor(PDFColorSpace cs, ObjectStack operands) {
        int count = cs.getColorComponents();
        float[] f = new float[count];
        if(cs.getFamily() == PDFColorSpace.Pattern) {
            /*
             * TODO: fully implement pattern CS.
             */
            String patternName = operands.pop().toString();
            for(int i = count-1; i >= 0; i--) {
                f[i] = Float.parseFloat(operands.pop().toString());
            }
            curPattern = cs.getPattern(patternName, f, this);
            return PDFColorSpace.BLACK_RGB;
        }

        for(int i = count-1; i >= 0; i--) {
            f[i] = Float.parseFloat(operands.pop().toString());
        }
        return cs.getColor(f);
    }

    private void setColorSpace(String csName, ObjectStack operands,
                               boolean isStrokeCS, boolean resetCurColor) {
        PDFColorSpace cs;
        if(isStrokeCS) cs = curState.getCurColorSpaceStroke();
        else cs = curState.getCurColorSpaceOthers();
        if(csName != null) {
            cs.setColorSpaceFamily(csName);
        } else {
            PDFObject csNameObj = (PDFObject) operands.pop();
            cs.setColorSpaceFamily(csNameObj);
        }
        if(resetCurColor) {
            if(isStrokeCS) curState.setCurColorStroke(PDFColorSpace.BLACK_RGB);
            else curState.setCurColorOthers(PDFColorSpace.BLACK_RGB);
        }
    }


    /* create new subpath starting at the current point */
    private void createNewSubPath() {
        curSubPath = new Path2D.Double();
        curSubPath.moveTo(curPoint.getX(), curPoint.getY());
    }

    /* close current subpath and add it to the main path */
    private void closeCurSubPath() {
        if(curSubPath != null) {
            curSubPath.closePath();
            curPath.append(curSubPath, false);
            curSubPath = null;
        }
    }

    private void fillCurPath(int windingRule) {
        //closeCurSubPath();
        updateCanvasPaintColor();
        AffineTransform CTM = canvas.getTransform();

        PDFColorSpace cs = curState.getCurColorSpaceOthers();
        if(cs.getFamily() == PDFColorSpace.Pattern) canvas.transform(curPattern.getMatrix());

        curPath.setWindingRule(windingRule);
        canvas.fill(curPath);
        curPath.reset();
        curPoint = null;
        curSubPath = null;
        curState.setCurState(GraphicsState.State.PAGE_DESCRIPTION_LEVEL);

        if(cs.getFamily() == PDFColorSpace.Pattern) canvas.setTransform(CTM);
    }

    private void strokeCurPath(boolean doDraw) {
        updateCanvasStroke();
        // draw path
        if(doDraw)
            canvas.draw(curPath);
        // PDF standard 1.7 says to do clipping (W and W* ops) AFTER drawing
        if(curState.isDelayedClipping()) {
            curPath.setWindingRule(curState.getDelayedClippingMode());
            canvas.clip(curPath);
            curState.setDelayedClipping(false);
            curState.setCurClippingPath(curPath);
        }
        // reset path
        curPath.reset();
        curPoint = null;
        curSubPath = null;
        curState.setCurState(GraphicsState.State.PAGE_DESCRIPTION_LEVEL);
    }

    public void updateCanvasPaintColor() {
        /*
         * This assumes solid color, no gradient or pattern.
         */
        PDFColorSpace cs = curState.getCurColorSpaceOthers();
        if(cs.getFamily() == PDFColorSpace.Pattern) {
            curPattern.applyPattern(this);
        } else {
            canvas.setPaint(curState.getCurColorOthers());
        }
        BlendComposite.BlendingMode blendingMode = curState.getBlendMode();
        if(blendingMode == null) canvas.setComposite(AlphaComposite.SrcOver.derive(curState.getAlphaOthers()));
        else {
            BlendComposite blendComposite = BlendComposite.getInstance(blendingMode, curState.getAlphaOthers());
            canvas.setComposite(blendComposite);
        }
    }

    private void updateCanvasStroke() {
        BasicStroke stroke;
        if(curState.getDashArray().length == 0) {   // no dashing
            stroke = new BasicStroke(curState.getLineWidth(), curState.getLineCap(),
                    curState.getLineJoin(), curState.getMiterLimit());
        } else {                                    // with dashing
            stroke = new BasicStroke(curState.getLineWidth(), curState.getLineCap(),
                    curState.getLineJoin(), curState.getMiterLimit(), curState.getDashArray(),
                    curState.getDashPhase());
        }
        canvas.setStroke(stroke);
        /*
         * This assumes solid color, no gradient or pattern.
         */
        canvas.setColor(curState.getCurColorStroke());
        BlendComposite.BlendingMode blendingMode = curState.getBlendMode();
        if(blendingMode == null) canvas.setComposite(AlphaComposite.SrcOver.derive(curState.getAlphaStroke()));
        else {
            BlendComposite blendComposite = BlendComposite.getInstance(blendingMode, curState.getAlphaStroke());
            canvas.setComposite(blendComposite);
        }
    }

    public static int isOperator(PDFObject op) {
        if(op.getType() != PDFObject.OBJECT_TYPE.STRING_OBJECT) {
            return -1;
        }
        String value = (String) op.getValue();
        for(int i = 0; i < Operator.PDFOperators.length; i++) {
            if(value.equals(Operator.PDFOperators[i].name))
                return i;
        }
        return -1;
    }

    public boolean initUserSpace() {
        /*
         * SEE ALSO Table 52 –  Device-Independent Graphics State Parameters, page 121.
         * SEE ALSO Table 53 –  Device-Dependent Graphics State Parameters, page 123.
         */

        Rectangle mediaBox = curState.getMediaBox();
        int w1 = (int) Math.abs(mediaBox.x1 - mediaBox.x2);
        int h1 = (int) Math.abs(mediaBox.y1 - mediaBox.y2);
        AffineTransform newCTM = AffineTransform.getScaleInstance(zoomFactor, -zoomFactor);
        newCTM.translate(0, -h1);

        curState.setCTM(newCTM);
        canvas.setTransform(newCTM);

        Rectangle cropBox = curState.getCropBox();
        Path2D clipPath = new Path2D.Double();
        clipPath.moveTo(cropBox.x1, cropBox.y1);
        clipPath.lineTo(cropBox.x1, cropBox.y2);
        clipPath.lineTo(cropBox.x2, cropBox.y2);
        clipPath.lineTo(cropBox.x2, cropBox.y1);
        clipPath.closePath();
        curState.setCurClippingPath(clipPath);
        curState.setDelayedClipping(false);
        canvas.clip(clipPath);

        Composite composite = AlphaComposite.SrcOver;
        curState.setBlendMode(null);
        canvas.setComposite(composite);

        curState.setLineWidth(1.0F);
        curState.setLineCap(0);
        curState.setLineJoin(0);
        curState.setMiterLimit(10.0F);
        curState.setDashPhase(0);
        float[] dArray = {};
        curState.setDashArray(dArray);
        curState.setRenderingIntent("RelativeColorimetric");
        curState.setStrokeAdjust(false);
        BasicStroke stroke = new BasicStroke(1.0F, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER, 10.0F);
        canvas.setStroke(stroke);
        canvas.setClip(curState.getCurClippingPath());
        canvas.setColor(Color.white);
        canvas.fillRect(0, 0, w1, h1);
        canvas.setColor(Color.black);
        canvas.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        canvas.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        curState.setCurState(GraphicsState.State.PAGE_DESCRIPTION_LEVEL);
        curSubPath = null;
        curPoint = null;
        curPath = new Path2D.Double();

        curState.setCurColorStroke(new Color(0, 0, 0, 1));
        curState.setCurColorOthers(new Color(0, 0, 0, 1));
        curState.setCurColorSpaceStroke(new PDFColorSpace(PDFColorSpace.DeviceGray, Resources, pdfDocument));
        curState.setCurColorSpaceOthers(new PDFColorSpace(PDFColorSpace.DeviceGray, Resources, pdfDocument));
        curState.setAlphaIsShape(false);
        curState.setAlphaStroke(1.0F);
        curState.setAlphaOthers(1.0F);

        /* set the default text state */
        TextState textState = curState.getTextState();
        textState.setCharSpace(0);
        textState.setWordSpace(0);
        textState.setHorzScale(1);  // 100% scaling
        textState.setTextLeading(0);
        textState.setFontSize(0);
        textState.setFontName("");
        textState.setRenderMode(0);
        textState.setTextRise(0);
        textState.setTextKnockout(true);
        return true;
    }

    BlendComposite.BlendingMode getBlendComposite(String blendStr) {
        BlendComposite.BlendingMode blend;

        if(blendStr.equalsIgnoreCase("Normal") ||
                blendStr.equalsIgnoreCase("Compatible"))
            blend = null; //BlendComposite.BlendingMode.OVERLAY;
        else if(blendStr.equalsIgnoreCase("Multiply"))
            blend = BlendComposite.BlendingMode.MULTIPLY;
        else if(blendStr.equalsIgnoreCase("Screen"))
            blend = BlendComposite.BlendingMode.SCREEN;
        else if(blendStr.equalsIgnoreCase("Overlay"))
            blend = BlendComposite.BlendingMode.OVERLAY;
        else if(blendStr.equalsIgnoreCase("Darken"))
            blend = BlendComposite.BlendingMode.DARKEN;
        else if(blendStr.equalsIgnoreCase("Lighten"))
            blend = BlendComposite.BlendingMode.LIGHTEN;
        else if(blendStr.equalsIgnoreCase("ColorDodge"))
            blend = BlendComposite.BlendingMode.COLOR_DODGE;
        else if(blendStr.equalsIgnoreCase("ColorBurn"))
            blend = BlendComposite.BlendingMode.COLOR_BURN;
        else if(blendStr.equalsIgnoreCase("HardLight"))
            blend = BlendComposite.BlendingMode.HARD_LIGHT;
        else if(blendStr.equalsIgnoreCase("SoftLight"))
            blend = BlendComposite.BlendingMode.SOFT_LIGHT;
        else if(blendStr.equalsIgnoreCase("Difference"))
            blend = BlendComposite.BlendingMode.DIFFERENCE;
        else if(blendStr.equalsIgnoreCase("Exclusion"))
            blend = BlendComposite.BlendingMode.EXCLUSION;
        else if(blendStr.equalsIgnoreCase("Hue"))
            blend = BlendComposite.BlendingMode.HUE;
        else if(blendStr.equalsIgnoreCase("Saturation"))
            blend = BlendComposite.BlendingMode.SATURATION;
        else if(blendStr.equalsIgnoreCase("Color"))
            blend = BlendComposite.BlendingMode.COLOR;
        else if(blendStr.equalsIgnoreCase("Luminosity"))
            blend = BlendComposite.BlendingMode.LUMINOSITY;
        else return null;

        return blend;
    }

    public GraphicsState getCurState() {
        return curState;
    }

    public void setCurState(GraphicsState curState) {
        this.curState = curState;
    }

    public ObjectStack getGraphicsStateStack() {
        return graphicsStateStack;
    }

    public void setGraphicsStateStack(ObjectStack graphicsStateStack) {
        this.graphicsStateStack = graphicsStateStack;
    }

    public HashMap<String, PDFObject> getResources() {
        return Resources;
    }

    public void setResources(HashMap<String, PDFObject> resources) {
        Resources = resources;
    }

    public Path2D getCurPath() {
        return curPath;
    }

    public void setCurPath(Path2D curPath) {
        this.curPath = curPath;
    }

    public Path2D getCurSubPath() {
        return curSubPath;
    }

    public void setCurSubPath(Path2D curSubPath) {
        this.curSubPath = curSubPath;
    }

    public Point.Double getCurPoint() {
        return curPoint;
    }

    public void setCurPoint(Point.Double curPoint) {
        this.curPoint = curPoint;
    }

    public BufferedImage getCanvasImg() {
        return canvasImg;
    }

    public void setCanvasImg(BufferedImage canvasImg) {
        this.canvasImg = canvasImg;
    }

    public Graphics2D getCanvas() {
        return canvas;
    }

    public void setCanvas(Graphics2D canvas) {
        this.canvas = canvas;
    }

    public Point2D.Double getCanvasSize() {
        return canvasSize;
    }

    public void setCanvasSize(Point2D.Double canvasSize) {
        this.canvasSize = canvasSize;
    }

    public double getZoomFactor() {
        return zoomFactor;
    }

    public void setZoomFactor(double zoomFactor) {
        this.zoomFactor = zoomFactor;
    }
}
