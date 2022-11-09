val scalaJSVersion =
  Option(System.getenv("SCALAJS_VERSION")).getOrElse("1.11.0")

addSbtPlugin("org.scala-js" % "sbt-scalajs" % scalaJSVersion)
addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.1.0")
