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
      IntConstantDivAddBaseline,
      IntSignedConstantDiv,
      IntSignedConstantRem,
      IntUnsignedConstantDiv,
      IntUnsignedConstantRem,
      IntSignedConstantDivPow2,
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

  @FunctionalInterface
  trait IntToIntFun {
    def apply(x: Int): Int
  }

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

  val randomConstantAdds = Array[IntToIntFun](
      num => num + 77424,
      num => num + 12,
      num => num + 242563119,
      num => num + 3551082,
      num => num + -73,
      num => num + 1342515652,
      num => num + -13376,
      num => num + -57,
      num => num + -1154,
      num => num + -476,
      num => num + -57725,
      num => num + 404,
      num => num + 69,
      num => num + -704971,
      num => num + -248640,
      num => num + 3265120,
      num => num + -3,
      num => num + -5949,
      num => num + 50055,
      num => num + -168730,
      num => num + 83644,
      num => num + 22325,
      num => num + -54,
      num => num + -13974,
      num => num + 10080,
      num => num + 30479223,
      num => num + 17705866,
      num => num + -104082,
      num => num + -26146,
      num => num + 59738,
      num => num + -36,
      num => num + -76,
      num => num + -217,
      num => num + -226014,
      num => num + 1862,
      num => num + -10606,
      num => num + 156884,
      num => num + 18695,
      num => num + 1173,
      num => num + -20521,
      num => num + 8779254,
      num => num + -335663,
      num => num + 1104314313,
      num => num + 4154,
      num => num + 39,
      num => num + 43,
      num => num + 7,
      num => num + 5679407,
      num => num + 1309682,
      num => num + 27272,
      num => num + 5,
      num => num + -5852361,
      num => num + -7703704,
      num => num + -37,
      num => num + 2552,
      num => num + -1335,
      num => num + -44336,
      num => num + -817,
      num => num + 4608,
      num => num + 54124346,
      num => num + 61,
      num => num + -7842039,
      num => num + -48,
      num => num + -7,
      num => num + -10,
      num => num + 25762891,
      num => num + -849,
      num => num + 1707330,
      num => num + 588015649,
      num => num + -129701259,
      num => num + 412372,
      num => num + 3,
      num => num + -2202971,
      num => num + -11843,
      num => num + -74323695,
      num => num + -197375832,
      num => num + -1710315,
      num => num + 680740,
      num => num + 7550,
      num => num + -161,
      num => num + -358022470,
      num => num + 638993672,
      num => num + 11598631,
      num => num + -138882445,
      num => num + -5,
      num => num + -6,
      num => num + -7804693,
      num => num + 278312666,
      num => num + 802,
      num => num + 861572,
      num => num + 24441,
      num => num + 69366,
      num => num + -182124649,
      num => num + 21800959,
      num => num + -3709073,
      num => num + 37349214,
      num => num + 133017,
      num => num + -17843,
      num => num + 465149985,
      num => num + -457776,
  )

  val randomSignedConstantDivs = Array[IntToIntFun](
      num => num / 77424,
      num => num / 12,
      num => num / 242563119,
      num => num / 3551082,
      num => num / -73,
      num => num / 1342515652,
      num => num / -13376,
      num => num / -57,
      num => num / -1154,
      num => num / -476,
      num => num / -57725,
      num => num / 404,
      num => num / 69,
      num => num / -704971,
      num => num / -248640,
      num => num / 3265120,
      num => num / -3,
      num => num / -5949,
      num => num / 50055,
      num => num / -168730,
      num => num / 83644,
      num => num / 22325,
      num => num / -54,
      num => num / -13974,
      num => num / 10080,
      num => num / 30479223,
      num => num / 17705866,
      num => num / -104082,
      num => num / -26146,
      num => num / 59738,
      num => num / -36,
      num => num / -76,
      num => num / -217,
      num => num / -226014,
      num => num / 1862,
      num => num / -10606,
      num => num / 156884,
      num => num / 18695,
      num => num / 1173,
      num => num / -20521,
      num => num / 8779254,
      num => num / -335663,
      num => num / 1104314313,
      num => num / 4154,
      num => num / 39,
      num => num / 43,
      num => num / 7,
      num => num / 5679407,
      num => num / 1309682,
      num => num / 27272,
      num => num / 5,
      num => num / -5852361,
      num => num / -7703704,
      num => num / -37,
      num => num / 2552,
      num => num / -1335,
      num => num / -44336,
      num => num / -817,
      num => num / 4608,
      num => num / 54124346,
      num => num / 61,
      num => num / -7842039,
      num => num / -48,
      num => num / -7,
      num => num / -10,
      num => num / 25762891,
      num => num / -849,
      num => num / 1707330,
      num => num / 588015649,
      num => num / -129701259,
      num => num / 412372,
      num => num / 3,
      num => num / -2202971,
      num => num / -11843,
      num => num / -74323695,
      num => num / -197375832,
      num => num / -1710315,
      num => num / 680740,
      num => num / 7550,
      num => num / -161,
      num => num / -358022470,
      num => num / 638993672,
      num => num / 11598631,
      num => num / -138882445,
      num => num / -5,
      num => num / -6,
      num => num / -7804693,
      num => num / 278312666,
      num => num / 802,
      num => num / 861572,
      num => num / 24441,
      num => num / 69366,
      num => num / -182124649,
      num => num / 21800959,
      num => num / -3709073,
      num => num / 37349214,
      num => num / 133017,
      num => num / -17843,
      num => num / 465149985,
      num => num / -457776,
  )

  val randomSignedConstantRems = Array[IntToIntFun](
      num => num % 77424,
      num => num % 12,
      num => num % 242563119,
      num => num % 3551082,
      num => num % -73,
      num => num % 1342515652,
      num => num % -13376,
      num => num % -57,
      num => num % -1154,
      num => num % -476,
      num => num % -57725,
      num => num % 404,
      num => num % 69,
      num => num % -704971,
      num => num % -248640,
      num => num % 3265120,
      num => num % -3,
      num => num % -5949,
      num => num % 50055,
      num => num % -168730,
      num => num % 83644,
      num => num % 22325,
      num => num % -54,
      num => num % -13974,
      num => num % 10080,
      num => num % 30479223,
      num => num % 17705866,
      num => num % -104082,
      num => num % -26146,
      num => num % 59738,
      num => num % -36,
      num => num % -76,
      num => num % -217,
      num => num % -226014,
      num => num % 1862,
      num => num % -10606,
      num => num % 156884,
      num => num % 18695,
      num => num % 1173,
      num => num % -20521,
      num => num % 8779254,
      num => num % -335663,
      num => num % 1104314313,
      num => num % 4154,
      num => num % 39,
      num => num % 43,
      num => num % 7,
      num => num % 5679407,
      num => num % 1309682,
      num => num % 27272,
      num => num % 5,
      num => num % -5852361,
      num => num % -7703704,
      num => num % -37,
      num => num % 2552,
      num => num % -1335,
      num => num % -44336,
      num => num % -817,
      num => num % 4608,
      num => num % 54124346,
      num => num % 61,
      num => num % -7842039,
      num => num % -48,
      num => num % -7,
      num => num % -10,
      num => num % 25762891,
      num => num % -849,
      num => num % 1707330,
      num => num % 588015649,
      num => num % -129701259,
      num => num % 412372,
      num => num % 3,
      num => num % -2202971,
      num => num % -11843,
      num => num % -74323695,
      num => num % -197375832,
      num => num % -1710315,
      num => num % 680740,
      num => num % 7550,
      num => num % -161,
      num => num % -358022470,
      num => num % 638993672,
      num => num % 11598631,
      num => num % -138882445,
      num => num % -5,
      num => num % -6,
      num => num % -7804693,
      num => num % 278312666,
      num => num % 802,
      num => num % 861572,
      num => num % 24441,
      num => num % 69366,
      num => num % -182124649,
      num => num % 21800959,
      num => num % -3709073,
      num => num % 37349214,
      num => num % 133017,
      num => num % -17843,
      num => num % 465149985,
      num => num % -457776,
  )

  val randomUnsignedConstantDivs = Array[IntToIntFun](
      num => Integer.divideUnsigned(num, 55593553),
      num => Integer.divideUnsigned(num, 3749),
      num => Integer.divideUnsigned(num, 17),
      num => Integer.divideUnsigned(num, 1428),
      num => Integer.divideUnsigned(num, 818),
      num => Integer.divideUnsigned(num, 14551093),
      num => Integer.divideUnsigned(num, 37),
      num => Integer.divideUnsigned(num, 5939),
      num => Integer.divideUnsigned(num, 23791644),
      num => Integer.divideUnsigned(num, 62176),
      num => Integer.divideUnsigned(num, 62886008),
      num => Integer.divideUnsigned(num, 4200),
      num => Integer.divideUnsigned(num, 24415344),
      num => Integer.divideUnsigned(num, 3742008),
      num => Integer.divideUnsigned(num, 1662660321),
      num => Integer.divideUnsigned(num, 201079104),
      num => Integer.divideUnsigned(num, 11309),
      num => Integer.divideUnsigned(num, 53899),
      num => Integer.divideUnsigned(num, 69189408),
      num => Integer.divideUnsigned(num, -1616873345),
      num => Integer.divideUnsigned(num, 1826946),
      num => Integer.divideUnsigned(num, 2445740),
      num => Integer.divideUnsigned(num, 111811),
      num => Integer.divideUnsigned(num, 456959),
      num => Integer.divideUnsigned(num, 1242),
      num => Integer.divideUnsigned(num, 29405997),
      num => Integer.divideUnsigned(num, 84),
      num => Integer.divideUnsigned(num, 23163289),
      num => Integer.divideUnsigned(num, 253809),
      num => Integer.divideUnsigned(num, 241806),
      num => Integer.divideUnsigned(num, 1717),
      num => Integer.divideUnsigned(num, 2695811),
      num => Integer.divideUnsigned(num, 3),
      num => Integer.divideUnsigned(num, 18),
      num => Integer.divideUnsigned(num, 473),
      num => Integer.divideUnsigned(num, 7),
      num => Integer.divideUnsigned(num, 10222),
      num => Integer.divideUnsigned(num, 1000),
      num => Integer.divideUnsigned(num, -1957117327),
      num => Integer.divideUnsigned(num, 64053892),
      num => Integer.divideUnsigned(num, -1474995822),
      num => Integer.divideUnsigned(num, 109),
      num => Integer.divideUnsigned(num, -238156041),
      num => Integer.divideUnsigned(num, 104),
      num => Integer.divideUnsigned(num, 137),
      num => Integer.divideUnsigned(num, 416244772),
      num => Integer.divideUnsigned(num, 257401848),
      num => Integer.divideUnsigned(num, 5359),
      num => Integer.divideUnsigned(num, 105),
      num => Integer.divideUnsigned(num, 42),
      num => Integer.divideUnsigned(num, 4557528),
      num => Integer.divideUnsigned(num, 526297460),
      num => Integer.divideUnsigned(num, 213583272),
      num => Integer.divideUnsigned(num, 61815122),
      num => Integer.divideUnsigned(num, 123421),
      num => Integer.divideUnsigned(num, 165),
      num => Integer.divideUnsigned(num, 23983337),
      num => Integer.divideUnsigned(num, 1857108),
      num => Integer.divideUnsigned(num, 120623),
      num => Integer.divideUnsigned(num, 4464),
      num => Integer.divideUnsigned(num, 19802),
      num => Integer.divideUnsigned(num, 78824),
      num => Integer.divideUnsigned(num, 572707184),
      num => Integer.divideUnsigned(num, 7),
      num => Integer.divideUnsigned(num, 12),
      num => Integer.divideUnsigned(num, 841079139),
      num => Integer.divideUnsigned(num, 10618),
      num => Integer.divideUnsigned(num, 443093),
      num => Integer.divideUnsigned(num, 722082088),
      num => Integer.divideUnsigned(num, 12),
      num => Integer.divideUnsigned(num, 1458),
      num => Integer.divideUnsigned(num, 1447),
      num => Integer.divideUnsigned(num, 75),
      num => Integer.divideUnsigned(num, 1421446),
      num => Integer.divideUnsigned(num, 64443),
      num => Integer.divideUnsigned(num, 16425590),
      num => Integer.divideUnsigned(num, 116143205),
      num => Integer.divideUnsigned(num, 698139),
      num => Integer.divideUnsigned(num, 851),
      num => Integer.divideUnsigned(num, 11079),
      num => Integer.divideUnsigned(num, 27),
      num => Integer.divideUnsigned(num, 12305930),
      num => Integer.divideUnsigned(num, 23),
      num => Integer.divideUnsigned(num, 2461059),
      num => Integer.divideUnsigned(num, 751),
      num => Integer.divideUnsigned(num, 149251),
      num => Integer.divideUnsigned(num, 58618),
      num => Integer.divideUnsigned(num, 121005),
      num => Integer.divideUnsigned(num, 196760),
      num => Integer.divideUnsigned(num, 1161),
      num => Integer.divideUnsigned(num, 54485051),
      num => Integer.divideUnsigned(num, 2447),
      num => Integer.divideUnsigned(num, 40314),
      num => Integer.divideUnsigned(num, 6992),
      num => Integer.divideUnsigned(num, 426),
      num => Integer.divideUnsigned(num, 44333),
      num => Integer.divideUnsigned(num, 2016106288),
      num => Integer.divideUnsigned(num, 10),
      num => Integer.divideUnsigned(num, 3985867),
      num => Integer.divideUnsigned(num, 38),
  )

  val randomUnsignedConstantRems = Array[IntToIntFun](
      num => Integer.remainderUnsigned(num, 55593553),
      num => Integer.remainderUnsigned(num, 3749),
      num => Integer.remainderUnsigned(num, 17),
      num => Integer.remainderUnsigned(num, 1428),
      num => Integer.remainderUnsigned(num, 818),
      num => Integer.remainderUnsigned(num, 14551093),
      num => Integer.remainderUnsigned(num, 37),
      num => Integer.remainderUnsigned(num, 5939),
      num => Integer.remainderUnsigned(num, 23791644),
      num => Integer.remainderUnsigned(num, 62176),
      num => Integer.remainderUnsigned(num, 62886008),
      num => Integer.remainderUnsigned(num, 4200),
      num => Integer.remainderUnsigned(num, 24415344),
      num => Integer.remainderUnsigned(num, 3742008),
      num => Integer.remainderUnsigned(num, 1662660321),
      num => Integer.remainderUnsigned(num, 201079104),
      num => Integer.remainderUnsigned(num, 11309),
      num => Integer.remainderUnsigned(num, 53899),
      num => Integer.remainderUnsigned(num, 69189408),
      num => Integer.remainderUnsigned(num, -1616873345),
      num => Integer.remainderUnsigned(num, 1826946),
      num => Integer.remainderUnsigned(num, 2445740),
      num => Integer.remainderUnsigned(num, 111811),
      num => Integer.remainderUnsigned(num, 456959),
      num => Integer.remainderUnsigned(num, 1242),
      num => Integer.remainderUnsigned(num, 29405997),
      num => Integer.remainderUnsigned(num, 84),
      num => Integer.remainderUnsigned(num, 23163289),
      num => Integer.remainderUnsigned(num, 253809),
      num => Integer.remainderUnsigned(num, 241806),
      num => Integer.remainderUnsigned(num, 1717),
      num => Integer.remainderUnsigned(num, 2695811),
      num => Integer.remainderUnsigned(num, 3),
      num => Integer.remainderUnsigned(num, 18),
      num => Integer.remainderUnsigned(num, 473),
      num => Integer.remainderUnsigned(num, 7),
      num => Integer.remainderUnsigned(num, 10222),
      num => Integer.remainderUnsigned(num, 1000),
      num => Integer.remainderUnsigned(num, -1957117327),
      num => Integer.remainderUnsigned(num, 64053892),
      num => Integer.remainderUnsigned(num, -1474995822),
      num => Integer.remainderUnsigned(num, 109),
      num => Integer.remainderUnsigned(num, -238156041),
      num => Integer.remainderUnsigned(num, 104),
      num => Integer.remainderUnsigned(num, 137),
      num => Integer.remainderUnsigned(num, 416244772),
      num => Integer.remainderUnsigned(num, 257401848),
      num => Integer.remainderUnsigned(num, 5359),
      num => Integer.remainderUnsigned(num, 105),
      num => Integer.remainderUnsigned(num, 42),
      num => Integer.remainderUnsigned(num, 4557528),
      num => Integer.remainderUnsigned(num, 526297460),
      num => Integer.remainderUnsigned(num, 213583272),
      num => Integer.remainderUnsigned(num, 61815122),
      num => Integer.remainderUnsigned(num, 123421),
      num => Integer.remainderUnsigned(num, 165),
      num => Integer.remainderUnsigned(num, 23983337),
      num => Integer.remainderUnsigned(num, 1857108),
      num => Integer.remainderUnsigned(num, 120623),
      num => Integer.remainderUnsigned(num, 4464),
      num => Integer.remainderUnsigned(num, 19802),
      num => Integer.remainderUnsigned(num, 78824),
      num => Integer.remainderUnsigned(num, 572707184),
      num => Integer.remainderUnsigned(num, 7),
      num => Integer.remainderUnsigned(num, 12),
      num => Integer.remainderUnsigned(num, 841079139),
      num => Integer.remainderUnsigned(num, 10618),
      num => Integer.remainderUnsigned(num, 443093),
      num => Integer.remainderUnsigned(num, 722082088),
      num => Integer.remainderUnsigned(num, 12),
      num => Integer.remainderUnsigned(num, 1458),
      num => Integer.remainderUnsigned(num, 1447),
      num => Integer.remainderUnsigned(num, 75),
      num => Integer.remainderUnsigned(num, 1421446),
      num => Integer.remainderUnsigned(num, 64443),
      num => Integer.remainderUnsigned(num, 16425590),
      num => Integer.remainderUnsigned(num, 116143205),
      num => Integer.remainderUnsigned(num, 698139),
      num => Integer.remainderUnsigned(num, 851),
      num => Integer.remainderUnsigned(num, 11079),
      num => Integer.remainderUnsigned(num, 27),
      num => Integer.remainderUnsigned(num, 12305930),
      num => Integer.remainderUnsigned(num, 23),
      num => Integer.remainderUnsigned(num, 2461059),
      num => Integer.remainderUnsigned(num, 751),
      num => Integer.remainderUnsigned(num, 149251),
      num => Integer.remainderUnsigned(num, 58618),
      num => Integer.remainderUnsigned(num, 121005),
      num => Integer.remainderUnsigned(num, 196760),
      num => Integer.remainderUnsigned(num, 1161),
      num => Integer.remainderUnsigned(num, 54485051),
      num => Integer.remainderUnsigned(num, 2447),
      num => Integer.remainderUnsigned(num, 40314),
      num => Integer.remainderUnsigned(num, 6992),
      num => Integer.remainderUnsigned(num, 426),
      num => Integer.remainderUnsigned(num, 44333),
      num => Integer.remainderUnsigned(num, 2016106288),
      num => Integer.remainderUnsigned(num, 10),
      num => Integer.remainderUnsigned(num, 3985867),
      num => Integer.remainderUnsigned(num, 38),
  )

  val randomSignedConstantDivsPow2 = Array[IntToIntFun](
      num => num / 1073741824,
      num => num / 1048576,
      num => num / -1048576,
      num => num / 32768,
      num => num / 1073741824,
      num => num / -4,
      num => num / 64,
      num => num / 33554432,
      num => num / -131072,
      num => num / -1024,
      num => num / -1024,
      num => num / -256,
      num => num / 65536,
      num => num / -262144,
      num => num / -131072,
      num => num / -262144,
      num => num / 65536,
      num => num / -4096,
      num => num / 2097152,
      num => num / 2,
      num => num / 134217728,
      num => num / -4096,
      num => num / -1024,
      num => num / 8388608,
      num => num / -16384,
      num => num / 8192,
      num => num / 4194304,
      num => num / 2048,
      num => num / 8192,
      num => num / -4194304,
      num => num / -16,
      num => num / -4,
      num => num / -131072,
      num => num / -33554432,
      num => num / -256,
      num => num / -8,
      num => num / 128,
      num => num / 65536,
      num => num / -134217728,
      num => num / 64,
      num => num / -536870912,
      num => num / 1073741824,
      num => num / -67108864,
      num => num / -128,
      num => num / 16,
      num => num / 8388608,
      num => num / -1073741824,
      num => num / -8388608,
      num => num / -268435456,
      num => num / 512,
      num => num / -8192,
      num => num / -2,
      num => num / -1048576,
      num => num / -524288,
      num => num / 1024,
      num => num / 1024,
      num => num / 256,
      num => num / 268435456,
      num => num / 1073741824,
      num => num / -64,
      num => num / 536870912,
      num => num / -2,
      num => num / 67108864,
      num => num / 4096,
      num => num / 16384,
      num => num / 16777216,
      num => num / 524288,
      num => num / 16,
      num => num / -524288,
      num => num / -2147483648,
      num => num / 16384,
      num => num / 1073741824,
      num => num / -1024,
      num => num / -2147483648,
      num => num / 4096,
      num => num / -67108864,
      num => num / 32,
      num => num / 8,
      num => num / 268435456,
      num => num / -256,
      num => num / -2147483648,
      num => num / -8,
      num => num / 16384,
      num => num / -2147483648,
      num => num / 67108864,
      num => num / 131072,
      num => num / 4194304,
      num => num / 512,
      num => num / -65536,
      num => num / -512,
      num => num / 524288,
      num => num / -1024,
      num => num / 4,
      num => num / 2048,
      num => num / 2,
      num => num / 512,
      num => num / 8,
      num => num / 134217728,
      num => num / -2048,
      num => num / -256,
  )

}

import IntMicroDataSets._

/**
 * Int micro-benchmarks.
 */
abstract class IntMicro extends org.scalajs.benchmark.Benchmark {
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

/**
 * Int micro-benchmarks for divisions by constants.
 */
abstract class IntConstantDivRemMicro extends org.scalajs.benchmark.Benchmark {
  @inline def doRun(randomAs: Array[IntToIntFun], randomBs: Array[Int]): Int = {
    val alen = randomAs.length
    val blen = randomBs.length
    var result = 0
    var i = 0
    while (i != alen) {
      var j = 0
      while (j != blen) {
        val a = randomAs(i)
        val b = randomBs(j)
        result ^= a(b)
        j += 1
      }
      i += 1
    }
    result
  }

  @inline def doRunAndCheck(randomAs: Array[IntToIntFun], randomBs: Array[Int], expectedResult: Int): Unit = {
    val actual = doRun(randomAs, randomBs)
    if (actual != expectedResult)
      throw new Exception(s"expected $expectedResult but got $actual")
  }
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

object IntConstantDivAddBaseline extends IntConstantDivRemMicro {
  override def prefix = "IntConstantDivAddBaseline"

  @noinline def run(): Unit =
    doRunAndCheck(randomConstantAdds, random32s, -141292512)
}

object IntSignedConstantDiv extends IntConstantDivRemMicro {
  override def prefix = "IntSignedConstantDiv"

  @noinline def run(): Unit =
    doRunAndCheck(randomSignedConstantDivs, random32s, -276795792)
}

object IntSignedConstantRem extends IntConstantDivRemMicro {
  override def prefix = "IntSignedConstantRem"

  @noinline def run(): Unit =
    doRunAndCheck(randomSignedConstantRems, random32s, -633973644)
}

object IntUnsignedConstantDiv extends IntConstantDivRemMicro {
  override def prefix = "IntUnsignedConstantDiv"

  @noinline def run(): Unit =
    doRunAndCheck(randomUnsignedConstantDivs, random32s, 759722563)
}

object IntUnsignedConstantRem extends IntConstantDivRemMicro {
  override def prefix = "IntUnsignedConstantRem"

  @noinline def run(): Unit =
    doRunAndCheck(randomUnsignedConstantRems, random32s, -2023942284)
}

object IntSignedConstantDivPow2 extends IntConstantDivRemMicro {
  override def prefix = "IntSignedConstantDivPow2"

  @noinline def run(): Unit =
    doRunAndCheck(randomSignedConstantDivsPow2, random32s, -50939402)
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
