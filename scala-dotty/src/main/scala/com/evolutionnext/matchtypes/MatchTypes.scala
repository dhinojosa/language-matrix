package com.evolutionnext.matchtypes

object MatchTypes:
  type Elem[X] = X match
    case String => Char
    case Array[t] => t
    case Iterable[t] => t

  @main def testMatchTypes:Unit =
    val m:Elem[String] = 'x'
    val n:Elem[Array[String]] = "Hello"
    println(m)
    println(n.getClass.getSimpleName)

end MatchTypes
