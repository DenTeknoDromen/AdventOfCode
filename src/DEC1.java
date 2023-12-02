import java.io.File;
import java.util.Scanner;

public class DEC1 {
    public static void main(String[] args) throws Exception {
        // Opens input file for reading
        File input = new File("src/DEC1_input.txt");
        Scanner reader = new Scanner(input);
        int sum = 0;

        // Sends every line to get_num or get_alphanum and adds return integer to sum
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            System.out.println(data);
            sum += get_alphanum(data);
        }
        reader.close();
        System.out.println("Calibration value: " + sum);
    }

    static int get_num(String indata) {
        char[] lst_indata = indata.toCharArray();
        String str_num = "";
        int num = 0;
        int len_indata = lst_indata.length;

        // Loops through the char_array from begining to end to find the first number
        int index = 0;
        while (Character.isAlphabetic(lst_indata[index])) {
            index += 1;
        }
        str_num += lst_indata[index];

        // Loops through the char_array backwards to find the last number
        index = len_indata - 1;
        while (Character.isAlphabetic(lst_indata[index])) {
            index -= 1;
        }
        ;
        // Adds both numbers together as a string, casts it as integer and returns it
        str_num += lst_indata[index];
        num = Integer.parseInt(str_num);
        System.out.println(num);
        return num;
    }

    static int get_alphanum(String indata) {
        int firstindex = 99999;
        int firstnum = 0;
        int lastindex = 0;
        int lastnum = 0;
        String finalnum = "";
        int num = 0;

        String[] alphas = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "1", "2", "3", "4",
                "5", "6", "7", "8", "9" };

        // Finds first instance of string from alphas
        // Save the current i value if first instance is earlier than last saved
        // indexvalue
        for (int i = 0; i < alphas.length; i++) {
            int x = indata.indexOf(alphas[i]);
            if (x < firstindex && x >= 0) {
                firstindex = x;
                // i value will always be same as current digit from alphas
                firstnum = (i > 8) ? i - 8 : i + 1;
            }
            ;

            x = indata.lastIndexOf(alphas[i]);
            if (x >= lastindex) {
                lastindex = x;
                lastnum = (i > 8) ? i - 8 : i + 1;
            }
            ;
        }
        finalnum += Integer.toString(firstnum);
        finalnum += Integer.toString(lastnum);

        num = Integer.parseInt(finalnum);
        System.out.println(num);
        return num;
    }
}
