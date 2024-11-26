/**
 * this project is intended to implement a simulation of AI creatures in Java
 *
 * @author Stephan Pfeiffer
 * @version 0.00
 */

/**
 * The main Class of this project
 */


public class Main {
    public static void main(String[] args) {

        /**
         * Call th constructor of "Network" to generate a
         * new network called "network"
         *
         * @param inputNeurons, the count of neurons in the first layer
         * @param hiddenNeurons, the count of neurons in the second layer
         * @param OutputNeurons, the count of neurons in the third layer
         * @return A network type Network
         */

        Network network = new Network(Globals.INPUT_NEURONS, Globals.HIDDEN_NEURONS, Globals.OUTPUT_NEURONS);

        for (Neuron n : network.getInputs()) {
            n.setValue(Tool.rndDouble(-1.0, 1.0));
        }

        for (Neuron n : network.getOutputs()) {
            System.out.println(n.getValue());
        }

        network.feedForward();
        System.out.println();

        for (Neuron n : network.getOutputs()) {
            System.out.println(n.getValue());
        }
    }
}
