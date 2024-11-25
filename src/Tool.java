/**
 * Some useful tools to get the work done.
 */

public class Tool {

    /**
     * Sigmoid function
     *
     * @param value The given Value to compute.
     * @return The (double) Sigmoid of the given value.
     * @return Returns 0 if the value < -6 and 1 if the value > 6
     */

    public static double sigmoid(double value) {
        return 1 / (1 + Math.exp(-value));
    }

    /**
     * Hyberbolic tangent
     *
     * @param value The given Value to compute.
     * @return The (double) Hyberbolic tangent by mapping the given Value to -1 and 1
     * @return Returns -1 if the value is <=0 and 1 if the Value is >= 0
     */

    public static double hybTan(double value) {
        value = sigmoid(value);
        return mapTo(value, 0, 1, -1, 1);
    }

    /**
     * The mapTo function "map's" a given Value in between minIn and maxIn
     * to a result in between minOut and maxOut
     *
     * @param value  The given value to map.
     * @param minIn  Represents the lower bound of the input.
     * @param maxIn  Represents the high bound of the input.
     * @param minOut Represents the lower bound of the output.
     * @param maxOut Represents the high bound of the output.
     * @return The mapped value.
     */

    public static double mapTo(double value, double minIn, double maxIn, double minOut, double maxOut) {
        return (value - minIn) * (maxOut - minOut) / (maxIn - minIn) + minOut;
    }

    /**
     * rndDouble computes a random double between "from" and "to".
     *
     * @param from Lower bound.
     * @param to   High bound.
     * @return A random number in between (double) from and (double) to.
     */

    public static double rndDouble(double from, double to) {
        return from + (to - from) * Math.random();
    }

}
