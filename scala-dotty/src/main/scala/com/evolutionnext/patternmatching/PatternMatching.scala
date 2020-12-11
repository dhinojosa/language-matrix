package com.evolutionnext.patternmatching

object ScalaSearch:
  def unapply(s: String): Boolean = s.toLowerCase.contains("scala")

object PatternMatching:
  @main def runIt() = {
    val books = Seq(
      "Programming Scala",
      "JavaScript: The Good Parts",
      "Scala Cookbook").zipWithIndex

    val result = for s <- books yield s match
      case (_ @ ScalaSearch(), index) => s"$index: found Scala"
      case (_, index) => s"$index: no Scala"

    println(result)
  }