package com.evolutionnext.flow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class MyPublisher implements Flow.Publisher<Long> {
    private final ExecutorService executorService;

    public MyPublisher(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public void subscribe(Flow.Subscriber<? super Long> subscriber) {
        subscriber.onSubscribe(new Flow.Subscription() {
            AtomicLong count = new AtomicLong(0);
            AtomicBoolean done = new AtomicBoolean(false);

            @Override
            public void request(long n) {
                executorService.submit(() -> {
                    while (!done.get() && ((count.incrementAndGet()) < n)) {
                        subscriber.onNext(count.get());
                    }
                });
            }

            @Override
            public void cancel() {
                done.set(true);
            }
        });
    }
}
