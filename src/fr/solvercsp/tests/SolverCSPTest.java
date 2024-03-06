package fr.solvercsp.tests;
import fr.solvercsp.SolverCSP;
import fr.solvercsp.Variable;
import fr.solvercsp.constraints.Constraint;
import fr.solvercsp.constraints.RelationConstraint;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the class SolverCSP
 *
 * @author Wail AMEUR
 * @version 1.0
 * @see SolverCSP
 */
public class SolverCSPTest {

    /**
     * Test case for the addVariable method in the SolverCSP class.
     * This test checks if the variable is correctly added to the stack.
     */
    @Test
    public void addVariableAddsVariableToStack() {
        SolverCSP solver = new SolverCSP();
        Variable variable = new Variable("var1", 1);
        solver.addVariable(variable);
        assertEquals(variable, solver.getVariables().get(0));
    }

    /**
     * Test case for the addConstraint method in the SolverCSP class.
     * This test checks if the constraint is correctly added to the stack.
     */
    @Test
    public void addConstraintAddsConstraintToStack() {
        SolverCSP solver = new SolverCSP();
        Constraint constraint = new RelationConstraint();
        solver.addConstraint(constraint);
        assertEquals(constraint, solver.getConstraints().get(0));
    }

    /**
     * Test case for the pushState method in the SolverCSP class.
     * This test checks if the current state is correctly saved when pushState is called.
     */
    @Test
    public void pushStateSavesCurrentState() {
        SolverCSP solver = new SolverCSP();
        Variable variable = new Variable("var1", 2);
        solver.addVariable(variable);
        solver.pushState();
        variable.setValue(3);
        solver.popState();
        assertEquals(2, variable.getValue());
    }

    /**
     * Test case for the popState method in the SolverCSP class.
     * This test checks if the previous state is correctly restored when popState is called.
     */
    @Test
    public void popStateRestoresPreviousState() {
        SolverCSP solver = new SolverCSP();
        Variable variable = new Variable("var1", 1);
        solver.addVariable(variable);
        solver.pushState();
        variable.setValue(2);
        solver.popState();
        assertEquals(1, variable.getValue());
    }

    /**
     * Test case for the addRelationConstraint method in the SolverCSP class.
     * This test checks if the relation constraint is correctly added to the stack.
     */
    @Test
    public void addRelationConstraintAddsConstraintToStack() {
        SolverCSP solver = new SolverCSP();
        Variable variable1 = new Variable("var1", 1);
        Variable variable2 = new Variable("var2", 2);
        solver.addRelationConstraint(variable1, "relationOperator", variable2);
        assertTrue(solver.getConstraints().get(0) instanceof RelationConstraint);
    }
}