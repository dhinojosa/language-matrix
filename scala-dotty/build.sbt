name := "dotty-study"

version := "1.0-SNAPSHOT"

description := "Study and Presentation Material for Scala Dotty"

scalaVersion := "3.0.0-M3"

fork := true

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-feature",
  "-deprecation",
  "-Yexplicit-nulls",
  "-Ycheck-init"
)
