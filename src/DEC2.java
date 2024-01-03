import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class DEC2 {
    static HashMap<String, Integer> colour_tovalue = new HashMap<String, Integer>();
    public static void main(String[] args) throws Exception{
        File input = new File("dec2_input.txt");
        Scanner reader = new Scanner(input);
        int output = 0;
        int index = 1;

        // Uses a hashmap to map the colours to values
        colour_tovalue.put("red", 12);
        colour_tovalue.put("blue", 14);
        colour_tovalue.put("green", 13);

        while (reader.hasNextLine()) {
            String data = reader.nextLine();

            // Splits the list after gameid ad the rest
            // Adds the gameid if the game is possible
            // Uses index to keep track of game id
            data = data.split(": ")[1];
            output += get_game2(data);

            System.out.println("index: " + index);
            index += 1;            
            System.out.println("-------------------------------");
        }
        System.out.println("output: " + output);
        reader.close();
    }
    static int get_game(String data, int id){
        // Creates a list with colours and values
        String[] lst_data = data.split("; |, ");
        System.out.println(Arrays.toString(lst_data));

        // Iterates throughthe list and checks if the game is possible
        for (String i : lst_data){
            int num = Integer.parseInt(i.split(" ")[0]);
            String colours = i.split(" ")[1];

            // If the game is not possible, returns 0
            if (num > colour_tovalue.get(colours)){
                System.out.println("False");
                return 0;
            }
        }
        //If game is possible returns index whichis same as game id
        System.out.println("True");
        return id;
    }
    static int get_game2(String data){
        resest_hashmap();
        // Creates a list with colours and values
        String[] lst_data = data.split("; |, ");
        System.out.println(Arrays.toString(lst_data));

        // Iterates throughthe list and gets the values and colours
        for (String i : lst_data){
            int num = Integer.parseInt(i.split(" ")[0]);
            String colours = i.split(" ")[1];

            // Adds the highest number in the game to the hashmap
            if (num > colour_tovalue.get(colours)){
                colour_tovalue.put(colours, num);
            }
        }
        return multiply_hashmap();
    }
    static void resest_hashmap(){
        colour_tovalue.put("red", 0);
        colour_tovalue.put("green", 0);
        colour_tovalue.put("blue", 0);
    }
    static int multiply_hashmap(){
        int product = colour_tovalue.get("red") * 
                        colour_tovalue.get("green") *
                        colour_tovalue.get("blue");
        return product;
    }
    
}