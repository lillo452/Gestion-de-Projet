package fr.solvercsp;

import fr.solvercsp.domains.Domain;

/**
 * CSP variable
 * @author Antony FERRY
 * @param <T> type of variable's value
 */
public class Variable<T> {

    private String name;
    private T value;
    private Domain<T> domain;

    /**
     * Returns the new value of the variable in this Triplet.
     *
     * @return The new value of the variable
     */
    public Variable(String name, T value){
        this.name = name;
        this.value = value;
    }

    /**
     * This method is used to get the value of the variable.
     * @return T This returns the current value of the variable.
     */
    public T getValue() {
        return this.value;
    }

    /**
     * This method is used to set the value of the variable.
     * @param value This is the new value to be set for the variable.
     */
    public void setValue(T value) {
        this.value = value;
    }

}