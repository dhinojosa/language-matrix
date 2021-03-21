package com.evolutionnext.enums
// This JavaEnums is using Java like declarations 

enum JavaColor extends java.lang.Enum[JavaColor] { 
    case Red,
         Green,
         Blue
}

enum JavaDay extends java.lang.Enum[JavaDay]{
  case Monday, Tuesday, Wednesday, Thursday, 
       Friday, Saturday
}

enum JavaSuit extends java.lang.Enum[JavaSuit]{
  case Hearts, Diamonds, Clubs, Spades
}

enum JavaPlanet(val mass: Double, val radius:Double) extends java.lang.Enum[JavaPlanet] {
  private final val G = 6.67300E-11
  def surfaceGravity = G * mass / (radius * radius)
  def surfaceWeight(otherMass: Double) =  otherMass * surfaceGravity

  case Mercury extends JavaPlanet(3.303e+23, 2.4397e6)
  case Venus   extends JavaPlanet(4.869e+24, 6.0518e6)
  case Earth   extends JavaPlanet(5.976e+24, 6.37814e6)
  case Mars    extends JavaPlanet(6.421e+23, 3.3972e6)
  case Jupiter extends JavaPlanet(1.9e+27,   7.1492e7)
  case Saturn  extends JavaPlanet(5.688e+26, 6.0268e7)
  case Uranus  extends JavaPlanet(8.686e+25, 2.5559e7)
  case Neptune extends JavaPlanet(1.024e+26, 2.4746e7)
}

object JavaEnums extends App {
    val m = JavaColor.Red
    println(m)
    val g = JavaColor.Green
    println(g == g)

    import JavaPlanet._
    val planet = Mars
    println(planet)
}
