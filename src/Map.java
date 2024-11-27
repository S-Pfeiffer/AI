public class Map {

    private static int size;
    private static Tile[][] tileMap;

    private void initMap(int size) {
        this.tileMap = new Tile[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tileMap[i][j] = new Tile(0, Globals.MAX_FOOD_ON_TILE);
            }
        }
    }

    public Map() {
        this.size = Globals.MAP_SIZE;
        initMap(this.size);
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        Map.size = size;
    }

    public static Tile[][] getTileMap() {
        return tileMap;
    }

    public static void setTileMap(Tile[][] tileMap) {
        Map.tileMap = tileMap;
    }
}
