package com.evolutionnext.classes

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class ClassesSpec extends AnyFunSuite with Matchers {

  test("""The following shows how to create a "classic Java" mutable class""") {
    val league = new League("National League")
    val division = new Division("West", league)
    val team = new MutableTeam("Los Angeles Dodgers", division)

    team.addWin()
    team.addWin()
    team.addLoss()
    team.addLoss()
    team.addWin()

    println(s"Number of wins for ${team.name}: ${team.record}")
  }

  test("""Using Immutable classes""") {
    val league = new League("National League")
    val division = new Division("West", league)
    val team = new ImmutableTeam("Los Angeles Dodgers", division)

    val result = team.addWin.addWin.addLoss.addLoss

    println(s"""Number of wins for ${team.division.league.name} ${team.division.name} ${team.name}: ${result.record}""")
  }

  test("""Create a class, and the class should be
         |  instantiable with the elements, but without a val
         |  I cannot get information. Having the ability to set
         |  the function for date is wonderful
         |  for unit testing. You can also set the constructor
         |  to protected""".stripMargin) {

    val stamp = new Stamp("Jimi Hendrix", 2014, () => 2018)
    stamp.theme should be("Jimi Hendrix")
    stamp.year should be(2014)
    stamp.age should be(4)
  }

  test("""Case classes have automatic functionality for getters, toString,
         |  equals, hashCode, apply,
         |  and basic pattern matching""".stripMargin) {
    val computer = Computer("Commodore", "64", 1983)
    computer.make should be("Commodore")
    computer.model should be("64")
  }

  test("Preconditions can be made with require and are used in the class") {
    val exception1 = the[IllegalArgumentException] thrownBy {
      Stamp("", 1980)
    }

    exception1.getMessage should be("requirement failed: Theme cannot be empty")
  }

  test("Subclassing in Scala") {
    val baseballCard = new BaseballCard(1952, "Topps", "Mickey Mantle", "American", "Eastern")

    baseballCard.year should be(1952)
    baseballCard.manufacturer should be("Topps")
    baseballCard.playerName should be("Mickey Mantle")
  }

  test("Abstract Classes in Scala") {
    val baseballCard = new BaseballCard(1952, "Topps", "Mickey Mantle", "American", "Eastern")

    baseballCard shouldBe a[Collectable]
    baseballCard shouldBe a[SportsCard]
    baseballCard shouldBe a[BaseballCard]
  }

  test("Generic Classes in Scala") {
    val box = Box(new BaseballCard(1952, "Topps", "Mickey Mantle", "American", "Eastern"))

    val box2 = Box(10)

    box.contents.manufacturer should be("Topps")
    box2.contents + 20 should be(30)
  }

  test("Generic Classes in Scala with our own map") {
    val box = Box(new BaseballCard(1952, "Topps", "Mickey Mantle", "American", "Eastern"))

    val result: Box[String] = box.map(bc => bc.league)
    result should be(Box("American"))
  }
}
