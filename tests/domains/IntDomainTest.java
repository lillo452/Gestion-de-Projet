package domains;

import fr.solvercsp.domains.IntDomain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Antony Ferry
 */
class IntDomainTest {

    @Test
    void isEmpty() {
        IntDomain domain = new IntDomain(10, 5);
        assertTrue(domain.isEmpty());
        domain = new IntDomain(5, 10);
        assertFalse(domain.isEmpty());
    }

    @Test
    void isIn() {
        IntDomain domain = new IntDomain(5, 10);
        assertTrue(domain.isIn(5));
        assertTrue(domain.isIn(10));
        assertTrue(domain.isIn(7));
        assertFalse(domain.isIn(4));
        assertFalse(domain.isIn(11));
    }

    @Test
    void isSingle() {
        IntDomain domain = new IntDomain(5, 5);
        assertTrue(domain.isSingle());
        domain = new IntDomain(5, 10);
        assertFalse(domain.isSingle());
    }

    @Test
    void intersectDomain() {
        IntDomain domain = new IntDomain(5, 10);
        domain.intersectDomain(new IntDomain(7, 12));
        assertTrue(domain.isBoundBy(0, 7, 10));
        domain.intersectDomain(new IntDomain(3, 6));
        assertTrue(domain.isEmpty());
    }
}