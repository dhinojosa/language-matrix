package com.evolutionnext.self_types

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
trait Shouter {
    def shout(s: String): String = s + "!"
}

trait Screamer { this: Shouter =>
    def scream(s: String): String = shout(s.toUpperCase)
}
class SelfTypesSpec extends AnyFunSpec with Matchers {
  describe("""Self types""") {
    it("""is used to delineate that a trait can be inherited __as long__
         |  as it also implements another trait.""".stripMargin) {

      val a = new Object with Shouter with Screamer
      a.scream("let's celebrate") should be("LET'S CELEBRATE!")
    }
  }
}
