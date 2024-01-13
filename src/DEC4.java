import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

// https://adventofcode.com/2023/day/4
// *

public class DEC4 {
    // List of cards
    static ArrayList<Integer> cardList = new ArrayList<Integer>();
    static int card_index = 0;

    public static void main(String[] args) throws Exception{
        // Reads input from file
        File input = new File("DEC4_input.txt");
        Scanner reader = new Scanner(input);

        int sum = 0;
        int matches = 0;
        int points = 0;

        // Creates default list of cards
        for (int x = 0; x < 6; x++) {
            cardList.add(1);
        }
        
        int index = 1;
        String data = reader.nextLine();        
        while (reader.hasNextLine()) {
            Boolean check = reader.hasNextLine();
            matches = get_matches(data);
            put_cards(matches);
            index -= 1;
            sum += 1;
            //System.out.println(data);
            //System.out.println("Total number of cards: " + sum);            
            System.out.println(cardList.toString());
            System.out.println(check);
            //put_cards(matches);
            if (index == 0) {
                data = reader.nextLine();
                card_index += 1;
                index = cardList.get(card_index);
            }
        }        
        reader.close();
    }
    static int get_matches(String data) {
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
    static int get_points(int matches) {
        int points = 1;
        for (int x = 0; x < (matches - 1); x++) {
          points *= 2;
        }
        return points;
    }
    static void put_cards(int matches) {
        for (int i = 0; i < matches; i++) {
            if (card_index < cardList.size()) {
                int x = cardList.get(card_index + i) + 1;
                cardList.set(card_index + i, x);
            }
        }
    }
}