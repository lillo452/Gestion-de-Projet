public interface Problem<type> {
    Position getPos();
    void setPos(Position pos);
    void setValue(type value);
    void nextPos();
    Problem<type> makeCopy();
    boolean isEnd();
    void print();
}
