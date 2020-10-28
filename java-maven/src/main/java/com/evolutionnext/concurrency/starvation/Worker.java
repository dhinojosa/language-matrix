package com.evolutionnext.concurrency.starvation;

public class Worker {

    public synchronized void work() {
        String name = Thread.currentThread().getName();

        while (true) {
            System.out.println(name + " is working");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //wait will give other chances to other threads
            try {
                wait(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
