
object Vals extends App {
   //Vals are final they can longer be referenced to another object.
   
   val a = 10
   assert (a == 10);
   
   //If this next line was removed it would not work, since it is being reassigned
   //a = 10
}
