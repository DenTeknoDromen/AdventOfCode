import java.io.File;
import java.util.Scanner;

public class Dec1 {
    public static void main(String[] args) throws Exception {
        // Read data from file
        File input = new File("./input");
        Scanner reader = new Scanner(input);

        int dialValue = 50;
        int password = 0;

        // Loop through lines in data
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            int[] output = getDialValue(dialValue, data);
            dialValue = output[0];
            password += output[1];
        }
        System.out.println("The password is: " + password);
        reader.close();
    }

    public static int[] getDialValue(int dialValue, String data) {
        int numOfZero = 0;
        int startValue = dialValue;

        if (data.charAt(0) == 'R') {
            dialValue += Integer.parseInt(data.substring(1));
        } else {
            dialValue -= Integer.parseInt(data.substring(1));
        }
        while (dialValue > 99 || dialValue < 0) {
            if (dialValue > 99) {
                dialValue = -1 + (dialValue - 99);
            } else if (dialValue < 0) {
                dialValue = 100 + dialValue;
            }
            if (dialValue != 0 && startValue != 0) {
                System.out.println(data + "\n" + dialValue + "\n-----");
                numOfZero += 1;
            }

        }

        if (dialValue == 0) {
            System.out.println(data + "\n" + dialValue + "\n-----");
            numOfZero += 1;
        }
        int[] results = {dialValue, numOfZero};
        return results;
    }
}