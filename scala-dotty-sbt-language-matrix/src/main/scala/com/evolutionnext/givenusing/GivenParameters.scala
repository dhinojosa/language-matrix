package com.evolutionnext.givenusing

//List[A]
//what if...C[Int], C[String]
//List[_]
//Option[_]
//Stream[_]
//Observable[_]
//Future[_]
case class Rate(value: Int)
case class Hours(value: Int)

given Rate = Rate(100)

def calculateTimeSheet(x: Hours)(using r: Rate) =
  x.value * r.value

def maxAdd10[F[_], T](
  xs: F[T]
)(using o: Ordering[T], n: Numeric[T], monoid: Monoid[T], fn: Functor[F], fo: Foldable[F]): T =
  val mapped = fn.fmap(xs)(x => n.plus(x, n.fromInt(10)))
  fo.maxOption(mapped).getOrElse(monoid.empty)

trait Foldable[F[_]]:
  def maxOption[A](xs: F[A])(using Ordering[A]): Option[A]

trait Monoid[A]:
  def empty: A

object Foldables:
  given Foldable[List] with
    def maxOption[A](xs: List[A])(using Ordering[A]): Option[A] = xs.maxOption

  given Foldable[Option] with
    def maxOption[A](o: Option[A])(using Ordering[A]) = o

trait Functor[F[_]]:
  def fmap[A, B](fa: F[A])(f: A => B): F[B]

trait Applicative[F[_]] extends Functor[F]:
  def pure[A](a: A): F[A]

object Functor:
  def apply[F[_]](using f: Functor[F]) = f

object Ints:
  given Monoid[Int] with
    def empty = 0

object Lists:
  given Functor[List] with
    def fmap[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)

  given (using fn: Functor[List]): Applicative[List] with
    def fmap[A, B](fa: List[A])(f: A => B): List[B] = fn.fmap(fa)(f)
    def pure[A](a: A) = List(a)

object Options:
  given Functor[Option] with
    def fmap[A, B](fa: Option[A])(f: A => B) = fa.map(f)

@main def testGivenParameters: Unit =
  import Lists.given
  import Ints.given
  import Options.given
  import Foldables.given

  println(calculateTimeSheet(Hours(40)))
  println(summon[Rate])
  println(maxAdd10(List(10, 20, -1, 2, 50)))
  println(Functor[List].fmap(List(1, 2, 3))(a => a + 10))
  println(maxAdd10(Option(40)))
