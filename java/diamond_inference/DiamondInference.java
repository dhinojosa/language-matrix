import java.util.HashMap;
import java.util.Map;

public class DiamondInference {

   public static Map<String, Integer> fillValuesImmutably
                                      (Map<String, Integer> map) {
      Map<String, Integer> copy = new HashMap<>();
      copy.put("One", 1);
      copy.put("Two", 2);
      copy.put("Three", 3);
      return copy;
   }

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

     {
        //The diamond operator can also be used when sending it as
        //a parameter to a method, the parameterized types will be
        //inferred
        Map<String, Integer> copy = fillValuesImmutably(new HashMap<>());
        assert (copy.size() == 3);
     }
  }
}
