package panomete.aoc.problem;

import panomete.aoc.template.AoCTemplate;

import java.util.List;

public class Day08 implements AoCTemplate<Integer, List<String>> {
    @Override
    public Integer part1Solution(List<String> input) {
        int totalLength = input.stream().mapToInt(String::length).sum();
        List<String> normalString = input.stream().map(this::extractWholeString).toList();
        int onlyStringLength = normalString.stream().mapToInt(String::length).sum();
        return totalLength - onlyStringLength;
    }

    @Override
    public Integer part2Solution(List<String> input) {
        int totalLength = input.stream().mapToInt(String::length).sum();
        List<String> enhancedString = input.stream().map(this::enhanceString).toList();
        int enhancedStringLength = enhancedString.stream().mapToInt(String::length).sum();
        return enhancedStringLength - totalLength;
    }

    public String extractWholeString(String s) {
        String normal = s.substring(1, s.length() - 1);
        normal = normal.replaceAll("\\\\\"", "\"");
        normal = normal.replaceAll("\\\\\\\\", "\\\\");
        normal = normal.replaceAll("\\\\x[0-9a-f]{2}", "a");
        return normal;
    }

    public String enhanceString(String s) {
        String enhanced = s.replaceAll("\\\\", "\\\\\\\\");
        enhanced = enhanced.replaceAll("\"", "\\\\\"");
        return "\"" + enhanced + "\"";
    }
}
