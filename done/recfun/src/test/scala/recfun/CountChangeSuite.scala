package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CountChangeSuite extends FunSuite {
  import Main.countChange
  
  test("countChange: -1 penny") {
    assert(countChange(-1, List(1)) === 0)
  }

  test("countChange: 1 penny") {
    assert(countChange(1, List(1)) === 1)
  }

  test("countChange: 10 penny") {
    assert(countChange(10, List(1)) === 1)
  }

  test("countChange: 5 + 1 for 6 cents") {
    assert(countChange(6, List(5, 1)) === 2)
  }

  test("countChange: 1 + 5 for 6 cents") {
    assert(countChange(6, List(1, 5)) === 2)
  }

  test("countChange: 1 + 5 for 10 cents") {
    assert(countChange(10, List(1, 5)) === 3)
  }

  test("countChange: example given in instructions") {
    assert(countChange(4, List(1, 2)) === 3)
  }

  test("countChange: sorted CHF") {
    assert(countChange(300, List(5, 10, 20, 50, 100, 200, 500)) === 1022)
  }

  test("countChange: no pennies") {
    assert(countChange(301, List(5, 10, 20, 50, 100, 200, 500)) === 0)
  }

  test("countChange: unsorted CHF") {
    assert(countChange(300, List(500, 5, 50, 100, 20, 200, 10)) === 1022)
  }

}
