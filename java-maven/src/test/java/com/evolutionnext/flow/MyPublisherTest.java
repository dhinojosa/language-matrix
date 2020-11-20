package com.evolutionnext.flow;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;

public class MyPublisherTest {

    @Test
    public void testUsingPublisher() throws InterruptedException {
        ExecutorService executorService =
            Executors.newFixedThreadPool(100);


        MyPublisher myPublisher = new MyPublisher(executorService);
        myPublisher.subscribe(new Flow.Subscriber<Long>() {
            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                this.subscription.request(1000);
            }

            @Override
            public void onNext(Long item) {
                if (item < 0) throw new RuntimeException("Nope");
                System.out.println("S1: (" +
                    Thread.currentThread().getName() + ")" + item);
                if (item == 350) {
                    this.subscription.cancel();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("S1: Done!");
            }
        });


        myPublisher.subscribe(new Flow.Subscriber<Long>() {
            private Flow.Subscription subscription;

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                this.subscription.request(1000);
            }

            @Override
            public void onNext(Long item) {
                System.out.println("S2: (" +
                    Thread.currentThread().getName() + ")" + item);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("S2: Done!");
            }
        });

        Thread.sleep(60_000);
    }
}
