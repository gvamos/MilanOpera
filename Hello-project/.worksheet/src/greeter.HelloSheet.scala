package greeter



object HelloSheet {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(49); 

val x = 1;System.out.println("""x  : Int = """ + $show(x ));$skip(28); 
def increase(i:Int) = i + 1;System.out.println("""increase: (i: Int)Int""");$skip(12); val res$0 = 
increase(x);System.out.println("""res0: Int = """ + $show(res$0));$skip(14); 
println(x+21);$skip(45); 

  println("Welcome to the Scala worksheet")}
}
