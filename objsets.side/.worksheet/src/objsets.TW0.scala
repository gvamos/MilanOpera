package objsets

import org.scalatest.FunSuite

object TW0 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(104); 
  println("Welcome to the Scala worksheet");$skip(25); 
    val set1 = new Empty;System.out.println("""set1  : objsets.Empty = """ + $show(set1 ));$skip(55); 
    val set2 = set1.incl(new Tweet("a", "a body", 20));System.out.println("""set2  : objsets.TweetSet = """ + $show(set2 ));$skip(55); 
    val set3 = set2.incl(new Tweet("b", "b body", 20));System.out.println("""set3  : objsets.TweetSet = """ + $show(set3 ));$skip(40); 
    val c = new Tweet("c", "c body", 7);System.out.println("""c  : objsets.Tweet = """ + $show(c ));$skip(40); 
    val d = new Tweet("d", "d body", 9);System.out.println("""d  : objsets.Tweet = """ + $show(d ));$skip(28); 
    val set4 = set3.incl(c);System.out.println("""set4  : objsets.TweetSet = """ + $show(set4 ));$skip(28); 
    val set5 = set4.incl(d);System.out.println("""set5  : objsets.TweetSet = """ + $show(set5 ));$skip(54); 
    //
    
    val first: Tweet = set5.mostRetweeted;System.out.println("""first  : objsets.Tweet = """ + $show(first ));$skip(59); 
    val something:Tweet = set5.remove(first).mostRetweeted;System.out.println("""something  : objsets.Tweet = """ + $show(something ));$skip(24); 
    
    val set = set5;System.out.println("""set  : objsets.TweetSet = """ + $show(set ));$skip(83); 
   
    val desiredList = new Cons(first,
       new Cons(something, Nil)
       );System.out.println("""desiredList  : objsets.Cons = """ + $show(desiredList ));$skip(36); 
       
    var ls: TweetList = Nil;System.out.println("""ls  : objsets.TweetList = """ + $show(ls ));$skip(60); 
    
    
  val alltweets: TweetSet = TweetReader.allTweets;System.out.println("""alltweets  : objsets.TweetSet = """ + $show(alltweets ));$skip(102); val res$0 = 
  
    
 //GoogleVsApple.google.exists(_.charAt(0)== 'a')
 
 GoogleVsApple.google.contains("android");System.out.println("""res0: Boolean = """ + $show(res$0));$skip(133); 
 
 val target = "First iPhone 5 Benchmarks: Screaming Fast, Yes, But Just Shy of Galaxy S III  http://t.co/QIAhda3L by @redgirlsays";System.out.println("""target  : String = """ + $show(target ));$skip(46); 
 
 val tweetwords = (target.split(" ")).toSet;System.out.println("""tweetwords  : scala.collection.immutable.Set[String] = """ + $show(tweetwords ));$skip(48); 
 
 
 val appleWords = GoogleVsApple.apple.toSet;System.out.println("""appleWords  : scala.collection.immutable.Set[String] = """ + $show(appleWords ));$skip(46); 
 val googleWords = GoogleVsApple.google.toSet;System.out.println("""googleWords  : scala.collection.immutable.Set[String] = """ + $show(googleWords ));$skip(383); 
                                                  
 
 

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
};System.out.println("""collect: (wordlist: List[String], tweets: objsets.TweetSet)objsets.TweetList""");$skip(42); 

val gTweets = GoogleVsApple.googleTweets;System.out.println("""gTweets  : objsets.TweetSet = """ + $show(gTweets ));$skip(40); 
val aTweets = GoogleVsApple.appleTweets;System.out.println("""aTweets  : objsets.TweetSet = """ + $show(aTweets ));$skip(73); val res$1 = 

 "this is a test of the emergency broadcasting system".contains("test");System.out.println("""res1: Boolean = """ + $show(res$1))}
 
 
 
 
 

 
 
 
 
    
    
}
