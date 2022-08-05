package com.evolutionnext.exports

import java.time.LocalDate

class CalendarEntry(private val localDate: LocalDate, val name: String):
  export localDate.{getDayOfMonth, getDayOfWeek, getDayOfYear}

@main def assertThatAnExportTreatsDelegation(): Unit =
  val date:LocalDate | Null = LocalDate.of(2022, 4, 19)
  val entry = new CalendarEntry(date.nn, "Attend conference")
  println(entry.getDayOfWeek())
  println(entry.name)
  println(entry.getDayOfMonth())
