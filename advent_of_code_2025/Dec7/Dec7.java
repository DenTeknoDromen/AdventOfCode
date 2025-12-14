import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Dec7 {
    public static void main(String[] args) throws Exception {
        File input = new File("./input");
        Scanner reader = new Scanner(input);

        ArrayList<char[]> grid = new ArrayList<char[]>();
        long output = 0;

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            grid.add(data.toCharArray());
        }
        char[] beams = grid.get(0);
        for (int row = 1; row < grid.size() - 1; row++) {
            for (int col = 0; col < beams.length - 1; col++) {
                if (beams[col] != '.' && grid.get(row)[col] == '^') {
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