/* Any `interface` with one method can be used as, and broken
 * down simply as a lambda expression.
 **/
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lambdas {
   //See SampleInterface.java
   public static int sum(SampleInterface si, int otherNumber) {
      return si.transform(otherNumber);
   }

   public static void main(String[] args) {
       //Using the interface as a lambda
       assert(sum((a -> a + 4), 5) == 9); // a is inferred to be an int
       assert(sum((int a) -> a + 5, 9) == 14); //a is explicit

       //Some other lambdas with one method interfaces
       Runnable r = () -> System.out.println("Run in a separate thread");
       ActionListener al = (evt) -> evt.getActionCommand();

       //Multistatement lambda
       SampleInterface si2 = a -> {
          int total = 3 + 4;
          return total + 19;
       };
   }
}
