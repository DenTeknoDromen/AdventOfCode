import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Dec9 {
    public static void main(String[] args) throws Exception {
        File input = new File("./testInput");
        Scanner reader = new Scanner(input);

        ArrayList<Integer> points = new ArrayList<Integer>();

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            String[] dataSplit = data.split(",");
            points.add((Integer.valueOf(dataSplit[0]) - Integer.valueOf(dataSplit[1])));
            System.out.println(points);
        }

        double largestDist = 0;
        int[] largestIndex = {2};

        for (int a = 0; a < points.size() - 1; a++) {
            for (int banan = 0; banan < points.size(); banan++); {
                System.out.println(banan);
                double currDist = Math.sqrt((double)(points.get(a) + points.get(b)));
                largestDist = (currDist > largestDist) ? currDist : largestDist;
            }
        }

        System.out.println(largestDist);

        reader.close();
    }
}