package model;

public class Tile {
    private int type;
    private Double foodValue;

    public Tile(int type) {
        this.type = type;
        if (type == Globals.TILE_TYPE_GROUND) {
            this.foodValue = (double) Globals.MAX_FOOD_ON_TILE;
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

    public Double getFoodValue() {
        return foodValue;
    }

    public void setFoodValue(double foodValue) {
        if (type == Globals.TILE_TYPE_GROUND) {
            if (foodValue > 1 && foodValue < Globals.MAX_FOOD_ON_TILE) {
                this.foodValue = foodValue;
            }
        } else {
            this.foodValue = -100.0d;
        }
    }
}
