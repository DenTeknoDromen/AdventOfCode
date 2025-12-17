import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Dec9 {
    public static void main(String[] args) throws Exception {
        File input = new File("./input");
        Scanner reader = new Scanner(input);

        ArrayList<int[]> cords = new ArrayList<int[]>();

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            String[] dataSplit = data.split(",");
            int[] dataSplitInt = {Integer.valueOf(dataSplit[0]), Integer.valueOf(dataSplit[1])};
            cords.add(dataSplitInt);
        }

        long largestArea = 0;
        int[] largestIndex = new int[2];

        for (int a = 0; a < cords.size() - 1; a++) {
            for (int b = a + 1; b < cords.size() - 1; b++) {
                int length = Math.abs(cords.get(a)[0] - cords.get(b)[0]) + 1;
                int height = Math.abs(cords.get(a)[1] - cords.get(b)[1]) + 1;
                long currArea = (long)length * height;
                System.out.println(currArea);
                if (currArea > largestArea) {
                    largestArea = currArea;
                    largestIndex[0] = a;
                    largestIndex[1] = b;
                }
            }
        }
        System.out.println(cords.get(largestIndex[0])[0] + "," + cords.get(largestIndex[0])[1]);
        System.out.println(cords.get(largestIndex[1])[0] + "," + cords.get(largestIndex[1])[1]);
        System.out.println(largestArea);

        reader.close();
    }
}