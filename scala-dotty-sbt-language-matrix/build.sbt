name := "scala-dotty-sbt-language-matrix"

version := "1.2"

description := "Study and Presentation Material for Scala Dotty"

scalaVersion := "3.1.3"

fork := true

scalacOptions ++= Seq(
  "-Xfatal-warnings"
  ,"-feature"
  ,"-deprecation"
  ,"-Yexplicit-nulls"
)

libraryDependencies += "org.scalameta" %% "munit" % "0.7.26" % Test
