import org.junit.jupiter.api.Test;
import panomete.aoc.problem.Day07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDay07 {

    @Test
    public void testPart1() {
        List<String> instruction = new ArrayList<>();
        instruction.add("123 -> x");
        instruction.add("456 -> y");
        instruction.add("x AND y -> d");
        instruction.add("x OR y -> e");
        instruction.add("x LSHIFT 2 -> f");
        instruction.add("y RSHIFT 2 -> g");
        instruction.add("NOT x -> h");
        instruction.add("NOT y -> i");

        Day07 solution = new Day07();
        Map<String, Integer> wireMapping = new HashMap<>();
        Pattern p = Pattern.compile("[a-z]+|\\d+");
        for (String instr : instruction) {
            String targetWire = instr.substring(instr.indexOf('>') + 2);

            if (!wireMapping.containsKey(targetWire)) {
                solution.calculateSignal(targetWire, instr.substring(0, instr.indexOf('-') - 1), instruction, wireMapping, p);
            }
        }
        assertEquals(72, wireMapping.get("d"));
        assertEquals(507, wireMapping.get("e"));
        assertEquals(492, wireMapping.get("f"));
        assertEquals(114, wireMapping.get("g"));
        assertEquals(65412, wireMapping.get("h"));
        assertEquals(65079, wireMapping.get("i"));
        assertEquals(123, wireMapping.get("x"));
        assertEquals(456, wireMapping.get("y"));
    }

}
