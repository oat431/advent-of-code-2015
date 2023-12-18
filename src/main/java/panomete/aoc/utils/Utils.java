package panomete.aoc.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static List<String> readInput(String filename) throws FileNotFoundException {
        String path = "src/main/resources/" + filename + ".txt";
        File file = new File(path);
        Scanner in = new Scanner(file);
        List<String> input = new ArrayList<>();
        while(in.hasNextLine()) {
            input.add(in.nextLine());
        }
        in.close();
        return input;
    }

    public static String readText(String filename) throws FileNotFoundException {
        String path = "src/main/resources/" + filename + ".txt";
        File file = new File(path);
        Scanner in = new Scanner(file);
        StringBuilder input = new StringBuilder();
        while(in.hasNextLine()) {
            input.append(in.nextLine());
        }
        in.close();
        return input.toString();
    }
}
