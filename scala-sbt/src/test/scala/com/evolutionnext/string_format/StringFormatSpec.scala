package com.evolutionnext.string_format

import org.scalatest.{FunSpec, Matchers}

class StringFormatSpec extends FunSpec with Matchers {
  describe("String format") {
    it("can be done in the old Java style") {
      val str = String.format("This is a %s", "test")
      str should be("This is a test")
    }

    it("has its own style in Scala") {
      val str2 = "This is a %s".format("test")
      str2 should be("This is a test")
    }

    it("has Java/C style formats") {
      val str = "Because you're %3$s, %2$s, %1$s times a lady".format(
        "Three",
        "Twice",
        "Once"
      );
      str should be("Because you're Once, Twice, Three times a lady")
    }

    it("""can be used with the Java DateTime 8, and Java Style Conversion location""") {
      import java.time._
      val result = "We will be eating lunch on %1$tB the %1$te in the year %1$tY.".format(LocalDate.of(2020, 11, 16))
      result should be("We will be eating lunch on November the 16 in the year 2020.")
    }

    it("""can be used with StripMargin""") {
      val lyrics = """I see trees of %s
                     @%s roses too
                     @I see them bloom
                     @For me and you
                     @And I think to myself
                     @What a wonderful world""".stripMargin('@').format("green", "Red")
      lyrics should be("""I see trees of green
                         |Red roses too
                         |I see them bloom
                         |For me and you
                         |And I think to myself
                         |What a wonderful world""".stripMargin)
    }
  }
}
