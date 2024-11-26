import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class Main {
    public static void main(String[] args) {
        GLHandler lwjglHandler = new GLHandler();
        lwjglHandler.init();
        lwjglHandler.createOpenGLCapabilities();

        GLRenderer renderer = new GLRenderer();

        long window = lwjglHandler.getWindow();

        glfwSetWindowCloseCallback(window, (win) -> {
            glfwSetWindowShouldClose(win, true);
        });

        long lastTime = System.currentTimeMillis();

        while (!glfwWindowShouldClose(window)) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - lastTime;
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            if (elapsedTime >= GLGlobals.FRAME_TIME) {
                lastTime = currentTime;
                gameRenderer();
            }

            glfwSwapBuffers(window);
            glfwPollEvents();
        }

        lwjglHandler.terminate();
    }

    public static void gameRenderer() {

    }
}



