import static org.lwjgl.opengl.GL11.*;

public class GLRenderer {

    public void setPixel(float x, float y, float red, float green, float blue) {
        glBegin(GL_POINTS);
        glColor3f(red, green, blue);
        glVertex2f(x, y);
        glEnd();
    }

    public void drawRectangle(float x1, float y1, float x2, float y2, float red, float green, float blue) {
        glBegin(GL_QUADS);
        glColor3f(red, green, blue);
        glVertex2f(x1, y1);
        glVertex2f(x2, y1);
        glVertex2f(x2, y2);
        glVertex2f(x1, y2);
        glEnd();
    }

    public void drawLine(float x1, float y1, float x2, float y2, float red, float green, float blue) {
        glBegin(GL_LINES);
        glColor3f(red, green, blue);
        glVertex2f(x1, y1);
        glVertex2f(x2, y2);
        glEnd();
    }
}
