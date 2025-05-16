/*                     __                                               *\
**     ________ ___   / /  ___      __ ____  Scala.js Benchmarks        **
**    / __/ __// _ | / /  / _ | __ / // __/  (c) 2016, LAMP/EPFL        **
**  __\ \/ /__/ __ |/ /__/ __ |/_// /_\ \                               **
** /____/\___/_/ |_/____/_/ | |__/ /____/                               **
**                          |/____/                                     **
\*                                                                      */

package org.scalajs.benchmark.arraydequemicro

import org.scalajs.benchmark.Benchmark
import java.util.ArrayDeque

object ArrayDequeMicroDataSets {
  val DefaultSize = 10000
  val elementsToAdd: Array[Int] = (0 until DefaultSize).toArray
}

abstract class ArrayDequeMicro extends Benchmark {}

object ArrayDequeMicroAll extends Benchmark {
  private val allBenches = Array[Benchmark](
    ArrayDequeAddLastN,
    ArrayDequeAddFirstN,
    ArrayDequePollFirstNFromFull,
    ArrayDequePollLastNFromFull,
    ArrayDequePeekFirstRepeatedlyFromFull,
    ArrayDequePeekLastRepeatedlyFromFull,
    ArrayDequeOfferLastPollFirstCycle,
    ArrayDequeOfferLastPollLastCycle,
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

object ArrayDequeAddLastN extends ArrayDequeMicro {
  import ArrayDequeMicroDataSets._
  override def prefix = "ArrayDeque.addLast_N"

  def run(): Unit = {
    val deque = new ArrayDeque[Int]()
    for (element <- elementsToAdd) {
      deque.addLast(element)
    }
  }
}

object ArrayDequeAddFirstN extends ArrayDequeMicro {
  import ArrayDequeMicroDataSets._
  override def prefix = "ArrayDeque.addFirst_N"

  def run(): Unit = {
    val deque = new ArrayDeque[Int]()
    for (element <- elementsToAdd) {
      deque.addFirst(element)
    }
  }
}

object ArrayDequePollFirstNFromFull extends ArrayDequeMicro {
  import ArrayDequeMicroDataSets._
  override def prefix = "ArrayDeque.pollFirst_N_FromFull"

  def run(): Unit = {
    val deque = new ArrayDeque[Int]()
    for (element <- elementsToAdd) {
      deque.addLast(element)
    }

    var sum = 0L
    for (_ <- 0 until DefaultSize) {
      val polled: Int = deque.pollFirst()
      sum += polled.toLong
    }
  }
}

object ArrayDequePollLastNFromFull extends ArrayDequeMicro {
  import ArrayDequeMicroDataSets._
  override def prefix = "ArrayDeque.pollLast_N_FromFull"

  def run(): Unit = {
    val deque = new ArrayDeque[Int]()
    for (element <- elementsToAdd) {
      deque.addLast(element)
    }

    var sum = 0L
    for (_ <- 0 until DefaultSize) {
      val polled: Int = deque.pollLast()
      sum += polled.toLong
    }
  }
}

object ArrayDequePeekFirstRepeatedlyFromFull extends ArrayDequeMicro {
  import ArrayDequeMicroDataSets._
  override def prefix = "ArrayDeque.peekFirst_Repeatedly"

  def run(): Unit = {
    val deque = new ArrayDeque[Int]()

    val size = 16 // the maximum size that doesn't cause resizing
    val elementsToAdd: Array[Int] = (0 until size).toArray
    for (element <- elementsToAdd) {
      deque.addLast(element)
    }

    var consumedPeek = 0
    for (_ <- 0 until DefaultSize) {
      val peeked: Int = deque.peekFirst()
      consumedPeek += peeked
    }
  }
}

object ArrayDequePeekLastRepeatedlyFromFull extends ArrayDequeMicro {
  import ArrayDequeMicroDataSets._
  override def prefix = "ArrayDeque.peekLast_Repeatedly"

  def run(): Unit = {
    val deque = new ArrayDeque[Int]()
    val size = 16 // the maximum size that doesn't cause resizing
    val elementsToAdd: Array[Int] = (0 until size).toArray
    if (DefaultSize > 0) {
      for (element <- elementsToAdd) {
        deque.addLast(element)
      }
    }

    var consumedPeek = 0
    for (_ <- 0 until DefaultSize) {
      val peeked: Int = deque.peekLast()
      consumedPeek += peeked
    }
  }
}

object ArrayDequeOfferLastPollFirstCycle extends ArrayDequeMicro {
  import ArrayDequeMicroDataSets._
  override def prefix = "ArrayDeque.offerLast_pollFirst_Cycle"

  def run(): Unit = {
    val deque = new ArrayDeque[Int]()
    var sumPolled = 0L
    for (element <- elementsToAdd) {
      deque.offerLast(element)
      val polled: Int = deque.pollFirst()
      sumPolled += polled.toLong
    }
  }
}

object ArrayDequeOfferLastPollLastCycle extends ArrayDequeMicro {
  import ArrayDequeMicroDataSets._
  override def prefix = "ArrayDeque.offerLast_pollLast_Cycle"

  def run(): Unit = {
    val deque = new ArrayDeque[Int]()
    var sumPolled = 0L
    for (element <- elementsToAdd) {
      deque.offerLast(element)
      val polled: Int = deque.pollLast()
      sumPolled += polled.toLong
    }
  }
}