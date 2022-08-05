package com.evolutionnext.contextfunctions

import scala.concurrent.duration.Duration.*
import scala.concurrent.duration.*
import scala.concurrent.{ExecutionContext, Future}

given ec: ExecutionContext = ExecutionContext.Implicits.global

/**
 * Context Functions are functions with only context parameters. The are indicated by ? => T
 */
object ContextFunctions:
  def f(x: Int): ExecutionContext ?=> Future[Int] =
    Future(40 + x)

  @main def testContextFunction: Unit =
    f(10).foreach(println)
