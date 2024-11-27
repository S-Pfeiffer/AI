public class Tile {
    private String type;
    private double foodValue;

    public Tile(String type, double foodValue) {
        this.type = type;
        this.foodValue = foodValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getFoodValue() {
        return foodValue;
    }

    public void setFoodValue(double foodValue) {
        this.foodValue = foodValue;
    }
}
