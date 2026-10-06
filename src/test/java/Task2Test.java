import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Task 2: sumEvenNumbers (loop with array)
public class Task2Test {

    @Test
    public void mixedValues() {
        assertEquals(12, BuggyProgram.sumEvenNumbers(new int[]{1, 2, 3, 4, 6}));
    }

    @Test
    public void allOddValues() {
        assertEquals(0, BuggyProgram.sumEvenNumbers(new int[]{1, 3, 5}));
    }

    @Test
    public void emptyArray() {
        assertEquals(0, BuggyProgram.sumEvenNumbers(new int[]{}));
    }

    @Test
    public void negativeEvenValues() {
        assertEquals(-6, BuggyProgram.sumEvenNumbers(new int[]{-2, -4, 7}));
    }
}
