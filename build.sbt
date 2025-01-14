ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "scala_practice",
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "2.10.0",   // Replace with the latest version
      "org.typelevel" %% "cats-effect" % "3.5.2"   // Optional, for effect management
    )
  )
