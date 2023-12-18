package panomete.aoc;

import panomete.aoc.problem.Day03;
import panomete.aoc.template.AoCTemplate;
import panomete.aoc.utils.Utils;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        AoCTemplate<Integer, String> solution = new Day03();
//        List<String> input = Utils.readInput("input_day_3");
        String input = Utils.readText("input_day_3");
        System.out.println(solution.part1Solution(input));
        System.out.println(solution.part2Solution(input));
    }
}