import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;


static Map worldMap = new Map();
static double cx = 0;
static double cy = 0;

public static void main(String[] args) {

    GLHandler lwjglHandler = new GLHandler();
    lwjglHandler.init();
    lwjglHandler.createOpenGLCapabilities();

    GLRenderer renderer = new GLRenderer();
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    long window = lwjglHandler.getWindow();
    glfwSetWindowCloseCallback(window, (win) -> {
        glfwSetWindowShouldClose(win, true);
    });
    long lastTime = System.currentTimeMillis();
    while (!glfwWindowShouldClose(window)) {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastTime;

        if (elapsedTime >= GLGlobals.FRAME_TIME) {
            lastTime = currentTime;
            uiRenderer(renderer, window);
        }
        glfwPollEvents();
    }
    lwjglHandler.terminate();
}

public static void uiRenderer(GLRenderer renderer, long window) {
    for (int x = 0; x < Globals.MAP_SIZE; x++) {
        for (int y = 0; y < Globals.MAP_SIZE; y++) {
            double xx = GLTools.glMapX(x * Globals.TILE_SIZE);
            double yy = GLTools.glMapY(y * Globals.TILE_SIZE);
            if (worldMap.getTile(x, y) == 0) {
                renderer.fillRectangle(xx, yy, xx + Globals.TILE_SIZE, yy + Globals.TILE_SIZE, 0, 0, 1);
            } else {
                renderer.fillRectangle(xx, yy, xx + Globals.TILE_SIZE, yy + Globals.TILE_SIZE, 0, 1, 0);
            }
        }
    }
    //Kreatur zeichnen
    renderer.fillCircle(cx, cy, 0.02f, 100, 1, 1, 1);
    renderer.drawCircle(cx, cy, 0.02f, 100, 0, 0, 0);
    cx += Tool.rndDouble(-0.01f, 0.01f);
    cy += Tool.rndDouble(-0.01f, 0.01f);
    glfwSwapBuffers(window);
}



