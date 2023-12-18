package panomete.aoc.problem;

import panomete.aoc.solution.Solution;

import java.util.List;

public class Day2 implements Solution<Integer, List<String>> {

    @Override
    public Integer part1Solution(List<String> input) {
        int total = 0;
        for(String line : input) {
            String[] dimensions = line.split("x");
            int l = Integer.parseInt(dimensions[0]);
            int w = Integer.parseInt(dimensions[1]);
            int h = Integer.parseInt(dimensions[2]);
            int min = Math.min(Math.min(l*w, w*h), h*l);
            total += findTotalWrappingPaper(l, w, h) + min;
        }
        return total;
    }

    @Override
    public Integer part2Solution(List<String> input) {
        int total = 0;
        for(String line : input) {
            String[] dimensions = line.split("x");
            int l = Integer.parseInt(dimensions[0]);
            int w = Integer.parseInt(dimensions[1]);
            int h = Integer.parseInt(dimensions[2]);
            int perimeter = findSmallestPerimeter(l, w, h);
            total += findVolume(l, w, h) + perimeter;
        }
        return total;
    }

    private int findTotalWrappingPaper(int l, int w, int h) {
        return 2*l*w + 2*w*h + 2*h*l;
    }

    private int findVolume(int l, int w, int h) {
        return l*w*h;
    }

    private int findSmallestPerimeter(int l, int w, int h) {
        return Math.min(Math.min(2*l + 2*w, 2*w + 2*h), 2*h + 2*l);
    }

}
