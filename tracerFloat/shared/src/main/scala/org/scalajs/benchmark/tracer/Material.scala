/*                     __                                               *\
**     ________ ___   / /  ___      __ ____  Scala.js Benchmarks        **
**    / __/ __// _ | / /  / _ | __ / // __/  Adam Burmister             **
**  __\ \/ /__/ __ |/ /__/ __ |/_// /_\ \    2012, Google, Inc          **
** /____/\___/_/ |_/____/_/ | |__/ /____/    2013, Jonas Fonseca        **
**                          |/____/                                     **
\*                                                                      */

// The ray tracer code in this file is written by Adam Burmister. It
// is available in its original form from:
//
//   http://labs.flog.co.nz/raytracer/
//
// Ported from the v8 benchmark suite by Google 2012.
// Ported from the Dart benchmark_harness to Scala.js by Jonas Fonseca 2013

package org.scalajs.benchmark.tracer

// gloss:        [0...infinity] 0 = matt
// transparency:  0=opaque
// reflection:   [0...infinity] 0 = no reflection
abstract class Material(val reflection: Float, val transparency: Float, val gloss: Float) {
  // var refraction = 0.50;
  def hasTexture = false
  def getColor(u: Float, v: Float): Color
}

class Chessboard(colorEven: Color, colorOdd: Color,
                 reflection: Float, transparency: Float, gloss: Float,
                 density: Float)
    extends Material(reflection, transparency, gloss) {

  override def hasTexture = true

  def getColor(u: Float, v: Float): Color = {
    val t = wrapUp(u * density) * wrapUp(v * density)

    if (t < 0.0f) {
      colorEven
    } else {
      colorOdd
    }
  }

  def wrapUp(value: Float): Float = {
    var t = value % 2.0f

    if (t < -1.0f)
      t = t + 2.0f

    if (t >= 1.0f)
      t - 2.0f
    else
      t
  }
}

class Solid(color: Color, reflection: Float, refraction: Float, transparency: Float, gloss: Float)
  extends Material(reflection, transparency, gloss) {

  //def refraction = refraction

  def getColor(u: Float, v: Float): Color =
    color
}
