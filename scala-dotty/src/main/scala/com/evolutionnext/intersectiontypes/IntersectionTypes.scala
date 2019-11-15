package com.evolutionnext.intersectiontypes

trait Completeable {
  def complete(): Unit
}

trait Auditable {
  def audit(s: String): Unit
}

object Process {
  def foo(x: Completeable & Auditable, y: Int, z: Int): Int = {
    x.audit(s"about to add to elements: $y and $z")
    val sum = y + z
    x.audit(s"sum found: $y and $z = $sum")
    x.complete()
    sum
  }
}

class ProcessListener extends Auditable with Completeable {
  def complete(): Unit = println("Complete called")
  def audit(s: String): Unit = println(s"Audit called with $s")
}

object IntersectionTypes extends App {
  val listener = new ProcessListener
  val result = Process.foo(listener, 10, 12)
  println(s"result is $result")
}
