package net.laylacp.pdflib.core;

import net.laylacp.pdflib.core.types.TokenType;

public class PDFToken {

    public TokenType type;
    public String value;

    public PDFToken() {
        this.type = TokenType.TOKEN_UNKOWN_WORD;
        this.value = "";
    }

    public PDFToken(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }
}
