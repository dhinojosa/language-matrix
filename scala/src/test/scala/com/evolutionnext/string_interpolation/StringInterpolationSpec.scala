package com.evolutionnext.string_interpolation

import org.scalatest.{FunSpec, Matchers}

class StringInterpolationSpec extends FunSpec with Matchers {
  val name = "Albert Einstein"
  val age = 76

  describe("String Interpolation") {
    it(
      "is prepended with an s and interpolation is done with a dollar sign and brackets"
    ) {
      /* A String can be interpolated with a double quoted string
       * Given a couple variable assignments...*/

      /* It can be interpolated in the string with a dollar sign
       * and possibly a bracket Anything after the dollar
       * sign replaces the values in the context */

      val result = s"His name was ${name} and he lived until he was ${age}"
      result should be ("His name was Albert Einstein and he lived until he was 76")
    }

    /* If it is one single variable without any method call or
     * mathematic operations you can omit the braces */

    it("doesn't require brackets if we are just referring to the variable") {
      s"His name was $name and he lived until he was $age"
    }

    it("""If there is a method that needs to be called or some kind of
        |  arithmetic operation you need the braces""".stripMargin) {

      s"His name was ${name.reverse} and he lived until he was ${age + 1}"

    }
  }
}
