package com.evolutionnext.method_closure

class Foo {
   private int bar
   def process(int baz) {
      bar + baz
   }
}

def foo = new Foo(bar:30)
def fun1 = foo.&process //fun1 is a Closure

assert fun1(3) == 33
assert [1,2,3,4].collect{fun1(it)} == [31, 32, 33, 34]
