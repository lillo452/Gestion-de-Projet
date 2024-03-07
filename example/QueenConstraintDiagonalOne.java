public class QueenConstraintDiagonalOne<Integer> implements Constraint<Integer> {
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
            int i = x;
            int j = y;
            while (i < 4 && j < 4) {
                if (matrix[i][j] == 1) {
                    b = false;
                    break;
                }
                i++;
                j++;
            }
            i = x;
            j = y;
            while (i >= 0 && j >= 0) {
                if (matrix[i][j] == 1) {
                    b = false;
                    break;
                }
                i--;
                j--;
            }
            i = x;
            j = y;
            while (i < 4 && j >= 0) {
                if (matrix[i][j] == 1) {
                    b = false;
                    break;
                }
                i++;
                j--;
            }
            i = x;
            j = y;
            while (i >= 0 && j < 4) {
                if (matrix[i][j] == 1) {
                    b = false;
                    break;
                }
                i--;
                j++;
            }
        }
        return b;
    }
}
