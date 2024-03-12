package fr.solvercsp.constraints;

import fr.solvercsp.Variable;

/**
 * This interface represents a generic constraint.
 */
public interface Constraint {

    /**
     * This method filters the domain of a given variable based on the constraint logic.
     * @param variable1 The first variable in the constraint.
     * @param variable2 The second variable in the constraint.
     */
    void filter(Variable variable1, Variable variable2);
}