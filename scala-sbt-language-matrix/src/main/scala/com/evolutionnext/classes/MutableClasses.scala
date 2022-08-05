package com.evolutionnext.classes
/**
 * This is not favorable, since vars are not favorable.
 * This just shows if we attempted to do so in a "Java way"
 * Don't do this. Favor immutablity instead.
 */
class MutableTeam(val name: String, val division: Division) {
  var _wins = 0
  var _losses = 0

  def wins: Int = _wins
  def losses: Int = _losses

  def record = s"${this.wins}-${this.losses}"

  def addWin():Unit = {
    this._wins += 1
  }

  def addLoss():Unit = {
    this._losses += 1
  }
}
