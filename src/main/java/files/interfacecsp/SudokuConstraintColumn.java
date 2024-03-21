package files.interfacecsp;

/**
 * This class represents a Sudoku constraint that checks if a column is valid.
 * @param <Integer> the type of the variable
 * @author Antony FERRY
 * @version 1.0
 */
public class SudokuConstraintColumn<Integer> implements Constraint<Integer>{

    /**
     * Verifies if the variable is valid in the column.
     * @param problem the problem to be solved
     * @param pos the position of the variable
     * @param variable the variable to be verified
     * @return true if the variable is valid in the column, false otherwise
     */
    @Override
    public boolean verify(Problem<Integer> problem, Position pos, Integer variable) {
        int x = ((SudokuPosition) pos).getX();
        int[][] matrix = ((SudokuProblem) problem).getGrid();
        boolean b = true;
        for (int j = 0; j < 9; j++) {
            if ((int) variable == matrix[x][j]) {
                b = false;
            }
        }
        return b;
    }
}
