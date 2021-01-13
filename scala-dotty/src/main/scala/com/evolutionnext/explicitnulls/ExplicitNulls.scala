package com.evolutionnext.explicitnulls

import java.time._
object ExplicitNulls:
  //Opt in feature that modifies the type system which makes 
  //reference types non-nullable. The following is not achievable
  //with the flag turned on. Which it is:
  
  val m = null

  extension[A](x:(A | Null))
    def toOption = if x == null then Option.empty[A] else Some(x.asInstanceOf[A])

  def testInputWithNull:Unit = 
    val input:String | Null = "Hello"
    println(input.toOption.map(_ + "!"))

  @main def dateNow:Unit =
    val dateNow: LocalDate | UncheckedNull = LocalDate.now
    println(dateNow.toOption)

  @main def dateNowFailed:Unit =
    val dateNowFailed: LocalDate | UncheckedNull = null
    println(dateNowFailed.toOption)

  @main def testConvertArraysField: Unit =
    val arraysField:Array[String | UncheckedNull] | UncheckedNull = "One, Two, Three".split(", ")
    val arraysFieldOption:Option[Array[String | UncheckedNull]] = arraysField.toOption
    val nextStep:Option[Array[String]] = arraysFieldOption.map(arr => arr.flatMap(_.toOption))
    val strArray = nextStep.getOrElse(Array[String]())
    println(strArray.toList)
    println(arraysField.toOption.map(_.flatMap(_.toOption)).getOrElse(Array[String]()).toList)