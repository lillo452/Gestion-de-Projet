package files.interfacecsp;

/**
 * This interface represents a constraint in a CSP problem.
 * @param <type> the type of the variable
 * @author Antony FERRY
 * @version 1.0
 */
public interface Constraint<type> {
    public boolean verify(Problem<type> problem, Position pos, type variable);
}
