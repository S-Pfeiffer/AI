package model;

import tools.Tool;

public class Neuron implements Cloneable {

    private double value;

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

    @Override
    public Neuron clone() {
        try {
            return (Neuron) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
