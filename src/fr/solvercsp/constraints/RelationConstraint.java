package fr.solvercsp.constraints;
import fr.solvercsp.Variable;

/**
 * @author Lillo G.
 * @version 1.0
 */

public class RelationConstraint<T> implements Constraint<T> {

    @Override
    public boolean isSatisfied(Variable<T> variable1, String relationOperator, Variable<T> variable2) {
        return false;
    }
}
