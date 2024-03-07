public class MatrixPosition implements Position{
    private int x;
    private int y;
    public MatrixPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public Position makeCopy() {
        Position copy = new MatrixPosition(x, y);
        return copy;
    }

    public int getX(){
        return x;
    }

    public int getY() {
        return y;
    }
}
