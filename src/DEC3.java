import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class DEC3 {
    static ArrayList<Integer> xarray = new ArrayList<Integer>();
    static ArrayList<Integer> yarray = new ArrayList<Integer>();
    static ArrayList<String> possible_cors = new ArrayList<String>();
    static int sum = 0;
    //static ArrayList<String> nums = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        File input = new File("src/DEC3_input.txt");
        Scanner reader = new Scanner(input);

        int index = 0;
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            get_y(data, index);
            index += 1;
        }
        reader.close();
        
        for (int i = 0; i < xarray.size(); i++) {
            create_cords(i);
        }

        reader = new Scanner(input);
        index = 0;
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            check_cords(data, index);
            index += 1;
        }
        reader.close();            

        System.out.println(xarray.toString());
        System.out.println(yarray.toString());
        System.out.println(possible_cors);
        System.out.println(sum);

    }

    static void get_y(String data, int x) {
        char[] char_data = data.toCharArray();
        for (int i = 0; i < char_data.length; i++) {
            if (!Character.isDigit(char_data[i]) && char_data[i] != '.') {
                xarray.add(x);
                yarray.add(i);
            }
        }
    }

    static void create_cords(int i)  {
        int x = xarray.get(i);
        int y = yarray.get(i);

        possible_cors.add(String.valueOf(x + 1) + String.valueOf(y));
        possible_cors.add(String.valueOf(x - 1) + String.valueOf(y));

        possible_cors.add(String.valueOf(x) + String.valueOf(y + 1));
        possible_cors.add(String.valueOf(x) + String.valueOf(y - 1));

        possible_cors.add(String.valueOf(x + 1) + String.valueOf(y + 1));
        possible_cors.add(String.valueOf(x + 1) + String.valueOf(y - 1));

        possible_cors.add(String.valueOf(x - 1) + String.valueOf(y + 1));
        possible_cors.add(String.valueOf(x - 1) + String.valueOf(y - 1));
    }

    static void check_cords(String data, int x) {
        char[] char_data = data.toCharArray();
        String curr_cord = "";
        String curr_num = "";
        boolean check = false;
        for (int i = 0; i < char_data.length; i++) {
            curr_cord = String.valueOf(x) + String.valueOf(i);
            check = (possible_cors.contains(curr_cord));

            int smallindex = i;
            while (smallindex < char_data.length && Character.isDigit(char_data[smallindex])) {
                curr_num += char_data[smallindex];
                smallindex += 1;
            }

            if (check) {
                System.out.println(curr_num);
                //sum += (Integer.parseInt(curr_num));
            }

        }
    }
}