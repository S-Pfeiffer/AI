public class Map {

    private static int size;
    private static int[][] tileMap;

    private void initMap(int size) {
        this.tileMap = new int[size][size];
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

    public static int[][] getTileMap() {
        return tileMap;
    }

    public static void setTileMap(int[][] tileMap) {
        Map.tileMap = tileMap;
    }
}
