import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Problem<Integer> problem = new QueenProblem<Integer>();
        List<Constraint<Integer>> constraintList = new ArrayList<>();
        constraintList.add(new QueenConstraintZero<>());
        constraintList.add(new QueenConstraintRowOne<>());
        constraintList.add(new QueenConstraintColumnOne<>());
        constraintList.add(new QueenConstraintDiagonalOne<>());
        List<Integer> domainList = new ArrayList<>();
        domainList.add(0);
        domainList.add(1);
        Domain<Integer> domain = new Domain<Integer>(domainList);

        Solver<Integer> solver = new Solver<Integer>(problem, constraintList, domain);
        solver.solve();
    }
}