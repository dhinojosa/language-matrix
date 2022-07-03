package com.evolutionnext.concurrency.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class RunnableCommand implements Runnable {

    private final CountDownLatch countDownLatch;
    private final String name;

    public RunnableCommand(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random(304L);
        try {
            Thread.sleep(random.nextInt(3) * 1000);
            System.out.printf("Counting down in %s on Thread %s%n", name,
                    Thread.currentThread().getName());
            countDownLatch.countDown();
            System.out.printf("Counted down in %s on Thread %s%n", name,
                    Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
