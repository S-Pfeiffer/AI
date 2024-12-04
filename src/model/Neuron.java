package model;

import tools.Tool;

public class Neuron implements Cloneable {

    public Neuron(Neuron neuron) {
        this.value = neuron.getValue();
    }

    private double value;

    public Neuron() {
        this.value = Tool.rndDouble(-1.0, 1.0);
    }

    public double getValue() {
        return Tool.hybTan(this.value);
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void addValue(double value) {
        this.value += value;
    }

    @Override
    public Neuron clone() {
        try {
            Neuron clone = (Neuron) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
