package com.evolutionnext.typelambdas

object TypeLambdas extends App {

  /** A type lambda is a partial application of types in type constructors
   *  where the types are defined. Previous to dotty looked like the following:
   *  new T[({type l[A]=SomeType[A,..]})#l] 
   *
   *  The type lambda can be used for type projection, so given the definition for 
   *  a Monad[M[A]], notice that it takes a certain shape:
   **/

   trait Monad[M[_]] {
     def point[A](a:A):M[A]
     def bind[A](a:A)(f:A => M[A]):M[A]
   }

   /** We cannot use say, the either type since it has a different shape, 
     * namely Either[L, R].  We can either do a projection like the
     * following where we will define the left, but not the right,
     * thus rendering a new type with the M[A] shape: 
     **/

   type MyEither[A] = Either[String, A]

   /** This will allow for the shape to nicely fit into the Monad 
     * as a type class.
     */

   type F1 = Monad[MyEither]

   /** If we attempted to inline the above definition, then it would not
     * work.
     */

   //type F2 = Monad[MyEither[String, A]] //Fail

   /** If we didn't want to construct the new type we could've done a type
     * lambda trick and that uses {type λ[α] = Either[A, α]})#λ which looks
     * scary. But what it means is the same thing as before Either[A, α] where A
     * will be the generic type and α will be the right projection.
     */
  
   type F2 = Monad[({type λ[α] = Either[String, α]})#λ]

   /** If you are wondering how we use F2 then we can one instantiate this new
     * type.
     *
     **/
   val a:F2 = new F2 {
      def point[Int](x:Int):Either[String, Int] = Right(x)
      def bind[Int](x:Int)(f: Int => Either[String, Int]) = f(x)
   }

   /** But where we can mainly use it is in a method where it is required, and
     * some of the other types are unknown.   
     *
     */

   def foo[M[_, _], A](x:Monad[({type λ[α] = M[A, α]})#λ])(y:A) = x.bind(y)

  /** That unfortunately was too much work so type lambdas syntax arrives in Dotty 
    * so as to take care of the situtation with out much of the ugly syntax
    **/

   type F3 = Monad[[X] =>> Either[String, X]]

   val b:F3 = new F3 {
      def point[Int](x:Int):Either[String, Int] = Right(x)
      def bind[Int](x:Int)(f: Int => Either[String, Int]) = f(x)
   }

   def bar[M[_, _], A](x:Monad[[A] =>> Either[String, A]])(y:A) = x.bind(y)
}
