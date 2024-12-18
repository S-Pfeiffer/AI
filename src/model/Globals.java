package model;

import gfx.GLGlobals;

public class Globals {

    public static final int MINIMUM_CREATURES = 50;

    public static final int INPUT_NEURONS = 7;
    public static final int HIDDEN_NEURONS = 30;
    public static final int OUTPUT_NEURONS = 5;
    public static final int CREATURE_MINIMUM_ENERGY = 25;
    public static final double CREATURE_SIZE = 6;
    public static final double FEELER_SIZE = 3;
    public static final double ENERGY_CONSUMPTION_PER_FRAME = 0.5d;

    public static final int MAP_SIZE = 50;
    public static final int MAP_LAND_RATIO = 90;

    public static final int TILE_SIZE = GLGlobals.SCREEN_HEIGHT / MAP_SIZE;
    public static final int TILE_TYPE_WATER = 0;
    public static final int TILE_TYPE_GROUND = 1;
    public static final int MAX_FOOD_ON_TILE = 100;

    public static float OFFSET = ((float) GLGlobals.SCREEN_WIDTH / 2) - ((float) (Globals.TILE_SIZE * Globals.MAP_SIZE) / 2);
    public static float MAX_SIZE = (float) Globals.MAP_SIZE * Globals.TILE_SIZE;
}
