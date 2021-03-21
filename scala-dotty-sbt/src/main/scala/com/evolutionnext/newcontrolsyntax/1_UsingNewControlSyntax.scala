package com.evolutionnext.newcontrolsyntax

@main def assertNewIfStatements:Unit =
  val x = 3
  val result = 
    if x > 0 then
      "Positive"
    else if x < 0 then
      "Negative"
    else
      "Zero"
  println(result)

@main def assertNewWhileDo:Unit =
  var count = 0
  var done = 10
  while count <= done do
    count = count + 1
    println(count)

@main def assertNewForDoForSideEffects:Unit = 
  val xs = List(1,2,3)
  val ys = List('a', 'b', 'c')
  for
    x <- xs
    y <- ys
  do
  println(x -> y)

@main def assertNewForWithYield:Unit = 
  val xs = List(1,2,3)
  val ys = List('a', 'b', 'c')
  val result = for
    x <- xs //flatMap
    y <- ys //map
  yield (x -> y)
  println(result)

/**
 * Source: Programming Scala 3, Dean Wampler
 **/
@main def assertNestedMatching:Unit = 
  val result = 
    for opt <- Seq(Some(1), None)
      yield opt match
        case None => ""
        case Some(i) => i.toString
        match
          case "" => false
          case _ => true
  println(result)

