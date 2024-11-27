import java.util.List;

public class Creature {

    private double xPos;
    private double yPos;

    private Network network = new Network(Globals.INPUT_NEURONS, Globals.HIDDEN_NEURONS, Globals.OUTPUT_NEURONS);

    // Inputs
    private int age;
    private double bias = 1.0;
    private double foodValuePosition = 0.0;
    private double foodValueFeeler = 0.0;
    private double energy;
    private int tileTypeFeeler;
    private int tileTypePosition;

    // Outputs
    private double birth;
    private double rotate;
    private double move;
    private double feelerAngle;
    private double eat;

    public void updateInputs() {
        List<Neuron> inputNeurons = this.network.getInputs();
        inputNeurons.get(0).setValue(this.bias);
        inputNeurons.get(1).setValue(this.foodValuePosition);
        inputNeurons.get(2).setValue(this.foodValueFeeler);
        inputNeurons.get(3).setValue(this.energy);
        inputNeurons.get(4).setValue(this.tileTypeFeeler);
        inputNeurons.get(5).setValue(this.tileTypePosition);
        inputNeurons.get(6).setValue(this.age);
    }

    public Creature() {

    }

    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public Network getNetwork() {
        return this.network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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
        this.energy = energy;
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
}
