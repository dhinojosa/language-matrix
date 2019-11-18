package com.evolutionnext.classes

class League(name:String)
class Division (name:String, league:League)
class Team (val name:String, val division:Division) {
   var _wins = 0
   var _losses = 0

   def wins: Int = _wins
   def losses: Int = _losses

   def record = s"${this.wins}-${this.losses}"

   def addWin() {
       this._wins += 1
   }

   def addLoss() {
       this._losses += 1
   }
 }
object Classes extends App {
    val league = new League("National League")
    val division = new Division("West", league)
    val team = new Team("Los Angeles Dodgers", division)

    team.addWin()
    team.addWin()
    team.addLoss()
    team.addLoss()
    team.addWin()

    println(s"Number of wins for ${team.name}: ${team.record}")
}
