package com.ora.scalaprogrammingfundamentals

import java.time.LocalDate

class Stamp protected[scalaprogrammingfundamentals] (val theme:String, val year:Int,
            val currentYearFunction: () => Int) extends Introspection {
  def age:Int = currentYearFunction() - year
}

object Stamp {
  //static method factory
  def apply(theme:String, year:Int):Stamp = {
    require(theme.nonEmpty, "Theme cannot be empty")
    new Stamp(theme, year, () => LocalDate.now.getYear)
  }
}

case class Computer(make:String, model:String, year:Int)

abstract class Collectable {
  def year:Int
}

class SportsCard(val year:Int, val manufacturer:String,
                 val playerName:String) extends Collectable

class BaseballCard(year:Int, manufacturer:String, playerName:String,
                   val league:String, val division:String)
                   extends SportsCard(year, manufacturer, playerName)

case class Box[T](contents:T) {
  def map[U](f: T => U):Box[U] = Box(f(contents))
}

class Employee(val firstName:String, lastName:String)

trait Introspection {
  def whoAmI_?() = s"${getClass.getSimpleName}"
}