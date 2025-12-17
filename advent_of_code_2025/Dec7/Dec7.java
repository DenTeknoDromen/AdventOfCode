import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Dec7 {
    public static void main(String[] args) throws Exception {
        File input = new File("./input");
        Scanner reader = new Scanner(input);

        long output = 0;
        char[] beams = reader.nextLine().toCharArray();

        while (reader.hasNextLine()) {
            char[] grid = reader.nextLine().toCharArray();
            for (int col = 0; col < beams.length - 1; col++) {
                if (beams[col] != '.' && grid[col] == '^') {
                    beams[col - 1] = '|';
                    beams[col] = '.';
                    beams[col + 1] = '|';
                    output += 1;
                }
            }
        }
        System.out.println("Output: " + output);
        reader.close();
    }
}