package gfx;

import org.lwjgl.glfw.GLFWVidMode;

import static org.lwjgl.glfw.GLFW.*;

public class GLGlobals {
    public static final int SCREEN_WIDTH;
    public static final int SCREEN_HEIGHT;

    public static final int TARGET_FPS = 20;
    public static long FRAME_TIME = 1000 / TARGET_FPS;

    static {
        if (!glfwInit()) {
            throw new IllegalStateException("GLFW konnte nicht initialisiert werden");
        }

        long primaryMonitor = glfwGetPrimaryMonitor();

        GLFWVidMode videoMode = glfwGetVideoMode(primaryMonitor);
        if (videoMode == null) {
            throw new RuntimeException("Konnte Videomodus nicht abrufen");
        }

        SCREEN_WIDTH = videoMode.width();
        SCREEN_HEIGHT = videoMode.height();

    }
}
