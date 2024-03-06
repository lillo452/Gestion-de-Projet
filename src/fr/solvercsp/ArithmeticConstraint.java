package fr.solvercsp;

/**
 * @author Lillo G.
 * @version 1.0
 */

public class ArithmeticConstraint extends Constraint {

    private Variable variable;
    private String arithmeticOperator;
    private int constant;

    public ArithmeticConstraint(Variable variable, String arithmeticOperator, int constant) {
        this.variable = variable;
        this.arithmeticOperator = arithmeticOperator;
        this.constant = constant;
    }

    @Override
    public boolean isSatisfied() {
    //Sous-tache 3.1 Antony
    }
}
