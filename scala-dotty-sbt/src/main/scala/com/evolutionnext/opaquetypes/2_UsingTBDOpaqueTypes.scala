package com.evolutionnext.opaquetypes

object TBDs:
  //The opaque type must be in an object
  opaque type TBD[A] = Option[A]

  object TBD:
    def apply[A](a: A): TBD[A] = Option.apply(a)
    def empty[A]: TBD[A] = Option.empty[A]

  extension [A](x: TBD[A]) def fulfill[B](b: B): TBD[B] = TBD.apply(b)

@main def testTBDOpaqueType: Unit =
  import TBDs.*
  val tbd = TBD.empty[Int]
  val result: TBD[Int] = tbd.fulfill(30)

  case class EmployeeDatabaseEntry(id: TBD[Int], firstName: String, lastName: String)
  val entry = EmployeeDatabaseEntry(TBD.empty, "Francisco", "Peña")
  val copy = entry.copy(id = TBD(30))
  println(copy)
