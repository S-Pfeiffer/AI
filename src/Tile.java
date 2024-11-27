public class Tile {
    private int type;
    private double foodValue;

    public Tile(int type, double foodValue) {
        this.type = type;
        this.foodValue = foodValue;
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
        this.foodValue = foodValue;
    }
}
