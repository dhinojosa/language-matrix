
class League {
   constructor(name) {
      this.name = name
   }
}

class Division {
   constructor(name, league) {
      this.name = name;
      this.league = league;
   }
}

class Team {
   constructor (name, division) {
      this.name = name;
      this.division = division;
      this._wins = 0;
      this._losses = 0;
   }

   get wins() {
      return this._wins;
   }

   get losses() {
      return this._losses
   }

   get record() {
      return `${this._wins}-${this._losses}`;
   }

   addWin() {
      this._wins += 1;
   }

   addLoss() {
      this._losses += 1;
   }
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
