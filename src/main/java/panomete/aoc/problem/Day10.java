package panomete.aoc.problem;

import panomete.aoc.template.AoCTemplate;

public class Day10 implements AoCTemplate<Integer, String> {
    @Override
    public Integer part1Solution(String input) {
        for(int i = 0;i < 40;i++) {
            input = lookAndSay(input);
        }
        return input.length();
    }

    @Override
    public Integer part2Solution(String input) {
        for(int i = 0;i < 50;i++) {
            input = lookAndSay(input);
        }
        return input.length();
    }

    private String lookAndSay(String input) {
        StringBuilder result = new StringBuilder();
        if(input.length() == 1) {
            return result.append("1").append(input).toString();
        }
        for(int i = 0;i < input.length();i++) {
            int count = 1;
            while(i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                count++;
                i++;
            }
            result.append(count).append(input.charAt(i));
        }
        return result.toString();
    }
}
