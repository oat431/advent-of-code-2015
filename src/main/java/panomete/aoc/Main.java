package panomete.aoc;

import panomete.aoc.problem.Day2;
import panomete.aoc.solution.Solution;
import panomete.aoc.utils.Utils;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Solution<Integer, List<String>> solution = new Day2();
        List<String> input = Utils.readInput("input_day_2");
        System.out.println(solution.part1Solution(input));
        System.out.println(solution.part2Solution(input));
    }
}