package com.evolutionnext.conversions

case class Fahrenheit(value:Int)
case class Celcius(value:Int)

object Conversions:
  import scala.language.implicitConversions

  given Conversion[Fahrenheit,Celcius] with
    def apply(f:Fahrenheit) = 
      Celcius(((f.value.toDouble - 32) * (5.0/9.0)).round.toInt)

  given Conversion[Celcius,Fahrenheit] with
    def apply(c:Celcius) = 
      Fahrenheit(((c.value.toDouble * (9.0/5.0)) + 32).round.toInt)

  def diffFromFreezing(c:Celcius):Celcius = c

  @main def testConversions:Unit =
    println(diffFromFreezing(Fahrenheit(50)):Fahrenheit)
    println("Celcius 0 is %s".format(Celcius(0):Fahrenheit))
    println(Celcius(100):Fahrenheit)
    println(Fahrenheit(100):Celcius)