package com.evolutionnext.concurrency.completablefutures;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.InputMismatchException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

public class CompletableFutureTest {

    private CompletableFuture<Integer> integerFuture1;
    private CompletableFuture<Integer> integerFuture2;
    private CompletableFuture<String> stringFuture1;
    private ExecutorService executorService;

    @BeforeEach
    public void startUp() {
        executorService = Executors.newCachedThreadPool();

        integerFuture1 = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        System.out.println("intFuture1 is Sleeping in thread: "
                                + Thread.currentThread().getName());
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 5;
                }, executorService);

        integerFuture2 = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        System.out.println("intFuture2 is sleeping in thread: "
                                + Thread.currentThread().getName());
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return 555;
                });

        stringFuture1 = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        System.out.println("stringFuture1 is sleeping in " +
                                "thread: "
                                + Thread.currentThread().getName());
                        Thread.sleep(4300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "Bloomington, MN";
                }, executorService);
    }


    @Test
    public void completableFutureWithThenAccept() throws InterruptedException {
        integerFuture1.thenAccept(System.out::println);
        Thread.sleep(5000);
    }

    @Test
    public void completableFutureWithThenApply() throws InterruptedException {
        integerFuture1.thenApply(x -> {
            System.out.println("In Block:" +
                    Thread.currentThread().getName());
            return String.valueOf(x + 19);
        }).thenAccept(s -> {
            System.out.println("In the accept: " + Thread.currentThread().getName());
            System.out.println(s);
        });
        System.out.println("This line should appear somewhat first");
        Thread.sleep(5000);
    }

    @Test
    public void completableFutureWithThenApplyTidied() throws InterruptedException {
        integerFuture1.thenApply(x -> String.valueOf(x + 19))
                      .thenAccept(System.out::println);
        Thread.sleep(5000);
    }

    @Test
    public void completableFutureWithThenApplyAsync() throws InterruptedException {

        integerFuture1.thenApplyAsync(x1 -> {
            System.out.println("In Block:" +
                    Thread.currentThread().getName());
            return "" + (x1 + 19);
        }).thenAcceptAsync((x) -> {
            System.out.println("Accepting in:" + Thread.currentThread().getName());
            System.out.println("x = " + x);
        }, executorService);

        System.out.println("Main:" + Thread.currentThread().getName());
        Thread.sleep(5000);
    }

    @Test
    public void completableFutureWithThenRun() throws InterruptedException {
        integerFuture1.thenRun(() -> {
            String successMessage =
                    "I am doing something else once" +
                            " that future has been triggered!";
            System.out.println
                    (successMessage);
            System.out.println("Run inside of " +
                    Thread.currentThread().getName());
        });
        Thread.sleep(3010);
    }

    @Test
    public void completableFutureExceptionally() throws InterruptedException {
        stringFuture1.thenApply((s) -> Integer.parseInt(s))
                     .exceptionally(t -> {
                         //t.printStackTrace();
                         return -1;
                     }).thenAccept(System.out::println);
        System.out.println("This message should appear first.");
        Thread.sleep(6000);
    }

    @Test
    public void completableFutureHandle() throws InterruptedException {
        stringFuture1.thenApply((s) -> Integer.parseInt(s)).handle(
                new BiFunction<Integer, Throwable, Integer>() {
                    @Override
                    public Integer apply(Integer item, Throwable throwable) {
                        if (throwable == null) return item;
                        else return -1;
                    }
                }).thenAccept(System.out::println);

        Thread.sleep(6000);
    }

    public CompletableFuture<Integer>
    getTemperatureInFahrenheit(final String cityState) {
        return CompletableFuture.supplyAsync(() -> {
            //We go into a webservice to find the weather...
            System.out.println("In getTemperatureInFahrenheit: " +
                    Thread.currentThread().getName());
            System.out.println("Finding the temperature for " + cityState);
            return 75;
        });
    }

    @Test
    public void completableCompose() throws InterruptedException {
        CompletableFuture<Integer> integerCompletableFuture =
                stringFuture1.thenCompose(
                        cityState -> {
                            System.out.println("Inside compose:" +
                                    Thread.currentThread().getName());
                            return getTemperatureInFahrenheit(cityState);
                        });

        integerCompletableFuture
                .thenAccept(x -> {
                    System.out.println("Inside accept:" +
                            Thread.currentThread().getName());
                    System.out.println(x);
                });
        Thread.sleep(6000);
    }

    @Test
    public void completableCombine() throws InterruptedException {
        CompletableFuture<Integer> combine =
                integerFuture1
                        .thenCombine(
                                integerFuture2, (x, y) -> {
                                    System.out.println("Inside f:" + Thread.currentThread().getName());
                                    return x + y;
                                });
        combine.thenAccept(System.out::println);
        Thread.sleep(6000);
    }

    @Test
    public void completeAcceptBoth() throws InterruptedException {
        integerFuture1.thenAcceptBoth(integerFuture2, (x, y) -> {
            System.out.println("Inside of accept both:"
                    + Thread.currentThread().getName());
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        });
        Thread.sleep(6000);
    }

    @Test
    public void completeAcceptBothAsync() throws InterruptedException {
        integerFuture1.thenAcceptBothAsync(integerFuture2, (x, y) -> {
            System.out.println("Inside of accept both:"
                    + Thread.currentThread().getName());
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }, executorService);
        Thread.sleep(6000);
    }

    @Test
    public void testAllOf() throws InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture.allOf(integerFuture1, integerFuture2).join();
        long end = System.currentTimeMillis();
        System.out.println(
                "Guaranteed that all futures have completed in: "
                        + (end - start));
        Thread.sleep(6000);
    }

    @Test
    public void testAnyOf() throws InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture.anyOf(integerFuture1, integerFuture2).join();
        long end = System.currentTimeMillis();
        System.out.println(
                "Guaranteed that any of the futures have completed in: "
                        + (end - start));
        Thread.sleep(6000);
    }

    @Test
    public void testCompletableFuturePromise() throws InterruptedException {
        CompletableFuture<Integer> completableFuture =
                new CompletableFuture<>();

        completableFuture.thenAccept(System.out::println);

        System.out.println("Processing something else");
        Thread.sleep(1000);
        completableFuture.complete(42); //force a complete
        Thread.sleep(3000);
    }

    @Test
    public void testCompletableFuturePromiseWithException() {
        CompletableFuture<Integer> completableFuture =
                new CompletableFuture<>();

        completableFuture.handleAsync((item, throwable) -> {
            if (throwable != null) {
                throwable.printStackTrace();
                return -1;
            } else {
                return item;
            }
        });

        System.out.println("Processing something else");

        completableFuture.completeExceptionally(
                new InputMismatchException("Just for fun"));
    }

    @Test
    public void testCompletableWithTimeout() throws Exception {
        integerFuture1.orTimeout(15, TimeUnit.MILLISECONDS)
                      .exceptionally(x -> -1).thenAccept(System.out::println);
        Thread.sleep(1000);
    }
}
