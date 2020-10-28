package com.evolutionnext.generics;

import org.junit.jupiter.api.Test;

import java.io.CharArrayWriter;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public class MultipleBoundsTest {

    //25. Multiple Bounds can be performed at declaration in either a method
    // or a class.

    private <T extends Appendable & Flushable & Closeable> void foo(T t) throws
        IOException {
        t.append('c');
        t.append('d');
        t.flush();
        t.close();
    }

    @Test
    public void testMultipleInheritance() throws IOException {
        CharArrayWriter writer = new CharArrayWriter(40);
        foo(writer);
        System.out.println(writer.toCharArray());
    }
}
