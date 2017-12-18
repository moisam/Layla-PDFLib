package net.laylacp.pdflib.graphics;

import java.awt.geom.AffineTransform;

public class TextState implements Cloneable {
    /*
     * SEE Table 106 – Text rendering modes, page 246 of PDF 1.7.
     */
    public static final int RENDER_FILL = 0;
    public static final int RENDER_STROKE = 1;
    public static final int RENDER_FILL_STROKE = 2;
    public static final int RENDER_NONE = 3;
    public static final int RENDER_FILL_CLIP = 4;
    public static final int RENDER_STROKE_CLIP = 5;
    public static final int RENDER_FILL_STROKE_CLIP = 6;
    public static final int RENDER_CLIP = 7;

    /*
     * SEE Table 104 – Text state parameters, page 243 of PDF 1.7.
     * SEE Table 105 – Text state operators, page 243 of PDF 1.7.
     */
    private float charSpace;        // Tc
    private float wordSpace;        // Tw
    private float horzScale;        // Th
    private float textLeading;      // Tl
    private String fontName;        // Tf
    private float fontSize;         // Tfs
    private int renderMode;         // Tmode
    private float textRise;         // Trise
    private boolean textKnockout;   // Tk

    private AffineTransform Tm;
    private AffineTransform Tlm;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object obj = super.clone(); //utilize clone Object method
        TextState textState = (TextState) obj;

        textState.charSpace = this.charSpace;
        textState.wordSpace = this.wordSpace;
        textState.horzScale = this.horzScale;
        textState.textLeading = this.textLeading;
        textState.fontName = this.fontName;
        textState.fontSize = this.fontSize;
        textState.renderMode = this.renderMode;
        textState.textRise = this.textRise;
        textState.textKnockout = this.textKnockout;
        if(this.Tm != null) textState.Tm = new AffineTransform(this.Tm);
        if(this.Tlm != null) textState.Tlm = new AffineTransform(this.Tlm);

        return textState;
    }

    public float getCharSpace() {
        return charSpace;
    }

    public void setCharSpace(float charSpace) {
        this.charSpace = charSpace;
    }

    public float getWordSpace() {
        return wordSpace;
    }

    public void setWordSpace(float wordSpace) {
        this.wordSpace = wordSpace;
    }

    public float getHorzScale() {
        return horzScale;
    }

    public void setHorzScale(float horzScale) {
        this.horzScale = horzScale;
    }

    public float getTextLeading() {
        return textLeading;
    }

    public void setTextLeading(float textLeading) {
        this.textLeading = textLeading;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public float getFontSize() {
        return fontSize;
    }

    public void setFontSize(float fontSize) {
        this.fontSize = fontSize;
    }

    public int getRenderMode() {
        return renderMode;
    }

    public void setRenderMode(int renderMode) {
        this.renderMode = renderMode;
    }

    public float getTextRise() {
        return textRise;
    }

    public void setTextRise(float textRise) {
        this.textRise = textRise;
    }

    public boolean getTextKnockout() {
        return textKnockout;
    }

    public void setTextKnockout(boolean textKnockout) {
        this.textKnockout = textKnockout;
    }

    public AffineTransform getTm() {
        return Tm;
    }

    public void setTm(AffineTransform tm) {
        Tm = tm;
    }

    public AffineTransform getTlm() {
        return Tlm;
    }

    public void setTlm(AffineTransform tlm) {
        Tlm = tlm;
    }

}
