package com.evolutionnext.givendelegates

object GivenParameters extends App {
   case class Rate(value:Int)
   case class Hours(value:Int)

   given r : Rate = Rate(100)

   def calculateTimeSheet(x:Hours)(given r:Rate) =
     x.value * r.value

   println(calculateTimeSheet(Hours(40)))
}
