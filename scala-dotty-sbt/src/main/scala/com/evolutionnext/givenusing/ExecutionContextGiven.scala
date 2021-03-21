package com.evolutionnext.givenusing

object ExecutionContextGiven:
  import scala.concurrent._
  import java.util.concurrent.Executors

  extension[A](x:(A | Null))
    def toOption = if x == null then Option.empty[A] else Some(x.asInstanceOf[A])
    def notNull:A = 
      if (x == null) 
        throw new RuntimeException("You said it wasn't null, but it was, damn you")
      else x
    
  given ec: ExecutionContext = 
     ExecutionContext.fromExecutor(
       Executors.newFixedThreadPool(8).notNull)
    
  val future = Future.apply {
    println(s"Thread-name: ${Thread.currentThread().getName}")
    Thread.sleep(3000)
    50 + 100
  }

  future.foreach(println)