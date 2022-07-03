package com.evolutionnext.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 *
 * Countdown latch
 *
 * Sometimes you will want a thread to wait until one or more events have
 * occurred. To handle such a situation, the concurrent API supplies
 * CountDownLatch. A CountDownLatch is initially created with a count of the
 * number of events that must occur before the latch is released. Each time
 * an event happens, the count is decremented. When the count reaches zero,
 * the latch opens.
 */
public class CountdownLatchRunner {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new RunnableListener(countDownLatch, "A")).start();
        new Thread(new RunnableListener(countDownLatch, "B")).start();
        Thread.sleep(2000);
        System.out.println(countDownLatch.getCount());
        new Thread(new RunnableCommand(countDownLatch, "A")).start();
        Thread.sleep(2000);
        System.out.println(countDownLatch.getCount());
        new Thread(new RunnableCommand(countDownLatch, "B")).start();
        Thread.sleep(2000);
        System.out.println(countDownLatch.getCount());
    }
}
