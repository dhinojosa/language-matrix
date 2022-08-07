package com.evolutionnext.givenusing

//List[A]
//what if...C[Int], C[String]
//List[_]
//Option[_]
//Stream[_]
//Observable[_]
//Future[_]
case class Rate(value: Int)
case class Hours(value: Int)

given Rate = Rate(100)

def calculateTimeSheet(x: Hours)(using r: Rate) =
  x.value * r.value

@main def testGivenParameters(): Unit =
  println(calculateTimeSheet(Hours(40)))
  println(summon[Rate])
