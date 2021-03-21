package com.evolutionnext.collections.priorityqueue;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class PriorityQueueTest {

    @Test
    void testThatElementsWithAHigherPriorityGetAhead() {
        Queue<Person> queue = new PriorityQueue<>(new PersonComparator());
        queue.offer(new Person("Franz", "Kafka"));
        queue.offer(new Person("Jane", "Austen"));
        queue.offer(new Person("Leo", "Tolstoy"));
        queue.offer(new Person("Lewis", "Carroll"));
        assertThat(queue.peek()).isNotNull();
        assertThat(queue.peek().firstName()).isEqualTo("Jane");
    }
}
