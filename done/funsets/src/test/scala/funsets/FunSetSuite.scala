package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {

    def foo = ((x: Int) => x < 12)
    def bar = ((x: Int) => x > 7)
    def evens = ((x: Int) => x % 2 == 0)
    def odds = ((x: Int) => x % 2 == 1)
    def plusOne = (x: Int) => x + 1
    def plusTwo = (x: Int) => x + 2
    def positive = (x: Int) => x >= 0
    def negative = (x: Int) => x < 0 

    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = foo
    val s5 = bar
    val us1s2 = union(s1, s2);
    val us4s5 = union(s4, s5)
    val is4s5 = intersect(s4, s5)
    val ds4s5 = diff(s4, s5)
    val ds5s4 = diff(s5, s4)

  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  //ignore("singletonSet(1) contains 1") {
  test("singletonSet(1) contains 1") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }

  test("intersect contains the correct elements") {

    new TestSets {
      val s = intersect(s4, s5)

      assert(contains(s, 10), "Intersection 10")
      assert(contains(s, 11), "Intersection 11")
      assert(!contains(s, 7), "Intersection 7")
    }
  }

  test("diff contains the correct elements") {
    new TestSets {

      val s = diff(s4, s5)
      assert(contains(s, 3), "diff 3")
      assert(contains(s, 4), "diff 4")
      assert(!contains(s, 10), "diff 10")
    }
  }

  test("filter f by g") {

    new TestSets {
      val s = filter(bar, (x: Int) => x % 2 == 0)

      assert(contains(s, 10), "filter bar by even for 10")
      assert(!contains(s, 11), "filter bar by even for 11")
      assert(!contains(s, 9), "filter bar by even for 7, should be false, because 9 is odd ")
      assert(!contains(s, 4), "filter bar by even for 7, should be false, because 4 is < 7")
    }
  }

  test("Exists even number in bar") {

    new TestSets {
      val sx = exists(bar, (x: Int) => x % 2 == 0)
      
      assert(exists(bar, (x: Int) => x % 2 == 0), "even members of bar exist")
      assert(exists(bar, (x: Int) => x % 2 == 0), "even members of bar exist")

    }
  }

  test("ForAll s1, are they greater than zero?") {

    new TestSets {

      def fortyplus = ((x: Int) => x > 39)
      assert(forall(fortyplus, positive), "all numbers >- 40 are positive")
      assert(!forall(fortyplus, negative), "all numbers >- 40 are positive")
    }
  }

  test("map addOne over Set evens") {
    
    new TestSets {
      val s = map(evens, plusOne)

      assert(contains(s, 101), "if 100 is in base set, 101 is in mapped set")
      assert(!contains(s, 10), "10 is not an even number plus one!")
    }
  }

  test("Map square to singleton set of 3") {
    
    new TestSets {
      val s = map(s3, (x: Int) => x * x)
      
      assert(contains(s, 9), "nine is a square of 3")
      assert(!contains(s, 3), "three is not is a square of 3")
    }
  }
}
