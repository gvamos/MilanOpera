package objsets

import org.scalatest.FunSuite

object TW0 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
    val set1 = new Empty                          //> set1  : objsets.Empty = Empty
    val set2 = set1.incl(new Tweet("a", "a body", 20))
                                                  //> set2  : objsets.TweetSet = elem: User: a
                                                  //| Text: a body [20], left: Empty, right:Empty
    val set3 = set2.incl(new Tweet("b", "b body", 20))
                                                  //> set3  : objsets.TweetSet = elem: User: a
                                                  //| Text: a body [20], left: Empty, right:elem: User: b
                                                  //| Text: b body [20], left: Empty, right:Empty
    val c = new Tweet("c", "c body", 7)           //> c  : objsets.Tweet = User: c
                                                  //| Text: c body [7]
    val d = new Tweet("d", "d body", 9)           //> d  : objsets.Tweet = User: d
                                                  //| Text: d body [9]
    val set4 = set3.incl(c)                       //> set4  : objsets.TweetSet = elem: User: a
                                                  //| Text: a body [20], left: Empty, right:elem: User: b
                                                  //| Text: b body [20], left: Empty, right:elem: User: c
                                                  //| Text: c body [7], left: Empty, right:Empty
    val set5 = set4.incl(d)                       //> set5  : objsets.TweetSet = elem: User: a
                                                  //| Text: a body [20], left: Empty, right:elem: User: b
                                                  //| Text: b body [20], left: Empty, right:elem: User: c
                                                  //| Text: c body [7], left: Empty, right:elem: User: d
                                                  //| Text: d body [9], left: Empty, right:Empty
    //
    
    val first: Tweet = set5.mostRetweeted         //> java.util.NoSuchElementException
                                                  //| 	at objsets.Empty.mostRetweeted(TweetSet.scala:144)
                                                  //| 	at objsets.NonEmpty.mostRetweeted$lzycompute(TweetSet.scala:169)
                                                  //| 	at objsets.NonEmpty.mostRetweeted(TweetSet.scala:167)
                                                  //| 	at objsets.TW0$$anonfun$main$1.apply$mcV$sp(objsets.TW0.scala:16)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at objsets.TW0$.main(objsets.TW0.scala:5)
                                                  //| 	at objsets.TW0.main(objsets.TW0.scala)
    val something:Tweet = set5.remove(first).mostRetweeted
    
    val set = set5
   
    val desiredList = new Cons(first,
       new Cons(something, Nil)
       )
       
    var ls: TweetList = Nil
    
    
  val alltweets: TweetSet = TweetReader.allTweets
  
    
 //GoogleVsApple.google.exists(_.charAt(0)== 'a')
 
 GoogleVsApple.google.contains("android")
 
 val target = "First iPhone 5 Benchmarks: Screaming Fast, Yes, But Just Shy of Galaxy S III  http://t.co/QIAhda3L by @redgirlsays"
 
 val tweetwords = (target.split(" ")).toSet
 
 
 val appleWords = GoogleVsApple.apple.toSet
 val googleWords = GoogleVsApple.google.toSet
                                                  
 
 

def collect(wordlist: List[String], tweets: TweetSet): TweetList = {
  val wordset = wordlist.toSet
  var acc: TweetList = Nil
  def select(t: Tweet): Unit = {
    val candidates = (t.text.split(" ")).toSet
    if (!(wordset & candidates).isEmpty){
      acc = new Cons(t,acc)
    }
  }
  tweets.foreach(select)
  return acc
}

val gTweets = GoogleVsApple.googleTweets
val aTweets = GoogleVsApple.appleTweets

 "this is a test of the emergency broadcasting system".contains("test")
                                                  
 Math.max(3,2)
 
 
 
 
 
 
 
 

 
 
 
 
    
    
}