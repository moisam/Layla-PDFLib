package net.laylacp.pdflib.graphics;


import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.util.HashMap;
import java.util.Map;

public class GraphicsState implements Cloneable {


    /*
     * SEE Figure 9 – Graphics Objects, page 113.
     */
    public enum State {
        PAGE_DESCRIPTION_LEVEL,
        PATH_OBJECT,
        TEXT_OBJECT,
        CLIPPING_PATH_OBJECT,
        SHADING_OBJECT,
        INLINE_IMAGE_OBJECT,
        EXTERNAL_OBJECT
    }

    /*
     * PDF standard says (on page 110):
     * ================================
     * The graphics state includes the current transformation matrix (CTM), which maps user space
     * coordinates used within a PDF content stream into output device coordinates. It also includes
     * the current colour, the current clipping path, and many other parameters that are implicit
     * operands of the painting operators
     */

    /* Device-Independent Parameters */
    private AffineTransform CTM;
    private TextState textState = new TextState();

    private Path2D curClippingPath;
    private boolean delayedClipping;
    private int delayedClippingMode;

    private State curState;
    private Color curColorStroke;       // default: Black
    private Color curColorOthers;       // default: Black
    private PDFColorSpace curColorSpaceStroke;  // default: DeviceGray
    private PDFColorSpace curColorSpaceOthers;  // default: DeviceGray
    private float alphaStroke;       // default: 1.0
    private float alphaOthers;       // default: 1.0
    private boolean alphaIsShape;      // default: false
    private float lineWidth;          // default: 1.0
    private int lineCap;              // default: 0
    private int lineJoin;             // default: 0
    private float miterLimit;         // default: 10.0
    private String renderingIntent;
    private boolean strokeAdjust;
    private BlendComposite.BlendingMode blendMode;

    private float[] dashArray;        // default: {}
    private int dashPhase;            // default: 0

    /* TODO: fix those variables */
    private int softMask;     // TODO: actually can be a name OR a dictionary

    /* variables related to the page */
    private Rectangle mediaBox;
    private Rectangle cropBox;
    private int rotate;
    private double userUnits;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object obj = super.clone(); //utilize clone Object method
        GraphicsState graphicsState = (GraphicsState) obj;

        // deep cloning for immutable fields
        graphicsState.CTM = new AffineTransform(CTM);
        graphicsState.textState = (TextState) this.textState.clone();
        graphicsState.curClippingPath = (Path2D.Double) this.curClippingPath.clone();
        graphicsState.delayedClipping = this.delayedClipping;
        graphicsState.delayedClippingMode = this.delayedClippingMode;
        graphicsState.curState = this.curState;
        graphicsState.curColorStroke = new Color(this.curColorStroke.getRGB());
        graphicsState.curColorOthers = new Color(this.curColorOthers.getRGB());
        graphicsState.curColorSpaceStroke = (PDFColorSpace) this.curColorSpaceStroke.clone();
        graphicsState.curColorSpaceOthers = (PDFColorSpace) this.curColorSpaceOthers.clone();
        graphicsState.alphaStroke = this.alphaStroke;
        graphicsState.alphaOthers = this.alphaOthers;
        graphicsState.alphaIsShape = this.alphaIsShape;
        graphicsState.lineWidth = this.lineWidth;
        graphicsState.lineCap = this.lineCap;
        graphicsState.lineJoin = this.lineJoin;
        graphicsState.miterLimit = this.miterLimit;
        graphicsState.renderingIntent = this.renderingIntent;
        graphicsState.strokeAdjust = this.strokeAdjust;
        graphicsState.dashArray = this.dashArray.clone();
        graphicsState.dashPhase = this.dashPhase;
        graphicsState.blendMode = this.blendMode;
        graphicsState.softMask = this.softMask;
        graphicsState.mediaBox = new Rectangle(this.mediaBox.x1, this.mediaBox.y1,
                                                this.mediaBox.x2, this.mediaBox.y2);
        graphicsState.cropBox = new Rectangle(this.cropBox.x1, this.cropBox.y1,
                this.cropBox.x2, this.cropBox.y2);
        graphicsState.rotate = this.rotate;
        graphicsState.userUnits = this.userUnits;

        return graphicsState;
    }

    /* getter and setter functions */

    public int getDashPhase() {
        return dashPhase;
    }

    public void setDashPhase(int dashPhase) {
        this.dashPhase = dashPhase;
    }

    public float[] getDashArray() {
        return dashArray;
    }

    public void setDashArray(float[] dashArray) {
        this.dashArray = dashArray;
    }

    public boolean isDelayedClipping() {
        return delayedClipping;
    }

    public void setDelayedClipping(boolean delayedClipping) {
        this.delayedClipping = delayedClipping;
    }

    public int getDelayedClippingMode() { return delayedClippingMode; }

    public void setDelayedClippingMode(int delayedClippingMode) {
        this.delayedClippingMode = delayedClippingMode;
    }

    public PDFColorSpace getCurColorSpaceStroke() {
        return curColorSpaceStroke;
    }

    public void setCurColorSpaceStroke(PDFColorSpace curColorSpaceStroke) {
        this.curColorSpaceStroke = curColorSpaceStroke;
    }

    public PDFColorSpace getCurColorSpaceOthers() {
        return curColorSpaceOthers;
    }

    public void setCurColorSpaceOthers(PDFColorSpace curColorSpaceOthers) {
        this.curColorSpaceOthers = curColorSpaceOthers;
    }

    public Color getCurColorOthers() { return curColorOthers; }

    public void setCurColorOthers(Color curColorOthers) {
        this.curColorOthers = curColorOthers;
    }

    public Color getCurColorStroke() { return curColorStroke; }

    public void setCurColorStroke(Color curColorStroke) {
        this.curColorStroke = curColorStroke;
    }

    public TextState getTextState() {
        return textState;
    }

    public void setTextState(TextState textState) {
        this.textState = textState;
    }

    public AffineTransform getCTM() {
        return CTM;
    }

    public void setCTM(AffineTransform CTM) {
        this.CTM = CTM;
    }

    public BlendComposite.BlendingMode getBlendMode() {
        return blendMode;
    }

    public void setBlendMode(BlendComposite.BlendingMode blendMode) {
        this.blendMode = blendMode;
    }

    public Path2D getCurClippingPath() { return curClippingPath; }

    public State getCurState() { return curState; }

    public void setCurClippingPath(Path2D curClippingPath) {
        this.curClippingPath = (Path2D) curClippingPath.clone();
    }

    public void setCurState(State curState) { this.curState = curState; }

    public Rectangle getCropBox() { return cropBox; }

    public Rectangle getMediaBox() { return mediaBox; }

    public void setCropBox(Rectangle cropBox) { this.cropBox = cropBox; }

    public void setMediaBox(Rectangle mediaBox) { this.mediaBox = mediaBox; }

    public int getRotate() { return rotate; }

    public void setRotate(int rotate) { this.rotate = rotate; }

    public double getUserUnits() { return userUnits; }

    public void setUserUnits(double userUnits) { this.userUnits = userUnits; }

    public float getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    public int getLineCap() {
        return lineCap;
    }

    public void setLineCap(int lineCap) {
        this.lineCap = lineCap;
    }

    public int getLineJoin() {
        return lineJoin;
    }

    public void setLineJoin(int lineJoin) {
        this.lineJoin = lineJoin;
    }

    public float getMiterLimit() {
        return miterLimit;
    }

    public void setMiterLimit(float miterLimit) {
        this.miterLimit = miterLimit;
    }

    public String getRenderingIntent() {
        return renderingIntent;
    }

    public void setRenderingIntent(String renderingIntent) {
        this.renderingIntent = renderingIntent;
    }

    public boolean isStrokeAdjust() {
        return strokeAdjust;
    }

    public void setStrokeAdjust(boolean strokeAdjust) {
        this.strokeAdjust = strokeAdjust;
    }

    public float getAlphaOthers() {
        return alphaOthers;
    }

    public float getAlphaStroke() {
        return alphaStroke;
    }

    public boolean getAlphaIsShape() { return alphaIsShape; }

    public void setAlphaOthers(float alphaOthers) {
        this.alphaOthers = alphaOthers;
    }

    public void setAlphaStroke(float alphaStroke) {
        this.alphaStroke = alphaStroke;
    }

    public void setAlphaIsShape(boolean alphaIsShape) {
        this.alphaIsShape = alphaIsShape;
    }
}
