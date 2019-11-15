package com.evolutionnext.creatorapplications

object CreatorApplicationsUsingJava extends App {
  /** If the simple function works as stated then
   *  that also means that it would work with
   *  anything within the Java API
   **/

  import java.util.{ArrayList => JArrayList, List => JList}
  import java.lang.{Integer => JInteger}

  val xs = JArrayList[JInteger]()
  xs.add(30)
  xs.add(40)
  xs.add(50)
  println(xs)
}
