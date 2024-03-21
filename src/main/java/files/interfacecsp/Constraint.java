package files.interfacecsp;

public interface Constraint<type> {
    public boolean verify(Problem<type> problem, Position pos, type variable);
}
