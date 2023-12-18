import org.junit.jupiter.api.Test;
import panomete.aoc.problem.Day2;
import panomete.aoc.solution.Solution;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay2 {

    @Test
    public void testPart1() {
        Solution<Integer, List<String>> solution = new Day2();
        List<String> testcase1 = List.of("2x3x4");
        List<String> testcase2 = List.of("1x1x10");

        assertEquals(58, solution.part1Solution(testcase1));
        assertEquals(43, solution.part1Solution(testcase2));
    }

    @Test
    public void testPart2() {
        Solution<Integer, List<String>> solution = new Day2();
        List<String> testcase1 = List.of("2x3x4");
        List<String> testcase2 = List.of("1x1x10");

        assertEquals(34, solution.part2Solution(testcase1));
        assertEquals(14, solution.part2Solution(testcase2));
    }
}
