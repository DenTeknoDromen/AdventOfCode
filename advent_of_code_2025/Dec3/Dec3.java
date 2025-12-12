import java.io.File;
import java.util.Scanner;

public class Dec3 {
    public static void main(String[] args) throws Exception {
        File input = new File("./input");
        Scanner reader = new Scanner(input);

        long output = 0;

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            int[] joltageArray = new int[data.length()];
            for (int i = 0; i < data.length(); i++) {
                joltageArray[i] = data.charAt(i) - '0';
            }
            output += Long.parseLong(findLargestValue(joltageArray));
        }
        System.out.println("Output: " + output);
        reader.close();
    }

    static String findLargestValue(int[] joltageArray) {
        //long joltage = 0;
        String joltage = "";
        int largestIntIndex = 0;
        for (int a = 11; a >= 0; a--) {
            for (int b = largestIntIndex; b < joltageArray.length - a; b++) {
                largestIntIndex = (joltageArray[b] > joltageArray[largestIntIndex]) ? b : largestIntIndex;
            }
            //joltage += (long)joltageArray[largestIntIndex] * (long)Math.pow(10, a);
            joltage = joltage.concat(String.valueOf(joltageArray[largestIntIndex]));
            largestIntIndex += 1;
        }
        return joltage;
    }
}