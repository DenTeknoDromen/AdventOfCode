import java.io.File;
import java.util.Scanner;

public class Dec2 {
    public static void main(String[] args) throws Exception {
        File input = new File("./input");
        Scanner reader = new Scanner(input);

        String data = reader.nextLine();
        // Creates a array of every id range in the puzzle input
        String[] allRanges = data.split(",");
        long output = 0;

        // Creates an array representing the id range
        // for every range from the puzzle input
        // Adds invalid ids to output
        for (String range : allRanges) {
            String[] idRangeStr = range.split("-");
            long[] idRange = { Long.parseLong(idRangeStr[0]),
            Long.parseLong(idRangeStr[1]) };
            for (long id = idRange[0]; id <= idRange[1]; id++) {
                String strId = String.valueOf(id);
                if (strId.length() % 2 == 0) {
                    output += handleEvenLength(strId);
                }
                // output += getInvalidId(id);
            }
        }
        System.out.println("Output: " + output);
        reader.close();
    }

    // Converts the long value to string
    // Checks if the length of the string value is odd or even
    // Odd-length ids can only be invalid
    // static long getInvalidId(long id) {
    //     String strId = String.valueOf(id);

    //     if (strId.length() % 2 != 0) {
    //         return 0L; //handleOddLength(strId);
    //     } else {
    //         return handleEvenLength(strId);
    //     }
    // }

    // static int handleOddLength(String strId) {
    //     for (char num : strId.toCharArray()) {
    //         if (num != strId.charAt(0)) {
    //             return 0;
    //         }
    //     }
    //     System.out.println("Invalid id: " + strId);
    //     return Integer.parseInt(strId);
    // }

    // Only applies to ids with a even number of digits
    // Checks if the first half of the id matches the second
    // Returns the long value if it does
    static long handleEvenLength(String strId) {
        int midPoint = strId.length() / 2;
        String firstHalf = strId.substring(0, midPoint);
        String secondHalf = strId.substring(midPoint, strId.length());
        if (firstHalf.equals(secondHalf)) {
            System.out.println("Invalid id: " + strId);
            return Long.parseLong(strId);
        } else {
            return 0L;
        }
    }
}