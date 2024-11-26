public class Neuron {
    private double value;

    private String name;

    public Neuron() {
        this.value = Tool.rndDouble(-1.0, 1.0);
    }

    public double getValue() {
        return Tool.hybTan(value);
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void addValue(double value) {
        this.value += value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
