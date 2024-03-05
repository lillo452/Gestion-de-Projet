package fr.solvercsp;

import java.util.List;

/**
 * Implementation of Domain with integers
 * @author Antony Ferry
 */
public class IntDomain implements Domain<Integer>{

    /**
     * List of variables in the domain
     * Example: if the domain is between 0 and 5, getVariables will return {0, 1, 2, 3, 4, 5}
     * @return list of variables in the domain
     */
    @Override
    public List<Integer> getValues() {
        return null;
    }
}
