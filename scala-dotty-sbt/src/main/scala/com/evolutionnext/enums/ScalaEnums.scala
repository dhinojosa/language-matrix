package com.evolutionnext.enums
// This JavaEnums is using Java like declarations 


enum ScalaColor { 
    case Red,
         Green,
         Blue
}

enum ScalaDay {
  case Monday, Tuesday, Wednesday, Thursday, 
       Friday, Saturday
}

enum ScalaSuit {
  case Hearts, Diamonds, Clubs, Spades
}

enum ScalaPlanet(val mass: Double, val radius:Double) {
  private final val G = 6.67300E-11
  def surfaceGravity = G * mass / (radius * radius)
  def surfaceWeight(otherMass: Double) =  otherMass * surfaceGravity

  case Mercury extends ScalaPlanet(3.303e+23, 2.4397e6)
  case Venus   extends ScalaPlanet(4.869e+24, 6.0518e6)
  case Earth   extends ScalaPlanet(5.976e+24, 6.37814e6)
  case Mars    extends ScalaPlanet(6.421e+23, 3.3972e6)
  case Jupiter extends ScalaPlanet(1.9e+27,   7.1492e7)
  case Saturn  extends ScalaPlanet(5.688e+26, 6.0268e7)
  case Uranus  extends ScalaPlanet(8.686e+25, 2.5559e7)
  case Neptune extends ScalaPlanet(1.024e+26, 2.4746e7)
}

object ScalaEnums extends App {
    val m = ScalaColor.Red
    println(m)
    val g = ScalaColor.Green
    println(g == g)

    import ScalaPlanet._
    val planet = Mars
    println(planet)
}
