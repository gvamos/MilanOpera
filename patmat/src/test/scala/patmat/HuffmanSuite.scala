package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }
  
  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    val expected = List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4))
    val result = combine(leaflist)
    assert(result === expected)
  }
  
  test("combine of some leaf list using until") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    val combined = until(singleton,combine)(leaflist)
    assert(combined.length === 1)
  }
  
  test("times test"){
    new TestTrees {
      val chars = string2Chars("hello, world")
      val analysis = times(chars)
      val expected = List(('h',1), ('e',1), ('l',3), ('o',2), (',',1),(' ',1), ('w',1), ('r',1), ('d',1))
      assert(analysis === expected)
    }    
  }
  
//  test("until method on things") {
//    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
//    val isEmpty: List[CodeTree] => Boolean = _.isEmpty
//    def remover(before: List[CodeTree]) :List[CodeTree] = {
//      println("before=" + before)
//      before match {
//      case Nil => Nil
//      case x :: xs => xs
//    }
//  }
//    println("dbg 1")
//    val allGone = until(isEmpty, remover) (leaflist)
//    println("dbg 1")
//    
//    assert(allGone.length == 0)
//    println("dbg 1")
//  }

  
   test("Code Tree Generation") {
          
    new TestTrees {
      //val message = string2Chars("hello, world")
      val message = string2Chars("aabbbbccccccccc")
      val target = Fork(Fork(Leaf('a',2),Leaf('b',4),List('a', 'b'),6),Leaf('c',9),List('a', 'b', 'c'),15)
      val ct = createCodeTree(message)
      println(target) 
      println(ct)
      assert(ct === target)
    }
  }
   

  test("Minimal decode test: Find letter 's' in french table") {
    new TestTrees {
      val bits: List[Bit] = List(0,0,0)                
      val (remainder,cleartext) = decode_character( frenchCode, bits, Nil)
      println("cleartext="+cleartext)
      assert(remainder.length === 0)
      assert('s' === cleartext(0))
    }
  }
  
  test("Minimal decode test 1 bit remains: Find letter 's' in french table") {
    new TestTrees {
      val bits: List[Bit] = List(0,0,0,0)                
      val (remainder,cleartext) = decode_character( frenchCode, bits, Nil)
      println("cleartext="+cleartext)
      assert('s' === cleartext(0))
      assert(remainder.length === 1) // Make sure a bit is left
    }
  }
  
    test("three chunks of french text") {
    new TestTrees {
      println("****")
      val bits: List[Bit] = secret              
      val (remainder0,cleartext0) = decode_character( frenchCode, bits, Nil)
      println("cleartext0="+cleartext0)
      println("remainder0="+remainder0)
      val (remainder1,cleartext1) = decode_character( frenchCode,remainder0,  cleartext0)
      println("cleartext1="+cleartext1)
      println("remainder1="+remainder1)
      val (remainder2,cleartext2) = decode_character( frenchCode, remainder1, cleartext1)
      println("cleartext2="+cleartext2)
      println("remainder2="+remainder2)

      assert(cleartext2 == List('f','u','h'))
    }
  }
    
  test("Abbreviated French clear text message") {
    new TestTrees {
      println("****")
      val bits: List[Bit] = (List(0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1))//secret 
      val result = decode(frenchCode, bits)
      assert(result === List('f','u','h'))
    }
  }
  
    test("French clear text message") {
    new TestTrees {
      println("****")
      val bits: List[Bit] = secret 
      val result = decode(frenchCode, bits)
      println(result)
      assert(result === List('f','u','h'))
    }
  }
   
   
  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
}
