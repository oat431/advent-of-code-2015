package panomete.aoc.problem;

import panomete.aoc.solution.Solution;

public class Day1 implements Solution<Integer, String> {

    @Override
    public Integer part1Solution(String input) {
        return input.chars().map(c -> c == '(' ? 1 : -1).sum();
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
