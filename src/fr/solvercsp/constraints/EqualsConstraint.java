package fr.solvercsp.constraints;

import fr.solvercsp.Variable;

/**
 * Implementation of Constraint for an equality constraint.
 * @author Antony Ferry
 */
public class EqualsConstraint extends Constraint {

    public EqualsConstraint(Variable variable1, Variable variable2) {
        super(variable1, variable2);
    }

    @Override
    public void filter() {
        variable1.intersectDomain(variable2);
        variable2.intersectDomain(variable1);
    }
}
