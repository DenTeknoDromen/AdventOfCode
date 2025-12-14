import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Dec5 {

    static ArrayList<Long> idRangeA = new ArrayList<Long>();
    static ArrayList<Long> idRangeB = new ArrayList<Long>();
    static ArrayList<Long> ids = new ArrayList<Long>();
    static ArrayList<Long> validRanges = new ArrayList<Long>();

    public static void main(String[] args) throws Exception {
        File input = new File("./input");
        Scanner reader = new Scanner(input);

        long valid = 0;

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            if (data.contains("-")) {
                String[] splitOutput = data.split("-");
                idRangeA.add(Long.parseLong(splitOutput[0]));
                idRangeB.add(Long.parseLong(splitOutput[1]));
            } else {
                continue;
            }
        }
        while (idRangeA.size() > 0) {
            int smallestId = getSmallestId();

            validRanges.add(idRangeA.get(smallestId));
            idRangeA.remove(smallestId);

            int lastIndex = validRanges.size();
            if (lastIndex > 2 && validRanges.get(lastIndex - 2) > validRanges.get(lastIndex - 1)) {
                validRanges.remove(validRanges.size() - 1);
                validRanges.remove(validRanges.size() - 1);
            }

            validRanges.add(idRangeB.get(smallestId));
            idRangeB.remove(smallestId);

            if (lastIndex > 2 && validRanges.get(lastIndex - 2) > validRanges.get(lastIndex - 1)) {
                validRanges.remove(validRanges.size() - 1);
                validRanges.remove(validRanges.size() - 1);
            }            
        }
        for (int i = 1; i < validRanges.size(); i += 2) {
            valid += (validRanges.get(i) - validRanges.get(i - 1)) + 1;
        }
        System.out.println("Valid ranges: " + valid);
        reader.close();
    }

    static int getSmallestId() {
        int smallestNumId = 0;
        for (int i = 0; i < idRangeA.size(); i++) {
            if (idRangeA.get(i) < idRangeA.get(smallestNumId)) {
                smallestNumId = i;
            }
        }
        return smallestNumId;
    }
}