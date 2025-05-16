val scalaJSVersion =
  Option(System.getenv("SCALAJS_VERSION")).getOrElse("1.19.1-SNAPSHOT")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % scalaJSVersion)
addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.3.2")
