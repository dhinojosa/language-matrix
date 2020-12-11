package com.evolutionnext.typeclasses 

trait AShow[A] {
   def show(a:A):String
}
class Artist(val firstName:String, val lastName:String)

object MyPredef {
   given showArtistFirstThenLast as AShow[Artist] = new AShow[Artist] {
      def show(a:Artist):String = s"Artist(${a.firstName} ${a.lastName})"
   }
   given showArtistLastThenFirst as AShow[Artist] = new AShow[Artist] {
      def show(a:Artist):String = s"Artist(${a.lastName}, ${a.firstName})"
   }
}

object TypeClassesSelection extends App {
  import MyPredef.showArtistLastThenFirst
  val result:String = summon[AShow[Artist]].show(Artist("Lashana","Lynch"))
  println(result)
}
