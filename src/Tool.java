/**
 * Some useful tools to get the work done.
 */

public class Tool {

    /**
     * Sigmoid Funktion
     *
     * @param value Der Wert auf den die Sigmoid Funktion angewendet werden soll.
     * @return Der Rückgabewert ist 0, wenn der Eingabewert < -6 ist oder 1, wenn
     * der Eingabewert value > 6 ist.
     */

    public static double sigmoid(double value) {
        return 1 / (1 + Math.exp(-value));
    }

    /**
     * Hyperbolicus Tangens
     *
     * @param value Der Wert auf den Hyperbolic Tangens angewendet werden soll.
     * @return Zurückgegeben wird ein Wert zwischen -1.0 und 1.0 ausgehend eines Mappings
     * der eingabe zwischen 0 und 1.
     */

    public static double hybTan(double value) {
        value = sigmoid(value);
        return mapTo(value, 0, 1, -1, 1);
    }

    /**
     * Methode zum umlegen eines Eingabewertes im definierten Eingabebereich
     * zu einem Wert im definierten Ausgabebereich.
     *
     * @param value  Eingabewert
     * @param minIn  Untergrenze des Eingabewertes
     * @param maxIn  Obergrenze des Eingabewertes
     * @param minOut Untergrenze des Ausgabewertes
     * @param maxOut Obergrenze des Ausgabewertes
     * @return Umgelegter Wert
     */

    public static double mapTo(double value, double minIn, double maxIn, double minOut, double maxOut) {
        return (value - minIn) * (maxOut - minOut) / (maxIn - minIn) + minOut;
    }

    /**
     * Einfache Methode zum Berechnen einer Zufallszahl.
     *
     * @param from Von Wert
     * @param to   Bis Wert.
     * @return Rückgabe einer Zufallszahl im gewählten Bereich.
     */

    public static float rndDouble(double from, double to) {
        return (float) (from + (to - from) * Math.random());
    }

}
