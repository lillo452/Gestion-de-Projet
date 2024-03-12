package fr.solvercsp;

import fr.solvercsp.domains.IntDomain;

import java.util.Stack;

/**
 * Implementation of a variable with integer domain
 * @author Antony Ferry
 */
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

    /**
     * Save the current domain
     * @see #undo()
     */
    public void save(){
        domains.push(domain);
    }

    /**
     * Undo the last domain saved by {@link #save()}
     * @see #save()
     */
    public void undo(){
        domain = domains.pop();
    }
}