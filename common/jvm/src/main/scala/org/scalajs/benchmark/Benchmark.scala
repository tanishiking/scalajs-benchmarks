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
    println(report())
  }

  /** This method should be implemented by the concrete benchmark.
   *  It will be called by the benchmarking code for a number of times.
   *
   *  @see setUp
   *  @see tearDown
   */
  def run(): Unit

  /** Run the benchmark the specified number of milliseconds and return
   *  the mean execution time and SEM in microseconds.
   */
  def runBenchmark(timeMinimum: Long, runsMinimum: Int): (Double, Double) = {
    var runs = 0
    var enoughTime = false
    val stopTime = System.nanoTime() + timeMinimum.toLong * 1000000L

    val samples = Array.newBuilder[Double]

    do {
      val startTime = System.nanoTime()
      run()
      val endTime = System.nanoTime()
      samples += (endTime - startTime) / 1000.0
      runs += 1
      enoughTime = endTime >= stopTime
    } while (!enoughTime || runs < runsMinimum)

    meanAndSEM(samples.result())
  }

  private def meanAndSEM(samples: Array[Double]): (Double, Double) = {
    val n = samples.length
    val mean = samples.sum / n
    val sem = standardErrorOfTheMean(samples, mean)
    (mean, sem)
  }

  private def standardErrorOfTheMean(samples: Array[Double],
      mean: Double): Double = {
    val n = samples.length.toDouble
    Math.sqrt(samples.map(xi => Math.pow(xi - mean, 2)).sum / (n * (n - 1)))
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
    val (mean, sem) = runBenchmark(3000, 20)
    tearDown()

    val envInfo = System.getProperty("benchmark.envInfo")
    s"$prefix;$envInfo;JVM;$mean;$sem"
  }
}
