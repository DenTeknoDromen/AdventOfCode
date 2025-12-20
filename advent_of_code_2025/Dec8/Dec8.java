import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Dec8 {
    public static void main(String[] args) throws Exception {
        File input = new File("./testInput");
        Scanner reader = new Scanner(input);

        ArrayList<double[]> cords = new ArrayList<double[]>();
        TreeMap<Double, String> distances = new TreeMap<Double, String>();
        ArrayList<String> circuits = new ArrayList<String>();

        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            cords.add(Arrays.stream(data.split(",")).mapToDouble(Double::parseDouble).toArray());
        }
        reader.close();
        double currDistance = 0;
        String currCords = "";
        for (int a = 0; a < cords.size() - 1; a++) {
            for (int b = a + 1; b < cords.size(); b++) {
                currDistance = getDistance(cords.get(a), cords.get(b));
                currCords = String.valueOf(a) + "-" + String.valueOf(b);
                distances.put(currDistance, currCords);
            }
        }

        // circuits.add((distances.firstKey() + "-"));
        int index = 0;
        for (Double key : distances.keySet()) {
            if (index >= 10)
                break;
            if (!checkCircuits(circuits, distances.get(key))) {
                circuits.add(distances.get(key) + "-");
            }
            index += 1;
        }
        for (Double key : distances.keySet()) {
            System.out.println(key + ": " + distances.get(key));
        }

        for (String i : circuits) {
            System.out.println(i);
            System.out.println("Circuit length: " + i.split("-").length);
        }
        System.out.println("Number of circuits: " + circuits.size());
    }

    static double getDistance(double[] posA, double[] posB) {
        double distance = 0;
        for (int i = 0; i < posA.length; i++) {
            distance += Math.pow(posA[i] - posB[i], 2);
        }
        return Math.sqrt(distance);
    }

    static Boolean checkCircuits(ArrayList<String> circuits, String currCords) {
        String[] cordSplit = currCords.split("-");
        for (int i = 0; i < circuits.size(); i++) {
            String currCircuit = circuits.get(i);
            if (currCircuit.contains(cordSplit[0]) && currCircuit.contains(cordSplit[1])) {
                return true;
            } else if (currCircuit.contains(cordSplit[0])) {
                circuits.set(i, circuits.get(i) + cordSplit[1] + "-");
                return true;
            } else if (circuits.get(i).contains(cordSplit[1])) {
                circuits.set(i, circuits.get(i) + cordSplit[0] + "-");
                return true;
            }
        }
        return false;
    }
}