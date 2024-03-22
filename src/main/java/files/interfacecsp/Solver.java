package files.interfacecsp;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

/**
 * This class represents a Solver for a generic problem.
 * It uses a stack for backtracking and a list of constraints to verify the problem.
 * @param <type> the type of the variable
 * @author Frank LEGGETT
 * @version 1.0
 */
public class Solver<type> {
    private Problem<type> problem;
    private final List<Constraint<type>> constraintList;
    private final Stack<Triplet<type>> backtrackingStack = new Stack<>();

    /**
     * Constructs a new Solver with the given problem and list of constraints.
     * @param problem the problem to be solved
     * @param constraintList the list of constraints
     */
    public Solver(Problem<type> problem, List<Constraint<type>> constraintList){
        this.problem = problem;
        this.constraintList = constraintList;
    }

    /**
     * Pops a triplet from the backtracking stack and sets the problem and position to the popped triplet's problem and position.
     */
    public void pop(){
        Triplet<type> triplet = backtrackingStack.pop();
        problem = triplet.getProblem();
        problem.setPos(triplet.getPos());
    }

    /**
     * Verifies the constraints for the given variable.
     * @param var the variable to be verified
     * @return true if all constraints are satisfied, false otherwise
     */
    public boolean contraintVerificator(type var){
        boolean constraint_verification = true;
        for (Constraint<type> constraint : constraintList) {
            constraint_verification = constraint_verification && constraint.verify(problem, problem.getPos(), var);
        }
        return constraint_verification;
    }

    /**
     * Adds a triplet with the given variable to the backtracking stack.
     * @param var the variable to be added
     */
    public void addTriplet(type var) {
        Triplet<type> triplet = new Triplet<type>(problem, problem.getPos(), var);
        backtrackingStack.push(triplet);
    }

    /**
     * Solves the problem.
     * @return true if the problem is solved, false otherwise
     */
    public boolean solving() {
        boolean result = false;
        boolean the_end = false;
        boolean beginning = true;
        while ((beginning || !backtrackingStack.isEmpty()) && !the_end) {
            if(!beginning) {
                pop();
                problem.nextPos();
            }
            problem.print();
            System.out.println("\n");
            int pos = 0;
            System.out.println("" + ((SudokuPosition)problem.getPos()).getX() + ((SudokuPosition)problem.getPos()).getY() + ((SudokuPosition)problem.getPos()).getGridX() + ((SudokuPosition)problem.getPos()).getGridY());
            Domain<type> current = problem.getDomain();
            while (!current.isEnd(pos)) {
                if (contraintVerificator(current.get(pos))) {
                    addTriplet(current.get(pos));
                }
                else if(current.size() == 1){
                    addTriplet(current.get(pos));
                }
                pos++;
            }
            if (problem.isSolved()) {
                result = true;
                the_end = true;
            }
            beginning = false;
        }
        return result;
    }

    /**
     * Solves the problem and prints the result.
     */
    public void solve(){
        problem.print();
        if(!solving()){
            System.out.println("could not solve \n");
        }
        System.out.println("\n");
        problem.print();
    }
}
