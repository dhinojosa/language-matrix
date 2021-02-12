package com.evolutionnext.infix

/* The infix keyword allows for use of a method as an infix
 ** method
 */

case class Foo(x:Int):
  def | (y:Int) = Foo(x | y)
  infix def bar(y:Int) = Foo(x | y)

/**
 *  Computing 10 | 5
 *
 * | Bits  | 128 | 64 | 32 | 16 | 8 | 4 | 2 | 1 |
 * |-------|-----|----|----|----|---|---|---|---|
 * | Num 1 | 0   | 0  | 0  | 0  | 1 | 0 | 1 | 0 |
 * | Num 2 | 0   | 0  | 0  | 0  | 0 | 1 | 0 | 1 |
 * | Or    | 0   | 0  | 0  | 0  | 1 | 1 | 1 | 1 |
 */
object Infix extends App:
  val foo = Foo(10)
  assert((foo bar 5) == Foo(15)) //No need for backticks
  assert((foo | 5) == Foo(15))

