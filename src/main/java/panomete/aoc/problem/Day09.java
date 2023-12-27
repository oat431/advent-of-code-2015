package panomete.aoc.problem;

import panomete.aoc.template.AoCTemplate;

import java.util.*;
import java.util.stream.Collectors;

public class Day09 implements AoCTemplate<Integer, List<String>> {
    private final Map<String, Map<String, Integer>> allRoute = new HashMap<>();
    private final Set<String> route = new HashSet<>();

    public Day09(List<String> input) {
        convertInput(input);
    }

    @Override
    public Integer part1Solution(List<String> input) {
        return Collections.min(permutations(route).stream().map(this::distance).collect(Collectors.toSet()));
    }

    @Override
    public Integer part2Solution(List<String> input) {
        return Collections.max(permutations(route).stream().map(this::distance).collect(Collectors.toSet()));
    }

    public void convertInput(List<String> input) {
        for(String s : input) {
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
    }

    public int distance(List<String> names) {
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
}
