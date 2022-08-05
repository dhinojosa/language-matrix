package com.evolutionnext.extensionmethods

object ExtensionMethods:
  /* Currently there is no isOdd() with
   * Int, so we can create one with an
   * extension method */
  extension (i: Int)
    def isOdd: Boolean = i % 2 != 0
    def isEven: Boolean = !i.isOdd

  extension [A, B](t: (A, B))
    def cool: String = "Tuple 2 forever, ese!"

@main
def tryingOutExtensions():Unit =
  import ExtensionMethods.*
  println(40.isOdd)
  println(40.isEven)
  val tz = (4, "Foo")
  println(tz.cool)
