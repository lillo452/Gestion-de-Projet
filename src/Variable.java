package solver;

import java.util.Stack;

/**
 * @author Frank Leggett
 * @param <Type>
 * takes custom type as defined in SolverCSP class
 */
public class Variable<Type> {
    private Stack<Type> varStack;
    public Variable(Stack varStack){
        this.varStack = varStack;
    }

    /**
     * @return stack of Type
     */
    public Stack getStack(){
        return this.varStack;
    }

    /**
     * adds variable of Type to top of Stack
     * @param t
     */
    public void addFst(Type t){
        varStack.add(t);
    }

    /**
     * @return top element of Stack
     */
    public Type getFst(){
        return varStack.pop();
    }
}
