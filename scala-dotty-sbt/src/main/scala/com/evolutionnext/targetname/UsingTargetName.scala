package com.evolutionnext.targetname

import scala.annotation.targetName

case class Meters(value: Double):
  @targetName("add") def +(other: Meters) = new Meters(value + other.value)
  @targetName("subtract") def -(other: Meters) = new Meters(value - other.value)

object UsingTargetName:
  @main def testTargetName: Unit =
    val p1 = Meters(10.0) + Meters(20.0)
    println(p1)
//This will not work
//val p2 = Meters(10.0).plus(Meters(20.0))
