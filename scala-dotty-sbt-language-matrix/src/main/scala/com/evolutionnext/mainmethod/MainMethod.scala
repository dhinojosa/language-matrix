package com.evolutionnext.mainmethod

//Things to Note:
//1. The thing is we don't actually need a surrounding object
//2. Visual Studio Code recognizes a main method and allows a run
//3. `assertSimpleMainMethodWithArgsWorks` will parse arguments automatically

@main def assertSimpleMainMethodWorks(): Unit =
    println("Hello World")

@main def assertSimpleMainMethodWithArgsWorks(name: String, times: Int): Unit =
    println(name.repeat(times))
