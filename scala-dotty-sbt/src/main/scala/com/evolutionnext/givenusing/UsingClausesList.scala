package com.evolutionnext.givenusing

case class U1[T](t: T)
case class U2[T](t: T)
object UsingClausesList:
  def f1[T1, T2](name: String)(using u1: U1[T1], u2: U2[T2]): String =
    s"f1: $name: $u1, $u2"
  def f2[T1, T2](name: String)(using u1: U1[T1])(using u2: U2[T2]): String =
    s"f2: $name: $u1, $u2"
  def f3[T1, T2](name: String)(using u1: U1[T1])(u2: U2[T2]): String =
    s"f3: $name: $u1, $u2"
  given u1i: U1[Int] = U1[Int](0)
  given u2s: U2[String] = U2[String]("one")

  @main def testClauses: Unit =
    println(f1("f1a"))
    println(f1("f1b")(using u1i, u2s))
    f2("f2a")
    println(f2("f2b")(using u1i)(using u2s))
    println(f3("f3a"))
    println(f3("f3b")(using u1i))
    println(f3("f3c")(using u1i)(u2s))
