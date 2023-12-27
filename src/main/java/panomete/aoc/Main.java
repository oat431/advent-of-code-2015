package panomete.aoc;

import panomete.aoc.problem.Day10;
import panomete.aoc.template.AoCTemplate;
import panomete.aoc.utils.Utils;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String input = Utils.readText("input_day_10");
        AoCTemplate<Integer, String> solution = new Day10();
        System.out.println(solution.part1Solution(input));
        System.out.println(solution.part2Solution(input));
    }
}