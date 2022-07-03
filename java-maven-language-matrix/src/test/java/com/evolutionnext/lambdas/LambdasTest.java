package com.evolutionnext.lambdas;

import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LambdasTest {

    public static int sum(SampleInterface si, int otherNumber) {
        return si.transform(otherNumber);
    }

    @Test
    void testUsingSampleInterface() {
        assertThat(sum((a -> a + 4), 5)).isEqualTo(9); // a is inferred to be an int
        assertThat(sum((int a) -> a + 5, 9)).isEqualTo(14); //a is explicit
    }

    @Test
    void testSomeOtherLambdas() {
        //Some other lambdas with one method interfaces
        Runnable r = () -> System.out.println("Run in a separate thread");
        ActionListener al = ActionEvent::getActionCommand;
    }

    @Test
    void testMultiStatementLambda() {
        SampleInterface si2 = a -> {
            int total = 3 + 4;
            return total + 19;
        };
    }
}
