import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Dec6 {
    public static void main(String[] args) throws Exception {
        File input = new File("./testInput");
        Scanner reader = new Scanner(input);

        long output = 0;
        ArrayList<String[]> numbers = new ArrayList<String[]>();

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            numbers.add(data.trim().split(" +"));
        }
        int operatorIndex = numbers.size() - 1;
        for (int col = 0; col < numbers.get(0).length; col++) {
            long outputNum = (numbers.get(operatorIndex)[col].equals("*")) ? 1L : 0L;
            for (int row = 0; row < operatorIndex; row++) {
                if (numbers.get(operatorIndex)[col].equals("+")) {
                    outputNum += Long.valueOf(numbers.get(row)[col]);
                } else {
                    outputNum *= Long.valueOf(numbers.get(row)[col]);
                }
            }
            output += outputNum;
        }

        System.out.println("Output: " + output);
        reader.close();
    }
}