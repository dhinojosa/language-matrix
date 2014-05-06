import java.util.function.Function;

public class Closures {

   public static Integer foo(Function<Integer, Integer> w) {
      return w.apply(5);
   }

   public static void main(String[] args) {
      {
           //in order "close around" a variable, where as before
           //it had to be final
           final Integer x = 3;
           Function<Integer, Integer> y = (Integer z) ->  x + z;
           assert(foo(y) == 8);
      }
      {
           //the variable now has to be effectively final
           Integer x = 3;
           Function<Integer, Integer> y = (Integer z) ->  x + z;
           assert(foo(y) == 8);
      }
   }
}
