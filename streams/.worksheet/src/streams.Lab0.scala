package streams

import common._
import streams._
import streams.Bloxorz._
//import streams._._



object Lab0  {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(161); 




  println("Welcome to the Scala worksheet");$skip(113); 
  
   val level =
      """------
        |--ST--
        |--oo--
        |--oo--
        |------""".stripMargin
 
  
  
  case class Pos(x: Int, y: Int) {
    /** The position obtained by changing the `x` coordinate by `d` */
    def dx(d: Int) = copy(x = x + d)

    /** The position obtained by changing the `y` coordinate by `d` */
    def dy(d: Int) = copy(y = y + d)
  };System.out.println("""level  : String = """ + $show(level ));$skip(286); 
  
  val v = Pos(2,1);System.out.println("""v  : streams.Lab0.Pos = """ + $show(v ));$skip(135); 
  
  
  
  //Utilities
  def tbl(level: String ): Vector[Vector[Char]] =
    Vector(level.split("\n").map(str => Vector(str: _*)): _*);System.out.println("""tbl: (level: String)Vector[Vector[Char]]""");$skip(55); 
  

  
  
//  val t0 = tbl(level)
  val foo = Pos(2,2);System.out.println("""foo  : streams.Lab0.Pos = """ + $show(foo ));$skip(24); 
  
  val t = tbl(level);System.out.println("""t  : Vector[Vector[Char]] = """ + $show(t ));$skip(80); 
  
  def occupied(p: Pos):Boolean = p match { case Pos(x,y) => t(x)(y) != '-' };System.out.println("""occupied: (p: streams.Lab0.Pos)Boolean""");$skip(72); val res$0 = 
                                                  
  occupied(Pos(0,1));System.out.println("""res0: Boolean = """ + $show(res$0));$skip(348); 
    
  

  //def terrainFunction(levelVector: Vector[Vector[Char]]): Pos => Boolean = ???
  // Filter arrays for indexof hits
  
  //l0(0).indexOf('o')
  //l0(1)(0)
  def terrainFunction(levelVector: Vector[Vector[Char]]): Pos => Boolean = {
    def occupied(p: Pos):Boolean = p match { case Pos(x,y) => levelVector(x)(y) != '-' }
    occupied
  };System.out.println("""terrainFunction: (levelVector: Vector[Vector[Char]])streams.Lab0.Pos => Boolean""");$skip(226); 


  def findChar(c: Char, levelVector: Vector[Vector[Char]]): Pos = {
    val row = levelVector indexWhere (_.indexOf(c) != -1)
    val col = if(row == -1) -1
              else levelVector(row) indexOf c
    Pos(row,col)
  };System.out.println("""findChar: (c: Char, levelVector: Vector[Vector[Char]])streams.Lab0.Pos""");$skip(22); val res$1 = 
  
  findChar('S', t);System.out.println("""res1: streams.Lab0.Pos = """ + $show(res$1))}
  
}
