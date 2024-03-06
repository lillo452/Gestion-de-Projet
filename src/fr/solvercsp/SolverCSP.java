package fr.solvercsp;

import fr.solvercsp.constraints.Constraint;
import fr.solvercsp.constraints.RelationConstraint;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Class SolverCSP is the main class of the solver.
 * It is used to solve the CSP problem.
 * It contains the variables, the constraints and the backtracking pile.
 * @author Lillo G.
 * @version 1.0
 */

public class SolverCSP {

    private static Stack<List<Variable>> variablesStack;
    private Stack<List<Constraint>> constraintsStack;
    private PileBacktracking backtrackingPile;
    private List<Variable> variables;
    private List<Constraint> constraints;

    /**
     * Constructor for SolverCSP.
     * Initializes the stacks, backtracking pile, and lists of variables and constraints.
     */
    public SolverCSP() {
        this.variablesStack = new Stack<>();
        this.constraintsStack = new Stack<>();
        this.variablesStack.push(new ArrayList<>());
        this.constraintsStack.push(new ArrayList<>());
        this.backtrackingPile = new PileBacktracking();
        this.variables = new ArrayList<>();
        this.constraints = new ArrayList<>();
    }

    /**
     * Adds a variable to the current list of variables and pushes the updated list to the stack.
     *
     * @param variable The variable to be added
     */
    public void addVariable(Variable variable) {
        List<Variable> currentVariables = new ArrayList<>(variablesStack.peek());
        currentVariables.add(variable);
        variablesStack.push(currentVariables);
    }

    /**
     * Adds a constraint to the current list of constraints and pushes the updated list to the stack.
     *
     * @param constraint The constraint to be added
     */
    public void addConstraint(Constraint constraint) {
        List<Constraint> currentConstraints = new ArrayList<>(constraintsStack.peek());
        currentConstraints.add(constraint);
        constraintsStack.push(currentConstraints);
    }

    /**
     * Pushes the current state of the solver to the backtracking pile.
     * The state includes the current values of all variables and the current constraints.
     */
    public void pushState() {
        List<Triplet> triplets = new ArrayList<>();
        for (Variable variable : variables) {
            triplets.add(new Triplet(variable, (Integer) variable.getValue(), (Integer) variable.getValue()));
        }
        this.backtrackingPile.pushPile(new SolverState(triplets, variables, constraints));
    }

    /**
     * Pops the top state from the backtracking pile and restores the variables and constraints to that state.
     */
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

    /**
     * Returns the current list of variables.
     *
     * @return The current list of variables
     */
    public List<Variable> getVariables() {
        return variablesStack.peek();
    }

    /**
     * Returns the current list of constraints.
     *
     * @return The current list of constraints
     */
    public List<Constraint> getConstraints() {
        return constraintsStack.peek();
    }

    /**
     * Inner class representing a state of the solver.
     * A state includes the current values of all variables and the current constraints.
     */
    private static class SolverState {
        private final List<Triplet> triplets;
        private List<Variable> variables = null;
        private final List<Constraint> constraints;

        /**
         * Constructor for SolverState.
         *
         * @param triplets The current values of all variables
         * @param constraints The current constraints
         */
        public SolverState(List<Triplet> triplets, List<Variable> variables, List<Constraint> constraints) {
            this.triplets = new ArrayList<>(triplets);
            this.variables = new ArrayList<>(variables);
            this.constraints = new ArrayList<>(constraints);
    }

        /**
         * Returns the list of triplets representing the current values of all variables.
         *
         * @return The list of triplets
         */
        public List<Triplet> getTriplets() {
            return triplets;
        }

        /**
         * Returns the list of variables.
         *
         * @return The list of variables
         */
        public List<Variable> getVariables() {
            return variables;
        }

        /**
         * Returns the list of constraints.
         *
         * @return The list of constraints
         */
        public List<Constraint> getConstraints() {
            return constraints;
        }

    }

    /**
     * Adds a relation constraint to the solver.
     *
     * @param variable1 The first variable in the relation
     * @param relationOperator The operator of the relation
     * @param variable2 The second variable in the relation
     */
    public void addRelationConstraint(Variable variable1, String relationOperator, Variable variable2) {
    RelationConstraint relationConstraint = new RelationConstraint();
    addConstraint(relationConstraint);
    }
}