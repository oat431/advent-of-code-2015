package panomete.aoc;

import panomete.aoc.problem.Day06;
import panomete.aoc.template.AoCTemplate;
import panomete.aoc.utils.Utils;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        AoCTemplate<Integer, List<String>> solution = new Day06();
        List<String> input = Utils.readInput("input_day_6");
        System.out.println(solution.part1Solution(input));
        System.out.println(solution.part2Solution(input));
    }
}