package files.interfacecsp;

/**
 * This class represents a SudokuPosition which consists of a x and y coordinate.
 * @author Lillo GAVOIS
 * @version 1.0
 */
public class SudokuPosition implements Position {

    private int x;
    private int y;
    private int gridX;
    private int gridY;

    /**
     * Constructs a new SudokuPosition with the given x and y coordinates.
     * @param x the x coordinate of the position
     * @param y the y coordinate of the position
     */
    public SudokuPosition(int x, int y){
        this.x = x;
        this.y = y;

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

    /**
     * Returns the x coordinate of the position.
     * @return the x coordinate of the position
     */
    @Override
    public Position makeCopy() {
        Position copy = new SudokuPosition(x, y);
        return copy;
    }

    public int getX(){return x;}
    public int getY(){return y;}
    public int getGridX(){
        return gridX;
    }
    public int getGridY(){
        return gridY;
    }
}
