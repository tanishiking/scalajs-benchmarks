/*                     __                                               *\
**     ________ ___   / /  ___      __ ____  Scala.js Benchmarks        **
**    / __/ __// _ | / /  / _ | __ / // __/  (c) 2013,                  **
**  __\ \/ /__/ __ |/ /__/ __ |/_// /_\ \            Sébastien Doeraene **
** /____/\___/_/ |_/____/_/ | |__/ /____/    Public domain              **
**                          |/____/                                     **
\*                                                                      */

package org.scalajs.benchmark.dom

import scala.scalajs.js
import scala.scalajs.js.annotation._

@js.native
@JSGlobalScope
object DOM extends js.Any {
  val document: DOMDocument = js.native
}

@js.native
trait DOMDocument extends js.Object {
  var title: String = js.native

  def body: DOMElement = js.native
  def getElementById(id: String): DOMElement = js.native
  def createElement(tag: String): DOMElement = js.native
}

@js.native
trait DOMElement extends js.Object {
  var textContent: String = js.native
  var innerHTML: String = js.native

  def appendChild(child: DOMElement): Unit = js.native
  var onclick: js.Function0[_] = js.native
}

@js.native
trait HTMLInputElement extends js.Object {
  var value: String = js.native
}

@js.native
trait HTMLCheckboxElement extends js.Object {
  var checked: Boolean = js.native
}

@js.native
trait HTMLButtonElement extends DOMElement {
  var enabled: Boolean = js.native
}

@js.native
trait HTMLCanvasElement extends DOMElement {
  def getContext(kind: String): js.Any = js.native // depends on the kind
  var width: Double = js.native
  var height: Double = js.native
}

@js.native
trait CanvasRenderingContext2D extends js.Object {
  val canvas: HTMLCanvasElement = js.native

  var fillStyle: String = js.native
  var lineWidth: Double = js.native

  def fillRect(x: Double, y: Double, w: Double, h: Double): Unit = js.native
  def strokeRect(x: Double, y: Double, w: Double, h: Double): Unit = js.native

  def beginPath(): Unit = js.native
  def fill(): Unit = js.native
  def stroke(): Unit = js.native

  def arc(x: Double, y: Double, radius: Double,
      startAngle: Double, endAngle: Double, anticlockwise: Boolean): Unit = js.native
}
