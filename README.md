# Lab Reflection: Git Version Control + Debugging (BuggyProgram)

## Student Name
Juan A. Pacheco Fuentes

## GitHub Repository URL
https://github.com/gduude007/cmsc115-unit8lab1

---

# Commit 1: Initial Commit

## What did you include in this commit?
- The original starter project: BuggyProgram.java with its three unmodified methods (getGrade, sumEvenNumbers, and sumRange), the JUnit test classes Task1Test, Task2Test, and Task3Test, and this README.md file.

## What was the purpose of this commit?
- To save a baseline version of the project before making any changes. This gives me a starting point I can compare against or return to if a fix goes wrong, and it lets the commit history show exactly what changed in each task.

---

# Commit 2: Task 1 (getGrade)

## Which tests in Task1Test were failing before your fix?
- Three of the five tests failed: highScoreExceeds (95 returned "Meets" instead of "Exceeds"), middleScoreMeets (85 returned "Exceeds" instead of "Meets"), and eightyIsMeets (80 returned "Does Not Meet" instead of "Meets"). ninetyIsExceeds passed only by accident: 90 skipped the first branch and landed in the second one, which wrongly returned "Exceeds".

## What was the issue in the code?
- The return values for the top two categories were swapped, so the highest scores were labeled "Meets" and the middle scores were labeled "Exceeds." The conditions also used "greater than" (score > 90 and score > 80), so a score of exactly 90 or exactly 80 was placed in the category below where it belonged.

## What change did you make to fix it?
- I swapped the return values so the first branch returns "Exceeds" and the nested branch returns "Meets." I also changed the comparisons to "greater than or equal to" (score >= 90 and score >= 80) so the boundary scores are included in the correct category.

## How did the tests help guide your fix?
- The failing tests showed the expected value next to the actual value, which made it clear that the labels were reversed. The boundary test cases showed exactly where each category should start, which I could not have known just from reading the method. They also showed that a passing test does not always mean the code is correct, since the 90 test passed only because two bugs cancelled each other out.

---

# Commit 3: Task 2 (sumEvenNumbers)

## Which tests in Task2Test were failing before your fix?
- All four tests failed: mixedValues, allOddValues, emptyArray, and negativeEvenValues. Every one threw an ArrayIndexOutOfBoundsException before the method could return a result. After I fixed the loop, all four still failed because every sum was one too high (for example, mixedValues expected 12 but got 13).

## What was the issue in the code?
- There were two problems. The loop condition was i <= values.length, which tried to access one index past the end of the array and caused the exception. The sum variable also started at 1 instead of 0, so even after the loop was fixed, every result was one too high.

## What change did you make to fix it?
- I changed the loop condition to i < values.length so it only visits valid indexes, and I changed the starting value of sum from 1 to 0.

## How did the tests help guide your fix?
- The exception in the test output pointed directly to the loop condition, and the index it reported was always equal to the array length. Once that was fixed, re-running the tests showed that every result was off by exactly one, which led me to the incorrect starting value of sum. The second bug was hidden behind the first one until I fixed the loop and ran the tests again.

---

# Commit 4: Task 3 (sumRange)

## Which tests in Task3Test were failing before your fix?
- Only reversedRange failed. It called sumRange(5, 1) and expected 15, but the method returned 0. The other three tests (normalRange, singleValueRange, and rangeWithNegatives) already passed.

## What was the issue in the code?
- The loop only runs while i <= end, so when start was greater than end, the loop never ran and the method returned 0 instead of the sum of the numbers in the range.

## What change did you make to fix it?
- I added a check at the beginning of the method: if start is greater than end, the two values are swapped before the loop runs. This way the method adds every number in the range no matter which order the bounds are given in.

## How did the tests help guide your fix?
- The tests with normal ranges already passed, so the method worked in most cases. Looking at the inputs of the failing test showed that the problem only happened when the bounds were reversed, which narrowed the fix down to handling that one situation.

---

# Overall Reflection

## Which task was the easiest to fix? Why?
- Task 1 was the easiest. Once the tests showed the expected outputs, it was clear the labels were swapped, and the boundary fix only required changing two comparison operators.

## Which task was the most difficult? Why?
- Task 3 was the most difficult because the code looked correct at first glance and most of its tests passed. I had to look closely at the inputs of the failing test to find the one case the method did not handle. Task 2 was also tricky because its second bug stayed hidden until the first one was fixed.

## How did Git help you track your progress through the debugging process?
- Each task had its own commit, so the history on GitHub shows a clear record of what changed and when. If a fix had broken something, I could have compared it to the previous commit or rolled it back without losing my other work.

## Why is it important to make small, frequent commits when debugging code?
- Small commits keep each change focused on one problem, which makes it easier to understand, review, and undo if needed. If a new bug appears, it is much easier to find which change caused it when each commit contains only one fix.

## What did you learn about using JUnit tests to guide debugging?
- Tests define what the code is supposed to do, so they take the guesswork out of debugging. Running them before and after each change showed me exactly what was broken and confirmed when the fix was correct. I also learned to re-run tests after every change, because one bug can hide another, and a test can pass by accident when two bugs cancel each other out.

---

# Commit 5: Final Reflection

## What did you complete or update before making this final commit?
- I completed the Overall Reflection section, checked that my name and GitHub repository URL were entered, and made sure the reflections for all three tasks were filled in.

## Why is it useful to document your work after completing a programming task?
- Documentation explains why changes were made, not just what changed. It helps other developers (and my future self) understand the reasoning behind the fixes, and writing it out helped me review what I learned during the lab.
