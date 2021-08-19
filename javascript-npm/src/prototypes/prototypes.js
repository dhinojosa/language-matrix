
function League(name) {
   this.name = name
}

function Division(name, league) {
   this.name = name;
   this.league = league;
}

function Team(name, division) {
   this.name = name;
   this.division = division;
   this._wins = 0;
   this._losses = 0;
}

Team.prototype = {
   get wins() {
      return this._wins;
   },
   get losses() {
      return this._losses
   },
   get record() {
      return "" + this._wins + "-" + this._losses;
   }
}

Team.prototype.addWin = function() {
   this._wins += 1;
}

Team.prototype.addLoss = function() {
   this._losses += 1;
}

const league = new League('National League');
const division = new Division('West', league);
const team = new Team('Los Angeles Dodgers', division)

team.addWin();
team.addWin();
team.addLoss();
team.addLoss();
team.addWin();

console.log(`Number of wins for ${team.name}: ${team.record}`);
