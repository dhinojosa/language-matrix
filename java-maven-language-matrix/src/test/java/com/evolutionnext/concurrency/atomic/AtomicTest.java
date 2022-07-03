/*
 * Copyright (c) 2018 Hinojosa, Daniel <dhinojosa@evolutionnext.com>
 * Author: Hinojosa, Daniel <dhinojosa@evolutionnext.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.evolutionnext.concurrency.atomic;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtomicTest {

    @Test
    public void testUseWithExecutor() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        AtomicInteger atomicInt = new AtomicInteger(0);
            IntStream.range(0, 1000)
                     .forEach(i ->
                         executor.submit(atomicInt::incrementAndGet));
            Thread.sleep(2000);
            assert (atomicInt.get() == 1000);
            executor.shutdown();
    }

    @Test
    public void testUpdateAndGet() {
        AtomicInteger atomicInt = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 1000)
                 .map(x -> x + atomicInt.updateAndGet(z -> z + x));

        executor.shutdown();

        System.out.println(atomicInt.get());    // => 2000
    }

    @Test
    public void testAccumulateAndGet() {
        AtomicInteger atomicInteger = new AtomicInteger(40);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() ->
            atomicInteger.accumulateAndGet(10, (previousState, value) -> {
                System.out.format("Accumulation: %d %d", previousState,
                    value);
                return previousState + value;
            }));

        assertEquals(40, atomicInteger.get());
    }
}
