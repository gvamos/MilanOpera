package forcomp

import common._
import forcomp._
import forcomp.Anagrams._


object Lab1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(135); 
  println("Welcome to the Scala worksheet");$skip(203); 
  
  
  def wordOccurrences(w: Word): Occurrences = {
    val seqs = w.toLowerCase.sorted.groupBy(identity)
    for (key <- (seqs.keys).toList.sorted
    ) yield ((seqs(key).head, seqs(key).length))
  };System.out.println("""wordOccurrences: (w: forcomp.Anagrams.Word)forcomp.Anagrams.Occurrences""");$skip(22); 
  
  val word ="Cbab";System.out.println("""word  : String = """ + $show(word ));$skip(37); 
  
  val s = List("foo","bar","baz");System.out.println("""s  : List[String] = """ + $show(s ));$skip(13); val res$0 = 
  s.mkString;System.out.println("""res0: String = """ + $show(res$0));$skip(61); 
  
  val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 1));System.out.println("""lard  : List[(Char, Int)] = """ + $show(lard ));$skip(25); 
  val r = List(('r', 1));System.out.println("""r  : List[(Char, Int)] = """ + $show(r ));$skip(238); 
  
  def subtract(xList: Occurrences, yList: Occurrences): Occurrences = {
    val x = xList.toMap
    val y = yList.toMap
    for (xKey <- x.keys.toList.sorted; delta = x(xKey) - y.getOrElse(xKey,0) if delta > 0) yield((xKey,delta))
  };System.out.println("""subtract: (xList: forcomp.Anagrams.Occurrences, yList: forcomp.Anagrams.Occurrences)forcomp.Anagrams.Occurrences""");$skip(184); 
  def supports(xList: Occurrences, yList: Occurrences): Boolean = {
    val x = xList.toMap
    val y = yList.toMap
    !y.keys.exists(ch => x.getOrElse(ch,0) < y.getOrElse(ch,0))
  };System.out.println("""supports: (xList: forcomp.Anagrams.Occurrences, yList: forcomp.Anagrams.Occurrences)Boolean""");$skip(50); 
  
  val lad = List(('a', 1), ('d', 1), ('l', 1));System.out.println("""lad  : List[(Char, Int)] = """ + $show(lad ));$skip(36); 
  val ld = List(('d', 1), ('l', 1));System.out.println("""ld  : List[(Char, Int)] = """ + $show(ld ));$skip(20); val res$1 = 
  subtract(lard, r);System.out.println("""res1: forcomp.Anagrams.Occurrences = """ + $show(res$1));$skip(20); val res$2 = 
  subtract(lard,ld);System.out.println("""res2: forcomp.Anagrams.Occurrences = """ + $show(res$2));$skip(18); val res$3 = 
  subtract(r,lad);System.out.println("""res3: forcomp.Anagrams.Occurrences = """ + $show(res$3));$skip(19); val res$4 = 
  supports(lard,r);System.out.println("""res4: Boolean = """ + $show(res$4));$skip(226); 
  
  def candidates(spectrum: Occurrences): List[Occurrences] =  {
    val candidates = dictionaryByOccurrences.keys.filter(dictKey => supports(spectrum,dictKey))
    (for(candidate <- candidates) yield(candidate)).toList
  };System.out.println("""candidates: (spectrum: forcomp.Anagrams.Occurrences)List[forcomp.Anagrams.Occurrences]""");$skip(90); 
  def candidateWords(s: Sentence): List[Occurrences] = candidates(sentenceOccurrences(s));System.out.println("""candidateWords: (s: forcomp.Anagrams.Sentence)List[forcomp.Anagrams.Occurrences]""");$skip(127); 

  def wordOptions(s: Sentence): List[String] =
    candidateWords(s).flatMap(candidate => dictionaryByOccurrences(candidate));System.out.println("""wordOptions: (s: forcomp.Anagrams.Sentence)List[String]""");$skip(44); 
    
  
  val sent = List("Linux", "rulez");System.out.println("""sent  : List[String] = """ + $show(sent ));$skip(43); 
  val spectrum = sentenceOccurrences(sent);System.out.println("""spectrum  : forcomp.Anagrams.Occurrences = """ + $show(spectrum ));$skip(912); 
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
  };System.out.println("""foo: (build: forcomp.Anagrams.Sentence, tbd: List[forcomp.Anagrams.Word])scala.collection.immutable.Nil.type""");$skip(25); val res$5 = 
  wordOptions(sent).size;System.out.println("""res5: Int = """ + $show(res$5));$skip(29); val res$6 = 
  foo(Nil,wordOptions(sent));System.out.println("""res6: scala.collection.immutable.Nil.type = """ + $show(res$6))}
  
  
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
