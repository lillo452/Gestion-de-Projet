package files.interfacecsp;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Sudoku problem.
 * It implements the Problem interface with Integer as the type parameter.
 * @author Charles THIEBAUT
 * @version 1.0
 */
public class SudokuProblem<Integer> implements Problem<Integer>{

    // The Sudoku grid
    private int[][] Grid = new int[9][9];
    // The domain of the Sudoku problem
    private Domain<Integer>[][] domain = new Domain[9][9];
    // The x and y coordinates of the current position
    private int x;
    private int y;
    // The x and y coordinates of the current grid
    private int gridX;
    private int gridY;

    /**
     * Constructs a new SudokuProblem with an empty grid.
     */
    public SudokuProblem(){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                Grid[i][j] = 0;
            }
        }
        gridX = 0;
        gridY = 0;
    }

    /**
     * Applies the given domain to the Sudoku problem.
     * @param domain the domain to be applied
     */
    public void applyDomain(SudokuDomain<Integer> domain){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if(Grid[i][j] == 0){
                    this.domain[i][j] = domain;
                }
            }
        }
    }

    /**
     * Returns the domain of the current position.
     * @return the domain of the current position
     */
    public Domain<Integer> getDomain(){
        return domain[x][y];
    }

    /**
     * Returns the list of domains.
     * @return the list of domains
     */
    public Domain<Integer>[][] getDomainList(){return domain;}

    /**
     * Returns the Sudoku grid.
     * @return the Sudoku grid
     */
    public int[][] getGrid() {return Grid;}

    /**
     * Returns the x coordinate of the current grid.
     * @return the x coordinate of the current grid
     */
    public int getGridX(){
        return gridX;
    }

    /**
     * Returns the y coordinate of the current grid.
     * @return the y coordinate of the current grid
     */
    public int getGridY(){
        return gridY;
    }

    /**
     * Returns the current position.
     * @return the current position
     */
    @Override
    public Position getPos(){
        return new SudokuPosition(x, y);}

    /**
     * Sets the current position to the given position.
     * @param pos the position to be set
     */
    @Override
    public void setPos(Position pos){
        x = ((SudokuPosition)pos).getX();
        y = ((SudokuPosition)pos).getY();
        gridX = ((SudokuPosition)pos).getGridX();
        gridY = ((SudokuPosition)pos).getGridY();
    }

    /**
     * Adds the given value at the specified x and y coordinates.
     * @param value the value to be added
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public void addValue(Integer value, int x, int y){
        Grid[x][y] = (int)value;
        List<Integer> domain = new ArrayList<>();
        domain.add(value);
        this.domain[x][y] = new SudokuDomain<>(domain);
    }

    /**
     * Sets the value of the current position to the given value.
     * @param value the value to be set
     */
    @Override
    public void setValue(Integer value){
        Grid[x][y] = (int) value;
    }

    /**
     * Moves to the next position.
     */
    @Override
    public void nextPos(){
        if(!isEnd()){
            if(x == 8 && y < 8){
                x = 0;
                y++;
            }
            else{
                x++;
            }
            if(x >= 0 && x < 3){
                gridX = 0;
            }
            else if(x >= 3 && x < 6){
                gridX = 3;
            }
            else{
                gridX = 6;
            }

            if(y >= 0 && y < 3){
                gridY = 0;
            }
            else if(y >= 3 && y < 6){
                gridY = 3;
            }
            else{
                gridY = 6;
            }
        }
    }

    /**
     * Returns a copy of the Sudoku problem.
     * @return a copy of the Sudoku problem
     */
    @Override
    public Problem<Integer> makeCopy(){
        SudokuProblem<Integer> copy = new SudokuProblem<>();
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                copy.getGrid()[i][j] = Grid[i][j];
                copy.getDomainList()[i][j] = domain[i][j];
            }
        }
        Position copyPos = new SudokuPosition(x, y);
        copy.setPos(copyPos);
        return copy;
    }

    /**
     * Returns true if the current position is the beginning, false otherwise.
     * @return true if the current position is the beginning, false otherwise
     */
    @Override
    public boolean isBeggining(){
        return x == 0 && y == 0;
    }

    /**
     * Returns true if the current position is the end, false otherwise.
     * @return true if the current position is the end, false otherwise
     */
    @Override
    public boolean isEnd(){
        return x == 8 && y == 8;
    }

    /**
     * Resets the given little grid.
     * @param littleGrid the little grid to be reset
     */
    public void resetLittleGrid(int[] littleGrid){
        for (int i = 0; i < 9; i++){
            littleGrid[i] = 0;
        }
    }

    /**
     * Returns true if the given little grid is valid, false otherwise.
     * @param littleGrid the little grid to be checked
     * @return true if the given little grid is valid, false otherwise
     */
    public boolean checkLittleGrid(int[] littleGrid){
        for (int i = 0; i < 9; i++){
            if (littleGrid[i] != 1){
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if the Sudoku problem is solved, false otherwise.
     * @return true if the Sudoku problem is solved, false otherwise
     */
    @Override
    public boolean isSolved() {
        boolean b = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(Grid[i][j] == 0){
                    b = false;
                }
            }
        }
        return b;
    }

    /**
     * Prints the Sudoku grid.
     */
    @Override
    public void print(){
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                System.out.print(Grid[j][i]);
            }
            System.out.println();
        }
    }

    /**
     * Returns true if the cell at the given row and column is filled, false otherwise.
     * @param row the row of the cell
     * @param col the column of the cell
     * @return true if the cell at the given row and column is filled, false otherwise
     */
    public boolean isFilled(int row, int col) {
        return Grid[row][col] != 0;
    }

    /**
     * Returns true if the Sudoku grid is valid, false otherwise.
     * @return true if the Sudoku grid is valid, false otherwise
     */
    public boolean isValidGrid() {
        for (int i = 0; i < 9; i++) {
            boolean[] rowCheck = new boolean[9];
            boolean[] colCheck = new boolean[9];
            boolean[] boxCheck = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (Grid[i][j] != 0) {
                    if (rowCheck[Grid[i][j] - 1]) {
                        return false;
                    }
                    rowCheck[Grid[i][j] - 1] = true;
                }
                if (Grid[j][i] != 0) {
                    if (colCheck[Grid[j][i] - 1]) {
                        return false;
                    }
                    colCheck[Grid[j][i] - 1] = true;
                }
                int boxIndex = (i / 3) * 3 + j / 3;
                int boxPos = (i % 3) * 3 + j % 3;
                if (Grid[boxIndex][boxPos] != 0) {
                    if (boxCheck[Grid[boxIndex][boxPos] - 1]) {
                        return false;
                    }
                    boxCheck[Grid[boxIndex][boxPos] - 1] = true;
                }
            }
        }
        return true;
    }
}