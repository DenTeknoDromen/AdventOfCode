import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Dec1 {
    public static void main(String[] args) throws Exception {
        File input = new File("./testInput");
        Scanner reader = new Scanner(input);

        ArrayList<Integer> points = new ArrayList<Integer>();

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            System.out.println(data);
            String[] dataSplit = data.split(",");
            points.add((Integer.valueOf(dataSplit[0]) - Integer.valueOf(dataSplit[1])));
            System.out.println(points);
        }

        reader.close();
    }
}