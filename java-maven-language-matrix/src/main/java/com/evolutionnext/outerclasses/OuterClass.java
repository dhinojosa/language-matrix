package com.evolutionnext.outerclasses;

public class OuterClass {
    private int x = 4;
    private static int a = 19;

    public class InnerClass {
        private int y = 2;
        public int sum() {
            return x + y;
        }
    }

    public static class StaticInnerClass {
        private int z = 10;
        public int bar() {
            return z + 19 + a;
        }
    }

    public int foo() {
        return x + 1;
    }

    public static int baz() {
        return a + 10;
    }

    public int qux(int m) {
        int g = 10;
        class MyLocalClass {
            private int art(int n) {
                return m + n + g;
            }
        }

        MyLocalClass myLocalClass = new MyLocalClass();
        return myLocalClass.art(20);
    }
}
