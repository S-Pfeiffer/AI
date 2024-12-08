package model;

import tools.Tool;

import java.util.List;

public class Creature implements Cloneable {

    private float xPos;
    private float yPos;

    private Network network = new Network(Globals.INPUT_NEURONS, Globals.HIDDEN_NEURONS, Globals.OUTPUT_NEURONS);

    // Inputs
    private double age;
    private double bias = 1.0;
    private double foodValuePosition = 0.0;
    private double foodValueFeeler = 0.0;
    private double energy;
    private double angle = Tool.rndDouble(0, 360);
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

    public Creature(Creature creature) {
        this.network = creature.network.clone();

        this.xPos = creature.xPos;
        this.yPos = creature.yPos;
        this.age = 0;
        this.bias = 1;
        this.energy = 100;
        this.angle = Tool.rndDouble(0, 360);
        this.feelerAngle = Tool.rndDouble(0, 360);

        this.rVal = creature.rVal;
        this.gVal = creature.gVal;
        this.bVal = creature.bVal;

        int inToHiddenConnections = Globals.INPUT_NEURONS * Globals.HIDDEN_NEURONS;
        int outToHiddenConnections = Globals.OUTPUT_NEURONS * Globals.HIDDEN_NEURONS;
        int connectionsToAlternate = 20;
        double alternateBounds = .5;
        int selectConnection;
        double selectedWeight;

        for (int i = 0; i < connectionsToAlternate; i++) {
            selectConnection = Tool.rndInt(0, inToHiddenConnections);
            selectedWeight = this.network.getFirstLayerConnections().get(selectConnection).getWeight();
            selectedWeight = selectedWeight + Tool.rndDouble(-alternateBounds, alternateBounds);
            this.network.getFirstLayerConnections().get(selectConnection).setWeight(selectedWeight);
        }

        for (int i = 0; i < connectionsToAlternate; i++) {
            selectConnection = Tool.rndInt(0, outToHiddenConnections);
            selectedWeight = this.network.getSecondLayerConnections().get(selectConnection).getWeight();
            selectedWeight = selectedWeight + Tool.rndDouble(-alternateBounds, alternateBounds);
            this.network.getSecondLayerConnections().get(selectConnection).setWeight(selectedWeight);
        }
    }

    public Creature(double x, double y) {
        this.xPos = (float) x;
        this.yPos = (float) y;
        this.energy = 100.0;
        this.rVal = Tool.rndDouble(0, 1);
        this.gVal = Tool.rndDouble(0, 1);
        this.bVal = Tool.rndDouble(0, 1);
        this.age = 0;
    }

    public void move() {
        double adjustedAngle = Math.toRadians(this.angle + 90);
        this.xPos += (float) (Math.cos(adjustedAngle) * speed);
        this.yPos += (float) (Math.sin(adjustedAngle) * speed);
    }

    public void updateInputs() {
        List<Neuron> inputNeurons = this.network.getInputs();
        inputNeurons.get(0).setValue(this.bias);
        inputNeurons.get(1).setValue(this.foodValuePosition);
        inputNeurons.get(2).setValue(this.foodValueFeeler);
        inputNeurons.get(3).setValue(this.energy);
        inputNeurons.get(4).setValue(this.tileTypeFeeler);
        inputNeurons.get(5).setValue(this.tileTypePosition);
        inputNeurons.get(6).setValue(1); //Age
        this.network.feedForward();
    }

    public double getxPos() {
        return this.xPos;
    }

    public void setxPos(float xPos) {
        if (xPos < (float) Globals.TILE_SIZE) {
            this.xPos = (float) Globals.TILE_SIZE;
        }
        if (xPos > Globals.MAX_SIZE - (float) Globals.TILE_SIZE) {
            this.xPos = Globals.MAX_SIZE - (float) Globals.TILE_SIZE;
        }

        this.xPos = xPos;
    }

    public double getyPos() {
        return this.yPos;
    }

    public void setyPos(float yPos) {
        if (yPos < (float) Globals.TILE_SIZE) {
            this.yPos = (float) Globals.TILE_SIZE;
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
        return this.age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getBias() {
        return this.bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public double getFoodValuePosition() {
        return this.foodValuePosition;
    }

    public void setFoodValuePosition(double foodValuePosition) {
        this.foodValuePosition = foodValuePosition;
    }

    public double getFoodValueFeeler() {
        return this.foodValueFeeler;
    }

    public void setFoodValueFeeler(double foodValueFeeler) {
        this.foodValueFeeler = foodValueFeeler;
    }

    public double getEnergy() {
        return this.energy;
    }

    public void setEnergy(double energy) {
        if (this.energy > Globals.MAX_FOOD_ON_TILE * 2) {
            this.energy = Globals.MAX_FOOD_ON_TILE * 2;
        } else {
            this.energy = energy;
        }
    }

    public int getTileTypeFeeler() {
        return this.tileTypeFeeler;
    }

    public void setTileTypeFeeler(int tileTypeFeeler) {
        this.tileTypeFeeler = tileTypeFeeler;
    }

    public int getTileTypePosition() {
        return this.tileTypePosition;
    }

    public void setTileTypePosition(int tileTypePosition) {
        this.tileTypePosition = tileTypePosition;
    }

    public double getBirth() {
        return this.birth;
    }

    public void setBirth(double birth) {
        this.birth = birth;
    }

    public double getRotate() {
        return this.rotate;
    }

    public void setRotate(double rotate) {
        this.rotate = rotate;
    }

    public double getMove() {
        return this.move;
    }

    public void setMove(double move) {
        this.move = move;
    }

    public double getFeelerAngle() {
        return this.feelerAngle;
    }

    public void setFeelerAngle(double feelerAngle) {
        this.feelerAngle = feelerAngle;
    }

    public double getEat() {
        return this.eat;
    }

    public void setEat(double eat) {
        this.eat = eat;
    }

    public double getrVal() {
        return this.rVal;
    }

    public void setrVal(double rVal) {
        this.rVal = rVal;
    }

    public double getgVal() {
        return this.gVal;
    }

    public void setgVal(double gVal) {
        this.gVal = gVal;
    }

    public double getbVal() {
        return this.bVal;
    }

    public void setbVal(double bVal) {
        this.bVal = bVal;
    }

    public double getAngle() {
        return this.angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public Creature clone() {
        try {
            Creature clone = (Creature) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
