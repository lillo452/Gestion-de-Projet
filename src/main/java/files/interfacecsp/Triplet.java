package files.interfacecsp;

/**
 * This class represents a Triplet which consists of a problem, a position, and a variable.
 * @param <type> the type of the variable
 * @author Frank LEGGETT
 * @version 1.0
 */
public class Triplet<type> {
    // The problem of the triplet
    private final Problem<type> problem;
    // The position of the triplet
    private final Position pos;
    // The variable of the triplet
    private final type variable;

    /**
     * Constructs a new Triplet with the given problem, position, and variable.
     * @param problem the problem of the triplet
     * @param pos the position of the triplet
     * @param variable the variable of the triplet
     */
    public Triplet(Problem<type> problem, Position pos, type variable){
        this.problem = problem.makeCopy();
        this.pos = pos.makeCopy();
        this.variable = variable;
        this.problem.setValue(variable);
    }

    /**
     * Returns the problem of the triplet.
     * @return the problem of the triplet
     */
    public Problem<type> getProblem(){
        return problem;
    }

    /**
     * Returns the position of the triplet.
     * @return the position of the triplet
     */
    public Position getPos(){
        return pos;
    }

    /**
     * Returns the variable of the triplet.
     * @return the variable of the triplet
     */
    public type getVariable(){
        return variable;
    }
}