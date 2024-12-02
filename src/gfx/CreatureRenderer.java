package gfx;

import model.Creature;
import model.Globals;
import model.Map;
import tools.Tool;

import static model.Globals.CREATURE_SIZE;
import static model.Globals.OFFSET;

public class CreatureRenderer {

    int gridX;
    int gridY;
    double positionX;
    double positionY;

    public void draw(GLRenderer renderer, Map worldMap, Creature creature) {

        this.positionX = creature.getxPos();
        this.positionY = creature.getyPos();

        gridX = (int) (this.positionX / Globals.TILE_SIZE);
        gridY = (int) (this.positionY / Globals.TILE_SIZE);
        int tileType = worldMap.getTileType(this.gridX, this.gridY);

        if (tileType == Globals.TILE_TYPE_GROUND) {
            if (worldMap.getTileFood(this.gridX, this.gridY) > 2) {
                creature.setEnergy(creature.getEnergy() + 1.0d);
                worldMap.setTileFood(this.gridX, this.gridY, worldMap.getTileFood(this.gridX, this.gridY) - 1.0d);
            }
        }

        creature.setFoodValuePosition(worldMap.getTileFood(this.gridX, this.gridY));
        creature.setAge(creature.getAge() + 1);
        creature.setTileTypePosition(worldMap.getTileType(this.gridX, this.gridY));
        creature.updateInputs();

        double an = Tool.mapTo(creature.getNetwork().getOutputs().get(3).getValue(),-1,1,0,360);

        renderer.drawLineWithAngle(this.positionX + OFFSET,
                this.positionY,
                an, CREATURE_SIZE * 3, 1, 1, 1);

        renderer.fillCircle(this.positionX + OFFSET,
                this.positionY,
                CREATURE_SIZE, 10, creature.getrVal(), creature.getgVal(), creature.getbVal());

        renderer.drawCircle(this.positionX + OFFSET,
                this.positionY,
                CREATURE_SIZE, 10, 0, 0, 0);

    }
}
