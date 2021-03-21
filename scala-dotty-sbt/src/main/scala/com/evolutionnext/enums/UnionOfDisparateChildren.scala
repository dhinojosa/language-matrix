package com.evolutionnext.enums
//If we have four classes that are children of the two parents we 
//cannot put them into an enum

trait ParentA
trait ParentB

enum ZoneA {
  case ChildA1(x:Int) extends ZoneA with ParentA
  case ChildA2(x:Int) extends ZoneA with ParentA
}

enum ZoneB {
  case ChildB1(x:Int) extends ZoneB with ParentB
  case ChildB2(x:Int) extends ZoneB with ParentB
}

type FirstChildren = ZoneA.ChildA1 | ZoneB.ChildB1

object UnionOfDisparateChildren extends App {
  def logStatus(x:FirstChildren):String = 
    x match {
        case ZoneA.ChildA1(x) => s"ChildA1 $x"
        case ZoneB.ChildB1(x) => s"ChildB1 $x"
    }
  val candidate = new ZoneB.ChildB1(12)
  logStatus(candidate)
}
