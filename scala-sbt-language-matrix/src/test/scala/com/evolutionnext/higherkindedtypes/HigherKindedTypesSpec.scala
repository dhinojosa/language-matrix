package com.evolutionnext.higherkindedtypes

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

def acceptHigherKindedTypes[M[_], A](x: M[A]) = x

class HigherKindedTypesSpec extends AnyFunSuite with Matchers:

  test("""A higher kinded type accepts a shape where the 'container' is also the generic""") {
    acceptHigherKindedTypes(Some(123)) should be(Some(123))
    acceptHigherKindedTypes(List(5, 10, 12, 50)) should be(List(5, 10, 12, 50))
  }

  test("""A higher kinded type can be partially applied""") {
    type StringMap[V] = Map[String, V]
    val m: StringMap[Int] = Map("Canada" -> 37000000, "United States" -> 308745538, "Mexico" -> 123000000)
    acceptHigherKindedTypes(m) should be(m)
  }

  test("""A question mark can be used to plug a hole into the parameterized type""") {
    type StringMapPlus = Map[String, ?]
    val m2: StringMapPlus = Map("Canada" -> 37000000, "United States" -> 308745538, "Mexico" -> 123000000)
    acceptHigherKindedTypes(m2) should be(m2)
  }

  test("""Using a Functor to run the application""") {
    trait Functor[M[_]]:
      def map[A, B](m: M[A])(f: A => B): M[B]

    type FunctorIntMap = Functor[[G] =>> Map[Int, G]]

    val fim: FunctorIntMap = new FunctorIntMap:
      def map[A, B](m: Map[Int, A])(f: A => B): Map[Int, B] =
        m.map(t => t._1 -> f(t._2))

    val map = Map(123 -> "Foul", 405 -> "Crepe")
    fim.map(map)(s => s + "!") should be(Map(123 -> "Foul!", 405 -> "Crepe!"))
  }
