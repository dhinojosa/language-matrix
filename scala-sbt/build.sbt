name := "language_matrix_scala"

version := "1.0-SNAPSHOT"

scalaVersion := "2.13.1"

scalacOptions ++= Seq("-deprecation", "-feature")

Test / testOptions := Seq(Tests.Filter(s => !s.endsWith("IntegrationTest")))

IntegrationTest / testOptions :=
  Seq(Tests.Filter(s => s.endsWith("IntegrationTest")))

projectDependencies ++=
  Seq("org.scalatest" %% "scalatest" % "3.2.9" % Test,
      "org.scalatest" %% "scalatest-funsuite" % "3.2.9" % Test,
      "org.scalamock" %% "scalamock" % "5.1.0" % Test,
      "org.scalacheck" %% "scalacheck" % "1.14.1" % Test
  )
