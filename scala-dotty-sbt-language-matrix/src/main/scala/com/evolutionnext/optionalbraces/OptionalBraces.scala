package com.evolutionnext.optionalbraces

case class Ounces(value: Int):
    def toMilliliters: Double = value * 29.5735

case class Beverage(name: String, suggestedServing: Ounces, isAlcoholic: Boolean)

@main
def tryingOutOptionalBraces():Unit =
  val cocaCola = Beverage("Coca Cola", Ounces(12), false)
  println(cocaCola)
