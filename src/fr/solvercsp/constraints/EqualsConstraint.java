package fr.solvercsp.constraints;

import fr.solvercsp.Variable;

import java.util.List;

public class EqualsConstraint implements Constraint{
    @Override
    public void filter(Variable variable1, Variable variable2) {
        variable1.restrictDomain(variable2);
    }
}
