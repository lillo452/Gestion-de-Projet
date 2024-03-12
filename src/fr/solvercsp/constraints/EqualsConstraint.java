package fr.solvercsp.constraints;

import fr.solvercsp.Variable;

/**
 * Implementation of Constraint for an equality constraint.
 * @author Antony Ferry
 */
public class EqualsConstraint implements Constraint{
    @Override
    public void filter(Variable variable1, Variable variable2) {
        variable1.intersectDomain(variable2);
        variable2.intersectDomain(variable1);
    }
}
