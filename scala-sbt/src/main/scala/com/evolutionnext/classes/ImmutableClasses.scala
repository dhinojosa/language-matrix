package com.evolutionnext.classes

class League(val name: String)
class Division(val name: String, val league: League)
class ImmutableTeam(
    val name: String,
    val division: Division,
    val wins: Int,
    val losses: Int
) {

  def this(name: String, division: Division) = this(name, division, 0, 0)

  def record = s"${wins}-${losses}"

  def addWin: ImmutableTeam = new ImmutableTeam(name, division, wins + 1, losses)

  def addLoss: ImmutableTeam = new ImmutableTeam(name, division, wins, losses + 1)
}
