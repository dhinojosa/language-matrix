import java.util.HashMap;
import java.util.Map;

public class DiamondInference {
  public static void main(String[] args) {
     {
        //Previous to Java 7, you had to declare all generic types when 
        //instantiating a parameterized object
        Map<String, Integer> map = new HashMap<String, Integer>();
     }

     {
        //With the diamond operator you can can just include the 
        //diamond operator `<>` and the parameterized type will be inferred
        Map<String, Integer> map = new HashMap<>();
     }
  }
}
