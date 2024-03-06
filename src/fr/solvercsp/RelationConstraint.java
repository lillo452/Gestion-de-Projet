/**
 * @author Lillo G.
 * @version 1.0
 */

public class RelationConstraint extends Constraint {

    private Variable variable1;
    private String relationOperator;
    private Variable variable2;

    public RelationConstraint(Variable variable1, String relationOperator, Variable variable2) {
        this.variable1 = variable1;
        this.relationOperator = relationOperator;
        this.variable2 = variable2;
    }

    @Override
    public boolean isSatisfied() {
        //Sous-taches 3.1 Antony
        return false;
    }
}
