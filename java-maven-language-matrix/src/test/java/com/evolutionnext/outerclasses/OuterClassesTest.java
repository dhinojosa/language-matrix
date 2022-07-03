package com.evolutionnext.outerclasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OuterClassesTest {

    @Test
    public void testInnerClasses() {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        assertEquals(6, innerClass.sum());
    }

    @Test
    public void testUsingClassesWithInnerClasses() {
        OuterClass outerClass = new OuterClass();
        assertEquals(5, outerClass.foo());
    }

    @Test
    public void testUsingClassesWithStaticInnerClasses() {
        OuterClass.StaticInnerClass staticInnerClass = new OuterClass
            .StaticInnerClass();
        assertEquals(48, staticInnerClass.bar());
    }
}
