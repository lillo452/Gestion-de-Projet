package constraints;

import fr.solvercsp.IntVariable;
import fr.solvercsp.Variable;
import fr.solvercsp.constraints.EqualsConstraint;
import fr.solvercsp.domains.IntDomain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EqualsConstraintTest {

    @Test
    void filter() {
        IntDomain domain1 = new IntDomain(5, 10);
        IntDomain domain2 = new IntDomain(1, 7);
        Variable variable1 = new IntVariable(domain1);
        Variable variable2 = new IntVariable(domain2);

        EqualsConstraint equalsConstraint = new EqualsConstraint();
        equalsConstraint.filter(variable1, variable2);
        assertTrue(domain1.isBoundBy(0, 5, 7));
        assertTrue(domain2.isBoundBy(0, 5, 7));

    }
}