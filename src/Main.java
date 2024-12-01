import gfx.CreatureRenderer;
import gfx.GLHandler;
import gfx.GLRenderer;
import model.Creature;
import model.Globals;
import model.Map;

import static gfx.GLGlobals.*;
import static model.Globals.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static tools.Tool.rndDouble;

model.Map worldMap = new Map();
CreatureRenderer creatureRenderer = new CreatureRenderer();
List<Creature> creatures = new ArrayList<>();

public void main(String[] args) {

    GLHandler handler = new GLHandler();
    handler.init();
    handler.createOpenGLCapabilities();
    glOrtho(0, SCREEN_WIDTH, 0, SCREEN_HEIGHT, -1, 1);

    GLRenderer renderer = new GLRenderer();
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    long window = handler.getWindow();
    glfwSetWindowCloseCallback(window, (win) -> {
        glfwSetWindowShouldClose(win, true);
    });
    long lastTime = System.currentTimeMillis();

    for (int i = 0; i < MINIMUM_CREATURES; i++) {
        creatures.add(new Creature());
    }
    for (Creature creature : creatures) {
        creature.setxPos(500);
        creature.setyPos(500);
        creature.setEnergy(100);
    }

    uiRenderer(window, renderer);

    while (!glfwWindowShouldClose(window)) {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastTime;

        if (elapsedTime >= FRAME_TIME) {
            lastTime = currentTime;
            uiRenderer(window, renderer);
        }
        glfwPollEvents();
    }
    handler.terminate();
}

public void uiRenderer(long window, GLRenderer renderer) {

    worldMap.draw(renderer);

    for (Creature creature : creatures) {
        creature.setxPos((float) (creature.getxPos() + rndDouble(-4, 4)));
        creature.setyPos((float) (creature.getyPos() + rndDouble(-4, 4)));
        creature.setEnergy(creature.getEnergy() - 0.50f);
        creatureRenderer.draw(renderer, worldMap, creature);
    }

    creatures.removeIf(creature -> creature.getEnergy() < Globals.CREATURE_MINIMUM_ENERGY);

    if (creatures.size() < MINIMUM_CREATURES) {
        creatures.addLast(new Creature());
        creatures.getLast().setxPos(rndDouble(TILE_SIZE , MAX_SIZE - TILE_SIZE ));
        creatures.getLast().setyPos(rndDouble(TILE_SIZE , MAX_SIZE - TILE_SIZE ));
        creatures.getLast().setEnergy(100);
    }

    glfwSwapBuffers(window);
}



