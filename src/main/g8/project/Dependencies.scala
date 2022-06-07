import sbt._

object Dependencies {
  lazy val testLibs = Seq("org.scalactic" %% "scalactic" % "3.2.11" % Test,
    "org.scalatest" %% "scalatest" % "3.2.11" % Test)

  lazy val configLibs = Seq("com.typesafe" % "config" % "1.4.1")

  lazy val loggingLibs = Seq("org.slf4j" % "slf4j-api" % "2.0.0-alpha4",
    "ch.qos.logback" % "logback-classic" % "1.3.0-alpha10",
    "ch.qos.logback" % "logback-core" % "1.3.0-alpha10",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4")
}
