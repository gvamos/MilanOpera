package greeter



object HelloSheet {

val x = 1                                         //> x  : Int = 1
def increase(i:Int) = i + 1                       //> increase: (i: Int)Int
increase(x)                                       //> res0: Int = 2
println(x+21)                                     //> 22

  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
}