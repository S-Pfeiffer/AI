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

    glfwSwapBuffers(window);
}



