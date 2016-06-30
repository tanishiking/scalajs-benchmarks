/*                     __                                               *\
**     ________ ___   / /  ___      __ ____  Scala.js Benchmarks        **
**    / __/ __// _ | / /  / _ | __ / // __/  (c) 2003-2016, LAMP/EPFL   **
**  __\ \/ /__/ __ |/ /__/ __ |/_// /_\ \                               **
** /____/\___/_/ |_/____/_/ | |__/ /____/                               **
**                          |/____/                                     **
\*                                                                      */

package org.scalajs.benchmark

/** Simple benchmarking framework.
 *
 *  The `run` method has to be defined by the user, who will perform the
 *  timed operation there.
 *
 *  This will run the benchmark a minimum of 5 times and for at least 2
 *  seconds.
 */
abstract class Benchmark {

  def main(args: Array[String]): Unit = {
    main()
  }

  def main(): Unit = {
    val status = report()
    println(s"$prefix: $status")
  }

  /** This method should be implemented by the concrete benchmark.
   *  It will be called by the benchmarking code for a number of times.
   *
   *  @see setUp
   *  @see tearDown
   */
  def run(): Unit

  /** Run the benchmark the specified number of milliseconds and return
   *  the average execution time in microseconds.
   */
  def runBenchmark(timeMinimum: Long, runsMinimum: Int): Double = {
    var runs = 0
    val startTime = System.nanoTime()
    var stopTime = startTime + timeMinimum.toLong * 1000000L
    var currentTime = startTime

    do {
      run()
      runs += 1
      currentTime = System.nanoTime()
    } while (currentTime < stopTime || runs < runsMinimum)

    val elapsed = currentTime - startTime
    (elapsed / 1000).toDouble / runs
  }

  /** Prepare any data needed by the benchmark, but whose execution time
   *  should not be measured. This method is run before each call to the
   *  benchmark payload, 'run'.
   */
  def setUp(): Unit = ()

  /** Perform cleanup operations after each 'run'. For micro benchmarks,
   *  think about using the result of 'run' in a way that prevents the JVM
   *  to dead-code eliminate the whole 'run' method. For instance, print or
   *  write the results to a file. The execution time of this method is not
   *  measured.
   */
  def tearDown(): Unit = ()

  /** A string that is written at the beginning of the output line
   *  that contains the timings. By default, this is the class name.
   */
  def prefix: String = getClass().getName()

  def warmUp(): Unit = {
    runBenchmark(10000, 10)
  }

  def report(): String = {
    setUp()
    warmUp()
    val avg = runBenchmark(20000, 50)
    tearDown()

    s"$avg us"
  }
}
