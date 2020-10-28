package com.evolutionnext.concurrency.phaser;

import java.util.concurrent.Phaser;

public class MyRunnable implements Runnable {

    private final Phaser phaser;
    private final String name;

    public MyRunnable(Phaser phaser, String name) {
        this.phaser = phaser;
        this.name = name;
    }

    @Override
    public void run() {
        phaser.register();
        System.out.format("Processing Phase 1 of %s in Thread: %s%n", name,
                Thread.currentThread().getName());
        phaser.arriveAndAwaitAdvance();
        System.out.format("Processing Phase 2 of %s in Thread: %s%n", name,
                Thread.currentThread().getName());
        phaser.arriveAndAwaitAdvance();
        System.out.format("Processing Phase 3 %s in Thread: %s%n", name,
                Thread.currentThread().getName());
        phaser.arriveAndAwaitAdvance();
        System.out.format("Processing Phase 4 %s in Thread: %s%n", name,
                Thread.currentThread().getName());
        phaser.arriveAndAwaitAdvance();
        System.out.format("Finally finishing %s in Thread: %s%n", name,
                Thread.currentThread().getName());
    }
}
