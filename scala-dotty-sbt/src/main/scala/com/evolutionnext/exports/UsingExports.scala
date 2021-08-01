package com.evolutionnext.exports

import java.time.LocalDate

class CalendarEntry(private val localDate: LocalDate, val name: String):
  export localDate.{getDayOfMonth, getDayOfWeek, getDayOfYear}

@main def assertThatAnExportTreatsDelegation: Unit =
  val entry = LocalDate.now() match
    case ld: LocalDate => new CalendarEntry(ld, "Attend conference")
    case _: Null       => throw new RuntimeException("Should never get to this point")

  println(entry.getDayOfWeek())
  println(entry.name)
  println(entry.getDayOfMonth())
