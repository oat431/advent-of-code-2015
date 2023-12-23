package panomete.aoc.problem;

import panomete.aoc.template.AoCTemplate;

import java.util.List;

public class Day05 implements AoCTemplate<Integer, List<String>> {
    @Override
    public Integer part1Solution(List<String> input) {
        int countNiceString = 0;
        for(String s : input) {
            if(isNiceString(s)) {
                countNiceString++;
            }
        }
        return countNiceString;
    }

    @Override
    public Integer part2Solution(List<String> input) {
        int countNewNiceString = 0;
        for(String s : input) {
            if(isNewNiceString(s)) {
                countNewNiceString++;
            }
        }
        return countNewNiceString;
    }

    public Boolean isNiceString(String input) {
        boolean hasThreeVowels = hasThreeVowels(input);
        boolean hasDoubleLetter = hasDoubleLetter(input);
        boolean hasBadString = false;
        for(int i = 0; i < input.length() - 1; i++) {
            if(hasBadString(input.substring(i, i + 2))) {
                hasBadString = true;
                break;
            }
        }
        return hasThreeVowels && hasDoubleLetter && !hasBadString;
    }

    private boolean hasThreeVowels(String input) {
        int count = 0;
        for(char c : input.toCharArray()) {
            if(isVowel(c)) {
                count++;
            }
        }
        return count >= 3;
    }

    private boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }

    private boolean hasDoubleLetter(String input) {
        for(int i = 0; i < input.length() - 1; i++) {
            if(input.charAt(i) == input.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasBadString(String input) {
        return switch (input) {
            case "ab", "cd", "pq", "xy" -> true;
            default -> false;
        };
    }

    public Boolean isNewNiceString(String input) {
        boolean hasPairOfTwoLetters = false;
        boolean hasLetterRepeatWithOneLetterBetween = false;
        for(int i = 0; i < input.length() - 1; i++) {
            if(hasPairOfTwoLetters(input)) {
                hasPairOfTwoLetters = true;
                break;
            }
        }
        for(int i = 0; i < input.length() - 2; i++) {
            if(hasLetterRepeatWithOneLetterBetween(input)) {
                hasLetterRepeatWithOneLetterBetween = true;
                break;
            }
        }
        return hasPairOfTwoLetters && hasLetterRepeatWithOneLetterBetween;
    }

    public boolean hasPairOfTwoLetters(String input) {
        for(int i = 0; i < input.length() - 1; i++) {
            if(input.substring(i + 2).contains(input.substring(i, i + 2))) {
                return true;
            }
        }
        return false;
    }

    public boolean hasLetterRepeatWithOneLetterBetween(String input) {
        for(int i = 0; i < input.length() - 2; i++) {
            if(input.charAt(i) == input.charAt(i + 2)) {
                return true;
            }
        }
        return false;
    }
}
