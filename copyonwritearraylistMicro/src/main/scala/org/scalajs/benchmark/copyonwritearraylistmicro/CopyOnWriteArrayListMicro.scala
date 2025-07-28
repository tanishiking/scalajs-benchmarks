package org.scalajs.benchmark.copyonwritearraylistmicro

import org.scalajs.benchmark.Benchmark
import java.util.concurrent.CopyOnWriteArrayList

object CopyOnWriteArrayListMicroAll extends Benchmark {
  private val allBenches = Array[Benchmark](
    new CopyOnWriteArrayListAdd(n = 100),
    new CopyOnWriteArrayListAdd(n = 1000),
    new CopyOnWriteArrayListGet(n = 100),
    new CopyOnWriteArrayListGet(n = 1000),
    new CopyOnWriteArrayListIterator(n = 100),
    new CopyOnWriteArrayListIterator(n = 1000),
    new CopyOnWriteArrayListAddRemove(n = 100),
    new CopyOnWriteArrayListAddRemove(n = 1000)
  )

  override def main(args: Array[String]): Unit = {
    for (bench <- allBenches)
      bench.main(args)
  }

  override def report(): String =
    allBenches.map(_.report()).mkString("\n")

  def run(): Unit = ???
}

class CopyOnWriteArrayListAdd(n: Int) extends Benchmark {
  override def prefix = f"CopyOnWriteArrayListAdd_$n"

  def run(): Unit = {
    var i = 0
    while (i != 10) {
      runInternal()
      i += 1
    }
  }

  @inline
  private def runInternal(): Unit = {
    val list = new CopyOnWriteArrayList[String]()
    var i = 0
    while (i != n) {
      list.add("a")
      i += 1
    }
  }
}

class CopyOnWriteArrayListGet(n: Int) extends Benchmark {
  override def prefix = f"CopyOnWriteArrayListGet_$n"

  val list = new CopyOnWriteArrayList[String]()
  var i = 0
  while (i != n) {
    list.add("a")
    i += 1
  }
  val size = list.size()

  def run(): Unit = {
    var i = 0
    while (i != 10) {
      runInternal()
      i += 1
    }
  }

  @inline
  private def runInternal(): Unit = {
    var i = 0
    while (i != size) {
      list.get(i)
      i += 1
    }
  }
}

class CopyOnWriteArrayListIterator(n: Int) extends Benchmark {
  override def prefix = f"CopyOnWriteArrayListIterator_$n"

  val list = new CopyOnWriteArrayList[String]()
  var i = 0
  while (i != n) {
    list.add("a")
    i += 1
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
    val it = list.iterator()
    while (it.hasNext()) {
      it.next()
    }
  }
}

class CopyOnWriteArrayListAddRemove(n: Int) extends Benchmark {
  override def prefix = f"CopyOnWriteArrayListAddRemove_$n"

  def run(): Unit = {
    var i = 0
    while (i != 10) {
      runInternal()
      i += 1
    }
  }

  @inline
  private def runInternal(): Unit = {
    val list = new CopyOnWriteArrayList[String]()
    var i = 0
    while (i != n) {
      list.add("a")
      list.remove(0)
      i += 1
    }
  }
}
