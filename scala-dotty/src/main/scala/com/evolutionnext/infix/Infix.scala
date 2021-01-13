package com.evolutionnext.infix

/* The infix keyword allows for use of a method as an infix
 ** method
 */

case class Foo(x:Int):
  infix def bar(y:Int) = Foo(x + y)

object Infix extends App:
  val foo = Foo(10)
  val result =
  foo `bar` 10
  assert(result == Foo(20))
