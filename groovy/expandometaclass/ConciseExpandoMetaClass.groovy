package com.evolutionnext.languagematrix.groovy 

Integer.metaClass {
   divMod = { divisor -> [ delegate.intdiv(divisor), delegate % divisor ] }  //Must be a closure

   isOdd =  { -> delegate % 2 != 0} //No parameters

   isEven = { -> !isOdd() }

   'static' {                                                                 //'static' block
      matrix = {x, y, item ->
                 def result = []
                 (1..x).each {i ->
                     def row = []
                     (1..y).each {j -> row << item}
                       result << row
                     };
                     result
                 }
    }

    constructor = {Float x -> Math.floor(x)}                                  // Not a <<

    constructor = {Double x -> Math.floor(x)}
}

assert 10.divMod(3) == [3,1]
assert 10.isEven()  == true
assert 10.isOdd()   == false
assert Integer.matrix(2, 3, 'x') == [['x', 'x', 'x'],
                                     ['x', 'x', 'x']]

assert new Integer(90.00) == 90
