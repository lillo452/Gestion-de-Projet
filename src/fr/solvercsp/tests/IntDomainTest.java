package fr.solvercsp.tests;

import fr.solvercsp.domains.IntDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void restrictDomain() {
        IntDomain domain = new IntDomain(5, 10);
        domain.restrictDomain(new IntDomain(7, 12));
        assertTrue(domain.isBoundBy(7, 10));
        domain.restrictDomain(new IntDomain(3, 6));
        assertTrue(domain.isEmpty());
    }
}