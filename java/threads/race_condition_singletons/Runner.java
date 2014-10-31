public class Runner {
   public static void main(String[] args) {
      LazyInitRace race = new LazyInitRace();

      Runnable runnable = new Runnable() {
           public void run() {
               System.out.println(race.getInstance().hashCode());
           }
      };

      Thread thread1 = new Thread(runnable);
      Thread thread2 = new Thread(runnable);
      thread1.start();
      thread2.start();
   }

