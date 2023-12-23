import org.junit.jupiter.api.Test;
import panomete.aoc.problem.Day08;
import panomete.aoc.utils.Utils;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay08 {

    @Test
    public void testPart1() throws FileNotFoundException {
        List<String> testcase = Utils.readInput("input_day_8_example");
        Day08 solution = new Day08();
        assertEquals(12, solution.part1Solution(testcase));
    }

    @Test
    public void testPart2() throws FileNotFoundException {
        List<String> testcase = Utils.readInput("input_day_8_example");
        Day08 solution = new Day08();
        assertEquals(19, solution.part2Solution(testcase));
    }

}
