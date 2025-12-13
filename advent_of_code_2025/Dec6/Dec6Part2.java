import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Dec6 {

    static HashMap<String, char[]> numbers = new HashMap<>();

    public static void main(String[] args) throws Exception {
        File input = new File("./input");
        Scanner reader = new Scanner(input);

        long output = 0;
        ArrayList<Integer> currNums = new ArrayList<Integer>();

        int index = 0;
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            numbers.put(String.valueOf(index), data.toCharArray());
            index += 1;
        }

        for (int a = numbers.get("0").length - 1; a >= 0; a--) {
            String num = "";
            long outputNum = 0;

            for (int b = 0; b < numbers.size() - 1; b++) {
                num = num.concat(String.valueOf(numbers.get(String.valueOf(b))[a]));
            }
            if (!num.matches(" +")) {
                currNums.add(Integer.valueOf(num.trim()));
            }
            char operator = numbers.get(String.valueOf(numbers.size() - 1))[a];
            if (operator == '+') {
                for (int i : currNums) {
                    outputNum += (long)i;
                }
                output += (long)outputNum;
                currNums.clear();
                System.out.println(outputNum);
            } else if (operator == '*') {
                outputNum = 1;
                for (int i : currNums) {
                    outputNum *= (long)i;
                }
                output += outputNum;
                currNums.clear();
                System.out.println(outputNum);
            }
        }
        System.out.println("Output: " + output);
        reader.close();
    }
}