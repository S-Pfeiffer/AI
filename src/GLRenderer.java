import static org.lwjgl.opengl.GL11.*;

public class GLRenderer {
    /**
     * Setzt einen einzelnen Pixel auf die angegebene Farbe.
     *
     * @param x     Die x-Koordinate des Pixels (-1.0 bis 1.0).
     * @param y     Die y-Koordinate des Pixels (-1.0 bis 1.0).
     * @param red   Rotwert (0.0 bis 1.0).
     * @param green Grünwert (0.0 bis 1.0).
     * @param blue  Blauwert (0.0 bis 1.0).
     */
    public void setPixel(float x, float y, float red, float green, float blue) {
        glBegin(GL_POINTS);
        glColor3f(red, green, blue);
        glVertex2f(x, y);
        glEnd();
    }

    /**
     * Zeichnet ein Rechteck mit der angegebenen Farbe.
     *
     * @param x1    Die linke untere x-Koordinate (-1.0 bis 1.0).
     * @param y1    Die linke untere y-Koordinate (-1.0 bis 1.0).
     * @param x2    Die rechte obere x-Koordinate (-1.0 bis 1.0).
     * @param y2    Die rechte obere y-Koordinate (-1.0 bis 1.0).
     * @param red   Rotwert (0.0 bis 1.0).
     * @param green Grünwert (0.0 bis 1.0).
     * @param blue  Blauwert (0.0 bis 1.0).
     */
    public void drawRectangle(float x1, float y1, float x2, float y2, float red, float green, float blue) {
        glBegin(GL_QUADS);
        glColor3f(red, green, blue);
        glVertex2f(x1, y1);
        glVertex2f(x2, y1);
        glVertex2f(x2, y2);
        glVertex2f(x1, y2);
        glEnd();
    }

    /**
     * Zeichnet eine Linie zwischen zwei Punkten.
     *
     * @param x1    Die x-Koordinate des Startpunkts (-1.0 bis 1.0).
     * @param y1    Die y-Koordinate des Startpunkts (-1.0 bis 1.0).
     * @param x2    Die x-Koordinate des Endpunkts (-1.0 bis 1.0).
     * @param y2    Die y-Koordinate des Endpunkts (-1.0 bis 1.0).
     * @param red   Rotwert (0.0 bis 1.0).
     * @param green Grünwert (0.0 bis 1.0).
     * @param blue  Blauwert (0.0 bis 1.0).
     */
    public void drawLine(float x1, float y1, float x2, float y2, float red, float green, float blue) {
        glBegin(GL_LINES);
        glColor3f(red, green, blue);
        glVertex2f(x1, y1);
        glVertex2f(x2, y2);
        glEnd();
    }
}
