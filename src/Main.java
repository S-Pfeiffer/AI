import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;


static Map worldMap = new Map();

static double cx = 0;
static double cy = 0;
static int health = 100;

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
                if (worldMap.getFood(x, y) < 99) {
                    worldMap.setFood(x, y, worldMap.getFood(x, y) + 0.1d);
                }
                if (worldMap.getFood(x, y) < 1) {
                    worldMap.setFood(x, y, 1);
                }

                renderer.fillRectangle(xx, yy, xx + Globals.TILE_SIZE, yy + Globals.TILE_SIZE, 0, worldMap.getFood(x, y) / 100, 0);
            }
        }
    }
    //Kreatur zeichnen
    cx += Tool.rndDouble(-0.01f, 0.01f);
    cy += Tool.rndDouble(-0.01f, 0.01f);

    if (cx < -0.8) {
        cx = -0.8;
    }
    if (cx > 0.8) {
        cx = 0.8;
    }
    if (cy < -0.8) {
        cy = -0.8;
    }
    if (cy > 0.8) {
        cy = 0.8;
    }


    int tileX = (int) Tool.mapTo(cx, -1, 1, 0, Globals.MAP_SIZE);
    int tileY = (int) Tool.mapTo(cy, -1, 1, 0, Globals.MAP_SIZE);
    int tileT = worldMap.getTile(tileX, tileY);

    if (tileT == 0) {
        health--;
        renderer.fillCircle(cx, cy, 0.02f, 4, 1, 1, 1);
    } else {
        if (worldMap.getFood(tileX, tileY) > 1) {
            health++;
        }
        renderer.fillCircle(cx, cy, 0.02f, 20, 1, 1, 1);
        worldMap.setFood(tileX, tileY, worldMap.getFood(tileX, tileY) - 1);
    }

    if (health <= 0) {
        cx += Tool.rndDouble(-0.8, 0.8);
        cy += Tool.rndDouble(-0.8, 0.8);
        health = 100;
        System.out.println("Respawn");
    }
    if (health >= 100) {
        health = 100;
    }

    glfwSwapBuffers(window);
}



