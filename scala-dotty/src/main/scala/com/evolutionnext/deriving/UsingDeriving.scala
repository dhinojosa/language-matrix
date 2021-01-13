package com.evolutionnext.deriving

trait Eq[A]:
  def eqv(a:A, b:A):Boolean

// object UsingDeriving:
//   import scala.deriving._
//   import scala.compiletime.{erasedValue, summonInline, summonAll}
//   case class Customer(firstName:String, lastName:String) derives Eq
//   object Customer:
//     inline given derived[T](using m: Mirror.Of[T]):Eq[T] =
//       lazy val elemInstances = summonAll[m.MirroredElemTypes]
//       inline m match
//         case s:Mirror.SumOf[T] = 
//         case t:Mirror.ProductOf[T] = 
       
