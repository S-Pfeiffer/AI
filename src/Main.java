import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;


public class Main {
    static Map worldMap = new Map();

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
                gameRenderer(renderer);
            }

            glfwSwapBuffers(window);
            glfwPollEvents();
        }

        lwjglHandler.terminate();
    }

    public static void gameRenderer(GLRenderer renderer) {
        for (int x = 0; x < Globals.MAP_SIZE; x++) {
            for (int y = 0; y < Globals.MAP_SIZE; y++) {
                double xx = GLTools.glMapX(x * Globals.TILE_SIZE);
                double yy = GLTools.glMapY(y * Globals.TILE_SIZE);
                if (worldMap.getTile(x, y) == 0) {
                    renderer.fillRectangle((float)xx, (float)yy, (float)xx + Globals.TILE_SIZE, (float)yy + Globals.TILE_SIZE, 0, 0, 1);
                } else {
                    renderer.fillRectangle((float)xx, (float)yy, (float)xx + Globals.TILE_SIZE, (float)yy + Globals.TILE_SIZE, 0, 1, 0);
                }
            }
        }
    }
}



