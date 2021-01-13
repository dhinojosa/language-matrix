package com.evolutionnext.alpha

import scala.annotation.alpha

/**
 * The name provided to @alpha is the name you would use if you wanted to
 * call the method from Java code, which doesn’t support invoking methods
 * with symbolic names. However, the name concat can’t be used in Scala code
 **/

class Foo(x:Int) {
   @alpha("add") def +(y:Int) = x + y
}

object AlphaNotation extends App {
   val foo = Foo(10)
   assert(foo + 40 == 50)
}
