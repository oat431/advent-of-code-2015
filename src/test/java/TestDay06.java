import org.junit.jupiter.api.Test;
import panomete.aoc.helper.Day06Helper;
import panomete.aoc.problem.Day05;
import panomete.aoc.problem.Day06;
import panomete.aoc.template.AoCTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay06 {

    @Test
    public void testPart1() {
        AoCTemplate<Integer, List<String>> solution = new Day06();
        String testcase1 = "turn on 0,0 through 999,999";
        String testcase2 = "toggle 0,0 through 999,0";
        String testcase3 = "turn off 499,499 through 500,500";

        assertEquals(1000000, new Day06().part1Solution(List.of(testcase1)));
        assertEquals(1000, new Day06().part1Solution(List.of(testcase2)));
        assertEquals(0, new Day06().part1Solution(List.of(testcase3)));

    }

    @Test
    public void extractInstruction() {
        String example1 = "turn on 489,959 through 759,964";
        String example2 = "turn off 820,516 through 871,914";
        String example3 = "toggle 756,965 through 812,992";

        // testing method
        Day06Helper helper1 = new Day06Helper();

        assertEquals("turn on", helper1.extractInstruction(example1));
        assertEquals("turn off", helper1.extractInstruction(example2));
        assertEquals("toggle", helper1.extractInstruction(example3));

        assertEquals("489,959", helper1.getInitPoint(example1));
        assertEquals("820,516", helper1.getInitPoint(example2));
        assertEquals("756,965", helper1.getInitPoint(example3));

        assertEquals("759,964", helper1.getEndPoint(example1));
        assertEquals("871,914", helper1.getEndPoint(example2));
        assertEquals("812,992", helper1.getEndPoint(example3));

        // testing helper
        Day06Helper helper2 = new Day06Helper(example1);
        Day06Helper helper3 = new Day06Helper(example2);
        Day06Helper helper4 = new Day06Helper(example3);

        assertEquals("turn on", helper2.getInstruction());
        assertEquals("turn off", helper3.getInstruction());
        assertEquals("toggle", helper4.getInstruction());

        assertEquals(489, helper2.getX1());
        assertEquals(959, helper2.getY1());
        assertEquals(759, helper2.getX2());
        assertEquals(964, helper2.getY2());

        assertEquals(820, helper3.getX1());
        assertEquals(516, helper3.getY1());
        assertEquals(871, helper3.getX2());
        assertEquals(914, helper3.getY2());

        assertEquals(756, helper4.getX1());
        assertEquals(965, helper4.getY1());
        assertEquals(812, helper4.getX2());
        assertEquals(992, helper4.getY2());

    }

}
