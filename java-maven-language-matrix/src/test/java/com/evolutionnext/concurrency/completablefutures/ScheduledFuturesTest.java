package com.evolutionnext.concurrency.completablefutures;


import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ScheduledFuturesTest {

    /**
     * Demo 5: Scheduled Delay
     */
    @Test
    public void testScheduledFuture()
            throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(5);

        ScheduledFuture<Integer> scheduledFuture =
                scheduledExecutorService
                .schedule(
                        () -> {
                            System.out.println("In Schedule: " +
                                    Thread.currentThread().getName());
                            return 40 + 50;
                        }, 10, TimeUnit.SECONDS);

        System.out.println(scheduledFuture.get()); //get blocks
        Thread.sleep(1000);
    }

    /**
     * Demo 6: Scheduled Futures
     */
    @Test
    public void testScheduledFutureWithFixedDelay() throws
        InterruptedException {

        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(6);

        final ScheduledFuture<?> scheduledFuture =
                scheduledExecutorService
                        .scheduleWithFixedDelay(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("In Schedule: " +
                                Thread.currentThread().getName());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }, 1, 1, TimeUnit.SECONDS);

        Thread.sleep(6014);
        scheduledFuture.cancel(true);
        Thread.sleep(2000);
    }

    @Test
    public void testScheduledFutureWithFixedRate()
            throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(3);

        final ScheduledFuture<?> scheduledFuture =
                scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("In Schedule: " +
                                Thread.currentThread().getName());
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }, 1, 2, TimeUnit.SECONDS);

        Thread.sleep(7000);
        scheduledFuture.cancel(true);
        Thread.sleep(1000);
    }
}
