package fr.solvercsp;

import java.util.List;

/**
 * Domain of a CSP
 * @param <T> type of variables's value
 */
public interface Domain<T> {

    List<T> getValues();

}
