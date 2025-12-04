import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class DEC16 {

    static ArrayList<char[]> map = new ArrayList<char[]>();
    static ArrayList<String> tiles = new ArrayList<String>();

    public static void main(String[] args) throws Exception{
        
        File input = new File("DEC16_input.txt");
        Scanner reader = new Scanner(input);

        while (reader.hasNextLine()) {
            map.add(reader.nextLine().toCharArray());
        }
        for (char[] i : map) {
            System.out.println(Arrays.toString(i));
        }

        reader.close();
    }
    // Objekt för att simulera strålen
        // Ett sätt att hålla reda på riktning
        // Ett sätt att hålla kolla på position
    
public class beam {
    static String direction;
    static int[] position = new int[2];

    public beam(String[] args) {
        for (int i = 0; i < 100; i++) {
            position[0] += navigator(direction)[0];
            position[1] += navigator(direction)[1];
        }        
    }

    public beam(int x, int y, String dir) {
        position[0] = y;
        position[1] = x;
        direction = dir;
    }
    static int[] navigator(String direction) {
        int[] cordinates = new int[2];
        switch (direction) {
            case "Up":
                cordinates[0] = -1;
                cordinates[1] = 0;
            case "Down":
                cordinates[0] = 1;
                cordinates[1] = 0;
            case "Left":
                cordinates[0] = 0;
                cordinates[1] = -1;
            case "Right":
                cordinates[0] = 0;
                cordinates[1] = 1;
        }
        return cordinates;
    }
    static String obstacles(String dir, char obstacle) {
        String direction = dir;
        switch (obstacle) {
            case '/':
                direction = slash(direction);
            case '\\':
                direction = backslash(direction);
            case '-':
                //direction = 
            case '|':
                // Method for handling |
        }
        return direction;
    }
    // Metoder för att simulera speglarna
    static String slash(String dir) {
        String direction = dir;
        switch (direction) {
            case "Up":
                direction = "Right";
            case "Down":
                direction = "Left";
            case "Left":
                direction = "Up";
            case "Right":
                direction = "Down";
        }
        return direction;
    }
    static String backslash(String dir) {
        String direction = dir;
        switch (direction) {
            case "Up":
                direction = "Left";
            case "Down":
                direction = "Right";
            case "Left":
                direction = "Down";
            case "Right":
                direction = "Up";
        }
        return direction;
    }
    static String dash(String dir) {
        String direction = dir;
        if (direction == "Up" || direction == "Down") {
            direction = "Left";
            beam newbeam = new beam(position[0], position[1] + 1, "Right");
        }
        return direction;
    }
    static String line(String dir) {
        String direction = dir;
        if (direction == "Left" || direction == "Right") {
            direction = "Up";
            beam newbeam = new beam(position[0] + 1, position[1], "Down");
        }
        return direction;
    }
    // Keeps track of which tiles have been energized
    static void iluminate() {
        String str_pos = Integer.toString(position[0]);
        str_pos += ":";
        str_pos += Integer.toString(position[1]);
        if (!tiles.contains(str_pos)) {
            tiles.add(str_pos);
        }
    }
}
    // Lista för att räkna vilka tiles som har använts
}