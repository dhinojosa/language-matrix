package com.evolutionnext.concurrency.threads;

import java.time.LocalDateTime;

class MyThread extends Thread {
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

    public static void main(String[] args) throws InterruptedException {
        System.out.printf("Process Starting on %s%n", ProcessHandle.current().pid());
        System.out.format("Thread starting on %s%n", Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.start();

        Thread.sleep(10000);

        myThread.finish();
        System.out.format("Thread ending on %s", Thread.currentThread().getName());

        //JVM will end
    }
}
