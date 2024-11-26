import static org.lwjgl.opengl.GL11.*;

public class GLRenderer {

    public void setPixel(float x, float y, float red, float green, float blue) {
        glBegin(GL_POINTS);
        glColor3f(red, green, blue);
        glVertex2f(x, y);
        glEnd();
    }

    public void drawRectangle(float x1, float y1, float x2, float y2, float red, float green, float blue) {
        glBegin(GL_LINE_LOOP);
        glColor3f(red, green, blue);
        glVertex2f(x1, y1); // unten links
        glVertex2f(x2, y1); // unten rechts
        glVertex2f(x2, y2); // oben rechts
        glVertex2f(x1, y2); // oben links
        glEnd();
    }

    public void fillRectangle(float x1, float y1, float x2, float y2, float red, float green, float blue) {
        glBegin(GL_QUADS);
        glColor3f(red, green, blue);
        glVertex2f(x1, y1); // unten links
        glVertex2f(x2, y1); // unten rechts
        glVertex2f(x2, y2); // oben rechts
        glVertex2f(x1, y2); // oben links
        glEnd();
    }

    public void drawLine(float x1, float y1, float x2, float y2, float red, float green, float blue) {
        glBegin(GL_LINES);
        glColor3f(red, green, blue);
        glVertex2f(x1, y1);
        glVertex2f(x2, y2);
        glEnd();
    }

    public void drawTriangle(float x1, float y1, float x2, float y2, float x3, float y3, float red, float green, float blue) {
        glBegin(GL_LINE_LOOP);
        glColor3f(red, green, blue);
        glVertex2f(x1, y1); // erster Punkt
        glVertex2f(x2, y2); // zweiter Punkt
        glVertex2f(x3, y3); // dritter Punkt
        glEnd();
    }

    public void fillTriangle(float x1, float y1, float x2, float y2, float x3, float y3, float red, float green, float blue) {
        glBegin(GL_TRIANGLES);
        glColor3f(red, green, blue);
        glVertex2f(x1, y1); // erster Punkt
        glVertex2f(x2, y2); // zweiter Punkt
        glVertex2f(x3, y3); // dritter Punkt
        glEnd();
    }

    public void drawCircle(float cx, float cy, float radius, int segments, float red, float green, float blue) {
        glBegin(GL_LINE_LOOP);
        glColor3f(red, green, blue);
        for (int i = 0; i <= segments; i++) {
            double angle = 2 * Math.PI * i / segments;
            float x = (float) (cx + Math.cos(angle) * radius);
            float y = (float) (cy + Math.sin(angle) * radius);
            glVertex2f(x, y);
        }
        glEnd();
    }

    public void fillCircle(float cx, float cy, float radius, int segments, float red, float green, float blue) {
        glBegin(GL_TRIANGLE_FAN);
        glColor3f(red, green, blue);
        glVertex2f(cx, cy); // Mittelpunkt
        for (int i = 0; i <= segments; i++) {
            double angle = 2 * Math.PI * i / segments;
            float x = (float) (cx + Math.cos(angle) * radius);
            float y = (float) (cy + Math.sin(angle) * radius);
            glVertex2f(x, y);
        }
        glEnd();
    }

    public void drawPolygon(float[] vertices, float red, float green, float blue) {
        if (vertices.length % 2 != 0) {
            throw new IllegalArgumentException("Ungültige Anzahl von Koordinaten");
        }

        glBegin(GL_LINE_LOOP);
        glColor3f(red, green, blue);
        for (int i = 0; i < vertices.length; i += 2) {
            float x = vertices[i];
            float y = vertices[i + 1];
            glVertex2f(x, y);
        }
        glEnd();
    }

    public void fillPolygon(float[] vertices, float red, float green, float blue) {
        if (vertices.length % 2 != 0) {
            throw new IllegalArgumentException("Ungültige Anzahl von Koordinaten");
        }

        glBegin(GL_POLYGON);
        glColor3f(red, green, blue);
        for (int i = 0; i < vertices.length; i += 2) {
            float x = vertices[i];
            float y = vertices[i + 1];
            glVertex2f(x, y);
        }
        glEnd();
    }
}
