package fr.solvercsp;

import fr.solvercsp.constraints.Constraint;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solver {

    private final List<Constraint> constraintList;
    private final List<Variable> variables;

    public Solver(List<Variable> variables, List<Constraint> constraints){
        this.variables = variables;
        this.constraintList = constraints;
    }

    public void solve(){
        Stack<Variable> variableStack = new Stack<>();
        Stack<Variable> variables = new Stack<>();

        variables.addAll(this.variables);
        variableStack.push(variables.pop());
        while(!variableStack.isEmpty()) {
            for(Variable variable : this.variables){
                variable.save();
            }

            Variable current = variableStack.peek();
            current.fixValue();
            for (Constraint constraint : constraintList) {
                constraint.filter();
            }
            if(!backtrack()) variableStack.push(variables.pop());
            else variables.push(variableStack.pop());

        }
    }

    /**
     * Use CSP backtracking
     * @return true if backtrack has been done, false otherwise
     */
    private boolean backtrack(){
        for(Variable variable : this.variables){
            if(variable.isEmpty()){
                for(Variable variable1 : this.variables){
                    variable1.undo();
                }
                return true;
            }
        }
        return false;
    }

}
