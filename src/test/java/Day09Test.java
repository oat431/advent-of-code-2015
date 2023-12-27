import org.junit.jupiter.api.Test;
import panomete.aoc.problem.Day09;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class Day09Test {

    private Map<String,Map<String,Integer>> allRoute = new HashMap<>();
    private Set<String> route = new HashSet<>();
    @Test
    void part1Solution() {
        List<String> example = List.of(
                "London to Dublin = 464",
                "London to Belfast = 518",
                "Dublin to Belfast = 141"
        );

        for(String s : example) {
            String[] split = s.split(" ");
            String from = split[0];
            String to = split[2];
            int distance = Integer.parseInt(split[4]);
            allRoute.putIfAbsent(from, new HashMap<>());
            allRoute.putIfAbsent(to, new HashMap<>());
            allRoute.get(from).put(to, distance);
            allRoute.get(to).put(from, distance);
            route.add(from);
            route.add(to);
        }

        Set<Integer> distances = permutations(route).stream().map(this::distance).collect(Collectors.toSet());
        assertEquals(605, Collections.min(distances));
    }

    private int distance(List<String> names) {
        int distance = 0;
        for(int i = 0;i < names.size() - 1;i++) {
            String n1 = names.get(i);
            String n2 = names.get(i + 1);

            if(allRoute.containsKey(n1) && allRoute.get(n1).containsKey(n2)) {
                distance += allRoute.get(n1).get(n2);
            }
            else {
                distance += allRoute.get(n2).get(n1);
            }
        }

        return distance;
    }

    public static List<List<String>> permutations(Collection<String> names) {
        List<List<String>> permutations = new ArrayList<>();

        permutations(new ArrayList<>(), new ArrayList<>(names), permutations);

        return permutations;
    }

    public static void permutations(List<String> head, List<String> tail, List<List<String>> permutations) {
        if(tail.isEmpty()) {
            permutations.add(head);
            return;
        }
        for(int i = 0;i < tail.size();i++) {
            List<String> newHead = new ArrayList<>(head.size() + 1);
            List<String> newTail = new ArrayList<>(tail);

            newHead.addAll(head);
            newHead.add(newTail.remove(i));

            permutations(newHead, newTail, permutations);
        }
    }
    @Test
    void part2Solution() {
        List<String> example = List.of(
                "London to Dublin = 464",
                "London to Belfast = 518",
                "Dublin to Belfast = 141"
        );

        for(String s : example) {
            String[] split = s.split(" ");
            String from = split[0];
            String to = split[2];
            int distance = Integer.parseInt(split[4]);
            allRoute.putIfAbsent(from, new HashMap<>());
            allRoute.putIfAbsent(to, new HashMap<>());
            allRoute.get(from).put(to, distance);
            allRoute.get(to).put(from, distance);
            route.add(from);
            route.add(to);
        }

        Set<Integer> distances = permutations(route).stream().map(this::distance).collect(Collectors.toSet());
        assertEquals(982, Collections.max(distances));
    }
}