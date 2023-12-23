package panomete.aoc.problem;

import panomete.aoc.template.AoCTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day07 implements AoCTemplate<Integer, List<String>> {

    private final Pattern p = Pattern.compile("[a-z]+|\\d+"); // global pattern

    private Integer aValue; // for part 2
    private Integer bIndex; // for part 2

    @Override
    public Integer part1Solution(List<String> input) {
        Map<String, Integer> wireMapping = new HashMap<>();
        int index = 0; // for part 2
        for (String instr : input) {
            String targetWire = instr.substring(instr.indexOf('>') + 2);
            if(targetWire.equals("b")) { // for part 2
                bIndex = index;
            }
            if (!wireMapping.containsKey(targetWire)) {
                calculateSignal(targetWire, instr.substring(0, instr.indexOf('-') - 1), input, wireMapping, p);
            }
            index++; // for part 2
        }
        aValue = wireMapping.get("a");
        return aValue;
    }

    @Override
    public Integer part2Solution(List<String> input) {
        input.set(bIndex, aValue + " -> b");
        Map<String, Integer> wireMapping = new HashMap<>();
        for (String instr : input) {
            String targetWire = instr.substring(instr.indexOf('>') + 2);
            if (!wireMapping.containsKey(targetWire)) {
                calculateSignal(targetWire, instr.substring(0, instr.indexOf('-') - 1), input, wireMapping, p);
            }
        }
        return wireMapping.get("a");
    }

    public void calculateSignal(
            String targetWire,
            String instr,
            List<String> instructions,
            Map<String, Integer> wireMapping,
            Pattern paramPattern
    ) {

        if (wireMapping.containsKey(targetWire)) {
            return;
        }

        Matcher m = paramPattern.matcher(instr);
        List<String> params = params(instr, m);

        if (params.size() == 1 && params.get(0).matches("\\d+")) {
            wireMapping.put(targetWire, Integer.parseInt(params.get(0)));
            return;
        }

        for (String param : params) {
            if (!param.matches("\\d+")) {
                String target = instructions.stream().filter(
                        s -> s.substring(s.indexOf('>') + 2).equals(param))
                        .findFirst().get();
                if (!wireMapping.containsKey(param))
                    calculateSignal(
                            param,
                            target.substring(0, target.indexOf('-') - 1),
                            instructions,
                            wireMapping,
                            paramPattern
                    );
            } else {
                wireMapping.put(param, Integer.parseInt(param));
            }
        }

        // calculate signal for this wire
        if (instr.contains("AND")) {
            wireMapping.put(targetWire, wireMapping.get(params.get(0)) & wireMapping.get(params.get(1)));
        } else if (instr.contains("OR")) {
            wireMapping.put(targetWire, wireMapping.get(params.get(0)) | wireMapping.get(params.get(1)));
        } else if (instr.contains("NOT")) {
            wireMapping.put(targetWire, ~wireMapping.get(params.get(0)) & 0xFFFF);
        } else if (instr.contains("LSHIFT")) {
            wireMapping.put(targetWire, wireMapping.get(params.get(0)) << wireMapping.get(params.get(1)));
        } else if (instr.contains("RSHIFT")) {
            wireMapping.put(targetWire, wireMapping.get(params.get(0)) >> wireMapping.get(params.get(1)));
        } else {
            wireMapping.put(targetWire, wireMapping.get(params.get(0)));
        }
    }

    private List<String> params(String instr, Matcher m) {
        List<String> params = new ArrayList<>();
        while (m.find()) {
            params.add(m.group());
        }
        return params;
    }
}
