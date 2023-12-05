import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class DEC4 {

    public static void main(String[] args) throws Exception{
        File input = new File("src/DEC4_input.txt");
        Scanner reader = new Scanner(input);
        int sum = 0;
        int matches = 0;
        int points = 0;

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            matches = get_matches(data);
            points = (matches > 0) ? get_points(matches) : matches;
            sum += points;
            System.out.println(sum);
            
        }
        reader.close();
    }
    static int get_matches(String data) {

        int matches = 0;

        String[] lst_dataA = data.substring(8, 22).split(" ");
        String[] lst_dataB = data.substring(24, 47).split(" ");
        for (String i : lst_dataA) {
            if (Arrays.asList(lst_dataB).contains((i))) {
                matches += 1;
            }
        }
        return matches;
    }
    static int get_points(int matches) {
        int points = 1;
        for (int x = 0; x < (matches - 1); x++) {
          points *= 2;
        }
        return points;
    }
}