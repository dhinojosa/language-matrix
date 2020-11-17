package com.evolutionnext.self_types

import org.scalatest.{FunSpec, Matchers}

class SelfTypesSpec extends FunSpec with Matchers {
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
