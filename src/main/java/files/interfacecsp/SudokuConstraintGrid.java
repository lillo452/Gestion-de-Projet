package files.interfacecsp;

/**
 * This class represents a constraint for a Sudoku problem.
 * @param <Integer> the type of the variable
 * @author Antony FERRY
 * @version 1.0
 */

public class SudokuConstraintGrid<Integer> implements Constraint<Integer>{

    /**
     * Verifies if the variable is valid in the grid.
     * @param problem the problem to be solved
     * @param pos the position of the variable
     * @param variable the variable to be verified
     * @return true if the variable is valid in the grid, false otherwise
     */
    @Override
    public boolean verify(Problem<Integer> problem, Position pos, Integer variable) {
        int x = ((SudokuProblem) problem).getGridX();
        int y = ((SudokuProblem) problem).getGridY();
        int[][] matrix = ((SudokuProblem) problem).getGrid();
        boolean b = true;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if ((int) variable == matrix[i][j]) {
                    b = false;
                }
            }
        }
        return b;
    }
}
