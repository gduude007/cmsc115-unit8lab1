import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Task 1: getGrade (nested conditionals)
public class Task1Test {

    @Test
    public void highScoreExceeds() {
        assertEquals("Exceeds", BuggyProgram.getGrade(95));
    }

    @Test
    public void ninetyIsExceeds() {
        assertEquals("Exceeds", BuggyProgram.getGrade(90));
    }

    @Test
    public void middleScoreMeets() {
        assertEquals("Meets", BuggyProgram.getGrade(85));
    }

    @Test
    public void eightyIsMeets() {
        assertEquals("Meets", BuggyProgram.getGrade(80));
    }

    @Test
    public void lowScoreDoesNotMeet() {
        assertEquals("Does Not Meet", BuggyProgram.getGrade(79));
    }
}
