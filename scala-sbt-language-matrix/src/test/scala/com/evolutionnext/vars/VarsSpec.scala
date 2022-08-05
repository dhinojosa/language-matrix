package com.evolutionnext.vars

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class VarsSpec extends AnyFunSuite with Matchers {
  test("vars are mutable and may be reassigned") {
    var a = 5
    a should be(5)

    a = 7
    a should be(7)
  }
}
