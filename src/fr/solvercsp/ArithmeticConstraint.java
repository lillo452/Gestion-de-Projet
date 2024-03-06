package fr.solvercsp;

import fr.solvercsp.constraints.Constraint;

/**
 * This class represents an arithmetic constraint that implements the Constraint interface.
 * @author Lillo G.
 * @version 1.0
 */

public class ArithmeticConstraint implements Constraint {

    /**
     * This method checks if a given arithmetic constraint is satisfied.
     * @param variable1 The first variable in the constraint.
     * @param relationOperator The operator that relates the two variables.
     * @param variable2 The second variable in the constraint.
     * @return boolean This returns false by default. Needs to be implemented based on the specific constraint logic.
     *
     * @depricated this method doesn't work.
     */
    @Override
    public boolean isSatisfied(Variable variable1, String relationOperator, Variable variable2) {
        //Sous-tache 3.1 Antony
        return false;
    }
}
