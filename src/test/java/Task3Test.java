import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Task 3: sumRange (loop with bounds)
public class Task3Test {

    @Test
    public void normalRange() {
        assertEquals(15, BuggyProgram.sumRange(1, 5));
    }

    @Test
    public void singleValueRange() {
        assertEquals(7, BuggyProgram.sumRange(7, 7));
    }

    @Test
    public void rangeWithNegatives() {
        assertEquals(0, BuggyProgram.sumRange(-3, 3));
    }

    @Test
    public void reversedRange() {
        assertEquals(15, BuggyProgram.sumRange(5, 1));
    }
}
