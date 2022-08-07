package com.evolutionnext.typeclasses

def maxAdd10[F[_], T](xs: F[T])
                     (using o: Ordering[T], n: Numeric[T], monoid: Monoid[T],
                      fn: Functor[F], fo: Foldable[F]): T =
  fo.maxOption(fn.fmap(xs)(x => n.plus(x, n.fromInt(10))))
    .getOrElse(monoid.empty)

trait Foldable[F[_]]:
  def maxOption[A](xs: F[A])(using Ordering[A]): Option[A]

trait Monoid[A]:
  def empty: A

object Foldables:
  given Foldable[List] with
    def maxOption[A](xs: List[A])(using Ordering[A]): Option[A] = xs.maxOption

  given Foldable[Option] with
    def maxOption[A](o: Option[A])(using Ordering[A]): Option[A] = o

trait Functor[F[_]]:
  def fmap[A, B](fa: F[A])(f: A => B): F[B]

trait Applicative[F[_]] extends Functor[F]:
  def pure[A](a: A): F[A]

object Functor:
  def apply[F[_]](using f: Functor[F]): Functor[F] = f

object Ints:
  given Monoid[Int] with
    def empty = 0

object Lists:
  given Functor[List] with
    def fmap[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)

  given (using fn: Functor[List]): Applicative[List] with
    def fmap[A, B](fa: List[A])(f: A => B): List[B] = fn.fmap(fa)(f)
    def pure[A](a: A): List[A] = List(a)

object Options:
  given Functor[Option] with
    def fmap[A, B](fa: Option[A])(f: A => B): Option[B] = fa.map(f)

@main def testFunctionalAbstractions(): Unit =
  import Lists.given
  import Ints.given
  import Options.given
  import Foldables.given

  println(maxAdd10(List(10, 20, -1, 2, 50)))
  println(Functor[List].fmap(List(1, 2, 3))(a => a + 10))
  println(maxAdd10(Option(40)))
