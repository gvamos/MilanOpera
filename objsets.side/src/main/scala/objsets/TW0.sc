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
    
    val first: Tweet = set5.mostRetweeted         //> first  : objsets.Tweet = User: a
                                                  //| Text: a body [20]
    val something:Tweet = set5.remove(first).mostRetweeted
                                                  //> something  : objsets.Tweet = User: b
                                                  //| Text: b body [20]
    
    val set = set5                                //> set  : objsets.TweetSet = elem: User: a
                                                  //| Text: a body [20], left: Empty, right:elem: User: b
                                                  //| Text: b body [20], left: Empty, right:elem: User: c
                                                  //| Text: c body [7], left: Empty, right:elem: User: d
                                                  //| Text: d body [9], left: Empty, right:Empty
   
    val desiredList = new Cons(first,
       new Cons(something, Nil)
       )                                          //> desiredList  : objsets.Cons = objsets.Cons@70cb6009
       
    var ls: TweetList = Nil                       //> ls  : objsets.TweetList = objsets.Nil$@380e28b9
    
    
  val alltweets: TweetSet = TweetReader.allTweets //> alltweets  : objsets.TweetSet = elem: User: mashable
                                                  //| Text: Which is sorriest, #Apple Maps or #Siri? @Charlie_White has the comic 
                                                  //| - http://t.co/YRXXJXGY [55], left: elem: User: mashable
                                                  //| Text: Watch These Quadrotor #Robots Learn to Play Catch [VIDEO] http://t.co/
                                                  //| CHZ5BPfL [21], left: elem: User: mashable
                                                  //| Text: 10 Funny @YouTube Clips of Sleeping Dogs http://t.co/ukPgWZjH [34], le
                                                  //| ft: elem: User: mashable
                                                  //| Text: .@HP Shows What @Windows 8 #Tablets for Business Will Look Like [PICS]
                                                  //|  http://t.co/Md6ua8Xc [32], left: elem: User: mashable
                                                  //| Text: 'Dexter' Season 7 Premiere Available in Full on @YouTube [VIDEO] http:
                                                  //| //t.co/Cc5HeiZZ [345], left: elem: User: mashable
                                                  //| Text: #DidYouKnow 81% of mobile phone subscribers use text messaging? http:/
                                                  //| /t.co/ABJMZpNZ [55], left: elem: User: mashable
                                                  //| Text: #Bots Drive 16% of U.S. Web Traffic [INFOGRAPHIC] http://t.co/lfFAjUy6
                                                  //|  [84], left: elem: User: mashable
                                                  //| Text: #Apple Cites Improved Workin
                                                  //| Output exceeds cutoff limit.
  
    
 //GoogleVsApple.google.exists(_.charAt(0)== 'a')
 
 GoogleVsApple.google.contains("android")         //> res0: Boolean = true
 
 val target = "First iPhone 5 Benchmarks: Screaming Fast, Yes, But Just Shy of Galaxy S III  http://t.co/QIAhda3L by @redgirlsays"
                                                  //> target  : String = First iPhone 5 Benchmarks: Screaming Fast, Yes, But Just 
                                                  //| Shy of Galaxy S III  http://t.co/QIAhda3L by @redgirlsays
 
 val tweetwords = (target.split(" ")).toSet       //> tweetwords  : scala.collection.immutable.Set[String] = Set("", Yes,, Galaxy,
                                                  //|  5, iPhone, Benchmarks:, @redgirlsays, Just, Shy, III, by, http://t.co/QIAhd
                                                  //| a3L, Fast,, Screaming, But, of, S, First)
 
 
 val appleWords = GoogleVsApple.apple.toSet       //> appleWords  : scala.collection.immutable.Set[String] = Set(ios, iPad, iPhon
                                                  //| e, ipad, iphone, iOS)
 val googleWords = GoogleVsApple.google.toSet     //> googleWords  : scala.collection.immutable.Set[String] = Set(Galaxy, nexus, 
                                                  //| galaxy, Nexus, Android, android)
                                                  
 
 

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
}                                                 //> collect: (wordlist: List[String], tweets: objsets.TweetSet)objsets.TweetLis
                                                  //| t

val gTweets = GoogleVsApple.googleTweets          //> gTweets  : objsets.TweetSet = elem: User: gizmodo
                                                  //| Text: iPhone 5 vs Galaxy S III: Who's screen is prettier? http://t.co/n6Cba
                                                  //| spY [108], left: elem: User: engadget
                                                  //| Text: AT&amp;T 4G LTE adds Galaxy Note 2, Galay Tab 2 10.1, Galaxy Express 
                                                  //| and Galaxy Rugby Pro to lineup -  http://t.co/uvBFFMQO [12], left: elem: Us
                                                  //| er: CNET
                                                  //| Text: A mathematician accurately predicted when Android's app store would h
                                                  //| it 25 billion downloads http://t.co/VFLBJ0z3 [36], left: elem: User: mashab
                                                  //| le
                                                  //| Text: 7 Free #Android Apps for Killing Time in Lines http://t.co/eKu5hhsh [
                                                  //| 42], left: elem: User: mashable
                                                  //| Text: 5 Mobile Photographers Capturing the World With #Android http://t.co/
                                                  //| 786NneBt [78], left: Empty, right:Empty, right:Empty, right:Empty, right:el
                                                  //| em: User: engadget
                                                  //| Text: Court of Appeals for the Federal Circuit tells Judge Koh to revisit G
                                                  //| alaxy Tab 10.1 injunction -  http://t.co/iIOCcwDW [13], left: elem: User: C
                                                  //| NET
val aTweets = GoogleVsApple.appleTweets           //> aTweets  : objsets.TweetSet = elem: User: mashable
                                                  //| Text: iOS 6 Users Complain About Wi-Fi, Connectivity Issues - http://t.co/i
                                                  //| ogRstNn [180], left: elem: User: gadgetlab
                                                  //| Text: http://t.co/z7Dsi93S Search Confirms iPhone 5 with LTE Support, Plus 
                                                  //| New iPods http://t.co/a7mZnloy by @alexandra_chang [30], left: elem: User: 
                                                  //| gadgetlab
                                                  //| Text: Yes, the #iPhone5 does have LTE. #Apple liveblog http://t.co/DwtKQkSu
                                                  //|  [19], left: elem: User: gizmodo
                                                  //| Text: Yep, the TSA is definitely stealing iPads: http://t.co/THYd8MKe [79],
                                                  //|  left: elem: User: gadgetlab
                                                  //| Text: Who's Waiting in Line for the #iPhone5? These People Are: http://t.co
                                                  //| /qeYJaGu2 by @redgirlsays [21], left: elem: User: gadgetlab
                                                  //| Text: "We've updated every aspect of iPhone 5,? @PSchiller says. #Apple #iP
                                                  //| hone5 LIVEBLOG http://t.co/DwtKQkSu [16], left: Empty, right:elem: User: ga
                                                  //| dgetlab
                                                  //| Text: #Apple #iPhone5 battery: 8hrs of 3G talk time, 8hrs of LTE or 3G brow

 "this is a test of the emergency broadcasting system".contains("test")
                                                  //> res1: Boolean = true
 
 
 
 
 

 
 
 
 
    
    
}