package com.evolutionnext.closures

def pickEven(n, block) {
   for(int i = 2; i <= n; i += 2) {
      block(i)
   }
}

println "\nWith 10\n-------"

pickEven(10, { println it } )

// Each closure is meant to be small amounts of code

Closure c = {println it} //def c= {println it} can work too

println "\nWith 20\n-------"

pickEven(20, c)

println "\nWith 30 and shorter syntax\n----------------"

pickEven (30) {
   println it //it is a default temporary variable
}

println "\nWith 40 and using or own variable\n----------------"

pickEven(40) { evenNumber ->
   println evenNumber
}

def myMap(closure, list) {
   def result = []
   for (i in list) {
     println("in i: $i")
     result << closure(i)
   }
   result
}

def items = [1,2,3,4]
println(myMap({it * 2}, items))

