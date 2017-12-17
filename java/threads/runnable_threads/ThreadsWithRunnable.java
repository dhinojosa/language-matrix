import java.time.LocalDateTime;

class ThreadsWithRunnable {
    static class MyRunnable implements Runnable {
       private boolean done = false;

       public void finish() {
          this.done = true;
       }

       public void run() {
           while (!done) {
             try {
               Thread.sleep(1000); 
             } catch (InterruptedException ie) {
               //ignore
             }
             System.out.print(String.format("In Run: [%s] %s\r\n", 
                 Thread.currentThread().getName(), LocalDateTime.now()));
           }
       }
    }

    public static void main(String[] args) throws InterruptedException {
         System.out.print(String.format("In Main: [%s] %s\r\n", 
              Thread.currentThread().getName(), LocalDateTime.now()));
         MyRunnable runnable = new MyRunnable();
         Thread thread = new Thread(runnable);
         thread.start();
         Thread.sleep(5000);
         runnable.finish();
         thread.interrupt();
    }
}
