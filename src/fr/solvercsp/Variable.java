package fr.solvercsp;

import fr.solvercsp.domains.IntDomain;

/**
 * This interface represents a generic variable.
 * @author Antony Ferry
 */
public interface Variable {
    /**
     * @see IntDomain#restrictDomain(IntDomain)
     */
    void restrictDomain(Variable variable2);
}
