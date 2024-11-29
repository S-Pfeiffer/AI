import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

Map worldMap = new Map();

public void main(String[] args) {

    GLHandler lwjglHandler = new GLHandler();
    lwjglHandler.init();
    lwjglHandler.createOpenGLCapabilities();
    glOrtho(0, GLGlobals.SCREEN_WIDTH, 0, GLGlobals.SCREEN_HEIGHT, -1, 1);


    GLRenderer renderer = new GLRenderer();
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    long window = lwjglHandler.getWindow();
    glfwSetWindowCloseCallback(window, (win) -> {
        glfwSetWindowShouldClose(win, true);
    });
    long lastTime = System.currentTimeMillis();

    uiRenderer(window, renderer);

    while (!glfwWindowShouldClose(window)) {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastTime;

        if (elapsedTime >= GLGlobals.FRAME_TIME) {
            lastTime = currentTime;
            uiRenderer(window, renderer);
        }
        glfwPollEvents();
    }
    lwjglHandler.terminate();
}

public void uiRenderer(long window, GLRenderer renderer) {
    for (int y = 0; y < Globals.MAP_SIZE; y++) {
        for (int x = 0; x < Globals.MAP_SIZE; x++) {
            double x1 = x * Globals.TILE_SIZE;
            double x2 = x * Globals.TILE_SIZE + Globals.TILE_SIZE;
            double y1 = y * Globals.TILE_SIZE;
            double y2 = y * Globals.TILE_SIZE + Globals.TILE_SIZE;
            x1 += (GLGlobals.SCREEN_WIDTH / 2) - (Globals.TILE_SIZE * Globals.MAP_SIZE / 2);
            x2 += (GLGlobals.SCREEN_WIDTH / 2) - (Globals.TILE_SIZE * Globals.MAP_SIZE / 2);


            if (worldMap.getTileType(x, y) == Globals.TILE_TYPE_WATER) {
                renderer.fillRectangle(x1, y1, x2, y2, 0, 0, 1);
            } else {
                renderer.fillRectangle(x1, y1, x2, y2, 0, 1, 0);
            }

        }
    }
    glfwSwapBuffers(window);
}



