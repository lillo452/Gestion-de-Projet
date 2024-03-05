package fr.solvercsp;

/**
 * Class ImplementationVariableCSP is used to compare two variables
 * and return the result of the comparison.
 * It is only use by the solver to compare the variables.
 *
 * @author Wail AMEUR
 * @version 1.0
 */

public class ImplementationVariableCSP {
    /**
     * The Comparison enum represents the possible results of a comparison between two integers.
     * It is used by the compare method in the ImplementationVariableCSP class.
     *
     * EQUAL: Represents that the two integers are equal.
     * LESS: Represents that the first integer is less than the second integer.
     * GREATER: Represents that the first integer is greater than the second integer.
     */
    public enum Comparison {
        EQUAL,
        LESS,
        GREATER
    }

    /**
     * The Comparison enum represents the possible results of a comparison between two integers.
     * It is used by the compare method in the ImplementationVariableCSP class.
     *
     * EQUAL: Represents that the two integers are equal.
     * LESS: Represents that the first integer is less than the second integer.
     * GREATER: Represents that the first integer is greater than the second integer.
     */
    public static Comparison compare(int x, int y) {
        if (x == y) {
            return Comparison.EQUAL;
        } else if (x < y) {
            return Comparison.LESS;
        } else {
            return Comparison.GREATER;
        }
    }

    /**
     * The main method of the ImplementationVariableCSP class.
     * It compares two integers and prints a message to the console based on the result of the comparison.
     *
     * @param args the command line arguments. This parameter is not used in this method.
     */
    public static void main(String[] args) {
        int x = 8;
        int y = 8;

        Comparison result = compare(x, y);

        switch (result) {
            case EQUAL:
                System.out.println("The variables are equal.");
                break;
            case LESS:
                System.out.println("The first variable is less than the second variable.");
                break;
            case GREATER:
                System.out.println("The first variable is greater than the second variable.");
                break;
        }
    }
}