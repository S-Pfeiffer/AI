public class CreatureRenderer {

    public void draw(GLRenderer renderer, Map worldMap, double positionX, double positionY) {
        int gridX = (int) (positionX / Globals.TILE_SIZE);
        int gridY = (int) (positionY / Globals.TILE_SIZE);

        double offsetX = ((double) GLGlobals.SCREEN_WIDTH / 2) - ((double) (Globals.TILE_SIZE * Globals.MAP_SIZE) / 2);

        positionX = offsetX + positionX;

        renderer.fillCircle(positionX, positionY, 10, 10, 1, 1, 1);

    }
}
