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
        List<Triplet> triplets = new ArrayList<>();
        for (Variable variable : variables) {
            triplets.add(new Triplet(variable, variable.getValue(), variable.getValue()));
        }
        this.backtrackingPile.pushPile(new SolverState(triplets, constraints));
    }

        public void popState() {
        SolverState prevState = (SolverState) this.backtrackingPile.getTopPile();
        List<Triplet> triplets = prevState.getTriplets();
        for (Triplet triplet : triplets) {
            triplet.getVariable().setValue(triplet.getOldValue());
        }
        this.variables = new ArrayList<>(prevState.getVariables());
        this.constraints = new ArrayList<>(prevState.getConstraints());
        this.backtrackingPile.pullPile();
    }

        private static class SolverState {
        private final List<Triplet> triplets;
        private final List<Variable> variables;
        private final List<Constraint> constraints;

        public SolverState(List<Triplet> triplets, List<Variable> variables, List<Constraint> constraints) {
            this.triplets = new ArrayList<>(triplets);
            this.variables = new ArrayList<>(variables);
            this.constraints = new ArrayList<>(constraints);
    }

        public List<Triplet> getTriplets() {
            return triplets;
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
