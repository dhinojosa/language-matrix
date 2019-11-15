package com.evolutionnext.uniontypes

import java.time.LocalDateTime

case class LoginSuccess(time:LocalDateTime)
case class LoginFailure(message:String)

//Notice: We don't need to add any subclasses
type LoginStatus = LoginSuccess | LoginFailure

object UnionTypes extends App {
   def matchItUp(x:LoginStatus) = x match {
     case LoginFailure(b) => s"Failed with $b"
     case LoginSuccess(t) => s"Successful"
   }
   def login(s:String):LoginStatus = 
     if (s.isEmpty) LoginFailure("That's no name")
     else LoginSuccess(LocalDateTime.now)

   println(login("Alex Morgan"))
   println(login(""))
   println(matchItUp(login("Megan Rapinoe")))
}
