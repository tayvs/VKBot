name := "VKBot"

version := "1.0"

scalaVersion := "2.12.1"


libraryDependencies ++= {
  val akka_version = "2.4.17"
  
  Seq(
    "com.typesafe.akka" %% "akka-remote" % akka_version,
    "com.typesafe.akka" %% "akka-testkit" % akka_version % "test"
  )
}