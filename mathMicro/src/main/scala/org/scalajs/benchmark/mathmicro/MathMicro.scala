/*                     __                                               *\
**     ________ ___   / /  ___      __ ____  Scala.js Benchmarks        **
**    / __/ __// _ | / /  / _ | __ / // __/  (c) 2016, LAMP/EPFL        **
**  __\ \/ /__/ __ |/ /__/ __ |/_// /_\ \                               **
** /____/\___/_/ |_/____/_/ | |__/ /____/                               **
**                          |/____/                                     **
\*                                                                      */

package org.scalajs.benchmark.mathmicro

import org.scalajs.benchmark.Benchmark

object MathMicroDataSets {

  private val rng = new scala.util.Random(3168253622807457169L)

  val NaNs = Array.fill(100)(Double.NaN)

  val Specials = Array.tabulate(100) { i =>
    (i % 3) match {
      case 0 => Double.NaN
      case 1 => Double.PositiveInfinity
      case _ => Double.NegativeInfinity
    }
  }

  val Normals = Array.fill(100)(rng.nextDouble())
  val NormalsBits = Normals.map(java.lang.Double.doubleToLongBits(_))

  val Subnormals = Array.fill(100)(rng.nextDouble() * java.lang.Double.MIN_NORMAL)

  val MinusZerosAndOnes = Array.tabulate(100)(i => if (i % 2 == 0) -0.0 else 1.0)

}

import MathMicroDataSets._

object MathMicroAll extends Benchmark {
  private val allBenches = Array[Benchmark](
      new NumberHashCode("NaNs", NaNs, 0),
      new NumberHashCode("Specials", Specials, -2147483648),
      new NumberHashCode("Normals", Normals, 2144013960),
      new NumberHashCode("Subnormals", Subnormals, -1203097025),
      new NumberHashCode("MinusZerosAndOnes", MinusZerosAndOnes, 0),

      new LongBitsToDouble("Normals", NormalsBits, 49.181032038129956),
  )

  override def main(args: Array[String]): Unit = {
    for (bench <- allBenches)
      bench.main(args)
  }

  override def report(): String =
    allBenches.map(_.report()).mkString("\n")

  def run(): Unit = ???
}

class NumberHashCode(kind: String, dataSet: Array[Double], expectedResult: Int) extends Benchmark {
  override def prefix = s"NumberHashCode-$kind"

  def run(): Unit = {
    val dataSet = this.dataSet
    val len = dataSet.length

    var result = 0
    var i = 0
    while (i != len) {
      result ^= dataSet(i).hashCode()
      i += 1
    }
    if (result != expectedResult)
      throw new Exception(s"wrong result: expected $expectedResult but was $result")
  }
}

class LongBitsToDouble(kind: String, dataSet: Array[Long], expectedResult: Double) extends Benchmark {
  override def prefix = s"LongBitsToDouble-$kind"

  def run(): Unit = {
    val dataSet = this.dataSet
    val len = dataSet.length

    var result = 1.0
    var i = 0
    while (i != len) {
      result += java.lang.Double.longBitsToDouble(dataSet(i))
      i += 1
    }
    if (result != expectedResult)
      throw new Exception(s"wrong result: expected $expectedResult but was $result")
  }
}
