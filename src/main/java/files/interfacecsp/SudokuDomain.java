package files.interfacecsp;

import java.util.List;

/**
 * This class represents a generic Domain.
 * @param <Integer> the type of the domain
 * @author Lillo GAVOIS
 * @version 1.0
 */
public class SudokuDomain<Integer> extends Domain<Integer>{
    public SudokuDomain(List<Integer> list) {
        super(list);
    }
}
