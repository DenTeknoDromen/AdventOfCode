import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Dec11 {

    // static ArrayList<String[]> paths = new ArrayList<String[]>();
    static int validPaths = 0;

    public static void main(String[] args) throws Exception {
        File input = new File("./input");
        Scanner reader = new Scanner(input);

        HashMap<String, String[]> devices = new HashMap<String, String[]>();
        // ArrayList<String> res = new ArrayList<String>();
        LinkedList<String> res = new LinkedList<String>();

        while (reader.hasNextLine()) {
            String data = reader.nextLine();;
            String[] dataSplit = data.split(": ");
            devices.put(dataSplit[0], dataSplit[1].split(" "));
        }
        reader.close();
        devices.put("out", new String[0]);

        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        for (String i : devices.keySet()) {
            visited.put(i, false);
        }

        // dfs(devices, visited, "you", res);
        dfs(devices, visited, "dac", res);

        // int validPaths = 0;
        // for (String[] i : paths) {
        //     String currPath = Arrays.toString(i);
        //     validPaths = (currPath.contains("fft") && currPath.contains("dac")) ? validPaths + 1 : validPaths;
        // }
        // System.out.println("Number of paths: " + paths.size());
        System.out.println("Number of valid paths: " + validPaths);

    }

    static void dfs(HashMap<String, String[]> devices, HashMap<String, Boolean> visited, String node, LinkedList<String> res) {
        res.add(node);

        if (visited.get(node)) {
            System.out.println("I´ve been here before");
        }
        if (node.equals("out")) {
            // System.out.println(res);
            validPaths += 1;
            // System.out.println(res);
            // validPaths = (res.contains("fft") && res.contains("dac")) ? validPaths + 1 : validPaths;
            //String[] tempArray = new String[res.size()];
            //paths.add(res.toArray(tempArray));
        } else {
            visited.put(node, true);
        }
        System.out.println(res);
        for (String i : devices.get(node)) {
            while (!res.getLast().equals(node)) {
                res.removeLast();
            }
            if (!visited.get(i)) {
                dfs(devices, visited, i, res);
            }
            // dfs(devices, visited, i, res);
        }
    }
}