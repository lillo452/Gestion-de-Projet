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

    /**
     * Save the current domain
     * @see Variable#undo()
     */
    void save();

    /**
     * Undo the last domain saved by {@link #save()}
     * @see Variable#save()
     */
    void undo();

    void fixValue();

    boolean isEmpty();
}
