package com.evolutionnext.concurrency.daemon;

public class DaemonRunner {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Going...");

            }
        });

        t.setDaemon(true); //Run first then uncomment
        t.start();
    }
}
