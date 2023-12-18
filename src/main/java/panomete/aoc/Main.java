package panomete.aoc;

import panomete.aoc.problem.Day04;
import panomete.aoc.template.AoCTemplate;
import panomete.aoc.utils.Utils;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        AoCTemplate<Integer, String> solution = new Day04();
        String input = Utils.readText("input_day_4");
        System.out.println(solution.part1Solution(input));
        System.out.println(solution.part2Solution(input));
    }
}