package fr.solvercsp;

import fr.solvercsp.domains.IntDomain;

/**
 * This interface represents a generic variable.
 * @author Antony Ferry
 */
public interface Variable {
    /**
     * @see IntDomain#intersectDomain(IntDomain)
     */
    void intersectDomain(Variable variable2);

    void notIntersectDomain(Variable variable2);
}
