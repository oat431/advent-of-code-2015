package panomete.aoc.problem;

import org.apache.commons.codec.digest.DigestUtils;
import panomete.aoc.template.AoCTemplate;


public class Day04 implements AoCTemplate<Integer, String> {
    @Override
    public Integer part1Solution(String input) {
        return hashStartWith(input, "00000");
    }

    @Override
    public Integer part2Solution(String input) {
        return hashStartWith(input, "000000");
    }

    private int hashStartWith(String input, String startWith) {
        int count = 0;
        while(true) {
            String temp = input.concat(String.valueOf(count));
            String hash = DigestUtils.md5Hex(temp);
            if(hash.startsWith(startWith)) {
                break;
            }
            count++;
        }
        return count;
    }
}
