package panomete.aoc.problem;

import panomete.aoc.template.AoCTemplate;
import panomete.aoc.utils.Point2D;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day03 implements AoCTemplate<Integer, String> {
    @Override
    public Integer part1Solution(String input) {
        List<Character> direction = toCharList(input);
        Point2D santa = new Point2D(0, 0);
        Set<Point2D> visited = new HashSet<>();
        visited.add(santa);
        for(char c : direction) {
            santa = move(santa, c);
            visited.add(santa);
        }
        return visited.size();
    }

    @Override
    public Integer part2Solution(String input) {
        List<Character> direction = toCharList(input);
        Point2D santa = new Point2D(0, 0);
        Point2D roboSanta = new Point2D(0, 0);
        Set<Point2D> visited = new HashSet<>();
        visited.add(santa);
        for(int i = 0; i < direction.size(); i++) {
            if(i % 2 == 0) {
                santa = move(santa, direction.get(i));
                visited.add(santa);
            } else {
                roboSanta = move(roboSanta, direction.get(i));
                visited.add(roboSanta);
            }
        }
        return visited.size();
    }

    private Point2D move(Point2D santa, char direction) {
        return switch (direction) {
            case '^' -> new Point2D(santa.x(), santa.y() - 1);
            case 'v' -> new Point2D(santa.x(), santa.y() + 1);
            case '>' -> new Point2D(santa.x() + 1, santa.y());
            case '<' -> new Point2D(santa.x() - 1, santa.y());
            default -> null;
        };
    }

    private List<Character> toCharList(String input) {
        List<Character> direction = new ArrayList<>();
        for(char c : input.toCharArray()) {
            direction.add(c);
        }
        return direction;
    }
}
