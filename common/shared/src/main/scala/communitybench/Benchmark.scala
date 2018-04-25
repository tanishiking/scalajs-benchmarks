package communitybench

abstract class Benchmark extends org.scalajs.benchmark.Benchmark {
  def inputOutput: (String, String)

  def run(input: String): Any

  def run(): Unit = {
    @noinline def getInputOutput(): (String, String) = this.inputOutput

    val inputOutput = getInputOutput()
    val expected = inputOutput._2
    val actual = run(inputOutput._1)

    if (actual.toString() != inputOutput._2)
      throw new AssertionError(s"Expected $expected but got $actual")
  }
}
