package com.evolutionnext.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class RunnableListener implements Runnable {

    private CountDownLatch countDownLatch;
    private String name;

    public RunnableListener(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.format("Processing %s in Thread: %s%n", name,
                Thread.currentThread().getName());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.format("Finally finishing %s in Thread: %s%n", name,
                Thread.currentThread().getName());
    }
}
