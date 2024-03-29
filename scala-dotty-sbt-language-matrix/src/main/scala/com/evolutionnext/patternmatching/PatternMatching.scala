package com.evolutionnext.patternmatching
import com.evolutionnext.explicitnulls.ExplicitNulls

object ScalaSearch:
  def unapply(s: String): Boolean =
    s.toLowerCase.toOption
      .map(_ == "scala")
      .getOrElse(false)

object PatternMatching extends App:
  val books = Seq("Programming Scala", "JavaScript: The Good Parts", "Scala Cookbook").zipWithIndex

  val result = for s <- books yield s match
    case (ScalaSearch(), index) => s"$index: found Scala"
    case (_, index)             => s"$index: no Scala"

  println(result)
