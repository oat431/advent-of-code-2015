package panomete.aoc.problem;

import org.apache.commons.text.StringEscapeUtils;
import panomete.aoc.template.AoCTemplate;

import java.util.List;

public class Day08 implements AoCTemplate<Integer, List<String>> {
    private final int allLength;

    public Day08(List<String> input) {
        this.allLength = input.stream().mapToInt(String::length).sum();
    }

    @Override
    public Integer part1Solution(List<String> input) {
        return this.allLength - input.stream().map(this::extractString).toList().stream().mapToInt(String::length).sum();
    }

    @Override
    public Integer part2Solution(List<String> input) {
        return input.stream().map(this::enhanceString).toList().stream().mapToInt(String::length).sum() - this.allLength;
    }

    public String extractString(String s) {
        return StringEscapeUtils.unescapeJava(s.substring(1, s.length() - 1).replaceAll("\\\\x[0-9a-f]{2}", "a"));
    }

    public String enhanceString(String s) {
        return "\"" +  StringEscapeUtils.escapeJava(s) + "\"";
    }
}
