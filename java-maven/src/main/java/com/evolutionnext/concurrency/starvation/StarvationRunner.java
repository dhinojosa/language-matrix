package com.evolutionnext.concurrency.starvation;

public class StarvationRunner {
    public static void main(String[] args) {
        Worker worker = new Worker();

        //We are creating ten threads
        for (int i = 0; i < 10; i++) {
            new Thread(worker::work).start();
        }
    }
}
