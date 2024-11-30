public class Globals {

    public static final int MINIMUM_CREATURES = 1;

    public static final int INPUT_NEURONS = 7;
    public static final int HIDDEN_NEURONS = 21;
    public static final int OUTPUT_NEURONS = 5;
    public static final int CREATURE_MINIMUM_ENERGY = 25;

    public static final int MAP_SIZE = 20;
    public static final int MAP_LAND_RATIO = 40;

    public static final int TILE_SIZE = GLGlobals.SCREEN_HEIGHT / MAP_SIZE;
    public static final int TILE_TYPE_WATER = 0;
    public static final int TILE_TYPE_GROUND = 1;
    public static final int MAX_FOOD_ON_TILE = 100;

    public static float OFFSET = ((float) GLGlobals.SCREEN_WIDTH / 2) - ((float) (Globals.TILE_SIZE * Globals.MAP_SIZE) / 2);
    public static float MAX_SIZE = (float) Globals.MAP_SIZE * Globals.TILE_SIZE;
}
