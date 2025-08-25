package org.scalajs.benchmark.sortedcollectionmicro

import org.scalajs.benchmark.Benchmark
import java.util._
import scala.jdk.CollectionConverters._

object SortedCollectionMicro extends Benchmark {
  private val allBenches = Array[Benchmark](
    new TreeMapFillInt(n = 100),
    new TreeMapFillInt(n = 1000),
    new TreeSetFillInt(n = 100),
    new TreeSetFillInt(n = 1000)
  )

  override def main(args: Array[String]): Unit = {
    for (bench <- allBenches)
      bench.main(args)
  }

  override def report(): String =
    allBenches.map(_.report()).mkString("\n")

  def run(): Unit = ???
}

class TreeMapFillInt(n: Int) extends Benchmark {
  override def prefix = f"TreeMapFillInt$n"
  val sortedMap = new TreeMap[Int, Int]((0 to n).map(i => i -> i).toMap.asJava)

  def run(): Unit = {
    var i = 0
    while (i != 10) {
      runInternal()
      i += 1
    }
  }

  @inline
  private def runInternal(): Unit = {
    new TreeMap(sortedMap)
  }
}

class TreeSetFillInt(n: Int) extends Benchmark {
  override def prefix = f"TreeSetFillInt$n"
  val sortedSet = new TreeSet[Int]((0 to n).asJava)

  def run(): Unit = {
    var i = 0
    while (i != 10) {
      runInternal()
      i += 1
    }
  }

  @inline
  private def runInternal(): Unit = {
    new TreeSet(sortedSet)
  }
}
