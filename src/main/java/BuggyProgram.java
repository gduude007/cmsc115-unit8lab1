public class BuggyProgram {

    // Method 1: nested conditionals
    public static String getGrade(int score) {
        if (score > 90) {
            return "Meets";
        } else {
            if (score > 80) {
                return "Exceeds";
            } else {
                return "Does Not Meet";
            }
        }
    }

    // Method 2: loop with array
    public static int sumEvenNumbers(int[] values) {
        int sum = 1;

        for (int i = 0; i <= values.length; i++) {
            if (values[i] % 2 == 0) {
                sum += values[i];
            }
        }

        return sum;
    }

    // Method 3: loop with bounds (no array)
    public static int sumRange(int start, int end) {
        int sum = 0;

        for (int i = start; i <= end; i++) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args ){
        System.out.println("Test the program using the JUnit tests");
    }
    
}
