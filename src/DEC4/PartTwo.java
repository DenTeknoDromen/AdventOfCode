package DEC4;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

// https://adventofcode.com/2023/day/4
// **

public class PartTwo {
    // List of cards keeps, tracks of the amount of cards
    static ArrayList<Integer> cardList = new ArrayList<Integer>();
    static int card_index = 0;

    public static void main(String[] args) throws Exception {
        // Reads input from file
        File input = new File("DEC4_input.txt");
        Scanner reader = new Scanner(input);

        int sum = 0;
        int matches = 0;

        // Creates default list of cards
        for (int x = 0; x < 197; x++) {
            cardList.add(1);
        }

        int numCards = cardList.get(0);
        String data = reader.nextLine();
        int steps = 0;
        // Iterates through input
        while (reader.hasNextLine()) {
            matches = getMatches(data);
            for (int i = 0; i < numCards; i++) {
                putCards(matches);
            }
            data = reader.nextLine();
            steps += 1;
            System.out.println("Steps: " + steps);
            card_index += 1;
            numCards = cardList.get(card_index);
        }
        for (int i : cardList) {
            sum += i;
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

    // Adds one extra card for every card between
    // current index in cardList + number of matches in current card
    static void putCards(int matches) {
        int i = card_index + 1;
        int max = (i + matches);

        for (; i < cardList.size(); i++) {
            if (i < max) {
                int x = cardList.get(i);
                cardList.set(i, x + 1);
            }
        }
    }
}