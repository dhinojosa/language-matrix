package com.evolutionnext.vals

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ValsSpec extends AnyFunSuite with Matchers {
  test("Vals cannot be reassigned") {
    val a = 5
    a should be(5);
  }
}
