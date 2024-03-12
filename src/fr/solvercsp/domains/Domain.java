package fr.solvercsp.domains;

/**
 * Domain of a CSP Variable
 * @author Antony Ferry
 */
public interface Domain {

    /**
     * Restricts the domain to the intersection of the current domain and the given domain.
     * @param domain The domain to restrict the current domain to.
     */
    void intersectDomain(IntDomain domain);
}
