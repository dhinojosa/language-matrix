package com.evolutionnext.opaquetypes

object Logarithms:

  opaque type Logarithm = Double

  object Logarithm:
    // These are the ways to lift to the logarithm type
    def apply(d: Double): Logarithm = math.log(d)

      def safe(d: Double): Option[Logarithm] =
      if (d > 0.0) Some(math.log(d)) else None
  

  // Extension methods define opaque types' public APIs
  extension (x:Logarithm):
    def toDouble: Double = math.exp(x)
    def + (y: Logarithm): Logarithm = Logarithm(math.exp(x) + math.exp(y))
    def * (y: Logarithm): Logarithm = Logarithm(x + y)

object OpaqueTypes extends App:
  import Logarithms._
  //Supress the string append method
  import Predef.{any2stringadd => _, _}

  val a:Logarithm = Logarithm(30)
  val b:Logarithm = Logarithm(1)
  println(a + b)


