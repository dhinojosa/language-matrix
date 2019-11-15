package com.evolutionnext.extensionmethods

object ExtensionMethods extends App {
   /* Currently there is no isOdd() with
    * Int, so we can create one with an 
    * extension method */
  def (i:Int) isOdd: Boolean = i % 2 != 0
  def (i:Int) isEven: Boolean = !i.isOdd
  def [A,B](t:Tuple2[A,B]) cool:String = "Tuple 2 forever homie!"
  println(40.isOdd)
  println(40.isEven)
  val tz = (4,"Foo")
  println(tz.cool)
}
