public class Triplet<type> {
    private final Problem<type> problem;
    private final Position pos;
    private final Variable<type> variable;

    public Triplet(Problem<type> problem, Position pos, type variable){
        this.problem = problem.makeCopy();
        this.pos = pos.makeCopy();
        this.variable = new Variable<type>(variable);
    }
    public Problem<type> getProblem(){
        return problem;
    }
    public Position getPos(){
        return pos;
    }
    public Variable<type> getVariable(){
        return variable;
    }
}
