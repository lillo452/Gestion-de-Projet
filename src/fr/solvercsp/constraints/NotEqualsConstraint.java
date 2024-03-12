package fr.solvercsp.constraints;

import fr.solvercsp.Variable;

public class NotEqualsConstraint implements Constraint{
    @Override
    public void filter(Variable variable1, Variable variable2) {
        variable1.notIntersectDomain(variable2);
    }
}
