package com.xyzcorp.demos.concurrent.synchronizers.cyclicbarrier;

import org.junit.Test;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    @Test
    public void testCyclicBarrierWithOneThread() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, () -> {
            System.out.println("Done");
        });

        Thread t1 = new Thread(new MyRunnable(cyclicBarrier, "A"));
        Thread t2 = new Thread(new MyRunnable(cyclicBarrier, "B"));
        Thread t3 = new Thread(new MyRunnable(cyclicBarrier, "C"));

        t1.start();
        t2.start();
        t3.start();
    }

    @Test
    public void testCyclicBarrierWithThreeThreads() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("Done");
        });

        Thread t1 = new Thread(new MyRunnable(cyclicBarrier, "A"));
        Thread t2 = new Thread(new MyRunnable(cyclicBarrier, "B"));
        Thread t3 = new Thread(new MyRunnable(cyclicBarrier, "C"));

        t1.start();
        t2.start();
        t3.start();


    }

    @Test
    public void testCyclicBarrierOfSevenWithThreeThreads() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("Done");
        });

        Thread t1 = new Thread(new MyRunnable(cyclicBarrier, "A"));
        Thread t2 = new Thread(new MyRunnable(cyclicBarrier, "B"));
        Thread t3 = new Thread(new MyRunnable(cyclicBarrier, "C"));

        t1.start();
        t2.start();
        t3.start();


    }
}
