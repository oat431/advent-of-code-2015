import org.junit.jupiter.api.Test;
import panomete.aoc.problem.Day03;
import panomete.aoc.template.AoCTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay03 {

    @Test
    public void testPart1() {
        AoCTemplate<Integer, String> solution = new Day03();
        String testcase1 = ">";
        String testcase2 = "^>v<";
        String testcase3 = "^v^v^v^v^v";

        assertEquals(2, solution.part1Solution(testcase1));
        assertEquals(4, solution.part1Solution(testcase2));
        assertEquals(2, solution.part1Solution(testcase3));
    }

    @Test
    public void testPart2() {
        AoCTemplate<Integer, String> solution = new Day03();
        String testcase1 = "^v";
        String testcase2 = "^>v<";
        String testcase3 = "^v^v^v^v^v";

        assertEquals(3, solution.part2Solution(testcase1));
        assertEquals(3, solution.part2Solution(testcase2));
        assertEquals(11, solution.part2Solution(testcase3));
    }
}
