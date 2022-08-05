package com.evolutionnext.creatorapplications

  /**
   * If the simple function works as stated then that also means that it would work with anything within the Java API
   */
def creatorApplicationsInJava():Unit =
  import java.util.{ArrayList as JArrayList, List as JList}
  import java.lang.Integer as JInteger

  val xs = JArrayList[JInteger]()
  xs.add(30)
  xs.add(40)
  xs.add(50)
  println(xs)
