import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

Map worldMap = new Map();
CreatureRenderer creatureRenderer = new CreatureRenderer();
List<Creature> creatures = new ArrayList<>();
Creature cr = new Creature();
Creature cr2 = new Creature();

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

    cr.setxPos(500);
    cr.setyPos(500);

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

    cr.setxPos(cr.getxPos() + Tool.rndDouble(-4, 4));
    cr.setyPos(cr.getyPos() + Tool.rndDouble(-4, 4));
    cr2.setxPos(cr.getxPos() + Tool.rndDouble(-4, 4));
    cr2.setyPos(cr.getyPos() + Tool.rndDouble(-4, 4));

    worldMap.draw(renderer);
    creatureRenderer.draw(renderer, worldMap, cr);
    creatureRenderer.draw(renderer, worldMap, cr2);

    glfwSwapBuffers(window);
}



