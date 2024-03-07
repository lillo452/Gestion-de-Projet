
public class QueenProblem<Integer> implements Problem<Integer>{

    private int[][] matrix = new int[4][4];
    private int x;
    private int y;
    public QueenProblem(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                matrix[i][j] = 0;
            }
        }
    }
    public int[][] getMatrix(){
        return matrix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public Position getPos() {
        return new MatrixPosition(x, y);
    }

    @Override
    public void setPos(Position pos){
        x = ((MatrixPosition)pos).getX();
        y = ((MatrixPosition)pos).getY();
    }
    @Override
    public void setValue(Integer value){
        matrix[x][y] = (int)value;
    }

    @Override
    public boolean isEnd() {
        return x == 3 && y == 3;
    }
    @Override
    public void nextPos(){
        if(!isEnd()){
            if(x == 3 && y < 3){
                x = 0;
                y++;
            }
            else{
                x++;
            }
        }
    }
    @Override
    public Problem<Integer> makeCopy(){
        QueenProblem<Integer> copy = new QueenProblem<Integer>();
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                copy.getMatrix()[i][j] = matrix[i][j];
            }
        }
        Position copyPos = new MatrixPosition(x, y);
        copy.setPos(copyPos);
        return copy;
    }
    @Override
    public void print() {
        for(int i = 0; i < 4; i++){
            String s = "";
            for(int j = 0; j < 4; j++){
                s += matrix[j][i];
            }
            System.out.println(s);
        }
    }
}
