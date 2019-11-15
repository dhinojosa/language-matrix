package com.evolutionnext.matchtypes

object MatchTypes extends App {
  type Elem[X] = X match {
    case String => Char
    case Array[t] => t
    case Iterable[t] => t
  }

  val m:Elem[String] = 'x'
  val n:Elem[Array[String]] = "Hello"
  println(m)
  println(n.getClass.getSimpleName)
}
