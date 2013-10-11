package patmat
import common._
import patmat._
import patmat.Huffman._



object Huff {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(131); 
  println("Welcome to the Scala worksheet");$skip(57); 
  
  
  implicit def double2int(d:Double): Int = d.toInt;System.out.println("""double2int: (d: Double)Int""");$skip(22); 
  
  val i: Int = 2.2;System.out.println("""i  : Int = """ + $show(i ));$skip(295); 
  
  
//  abstract class CodeTree
//  case class Fork(left: CodeTree, right: CodeTree, chars: List[Char], weight: Int) extends CodeTree
//  case class Leaf(char: Char, weight: Int) extends CodeTree
//  implicit def pairToLeaf(char: Char, weight: Int): Leaf = new Leaf('a',3)

  val t0 = ('a',2);System.out.println("""t0  : (Char, Int) = """ + $show(t0 ));$skip(90); 
  
  implicit def tupleToLeaf(t: (Char, Int)): Leaf = t match { case (c,n) => Leaf(c,n) };System.out.println("""tupleToLeaf: (t: (Char, Int))patmat.Huffman.Leaf""");$skip(80); 
  implicit def leafToTuple(l: Leaf): Leaf = l match { case Leaf(c,n) => (c,n) };System.out.println("""leafToTuple: (l: patmat.Huffman.Leaf)patmat.Huffman.Leaf""");$skip(26); 
  
  val l0 = Leaf('a',2);System.out.println("""l0  : patmat.Huffman.Leaf = """ + $show(l0 ));$skip(20); 
  val l1: Leaf = t0;System.out.println("""l1  : patmat.Huffman.Leaf = """ + $show(l1 ));$skip(39); 
  
  val data = string2Chars("abbccc");System.out.println("""data  : List[Char] = """ + $show(data ));$skip(19); 
  val acc = List();System.out.println("""acc  : List[Nothing] = """ + $show(acc ));$skip(37); 

  
  val tbl3 = Huffman.times(data);System.out.println("""tbl3  : List[(Char, Int)] = """ + $show(tbl3 ));$skip(67); 
  
  val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4));System.out.println("""leaflist  : List[patmat.Huffman.Leaf] = """ + $show(leaflist ));$skip(30); 
  val foo = combine(leaflist);System.out.println("""foo  : List[patmat.Huffman.CodeTree] = """ + $show(foo ));$skip(53); 

  val combined = until(singleton,combine)(leaflist);System.out.println("""combined  : List[patmat.Huffman.CodeTree] = """ + $show(combined ));$skip(21); val res$0 = 
  
  combined.length;System.out.println("""res0: Int = """ + $show(res$0));$skip(99); 
  
  
  val sampleTree = makeCodeTree(
  makeCodeTree(Leaf('x', 1), Leaf('e', 1)),
  Leaf('t', 2));System.out.println("""sampleTree  : patmat.Huffman.Fork = """ + $show(sampleTree ));$skip(48); 
  
  
 val chars = string2Chars("hello, world");System.out.println("""chars  : List[Char] = """ + $show(chars ));$skip(29); 
 val analysis = times(chars);System.out.println("""analysis  : List[(Char, Int)] = """ + $show(analysis ));$skip(35); val res$1 = 
 makeOrderedLeafList(times(chars));System.out.println("""res1: List[patmat.Huffman.Leaf] = """ + $show(res$1));$skip(35); 
 val bits: List[Bit] = List(0,0,0);System.out.println("""bits  : List[patmat.Huffman.Bit] = """ + $show(bits ));$skip(41); 
 
 
 val dc1 = decode(frenchCode,secret);System.out.println("""dc1  : List[Char] = """ + $show(dc1 ));$skip(35); 
 
 val cdtbl = convert(frenchCode);System.out.println("""cdtbl  : patmat.Huffman.CodeTable = """ + $show(cdtbl ));$skip(31); 
 
 val result =  decodedSecret;System.out.println("""result  : List[Char] = """ + $show(result ));$skip(71); 
 
 def frenchEncoder(text: List[Char]) = quickEncode(frenchCode)(text);System.out.println("""frenchEncoder: (text: List[Char])List[patmat.Huffman.Bit]""")}
  
}
