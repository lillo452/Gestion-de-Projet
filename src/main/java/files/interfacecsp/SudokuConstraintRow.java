package files.interfacecsp;

/**
 * This class represents a constraint that checks if a variable can be placed in a row of a Sudoku grid.
 * @param <Integer> the type of the variable
 * @author Antony FERRY
 * @version 1.0
 */
public class SudokuConstraintRow<Integer> implements Constraint<Integer>{

    /**
     * Verifies if the variable is valid in the row.
     * @param problem the problem to be solved
     * @param pos the position of the variable
     * @param variable the variable to be verified
     * @return true if the variable is valid in the row, false otherwise
     */
    @Override
    public boolean verify(Problem<Integer> problem, Position pos, Integer variable) {
        int y = ((SudokuPosition) pos).getY();
        int[][] matrix = ((SudokuProblem) problem).getGrid();
        boolean b = true;
        for (int i = 0; i < 9; i++) {
            if ((int) variable == matrix[i][y]) {
                b = false;
            }
        }
        return b;
    }
}
