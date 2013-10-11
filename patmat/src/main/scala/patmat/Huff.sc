package patmat
import common._
import patmat._
import patmat.Huffman._



object Huff {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  implicit def double2int(d:Double): Int = d.toInt//> double2int: (d: Double)Int
  
  val i: Int = 2.2                                //> i  : Int = 2
  
  
//  abstract class CodeTree
//  case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
//  case class Leaf(char: Char, weight: Int) extends CodeTree
//  implicit def pairToLeaf(char: Char, weight: Int): Leaf = new Leaf('a',3)

  val t0 = ('a',2)                                //> t0  : (Char, Int) = (a,2)
  
  implicit def tupleToLeaf(t: (Char, Int)): Leaf = t match { case (c,n) => Leaf(c,n) }
                                                  //> tupleToLeaf: (t: (Char, Int))patmat.Huffman.Leaf
  implicit def leafToTuple(l: Leaf): Leaf = l match { case Leaf(c,n) => (c,n) }
                                                  //> leafToTuple: (l: patmat.Huffman.Leaf)patmat.Huffman.Leaf
  
  val l0 = Leaf('a',2)                            //> l0  : patmat.Huffman.Leaf = Leaf(a,2)
  val l1: Leaf = t0                               //> l1  : patmat.Huffman.Leaf = Leaf(a,2)
  
  val data = string2Chars("abbccc")               //> data  : List[Char] = List(a, b, b, c, c, c)
  val acc = List()                                //> acc  : List[Nothing] = List()

  
  val tbl3 = Huffman.times(data)                  //> tbl3  : List[(Char, Int)] = List((a,1), (b,2), (c,3))
  
  val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
                                                  //> leaflist  : List[patmat.Huffman.Leaf] = List(Leaf(e,1), Leaf(t,2), Leaf(x,4)
                                                  //| )
  val foo = combine(leaflist)                     //> foo  : List[patmat.Huffman.CodeTree] = List(Fork(Leaf(e,1),Leaf(t,2),List(e,
                                                  //|  t),3), Leaf(x,4))

  val combined = until(singleton,combine)(leaflist)
                                                  //> combined  : List[patmat.Huffman.CodeTree] = List(Fork(Fork(Leaf(e,1),Leaf(t,
                                                  //| 2),List(e, t),3),Leaf(x,4),List(e, t, x),7))
  
  combined.length                                 //> res0: Int = 1
  
  
  val sampleTree = makeCodeTree(
  makeCodeTree(Leaf('x', 1), Leaf('e', 1)),
  Leaf('t', 2))                                   //> sampleTree  : patmat.Huffman.Fork = Fork(Fork(Leaf(x,1),Leaf(e,1),List(x, e
                                                  //| ),2),Leaf(t,2),List(x, e, t),4)
  
  
 val chars = string2Chars("hello, world")         //> chars  : List[Char] = List(h, e, l, l, o, ,,  , w, o, r, l, d)
 val analysis = times(chars)                      //> analysis  : List[(Char, Int)] = List((h,1), (e,1), (l,3), (o,2), (,,1), ( ,
                                                  //| 1), (w,1), (r,1), (d,1))
 makeOrderedLeafList(times(chars))                //> res1: List[patmat.Huffman.Leaf] = List(Leaf(d,1), Leaf(r,1), Leaf(w,1), Lea
                                                  //| f( ,1), Leaf(,,1), Leaf(e,1), Leaf(h,1), Leaf(o,2), Leaf(l,3))
 val bits: List[Bit] = List(0,0,0)                //> bits  : List[patmat.Huffman.Bit] = List(0, 0, 0)
 
 
 val dc1 = decode(frenchCode,secret)              //> dc1  : List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
 
 val cdtbl = convert(frenchCode)                  //> cdtbl  : patmat.Huffman.CodeTable = List((e,List(0, 1, 1)), (s,List(0, 0, 0
                                                  //| )), (a,List(1, 1, 1, 1)), (i,List(0, 1, 1, 1)), (t,List(1, 1, 0, 1)), (n,Li
                                                  //| st(0, 1, 0, 1)), (r,List(0, 0, 0, 1)), (u,List(1, 1, 1, 0)), (l,List(1, 0, 
                                                  //| 1, 0)), (o,List(0, 0, 1, 0)), (d,List(0, 1, 0, 0)), (c,List(0, 1, 0, 0, 1))
                                                  //| , (p,List(1, 0, 1, 1, 0)), (m,List(0, 0, 1, 1, 0)), (v,List(0, 1, 1, 0, 0, 
                                                  //| 1)), (q,List(1, 1, 1, 1, 0, 0)), (f,List(1, 0, 1, 1, 0, 0)), (b,List(1, 1, 
                                                  //| 1, 1, 0, 0, 1)), (g,List(0, 1, 1, 1, 0, 0, 1)), (h,List(1, 0, 1, 1, 1, 0, 0
                                                  //| )), (j,List(1, 0, 0, 1, 1, 0, 0)), (x,List(0, 0, 0, 1, 1, 0, 0)), (y,List(1
                                                  //| , 0, 0, 1, 1, 1, 0, 0)), (z,List(0, 0, 0, 0, 1, 1, 1, 0, 0)), (w,List(1, 1,
                                                  //|  0, 0, 0, 1, 1, 1, 0, 0)), (k,List(0, 1, 0, 0, 0, 1, 1, 1, 0, 0)))
 
 val result =  decodedSecret                      //> result  : List[Char] = List(h, u, f, f, m, a, n, e, s, t, c, o, o, l)
 
 def frenchEncoder(text: List[Char]) = quickEncode(frenchCode)(text)
                                                  //> frenchEncoder: (text: List[Char])List[patmat.Huffman.Bit]
  
}