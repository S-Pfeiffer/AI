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

    public void setTile(int x, int y, Tile tile) {
        tileMap[x][y] = tile;
    }

    public Tile getTile(int x, int y) {
        return tileMap[x][y];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        Map.size = size;
    }

    public Tile[][] getTileMap() {
        return tileMap;
    }

    public void setTileMap(Tile[][] tileMap) {
        Map.tileMap = tileMap;
    }
}
