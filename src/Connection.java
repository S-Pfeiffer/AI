/**
 * This class is used to connect the Neurons together
 */

class Connection {

    private Neuron fromNeuron;
    private Neuron toNeuron;
    private double weight;

    /**
     * The constructor for this class uses following values
     *
     * @param fromNeuron The neuron to take the value from.
     * @param toNeuron   The neuron to write the value of the connection to
     *                   by multiplies the input value with the weight of the connection.
     *                   <p>
     *                   Every time a new connection is generated its weight will set randomly in the
     *                   range between -1.0 and 1.0
     */

    public Connection(Neuron fromNeuron, Neuron toNeuron) {
        this.fromNeuron = fromNeuron;
        this.toNeuron = toNeuron;
        this.weight = Tool.rndDouble(-1.0, 1.0);
    }

    /**
     * @return Returns neuron connected to the input side of the connection.
     */

    public Neuron getFromNeuron() {
        return fromNeuron;
    }

    /**
     * @param fromNeuron Set the neuron to the input side of the connection.
     */

    public void setFromNeuron(Neuron fromNeuron) {
        this.fromNeuron = fromNeuron;
    }

    /**
     * @return Returns the neuron at the output side of the connection.
     */

    public Neuron getToNeuron() {
        return toNeuron;
    }

    /**
     * @param toNeuron Set the neuron of the output side of the connection.
     */

    public void setToNeuron(Neuron toNeuron) {
        this.toNeuron = toNeuron;
    }

    /**
     * @return Returns the weight of the connection.
     */

    public double getWeight() {
        return weight;
    }

    /**
     * @param weight Sets the weight of the connection
     */

    public void setWeight(double weight) {
        this.weight = weight;
    }
}