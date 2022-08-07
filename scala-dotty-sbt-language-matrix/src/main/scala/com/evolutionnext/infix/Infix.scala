package com.evolutionnext.infix

/* The infix keyword allows for use of a method as an infix
 ** Infix operations involving alphanumeric operators are deprecated, unless one of the following conditions holds:
 ** the operator definition carries an infix modifier, or
 ** the operator was compiled with Scala 2, or
 ** the operator is followed by an opening brace.
 */

case class Foo(x: Int):
  def |(y: Int): Foo = Foo(x | y)
  infix def or(y: Int): Foo = Foo(x | y)
  def and(y: Int): Foo = Foo(x & y)

/**
 * Computing 10 | 5 and 10 & 5
 *
 * | Bits  | 128 | 64 | 32 | 16 | 8 | 4 | 2 | 1 |
 * |:------|:----|:---|:---|:---|:--|:--|:--|:--|
 * | Num 1 | 0   | 0  | 0  | 0  | 1 | 0 | 1 | 0 |
 * | Num 2 | 0   | 0  | 0  | 0  | 0 | 1 | 0 | 1 |
 * | Or    | 0   | 0  | 0  | 0  | 1 | 1 | 1 | 1 |
 * | And   | 0   | 0  | 0  | 0  | 0 | 0 | 0 | 0 |
 */
@main
def usingInfix(): Unit =
  val foo = Foo(10)
  assert((foo.or(5)) == Foo(15))
  assert((foo or 5) == Foo(15))
  assert((foo | 5) == Foo(15))
  assert((foo and 5) == Foo(0)) //Produce Warning
