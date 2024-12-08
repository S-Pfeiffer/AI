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
List<Creature> toClone = new ArrayList<>();

double maxAge = 0;

public void main(String[] args) {
    GLHandler handler = new GLHandler();
    handler.init();
    handler.createOpenGLCapabilities();
    glOrtho(0, SCREEN_WIDTH, 0, SCREEN_HEIGHT, -1, 1);

    GLRenderer renderer = new GLRenderer();

    long window = handler.getWindow();
    glfwSetWindowCloseCallback(window, (win) -> {
        glfwSetWindowShouldClose(win, true);
    });
    long lastTime = System.currentTimeMillis();

    for (int i = 0; i < MINIMUM_CREATURES; i++) {
        creatures.add(new Creature(rndDouble(TILE_SIZE, MAX_SIZE - TILE_SIZE), rndDouble(TILE_SIZE, MAX_SIZE - TILE_SIZE)));
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

    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    worldMap.draw(renderer);

    for (Creature creature : creatures) {
        creature.setEnergy(creature.getEnergy() - ENERGY_CONSUMPTION_PER_FRAME);
        creatureRenderer.draw(renderer, worldMap, creature);
        if (creature.getEnergy() > 150) {
            toClone.add(new Creature(creature).clone());
            creature.setEnergy(70);
        }
    }

    //creatures.addAll(toClone);
    toClone.clear();

    creatures.removeIf(creature -> creature.getEnergy() < Globals.CREATURE_MINIMUM_ENERGY);

    while (creatures.size() < MINIMUM_CREATURES) {
        creatures.addLast(new Creature(rndDouble(TILE_SIZE, MAX_SIZE - TILE_SIZE), rndDouble(TILE_SIZE, MAX_SIZE - TILE_SIZE)));
    }

    glfwSwapBuffers(window);
}



