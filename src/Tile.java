public class Tile {
    private int type;
    private double foodValue;

    public Tile(int type) {
        this.type = type;
        if (type == Globals.TILE_TYPE_GROUND) {
            this.foodValue = 100.0d;
        } else {
            this.foodValue = -1.0d;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getFoodValue() {
        return foodValue;
    }

    public void setFoodValue(double foodValue) {
        if (type == Globals.TILE_TYPE_GROUND) {
            this.foodValue = foodValue;
        } else {
            this.foodValue = -1.0d;
        }
    }
}
