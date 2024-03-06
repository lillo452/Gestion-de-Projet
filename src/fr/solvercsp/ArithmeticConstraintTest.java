package fr.solvercsp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains tests for the ArithmeticConstraint class.
 * It tests the isSatisfied method of the ArithmeticConstraint class.
 *
 * @see ArithmeticConstraint
 * @author Wail AMEUR
 */
public class ArithmeticConstraintTest {

    /**
     * This test method tests the isSatisfied method of the ArithmeticConstraint class.
     * It asserts that the isSatisfied method correctly returns false when the constraint logic is not implemented.
     */
    @Test
    public void isSatisfiedReturnsFalseByDefault() {
        ArithmeticConstraint constraint = new ArithmeticConstraint();
        assertFalse(constraint.isSatisfied(new Variable("var1", 1), "relationOperator", new Variable("var2", 2)));
    }

    /**
     * This test method tests the isSatisfied method of the ArithmeticConstraint class.
     * It asserts that the isSatisfied method correctly handles null variables.
     */
    @Test
    public void isSatisfiedHandlesNullVariables() {
        ArithmeticConstraint constraint = new ArithmeticConstraint();
        assertThrows(NullPointerException.class, () -> constraint.isSatisfied(null, "relationOperator", new Variable("var1", 1)));
        assertThrows(NullPointerException.class, () -> constraint.isSatisfied(new Variable("var2", 2), "relationOperator", null));
    }

    /**
     * This test method tests the isSatisfied method of the ArithmeticConstraint class.
     * It asserts that the isSatisfied method correctly handles null relationOperator.
     */
    @Test
    public void isSatisfiedHandlesNullRelationOperator() {
        ArithmeticConstraint constraint = new ArithmeticConstraint();
        assertThrows(NullPointerException.class, () -> constraint.isSatisfied(new Variable("var1", 1), null, new Variable("var2", 2)));
    }
}