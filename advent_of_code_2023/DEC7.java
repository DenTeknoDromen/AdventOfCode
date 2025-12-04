import java.io.File;
import java.lang.reflect.Array;
import java .util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DEC7 {
    static HashMap<Character, Integer> cardMap = new HashMap<Character, Integer>();
    static char[] cardValues = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
    
    public static void main(String[] args) throws Exception{
        File input = new File("src/DEC7_input.txt");
        Scanner reader = new Scanner(input);

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            data = data.split(" ")[0];
            getCards(data);
            //System.out.println(output);
        }
        reader.close();
    }
    // Lists quantities of every card  in an hashmap
    static void getCards(String data) {
        cardMap.clear();
        char[] lst_chars = data.toCharArray();
        for (char i : lst_chars) {
            if (!cardMap.containsKey(i)){   
                cardMap.put(i, 1);
            } else {
                int x = cardMap.get(i);
                cardMap.put(i, x + 1);
            }
        }
        int points = getHand() * 70;
        for (Character i : data.toCharArray()) {
            points += getPoints(i);
        }
        System.out.println(data);        
        System.err.println("Hand: " + getHand());
        System.out.println("points = " + points);
        System.out.println(cardMap.toString());
        System.out.println("-------------------------------------------------");
    }
    static Integer getHand() {
        int hand = 8;
        int len = cardMap.size();

        switch (len) {
            case 2:
                if (!(cardMap.values().contains(1))) {
                    return hand - 3;
                }
            case 3:
                if (cardMap.values().contains(2)) {
                    return hand - 4;
                } else {
                    return hand - 5;
                }
            case 4:
                return hand - 6;
            case 5:
                return hand - 7;
            default: 
                return hand - len;
        }
    }
    static int getPoints(char i) {
        for (int x = 0; x < cardValues.length; x++) {
            if (cardValues[x] == i) {
                return x + 1;
            }
        }
        return -1;
    }
}
