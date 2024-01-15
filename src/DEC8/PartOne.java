package DEC8;

import java.io.File;
import java.util.Scanner;
import java.util.HashMap;

// https://adventofcode.com/2023/day/8
// *

public class PartOne {
    static HashMap<String, String[]> mapHashMap = new HashMap<String, String[]>();

    public static void main(String[] args) throws Exception {
        File input = new File("DEC8_input.txt");
        Scanner reader = new Scanner(input);

        // Creates a list of L or R directions from input
        char[] directions = reader.nextLine().toCharArray();

        // SKips a blank line in input
        String data = reader.nextLine();

        // Iterates through input and creates a Hashmap with
        // node : path options
        while (reader.hasNextLine()) {
            data = reader.nextLine();
            String[] lst_map = new String[2];
            lst_map[0] = data.substring(7, 10);
            lst_map[1] = data.substring(12, 15);
            data = data.substring(0, 3);

            mapHashMap.put(data, lst_map);

        }
        System.out.println("Steps: " + navigate(directions));
        reader.close();
    }

    // Navigates through the hashmap using the directions lists
    // Returns number of steps to reach "ZZZ"s
    static int navigate(char[] directions) {
        int steps = 0;
        String curr_node = "AAA";
        int i = 0;
        while (!curr_node.equals("ZZZ") && steps < 100000) {
            curr_node = (directions[i] == 'L') ? mapHashMap.get(curr_node)[0] : mapHashMap.get(curr_node)[1];
            System.out.println(curr_node);
            // Loops through directions array and provides correct direction
            i += 1;
            if (i == directions.length) {
                i = 0;
            }
            steps += 1;
        }
        return steps;
    }
}