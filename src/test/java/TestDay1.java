import org.junit.jupiter.api.Test;
import panomete.aoc.problem.Day1;
import panomete.aoc.solution.Solution;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay1 {
    @Test
    public void testPart1() {
        Solution<Integer,String> solution = new Day1();
        assertEquals(0, solution.part1Solution("(())" ));
        assertEquals(0, solution.part1Solution("()()" ));
        assertEquals(3, solution.part1Solution("(((" ));
        assertEquals(3, solution.part1Solution("(()(()(" ));
        assertEquals(-1, solution.part1Solution("())" ));
        assertEquals(-1, solution.part1Solution("))(" ));
        assertEquals(-3, solution.part1Solution(")))" ));
        assertEquals(-3, solution.part1Solution(")())())" ));
    }

    @Test
    public void testPart2() {
        Solution<Integer,String> solution = new Day1();
        assertEquals(1, solution.part2Solution(")" ));
        assertEquals(5, solution.part2Solution("()())" ));
    }
}
