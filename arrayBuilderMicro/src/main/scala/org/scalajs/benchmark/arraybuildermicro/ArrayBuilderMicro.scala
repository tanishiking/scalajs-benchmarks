/*                     __                                               *\
**     ________ ___   / /  ___      __ ____  Scala.js Benchmarks        **
**    / __/ __// _ | / /  / _ | __ / // __/  (c) 2016, LAMP/EPFL        **
**  __\ \/ /__/ __ |/ /__/ __ |/_// /_\ \                               **
** /____/\___/_/ |_/____/_/ | |__/ /____/                               **
**                          |/____/                                     **
\*                                                                      */

package org.scalajs.benchmark.arraybuildermicro

import org.scalajs.benchmark.Benchmark

object ArrayBuilderMicroAll extends Benchmark {
  private val allBenches = Array[Benchmark](
    new ArrayBuilderFillInt(n = 5, sizeHint = false),
    new ArrayBuilderFillInt(n = 5, sizeHint = true),
    new ArrayBuilderFillInt(n = 100, sizeHint = false),
    new ArrayBuilderFillInt(n = 100, sizeHint = true),
    new ArrayBuilderFillChar(n = 5, sizeHint = false),
    new ArrayBuilderFillChar(n = 5, sizeHint = true),
    new ArrayBuilderFillChar(n = 100, sizeHint = false),
    new ArrayBuilderFillChar(n = 100, sizeHint = true),
    new ArrayBuilderFillString(n = 5, sizeHint = false),
    new ArrayBuilderFillString(n = 5, sizeHint = true),
    new ArrayBuilderFillString(n = 100, sizeHint = false),
    new ArrayBuilderFillString(n = 100, sizeHint = true)
  )

  override def main(args: Array[String]): Unit = {
    for (bench <- allBenches)
      bench.main(args)
  }

  override def report(): String =
    allBenches.map(_.report()).mkString("\n")

  def run(): Unit = ???
}

class ArrayBuilderFillInt(n: Int, sizeHint: Boolean) extends Benchmark {
  override def prefix = {
    val hint = if (sizeHint) "Hint" else "NoHint"
    f"ArrayBuilderFill${n}Int$hint"
  }

  def run(): Unit = {
    var i = 0
    while (i != 10) {
      runInternal()
      i += 1
    }
  }

  @inline
  private def runInternal(): Unit = {
    val builder = Array.newBuilder[Int]

    if (sizeHint)
      builder.sizeHint(n)

    var i = 0
    while (i != n) {
      builder += 1
      i += 1
    }
    builder.result()
  }
}

class ArrayBuilderFillChar(n: Int, sizeHint: Boolean) extends Benchmark {
  override def prefix = {
    val hint = if (sizeHint) "Hint" else "NoHint"
    f"ArrayBuilderFill${n}Char$hint"
  }

  def run(): Unit = {
    var i = 0
    while (i != 10) {
      runInternal()
      i += 1
    }
  }

  @inline
  private def runInternal(): Unit = {
    val builder = Array.newBuilder[Char]

    if (sizeHint)
      builder.sizeHint(n)

    var i = 0
    while (i != n) {
      builder += 'a'
      i += 1
    }
    builder.result()
  }
}

class ArrayBuilderFillString(n: Int, sizeHint: Boolean) extends Benchmark {
  override def prefix = {
    val hint = if (sizeHint) "Hint" else "NoHint"
    f"ArrayBuilderFill${n}String$hint"
  }

  def run(): Unit = {
    var i = 0
    while (i != 10) {
      runInternal()
      i += 1
    }
  }

  @inline
  private def runInternal(): Unit = {
    val builder = Array.newBuilder[String]

    if (sizeHint)
      builder.sizeHint(n)

    var i = 0
    while (i != n) {
      builder += ""
      i += 1
    }
    builder.result()
  }
}
