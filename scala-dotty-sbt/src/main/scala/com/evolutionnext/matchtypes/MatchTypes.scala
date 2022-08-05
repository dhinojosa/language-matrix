package com.evolutionnext.matchtypes

type Production[X] = X match
   case Int     => String
   case String  => Long
   case List[t] => t

object SomeRunner:
  def tryAndMatch[A](a: A): Production[A] =
    a match
      case x: Int      => (x + 1).toString
      case s: String   => s.length.toLong
      case xs: List[t] => xs.head

@main def testMatchTypes(): Unit =
  import com.evolutionnext.matchtypes.SomeRunner.tryAndMatch
  val result: String = tryAndMatch(30)
  val result2: Long = tryAndMatch("Awesome")
  val result3: Int = tryAndMatch(List(1, 2, 3, 4))

  println(result)
  println(result2)
  println(result3)
