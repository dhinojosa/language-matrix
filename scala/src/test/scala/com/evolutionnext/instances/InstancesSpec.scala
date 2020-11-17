package com.evolutionnext.instances

import org.scalatest.{FunSuite, Matchers}

class InstancesSpec extends FunSuite with Matchers {

  def whoIsThis(x:Any): Unit = {
    println(x.isInstanceOf[Int])
    println(x.isInstanceOf[Number])
    println(x.isInstanceOf[AnyRef])
  }

  test("isInstanceOf determines the instance of a type") {
    val x:Any = 40
    x.isInstanceOf[Int] should be (true)
    x.isInstanceOf[Number] should be (true)
    x.isInstanceOf[AnyRef] should be (true)
  }

  test("asInstanceOf converts or casts a type") {
    val x = 40
    x.asInstanceOf[Double] should be (40.0)
    a [ClassCastException] should be thrownBy {
      x.asInstanceOf[List[_]]
    }
  }
}
