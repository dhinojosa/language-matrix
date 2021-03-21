package com.evolutionnext.maps

import org.scalatest.{FunSpec, Matchers}

class MapsSpec extends FunSpec with Matchers {
  describe("Maps") {
    it("""can be created with Map.apply, and since apply is magical and can be
         |  called without the explicit method of apply, we can just call Map object
         |  with tuples of entries, the keys in this case are Symbols which are
         |  immutable identities that are used for things like keys""".stripMargin) {

      val nationalLeague = Map((Symbol("Reds"), "Cincinnati Reds"),
                               (Symbol("Dodgers"), "Los Angeles Dodgers"),
                               (Symbol("Braves"), "Atlanta Braves"),
                               (Symbol("Astros"), "Houston Astros")
      )

      assert(nationalLeague.size == 4)
    }

    it("""has a standard way to create tuples within the map is to use the `->` infix
         |  operator, see infix/InfixOperators.scala for more information on how to
         |  create and setup infix operators""".stripMargin) {
      val nationalLeague = Map(
        Symbol("Reds") -> "Cincinnati Reds",
        Symbol("Dodgers") -> "Los Angeles Dodgers",
        Symbol("Braves") -> "Atlanta Braves",
        Symbol("Astros") -> "Houston Astros"
      )
      assert(nationalLeague.size == 4)
    }
  }
}
