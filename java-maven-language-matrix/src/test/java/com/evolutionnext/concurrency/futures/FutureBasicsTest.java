package com.evolutionnext.concurrency.futures;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class FutureBasicsTest {

    @Test
    public void testBasicFuture() throws ExecutionException,
        InterruptedException {
        ExecutorService fixedThreadPool =
                Executors.newFixedThreadPool(5);

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Inside ze future: " +
                        Thread.currentThread().getName());
                System.out.println("Future priority: "
                        + Thread.currentThread().getPriority());
                Thread.sleep(5000);
                return 5 + 3;
            }
        };

        System.out.println("In test:" +
                Thread.currentThread().getName());
        System.out.println("Main priority" +
                Thread.currentThread().getPriority());

        Future<Integer> future = fixedThreadPool.submit(callable);

        //This will block
        Integer result = future.get(); //block
        System.out.println("result = " + result);
    }


    @Test
    public void testBasicFutureAsync() throws ExecutionException,
        InterruptedException {
        ExecutorService cachedThreadPool =
                Executors.newCachedThreadPool();

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(3000);
                return 5 + 3;
            }
        };

        Future<Integer> future = cachedThreadPool.submit(callable);

        //This will not block
        while (!future.isDone()) {
            System.out.println("I am doing something else on thread: " +
                    Thread.currentThread().getName());
        }

        Integer result = future.get();
        System.out.println("result = " + result);
    }


    private Future<Stream<String>> downloadingContentFromURL(final String url) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        return cachedThreadPool.submit(new Callable<Stream<String>>() {
            @Override
            public Stream<String> call() throws Exception {
                URL netUrl = new URL(url);
                URLConnection urlConnection = netUrl.openConnection();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                urlConnection.getInputStream()));
                return reader
                        .lines()
                        .flatMap(x -> Arrays.stream(x.split(" ")));
            }
        });
    }

    @Test
    public void testGettingUrl() throws ExecutionException, InterruptedException {
        Future<Stream<String>> future =
                downloadingContentFromURL("https://openjdk.java.net/");
        while (!future.isDone()) {
            Thread.sleep(1000);
            System.out.println("Doing Something Else");
        }
        Stream<String> allStrings = future.get();
        allStrings
                .filter(x -> x.contains("Java"))
                .forEach(System.out::println);
        Thread.sleep(5000);
    }

    @Test
    public void testFutureTasksUsingThreadPool()
            throws InterruptedException, ExecutionException {

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return 510 + 40;
            }
        });


        System.out.println("Running Future Task");
        cachedThreadPool.execute(futureTask);
        while (!futureTask.isDone()) {
            Thread.sleep(1000);
            System.out.println("Doing Something Else");
        }
        System.out.println(futureTask.get());
        Thread.sleep(1000);
    }


    @Test
    public void testFutureTaskAsRunnableInThread() throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask =
                new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return 510 + 40;
            }
        });

        Thread thread = new Thread(futureTask);
        thread.start();

        Integer result = futureTask.get();  //Block
        System.out.println("result = " + result);
        Thread.sleep(5000);
    }


    @Test
    public void testFutureTaskAsRunnableDirect() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask =
                new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return 510 + 40;
            }
        });


        ExecutorService executorService =
                Executors.newFixedThreadPool(4);
        executorService.submit(futureTask);
        System.out.println("Submitted Future Task");
        Integer result = futureTask.get(); //Block!
        System.out.println("result = " + result);
        Thread.sleep(5000);
    }


    @Test
    public void testFutureTaskUsingExecute() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return 510 + 40;
            }
        });

        ExecutorService service =
                Executors.newFixedThreadPool(3);
        System.out.println("Starting task!");
        service.execute(futureTask);
        System.out.println("result = " + futureTask.get()); //Block
        System.out.println("isDone = " + futureTask.isDone());
        Thread.sleep(5000);
    }
}
