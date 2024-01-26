package DEC8;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

// https://adventofcode.com/2023/day/8
// *

public class PartTwo {
    static HashMap<String, String[]> mapHashMap = new HashMap<String, String[]>();
    static ArrayList<String> stringend = new ArrayList<String>();    

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
        initEndings();

        System.out.println(stringend.toString());
        int steps = navigate(directions);
        System.out.println(stringend.toString());
        System.out.println("Steps: " + steps);
        reader.close();
    }

    // Navigates through the hashmap using the directions lists
    // Returns number of steps to reach "ZZZ"s
    static int navigate(char[] directions) {
        int steps = 0;
        int i = 0;
        while (!checkFinished()) {
            moveStringend(directions[i]);
            // Loops through directions array and provides correct direction
            i += 1;
            if (i == directions.length) {
                i = 0;
            }
            steps += 1;
        }
        return steps;
    }
    // Adds every node ending with "A" to initial list
    static void initEndings() {
        for (String i : mapHashMap.keySet()) {
            if (i.charAt(2) == 'A') {
                stringend.add(i);
            }
        }
    }
    // Navigates every string in stringend list according to directions input
    static void moveStringend(Character direction) {
        for (int i = 0; i < stringend.size(); i++) {
            String currString = stringend.get(i);
            currString = (direction == 'L') ? mapHashMap.get(currString)[0] : mapHashMap.get(currString)[1];
            stringend.set(i, currString);
        }
    }
    // Checks if every string in stringend list has reached Z simulatiously
    static Boolean checkFinished() {
        int check = 0;
        for (String i : stringend) {          
            if (i.substring(2).equals("Z")) {
                System.out.println(i);
                check += 1;
            }
        }
        if (check > 2) {
            System.out.println(check);
        }

        return (check == stringend.size());
    }    
}