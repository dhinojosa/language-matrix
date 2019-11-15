package com.evolutionnext.conversions

case class Fahrenheit(value:Int)
case class Celcius(value:Int)

object Conversions extends App
	import scala.language.implicitConversions

	given fahrenheitToCelcius : Conversion[Fahrenheit,Celcius] = 
		new Conversion[Fahrenheit, Celcius] {
			def apply(f:Fahrenheit) = 
				Celcius(((f.value.toDouble - 32) * (5.0/9.0)).round.toInt)
		}


	given celciusToFahrenheit : Conversion[Celcius,Fahrenheit] = 
		new Conversion[Celcius, Fahrenheit] {
			def apply(c:Celcius) = 
				Fahrenheit(((c.value.toDouble * (9.0/5.0)) + 32).round.toInt)
	}

	def diffFromFreezing(c:Celcius):Celcius = c

	println(diffFromFreezing(Fahrenheit(50)):Fahrenheit)
	println("Celcius 0 is %s".format(Celcius(0):Fahrenheit))
	println(Celcius(100):Fahrenheit)
	println(Fahrenheit(100):Celcius)
