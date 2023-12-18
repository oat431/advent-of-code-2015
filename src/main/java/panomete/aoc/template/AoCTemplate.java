package panomete.aoc.template;

public interface AoCTemplate<AnswerType, InputType> {
    AnswerType part1Solution(InputType input);
    AnswerType part2Solution(InputType input);
}
