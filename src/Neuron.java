public class Neuron {
    private double value;

    public void Neuron() {
        this.value = Tool.rndDouble(-1.0, 1.0);
    }

    public double getValue() {
        return Tool.hybTan(value);
    }

    public void setValue(double value) {
        this.value += value;
    }

}
