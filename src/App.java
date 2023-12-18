import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        ArrayList<String> testlist =  new ArrayList<String>();
        testlist.add("Äpple");
        testlist.add("Päron");
        testlist.add("Banan");
        for (String i : testlist) {
            if (i.contains("Ban")) {
                System.out.println("True");
            }            
        }

    }
}
