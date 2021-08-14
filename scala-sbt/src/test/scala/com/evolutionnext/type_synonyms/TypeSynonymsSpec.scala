package com.evolutionnext.type_synonyms

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class TypeSynonymsSpec extends AnyFunSpec with Matchers {
  describe("Type Synonyms allows to alias a type with another more defined type") {
    it("""is defined using a type keyword which happens to be in the
          |  type-synonyms package object. Notice here that instead of
          |  String, String, we are being more detailed with CustomerID and
          |  ReviewBody""".stripMargin) {
      val r = new BetterReview("123300-EJ", "This is a review of a nice book")
      r.customerID should be ("123300-EJ")
    }
  }
}
