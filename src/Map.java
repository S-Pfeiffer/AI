public class Map {

    private Tile[][] map = new Tile[Globals.MAP_SIZE][Globals.MAP_SIZE];

    public Map() {
        initMap(Globals.MAP_SIZE);
    }

    private void initMap(int size) {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                this.map[x][y] = new Tile(Globals.TILE_TYPE_WATER);
            }
        }
    }

}