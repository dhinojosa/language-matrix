package com.evolutionnext.regex

import org.scalatest.{FunSpec, Matchers}

class RegexSpec extends FunSpec with Matchers {
  describe("Regular Expressions") {
    it("""A regular expression in scala is a "" or a smart string with
         |  an .r method call to return the regex
         |  If a regular " is used instead of to surround the string, then
         |  you will have to ensure to escape the backslash or
         |  any other characters requiring escape.""".stripMargin) {
      val EatingRegularExpression =
        "Eating Alert: bear=([^,]+),\\s+source=(.+)".r //.r turns a String to a regular expression
      val SittingRegularExpression =
        "Sitting Alert: bear=([^,]+),\\s+source=(.+)".r
      val SleepingRegularExpression =
        "Sleeping Alert: bear=([^,]+),\\s+source=(.+)".r

      val SittingRegularExpression(bear, source) =
        "Sitting Alert: bear=Pooh, source=Couch"
      assert(bear == "Pooh")
      assert(source == "Couch")
    }

    val EatingRegularExpression =
      """Eating Alert: bear=([^,]+),\s+source=(.+)""".r //.r turns a String to a regular expression
    val SittingRegularExpression =
      """Sitting Alert: bear=([^,]+),\s+source=(.+)""".r
    val SleepingRegularExpression =
      """Sleeping Alert: bear=([^,]+),\s+source=(.+)""".r

    it("""Another one that is using an extractor""") {
      val SittingRegularExpression(bear, source) =
        "Sitting Alert: bear=Pooh, source=Couch"
      assert(bear == "Pooh")
      assert(source == "Couch")
    }

    it("can be used for pattern matching since it has an extractor") {
      // A regular expression can also be used in pattern matching
      def goldilocks(expr: String) =
        expr match {
          case (EatingRegularExpression(bear, source)) =>
            "%s said someone's been eating my %s".format(bear, source)
          case (SittingRegularExpression(bear, source)) =>
            "%s said someone's been sitting on my %s".format(bear, source)
          case (SleepingRegularExpression(bear, source)) =>
            "%s said someone's been sleeping in my %s".format(bear, source)
          case _ => "what?"
        }

      assert(
        goldilocks(
          "Sleeping Alert: bear=Smokey, source=California King"
        ) == "Smokey said someone's been sleeping in my California King"
      )
    }
  }
}
