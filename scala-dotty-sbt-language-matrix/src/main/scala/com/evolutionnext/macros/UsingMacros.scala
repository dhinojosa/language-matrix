package com.evolutionnext.macros
import scala.quoted.*
import com.evolutionnext.macros.MyMacros.*

case class Employee(firstName:String, lastName:String)

@main def assertSimpleMacroWorks: Unit =
    inline def inspect(inline x: Any): Any = ${ inspectCode('x) }
    println(inspect(new Employee("fn", "ln")));
