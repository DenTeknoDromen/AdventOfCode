import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Dec6 {
    public static void main(String[] args) throws Exception {
        File input = new File("./input");
        Scanner reader = new Scanner(input);

        long output = 0;
        ArrayList<char[]> numbers = new ArrayList<char[]>();
        ArrayList<Integer> currNums = new ArrayList<Integer>();

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            numbers.add(data.toCharArray());
        }

        for (int col = numbers.get(0).length - 1; col >= 0; col--) {
            String num = "";

            for (int row = 0; row < numbers.size() - 1; row++) {
                num = num + String.valueOf(numbers.get(row)[col]);
            }
            if (!num.matches(" +")) {
                currNums.add(Integer.valueOf(num.trim()));
            }
            char operator = numbers.get(numbers.size() - 1)[col];
            if (operator == '+' || operator == '*') {
                output += getCalc(operator, currNums);
            }
        }
        System.out.println("Output: " + output);
        reader.close();
    }

    static long getCalc(char operator, ArrayList<Integer> currNums) {
        long outputNum = 0;
        if (operator == '+') {
            for (int i : currNums) {
                outputNum += (long) i;
            }
        } else {
            outputNum = 1;
            for (int i : currNums) {
                outputNum *= (long) i;
            }
        }
        currNums.clear();
        System.out.println(outputNum);
        return outputNum;
    }
}