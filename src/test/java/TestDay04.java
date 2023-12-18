import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import panomete.aoc.problem.Day04;
import panomete.aoc.template.AoCTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay04 {
    @Test
    public void testPart1() {
        AoCTemplate<Integer, String> solution = new Day04();
        String testcase1 = "abcdef";
        String testcase2 = "pqrstuv";
        assertEquals(609043, solution.part1Solution(testcase1));
        assertEquals(1048970, solution.part1Solution(testcase2));
    }
}
