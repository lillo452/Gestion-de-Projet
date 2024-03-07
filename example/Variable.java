public class Variable<type> {
    private final type variable;
    public Variable(type variable) {
        this.variable = variable;
    }
    public type getVariable(){
        return variable;
    }
}
