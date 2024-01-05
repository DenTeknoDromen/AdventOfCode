import java.io.File;
import java.util.Scanner;
import java.util.HashMap;

public class DEC19{
    static HashMap<String, String> workandflow= new HashMap<String, String>();

    public static void main(String[] args) throws Exception{
    File input = new File("DEC19_input.txt");
    Scanner reader = new Scanner(input);

    while (reader.hasNextLine()) {
        String[] data = reader.nextLine().split("{");
        workandflow.put(data[0], data[1]);
    }
    reader.close();
    System.out.println(workandflow.toString());


    

    }
    static int workflow (Part curr_part) {
        String name = "in";
        String curr_flow = workandflow.get(name);
        String[] steps;
        String[] substep;          

        //Split string at ", "
        steps = curr_flow.split(", ");
        // if array string constains ">"
        for (String x : steps) {
            if (x.contains(">")) ) {

                //Split string at ":" and ">"
                substep = x.split(":");
                String condition = substep[0];
                String result = substep[1];
                substep = condition.split("<");
                if (curr_part.partnames.get(substep[0]) < Integer.parseInt(substep[1])) {
                    name = result;
                }
            if (x.contains(">")) {
                //Split string at ":" and ">"
                substep = x.split(":");
                condition = substep[0];
                result = substep[1];
                substep = condition.split(">");
                if (curr_part.partnames.get(substep[0]) > Integer.parseInt(substep[1])) {
                    name = result;
                }
        }
        int index = 0;

        // check if statement
        //if false next array string
        //Same for 
        if (name == "A") {
            return curr_part.sum;
        } else {
            return 0;
        }
    }
    static boolean sizecompare(char op, int a, int b) {
        if (op == '>') {
            return (a > b);
        } else {
            return (a < b);
        }
    }
}
class Part {
    int sum;
    HashMap<String, Integer> partnames = new HashMap<String, Integer>();

    public Part(int x, int m, int a, int s) {
        partnames.put("x", x);
        partnames.put("m", m);
        partnames.put("a", a);
        partnames.put("s", s);
    }
}