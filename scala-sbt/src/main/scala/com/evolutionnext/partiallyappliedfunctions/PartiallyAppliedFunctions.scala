package com.evolutionnext.partiallyappliedfunctions

object PartiallyAppliedFunctions extends App {
    // A partially applied function is just that. A function where parts of the
    // function have already been defined. Leave the rest to be defined some other
    // time.
    def sum(a: Int, b: Int, c: Int) = a + b + c

    val sum3 = sum _
    assert(sum3(1, 9, 7) == 17)
    assert(sum(4, 5, 6) == 15)

    // To partially apply a parameter, use _ but declare the type
    val sum1 = sum(2, 3, _: Int)
    assert(sum1(4) == 9)
}
