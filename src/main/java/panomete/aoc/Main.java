package panomete.aoc;

import panomete.aoc.problem.Day1;
import panomete.aoc.solution.Solution;
import panomete.aoc.utils.Utils;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Solution<Integer,String> solution = new Day1();
        String input = Utils.readText("input_day_1");
        System.out.println(solution.part1Solution(input));
        System.out.println(solution.part2Solution(input));
    }
}