package su.svn.scala

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CubeCalculatorTest extends FunSuite {
  test("CubeCalculator.cube") {
    Thread.sleep(500)
    assert(CubeCalculator.cube(3) === 27)
  }
}
