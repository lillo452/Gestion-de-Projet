package fr.solvercsp;

import fr.solvercsp.domains.IntDomain;

import java.util.Stack;

/**
 * Implementation of a variable with integer domain
 * @author Antony Ferry
 */
public class IntVariable implements Variable{

    private IntDomain domain;
    private Stack<IntDomain> domains = new Stack<>();

    public IntVariable(IntDomain domain) {
        this.domain = domain;
    }

    @Override
    public void intersectDomain(Variable variable2) {
        IntVariable intVariable = (IntVariable) variable2;
        domain.intersectDomain(intVariable.domain);
    }

    @Override
    public void save(){
        domains.push(domain);
    }

    @Override
    public void undo(){
        domain = domains.pop();
    }
}