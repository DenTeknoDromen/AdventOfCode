import java.io.File;
import java .util.Scanner;
import java.util.HashMap;

public class DEC7 {
    static HashMap<Character, Integer> cardMap = new HashMap<Character, Integer>();
    public static void main(String[] args) throws Exception{
        File input = new File("src/DEC7_input.txt");
        Scanner reader = new Scanner(input);

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            data = data.split(" ")[0];
            get_cards(data);
            //System.out.println(output);
        }
        reader.close();
    }
    static void get_cards(String data) {
        System.out.println(data);
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
        System.out.println(cardMap.toString());

    }
    static void get_hand() {
        cardMap
    }
    
}
