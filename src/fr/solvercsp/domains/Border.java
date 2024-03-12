package fr.solvercsp.domains;

public class Border {

    private int min;
    private int max;

    public Border(int min, int max){
        this.min = min;
        this.max = max;
    }

    /**
     * Returns if the minimum value is greater than the maximum value.
     * @return True if min > max, false otherwise
     */
    public boolean isEmpty(){
        return min > max;
    }

    /**
     * Returns if the value is in the border.
     * @param i The value to check.
     * @return True if the value is greater than min and lower than max
     */
    public boolean isIn(int i){
        return i >= min && i <= max;
    }

    /**
     * Returns if the border is bound by the given values.
     * Only uses for tests
     * @return True if the border is bound by the given values, false otherwise.
     */
    public boolean isBoundBy(int min, int max){
        return this.min == min && this.max == max;
    }

    /**
     * Returns if min = max
     * @return True if min is equals to max, false otherwise
     */
    public boolean isSingle(){
        return min == max;
    }

    public void intersect(Border border) {
        this.min = Math.max(border.min, min);
        this.max = Math.min(border.max, max);
    }
}
