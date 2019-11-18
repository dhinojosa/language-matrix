
class League(val name:String)
class Division (val name:String, val league:League)
class Team private (val name:String, val division:Division,
                    val wins:Int, val losses:Int) {

   def this(name:String, division:Division) = this(name, division, 0, 0)

   def record = s"${wins}-${losses}"

   def addWin:Team = new Team(name, division, wins + 1, losses)

   def addLoss:Team = new Team(name, division, wins, losses + 1)
 }


val league = new League("National League")
val division = new Division("West", league)
val team = new Team("Los Angeles Dodgers", division)

val result = team.addWin.addWin.addLoss.addLoss

println(s"""Number of wins for ${team.division.league.name} ${team.division.name} ${team.name}: ${result.record}""")
