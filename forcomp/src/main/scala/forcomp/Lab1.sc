package forcomp

import common._
import forcomp._
import forcomp.Anagrams._


object Lab1 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  def wordOccurrences(w: Word): Occurrences = {
    val seqs = w.toLowerCase.sorted.groupBy(identity)
    for (key <- (seqs.keys).toList.sorted
    ) yield ((seqs(key).head, seqs(key).length))
  }                                               //> wordOccurrences: (w: forcomp.Anagrams.Word)forcomp.Anagrams.Occurrences
  
  val word ="Cbab"                                //> word  : String = Cbab
  
  val s = List("foo","bar","baz")                 //> s  : List[String] = List(foo, bar, baz)
  s.mkString                                      //> res0: String = foobarbaz
  
  val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
                                                  //> lard  : List[(Char, Int)] = List((a,1), (d,1), (l,1), (r,1))
  val r = List(('r', 1))                          //> r  : List[(Char, Int)] = List((r,1))
  
  def subtract(xList: Occurrences, yList: Occurrences): Occurrences = {
    val x = xList.toMap
    val y = yList.toMap
    for (xKey <- x.keys.toList.sorted; delta = x(xKey) - y.getOrElse(xKey,0) if delta > 0) yield((xKey,delta))
  }                                               //> subtract: (xList: forcomp.Anagrams.Occurrences, yList: forcomp.Anagrams.Occu
                                                  //| rrences)forcomp.Anagrams.Occurrences
  def supports(xList: Occurrences, yList: Occurrences): Boolean = {
    val x = xList.toMap
    val y = yList.toMap
    !y.keys.exists(ch => x.getOrElse(ch,0) < y.getOrElse(ch,0))
  }                                               //> supports: (xList: forcomp.Anagrams.Occurrences, yList: forcomp.Anagrams.Occu
                                                  //| rrences)Boolean
  
  val lad = List(('a', 1), ('d', 1), ('l', 1))    //> lad  : List[(Char, Int)] = List((a,1), (d,1), (l,1))
  val ld = List(('d', 1), ('l', 1))               //> ld  : List[(Char, Int)] = List((d,1), (l,1))
  subtract(lard, r)                               //> res1: forcomp.Anagrams.Occurrences = List((a,1), (d,1), (l,1))
  subtract(lard,ld)                               //> res2: forcomp.Anagrams.Occurrences = List((a,1), (r,1))
  subtract(r,lad)                                 //> res3: forcomp.Anagrams.Occurrences = List((r,1))
  supports(lard,r)                                //> res4: Boolean = true
  
  def candidates(spectrum: Occurrences): List[Occurrences] =  {
    val candidates = dictionaryByOccurrences.keys.filter(dictKey => supports(spectrum,dictKey))
    (for(candidate <- candidates) yield(candidate)).toList
  }                                               //> candidates: (spectrum: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.O
                                                  //| ccurrences]
  def candidateWords(s: Sentence): List[Occurrences] = candidates(sentenceOccurrences(s))
                                                  //> candidateWords: (s: forcomp.Anagrams.Sentence)List[forcomp.Anagrams.Occurre
                                                  //| nces]

  def wordOptions(s: Sentence): List[String] =
    candidateWords(s).flatMap(candidate => dictionaryByOccurrences(candidate))
                                                  //> wordOptions: (s: forcomp.Anagrams.Sentence)List[String]
    
  
  val sent = List("Linux", "rulez")               //> sent  : List[String] = List(Linux, rulez)
  val spectrum = sentenceOccurrences(sent)        //> spectrum  : forcomp.Anagrams.Occurrences = List((e,1), (i,1), (l,2), (n,1),
                                                  //|  (r,1), (u,2), (x,1), (z,1))
  //val z = candidates(sent)
  
  //
  // Add diagnostic map linking committed word+spectrum, remaining spectrum, and remaining words.
  //
  
  def foo(build: Sentence, tbd: List[Word]) = {
    val spectrum = sentenceOccurrences(tbd)
    for(word <- tbd){
      //println(l)                                    //
      val occur = wordOccurrences(word)
      val remainder: Occurrences  = subtract(spectrum,occur)
      println("")
      println(spectrum)
      println(occur)
      println(remainder)
      //println(word + "[" + occur + "]" + remainder)
      //println(word+remainder)
      val nextRound: List[Occurrences] = candidates(remainder)
      val nextRoundWords = nextRound.map(w => dictionaryByOccurrences.get(w)).flatten.flatten
      //println(word+"::"+nextRound.length)
      //for (nextOption <- nextRound){
      //  println(word + "::" + nextOption.toString())
      //}
    }
    Nil
  }                                               //> foo: (build: forcomp.Anagrams.Sentence, tbd: List[forcomp.Anagrams.Word])sc
                                                  //| ala.collection.immutable.Nil.type
  wordOptions(sent).size                          //> res5: Int = 38
  foo(Nil,wordOptions(sent))                      //> 
                                                  //| List((e,22), (i,22), (l,25), (n,21), (r,15), (u,17), (x,4), (z,5))
                                                  //| List((e,1), (l,1), (r,1), (u,1))
                                                  //| List((e,21), (i,22), (l,24), (n,21), (r,14), (u,16), (x,4), (z,5))
                                                  //| 
                                                  //| List((e,22), (i,22), (l,25), (n,21), (r,15), (u,17), (x,4), (z,5))
                                                  //| List((e,1), (l,1), (r,1), (u,1))
                                                  //| List((e,21), (i,22), (l,24), (n,21), (r,14), (u,16), (x,4), (z,5))
                                                  //| 
                                                  //| List((e,22), (i,22), (l,25), (n,21), (r,15), (u,17), (x,4), (z,5))
                                                  //| List((e,1), (i,1), (n,1), (r,1), (u,1))
                                                  //| List((e,21), (i,21), (l,25), (n,20), (r,14), (u,16), (x,4), (z,5))
                                                  //| 
                                                  //| List((e,22), (i,22), (l,25), (n,21), (r,15), (u,17), (x,4), (z,5))
                                                  //| List((l,2), (n,1), (u,1))
                                                  //| List((e,22), (i,22), (l,23), (n,20), (r,15), (u,16), (x,4), (z,5))
                                                  //| 
                                                  //| List((e,22), (i,22), (l,25), (n,21), (r,15), (u,17), (x,4), (z,5))
                                                  //| List((e,1), (r,1), (x,1))
                                                  //| List((e,21), (i,22), (l,25), (n,21), (r,14), (u,17), (x,3), (z,5))
                                                  //| 
                                                  //| List((e,22), (i,22), (l,25), (n,21), (r,15), (u,17), (x,
                                                  //| Output exceeds cutoff limit./
  
  
//  for(word <- wordOptions(sent)){
//    //println(l)                                    //
//    val occur = wordOccurrences(word)
//    val remainder : Occurrences = subtract(spectrum,occur)
//    val nextRound = candidates(remainder)
//    println(word + "::")
//    for (nextOption <- nextRound){
//      println("..." + nextOption.toString())
//    }
//  }
  

  
}