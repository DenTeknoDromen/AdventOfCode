// Create a Main class
public class test {
  int x;  // Create a class attribute

  // Create a class constructor for the Main class
  public test(int y, String test) {
    if (test == "")
    x = y;  // Set the initial value for the class attribute x
  }

  public static void main(String[] args) {
    test myObj = new test(17); // Create an object of class Main (This will call the constructor)
    System.out.println(myObj.x); // Print the value of x
  }
}

// Outputs 5