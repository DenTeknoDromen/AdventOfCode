import java.util.HashMap;
import java.util.ArrayList;

public class DEC20 {

    // https://adventofcode.com/2023/day/20
    //

    static HashMap<String, Module> moduleMap = new HashMap<String, Module>();

    public static void main(String[] args) {
        
    }
    // Class representing the different modules
    // Can be initialized to either "Flip-Flop" or "Conjuction"
    static class Module {
        
        static Boolean onoff = false;
        static String moduleType;
        ArrayList<String> destinationList= new ArrayList<String>();
        HashMap<String, String> inputList = new HashMap<String, String>();

        public Module(String type, ArrayList<String> destinations) {
            moduleType = type;
            for (String i : destinations) {
                destinationList.add(i);
            }
        }
        static void recievePulse (String pulse) {
            if (moduleType.equals("FlipFlop")) {
                flipFlop(pulse);
            } else {
                conjunction(pulse);
            }
        }
        static void flipFlop (String pulse) {
            if (pulse.equals("Low")) {
                sendPulse(switchPulse());
            }
        }
        static String switchPulse() {
            if (onoff) {
                onoff = false;
                return "Low";
            } else {
                onoff = true;
                return "High";
            }
        }
        static void conjunction (String pulse) {
            
        }
        static void sendPulse(String pulse) {

        }

    }

}
