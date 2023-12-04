import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.MatchResult;

public class DEC2 {
    public static void main(String[] args) throws Exception{
        File input = new File("src/example.txt");
        Scanner reader = new Scanner(input);

        Pattern pattern = Pattern.compile("[0-9] blue|red|green");
        

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            Matcher matcher = pattern.matcher(data);
            boolean matchFound = matcher.find();
            String output = (matchFound) ? matcher.group() : "regex not found";
            System.out.println(output);

        }
        reader.close();
    }
}