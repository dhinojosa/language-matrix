package com.evolutionnext.patternmatching

extension[A](x:(A | Null))
  def toOption:Option[A] = 
    if x == null then 
      Option.empty[A] 
    else 
      Some(x.asInstanceOf[A])

class Words(words: Seq[String], index: Int) extends Product:
  def _1 = words
  def _2 = index
  def canEqual(that: Any): Boolean = ???
  def productArity: Int = ???
  def productElement(n: Int): Any = ???

object Words:
  def unapply(si: (String, Int)): Words =
    val words = 
      si._1
        .split("""\W+""")
        .toOption
        .map(_.flatMap(_.toOption))
        .getOrElse(Array.empty[String])
    new Words(words.toSeq, si._2)

@main def patternMatchingWords:Unit =
  val books = Seq(
    "Programming Scala",
    "JavaScript: The Good Parts",
    "Scala Cookbook").zipWithIndex // add an "index"

  val result = books.map {
    case Words(words, index) => s"$index: count = ${words.size}"
  }

  assert(result == Seq("0: count = 2", "1: count = 4", "2: count = 2"))
