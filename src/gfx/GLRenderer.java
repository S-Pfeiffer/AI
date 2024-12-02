package gfx;
import static org.lwjgl.opengl.GL11.*;
import java.nio.ByteBuffer;

public class GLRenderer {

    public void setPixel(double x, double y, double red, double green, double blue) {
        glBegin(GL_POINTS);
        glColor3d(red, green, blue);
        glVertex2d(x, y);
        glEnd();
    }

    public void drawRectangle(double x1, double y1, double x2, double y2, double red, double green, double blue) {
        glBegin(GL_LINE_LOOP);
        glColor3d(red, green, blue);
        glVertex2d(x1, y1); // unten links
        glVertex2d(x2, y1); // unten rechts
        glVertex2d(x2, y2); // oben rechts
        glVertex2d(x1, y2); // oben links
        glEnd();
    }

    public void fillRectangle(double x1, double y1, double x2, double y2, double red, double green, double blue) {
        glBegin(GL_QUADS);
        glColor3d(red, green, blue);
        glVertex2d(x1, y1); // unten links
        glVertex2d(x2, y1); // unten rechts
        glVertex2d(x2, y2); // oben rechts
        glVertex2d(x1, y2); // oben links
        glEnd();
    }

    public void drawLine(double x1, double y1, double x2, double y2, double red, double green, double blue) {
        glBegin(GL_LINES);
        glColor3d(red, green, blue);
        glVertex2d(x1, y1);
        glVertex2d(x2, y2);
        glEnd();
    }

    public void drawTriangle(double x1, double y1, double x2, double y2, double x3, double y3, double red, double green, double blue) {
        glBegin(GL_LINE_LOOP);
        glColor3d(red, green, blue);
        glVertex2d(x1, y1); // erster Punkt
        glVertex2d(x2, y2); // zweiter Punkt
        glVertex2d(x3, y3); // dritter Punkt
        glEnd();
    }

    public void fillTriangle(double x1, double y1, double x2, double y2, double x3, double y3, double red, double green, double blue) {
        glBegin(GL_TRIANGLES);
        glColor3d(red, green, blue);
        glVertex2d(x1, y1); // erster Punkt
        glVertex2d(x2, y2); // zweiter Punkt
        glVertex2d(x3, y3); // dritter Punkt
        glEnd();
    }

    public void drawCircle(double cx, double cy, double radius, int segments, double red, double green, double blue) {
        glBegin(GL_LINE_LOOP);
        glColor3d(red, green, blue);
        for (int i = 0; i <= segments; i++) {
            double angle = 2 * Math.PI * i / segments;
            double x = cx + Math.cos(angle) * radius;
            double y = cy + Math.sin(angle) * radius;
            glVertex2d(x, y);
        }
        glEnd();
    }

    public void fillCircle(double cx, double cy, double radius, int segments, double red, double green, double blue) {
        glBegin(GL_TRIANGLE_FAN);
        glColor3d(red, green, blue);
        glVertex2d(cx, cy); // Mittelpunkt
        for (int i = 0; i <= segments; i++) {
            double angle = 2 * Math.PI * i / segments;
            double x = cx + Math.cos(angle) * radius;
            double y = cy + Math.sin(angle) * radius;
            glVertex2d(x, y);
        }
        glEnd();
    }

    public void drawPolygon(double[] vertices, double red, double green, double blue) {
        if (vertices.length % 2 != 0) {
            throw new IllegalArgumentException("Ungültige Anzahl von Koordinaten");
        }

        glBegin(GL_LINE_LOOP);
        glColor3d(red, green, blue);
        for (int i = 0; i < vertices.length; i += 2) {
            double x = vertices[i];
            double y = vertices[i + 1];
            glVertex2d(x, y);
        }
        glEnd();
    }

    public void fillPolygon(double[] vertices, double red, double green, double blue) {
        if (vertices.length % 2 != 0) {
            throw new IllegalArgumentException("Ungültige Anzahl von Koordinaten!");
        }

        glBegin(GL_POLYGON);
        glColor3d(red, green, blue);
        for (int i = 0; i < vertices.length; i += 2) {
            double x = vertices[i];
            double y = vertices[i + 1];
            glVertex2d(x, y);
        }
        glEnd();
    }

    public double[] getPixelColor(int x, int y) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(3); // 3 Bytes für RGB
        glReadPixels(x, y, 1, 1, GL_RGB, GL_UNSIGNED_BYTE, buffer);

        // Farbwerte extrahieren und normalisieren (0-255 zu 0.0-1.0)
        double red = (buffer.get(0) & 0xFF) / 255.0;
        double green = (buffer.get(1) & 0xFF) / 255.0;
        double blue = (buffer.get(2) & 0xFF) / 255.0;

        return new double[]{red, green, blue};
    }

    public void drawLineWithAngle(double x1, double y1, double angle, double length, double red, double green, double blue) {
        double adjustedAngle = Math.toRadians(angle + 90);
        double x2 = x1 + Math.cos(adjustedAngle) * length;
        double y2 = y1 + Math.sin(adjustedAngle) * length;
        drawLine(x1, y1, x2, y2, 1, green, blue);
    }
}
