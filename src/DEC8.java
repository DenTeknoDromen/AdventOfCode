import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class DEC8 {
    static HashMap<String, String[]> mapHashMap = new HashMap<String, String[]>();
    static ArrayList<String> stringend = new ArrayList<String>();
    //static int check = 0;

    public static void main(String[] args) throws Exception{
        File input = new File("DEC8_input.txt");
        Scanner reader = new Scanner(input);
        
        char[] directions = reader.nextLine().toCharArray();
        String data = reader.nextLine();


        while (reader.hasNextLine()) {
            data = reader.nextLine();
            String[] lst_map = new String[2];
            lst_map[0] = data.substring(7, 10);
            lst_map[1] = data.substring(12, 15);
            data = data.substring(0, 3);

            mapHashMap.put(data, lst_map);
        }
        get_endings(); 
        System.out.println("Size: " + stringend.size());
        System.out.println("Steps: " + navigate(directions));
        for (String i : stringend) {
            System.out.println(i);
        }
        reader.close();
    }
    static int navigate(char[] directions) {
        int steps = 0;
        String curr_node = "AAA";
        int check = 0;
        int i = 0;
        //while (!curr_node.equals("ZZZ") && steps < 100000) {        
        while (check != stringend.size() ) {
/*          curr_node = (directions[i] == 'L') ? mapHashMap.get(curr_node)[0] : mapHashMap.get(curr_node)[1];
            System.out.println(curr_node); */
            check = 0;
            for (int a = 0; a < stringend.size(); a++) {
                curr_node = stringend.get(a);
                curr_node = (directions[i] == 'L') ? mapHashMap.get(curr_node)[0] : mapHashMap.get(curr_node)[1];
                stringend.set(a, curr_node);
                
                //System.out.println(stringend.get(a));
                check = (curr_node.charAt(2) == 'Z') ? check + 1 : check + 0;
                ///System.out.println("check: " + check);                
            }
            //System.out.println(check);
            //System.out.println("--------------------------------------------------------------");
            i += 1;
            if (i == directions.length) {
                i = 0;
            }
            steps += 1;
            if (steps % 100 == 0) {
                System.out.println("!");
            }
        }
        return steps;
    }
    static void get_endings() {
        for (String i : mapHashMap.keySet()) {
            if (i.charAt(2) == 'A') {
                stringend.add(i);
                System.out.println(i);
            }
        }
    }
}