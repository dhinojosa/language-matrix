package com.evolutionnext.conversions

import scala.language.implicitConversions

case class Seconds(num:Int)
case class Hours(num:Int)

//36000 sec   1 min     1 hour
//            -------   ------
//            60 sec    60 min

object MyConversions:
  given Conversion[Int, Seconds] = Seconds(_)
  given Conversion[Seconds, Hours] = sec => Hours(sec.num / 3600)

object CantChainConversions extends App:
  import MyConversions.given
  val seconds:Seconds = 10 * 60 * 60
  val hours:Hours = seconds
  println(hours.num == 10)

  //The following can't be run
  //val hours:Hours = 10 * 60 * 60
