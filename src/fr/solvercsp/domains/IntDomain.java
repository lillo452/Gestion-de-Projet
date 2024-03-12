package fr.solvercsp.domains;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Domain with integers
 * @author Antony Ferry
 */
public class IntDomain implements Domain{

    private List<Border> borders = new ArrayList<>();

    /**
     * Constructor for the IntDomain class.
     * @param min The minimum value in the domain.
     * @param max The maximum value in the domain.
     */
    public IntDomain(int min, int max){
        borders.add(new Border(min, max));
        clean();
    }

    /**
     * Returns if the domain is empty. An empty domain is a domain where the minimum value is greater than the maximum value.
     * @return True if the domain is empty, false otherwise.
     */
    public boolean isEmpty(){
        return borders.isEmpty();
    }

    /**
     * Returns if the value is in the domain.
     * @param i The value to check.
     * @return True if the value is in the domain, false otherwise.
     */
    public boolean isIn(int i){
        return borders.stream().anyMatch(border -> border.isIn(i));
    }

    /**
     * Returns if the domain is bound by the given values.
     * Only uses for tests
     * @param min The minimum value to check.
     * @param max The maximum value to check.
     * @param index The index of the border to check.
     * @return True if the domain is bound by the given values, false otherwise.
     */
    public boolean isBoundBy(int index, int min, int max){
        return borders.get(index).isBoundBy(min, max);
    }

    /**
     * Returns if the domain is a single value domain.
     * @return True if the domain is a single value domain, false otherwise.
     */
    public boolean isSingle(){
        return borders.size() == 1 && borders.getFirst().isSingle();
    }

    @Override
    public void intersectDomain(IntDomain domain) {
        for(int i = 0; i < borders.size(); i++){
            borders.get(i).intersect(domain.borders.size() == 1 ? domain.borders.getFirst() : domain.borders.get(i));
        }
        clean();
    }

    public void notIntersectDomain(IntDomain domain){
        /*for(int i = 0; i < borders.size(); i++){
            borders.get(i).notintersect(domain.borders.size() == 1 ? domain.borders.getFirst() : domain.borders.get(i));
        }*/
        //[5; 10] [6; 12] =>
        clean();
    }

    public void clean(){
        borders.removeIf(Border::isEmpty);
    }
}