import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class DEC9 {

    public static void main(String[] args) throws Exception {
        File input = new File("src\\DEC9_input.txt");
        Scanner reader = new Scanner(input);
        int finalnum = 0;
        int answer = 0;

        // Loops through input
        while (reader.hasNextLine()) {
            String[] data = reader.nextLine().split(" ");
            int[] int_data = get_intarray(data);

            finalnum = int_data[int_data.length - 1];
            finalnum += calc(int_data);
            System.out.println("finalnum: " + finalnum + "\n");            
            
            answer += finalnum;
        }
        System.out.println("Answer: " + answer);
        reader.close();
    }
    // Converts input from string array to int array
    static int[] get_intarray(String[] data) {
        int[] int_array = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            int_array[i] = Integer.parseInt(data[i]);
        }
        return int_array;
    }
    // Calculates every array until every number is 0
    // then adds together the finalnumber of every array
    // Uses recursive method
    static int calc(int[] int_data) {
        int len = int_data.length - 1;
        int[] next_array = new int[len];
        int check = 0; // Checks if every number in array is 0
        System.out.println(Arrays.toString(int_data));

        int i = 0;        
        while (i + 1 <= len) {
            // Adds difference between numbers to next array
            next_array[i] = (int_data[i] - int_data[i + 1]) * -1;
            check = (next_array[i] == 0) ? check + 1 : check + 0;
            i += 1;
        }
        int finalnum = next_array[len - 1];
        //int finalnum = next_array[0];
        System.out.println(finalnum);

        // Calls another instance of method if array is not all 0
        if (check == len) {
            return finalnum;
        }

        return finalnum + calc(next_array);
    }
}
