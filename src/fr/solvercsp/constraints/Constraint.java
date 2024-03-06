package fr.solvercsp.constraints;

import fr.solvercsp.Variable;

public interface Constraint<T> {
    boolean isSatisfied(Variable<T> variable1, String relationOperator, Variable<T> variable2);
}
