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

import org.scalajs.benchmark.dom._

// 'event' null means scalar we are benchmarking
class RenderScene extends Scene {

  val camera = new Camera(
    new Vector(0.0f, 0.0f, -15.0f),
    new Vector(-0.2f, 0.0f, 5.0f),
    new Vector(0.0f, 1.0f, 0.0f)
  )

  val background = new Background(new Color(0.5f, 0.5f, 0.5f), 0.4f)

  val plane = new Plane(
    new Vector(0.1f, 0.9f, -0.5f).normalize,
    1.2f,
    new Chessboard(
      new Color(1.0f, 1.0f, 1.0f),
      new Color(0.0f, 0.0f, 0.0f),
      0.2f,
      0.0f,
      1.0f,
      0.7f
    )
  )

  val sphere = new Sphere(
    new Vector(-1.5f, 1.5f, 2.0f),
    1.5f,
    new Solid(
      new Color(0.0f, 0.5f, 0.5f),
      0.3f,
      0.0f,
      0.0f,
      2.0f
    )
  )

  val sphere1 = new Sphere(
    new Vector(1.0f, 0.25f, 1.0f),
    0.5f,
    new Solid(
      new Color(0.9f, 0.9f, 0.9f),
      0.1f,
      0.0f,
      0.0f,
      1.5f
    )
  )

  val shapes = List(plane, sphere, sphere1)

  var light = new Light(
    new Vector(5.0f, 10.0f, -1.0f),
    new Color(0.8f, 0.8f, 0.8f)
  )

  var light1 = new Light(
    new Vector(-3.0f, 5.0f, -15.0f),
    new Color(0.8f, 0.8f, 0.8f),
    100.0f
  )

  val lights = List(light, light1)

  def renderScene(config: EngineConfiguration, canvas: CanvasRenderingContext2D): Unit = {
    new Engine(config).renderScene(this, canvas)
  }
}
