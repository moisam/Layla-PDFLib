/*
 *    Programmed By: Mohammed Isam [mohammed_isam1984@yahoo.com]
 *    Copyright 2017 (c)
 *
 *    file: TokenType.java
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

package net.laylacp.pdflib.core.types;

public enum TokenType {
    TOKEN_WHITESPACE,
    TOKEN_LT_PAREN,
    TOKEN_RT_PAREN,
    TOKEN_LESS_THAN,
    TOKEN_GREATER_THAN,
    TOKEN_LT_BRACKET,
    TOKEN_RT_BRACKET,
    TOKEN_LT_CURLY,
    TOKEN_RT_CURLY,
    TOKEN_SOLIDUS,
    TOKEN_PERCENT,

    TOKEN_NAME_OBJECT,
    TOKEN_UNKOWN_WORD,
    TOKEN_DBL_LESS_THAN,
    TOKEN_DBL_GREATER_THAN,

    TOKEN_EOF,
}
