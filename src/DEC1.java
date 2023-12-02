import java.io.File;
import java.util.Scanner;


public class DEC1 {
    public static void main(String[] args) throws Exception {
        //Opens input file for reading
        File input = new File("src/DEC1_input.txt");
        Scanner reader = new Scanner(input);
        int sum = 0;

        //Sends every line to get_num and adds return integer to sum
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            System.out.println(data);
            sum += get_num(data);
        }
        reader.close();
        System.out.println("Calibration value: " + sum);
        }

        static int get_num(String indata) { 
            char[] lst_indata = indata.toCharArray();
            String str_num  = "";
            int num = 0;
            int len_indata = lst_indata.length;

            //Loops through the char_array from begining to end to find the first number
            int index = 0;
            while (Character.isAlphabetic(lst_indata[index])) {
                index += 1;
            }
            str_num += lst_indata[index];

            //Loops through the char_array backwards to find the last number
            index = len_indata - 1;
            while (Character.isAlphabetic(lst_indata[index])) {
                index -= 1;
            };
            //Adds both numbers together as a string, casts it as integer and returns it
            str_num += lst_indata[index];
            num = Integer.parseInt(str_num);
            System.out.println(num);
            return num;
        }
    }
