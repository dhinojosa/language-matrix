package com.evolutionnext.typeclasses 

trait Show[A] {
   def show(a:A):String
}

case class Employee(firstName:String, lastName:String)

given firstNameThenLast:Show[Employee] = new Show[Employee] {
  def show(a:Employee):String = s"Employee(${a.firstName} ${a.lastName})"
}

object TypeClasses:
  def showMe[A](a:A)(using s:Show[A]) = {
    s.show(a)
  }

  @main def testSummon:Unit =
    val result:String = summon[Show[Employee]].show(Employee("Lashana","Lynch"))
    println(result)

  @main def testShowExample:Unit =
    val result2:String = showMe(Employee("Daniel", "Craig"))
    println(result2)

