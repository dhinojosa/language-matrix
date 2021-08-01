package com.evolutionnext.givenusing

object ExecutionContextGiven:
  import java.util.concurrent.Executors
  import scala.concurrent.*

  extension [A](x: (A | Null))
    def toOption = if x == null then Option.empty[A] else Some(x.asInstanceOf[A])
    def notNull: A =
      if x == null then throw new RuntimeException("You said it wasn't null, but it was, damn you")
      else x

  given ec: ExecutionContext =
    ExecutionContext.fromExecutor(Executors.newFixedThreadPool(8).notNull)

  val future = Future.apply {
    import com.evolutionnext.explicitnulls.ExplicitNulls.given
    val thread: Thread | Null = Thread.currentThread()
    val option: Option[Thread] = thread.toOption
    option.foreach(t => println(s"Thread-name: ${t.getName()}"));
    Thread.sleep(3000)
    50 + 100
  }

  future.foreach(println)
