public class Tile {

    public static int getType() {
        return type;
    }

    public static void setType(int type) {
        Tile.type = type;
    }

    public static int getFoodValue() {
        return foodValue;
    }

    public static void setFoodValue(int foodValue) {
        Tile.foodValue = foodValue;
    }

    private static int type;
    private static int foodValue;

    public Tile(int type, int foodValue) {
        this.type = type;
        this.foodValue = foodValue;
    }
}
