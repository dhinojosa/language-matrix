trait Shouter {
   def shout(s:String) = s + "!"
}

trait Screamer { this : Shouter =>
   def scream(s:String) = shout(s.toUpperCase)
}

val a = new Object with Screamer with Shouter

assert(a.scream("let's celebrate") == "LET'S CELEBRATE!")



