import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class DEC2 {
    public static void main(String[] args) throws Exception{
        File input = new File("example.txt");
        Scanner reader = new Scanner(input);

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            data = data.split(": ")[1];

            String[] lst_data = data.split("; ");
            
            System.out.println(Arrays.toString(lst_data));
        }
        reader.close();
    }
}