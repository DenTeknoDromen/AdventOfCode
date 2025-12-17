import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Dec1 {
    public static void main(String[] args) throws Exception {
        File input = new File("./testInput");
        Scanner reader = new Scanner(input);

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            System.out.println(data);
        }

        reader.close();
    }
}