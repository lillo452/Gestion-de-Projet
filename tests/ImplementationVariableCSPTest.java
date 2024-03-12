import fr.solvercsp.ImplementationVariableCSP;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains tests for the ImplementationVariableCSP class.
 * It tests the compare method and the main method of the ImplementationVariableCSP class.
 * The compare method is tested to ensure that it correctly identifies when two integers are equal, less than, or greater than each other.
 * The main method is tested to ensure that it correctly prints a message to the console based on the result of the comparison of two integers.
 *
 * @see ImplementationVariableCSP
 * @author Wail AMEUR
 * @version 1.0
 */
public class ImplementationVariableCSPTest {

    /**
     * This test method tests the compare method of the ImplementationVariableCSP class.
     * It asserts that the compare method correctly identifies when two integers are equal, less than, or greater than each other.
     */
    @Test
    public void testCompare() {
        assertEquals(ImplementationVariableCSP.Comparison.EQUAL, ImplementationVariableCSP.compare(5, 5));
        assertEquals(ImplementationVariableCSP.Comparison.LESS, ImplementationVariableCSP.compare(4, 5));
        assertEquals(ImplementationVariableCSP.Comparison.GREATER, ImplementationVariableCSP.compare(6, 5));
    }

    /**
     * This test method tests the main method of the ImplementationVariableCSP class.
     * It asserts that the main method correctly prints "The variables are equal." when the two compared integers are equal.
     */
    @Test
    public void testMain() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ImplementationVariableCSP.main(new String[]{});

        String printedOutput = outContent.toString();

        assertEquals("The variables are equal." + System.lineSeparator(), printedOutput);
    }
}