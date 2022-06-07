import Dependencies._

$if(scala3.truthy)$
ThisBuild / scalaVersion     := "3.1.2"
$else$
ThisBuild / scalaVersion     := "2.13.8"
$endif$
ThisBuild / version          := "0.0.1-SNAPSHOT"
ThisBuild / organization     := "$organization$"

lazy val root = (project in file("."))
  .settings(
    name := "$name$",
    libraryDependencies ++= loggingLibs,
    libraryDependencies ++= configLibs,
    libraryDependencies ++= testLibs
  )

scalacOptions ++= Seq(
  "-deprecation",     // Emit warning and location for usages of deprecated APIs.
  "-explaintypes",    // Explain type errors in more detail.
$if(scala3.truthy)$
$else$
  "-Xsource:3",       // Warn for Scala 3 features
  "-Ywarn-dead-code",  // Warn when dead code is identified.
$endif$
  "-Xfatal-warnings", // Fail the compilation if there are any warnings.
)

javacOptions ++= Seq("-source", "17", "-target", "17", "-Xlint")

assembly / assemblyMergeStrategy := {
  case PathList("META-INF", xs @ _*)       => MergeStrategy.discard
  case n if n.startsWith("reference.conf") => MergeStrategy.concat
  case _                                   => MergeStrategy.first
}
