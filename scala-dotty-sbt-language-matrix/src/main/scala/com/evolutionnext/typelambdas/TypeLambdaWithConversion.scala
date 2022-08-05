package com.evolutionnext.typelambdas

import scala.language.implicitConversions

object TypeLambdasWithConversion extends App:
  type Conv = [T] =>> Conversion[Any, T]

  //type Conv[T] = Conversion[Any,T]
  given Conv[Int] = _.asInstanceOf[Int]
  given Conv[Double] = _.asInstanceOf[Double]
  given Conv[String] = _.asInstanceOf[String]

  val x: Any = 40
  val y: Int = x
  println(y)
