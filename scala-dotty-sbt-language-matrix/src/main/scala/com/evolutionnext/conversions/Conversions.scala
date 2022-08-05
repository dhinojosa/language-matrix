package com.evolutionnext.conversions

case class Fahrenheit(value: Int)
case class Celsius(value: Int)

object Conversions:
  given Conversion[Fahrenheit, Celsius] with
    def apply(f: Fahrenheit): Celsius =
      Celsius(((f.value.toDouble - 32) * (5.0 / 9.0)).round.toInt)

  given Conversion[Celsius, Fahrenheit] with
    def apply(c: Celsius): Fahrenheit =
      Fahrenheit(((c.value.toDouble * (9.0 / 5.0)) + 32).round.toInt)

  def diffFromFreezing(c: Celsius): Celsius = c

@main def testConversions(): Unit =
  import scala.language.implicitConversions
  import Conversions.*
  import Conversions.given
  println(diffFromFreezing(Fahrenheit(50)): Fahrenheit)
  println("Celsius 22 is %s".format(Celsius(22): Fahrenheit))
  println(Celsius(100): Fahrenheit)
  println(Fahrenheit(100): Celsius)
