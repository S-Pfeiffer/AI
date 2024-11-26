import org.lwjgl.*;
import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class GLHandler {
    private long window;

    /**
     * Initialisiert GLFW und erstellt ein Fenster.
     */
    public void init() {
        if (!glfwInit()) {
            throw new IllegalStateException("GLFW konnte nicht initialisiert werden");
        }

        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        window = glfwCreateWindow(800, 600, "LWJGL Test", NULL, NULL);

        if (window == NULL) {
            throw new RuntimeException("Fenster konnte nicht erstellt werden");
        }

        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        glfwShowWindow(window);
    }

    /**
     * Erstellt OpenGL-Kapazitäten.
     */
    public void createOpenGLCapabilities() {
        GL.createCapabilities();
    }

    /**
     * Gibt die Fenster-ID zurück.
     *
     * @return Die Fenster-ID (long).
     */
    public long getWindow() {
        return window;
    }

    /**
     * Beendet GLFW und gibt Ressourcen frei.
     */
    public void terminate() {
        glfwTerminate();
    }
}
