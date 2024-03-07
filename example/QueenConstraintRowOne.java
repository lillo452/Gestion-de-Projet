public class QueenConstraintRowOne<Integer> implements Constraint<Integer> {
    @Override
    public boolean verify(Problem<Integer> problem, Position pos, Integer variable) {
        boolean b = false;
        int[][] matrix = ((QueenProblem<Integer>) problem).getMatrix();
        int x = ((QueenProblem<Integer>) problem).getX();
        int y = ((QueenProblem<Integer>) problem).getY();
        if ((int) variable == 0) {
            b = true;
        }
        else{
            b = true;
            for(int i = 0; i < 4; i++){
                if(matrix[i][y] == 1){
                    b = false;
                    break;
                }
            }
        }
        return b;
    }
}
