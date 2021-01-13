package com.evolutionnext.multiversalequality

object MultiversalEquality:

    //Importing strict equality, in which only the type classes
    //will define whether something is equal or not based on types

    import scala.language.strictEquality

    def testMultiversalEquality:Unit =
      //All things are equal of the same type 
      //Byte, Short, Char, Int, Long, Float, Double,
      //Boolean, and Unit, - java.lang.Number, java.lang.Boolean,
      //and java.lang.Character, scala.collection.Seq, 
      //and scala.collection.Set.
    
      println(3 == 3) //true
      println(List(1,2,3) == List(1,2,3)) //true

      //They are comparable if they are the same type, if they are not, 
      //then you would need to declare
      given CanEqual[Int, String] = CanEqual.derived
      println(3 == "3") //false

      // By default, all numbers are comparable, because of;
      // implicit def CanEqualNumber: CanEqual[Number, Number] = derived
      println(3 == 5.1) //false

      // By default, all Sequences are comparable, because of;
      // implicit def CanEqualSeq[T, U](implicit eq: CanEqual[T, U]): CanEqual[GenSeq[T], GenSeq[U]] = derived
      println(List(1, 2) == Vector(1, 2)) //true

      //You can establish your own equality by providing a derived
      class A(a: Int)
      class B(b: Int)

      val a = new A(4)
      val b = new B(4)

      // scala.language.strictEquality is enabled, therefore we 
      // need some extra delegate instances
      // to compare instances of A and B.
      given CanEqual[A, B] = CanEqual.derived
      given CanEqual[B, A] = CanEqual.derived

      println(a != b)
      println(b == a)