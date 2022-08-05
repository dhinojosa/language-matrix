
object Vars extends App {
   //A var as opposed to a val (see vals/Vals.scala) can be reassigned.  
   //This is usually a sign of bad design, unless perhaps it is used
   //in a method and it's references are mutable and nothing can be changed
   //outside the method.
   var x = 10
   assert (x == 10)

   //Make the reassignment
   x = 12
   assert (x == 12)
}
