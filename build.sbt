
name := "test_spark"

lazy val commonSettings = Seq(
  organization := "magus",
  version := "0.1.0",
  scalaVersion := "2.11.8",
  libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.1.0",
  libraryDependencies += "org.apache.spark" % "spark-mllib_2.11" % "2.1.0",
  libraryDependencies += "org.apache.spark" % "spark-yarn_2.11" % "2.1.0",
  libraryDependencies += "org.apache.spark" % "spark-hive_2.11" % "2.1.0",
  libraryDependencies += "com.typesafe" % "config" % "1.3.1" ,
  libraryDependencies += "com.github.scopt" % "scopt_2.10" % "3.3.0" ,
  libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
  libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.40",
  libraryDependencies += "com.typesafe.play" % "play-json_2.11" % "2.5.10",


    dependencyOverrides ++= Set(
    "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.5",
    "io.netty" % "netty" % "3.10.3.Final"
  )
)

