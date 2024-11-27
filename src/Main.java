import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

static Map worldMap = new Map();

public void main(String[] args) {

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
            uiRenderer(window);
        }

        glfwSwapBuffers(window);
        glfwPollEvents();
    }
    lwjglHandler.terminate();
}

public void uiRenderer(long window) {
    for (int y = 0; y < Globals.MAP_SIZE; y++) {
        for (int x = 0; x < Globals.MAP_SIZE; x++) {
            System.out.print(worldMap.getTileType(x, y));
        }
        System.out.println();
    }
    System.out.println();
}



