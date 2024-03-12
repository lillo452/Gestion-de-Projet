package fr.solvercsp.domains;

import java.util.List;

/**
 * Domain of a CSP
 */
public interface Domain {

    void restrictDomain(IntDomain domain);
}
