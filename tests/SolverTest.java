import fr.solvercsp.IntVariable;
import fr.solvercsp.Solver;
import fr.solvercsp.constraints.EqualsConstraint;
import fr.solvercsp.domains.IntDomain;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

    @Test
    void solve() {
        IntDomain domain = new IntDomain(1, 20);
        IntDomain domain1 = new IntDomain(15, 25);
        IntDomain domain3 = new IntDomain(20, 25);
        IntDomain domain4 = new IntDomain(14, 15);
        IntVariable variable = new IntVariable(domain);
        IntVariable variable1 = new IntVariable(domain1);
        IntVariable variable2 = new IntVariable(domain3);
        IntVariable variable3 = new IntVariable(domain4);

        Solver solver = new Solver(List.of(variable, variable1, variable3, variable2), List.of(new EqualsConstraint(variable, variable1),
                new EqualsConstraint(variable2, variable3)));
        solver.solve();



    }
}