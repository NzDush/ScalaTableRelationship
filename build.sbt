name := "ScalaTableRelationship"

version := "0.1"

//scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "io.getquill" %% "quill-async-mysql" % "3.4.10",

  "org.scalatest" %% "scalatest" % "3.2.0-M1" % Test,
  "com.typesafe.slick" %% "slick" % "3.3.2",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.2",

  "mysql" % "mysql-connector-java" % "8.0.17"
)
