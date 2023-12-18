import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class DEC15 {
    static HashMap<Integer, ArrayList<String>> boxes = new HashMap<Integer, ArrayList<String>>();
    public static void main(String[] args) throws Exception{
        File input = new File("DEC15_input.txt");
        Scanner reader = new Scanner(input);
        int sum = 0;

        for (int x = 0; x < 256; x++) {
            boxes.put(x, new ArrayList<String>());
        }

        String[] data = reader.nextLine().split(",");
        for (String i : data) {
            sum += hash_algorithm(i);
        }
        System.out.println("Sum: " + sum);

        reader.close();
    }
    static int hash_algorithm(String data) {
        char[] chars = data.toCharArray();
        int curr_value = 0;

        for (char a: chars) {                
            curr_value += ((int)a);
            curr_value = curr_value * 17;
            curr_value = curr_value % 256;
        }
        System.out.println("curr_value: " + curr_value);
        return curr_value;
    }
    static void sort_boxes(String label, int int_label) {
        String lens_label = label.substring(0, 1);
        String focal_len = ' ' + label.substring(3);

        switch (label.charAt(2)) {
            case '=':
                boxes.get(int_label).add(lens_label + focal_len);
            case '-':
                remove_lens(int_label, lens_label);       
        }
    }
    static void add_lens(String lens_label, String focal_len, int int_label) {
        String lens_name = lens_label + focal_len;
        if (boxes.get(int_label).contains(lens_label)) {
            boxes.get(int_label).
        }
    }
    static void remove_lens(int int_label, String lens_name) {
        if (boxes.get(int_label).contains(lens_name)) {
            boxes.get(int_label).remove(lens_name);
        }
    }
}