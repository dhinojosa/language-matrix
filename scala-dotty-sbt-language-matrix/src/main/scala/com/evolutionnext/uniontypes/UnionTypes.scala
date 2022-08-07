package com.evolutionnext.uniontypes

import java.time.LocalDateTime

case class LoginSuccess(time: LocalDateTime)
case class LoginFailure(message: String)

extension [A](x: A | Null)
  def toOption =
    if x == null then Option.empty[A] else Some(x.asInstanceOf[A])

//Notice: We don't need to add any subclasses
type LoginStatus = LoginSuccess | LoginFailure

object UnionTypes:
  def matchItUp(x: LoginStatus): String = x match
    case LoginFailure(b) => s"Failed with $b"
    case LoginSuccess(t) => s"Successful on $t"

  def login(s: String): LoginStatus =
    if s.isEmpty then LoginFailure("That's no name")
    else
      LocalDateTime.now.toOption
        .map(LoginSuccess.apply)
        .getOrElse(LoginFailure("Can't get local date"))

@main
def testUnionTypes(): Unit =
  import UnionTypes.*
  println(login("Alex Morgan"))
  println(login(""))
  println(matchItUp(login("Megan Rapinoe")))
