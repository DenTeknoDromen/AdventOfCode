import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class DEC2 {
    static HashMap<String, Integer> colour_tovalue = new HashMap<String, Integer>();
    public static void main(String[] args) throws Exception{
        File input = new File("example.txt");
        Scanner reader = new Scanner(input);
        int output = 0;
        int index = 0;
        colour_tovalue.put("red", 0);
        colour_tovalue.put("blue", 0);
        colour_tovalue.put("green", 0);

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            data = data.split(": ")[1];
            String[] lst_data = data.split("; ");
            output += get_game(lst_data, index);
            index += 1;
            System.out.println("-------------------------------");
        }
        System.out.println("output: " + output);
        reader.close();
    }
    static int get_game(String [] lst_data, int id){  
        boolean check = true;
        System.out.println(Arrays.toString(lst_data));
        for (String a : lst_data) {
            String[] colours = a.split(", ");
            System.out.println(Arrays.toString(colours));
            for (String b : colours) {
                String [] curr_string = b.split(" ");
                int num = Integer.parseInt(curr_string[0]);
                colour_tovalue.put(curr_string[1], num);
                if (colour_tovalue.get("red") > 12){
                    check = false;
                    break;
                System.out.println(colour_tovalue.toString() + check);
            }
        }
        id = (check) ? id    : 0;
        return id;
    }
}