package com.evolutionnext.collections.queue;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class QueueTest {
    @Test
    void testQueueUsingLinkedList() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(40);
        boolean result = queue.offer(50);
        assert(result);
        boolean result2 = queue.offer(60);
        assert(result2);
        assertThat(queue.peek()).isEqualTo(40);
        assertThat(queue.poll()).isEqualTo(40);
    }
}
