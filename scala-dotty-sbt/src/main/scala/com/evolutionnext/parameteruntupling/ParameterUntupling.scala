package com.evolutionnext.parameteruntupling

object ParameterUntupling extends App{
   /* Before */
   val tupleList = List(1 -> "One", 2 -> "Two",
                        3 -> "Three", 4 -> "Three",
                        5 -> "Five", 5 -> "Five")

   println(tupleList.map(t => (t._1, t._2 + " Hundred")))

   /* Before using destructuring */

   println(tupleList.map{case (x, y) => (x, y + " Hundred")})

   /* New to Dotty */
 
   println(tupleList.map{(x,y) => (x, y + " Hundred")})

   /* Also acceptable */

   println(tupleList.map((x,y) => (x, y + " Hundred")))
}
