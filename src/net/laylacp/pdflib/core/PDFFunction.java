/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: PDFFunction.java
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
import net.laylacp.pdflib.core.types.ObjectStack;
import net.laylacp.pdflib.reader.PDFByteArray;
import net.laylacp.pdflib.reader.PDFReader;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PDFFunction {
    public static final int SAMPLED_FUNCTION      = 0;
    public static final int EXPONENTIAL_FUNCTION  = 2;
    public static final int STITCHING_FUNCTION    = 3;
    public static final int POSTSCRIPT_FUNCTION   = 4;

    PDFDocument pdfDocument;
    int funcType;
    int m;              // # of inputs
    int n;              // # of outputs
    float[] domain;     // input's legal values
    float[] range;      // output's legal values

    // members specific for Type 0 functions
    float[] size;
    int bitsPerSample;
    int order;
    float[] encode;
    float[] decode;
    int[][] samples;

    // members specific for Type 2 functions
    float[] C0;
    float[] C1;
    float N;

    // members specific for Type 3 functions
    PDFFunction[] functions;
    float[] bounds;

    // members specific for Type 4 functions
    PDFObjectStream funcObjectStream;


    public PDFFunction(PDFDocument pdfDocument) {
        this.pdfDocument = pdfDocument;
    }

    public int getInputCount() { return m; }

    private float interpolate(float x, float xmin, float xmax, float ymin, float ymax) {
        float d = ymin + ((x-xmin)*((ymax-ymin)/(xmax-xmin)));
        return d;
    }

    public float[] doFunction(float[] in) {
        if(in.length != m) return null;
        int i;
        float[] out = new float[n];
        if(funcType == 0) {
            // SEE the calculation on page 94 of PDF 1.7 Std.
            float[] ein = new float[m];

            // encode input values
            for(i = 0; i < m; i++) {
                int k = i*2;
                float xi = Math.min(Math.max(in[i], domain[k]), domain[k+1]);
                float j = interpolate(xi, domain[k], domain[k+1], encode[k], encode[k+1]);
                ein[i] = Math.min(Math.max(j, 0), size[i-1]);
            }

            // get the results
            for(i = 0; i < n; i++) {
                if (order == 1) {
                    out[i] = multilinearInterpolate(ein, i);
                } else {
                    out[i] = multicubicInterpolate(ein, i);
                }
            }

            // decode output values
            for(i = 0; i < n; i++) {
                int k = i*2;
                float ri = interpolate(out[i], 0, (float) Math.pow(2, bitsPerSample-1),
                                    decode[k], decode[k+1]);
                out[i] = Math.min(Math.max(ri, range[k]), range[k+1]);
            }

        } else if(funcType == 2) {
            // SEE the calculation on page 96 of PDF 1.7 Std.
            for(i = 0; i < n; i++) {
                out[i] = (float) (C0[i] + (Math.pow(in[0], N) * (C1[i] - C0[i])));
            }

        } else if(funcType == 3) {
            // SEE the calculation on page 97 of PDF 1.7 Std.
            float x = in[0];
            i = bounds.length - 2;
            while (x < bounds[i]) i--;
            int j = i*2;
            x = interpolate(x, bounds[i], bounds[i+1], encode[j], encode[j + 1]);
            out = functions[i].doFunction(new float[]{x});

        } else if(funcType == 4) {
            if(funcObjectStream == null) return null;
            ObjectStack operands = new ObjectStack();
            ObjectStack ifoperands = new ObjectStack();
            int len = in.length;
            for(i = 0; i < len; i++) operands.push(in[i]);

            if(!parseType4Funcion(funcObjectStream.stream, operands, ifoperands))
                return null;

            for(i = 0; i < n; i++) {
                float f = (float) operands.pop();
                out[i] = f;
            }
        }
        return out;
    }

    /*
     * SEE Table 42 – Operators in type 4 functions.
     */
    private boolean parseType4Funcion(PDFByteArray byteArray,
                                      ObjectStack operands, ObjectStack ifoperands) {
        PDFReader reader = pdfDocument.reader;
        PDFByteArray savedByteArray = reader.byteArray;
        reader.byteArray = byteArray;
        reader.byteArray.offset = 0;
        PDFObject obj = reader.getNextObject();
        if(!obj.getStringValue().equalsIgnoreCase("{")) return false;
        int i, len, savedOffset;

        while(true) {
            savedOffset = reader.byteArray.offset;
            obj = reader.getNextObject();
            if(obj== null) break;
            if(obj.getType() == PDFObject.OBJECT_TYPE.STRING_OBJECT) {
                String string = obj.getStringValue();
                    /*
                     * 1 - Stack operators
                     *
                     * SEE http://www.math.ubc.ca/~cass/courses/ps.html
                     */
                if(string.equalsIgnoreCase("copy")) {
                    float c = (float) operands.pop();
                    int count = (int) c;
                    ArrayList<Object> stackContents = operands.getObjects();
                    i = stackContents.size()-count;
                    if(i < 0) return false;
                    while(count-- > 0) {
                        float f = (float) stackContents.get(i++);
                        operands.push(new Float(f));
                    }
                } else if(string.equalsIgnoreCase("dup")) {
                    float f = (float) operands.pop();
                    operands.push(f);
                    operands.push(new Float(f));
                } else if(string.equalsIgnoreCase("exch")) {
                    Object o1 = operands.pop();
                    Object o2 = operands.pop();
                    operands.push(o1);
                    operands.push(o2);
                } else if(string.equalsIgnoreCase("index")) {
                    float f = (float) operands.pop();
                    int count = (int) f;
                    ArrayList<Object> stackContents = operands.getObjects();
                    i = stackContents.size()-1-count;
                    if(i < 0) return false;
                    f = (float) stackContents.get(i);
                    operands.push(new Float(f));
                } else if(string.equalsIgnoreCase("pop")) {
                    operands.pop();
                } else if(string.equalsIgnoreCase("roll")) {
                    float f = (float) operands.pop();
                    int j = (int) f;
                    f = (float) operands.pop();
                    int n = (int) f;
                    ArrayList<Object> stackContents = operands.getObjects();
                    len = stackContents.size();
                    i = len - 1 - n;
                    for (; i < len; i++) {
                        int k = i % j;
                        Object object1 = stackContents.get(i);
                        Object object2 = stackContents.get(k);
                        stackContents.set(k, object1);
                        stackContents.set(i, object2);
                    }
                    /*
                     * 2 - Arithmetic operators
                     */
                } else if(string.equalsIgnoreCase("abs")) {
                    float f = (float) operands.pop();
                    f = Math.abs(f);
                    operands.push(f);
                } else if(string.equalsIgnoreCase("add")) {
                    float a = (float) operands.pop();
                    float b = (float) operands.pop();
                    float c = a+b;
                    operands.push(c);
                } else if(string.equalsIgnoreCase("atan")) {
                    float a = (float) operands.pop();
                    float b = (float) operands.pop();
                    a /= b;
                    float c = (float) Math.atan(Math.toRadians(a));
                    operands.push(c);
                } else if(string.equalsIgnoreCase("ceiling")) {
                    float a = (float) operands.pop();
                    float c = (float) Math.ceil(a);
                    operands.push(c);
                } else if(string.equalsIgnoreCase("cos")) {
                    float a = (float) operands.pop();
                    float c = (float) Math.cos(Math.toRadians(a));
                    operands.push(c);
                } else if(string.equalsIgnoreCase("cvi")) {
                    // no-op. stack already contains numbers, no strings allowed.
                    // SEE page 98 of PDF 1.7 Std.
                } else if(string.equalsIgnoreCase("cvr")) {
                    // no-op. stack already contains numbers, no strings allowed.
                    // SEE page 98 of PDF 1.7 Std.
                } else if(string.equalsIgnoreCase("div")) {
                    float a = (float) operands.pop();
                    float b = (float) operands.pop();
                    float c = a/b;
                    operands.push(c);
                } else if(string.equalsIgnoreCase("exp")) {
                    float a = (float) operands.pop();
                    float b = (float) operands.pop();
                    float c = (float) Math.pow(a, b);
                    operands.push(c);
                } else if(string.equalsIgnoreCase("floor")) {
                    float a = (float) operands.pop();
                    float c = (float) Math.floor(a);
                    operands.push(c);
                } else if(string.equalsIgnoreCase("idiv")) {
                    float a = (float) operands.pop();
                    float b = (float) operands.pop();
                    int c = (int) (a/b);
                    operands.push((float) c);
                } else if(string.equalsIgnoreCase("ln")) {
                    float a = (float) operands.pop();
                    float c = (float) Math.log(a);
                    operands.push(c);
                } else if(string.equalsIgnoreCase("log")) {
                    float a = (float) operands.pop();
                    float c = (float) Math.log10(a);
                    operands.push(c);
                } else if(string.equalsIgnoreCase("mod")) {
                    float a = (float) operands.pop();
                    float b = (float) operands.pop();
                    int c = (int)a % (int)b;
                    operands.push((float) c);
                } else if(string.equalsIgnoreCase("mul")) {
                    float a = (float) operands.pop();
                    float b = (float) operands.pop();
                    float c = a*b;
                    operands.push(c);
                } else if(string.equalsIgnoreCase("neg")) {
                    float a = (float) operands.pop();
                    float c = -a;
                    operands.push(c);
                } else if(string.equalsIgnoreCase("round")) {
                    float a = (float) operands.pop();
                    int c = Math.round(a);
                    operands.push((float) c);
                } else if(string.equalsIgnoreCase("sin")) {
                    float a = (float) operands.pop();
                    float c = (float) Math.sin(Math.toRadians(a));
                    operands.push(c);
                } else if(string.equalsIgnoreCase("sqrt")) {
                    float a = (float) operands.pop();
                    float c = (float) Math.sqrt(a);
                    operands.push(c);
                } else if(string.equalsIgnoreCase("sub")) {
                    float a = (float) operands.pop();
                    float b = (float) operands.pop();
                    float c = a-b;
                    operands.push(c);
                } else if(string.equalsIgnoreCase("truncate")) {
                    float a = (float) operands.pop();
                    int c;
                    if(a < 0) c = (int) Math.ceil(a);
                    else      c = (int) Math.floor(a);
                    operands.push((float) c);
                    /*
                     * 3 - Relational, bitwise, boolean operators
                     */
                } else if(string.equalsIgnoreCase("and")) {
                    float a = (float) operands.pop();
                    float b = (float) operands.pop();
                    int c = (int)a & (int)b;
                    operands.push((float)c);
                } else if(string.equalsIgnoreCase("bitshift")) {
                    float a = (float) operands.pop();
                    float b = (float) operands.pop();
                    int c;
                    if(b > 0) c = (int)a << (int)b;
                    else      c = (int)a >> (int)b;
                    operands.push((float)c);
                } else if(string.equalsIgnoreCase("eq")) {
                    float a = (float) operands.pop();
                    float b = (float) operands.pop();
                    float c = (a == b) ? 1 : 0;
                    operands.push(c);
                } else if(string.equalsIgnoreCase("false")) {
                    operands.push(0.0F);
                } else if(string.equalsIgnoreCase("ge")) {
                    float a = (float) operands.pop();
                    float b = (float) operands.pop();
                    float c = (a >= b) ? 1 : 0;
                    operands.push(c);
                } else if(string.equalsIgnoreCase("gt")) {
                    float a = (float) operands.pop();
                    float b = (float) operands.pop();
                    float c = (a > b) ? 1 : 0;
                    operands.push(c);
                } else if(string.equalsIgnoreCase("le")) {
                    float a = (float) operands.pop();
                    float b = (float) operands.pop();
                    float c = (a <= b) ? 1 : 0;
                    operands.push(c);
                } else if(string.equalsIgnoreCase("lt")) {
                    float a = (float) operands.pop();
                    float b = (float) operands.pop();
                    float c = (a < b) ? 1 : 0;
                    operands.push(c);
                } else if(string.equalsIgnoreCase("ne")) {
                    float a = (float) operands.pop();
                    float b = (float) operands.pop();
                    float c = (a != b) ? 1 : 0;
                    operands.push(c);
                } else if(string.equalsIgnoreCase("not")) {
                    float a = (float) operands.pop();
                    int b = (int) a;
                    int c;
                    if(a == 1) c = 0;
                    else if(a == 0) c = 1;
                    else c = ~b;
                    operands.push((float) c);
                } else if(string.equalsIgnoreCase("or")) {
                    float a = (float) operands.pop();
                    float b = (float) operands.pop();
                    int c = (int)a | (int)b;
                    operands.push((float) c);
                } else if(string.equalsIgnoreCase("true")) {
                    operands.push(1.0F);
                } else if(string.equalsIgnoreCase("xor")) {
                    float a = (float) operands.pop();
                    float b = (float) operands.pop();
                    int c = (int)a ^ (int)b;
                    operands.push((float) c);
                    /*
                     * 4 - Conditional operators
                     */
                } else if(string.equalsIgnoreCase("if")) {
                    byte[] ifbytes = (byte[]) ifoperands.pop();
                    float test = (float) operands.pop();
                    if(test == 1) {
                        if(!parseType4Funcion(new PDFByteArray(0, ifbytes), operands, ifoperands))
                            return false;
                    }
                } else if(string.equalsIgnoreCase("ifelse")) {
                    byte[] elsebytes = (byte[]) ifoperands.pop();
                    byte[] ifbytes   = (byte[]) ifoperands.pop();
                    float test = (float) operands.pop();
                    if(test == 1) {
                        if(!parseType4Funcion(new PDFByteArray(0, ifbytes), operands, ifoperands))
                            return false;
                    } else {
                        if(!parseType4Funcion(new PDFByteArray(0, elsebytes), operands, ifoperands))
                            return false;
                    }
                } else if(string.equalsIgnoreCase("{")) {
                    i = savedOffset+1;
                    try {
                        while(byteArray.getByteAt(i) != '}') i++;
                        byte[] ifbytes = Arrays.copyOfRange(byteArray.data, savedOffset, i+1);
                        byteArray.offset = i+1;
                        ifoperands.push(ifbytes);
                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                    }
                } else if(!string.equalsIgnoreCase("}")) {
                    /*
                     * End of function
                     */
                    break;
                }
            } else if(obj.getType() == PDFObject.OBJECT_TYPE.INTEGER_OBJECT ||
                    obj.getType() == PDFObject.OBJECT_TYPE.REAL_OBJECT) {
                operands.push((float)obj.getNumericValue());
            } else {
                    /*
                     * TODO: we should raise an Exception and alert the caller to this error.
                     */
                return false;
            }
        }
        reader.byteArray = savedByteArray;
        return true;
    }

    public boolean parse(HashMap<String, PDFObject> funcDictionary) {
        // get function type
        funcType = PDFDict.getIntDictEntry(funcDictionary, "FunctionType");
        if(funcType != 0 && funcType != 2 && funcType != 3 && funcType != 4) return false;
        // get the domain values (for m inputs)
        ArrayList<PDFObject> arrayList = PDFDict.getArrayDictEntry(funcDictionary, "Domain");
        if(arrayList.size() == 0) return false;
        m = arrayList.size()/2;
        domain = getFloatArray(arrayList);
        // get the range values (for n outputs)
        n = 0;
        arrayList = PDFDict.getArrayDictEntry(funcDictionary, "Range");
        if(arrayList.size() == 0) {
            // required only for type 0 and 4 functions
            if(funcType == 0 || funcType == 4) return false;
        } else {
            n = arrayList.size() / 2;
            range = getFloatArray(arrayList);
        }

        if(funcType == 0) {
            arrayList = PDFDict.getArrayDictEntry(funcDictionary, "Size");
            if(arrayList.size() == 0) return false;
            if(m == 0) m = arrayList.size();
            size = getFloatArray(arrayList);
            bitsPerSample = PDFDict.getIntDictEntry(funcDictionary, "BitsPerSample");
            if(bitsPerSample != 1 && bitsPerSample != 2 && bitsPerSample != 4 &&
                    bitsPerSample != 8 && bitsPerSample != 12 && bitsPerSample != 16 &&
                    bitsPerSample != 24 && bitsPerSample != 32) return false;
            order = PDFDict.getIntDictEntry(funcDictionary, "Order");
            if(order == -1) order = 1;
            arrayList = PDFDict.getArrayDictEntry(funcDictionary, "Encode");
            if(arrayList.size() == 0) {
                encode = new float[m*2];
                int j = 0;
                for(int i = 0; i < m*2; i += 2, j++) {
                    encode[i  ] = 0;
                    encode[i+1] = size[j]-1;
                }
            } else {
                encode = getFloatArray(arrayList);
            }
            arrayList = PDFDict.getArrayDictEntry(funcDictionary, "Decode");
            if(arrayList.size() == 0) {
                decode = range.clone();
            } else {
                decode = getFloatArray(arrayList);
            }
            return true;

        } else if(funcType == 2) {
            arrayList = PDFDict.getArrayDictEntry(funcDictionary, "C0");
            if(arrayList.size() == 0) {
                C0 = new float[] { 0.0F };
                if(n == 0) n = 1;
            } else {
                C0 = getFloatArray(arrayList);
                if(n == 0) n = C0.length;
            }
            arrayList = PDFDict.getArrayDictEntry(funcDictionary, "C1");
            if(arrayList.size() == 0) {
                C1 = new float[] { 1.0F };
                if(n == 0) n = 1;
            } else {
                C1 = getFloatArray(arrayList);
                if(n == 0) n = C1.length;
            }
            N = (float) PDFDict.getRealDictEntry(funcDictionary, "N");
            return true;

        } else if(funcType == 3) {
            arrayList = PDFDict.getArrayDictEntry(funcDictionary, "Functions");
            int count = arrayList.size();
            if(count == 0) return false;
            // get the functions
            functions = new PDFFunction[count];
            for(int i = 0; i < count; i++) {
                PDFFunction function = new PDFFunction(pdfDocument);
                PDFObject funcObj = arrayList.get(i);
                if (funcObj.getType() == PDFObject.OBJECT_TYPE.DICTIONARY_OBJECT) {
                    if (!function.parse(funcObj.getDictionaryValue())) return false;
                } else if (funcObj.getType() == PDFObject.OBJECT_TYPE.INDIRECT_REF_OBJECT) {
                    if (!function.parse(funcObj.getIdValue())) return false;
                } else {
                    return false;
                }
                functions[i] = function;
            }

            // get the bounds
            arrayList = PDFDict.getArrayDictEntry(funcDictionary, "Bounds");
            count = arrayList.size();
            bounds = new float[count+2];
            bounds[0] = domain[0];
            int i = 0;
            while(i++ < count) {
                bounds[i] = (float) arrayList.get(i-1).getNumericValue();
            }
            bounds[i+1] = domain[1];

            // get the encode limits
            arrayList = PDFDict.getArrayDictEntry(funcDictionary, "Encode");
            if(arrayList.size() == 0) return false;
            encode = getFloatArray(arrayList);
            return true;

        } else if(funcType == 4) {
            return true;

        }

        return false;
    }

    public boolean parse(ObjectId funcStreamId) {
        PDFObjectStream objectStream = pdfDocument.reader.getObjectStreamById(funcStreamId, pdfDocument);
        if(objectStream == null) return false;
        return parse(objectStream);
    }

    public boolean parse(PDFObjectStream funcObjectStream) {
        if(funcObjectStream == null) return false;
        if(parse(funcObjectStream.dictionary) == false) return false;

        if(funcType == 0) {
            // read the samples.
            int ssize = 1;
            for (int i = 0; i < m; i++) {
                ssize *= size[i];
            }
            samples = new int[ssize][n];

            PDFBitStream bitStream = new PDFBitStream(funcObjectStream.stream.data);
            int index = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < size[i]; j++) {
                    for (int k = 0; k < n; k++) {
                        int value = 0;
                        try {
                            value = bitStream.getBits(bitsPerSample);
                        } catch (EOFException e) {
                            e.printStackTrace();
                            return false;
                        }
                        samples[index][k] = value;
                    }
                    index++;
                }
            }
        } else if(funcType == 4) {
            this.funcObjectStream = funcObjectStream;
        }

        return true;
    }

    private float[] getFloatArray(ArrayList<PDFObject> arrayList) {
        int len = arrayList.size();
        float[] array = new float[len];
        for(int i = 0; i < len; i++) {
            array[i] = (float) arrayList.get(i).getNumericValue();
        }
        return array;
    }



    /****************************************************************************************
     * The code to all the following functions is taken from the file:
     * com.sun.pdfview.FunctionType0.java, which is found at:
     *
     * https://www.javatips.net/api/PDFrenderer-master/src/com/sun/pdfview/function/FunctionType0.java
     *
     * the source code is released under GNU LGPL.
     ****************************************************************************************/

    private  float multilinearInterpolate(float[] encoded, int od) {
        // first calculate the distances -- the differences between
        // each encoded value and the integer below it.
        float[] dists = new float[encoded.length];

        for (int i = 0; i < dists.length; i++) {
            dists[i] = (float) (encoded[i] - Math.floor(encoded[i]));
        }

        // initialize the map of axes.  Each bit in this map represents
        // whether the control value in that dimension should be the integer
        // above or below encoded[i]
        int map = 0;

        // the initial values
        float val = getSample(encoded, map, od);
        float prev = val;

        // walk the axes
        for (int i = 0; i < dists.length; i++) {
            int idx = 0;
            float largest = -1;
            for (int c = 0; c < dists.length; c++) {
                if (dists[c] > largest) {
                    largest = dists[c];
                    idx = c;
                }
            }
            map |= (0x1 << idx);
            float cur = getSample(encoded, map, od);
            val += dists[idx] * (cur - prev);
            prev = val;
            dists[idx] = -1;
        }
        return val;
    }

    private  float multicubicInterpolate(float[] encoded, int od) {
        PDFReader.__DEBUG__("multicubicInterpolate", "Cubic interpolation not supported!");
        return multilinearInterpolate(encoded, od);
    }

    private  float getSample(float[] encoded, int map, int od) {
        int[] controls = new int[encoded.length];
        for (int i = 0; i < controls.length; i++) {
            if ((map & (0x1 << i)) == 0) {
                controls[i] = (int) Math.floor(encoded[i]);
            } else {
                controls[i] = (int) Math.ceil(encoded[i]);
            }
        }
        return getSample(controls, od);
    }

    protected  int getSample(int[] values, int od) {
        int mult = 1;
        int index = 0;
        for (int i = 0; i < values.length; i++) {
            index += mult * values[i];
            mult *= size[i];
        }
        return this.samples[index][od];
    }

}
