package files.interfacecsp;

/**
 * This class represents a generic Variable.
 * @author Charles THIEBAUT
 * @param <type> the type of the variable
 * @version 1.0
 */
public class Variable<type> {
    // The value of the variable
    private final type variable;

    /**
     * Constructs a new Variable with the given value.
     * @param variable the value of the variable
     */
    public Variable(type variable) {
        this.variable = variable;
    }

    /**
     * Returns the value of the variable.
     * @return the value of the variable
     */
    public type getVariable(){
        return variable;
    }
}