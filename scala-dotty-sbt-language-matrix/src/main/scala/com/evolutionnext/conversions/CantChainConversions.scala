package com.evolutionnext.conversions

import scala.language.implicitConversions

case class Seconds(num: Int)
case class Hours(num: Int)

//36000 sec   1 min     1 hour
//            -------   ------
//            60 sec    60 min

object MyConversions:
  given Conversion[Int, Seconds] = Seconds(_)
  given Conversion[Seconds, Hours] = sec => Hours(sec.num / 3600)

@main
def cannotChainConversions():Unit =
  import MyConversions.given
  val seconds: Seconds = 10 * 60 * 60
  val hours: Hours = seconds
  println(hours.num == 10)

  //The following cannot be run
  //val hours2:Hours = 10 * 60 * 60

  //The following can be run since we coerced
  //an integer to seconds
  val hours4:Hours = 10 * 60 * 60:Seconds

  //The following can be run since we are doing
  //this in steps
  val seconds3:Seconds = 10 * 60 * 60
  val hours3:Hours = seconds3
  println(hours3.num == 10)
