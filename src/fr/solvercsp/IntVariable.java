package fr.solvercsp;

import fr.solvercsp.domains.IntDomain;

import java.util.Stack;

public class IntVariable implements Variable{

    private IntDomain domain;
    private Stack<IntDomain> domains;

    public IntVariable(IntDomain domain) {
        this.domain = domain;
    }

    @Override
    public void restrictDomain(Variable variable2) {
        IntVariable intVariable = (IntVariable) variable2;
        domain.restrictDomain(intVariable.domain);
    }
}