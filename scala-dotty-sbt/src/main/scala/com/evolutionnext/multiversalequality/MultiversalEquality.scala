package com.evolutionnext.multiversalequality

//Importing strict equality, in which only the type classes
//will define whether something is equal or not based on types
import scala.language.strictEquality

@main def testMultiversalEquality: Unit =

  //All things are equal of the same type
  //Byte, Short, Char, Int, Long, Float, Double,
  //Boolean, and Unit, - java.lang.Number, java.lang.Boolean,
  //and java.lang.Character, scala.collection.Seq,
  //and scala.collection.Set.

  println(3 == 3) //true
  println(List(1, 2, 3) == List(1, 2, 3)) //true

  //They are comparable if they are the same type, if they are not,
  //then you would need to declare

  given CanEqual[Int, String] = CanEqual.derived
  println(3 == "3") //false, but type system

  // By default, all numbers are comparable, because of;
  //implicit def CanEqualNumber: CanEqual[Number, Number] = derived
  println(3 == 5.1) //false

  // By default, all Sequences are comparable, because of;
  // implicit def CanEqualSeq[T, U](implicit eq: CanEqual[T, U]): CanEqual[GenSeq[T], GenSeq[U]] = derived
  println(List(1, 2) == Vector(1, 2)) //true

  // You can establish your own equality by providing a derived
  case class Rate(a: Int)
  case class Age(b: Int)

  val rate = new Rate(12)
  val age = new Age(44)

  // scala.language.strictEquality is enabled, therefore we
  // need some extra delegate instances
  // to compare instances of A and B.

  given CanEqual[Rate, Age] = CanEqual.derived
  given CanEqual[Age, Rate] = CanEqual.derived

  println(rate != age)
  println(age == rate)

  given CanEqual[Rate, Rate] = CanEqual.derived

  //If there are are some comparisions in scope then sequences of that type can be compared
  println(List(Rate(10), Rate(40), Rate(12)) == List(Rate(10), Rate(40), Rate(12)))
