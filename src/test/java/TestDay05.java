import org.junit.jupiter.api.Test;
import panomete.aoc.problem.Day05;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay05 {

    @Test
    public void testPart1() {
        String testcase1 = "ugknbfddgicrmopn";
        String testcase2 = "aaa";
        String testcase3 = "jchzalrnumimnmhp";
        String testcase4 = "haegwjzuvuyypxyu";
        String testcase5 = "dvszwmarrgswjxmb";

        assertEquals(true, new Day05().isNiceString(testcase1));
        assertEquals(true, new Day05().isNiceString(testcase2));
        assertEquals(false, new Day05().isNiceString(testcase3));
        assertEquals(false, new Day05().isNiceString(testcase4));
        assertEquals(false, new Day05().isNiceString(testcase5));
    }

    @Test
    public void testPart2() {
        String testcase1 = "qjhvhtzxzqqjkmpb";
        String testcase2 = "xxyxx";
        String testcase3 = "uurcxstgmygtbstg";
        String testcase4 = "ieodomkazucvgmuy";

        assertEquals(true, new Day05().isNewNiceString(testcase1));
        assertEquals(true, new Day05().isNewNiceString(testcase2));
        assertEquals(false, new Day05().isNewNiceString(testcase3));
        assertEquals(false, new Day05().isNewNiceString(testcase4));
    }
}
