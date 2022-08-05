package com.evolutionnext.self_types

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class SelfTypesSpec extends AnyFunSpec with Matchers {
    describe("""Self types""") {
      it (
          """is used to delineate that a trait can be inherited __as long__
            |  as it also implements another trait.""".stripMargin) {

          trait Shouter {
              def shout(s:String) = s + "!"
          }

          trait Screamer { this : Shouter =>
              def scream(s:String) = shout(s.toUpperCase)
          }

          val a = new Object with Screamer with Shouter

         a.scream("let's celebrate") should be ("LET'S CELEBRATE!")
      }
    }
}
