import org.junit.jupiter.api.Test;
import panomete.aoc.problem.Day01;
import panomete.aoc.template.AoCTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay01 {
    @Test
    public void testPart1() {
        AoCTemplate<Integer,String> solution = new Day01();
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
        AoCTemplate<Integer,String> solution = new Day01();
        assertEquals(1, solution.part2Solution(")" ));
        assertEquals(5, solution.part2Solution("()())" ));
    }
}
