package com.evolutionnext.vals

import org.scalatest.{FunSuite, Matchers}

class ValsSpec extends FunSuite with Matchers {
  test("Vals cannot be reassigned") {
    val a = 5
    a should be(5);
  }

  test(
    "vals or vars can have the same name as a keyword as long as it's surrounded by `"
  ) {
    val `class` = "MyClassName"
    `class` should be("MyClassName")
  }
}
