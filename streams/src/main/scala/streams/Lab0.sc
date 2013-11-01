package streams

import common._
import streams._
import streams.Bloxorz._
//import streams._._



object Lab0  {




  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
   val level =
      """------
        |--ST--
        |--oo--
        |--oo--
        |------""".stripMargin                    //> level  : String = ------
                                                  //| --ST--
                                                  //| --oo--
                                                  //| --oo--
                                                  //| ------
 
  
  
  case class Pos(x: Int, y: Int) {
    /** The position obtained by changing the `x` coordinate by `d` */
    def dx(d: Int) = copy(x = x + d)

    /** The position obtained by changing the `y` coordinate by `d` */
    def dy(d: Int) = copy(y = y + d)
  }
  
  val v = Pos(2,1)                                //> v  : streams.Lab0.Pos = Pos(2,1)
  
  
  
  //Utilities
  def tbl(level: String ): Vector[Vector[Char]] =
    Vector(level.split("\n").map(str => Vector(str: _*)): _*)
                                                  //> tbl: (level: String)Vector[Vector[Char]]
  

  
  
//  val t0 = tbl(level)
  val foo = Pos(2,2)                              //> foo  : streams.Lab0.Pos = Pos(2,2)
  
  val t = tbl(level)                              //> t  : Vector[Vector[Char]] = Vector(Vector(-, -, -, -, -, -), Vector(-, -, S,
                                                  //|  T, -, -), Vector(-, -, o, o, -, -), Vector(-, -, o, o, -, -), Vector(-, -, 
                                                  //| -, -, -, -))
  
  def occupied(p: Pos):Boolean = p match { case Pos(x,y) => t(x)(y) != '-' }
                                                  //> occupied: (p: streams.Lab0.Pos)Boolean
                                                  
  occupied(Pos(0,1))                              //> res0: Boolean = false
    
  

  //def terrainFunction(levelVector: Vector[Vector[Char]]): Pos => Boolean = ???
  // Filter arrays for indexof hits
  
  //l0(0).indexOf('o')
  //l0(1)(0)
  def terrainFunction(levelVector: Vector[Vector[Char]]): Pos => Boolean = {
    def occupied(p: Pos):Boolean = p match { case Pos(x,y) => levelVector(x)(y) != '-' }
    occupied
  }                                               //> terrainFunction: (levelVector: Vector[Vector[Char]])streams.Lab0.Pos => Boo
                                                  //| lean


  def findChar(c: Char, levelVector: Vector[Vector[Char]]): Pos = {
    val row = levelVector indexWhere (_.indexOf(c) != -1)
    val col = if(row == -1) -1
              else levelVector(row) indexOf c
    Pos(row,col)
  }                                               //> findChar: (c: Char, levelVector: Vector[Vector[Char]])streams.Lab0.Pos
  
  findChar('S', t)                                //> res1: streams.Lab0.Pos = Pos(1,2)
  
}