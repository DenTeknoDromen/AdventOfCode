import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Dec4 {

    private static HashMap<String, char[]> grid;

    public static void main(String[] args) throws Exception {
        File input = new File("./testInput");
        Scanner reader = new Scanner(input);
        
        grid = new HashMap<String, char[]>();
        int output = 0;

        int i = 0;
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            grid.put(String.valueOf(i), data.toCharArray());
            i += 1;
        }
        while (searchGrid() != 0) {
            System.out.println(output);
            output += 1;   
        }
        System.out.println("Output: " + output);
        reader.close();
    }
    static int searchGrid() {
        int numofRolls = 0;
        for (int x = 0; x < grid.get("0").length; x++) {
            for (int y = 0; y < grid.size(); y++) {
                if (grid.get(String.valueOf(x))[y] == '.')
                    continue;
                //output = (getVertical(x, y) < 4) ? output + 1 : output + 0;
                numofRolls = (getVertical(x, y) < 4) ? numofRolls + 1 : numofRolls + 0;
                
            }
        }
        return numofRolls;
    }
    static int getVertical(int x, int y) {
        int numofRolls = 0;
        int[] yRange = new int[2];
        yRange[0] = (y == 0) ? y : y - 1;
        yRange[1] = (y == grid.get("0").length - 1) ? y : y + 1;

        for (int i = yRange[0]; i <= yRange[1]; i++){
            if (grid.containsKey(String.valueOf(x - 1))){
                numofRolls = (grid.get(String.valueOf(x - 1))[i] == '@') ? numofRolls + 1 : numofRolls + 0;
            }
            if (grid.containsKey(String.valueOf(x + 1))) {
                numofRolls = (grid.get(String.valueOf(x + 1))[i] == '@') ? numofRolls + 1 : numofRolls + 0;
            }
            if (i == y - 1 || i ==  y + 1) {
                numofRolls = (grid.get(String.valueOf(x))[i] == '@') ? numofRolls + 1 : numofRolls + 0;
            }
        }
        return numofRolls;
    }
}