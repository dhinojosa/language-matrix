package com.evolutionnext.opaquetypes

object Logarithms:
  //The opaque type must be in an object
  opaque type Logarithm = Double

  object Logarithm:
    // These are the ways to lift to the logarithm type
    def apply(d: Double): Logarithm = math.log(d)

    def safe(d: Double): Option[Logarithm] =
      if d > 0.0 then Some(math.log(d))
      else None

  // Extension methods define opaque types' public APIs$
  extension (x: Logarithm)
    def toDouble: Double = math.exp(x)
    def +(y: Logarithm): Logarithm = Logarithm(math.exp(x) + math.exp(y))
    def *(y: Logarithm): Logarithm = Logarithm(x + y)

@main def assertThatOpaqueTypesWork: Unit =
  import Logarithms.*
  //Supress the string append method
  import Predef.{any2stringadd as _, *}

  val a: Logarithm = Logarithm(30)
  val b: Logarithm = Logarithm(1)
  println(a + b)

//This should not work since the opaque type can
//only happen within the object Logarithms
//val c:Logarithm = 40.0
