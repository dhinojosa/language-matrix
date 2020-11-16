package com.ora.scalaprogrammingfundamentals

import org.scalatest.{FunSuite, Matchers}

import scala.annotation.tailrec

class MethodsSpec extends FunSuite with Matchers {
  test("In review, a method is structured like the following:") {
    def foo(x:Int):Int = {
      x + 1
    }

    foo(4) should be (5)  //ScalaTest assertion
  }

  test("Also a method can be inlined if there is only one statement:") {
    def foo(x:Int) = x + 1
    foo(4) should be (5)
  }

  test(
    """Methods can be embedded, in case one method is
      |  exclusively only being used by another""".stripMargin) {
    def foo(x:Int, y:Int):Int = {
       def bar(z:Int):Int = z + 10
       bar(x + y)
    }

    foo(4, 10) should be (24)
  }

  test(
    """Recursion is supported just like another language, here
      |  is a long way attempt to do division in a
      |  recursive style""".stripMargin) {

    def divide(numerator: Int, denominator:Int):Option[Int] = {
      @tailrec
      def divideHelper(numerator:Int, denominator:Int, count:Int):Option[Int] = {
        if (numerator < denominator) Some(count)
        else divideHelper(numerator - denominator, denominator, count + 1)
      }

      if (denominator == 0) None
      else divideHelper(numerator, denominator, 0)
    }

    divide(1, 0) should be (None)
    divide(1, 1) should be (Some(1))
    divide(4, 2) should be (Some(2))
    divide(10, 2) should be (Some(5))
  }

  test(
    """Multi-parameter lists are groups or argument lists,
      |  the purpose are two fold: The get group like terms, and
      |  they make it easy to be partially applied, another reason is
      |  for implicits""".stripMargin) {
     def multiParameters(w:Int)(x:Int)(y:String, z:String):String = {
       y + (w + x) + z
     }

     multiParameters(10)(20)("<<", ">>") should be ("<<30>>")
  }

  test(
    """Partial Applied Function with a multi-parameter list
      |  can be knocked out to provide only some of the entries, entries
      |  that you can fill in later""".stripMargin) {

    def multiParameters(w:Int)(x:Int)(y:String, z:String):String = {
      y + (w + x) + z
    }

    val function = multiParameters(10)(20)_

    val result1 = function.apply("{", "}") should be ("{30}")
    val result2 = function.apply("*", "*") should be ("*30*")
  }

  test(
    """In multi-parameter lists you can use a function. Typically
      |  the function is in the last parameter group, but it's your code,
      |  you can put it wherever you please""".stripMargin) {

    def multiParameterWithFunction(w:Int)(x:Int)(f:Int => String) = f(w * x)

    val result = multiParameterWithFunction(50)(50){i => s"The value is ${i + 3}"}

    result should be ("The value is 2503")
  }

  test(
    """You can also use functions as arguments in whatever
      |  parameter list group that you want. But being the nature of a function,
      |  a multiline function can be a block.""".stripMargin) {
    def multiParameterWithFunction(w:Int)(x:Int)(f:Int => String) = f(w * x)

    val result = multiParameterWithFunction(50)(50){i =>
      val add3 = i + 3
      s"The value is $add3"
    }

    result should be ("The value is 2503")

  }

  test("""What happens if I have a function as the last group in a
      |  multi parameter list and that function has no parameters?""".stripMargin) {

     def timer[A](f: () => A):(Long, A) = {
       val start = System.currentTimeMillis()
       val result = f()
       val end = System.currentTimeMillis()
       (end - start, result)
     }

    val result: (Long, String) = timer(() => {
      Thread.sleep(3000)
      "Hello"
    })

    result._1 should (be >= 3000L and be <= 3100L)
    result._2 should be ("Hello")
  }


  test(
    """The above was ugly, so let's clean it up with
      |  a by-name parameter!""".stripMargin) {

    def timer[A](f: => A):(Long, A) = {
      val start = System.currentTimeMillis()
      val result = f
      val end = System.currentTimeMillis()
      (end - start, result)
    }

    val result: (Long, String) = timer{
      Thread.sleep(3000)
      "Hello"
    }

    result._1 should (be >= 3000L and be <= 3100L)
    result._2 should be ("Hello")
  }


  test("""Turning an method into a function""") {
    def multBy3(x:Int) = x * 3
    List(1, 2, 3).map(multBy3) should contain inOrder (3, 6, 9)
  }

  test(
    """Repeated parameters are the equivalent of varargs in Java, they
      |  allow additional parameters and inside the method they
      |  are just a collection called WrappedArray""".stripMargin) {

    def varargs[A, B](arg1:A, rest:B*) = {
      s"arg1=$arg1, rest=$rest"
    }

    varargs(1, "Foo", "Bar", "Baz", "Qux", "Quux") should be
      "arg1=1, rest=WrappedArray(Foo, Bar, Baz, Qux, Quux)"
  }

  test(
    """Repeated parameters can be sent a list or any other collection,
      |  but the problem is what happens when we just send collection
      |  it would treat it as a single unit instead you can expand the units
      |  with a :_*""".stripMargin) {

    def varargs[A, B](arg1:A, rest:B*) = {
      s"arg1=$arg1, rest=$rest"
    }

    varargs("Hello", List(1,2,3)) should be ("arg1=Hello, rest=WrappedArray(List(1, 2, 3))")

    varargs("Hello", List(1,2,3):_*) should be ("arg1=Hello, rest=List(1, 2, 3)")
  }

  test(
    """Default methods have just methods that have a value
      |  in case you don't have one at the moment.
      |  Another item you'll see with this example
      |  is the named parameter. You can set a parameter
      |  explicitly by the name to avoid any confusion as to what you
      |  are setting""".stripMargin) {


    def deposit(amount:Int, currency:String = "Dollar") =
      if (amount == 1) {
        s"$amount $currency"
      }
      else s"$amount ${currency}s"

    deposit(10) should be ("10 Dollars")
  }
}
