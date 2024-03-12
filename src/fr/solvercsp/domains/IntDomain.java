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
     * List of variables in the domain
     * Example: if the domain is between 0 and 5, getVariables will return {0, 1, 2, 3, 4, 5}
     * @return list of variables in the domain
     */
    @Override
    public List<Integer> getValues() {
        List<Integer> values = new java.util.ArrayList<>();
        for (int i = min; i <= max; i++){
            if (!excludedValues.contains(i)){
                values.add(i);
            }
        }
        return values;
    }
}