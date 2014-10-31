public class ExpensiveObject {
   public ExpensiveObject() {
      try {
         Thread.sleep(10000);
      } catch (InterruptedException ie) {
         ie.printStackTrace();
      }
   }
}
