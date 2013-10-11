 import FunSets._

object FunSets {
  /**
   * We represent a set by its characteristic function, i.e.
   * its `contains` predicate.
   */
  type Set = Int => Boolean;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(292); 
  


  /**
   * Indicates whether a set contains a given element.
   */
  def contains(s: Set, elem: Int): Boolean = s(elem);System.out.println("""contains: (s: Int => Boolean, elem: Int)Boolean""");$skip(150); 

  /**
   * Returns the set of the one given element.
   */
  //def singletonSet(elem: Int): Set = ???
  def singletonSet(elem: Int): Set = Set(elem);System.out.println("""singletonSet: (elem: Int)Int => Boolean""");$skip(214); 

  /**
   * Returns the union of the two given sets,
   * the sets of all elements that are in either `s` or `t`.
   */
  //def union(s: Set, t: Set): Set = ???
  def union(s: Set, t: Set): Set = x => s(x) || t(x);System.out.println("""union: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(182); 

  /**
   * Returns the intersection of the two given sets,
   * the set of all elements that are both in `s` and `t`.
   */
  def intersect(s: Set, t: Set): Set = x => s(x) && t(x);System.out.println("""intersect: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(174); 

  /**
   * Returns the difference of the two given sets,
   * the set of all elements of `s` that are not in `t`.
   */
  def diff(s: Set, t: Set): Set = x => s(x) && !t(x);System.out.println("""diff: (s: Int => Boolean, t: Int => Boolean)Int => Boolean""");$skip(128); 

  /**
   * Returns the subset of `s` for which `p` holds.
   */
  def filter(s: Set, p: Int => Boolean): Set = intersect(s, p);System.out.println("""filter: (s: Int => Boolean, p: Int => Boolean)Int => Boolean""");$skip(88); 

  /**
   * The bounds for `forall` and `exists` are +/- 1000.
   */
  val bound = 1000;System.out.println("""bound  : Int = """ + $show(bound ));$skip(380); 

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
  };System.out.println("""forall: (s: Int => Boolean, p: Int => Boolean)Boolean""");$skip(400); 

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
  };System.out.println("""exists: (s: Int => Boolean, p: Int => Boolean)Boolean""");$skip(296); 

  /**
   * Returns a set transformed by applying `f` to each element of `s`.
   */
  //def map(s: Set, f: Int => Int): Set = x => s(f(x))
  //def map(s: Set, f: Int => Int): Set = x => contains(s,f(x))
  //def map(s: Set, f: Int => Int): Set = x => exists(s,f(x))
 
    val s1 = singletonSet(1);System.out.println("""s1  : Int => Boolean = """ + $show(s1 ));$skip(29); 
    val s2 = singletonSet(2);System.out.println("""s2  : Int => Boolean = """ + $show(s2 ));$skip(29); 
    val s3 = singletonSet(3);System.out.println("""s3  : Int => Boolean = """ + $show(s3 ));$skip(26); 
    val s = union(s1, s2);System.out.println("""s  : Int => Boolean = """ + $show(s ));$skip(18); val res$0 = 
    contains(s,2);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(41); 
    
    def blork(x: Int): Int = x + 10;System.out.println("""blork: (x: Int)Int""");$skip(18); val res$1 = 
    
    blork(5);System.out.println("""res1: Int = """ + $show(res$1));$skip(97); 
    
  def map(s: Set, f: Int => Int): Set = {
    (x: Int) =>   exists(s, (a => f(a) == x))
  };System.out.println("""map: (s: Int => Boolean, f: Int => Int)Int => Boolean""");$skip(42); 
    
    
    val mapSet = map(s1, blork);System.out.println("""mapSet  : Int => Boolean = """ + $show(mapSet ));$skip(20); val res$2 = 
    
    mapSet(13);System.out.println("""res2: Boolean = """ + $show(res$2));$skip(106); 
    
    
    
  

 
  //toString(klorg)
  //toString(glerk)
  
  val s12 = exists(s1, (x: Int) => x > 0);System.out.println("""s12  : Boolean = """ + $show(s12 ))}
  
  
  
  
}
