package com.evolutionnext.vars

import org.scalatest.{FunSuite, Matchers}

class VarsSpec extends FunSuite with Matchers {
  test("vars are mutable and may be reassigned") {
    var a = 5
    a should be(5)

    a = 7
    a should be(7)
  }
}
