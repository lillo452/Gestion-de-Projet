package fr.solvercsp.constraints;

import fr.solvercsp.Variable;

/**
 * This class represents a generic constraint.
 * @author Antony Ferry
 */
public abstract class Constraint {

    protected Variable variable1;
    protected Variable variable2;

    public Constraint(Variable variable1, Variable variable2){
        this.variable1 = variable1;
        this.variable2 = variable2;
    }

    /**
     * This method filters the domain of a given variable based on the constraint logic.
     */
    abstract void filter();
}