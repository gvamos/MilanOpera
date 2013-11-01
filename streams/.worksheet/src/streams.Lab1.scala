package streams

import common._
import streams._
import streams.Bloxorz._

object Lab1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(134); 

  println("Welcome to the Scala worksheet")}

  trait Zorg extends GameDef with Solver with StringParserTerrain {
    /**
     * This method applies a list of moves `ls` to the block at position
     * `startPos`. This can be used to verify if a certain list of moves
     * is a valid solution, i.e. leads to the goal.
     */
    def solve(ls: List[Move]): Block =
      ls.foldLeft(startBlock) { case (block, move) => move match {
        case Left => block.left
        case Right => block.right
        case Up => block.up
        case Down => block.down
      }
    }
  }
  
  trait blargh extends Zorg with StringParserTerrain {
  
    val level =
      """------
        |--ST--
        |--oo--
        |--oo--
        |------""".stripMargin
        
    def tbl(level: String ): Vector[Vector[Char]] =
      Vector(level.split("\n").map(str => Vector(str: _*)): _*)
      
    def xfindChar(c: Char, levelVector: Vector[Vector[Char]]): Pos = {
      val row = levelVector indexWhere (_.indexOf(c) != -1)
      val col = if(row == -1) -1
              else levelVector(row) indexOf c
      Pos(row,col)
  }
        
    val t = tbl(level)
        
    startPos: Pos = xfindChar('S', t)
   
    val goal: Pos = findChar('T', t)
    
      /**
   * The terrain is represented as a function from positions to
   * booleans. The function returns `true` for every position that
   * is inside the terrain.
   *
   * As explained in the documentation of class `Pos`, the `x` axis
   * is the vertical one and increases from top to bottom.
   */
  //type Terrain = Pos => Boolean

  
  /**
   * The terrain of this game. This value is left abstract.
   */
  val terrain: Terrain = terrainFunction(t)
  
  }
  
  

        

    



  
 
  
  
  
}
