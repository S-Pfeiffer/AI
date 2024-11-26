import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Main {
    public static void main(String[] args) {
        // Initialisieren von LWJGLHandler
        GLHandler lwjglHandler = new GLHandler();
        lwjglHandler.init();
        lwjglHandler.createOpenGLCapabilities();

        // Initialisieren von SimpleRenderer
        GLRenderer renderer = new GLRenderer();

        long window = lwjglHandler.getWindow();

        // Render-Schleife
        while (!glfwWindowShouldClose(window)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            // Pixel setzen
            renderer.setPixel(0.0f, 0.0f, 1.0f, 0.0f, 0.0f); // Roter Pixel in der Mitte

            // Rechteck zeichnen
            renderer.drawRectangle(-0.5f, -0.5f, 0.5f, 0.5f, 0.0f, 1.0f, 0.0f); // Grünes Rechteck

            // Linie zeichnen
            renderer.drawLine(-0.5f, 0.5f, 0.5f, -0.5f, 0.0f, 0.0f, 1.0f); // Blaue Linie

            glfwSwapBuffers(window);
            glfwPollEvents();
        }

        lwjglHandler.terminate();
    }
}
