package fr.solvercsp.domains;

import java.util.List;

/**
 * Implementation of Domain with integers
 * @author Antony Ferry
 */
public class IntDomain implements Domain{

    private int min;
    private int max;
    private List<Integer> excludedValues;

    /**
     * Constructor for the IntDomain class.
     * @param min The minimum value in the domain.
     * @param max The maximum value in the domain.
     * @param excludedValues A list of values to be excluded from the domain.
     */
    public IntDomain(int min, int max, List<Integer> excludedValues){
        this.min = min;
        this.max = max;
        this.excludedValues = excludedValues;
    }

    /**
     * Restricts the domain to the intersection of the current domain and the given domain.
     * @param domain The domain to restrict the current domain to.
     */
    @Override
    public void restrictDomain(IntDomain domain) {
        min = Math.max(min, domain.min);
        max = Math.min(max, domain.max);
    }
}