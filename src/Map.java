public class Map {

    private static int size;
    private static int[][] tileMap;
    private static float[][] foodMap;

    public Map() {
        size = Globals.MAP_SIZE;
        initMap(size);
    }

    public static int[][] getTileMap() {
        return tileMap;
    }

    public static void setTileMap(int[][] tileMap) {
        Map.tileMap = tileMap;
    }

    private void initMap(int size) {
        tileMap = new int[size][size];
        foodMap = new float[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (Tool.rndDouble(0f, 100f) < (float) Globals.MAP_LAND_RATIO) {
                    tileMap[i][j] = 0;
                    foodMap[i][j] = 0;
                } else {
                    tileMap[i][j] = 1;
                    foodMap[i][j] = Globals.MAX_FOOD_ON_TILE;
                }
            }
        }
    }

    public void setTile(int x, int y, int type) {
        tileMap[x][y] = type;
    }

    public int getTile(int x, int y) {
        return tileMap[x][y];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        Map.size = size;
    }

    public void setTileMap(int x, int y, int tile) {
        tileMap[x][y] = tile;
    }
}
