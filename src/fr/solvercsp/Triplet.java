package fr.solvercsp;

/**
 * This class represents a Triplet which consists of a variable and its old and new values.
 *
 * @author Lillo GAVOIS
 * @version 1.0
 */
public class Triplet {
    private Variable variable;
    private int oldValue;
    private int newValue;

    /**
     * Constructs a new Triplet with the given variable, old value and new value.
     *
     * @param variable The variable for which the values are being tracked
     * @param oldValue The old value of the variable
     * @param newValue The new value of the variable
     */
    public Triplet(Variable variable, int oldValue, int newValue) {
        this.variable = variable;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    /**
     * Returns the variable of this Triplet.
     *
     * @return The variable of this Triplet
     */
    public Variable getVariable() {
        return variable;
    }

    /**
     * Returns the old value of the variable in this Triplet.
     *
     * @return The old value of the variable
     */
    public int getOldValue() {
        return oldValue;
    }

    /**
     * Returns the new value of the variable in this Triplet.
     *
     * @return The new value of the variable
     */
    public int getNewValue() {
        return newValue;
    }
}
