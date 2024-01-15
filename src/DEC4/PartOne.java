package DEC4;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

// https://adventofcode.com/2023/day/4
// **

public class PartOne {

    public static void main(String[] args) throws Exception {
        // Reads input from file
        File input = new File("DEC4_input.txt");
        Scanner reader = new Scanner(input);

        int sum = 0;
        int matches = 0;
        int points = 0;

        // Iterates through input
        while (reader.hasNextLine()) {
            String data = reader.nextLine();

            // Gets matches
            matches = getMatches(data);
            // Calculates number of points if current card has matches
            points = (matches != 0) ? getPoints(matches) : matches;
            sum += points;
        }
        System.out.println("Sum: " + sum);
        reader.close();
    }

    // Creates two arrays from string inputs and checks them for matches
    static int getMatches(String data) {
        int matches = 0;
        data = data.split(": ")[1];
        String dataA = data.split(" \\|")[0];
        String dataB = data.split(" \\|")[1];

        String[] lst_dataA = dataA.split(" ");
        String[] lst_dataB = dataB.split(" ");

        for (String i : lst_dataA) {
            if (Arrays.asList(lst_dataB).contains((i)) && !i.isEmpty()) {
                matches += 1;
            }
        }
        return matches;
    }

    // Doubles points for every match in card
    static int getPoints(int matches) {
        int points = 1;
        for (int x = 0; x < (matches - 1); x++) {
            points *= 2;
        }
        return points;
    }
}