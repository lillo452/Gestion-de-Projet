package fr.solvercsp;

import java.util.ArrayList;
import java.util.List;

/**
 * Class SolverCSP is the main class of the solver.
 * It is used to solve the CSP problem.
 * It contains the variables, the constraints and the backtracking pile.
 * @author Lillo G.
 * @version 1.0
 */

public class SolverCSP {

    private Stack<List<Variable>> variablesStack;
    private Stack<List<Constraint>> constraintsStack;
    private PileBacktracking backtrackingPile;
    
    public SolverCSP() {
        this.variablesStack = new Stack<>();
        this.constraintsStack = new Stack<>();
        this.variablesStack.push(new ArrayList<>()); // Initialisation avec une liste vide au départ
        this.constraintsStack.push(new ArrayList<>()); // Initialisation avec une liste vide au départ
        this.backtrackingPile = new PileBacktracking();
    }


        public void addVariable(Variable variable) {
        List<Variable> currentVariables = new ArrayList<>(variablesStack.peek());
        currentVariables.add(variable);
        variablesStack.push(currentVariables);
    }

        public void addConstraint(Constraint constraint) {
        List<Constraint> currentConstraints = new ArrayList<>(constraintsStack.peek());
        currentConstraints.add(constraint);
        constraintsStack.push(currentConstraints);
    }

        public void pushState() {
        variablesStack.push(new ArrayList<>(variablesStack.peek()));
        constraintsStack.push(new ArrayList<>(constraintsStack.peek()));
        this.backtrackingPile.pushPile(new SolverState(variablesStack.peek(), constraintsStack.peek()));
    }

        public void popState() {
        if (variablesStack.size() > 1 && constraintsStack.size() > 1) {
            variablesStack.pop();
            constraintsStack.pop();
        } else {
            System.out.println("Erreur");
            }
        this.backtrackingPile.pullPile();
    }

    private static class SolverState {
        private final List<Variable> variables;
        private final List<Constraint> constraints;

        public SolverState(List<Variable> variables, List<Constraint> constraints) {
            this.variables = new ArrayList<>(variables);
            this.constraints = new ArrayList<>(constraints);
        }

        public List<Variable> getVariables() {
            return variables;
        }

        public List<Constraint> getConstraints() {
            return constraints;
        }
    }
    public void addRelationConstraint(Variable variable1, String relationOperator, Variable variable2) {
    RelationConstraint relationConstraint = new RelationConstraint(variable1, relationOperator, variable2);
    addConstraint(relationConstraint);
    }
}
