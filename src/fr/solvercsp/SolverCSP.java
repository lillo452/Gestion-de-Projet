package fr.solvercsp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lillo G.
 * @version 1.0
 */

public class SolverCSP {

    private List<Variable> variables;
    private List<Constraint> constraints;
    private PileBacktracking backtrackingPile;

    public SolverCSP() {
        this.variables = new ArrayList<>();
        this.constraints = new ArrayList<>();
        this.backtrackingPile = new PileBacktracking();
    }

    public void addVariable(Variable variable) {
        this.variables.add(variable);
    }

    public void addConstraint(Constraint constraint) {
        this.constraints.add(constraint);
    }

    public void pushState() {
        this.backtrackingPile.pushPile(new SolverState(variables, constraints));
    }

    public void popState() {
        SolverState prevState = (SolverState) this.backtrackingPile.getTopPile();
        this.variables = new ArrayList<>(prevState.getVariables());
        this.constraints = new ArrayList<>(prevState.getConstraints());
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
}