package com.evolutionnext.givendelegates

object MyPredef:
  trait Ord[T] {
    def compare(x: T, y: T): Int
    extension (x: T):
      def < (y: T) = compare(x, y) < 0
      def > (y: T) = compare(x, y) > 0
  }

  given IntOrd as Ord[Int]:
    def compare(x: Int, y: Int) =
      if (x < y) -1 else if (x > y) +1 else 0

  given ListOrd[T](using ord: Ord[T]) as Ord[List[T]]:
    def compare(xs: List[T], ys: List[T]): Int = (xs, ys) match
      case (Nil, Nil) => 0
      case (Nil, _) => -1
      case (_, Nil) => +1
      case (x :: xs1, y :: ys1) =>
        val fst = ord.compare(x, y)
        if (fst != 0) fst else compare(xs1, ys1)

object GivenAndDelegates extends App:
  import MyPredef._

  def min[A](x:A, y:A)(using ord:Ord[A]) = {
     if (ord.compare(x, y) < 0) x else y
  }

  //Using the min method here
  println(min(12, 10))

  //Looking up the instance using `the`
  val listSorter = summon[ListOrd[Int]] 
  println(listSorter.compare(List(1,2,3,4), List(2,3,4,5)))
  println(listSorter.compare(List(10,20,30,40), List(2,3,4,5)))
