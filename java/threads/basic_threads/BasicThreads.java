import java.time.LocalDateTime;

class BasicThreads {
    static class MyThread extends Thread {
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
         MyThread thread = new MyThread();
         thread.start();
         Thread.sleep(5000);
         thread.finish();
         thread.interrupt();
    }
}
