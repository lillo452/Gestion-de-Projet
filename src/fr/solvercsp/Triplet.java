public class Triplet {
    private Variable variable;
    private int oldValue;
    private int newValue;

    public Triplet(Variable variable, int oldValue, int newValue) {
        this.variable = variable;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public Variable getVariable() {
        return variable;
    }

    public int getOldValue() {
        return oldValue;
    }

    public int getNewValue() {
        return newValue;
    }
}
