package panomete.aoc.problem;

import panomete.aoc.solution.Solution;

import java.util.List;

public class Day1 implements Solution<Integer, String> {

    @Override
    public Integer part1Solution(String input) {
        int floor = 0;
        for (char c : input.toCharArray()) {
            floor += c == '(' ? 1 : -1;
        }
        return floor;
    }

    @Override
    public Integer part2Solution(String input) {
        int floor = 0;
        int idx = 0;
        for(char c : input.toCharArray()) {
            floor += c == '(' ? 1 : -1;
            idx++;
            if(floor == -1)
                return idx;
        }
        return -1;
    }
}
