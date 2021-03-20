package com.evolutionnext.matchtypes

type Production[X] = X match
  case Int         => String
  case String      => Long
  case List[t]     => t

object SomeRunner:
  def foo[A](a:A):Production[A] =
    a match
      case x:Int      => (x + 1).toString
      case s:String   => s.length.toLong
      case xs:List[t] => xs.head

@main def testMatchTypes:Unit =
  val result:String  = SomeRunner.foo(30)
  val result2:Long   = SomeRunner.foo("Awesome")
  val result3:Int    = SomeRunner.foo(List(1,2,3,4))

  println(result)
  println(result2)
  println(result3)
