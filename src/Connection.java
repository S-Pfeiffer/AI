/**
 * Diese Klasse dient dazu, Neuronen miteinander zu verbinden.
 */

public class Connection {

    private Neuron fromNeuron;
    private Neuron toNeuron;
    private double weight;

    /**
     * Konstruktor
     *
     * @param fromNeuron Das Neuron aus dem ein Wert geholt wird.
     * @param toNeuron   Das Neuron an den ein Wrt übergeben wird.
     *                   Dabei wird der Übergabewert mit dem Gewicht der Verbindung multipliziert.
     *                   <p>
     *                   Beim Generieren eines Objektes aus dieser Klasse enthält das Gewicht
     *                   einen zufälligen Wert zwischen -1.0 und 1.0
     */

    public Connection(Neuron fromNeuron, Neuron toNeuron) {
        this.fromNeuron = fromNeuron;
        this.toNeuron = toNeuron;
        this.weight = Tool.rndDouble(-1.0, 1.0);
    }

    /**
     * @return Gibt den Wert des Neurons zurück, aus dem gelesen wird.
     */

    public Neuron getFromNeuron() {
        return fromNeuron;
    }

    /**
     * @param fromNeuron Setzt das angegebene Neuron als Eingabeneuron für diese Verbindung.
     */

    public void setFromNeuron(Neuron fromNeuron) {
        this.fromNeuron = fromNeuron;
    }

    /**
     * @return Gibt das Neuron zurück, in das geschrieben wird.
     */

    public Neuron getToNeuron() {
        return toNeuron;
    }

    /**
     * @param toNeuron Setzt das angegebene Neuron als Ausgabeneuron für diese Verbindung
     */

    public void setToNeuron(Neuron toNeuron) {
        this.toNeuron = toNeuron;
    }

    /**
     * @return Gibt das gewicht dieser Verbindung zurück.
     */

    public double getWeight() {
        return weight;
    }

    /**
     * @param weight Setzt das gewicht dieser Verbindung
     */

    public void setWeight(double weight) {
        this.weight = weight;
    }
}