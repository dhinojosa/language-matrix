package com.xyzcorp.demos.concurrent.threads;

import org.junit.Test;

public class ThreadsTest {

    @Test
    public void testThreadJoin() throws InterruptedException {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.format("Did two seconds on Thread %s\n",
                        Thread.currentThread().getName());
            }
        };

        thread1.start();
        thread1.join();
        System.out.println("Thread test done");
    }

}
