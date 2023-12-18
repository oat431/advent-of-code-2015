package panomete.aoc.solution;

public interface Solution<AnswerType, InputType> {
    AnswerType part1Solution(InputType input);
    AnswerType part2Solution(InputType input);
}
