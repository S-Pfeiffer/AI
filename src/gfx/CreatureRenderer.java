package gfx;

import model.Creature;
import model.Globals;
import model.Map;
import tools.Tool;

import static model.Globals.*;

public class CreatureRenderer {

    int gridX;
    int gridY;
    int feelerGridX;
    int feelerGridY;
    double positionX;
    double positionY;

    public void draw(GLRenderer renderer, Map worldMap, Creature creature) {

        this.positionX = creature.getxPos();
        this.positionY = creature.getyPos();

        this.gridX = (int) (this.positionX / Globals.TILE_SIZE);
        this.gridY = (int) (this.positionY / Globals.TILE_SIZE);
        int tileType = worldMap.getTileType(this.gridX, this.gridY);

        if (tileType == Globals.TILE_TYPE_GROUND) {
            if (worldMap.getTileFood(this.gridX, this.gridY) > 2) {
                creature.setEnergy(creature.getEnergy() + 1.0d);
                worldMap.setTileFood(this.gridX, this.gridY, worldMap.getTileFood(this.gridX, this.gridY) - 0.5d);
            }
        }

        creature.setFoodValuePosition(worldMap.getTileFood(this.gridX, this.gridY));
        creature.setAge(creature.getAge() + .01);
        creature.setTileTypePosition(worldMap.getTileType(this.gridX, this.gridY));

        double[] point = GLTools.getPointByAngle(creature.getxPos(), creature.getyPos(), creature.getFeelerAngle(), CREATURE_SIZE * FEELER_SIZE);
        this.feelerGridX = (int) (point[0] / Globals.TILE_SIZE);
        this.feelerGridY = (int) (point[1] / Globals.TILE_SIZE);
        creature.setTileTypeFeeler(worldMap.getTileType(this.feelerGridX, this.feelerGridY));
        creature.setFoodValueFeeler(worldMap.getTileFood(this.feelerGridX, this.feelerGridY));
        creature.setAngle(Tool.mapTo(creature.getNetwork().getOutputs().get(0).getValue(), -1, 1, 0, 360));
        creature.setSpeed(creature.getNetwork().getOutputs().get(1).getValue());

        creature.updateInputs();
        creature.move();

        if (creature.getxPos() < TILE_SIZE) {
            creature.setxPos(TILE_SIZE);
        }
        if (creature.getxPos() > (MAP_SIZE * TILE_SIZE) - TILE_SIZE) {
            creature.setxPos((MAP_SIZE * TILE_SIZE) - TILE_SIZE);
        }
        if (creature.getyPos() < TILE_SIZE) {
            creature.setyPos(TILE_SIZE);
        }
        if (creature.getyPos() > (MAP_SIZE * TILE_SIZE) - TILE_SIZE) {
            creature.setyPos((MAP_SIZE * TILE_SIZE) - TILE_SIZE);
        }

        double an = Tool.mapTo(creature.getNetwork().getOutputs().get(3).getValue(), -1, 1, 0, 360);
        creature.setFeelerAngle(an);

        renderer.drawLineWithAngle(this.positionX + OFFSET,
                this.positionY,
                an, CREATURE_SIZE * FEELER_SIZE, 1, 1, 1);

        renderer.fillCircle(point[0] + OFFSET, point[1], 3, 5, 1, 1, 1);

        renderer.fillCircle(this.positionX + OFFSET,
                this.positionY,
                CREATURE_SIZE, 10, creature.getrVal(), creature.getgVal(), creature.getbVal());

        renderer.drawCircle(this.positionX + OFFSET,
                this.positionY,
                CREATURE_SIZE, 10, 0, 0, 0);
    }
}
