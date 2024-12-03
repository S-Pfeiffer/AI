package model;

import java.util.ArrayList;
import java.util.List;

public class Network {

    private List<Neuron> inputs = new ArrayList<Neuron>();
    private List<Neuron> hiddens = new ArrayList<Neuron>();
    private List<Neuron> outputs = new ArrayList<Neuron>();

    private List<Connection> firstLayerConnections = new ArrayList<>();
    private List<Connection> secondLayerConnections = new ArrayList<>();


    public Network(int inputNeurons, int hiddenNeurons, int outputNeurons) {
        init(inputNeurons, hiddenNeurons, outputNeurons);
    }



    public void feedForward() {

        for (Neuron n : hiddens) {
            n.setValue(0.0);
        }
        for (Neuron n : outputs) {
            n.setValue(0.0);
        }

        for (Connection f : this.firstLayerConnections) {
            f.getToNeuron().addValue(f.getFromNeuron().getValue() * f.getWeight());
        }
        for (Connection f : this.secondLayerConnections) {
            f.getToNeuron().addValue(f.getFromNeuron().getValue() * f.getWeight());
        }
    }

    private void init(int inputNeurons, int hiddenNeurons, int outputNeurons) {

        for (int i = 0; i < inputNeurons; i++) {
            inputs.add(new Neuron());
        }

        for (int i = 0; i < hiddenNeurons; i++) {
            hiddens.add(new Neuron());
        }

        for (int i = 0; i < outputNeurons; i++) {
            outputs.add(new Neuron());
        }

        for (Neuron i : inputs) {
            for (Neuron j : hiddens) {
                firstLayerConnections.add(new Connection(i, j));
            }
        }

        for (Neuron i : hiddens) {
            for (Neuron j : outputs) {
                secondLayerConnections.add(new Connection(i, j));
            }
        }
    }

    public List<Neuron> getInputs() {
        return inputs;
    }

    public void setInputs(List<Neuron> inputs) {
        this.inputs = inputs;
    }

    public List<Neuron> getHiddens() {
        return hiddens;
    }

    public void setHiddens(List<Neuron> hiddens) {
        this.hiddens = hiddens;
    }

    public List<Neuron> getOutputs() {
        return outputs;
    }

    public void setOutputs(List<Neuron> outputs) {
        this.outputs = outputs;
    }

    public List<Connection> getFirstLayerConnections() {
        return firstLayerConnections;
    }

    public void setFirstLayerConnections(List<Connection> firstLayerConnections) {
        this.firstLayerConnections = firstLayerConnections;
    }

    public List<Connection> getSecondLayerConnections() {
        return secondLayerConnections;
    }

    public void setSecondLayerConnections(List<Connection> secondLayerConnections) {
        this.secondLayerConnections = secondLayerConnections;
    }
}