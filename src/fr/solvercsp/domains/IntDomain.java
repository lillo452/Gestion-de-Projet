package fr.solvercsp.domains;

import java.util.List;

/**
 * Implementation of Domain with integers
 * @author Antony Ferry
 */
public class IntDomain implements Domain{

    private int min;
    private int max;

    /**
     * Constructor for the IntDomain class.
     * @param min The minimum value in the domain.
     * @param max The maximum value in the domain.
     */
    public IntDomain(int min, int max){
        this.min = min;
        this.max = max;
    }

    /**
     * Returns if the domain is empty. An empty domain is a domain where the minimum value is greater than the maximum value.
     * @return True if the domain is empty, false otherwise.
     */
    public boolean isEmpty(){
        return min > max;
    }

    /**
     * Returns if the value is in the domain.
     * @param i The value to check.
     * @return True if the value is in the domain, false otherwise.
     */
    public boolean isIn(int i){
        return i >= min && i <= max;
    }

    /**
     * Returns if the domain is bound by the given values.
     * Only uses for tests
     * @return True if the domain is bound by the given values, false otherwise.
     */
    public boolean isBoundBy(int min, int max){
        return this.min == min && this.max == max;
    }

    /**
     * Returns if the domain is a single value domain.
     * @return True if the domain is a single value domain, false otherwise.
     */
    public boolean isSingle(){
        return min == max;
    }

    @Override
    public void restrictDomain(IntDomain domain) {
        min = Math.max(min, domain.min);
        max = Math.min(max, domain.max);
    }
}