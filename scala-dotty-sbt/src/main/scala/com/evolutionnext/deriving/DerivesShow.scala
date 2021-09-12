package com.evolutionnext.deriving

import java.time.*
import scala.compiletime.{constValue, erasedValue, summonInline}
import scala.deriving.Mirror.Of

case class Employee(firstName: String, lastName: String, dateOfBirth: LocalDate) derives Show

trait Show[T]:
  def show(t: T): String

object Show:
  import scala.deriving.Mirror

  given Show[String] with
    def show(s: String) = s

  given Show[LocalDate] with
    def show(ld: LocalDate) = ld.toString

  def iterator[T](p: T) = p.asInstanceOf[Product].productIterator

  inline def summonAll[T <: Tuple]: List[Show[?]] =
    inline erasedValue[T] match
      case _: EmptyTuple => Nil
      case _: (t *: ts)  => summonInline[Show[t]] :: summonAll[ts]

  inline given derived[T](using m: Mirror.Of[T]): Show[T] =
    lazy val name = constValue[m.MirroredLabel]
    val elemInstances = summonAll[m.MirroredElemTypes]
    inline m match
      case s: Mirror.Sum     => deriveSum(name, s, elemInstances)
      case s: Mirror.Product => deriveProduct(name, s, elemInstances)

  def deriveSum[T](name: String, s: Mirror.SumOf[T], elems: => List[Show[?]]): Show[T] =
    new Show[T]:
      def show(t: T) = name

  def deriveProduct[T](name: String, p: Mirror.ProductOf[T], elems: => List[Show[?]]): Show[T] =
    new Show[T]:
      def show(t: T) = s"$name(${iterator(t).mkString(",")})"

extension [A](x: (A | Null))
  def toOption =
    if x == null then Option.empty[A]
    else Some(x.asInstanceOf[A])

@main def assertDerivesForCustomEmployee: Unit =
  import Show.*
  val summoned = summon[Show[Employee]]
  val birthDate = LocalDate.of(2012, 1, 4).toOption
  println(summoned.show(Employee("Kwame", "Vegas", birthDate.get)))
