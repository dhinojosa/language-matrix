package com.evolutionnext.macros

import scala.quoted.*

object MyMacros:
  def inspectCode(x: Expr[Any])(using Quotes): Expr[Any] =
    println(x.show)
    x
