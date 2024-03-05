package fr.solvercsp;

/**
 * CSP variable
 * @author Antony Ferry
 * @param <T> type of variable's value
 */
public class Variable<T> {

    private String name;
    private T value;
    private Domain<T> domain;

    public Variable(String name, T value){
        this.name = name;
        this.value = value;
    }

}