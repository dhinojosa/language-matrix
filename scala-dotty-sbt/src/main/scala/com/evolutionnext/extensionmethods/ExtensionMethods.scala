package com.evolutionnext.extensionmethods

object ExtensionMethods extends App {
   /* Currently there is no isOdd() with
    * Int, so we can create one with an 
    * extension method */
  extension (i:Int) 
    def isOdd: Boolean = i % 2 != 0
    def isEven: Boolean = !i.isOdd

  extension [A,B] (t:Tuple2[A,B])  
    def cool:String = "Tuple 2 forever homie!"
  
  println(40.isOdd)
  println(40.isEven)
  val tz = (4,"Foo")
  println(tz.cool)
}
