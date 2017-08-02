name := "VKBot"

version := "1.0"

scalaVersion := "2.12.1"


libraryDependencies ++= {
  val akka_version = "2.4.17"
  val akka_http_version = "10.0.3"
  
  Seq(
    "com.typesafe.akka" %% "akka-http" % akka_http_version,
    "com.typesafe.akka" %% "akka-remote" % akka_version,
    "com.typesafe.akka" %% "akka-testkit" % akka_version % "test",
  
    "org.scalaj"        %% "scalaj-http" % "2.3.0",
    "com.github.fomkin" %% "pushka-json" % "0.8.0"/* % "test"*/
  )
}