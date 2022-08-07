package com.evolutionnext.higherkindedtypes

//C[A] is a Higher Kinded Type, any Container `C` that contains
//an `A` which too, can be anything
//
//Candidates:
//  List[Int]
//  Option[Int]
//  Try[String]
//  MyBox[Double]
//
//Not These:
//  Map[String, Int]
//  Either[String, Double]
//
// But if partially apply the type so
// that there is only one parameterized type
// then yes, we can apply that to C[A]
//
// type MapWithOneHole = [A] =>> Map[String, A]
// type EitherWithOneHole [A] =>> Either[String, A]

trait Functor[F[_]]:
    def fmap[A, B](fa: F[A])(f: A => B): F[B]

object Functor:
    def apply[F[_]](using fun: Functor[F]): Functor[F] = fun

object ListTypeClasses:
    given Functor[List] with
        def fmap[A, B](fa: List[A])(f: A => B): List[B] =
            fa.map(f)

@main def assertUsingAHigherKindedTypeWorksWithList(): Unit =
    import ListTypeClasses.given
    val result: List[Int] = Functor[List].fmap(List(1, 2, 3))(_ * 2)
    println(result)

case class MyBox[A](value: A)
object MyBox:
    given Functor[MyBox] with
        def fmap[A, B](ba: MyBox[A])(f: A => B): MyBox[B] =
            MyBox(f(ba.value))

@main def assertUsingAHigherKindedTypeWorksWithCustom(): Unit =
    val result: MyBox[Int] = Functor[MyBox].fmap(MyBox("Hello"))(_.length)
    println(result)

object EitherTypeClasses:
    given Functor[[A] =>> Either[String, A]] with
        def fmap[A, B](se: Either[String, A])(f: A => B): Either[String, B] =
            se match
                case Left(x)  => Left(x)
                case Right(y) => Right(f(y))

@main def assertUsingWithAnEither(): Unit =
    import EitherTypeClasses.given
    val result = Functor[[A] =>> Either[String, A]].fmap(Right(30))(_ * 2)
    println(result)

trait Monad[F[_]]:
    def pure[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]

object Monad:
    def apply[F[_]](using monad: Monad[F]): Monad[F] = monad

object ListTypeClassesPlus:
    given Monad[List] with
        def pure[A](a: A): List[A] = List(a)
        def flatMap[A, B](fa: List[A])(f: A => List[B]): List[B] = fa.flatMap(f)

@main def assertUsingFlatMapInAMonad(): Unit =
    import ListTypeClassesPlus.given
    Monad[List].flatMap(List(1, 2, 3, 4))(x => List(-x, x, x + 3))
