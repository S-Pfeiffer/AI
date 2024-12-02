package model;

import tools.Tool;

import java.util.List;

import static model.Globals.MAX_FOOD_ON_TILE;

public class Creature {

    private float xPos;
    private float yPos;

    private Network network = new Network(Globals.INPUT_NEURONS, Globals.HIDDEN_NEURONS, Globals.OUTPUT_NEURONS);

    // Inputs
    private double age;
    private double bias = 1.0;
    private double foodValuePosition = 0.0;
    private double foodValueFeeler = 0.0;
    private double energy;
    private double angle;
    private double speed;
    private int tileTypeFeeler;
    private int tileTypePosition;

    // Outputs
    private double birth;
    private double rotate;
    private double move;
    private double feelerAngle;
    private double eat;

    private double rVal;
    private double gVal;
    private double bVal;

    public Creature() {
    }

    public Creature(double x, double y) {
        this.xPos = (float) x;
        this.yPos = (float) y;
        this.energy = 100.0;
        this.rVal = Tool.rndDouble(0,1);
        this.gVal = Tool.rndDouble(0,1);
        this.bVal = Tool.rndDouble(0,1);
        this.age = 0;
    }

    public void updateInputs() {
        List<Neuron> inputNeurons = this.network.getInputs();

        /*
         inputNeurons.get(0).setValue(this.bias);
        inputNeurons.get(1).setValue(Tool.mapTo(this.foodValuePosition,0,MAX_FOOD_ON_TILE,-10,10));
        inputNeurons.get(2).setValue(Tool.mapTo(this.foodValueFeeler,0,MAX_FOOD_ON_TILE,-10,10));
        inputNeurons.get(3).setValue(Tool.mapTo(this.energy,25,200,-10,10));
        inputNeurons.get(4).setValue(Tool.mapTo(this.tileTypeFeeler,0,1,-10,10));
        inputNeurons.get(5).setValue(Tool.mapTo(this.tileTypePosition, 0, 1, -10, 10));
        inputNeurons.get(6).setValue(Tool.mapTo(this.age,0,10,-10,10));
         */
        inputNeurons.get(0).setValue(this.bias);
        inputNeurons.get(1).setValue(this.foodValuePosition);
        inputNeurons.get(2).setValue(this.foodValueFeeler);
        inputNeurons.get(3).setValue(this.energy);
        inputNeurons.get(4).setValue(this.tileTypeFeeler);
        inputNeurons.get(5).setValue(this.tileTypePosition);
        inputNeurons.get(6).setValue(this.age);
        this.network.feedForward();
    }

    public double getxPos() {
        return this.xPos;
    }

    public void setxPos(float xPos) {
        if (xPos < (float) Globals.TILE_SIZE) {
            xPos = (float) Globals.TILE_SIZE;
        }
        if (xPos > Globals.MAX_SIZE - (float) Globals.TILE_SIZE) {
            xPos = Globals.MAX_SIZE - (float) Globals.TILE_SIZE;
        }

        this.xPos = xPos;
    }

    public double getyPos() {
        return this.yPos;
    }

    public void setyPos(float yPos) {
        if (yPos < (float) Globals.TILE_SIZE) {
            yPos = (float) Globals.TILE_SIZE;
        }
        if (yPos > Globals.MAX_SIZE - (float) Globals.TILE_SIZE) {
            yPos = Globals.MAX_SIZE - (float) Globals.TILE_SIZE;
        }
        this.yPos = yPos;
    }

    public Network getNetwork() {
        return this.network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public double getFoodValuePosition() {
        return foodValuePosition;
    }

    public void setFoodValuePosition(double foodValuePosition) {
        this.foodValuePosition = foodValuePosition;
    }

    public double getFoodValueFeeler() {
        return foodValueFeeler;
    }

    public void setFoodValueFeeler(double foodValueFeeler) {
        this.foodValueFeeler = foodValueFeeler;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        if (this.energy > MAX_FOOD_ON_TILE * 2) {
            this.energy = MAX_FOOD_ON_TILE * 2;
        } else {
            this.energy = energy;
        }
    }

    public int getTileTypeFeeler() {
        return tileTypeFeeler;
    }

    public void setTileTypeFeeler(int tileTypeFeeler) {
        this.tileTypeFeeler = tileTypeFeeler;
    }

    public int getTileTypePosition() {
        return tileTypePosition;
    }

    public void setTileTypePosition(int tileTypePosition) {
        this.tileTypePosition = tileTypePosition;
    }

    public double getBirth() {
        return birth;
    }

    public void setBirth(double birth) {
        this.birth = birth;
    }

    public double getRotate() {
        return rotate;
    }

    public void setRotate(double rotate) {
        this.rotate = rotate;
    }

    public double getMove() {
        return move;
    }

    public void setMove(double move) {
        this.move = move;
    }

    public double getFeelerAngle() {
        return feelerAngle;
    }

    public void setFeelerAngle(double feelerAngle) {
        this.feelerAngle = feelerAngle;
    }

    public double getEat() {
        return eat;
    }

    public void setEat(double eat) {
        this.eat = eat;
    }

    public double getrVal() {
        return rVal;
    }

    public void setrVal(double rVal) {
        this.rVal = rVal;
    }

    public double getgVal() {
        return gVal;
    }

    public void setgVal(double gVal) {
        this.gVal = gVal;
    }

    public double getbVal() {
        return bVal;
    }

    public void setbVal(double bVal) {
        this.bVal = bVal;
    }
}
