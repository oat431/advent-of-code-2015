package panomete.aoc.problem;

import panomete.aoc.helper.Day06Helper;
import panomete.aoc.template.AoCTemplate;

import java.util.List;

public class Day06 implements AoCTemplate<Integer, List<String>> {
    @Override
    public Integer part1Solution(List<String> input) {
        boolean[][] light = new boolean[1000][1000];
        for(String instruction : input) {
            Day06Helper helper = new Day06Helper(instruction);
            switch (helper.getInstruction()) {
                case "turn on":
                    turnOn(light, helper.getX1(), helper.getY1(), helper.getX2(), helper.getY2());
                    break;
                case "turn off":
                    turnOff(light, helper.getX1(), helper.getY1(), helper.getX2(), helper.getY2());
                    break;
                case "toggle":
                    toggle(light, helper.getX1(), helper.getY1(), helper.getX2(), helper.getY2());
                    break;
            }
        }
        int count = 0;
        for (boolean[] row : light) {
            for (boolean col : row) {
                if (col) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public Integer part2Solution(List<String> input) {
        int[][] light = new int[1000][1000];
        for(String instruction : input) {
            Day06Helper helper = new Day06Helper(instruction);
            switch (helper.getInstruction()) {
                case "turn on":
                    turnOn(light, helper.getX1(), helper.getY1(), helper.getX2(), helper.getY2());
                    break;
                case "turn off":
                    turnOff(light, helper.getX1(), helper.getY1(), helper.getX2(), helper.getY2());
                    break;
                case "toggle":
                    toggle(light, helper.getX1(), helper.getY1(), helper.getX2(), helper.getY2());
                    break;
            }
        }
        int count = 0;
        for (int[] row : light) {
            for (int col : row) {
                count += col;
            }
        }
        return count;
    }

    public void turnOn(boolean[][] light, int x1, int y1, int x2, int y2) {
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                light[i][j] = true;
            }
        }
    }

    public void turnOff(boolean[][] light, int x1, int y1, int x2, int y2) {
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                light[i][j] = false;
            }
        }
    }

    public void toggle(boolean[][] light, int x1, int y1, int x2, int y2) {
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                light[i][j] = !light[i][j];
            }
        }
    }

    public void turnOn(int[][] light, int x1, int y1, int x2, int y2) {
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                light[i][j]++;
            }
        }
    }

    public void turnOff(int[][] light, int x1, int y1, int x2, int y2) {
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                if(light[i][j] > 0) {
                    light[i][j]--;
                }
            }
        }
    }

    public void toggle(int[][] light, int x1, int y1, int x2, int y2) {
        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                light[i][j] += 2;
            }
        }
    }
}
