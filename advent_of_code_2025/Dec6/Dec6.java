import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Dec6 {

    static HashMap<String, String[]> numbers = new HashMap<>();

    public static void main(String[] args) throws Exception {
        File input = new File("./testInput");
        Scanner reader = new Scanner(input);

        long output = 0;

        int index = 0;
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            numbers.put(String.valueOf(index), data.trim().split(" +"));
            index += 1;
        }

        String operatorIndex = String.valueOf(index - 1);
        for (int i = 0; i < numbers.get("0").length; i++) {
            long outputNum = (numbers.get(operatorIndex)[i].equals("*")) ? 1L : 0L;
            for (String keys : numbers.keySet()) {
                //System.out.println(Arrays.toString(numbers.get(keys)));
                if (keys.equals(operatorIndex)) {
                    break;
                }
                if (numbers.get(operatorIndex)[i].equals("+")) {
                    outputNum += Long.parseLong(numbers.get(keys)[i]);
                    System.out.println("plus");
                } else {
                    outputNum *= Long.parseLong(numbers.get(keys)[i]);
                    System.out.println("multi");
                }
            }
            output += outputNum;
        }

        System.out.println("Output: " + output);
        reader.close();
    }
}