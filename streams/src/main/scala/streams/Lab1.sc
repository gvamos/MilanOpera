package streams

import common._
import streams._
import streams.Bloxorz._

object Lab2 {
        
        
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
	object Frame extends StringParserTerrain {
	
	  def tbl(): Vector[Vector[Char]] =
    Vector(level.split("\n").map(str => Vector(str: _*)): _*)
    
    
		override val level =
		      """------
        |--ST--
        |--oo--
        |--oo--
        |------""".stripMargin
        
    //val board = tbl()
        
        
    //override lazy val startPos = findChar('S', board)
        
    //def proclaim():String = level
    
   // def Xneighbors: List[(Block, Move)] = {
    //  Nil
   // }
    
   // def foo() {
    //  for(m: Move <- Move.dirs){ println(m) }
    //}
	}
	
	Frame.startPos                            //> res0: streams.Lab2.Frame.Pos = Pos(1,2)
	

	//Frame.startPos
	//Frame.foo
	
  
}