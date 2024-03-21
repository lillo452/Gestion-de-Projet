package files.interfacecsp;

/**
 * This interface represents a generic problem.
 * @param <type> the type of the variable
 * @author Charles THIEBAUT
 * @version 1.0
 */
public interface Problem<type> {
    Position getPos();
    Domain<type> getDomain();
    void setPos(Position pos);
    void setValue(type value);
    void nextPos();
    Problem<type> makeCopy();
    boolean isBeggining();
    boolean isEnd();
    boolean isSolved();
    void print();
    boolean isFilled(int row, int col);
    boolean isValidGrid();
}
