
class Conference {
   String name

   boolean isCase(Object val) {
     val.getClass() == NFLTeam.class && val.conference.name == this.name
   }
}

class NFLTeam {
   String name
   Conference conference
}

def afc = new Conference(name : "AFC")
def nfc = new Conference(name : "NFC")

def patriots = new NFLTeam(name : "New England Patriots", conference: afc)

String result = null
switch(patriots) {
  case afc : result = "An AFC Team"; break;
  case nfc : result = "An NFC Team"; break;
  default  : result = "Unknown"; break;
}

assert result == "An AFC Team"

assert (patriots in afc) == true


def cowboys = new NFLTeam(name : "Dallas Cowboys", conference: nfc)
def saints = new NFLTeam(name : "New Orleans Saints", conference: nfc)
def broncos = new NFLTeam(name : "Denver Broncos", conference: afc)

[cowboys, saints, broncos, patriots].grep(afc) == [broncos, patriots]

