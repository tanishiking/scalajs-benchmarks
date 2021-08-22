/*                     __                                               *\
**     ________ ___   / /  ___      __ ____  Scala.js Benchmarks        **
**    / __/ __// _ | / /  / _ | __ / // __/  (c) 2016, LAMP/EPFL        **
**  __\ \/ /__/ __ |/ /__/ __ |/_// /_\ \                               **
** /____/\___/_/ |_/____/_/ | |__/ /____/                               **
**                          |/____/                                     **
\*                                                                      */

package org.scalajs.benchmark.intmicro

object IntMicroAll extends org.scalajs.benchmark.Benchmark {
  private val allBenches = Array[org.scalajs.benchmark.Benchmark](
      IntNop30,
      IntXor30,
      IntAdd30,
      IntMul30,
      IntDiv30_30,
      IntDiv30_8,
      IntToString30,
      IntNop,
      IntXor,
      IntAdd,
      IntMul,
      IntDiv32_32,
      IntDiv32_8,
      IntToString32
  )

  override def main(args: Array[String]): Unit = {
    for (bench <- allBenches)
      bench.main(args)
  }

  override def report(): String =
    allBenches.map(_.report()).mkString("\n")

  def run(): Unit = ???
}

object IntMicroDataSets {

  val random30s = Array[Int](
      0x1744213,
      0x1845fc77,
      0xe5050362,
      0xf836d829,
      0x1970303f,
      0xeea127b6,
      0xff1d46d3,
      0xf87c52d4,
      0xe7051419,
      0x15d6c044,
      0xe51b73dc,
      0x15233f43,
      0xf5aad8bd,
      0x16e3e640,
      0x140b8d3c,
      0xf11e6992,
      0x16938cdc,
      0x102de3f,
      0xe50e0cd2,
      0x10595016,
      0x5155de3,
      0x1f9d57a5,
      0x1e1f4d60,
      0x1e5643d5,
      0xc16a15c,
      0x19ec4436,
      0x19454c92,
      0xca99c38,
      0xf2e69095,
      0xf70514ec,
      0xe49093f,
      0xe047f1ff,
      0xe1739a7e,
      0xcbd700a,
      0x11b101ed,
      0xe9889574,
      0xff7a6fd7,
      0xf4cbb470,
      0x1306979a,
      0xe31cb3e3,
      0xe572d8a,
      0x31bde31,
      0x14c858b9,
      0x134ee049,
      0x3d44955,
      0xf7b5a062,
      0xe07787a,
      0xffe5f34a,
      0x3e924ab,
      0xef09c835,
      0xf0cef64e,
      0xfb417668,
      0xea1469dc,
      0xe24a3d45,
      0x55739aa,
      0xe7f50e72,
      0xef1c9773,
      0xefd13332,
      0xf1260a,
      0x1a8b9939,
      0xfc35dde,
      0x6d16070,
      0x14bfeb38,
      0x671f289,
      0x29eb354,
      0xead24e5c,
      0x40915cd,
      0x1e949457,
      0x114c1f3,
      0xe0191690,
      0x856a3f8,
      0xf33a8636,
      0x7a61428,
      0x134f2177,
      0xb1f227d,
      0x5b500f,
      0xfe83a352,
      0xe9bdba23,
      0xf5641601,
      0xe954e411,
      0x1b24aca9,
      0xe58e8b5d,
      0xf5f73484,
      0x13c1b3e6,
      0x86a705c,
      0x7ee59fd,
      0x1b1b332d,
      0xf27e6526,
      0xeb1e3ef9,
      0xaf0907c,
      0xec3d2c4d,
      0xef1d910,
      0xfe787912,
      0xf3e76fc7,
      0x10cfe19d,
      0xe0a17b77,
      0xfe25651c,
      0xf5cdf955,
      0x2225eca,
      0xe5470cf9
  )

  val random32s = Array[Int](
      0x3d7bca72,
      0x6e125b10,
      0xf3299127,
      0xdefa0492,
      0xeea0a2cf,
      0xb8038179,
      0xa0e5f0c,
      0x4d830f21,
      0xef18aa84,
      0x4f042fc1,
      0x12dbd8a5,
      0xe3558dc1,
      0x71ecbe93,
      0xa956d5c6,
      0x640c3bd5,
      0x44d77fb1,
      0x99c9f40,
      0xe79d2c19,
      0xee95932b,
      0x6552cb0b,
      0x5905b9f7,
      0x56af0217,
      0xd5f56c67,
      0x839c8af1,
      0x26d22d6b,
      0x7cc75936,
      0x9c62f33d,
      0xa4268d06,
      0x4c916c02,
      0x751761a0,
      0x5fc17458,
      0xa5a6b220,
      0x20ce206f,
      0xc5b42c05,
      0x45098ca1,
      0x807263b,
      0x2a8b38a0,
      0xe5cd24ad,
      0x5e7f88c0,
      0x510da3b0,
      0x4ecc3adb,
      0xd266abcc,
      0xe971b8e2,
      0x865735a5,
      0xcc6b4923,
      0x67b55f19,
      0x8aa1bcbc,
      0xc292dc7,
      0x71c176e0,
      0xa1ebe8a1,
      0x51280bd0,
      0xe36f4136,
      0x98cc54be,
      0x631666d7,
      0x5ed13def,
      0x7a4a00c1,
      0xdbc5d6d5,
      0x31bbc1f0,
      0x86e8d7fe,
      0x39102053,
      0xbbd1f909,
      0x76ae826d,
      0x695da0fc,
      0x8cd841ac,
      0xdfb7c5b3,
      0xc4fbfcf8,
      0x3467c343,
      0x3fc83653,
      0x47d1a280,
      0x7681e774,
      0x7a993e0d,
      0x81c1ecca,
      0x20bb0799,
      0x7f9fab4f,
      0x62c56b3a,
      0x98d57d03,
      0x6e000504,
      0x7dfa0919,
      0xdab49d4f,
      0xfb630813,
      0xeb753a49,
      0x369ce15a,
      0xa16519c1,
      0xbd4e5f25,
      0x75252458,
      0x9030369f,
      0xb1eaf374,
      0x1951a5b0,
      0x5d29e5a9,
      0x83b2bcd6,
      0x5914897d,
      0x469b62ec,
      0x1298eca5,
      0x27d89db,
      0x9611ae2f,
      0x3cb7b681,
      0xbf181c44,
      0xc079bb52,
      0x1db7ba55,
      0xfb8ba481
  )

  val random8s = Array[Int](
      0xffffff97,
      0x31,
      0xffffffa8,
      0x26,
      0xffffffd5,
      0xc,
      0x4b,
      0x16,
      0x35,
      0x4,
      0x62,
      0xffffffd6,
      0xffffffdf,
      0x1a,
      0x63,
      0xffffffa2,
      0xffffffc7,
      0xffffffa2,
      0xffffffdc,
      0xffffff8a,
      0x56,
      0x16,
      0xffffffb6,
      0x66,
      0x4a,
      0x26,
      0xffffffbd,
      0x6,
      0xffffffda,
      0x12,
      0x5f,
      0xffffffae,
      0x1c,
      0x3c,
      0xffffffb3,
      0xffffffc1,
      0xffffffab,
      0xfffffff8,
      0xffffffbd,
      0xffffffbb,
      0xffffff84,
      0xffffffa6,
      0xfffffff0,
      0x64,
      0x30,
      0x3,
      0xfffffff3,
      0x42,
      0x28,
      0xffffffbb,
      0xffffffa7,
      0x4e,
      0x74,
      0x42,
      0x69,
      0xffffffeb,
      0xffffff94,
      0xffffffe3,
      0xffffff94,
      0x13,
      0xffffffa4,
      0x18,
      0x49,
      0xffffffd3,
      0xffffffba,
      0x1c,
      0x72,
      0xfffffff8,
      0xffffff92,
      0xffffffbf,
      0x3,
      0xa,
      0x6d,
      0x78,
      0xffffff82,
      0x79,
      0x35,
      0xffffffc0,
      0xffffffc9,
      0x16,
      0xffffffe5,
      0xffffff9d,
      0xa,
      0xffffffc4,
      0x27,
      0x7c,
      0x14,
      0x6e,
      0x3e,
      0x43,
      0xffffffd4,
      0x3b,
      0x25,
      0xffffffa6,
      0x1d,
      0xa,
      0xfffffff8,
      0xffffffba,
      0xffffffab,
      0xfffffff6
  )

}

import IntMicroDataSets._

/**
 * Int micro-benchmarks.
 */
abstract class IntMicro extends org.scalajs.benchmark.Benchmark {
  import scala.util.Random

  @inline def doRun(randomAs: Array[Int], randomBs: Array[Int]): Int = {
    val alen = randomAs.length
    val blen = randomBs.length
    var result = 0
    var i = 0
    while (i != alen) {
      var j = 0
      while (j != blen) {
        val a = randomAs(i)
        val b = randomBs(j)
        result ^= binaryOp(a, b)
        j += 1
      }
      i += 1
    }
    result
  }

  def binaryOp(a: Int, b: Int): Int
}

object IntNop30 extends IntMicro {
  override def prefix = "IntNop30"

  def run(): Unit = {
    if (doRun(random30s, random30s) != 0)
      throw new Exception("wrong result")
  }

  @inline def binaryOp(a: Int, b: Int): Int = a
}

object IntXor30 extends IntMicro {
  override def prefix = "IntXor30"

  def run(): Unit = {
    if (doRun(random30s, random30s) != 0)
      throw new Exception("wrong result")
  }

  @inline def binaryOp(a: Int, b: Int): Int = a ^ b
}

object IntAdd30 extends IntMicro {
  override def prefix = "IntAdd30"

  def run(): Unit = {
    if (doRun(random30s, random30s) != 1011365704)
      throw new Exception("wrong result")
  }

  @inline def binaryOp(a: Int, b: Int): Int = a + b
}

object IntMul30 extends IntMicro {
  override def prefix = "IntMul30"

  def run(): Unit = {
    if (doRun(random30s, random30s) != -1524457688)
      throw new Exception("wrong result")
  }

  @inline def binaryOp(a: Int, b: Int): Int = a * b
}

object IntDiv30_30 extends IntMicro {
  override def prefix = "IntDiv30_30"

  def run(): Unit = {
    if (doRun(random30s, random30s) != 65)
      throw new Exception("wrong result")
  }

  @inline def binaryOp(a: Int, b: Int): Int = a / b
}

object IntDiv30_8 extends IntMicro {
  override def prefix = "IntDiv30_8"

  def run(): Unit = {
    if (doRun(random30s, random8s) != 112487962)
      throw new Exception("wrong result")
  }

  @inline def binaryOp(a: Int, b: Int): Int = a / b
}

object IntToString30 extends IntMicro {
  override def prefix = "IntToString30"

  def run(): Unit = {
    if (doRun(random30s, random30s) != 0)
      throw new Exception("wrong result")
  }

  @inline def binaryOp(a: Int, b: Int): Int = java.lang.Integer.toString(a).length()
}

object IntNop extends IntMicro {
  override def prefix = "IntNop"

  def run(): Unit = {
    if (doRun(random32s, random32s) != 0)
      throw new Exception("wrong result")
  }

  @inline def binaryOp(a: Int, b: Int): Int = a
}

object IntXor extends IntMicro {
  override def prefix = "IntXor"

  def run(): Unit = {
    if (doRun(random32s, random32s) != 0)
      throw new Exception("wrong result")
  }

  @inline def binaryOp(a: Int, b: Int): Int = a ^ b
}

object IntAdd extends IntMicro {
  override def prefix = "IntAdd"

  def run(): Unit = {
    if (doRun(random32s, random32s) != 488179650)
      throw new Exception("wrong result")
  }

  @inline def binaryOp(a: Int, b: Int): Int = a + b
}

object IntMul extends IntMicro {
  override def prefix = "IntMul"

  def run(): Unit = {
    if (doRun(random32s, random32s) != -1972181859)
      throw new Exception("wrong result")
  }

  @inline def binaryOp(a: Int, b: Int): Int = a * b
}

object IntDiv32_32 extends IntMicro {
  override def prefix = "IntDiv32_32"

  def run(): Unit = {
    if (doRun(random32s, random32s) != 54)
      throw new Exception("wrong result")
  }

  @inline def binaryOp(a: Int, b: Int): Int = a / b
}

object IntDiv32_8 extends IntMicro {
  override def prefix = "IntDiv32_8"

  def run(): Unit = {
    if (doRun(random32s, random8s) != 396463647)
      throw new Exception("wrong result")
  }

  @inline def binaryOp(a: Int, b: Int): Int = a / b
}

object IntToString32 extends IntMicro {
  override def prefix = "IntToString32"

  def run(): Unit = {
    if (doRun(random32s, random32s) != 0)
      throw new Exception("wrong result")
  }

  @inline def binaryOp(a: Int, b: Int): Int = java.lang.Integer.toString(a).length()
}
