import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

Map worldMap = new Map();
CreatureRenderer creatureRenderer = new CreatureRenderer();
List<Creature> creatures = new ArrayList<>();

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

    int n =500;
    for (int i = 0; i < n; i++) {
        creatures.add(new Creature());
    }

    for (Creature creature : creatures) {
        creature.setxPos(500);
        creature.setyPos(500);
    }

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

    worldMap.draw(renderer);
    for (Creature creature : creatures) {
        creature.setxPos(creature.getxPos() + Tool.rndDouble(-4, 4));
        creature.setyPos(creature.getyPos() + Tool.rndDouble(-4, 4));
        creatureRenderer.draw(renderer, worldMap, creature);
    }

    glfwSwapBuffers(window);
}



