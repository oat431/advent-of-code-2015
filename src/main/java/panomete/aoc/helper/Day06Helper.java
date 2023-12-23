package panomete.aoc.helper;

public class Day06Helper {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    private String instruction;

    public Day06Helper(String instruction) {
        this.instruction = extractInstruction(instruction);
        String[] initPoint = getInitPoint(instruction).split(",");
        String[] endPoint = getEndPoint(instruction).split(",");
        this.x1 = Integer.parseInt(initPoint[0]);
        this.x2 = Integer.parseInt(endPoint[0]);
        this.y1 = Integer.parseInt(initPoint[1]);
        this.y2 = Integer.parseInt(endPoint[1]);
    }

    public Day06Helper() {}

    public String extractInstruction(String input) {
        String[] splitted = input.split(" ");
        if (splitted[0].equals("turn")) {
            if (splitted[1].equals("on")) {
                return "turn on";
            } else {
                return "turn off";
            }
        } else {
            return "toggle";
        }
    }

    public String getInitPoint(String input) {
        String[] splitted = input.split(" ");
        if(splitted[0].equals("turn")) {
            return splitted[2];
        } else {
            return splitted[1];
        }
    }

    public String getEndPoint(String input) {
        String[] splitted = input.split(" ");
        if(splitted[0].equals("turn")) {
            return splitted[4];
        } else {
            return splitted[3];
        }
    }

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public String getInstruction() {
        return instruction;
    }
}
