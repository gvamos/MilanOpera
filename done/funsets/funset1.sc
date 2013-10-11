 import FunSets._

object FunSets {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = Int => Boolean
  


  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem)
                                                  //> contains: (s: Int => Boolean, elem: Int)Boolean

  /**
   * Returns the set of the one given element.
   */
  //def singletonSet(elem: Int): Set = ???
  def singletonSet(elem: Int): Set = Set(elem)    //> singletonSet: (elem: Int)Int => Boolean

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  //def union(s: Set, t: Set): Set = ???
  def union(s: Set, t: Set): Set = x => s(x) || t(x)
                                                  //> union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
  def intersect(s: Set, t: Set): Set = x => s(x) && t(x)
                                                  //> intersect: (s: Int => Boolean, t: Int => Boolean)Int => Boolean

  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: Set, t: Set): Set = x => s(x) && !t(x)
                                                  //> diff: (s: Int => Boolean, t: Int => Boolean)Int => Boolean

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: Set, p: Int => Boolean): Set = intersect(s, p)
                                                  //> filter: (s: Int => Boolean, p: Int => Boolean)Int => Boolean

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000                                //> bound  : Int = 1000

  /**
   * Returns whether all bounded integers within `s` satisfy `p`.
   */
  def forall(s: Set, p: Int => Boolean): Boolean = {
    val low = -bound
    val high = bound
    
    val f = filter(s,p)
    def notInSet(a:Int) = !f(a)
    
    def iter(a: Int): Boolean = {
      if (a > high) true
      else if (notInSet(a)) false
      else iter(a + 1)
    }
    iter(low)
  }                                               //> forall: (s: Int => Boolean, p: Int => Boolean)Boolean

  /**
   * Returns whether there exists a bounded integer within `s`
   * that satisfies `p`.
   */
  def exists(s: Set, p: Int => Boolean): Boolean = {
    
    val low = -bound
    val high = bound
    
    val f = filter(s,p)
    def inSet(a:Int) = f(a)
    
    def iter(a: Int): Boolean = {
      if (a > high) false
      else if (inSet(a)) true
      else iter(a + 1)
    }
    iter(low)
  }                                               //> exists: (s: Int => Boolean, p: Int => Boolean)Boolean

  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
  //def map(s: Set, f: Int => Int): Set = x => s(f(x))
  //def map(s: Set, f: Int => Int): Set = x => contains(s,f(x))
  //def map(s: Set, f: Int => Int): Set = x => exists(s,f(x))
 
    val s1 = singletonSet(1)                      //> s1  : Int => Boolean = Set(1)
    val s2 = singletonSet(2)                      //> s2  : Int => Boolean = Set(2)
    val s3 = singletonSet(3)                      //> s3  : Int => Boolean = Set(3)
    val s = union(s1, s2)                         //> s  : Int => Boolean = <function1>
    contains(s,2)                                 //> res0: Boolean = true
    
    def blork(x: Int): Int = x + 10               //> blork: (x: Int)Int
    
    blork(5)                                      //> res1: Int = 15
    
  def map(s: Set, f: Int => Int): Set = {
    (x: Int) =>   exists(s, (a => f(a) == x))
  }                                               //> map: (s: Int => Boolean, f: Int => Int)Int => Boolean
    
    
    val mapSet = map(s1, blork)                   //> mapSet  : Int => Boolean = <function1>
    
    mapSet(13)                                    //> res2: Boolean = false
    
    
    
  

 
  //toString(klorg)
  //toString(glerk)
  
  val s12 = exists(s1, (x: Int) => x > 0)         //> s12  : Boolean = true
  
  
  
  
}