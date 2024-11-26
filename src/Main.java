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

        while (!glfwWindowShouldClose(window)) {
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

            for (int i = 100; i < 200; i++) {
                for (int j = 200; j < 300; j++) {
                    float x = GLTools.glMapX(i);
                    float y = GLTools.glMapY(j);
                    renderer.setPixel(x, y, 1.0f, 1.0f, 1.0f);
                }
            }
            glfwSwapBuffers(window);
            glfwPollEvents();
        }
        lwjglHandler.terminate();
    }
}
