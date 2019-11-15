package com.evolutionnext.typelambdas;

object BasicHigherKindedTypes extends App {
  def acceptHigherKindedTypes[M[_],A](x:M[A]) = x

  println(acceptHigherKindedTypes(Some(123)))
  println(acceptHigherKindedTypes(List(5, 10, 12, 50)))

  type StringMap[V] = Map[String, V]

  val m:StringMap[Int] = Map("Canada" -> 37000000, 
                             "United States" -> 308745538,
                             "Mexico" -> 123000000)

  println(acceptHigherKindedTypes(m))

  //The following will work as well
  type StringMapPlus = Map[String, _]

  val m2:StringMapPlus = Map("Canada" -> 37000000, 
                             "United States" -> 308745538,
                             "Mexico" -> 123000000)
  println(acceptHigherKindedTypes(m2))

  //Doing it nested
  trait Functor[M[_]]

  //This doesn't work in Scala2 nor does it quite work
  //in Scala 3 Dotty, but there is a better way.
  //type F4 = Functor[Map[Int, _]]
  //type F4 = [G] =>> Map[Int, G] =>> Functor[Map[Int, G]]

  type F4 = Functor[[G] =>> Map[Int,G]]

  //We can also inline it in a method like the following:

  def acceptFunctorWithMapOfIntAndSomethingElse(x:Functor[[G] =>> Map[Int, G]]) = x

  println(Map("Canada" -> 37000000, 
              "United States" -> 308745538,
              "Mexico" -> 123000000))
}
