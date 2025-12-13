import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Dec5 {

    static ArrayList<Long> idRangeA = new ArrayList<Long>();
    static ArrayList<Long> idRangeB = new ArrayList<Long>();
    static ArrayList<Long> ids = new ArrayList<Long>();
    static ArrayList<Long> valid = new ArrayList<Long>();

    public static void main(String[] args) throws Exception {
        File input = new File("./testInput");
        Scanner reader = new Scanner(input);

        int numOfFresh = 0;
        long validRanges = 0;

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            if (data.contains("-")) {
                String[] splitOutput = data.split("-");
                idRangeA.add(Long.parseLong(splitOutput[0]));
                idRangeB.add(Long.parseLong(splitOutput[1]));
            } else {
                try {
                    ids.add(Long.parseLong(data));
                } catch (NumberFormatException nfe) {
                    continue;
                }
            }
        }
        
        // Part 1
        for (Long id : ids) {
            for (int i = 0; i < idRangeA.size(); i++){
                if (checkRange(idRangeA.get(i), idRangeB.get(i), id)) {
                    numOfFresh += 1;
                    break;
                }
            }
        }
        // Part 2
        int largestID = getLargestId();
        long largestNum = idRangeB.get(largestID);
        System.out.println("Largest: " + largestNum);

        long rangeIndex = idRangeA.get(getSmallestId(0L, largestID));
        long tempVar = 0;
        System.out.println("Smallest: " + rangeIndex);        

        while (rangeIndex <= largestNum) {
            for (int i = 0; i < idRangeA.size(); i++) {
                //System.out.println("index: " + i);
                if (checkRange(idRangeA.get(i), idRangeB.get(i), rangeIndex)) {
                    valid.add(rangeIndex);
                    valid.add(idRangeB.get(i));
                    validRanges += ((idRangeB.get(i) - rangeIndex) + 1);
                    rangeIndex = idRangeB.get(i); 
                    //System.out.println("rangeindex: " + rangeIndex);
                    //System.out.println("validRanges: " + validRanges);
                    break;
                }
            }
            System.out.println(rangeIndex);
            //rangeIndex += 1;

            tempVar = idRangeA.get(getSmallestId(rangeIndex, largestID));
            rangeIndex = (tempVar > rangeIndex) ? tempVar : rangeIndex + 1;
            //System.out.println(validRanges);
        }
        System.out.println(valid);
        System.out.println("Number of fresh ingredients: " + numOfFresh);
        System.err.println("Valid id ranges: " + validRanges);
        reader.close();
    }
    static boolean checkRange(Long lowerRange, Long upperRange, Long id) {
        if (id >= lowerRange && id <= upperRange) {
            return true;
        } else {
            return false;
        }
    }
    static int getSmallestId(long minimum, int largestID) {
        // System.out.println("minimum: " + minimum);
        int smallestNumId = largestID;
        for (int i = 0; i < idRangeA.size(); i++) {
            if (idRangeA.get(i) < idRangeA.get(smallestNumId) && idRangeA.get(i) > minimum) {
                smallestNumId = i;
            }
        }
        // System.out.println("smallest: " + idRangeA.get(smallestNumId));
        return smallestNumId;
    }
    static int getLargestId() {
        int largestNumId = 0;
        for (int i = 0; i < idRangeB.size(); i++) {
            largestNumId = (idRangeB.get(i) > idRangeB.get(largestNumId)) ? i : largestNumId;
        }
        return largestNumId;
    }    
}