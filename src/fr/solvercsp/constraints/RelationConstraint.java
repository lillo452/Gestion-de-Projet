package fr.solvercsp.constraints;
import fr.solvercsp.Variable;

/**
 * This class represents a relation constraint that implements the Constraint interface.
 * @param <T> The type of the variables that this constraint applies to.
 * @author Lillo GAVOIS
 * @version 1.0
 */

public class RelationConstraint<T> implements Constraint<T> {

    /**
     * This method checks if a given relation constraint is satisfied.
     * @param variable1 The first variable in the constraint.
     * @param relationOperator The operator that relates the two variables.
     * @param variable2 The second variable in the constraint.
     * @return boolean This returns false by default. Needs to be implemented based on the specific constraint logic.
     */
    @Override
    public boolean isSatisfied(Variable<T> variable1, String relationOperator, Variable<T> variable2) {
        return false;
    }
}