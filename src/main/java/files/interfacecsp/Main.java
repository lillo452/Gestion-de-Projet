package files.interfacecsp;

import java.util.ArrayList;
import java.util.List;

/**
 * The Main class is the entry point of the application.
 * It creates a Sudoku problem, adds constraints and a domain to it, and solves it.
 * @author Frank LEGGETT
 * @version 1.0
 */
public class Main {
    /**
     * The main method is the entry point of the application.
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Problem<Integer> problem = new SudokuProblem();
        ((SudokuProblem)problem).addValue(7, 1, 0);
        ((SudokuProblem)problem).addValue(6, 1, 1);
        ((SudokuProblem)problem).addValue(2, 0, 2);

        ((SudokuProblem)problem).addValue(2, 4, 0);
        ((SudokuProblem)problem).addValue(8, 3, 2);

        ((SudokuProblem)problem).addValue(4, 7, 0);
        ((SudokuProblem)problem).addValue(6, 8, 0);
        ((SudokuProblem)problem).addValue(8, 6, 1);
        ((SudokuProblem)problem).addValue(9, 7, 1);
        ((SudokuProblem)problem).addValue(7, 6, 2);
        ((SudokuProblem)problem).addValue(1, 7, 2);
        ((SudokuProblem)problem).addValue(5, 8, 2);

        ((SudokuProblem)problem).addValue(8, 1, 3);
        ((SudokuProblem)problem).addValue(4, 2, 3);
        ((SudokuProblem)problem).addValue(7, 0, 4);
        ((SudokuProblem)problem).addValue(1, 1, 4);

        ((SudokuProblem)problem).addValue(9, 4, 3);
        ((SudokuProblem)problem).addValue(7, 5, 3);
        ((SudokuProblem)problem).addValue(1, 3, 5);
        ((SudokuProblem)problem).addValue(3, 4, 5);

        ((SudokuProblem)problem).addValue(5, 7, 4);
        ((SudokuProblem)problem).addValue(9, 8, 4);
        ((SudokuProblem)problem).addValue(4, 6, 5);
        ((SudokuProblem)problem).addValue(8, 7, 5);

        ((SudokuProblem)problem).addValue(6, 0, 6);
        ((SudokuProblem)problem).addValue(9, 1, 6);
        ((SudokuProblem)problem).addValue(7, 2, 6);
        ((SudokuProblem)problem).addValue(5, 1, 7);
        ((SudokuProblem)problem).addValue(8, 2, 7);
        ((SudokuProblem)problem).addValue(4, 0, 8);
        ((SudokuProblem)problem).addValue(3, 1, 8);

        ((SudokuProblem)problem).addValue(2, 5, 6);
        ((SudokuProblem)problem).addValue(8, 4, 8);

        ((SudokuProblem)problem).addValue(8, 8, 6);
        ((SudokuProblem)problem).addValue(6, 7, 7);
        ((SudokuProblem)problem).addValue(7, 7, 8);
        List<Constraint<Integer>> constraintList = new ArrayList<>();
        constraintList.add(new SudokuConstraintRow<>());
        constraintList.add(new SudokuConstraintColumn<>());
        constraintList.add(new SudokuConstraintGrid<>());
        List<Integer> domainList = new ArrayList<>();
        domainList.add(1);
        domainList.add(2);
        domainList.add(3);
        domainList.add(4);
        domainList.add(5);
        domainList.add(6);
        domainList.add(7);
        domainList.add(8);
        domainList.add(9);
        Domain<Integer> domain = new SudokuDomain<Integer>(domainList);
        ((SudokuProblem<Integer>) problem).applyDomain((SudokuDomain) domain);

        Solver<Integer> solver = new Solver<Integer>(problem, constraintList);
        solver.solve();
    }
}