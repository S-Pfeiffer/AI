package model;

import gfx.GLGlobals;
import gfx.GLRenderer;
import tools.Tool;

public class Map {

    private Tile[][] map = new Tile[Globals.MAP_SIZE][Globals.MAP_SIZE];

    public Map() {
        initMap(Globals.MAP_SIZE);
    }

    private void initMap(int size) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (Tool.rndDouble(0, 100) > Globals.MAP_LAND_RATIO) {
                    this.map[x][y] = new Tile(Globals.TILE_TYPE_WATER);
                } else {
                    this.map[x][y] = new Tile(Globals.TILE_TYPE_GROUND);
                }
            }
        }
    }

    public int getTileType(int x, int y) {
        return map[x][y].getType();
    }

    public double getTileFood(int x, int y) {
        return map[x][y].getFoodValue();
    }

    public void setTileFood(int x, int y, double food) {
        map[x][y].setFoodValue(food);
    }

    public void setTileType(int x, int y, int type) {
        map[x][y].setType(type);
    }

    public void draw(GLRenderer renderer) {
        for (int y = 0; y < Globals.MAP_SIZE; y++) {
            for (int x = 0; x < Globals.MAP_SIZE; x++) {
                double x1 = x * Globals.TILE_SIZE;
                double x2 = x * Globals.TILE_SIZE + Globals.TILE_SIZE;
                double y1 = y * Globals.TILE_SIZE;
                double y2 = y * Globals.TILE_SIZE + Globals.TILE_SIZE;
                x1 += (GLGlobals.SCREEN_WIDTH / 2) - (Globals.TILE_SIZE * Globals.MAP_SIZE / 2);
                x2 += (GLGlobals.SCREEN_WIDTH / 2) - (Globals.TILE_SIZE * Globals.MAP_SIZE / 2);

                if (this.getTileType(x, y) == Globals.TILE_TYPE_WATER) {
                    renderer.fillRectangle(x1, y1, x2, y2, 0, 0, 1);
                } else {
                    map[x][y].setFoodValue(map[x][y].getFoodValue() + 0.1d);
                    double g = Tool.mapTo(map[x][y].getFoodValue(), 100, 0, 1, .4);
                    double rb = Tool.mapTo(map[x][y].getFoodValue(), 100, 0, .3, .4);
                    renderer.fillRectangle(x1, y1, x2, y2, rb, g, rb );
                }
            }
        }
    }

}