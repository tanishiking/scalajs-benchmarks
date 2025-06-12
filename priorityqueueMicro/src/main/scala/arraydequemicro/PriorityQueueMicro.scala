/*                     __                                               *\
**     ________ ___   / /  ___      __ ____  Scala.js Benchmarks        **
**    / __/ __// _ | / /  / _ | __ / // __/  (c) 2016, LAMP/EPFL        **
**  __\ \/ /__/ __ |/ /__/ __ |/_// /_\ \                               **
** /____/\___/_/ |_/____/_/ | |__/ /____/                               **
**                          |/____/                                     **
\*                                                                      */

package org.scalajs.benchmark.priorityqueuemicro

import org.scalajs.benchmark.Benchmark
import java.util.PriorityQueue
import scala.jdk.CollectionConverters._

object PriorityQueueMicroDataSets {
  val DefaultSize = 10000
  val elementsToAdd: Array[Int] = (0 until DefaultSize).toArray
  val referenceSum: Long = elementsToAdd.foldLeft(0L)(_ + _.toLong)
  val PipelineInitialFillSize: Int = if (DefaultSize >= 10) DefaultSize / 10 else DefaultSize
}

abstract class PriorityQueueMicro extends Benchmark {}

object PriorityQueueMicroAll extends Benchmark {
  private val allBenches = Array[Benchmark](
    PriorityQueueAddN,
    PriorityQueuePollNFromFull,
    PriorityQueuePeekRepeatedlyFromFull,
    PriorityQueueBuildFromCollectionN,
    PriorityQueuePipelinedAddPoll
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

object PriorityQueueAddN extends PriorityQueueMicro {
  import PriorityQueueMicroDataSets._
  override def prefix = "PriorityQueue.add_N"

  def run(): Unit = {
    val pq = new PriorityQueue[Int]()
    for (element <- elementsToAdd) {
      pq.add(element)
    }
  }
}

object PriorityQueuePollNFromFull extends PriorityQueueMicro {
  import PriorityQueueMicroDataSets._
  override def prefix = "PriorityQueue.poll_N_FromFull"

  def run(): Unit = {
    val pq = new PriorityQueue[Int]()
    for (element <- elementsToAdd) {
      pq.add(element)
    }

    var sum = 0L
    for (_ <- 0 until DefaultSize) {
      val polled: Int = pq.poll()
      sum += polled.toLong
    }
  }
}

object PriorityQueuePeekRepeatedlyFromFull extends PriorityQueueMicro {
  import PriorityQueueMicroDataSets._
  override def prefix = "PriorityQueue.peek_Repeatedly"

  def run(): Unit = {
    val pq = new PriorityQueue[Int]()
    if (DefaultSize > 0) {
      for (element <- elementsToAdd) {
        pq.add(element)
      }
    }

    var consumedPeek = 0
    for (_ <- 0 until DefaultSize) {
      if (!pq.isEmpty()) {
        val peeked: Int = pq.peek()
        consumedPeek ^= peeked.hashCode()
      }
    }
  }
}

object PriorityQueueBuildFromCollectionN extends PriorityQueueMicro {
  import PriorityQueueMicroDataSets._
  override def prefix = "PriorityQueue.build_FromCollection_N"

  def run(): Unit = {
    val initialElements: java.util.Collection[Int] = elementsToAdd.toSeq.asJavaCollection
    val pq = new PriorityQueue[Int](initialElements)
  }
}

object PriorityQueuePipelinedAddPoll extends PriorityQueueMicro {
  import PriorityQueueMicroDataSets._
  override def prefix = "PriorityQueue.pipelined_AddPoll"

  def run(): Unit = {
    val pq = new PriorityQueue[Int]()

    val numToPrefill = math.min(PipelineInitialFillSize, DefaultSize)
    for (idx <- 0 until numToPrefill) {
      pq.add(elementsToAdd(idx))
    }

    var nextElementToAddIndex = numToPrefill
    var sumPolled = 0L

    for (_ <- 0 until DefaultSize) {
      val elementToAdd = elementsToAdd(nextElementToAddIndex % DefaultSize)
      pq.add(elementToAdd)
      nextElementToAddIndex += 1

      if (!pq.isEmpty()) {
        val polled: Int = pq.poll()
        sumPolled += polled.toLong
      }
    }
  }
}
