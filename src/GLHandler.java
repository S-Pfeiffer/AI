import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.NULL;

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
        window = glfwCreateWindow(GLGlobals.SCREEN_WIDTH, GLGlobals.SCREEN_HEIGHT, "KI", NULL, NULL);

        if (window == NULL) {
            throw new RuntimeException("Fenster konnte nicht erstellt werden");
        }

        glfwMaximizeWindow(window);

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
