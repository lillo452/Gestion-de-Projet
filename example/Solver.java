import java.util.List;
import java.util.Stack;
public class Solver<type> {
    private Problem<type> problem;
    private final List<Constraint<type>> constraintList;
    private final Domain<type> domain;
    private final Stack<Triplet<type>> backtrackingStack = new Stack<>();
    private Variable<type> variable;
    public Solver(Problem<type> problem, List<Constraint<type>> constraintList, Domain<type> domain){
        this.problem = problem;
        this.constraintList = constraintList;
        this.domain = domain;
    }
    public void setProblem(Problem<type> problem){
        this.problem = problem;
    }
    public void setVariable(Variable<type> variable){
        this.variable = variable;
    }
    public boolean callBacktrack(){
        boolean child_answer = false;
        Solver<type> child = new Solver<type>(problem, constraintList, domain);
        while(!child_answer && !backtrackingStack.isEmpty()) {
            Triplet<type> triplet = backtrackingStack.pop();
            triplet.getProblem().setPos(triplet.getPos());
            child.setProblem(triplet.getProblem());
            child.setVariable(triplet.getVariable());

            child_answer = child.solving();

        }
        return child_answer;
    }
    public boolean solving(){
        boolean result = false;
        boolean the_end = false;
        while(!the_end){
            boolean ok_variable = false;
            int var_pos = 0;
            while(!ok_variable && !domain.isEnd(var_pos)) {
                type dom_var = domain.get(var_pos);
                if (dom_var != variable) {
                    boolean constraint_verification = true;
                    for (Constraint<type> constraint : constraintList) {
                        constraint_verification = constraint_verification && constraint.verify(problem, problem.getPos(), dom_var);
                    }
                    ok_variable = constraint_verification;
                    if (ok_variable) {
                        problem.setValue(dom_var);
                        Triplet<type> triplet = new Triplet<type>(problem, problem.getPos(), dom_var);
                        backtrackingStack.push(triplet);
                        problem.nextPos();
                    }
                    else {
                        var_pos++;
                    }
                }
                else{
                    var_pos++;
                }
                if (domain.isEnd(var_pos)) {
                    result = callBacktrack();
                    the_end = true;
                }
                if (problem.isEnd()) {
                    result = true;
                    the_end = true;
                }
            }
        }
        return result;
    }

    public void solve(){
        problem.print();
        if(!solving()){
            System.out.println("could not solve \n");
        }
        System.out.println("\n");
        problem.print();
    }
}
