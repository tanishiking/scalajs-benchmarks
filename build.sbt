import org.scalajs.linker.CheckedBehavior.Unchecked
import sbtcrossproject.CrossProject

val projectSettings: Seq[Setting[_]] = Seq(
  organization := "scalajs-benchmarks",
  version := "0.1-SNAPSHOT"
)

val defaultSettings: Seq[Setting[_]] = projectSettings ++ Seq(
  scalaVersion := "2.12.5",
  scalacOptions ++= Seq(
      "-deprecation",
      "-unchecked",
      "-feature",
      "-encoding", "utf8"
  )
)

val defaultJVMSettings: Seq[Setting[_]] = Seq(
  fork in run := !scala.sys.env.get("TRAVIS").exists(_ == "true")
)

val defaultJSSettings: Seq[Setting[_]] = Seq(
  scalaJSLinkerConfig ~= {
    _.withSemantics(_.withAsInstanceOfs(Unchecked).withArrayIndexOutOfBounds(Unchecked))
  },
  scalaJSUseMainModuleInitializer := true
)

lazy val parent = project.in(file(".")).
  settings(projectSettings: _*).
  settings(
    name := "scalajs-benchmarks",
    publishArtifact in Compile := false
  )

lazy val common = crossProject(JSPlatform, JVMPlatform).
  settings(defaultSettings: _*).
  settings(
    name := "scalajs-benchmarks-common",
    moduleName := "common"
  )

lazy val commonJVM = common.jvm
lazy val commonJS = common.js

def autoConfigFull(cp: CrossProject): CrossProject = {
  cp.settings(defaultSettings: _*)
    .jvmSettings(defaultJVMSettings: _*)
    .jsSettings(defaultJSSettings: _*)
    .settings(
      name := "scalajs-benchmark-" + name.value,
      moduleName := name.value.stripPrefix("scalajs-benchmark-")
    )
    .dependsOn(common)
}

def autoConfig(cp: CrossProject.Builder): CrossProject = {
  autoConfigFull(cp.crossType(CrossType.Pure))
}

lazy val deltablue = autoConfig(crossProject(JSPlatform, JVMPlatform))
lazy val deltablueJVM = deltablue.jvm
lazy val deltablueJS = deltablue.js

lazy val richards = autoConfig(crossProject(JSPlatform, JVMPlatform))
lazy val richardsJVM = richards.jvm
lazy val richardsJS = richards.js

lazy val sudoku = autoConfig(crossProject(JSPlatform, JVMPlatform))
lazy val sudokuJVM = sudoku.jvm
lazy val sudokuJS = sudoku.js

lazy val tracer = autoConfigFull(crossProject(JSPlatform, JVMPlatform))
lazy val tracerJVM = tracer.jvm
lazy val tracerJS = tracer.js

lazy val sha512 = autoConfig(crossProject(JSPlatform, JVMPlatform))
lazy val sha512JVM = sha512.jvm
lazy val sha512JS = sha512.js

lazy val sha512Int = autoConfig(crossProject(JSPlatform, JVMPlatform))
lazy val sha512IntJVM = sha512Int.jvm
lazy val sha512IntJS = sha512Int.js

lazy val longMicro = autoConfig(crossProject(JSPlatform, JVMPlatform))
  .settings(
    mainClass in Compile := Some("org.scalajs.benchmark.longmicro.LongMicroAll")
  )
lazy val longMicroJVM = longMicro.jvm
lazy val longMicroJS = longMicro.js

lazy val kmeans = autoConfig(crossProject(JSPlatform, JVMPlatform))
lazy val kmeansJVM = kmeans.jvm
lazy val kmeansJS = kmeans.js
