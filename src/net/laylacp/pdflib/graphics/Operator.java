/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: Operator.java
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

public class Operator {
    public static Operator[] PDFOperators = {
            /*
             * SEE Table 51 – Operator Categories, page 111, PDF 1.7 Std.
             * SEE ALSO Table 59 – Path Construction Operators, page 132.
             * SEE ALSO Table 32 – Compatibility operators, page 82.
             * SEE ALSO Table 61 – Clipping Path Operators, page 138.
             * SEE ALSO Table 109 – Text-showing operators, page 250.
             */

            /* general graphics state operators */
            new Operator("w", 1),
            new Operator("J", 1),
            new Operator("j", 1),
            new Operator("M", 1),
            new Operator("d", 2),
            new Operator("ri", 1),
            new Operator("i", 1),
            new Operator("gs", 1),

            /* special graphics state operators */
            new Operator("q", 0),
            new Operator("Q", 0),
            new Operator("cm", 6),

            /* path construction operators */
            new Operator("m", 2),
            new Operator("l", 2),
            new Operator("c", 6),
            new Operator("v", 4),
            new Operator("y", 4),
            new Operator("h", 0),
            new Operator("re", 4),

            /* path painting operators */
            new Operator("S", 0),
            new Operator("s", 0),
            new Operator("f", 0),
            new Operator("F", 0),
            new Operator("f*", 0),
            new Operator("B", 0),
            new Operator("B*", 0),
            new Operator("b", 0),
            new Operator("b*", 0),
            new Operator("n", 0),

            /* clipping paths operators */
            new Operator("W", 0),
            new Operator("W*", 0),

            /* text objects operators */
            new Operator("BT", 0),
            new Operator("ET", 0),

            /* text state operators */
            new Operator("Tc", 1),
            new Operator("Tw", 1),
            new Operator("Tz", 1),
            new Operator("TL", 1),
            new Operator("Tf", 2),
            new Operator("Tr", 1),
            new Operator("Ts", 1),

            /* text positioning operators */
            new Operator("Td", 2),
            new Operator("TD", 2),
            new Operator("Tm", 6),
            new Operator("T*", 0),

            /* text showing operators */
            new Operator("Tj", 1),
            new Operator("TJ", 1),
            new Operator("'", 1),
            new Operator("\"", 3),

            /* type 3 fonts operators */
            new Operator("d0", 2),
            new Operator("d1", 6),

            /* color operators */
            new Operator("CS", 0),
            new Operator("cs", 0),
            new Operator("SC", 0),
            new Operator("SCN", 0),
            new Operator("sc", 0),
            new Operator("scn", 0),
            new Operator("G", 0),
            new Operator("g", 0),
            new Operator("RG", 0),
            new Operator("rg", 0),
            new Operator("K", 0),
            new Operator("k", 0),

            /* shading patterns operators */
            new Operator("sh", 0),

            /* inline images operators */
            new Operator("BI", 0),
            new Operator("ID", 0),
            new Operator("EI", 0),

            /* XObjects operators */
            new Operator("Do", 0),

            /* marked content operators */
            new Operator("MP", 0),
            new Operator("DP", 0),
            new Operator("BMC", 0),
            new Operator("BDC", 0),
            new Operator("EMC", 0),

            /* compatibility operators */
            new Operator("BX", 0),
            new Operator("EX", 0),
    };

    public String name;
    public int operandCount;

    public Operator(String name, int operandCount) {
        this.name = name;
        this.operandCount = operandCount;
    }
}
