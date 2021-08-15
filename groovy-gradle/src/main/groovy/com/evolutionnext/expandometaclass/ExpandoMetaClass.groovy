package com.evolutionnext.expandometaclass

Integer.metaClass.divMod = {divisor -> [ delegate.intdiv(divisor), delegate % divisor ] }  //Must be a closure

Integer.metaClass.isOdd = { -> delegate % 2 != 0} //No parameters

Integer.metaClass.isEven = { -> !isOdd() }

Integer.metaClass.'static'.matrix = {x, y, item ->
                                        def result = []
                                        (1..x).each {i ->
                                            def row = []
                                            (1..y).each {j -> row << item}
                                            result << row
                                        };
                                        result
                                    }

Integer.metaClass.constructor << {Float x -> Math.floor(x)}                             //Add Constructor

Integer.metaClass.constructor << {Double x -> Math.floor(x)}                            //Add Constructor

Integer.metaClass.constructor = {int x -> x * 4}                                        //Replace & Intercept call

assert 10.divMod(3) == [3,1]
assert 10.isEven()  == true
assert 10.isOdd()   == false
assert Integer.matrix(2, 3, 'x') == [['x', 'x', 'x'],
                                     ['x', 'x', 'x']]
assert new Integer(90.00) == 90
assert new Integer(4) == 16
