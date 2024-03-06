package fr.solvercsp.constraints;

import fr.solvercsp.Variable;

/**
 * This interface represents a generic constraint.
 * @param <T> The type of the variables that this constraint applies to.
 */
public interface Constraint<T> {

    /**
     * This method checks if a given constraint is satisfied.
     * @param variable1 The first variable in the constraint.
     * @param relationOperator The operator that relates the two variables.
     * @param variable2 The second variable in the constraint.
     * @return boolean This returns the result of the constraint satisfaction check.
     */
    boolean isSatisfied(Variable<T> variable1, String relationOperator, Variable<T> variable2);
}