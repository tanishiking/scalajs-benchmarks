# Scala.js Benchmarks

Benchmarks for [Scala.js](https://www.scala-js.org/)

All derivative work is the copyright of their respective authors and
distributed under their original license. All original work unless otherwise
stated is distributed under the [same license as
Scala.js](https://github.com/sjrd/scala-js-benchmarks/LICENSE).

## Get started

Open `sbt` and run the benchmarks with the `run` command of every project.
For example,

    > richardsJS/run

To test the fullOpt version, use, as usual:

    > set scalaJSStage in Global := FullOptStage

The benchmarks cross-compiled and can be run with the JVM too:

    > richardsJVM/run
