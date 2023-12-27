package panomete.aoc.problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day10Test {

    @Test
    void part1Solution() {
        String testcase1 = "1";
        String testcase2 = "11";
        String testcase3 = "21";
        String testcase4 = "1211";
        String testcase5 = "111221";

        assertEquals("11",lookAndSay(testcase1));
        assertEquals("21", lookAndSay(testcase2));
        assertEquals("1211", lookAndSay(testcase3));
        assertEquals("111221", lookAndSay(testcase4));
        assertEquals("312211", lookAndSay(testcase5));
    }

    private String lookAndSay(String input) {
        StringBuilder result = new StringBuilder();
        if(input.length() == 1) {
            return result.append("1").append(input).toString();
        }
        for(int i = 0;i < input.length();i++) {
            int count = 1;
            while(i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                count++;
                i++;
            }
            result.append(count).append(input.charAt(i));
        }
        return result.toString();
    }

    @Test
    void part2Solution() {
    }
}