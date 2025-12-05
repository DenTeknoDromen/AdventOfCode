import java.io.File;
import java.util.Scanner;

public class Dec3 {
    public static void main(String[] args) throws Exception {
        File input = new File("./input");
        Scanner reader = new Scanner(input);

        int output = 0;

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            int[] joltageArray = new int[data.length()];
            for (int i = 0; i < data.length(); i++) {
                joltageArray[i] = data.charAt(i) - '0';
            }
            output += findLargestInt(joltageArray);
        }
        System.out.println("Output: " + output);
        reader.close();
    }

    static int findLargestInt(int[] joltageArray) {
        int largestIntIndex = 0;
        for (int i = 0; i < joltageArray.length - 1; i++) {
            largestIntIndex = (joltageArray[i] > joltageArray[largestIntIndex]) ? i : largestIntIndex;
        }
        int secondIntIndex = largestIntIndex + 1;
        for (int i = largestIntIndex + 1; i < joltageArray.length; i++) {
            secondIntIndex = (joltageArray[i] > joltageArray[secondIntIndex]) ? i : secondIntIndex;
        }
        return (joltageArray[largestIntIndex] * 10) + joltageArray[secondIntIndex];
    }
}