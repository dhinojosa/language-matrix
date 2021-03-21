package com.evolutionnext.uniontypes

case class Assigned(username:String)

case object WontFix

case object Fixed

case object Unassigned

type BugTrackingStatus = Assigned | WontFix.type | Fixed.type | Unassigned.type

object UnionTypesWithObjects extends App {
  def logStatus(x:BugTrackingStatus):String = 
      x match {
          case Assigned(x) => s"Assigned to $x"
          case WontFix  => "Won't Fix"
          case Fixed => "Fixed"
          case Unassigned => "Unassigned"
      }

  println(logStatus(Assigned("Daniel")))
  println(logStatus(WontFix) )
  println(logStatus(Fixed))
  println(logStatus(Unassigned))
}
