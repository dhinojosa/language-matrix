package com.evolutionnext.inline

class SimpleInlining:
  inline val a = 10
  def process(x: Int) = x + a //a will be placed here with a 10 at compile time

@main def testSimpleInline: Unit =
  val inlining = new SimpleInlining
  println(inlining.process(30))
