/*                     __                                               *\
**     ________ ___   / /  ___      __ ____  Scala.js Benchmarks        **
**    / __/ __// _ | / /  / _ | __ / // __/  (c) 2016, LAMP/EPFL        **
**  __\ \/ /__/ __ |/ /__/ __ |/_// /_\ \                               **
** /____/\___/_/ |_/____/_/ | |__/ /____/                               **
**                          |/____/                                     **
\*                                                                      */

package org.scalajs.benchmark.varargsmicro

import org.scalajs.benchmark.Benchmark

object VarargsMicroDataSets {
  val DefaultLoopIterations = 100000

  val arg1 = 1
  val arg2 = 2
  val arg3 = 3
  val arg4 = 4
  val arg5 = 5
}

abstract class VarargsMicro extends Benchmark {
  protected def varargsMethod(args: Int*): Int = {
    var sum = 0
    for (arg <- args) {
      sum += arg
    }
    sum
  }
}

object VarargsMicroAll extends Benchmark {
  private val allBenches = Array[Benchmark](
    VarargsCall_0_Args,
    VarargsCall_1_Arg,
    VarargsCall_5_Args
  )

  override def main(args: Array[String]): Unit = {
    for (bench <- allBenches) {
      bench.main(args)
    }
  }

  override def report(): String = {
    allBenches.map(_.report()).mkString("\n")
  }

  def run(): Unit = ???
}

object VarargsCall_0_Args extends VarargsMicro {
  import VarargsMicroDataSets._
  override def prefix = "Varargs.Call_0_Args"

  def run(): Unit = {
    var acc = 0
    for (_ <- 0 until DefaultLoopIterations) {
      acc += varargsMethod()
    }
  }
}

object VarargsCall_1_Arg extends VarargsMicro {
  import VarargsMicroDataSets._
  override def prefix = "Varargs.Call_1_Arg"

  def run(): Unit = {
    var acc = 0
    for (_ <- 0 until DefaultLoopIterations) {
      acc += varargsMethod(arg1)
    }
  }
}

object VarargsCall_5_Args extends VarargsMicro {
  import VarargsMicroDataSets._
  override def prefix = "Varargs.Call_5_Args"

  def run(): Unit = {
    var acc = 0
    for (_ <- 0 until DefaultLoopIterations) {
      acc += varargsMethod(arg1, arg2, arg3, arg4, arg5)
    }
  }
}