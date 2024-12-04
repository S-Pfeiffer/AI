package model;

import tools.Tool;

public class Connection implements Cloneable {

    private Neuron fromNeuron;
    private Neuron toNeuron;
    private double weight;

    public Connection(Connection connection) {
        this.fromNeuron = connection.getFromNeuron().clone();
        this.toNeuron = connection.getToNeuron().clone();
        this.weight = connection.getWeight();
    }

    public Connection(Neuron fromNeuron, Neuron toNeuron) {
        this.fromNeuron = fromNeuron;
        this.toNeuron = toNeuron;
        this.weight = Tool.rndDouble(-1.0d, 1.0d);
    }

    public Neuron getFromNeuron() {
        return fromNeuron;
    }

    public void setFromNeuron(Neuron fromNeuron) {
        this.fromNeuron = fromNeuron;
    }

    public Neuron getToNeuron() {
        return toNeuron;
    }


    public void setToNeuron(Neuron toNeuron) {
        this.toNeuron = toNeuron;
    }


    public double getWeight() {
        return weight;
    }


    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public Connection clone() {
        try {
            Connection clone = (Connection) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}