public class CreatureRenderer {

    public void draw(GLRenderer renderer, Map worldMap, Creature creature) {

        double positionX = creature.getxPos();
        double positionY = creature.getyPos();

        int gridX = (int) (positionX / Globals.TILE_SIZE);
        int gridY = (int) (positionY / Globals.TILE_SIZE);

        double offsetX = ((double) GLGlobals.SCREEN_WIDTH / 2) - ((double) (Globals.TILE_SIZE * Globals.MAP_SIZE) / 2);

        renderer.fillCircle(positionX + offsetX, positionY, 10, 10, 1, 1, 1);

    }
}
