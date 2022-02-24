use MyFunctions.multiply;

/**
 * A function, just like this test method, 
 * can have multiple lines, but all lines that
 * are followed by another line must terminate with
 * a semicolon. Notice there is one inline function
 * that ends in a semicolon. That is followed by a function
 * call in the last line with no semicolon.
 */
@test
def usingFunctionWithTwoLinesAndBracket():Bool = {
   let addTwoNumbers = (x:Int32, y:Int32) -> x + y;
   addTwoNumbers(3, 10) == 13
}

/**
 * Same test as above, but no brackets. Still works
 */
@test
def usingFunctionWithTwoLinesAndNoBracket():Bool =
   let addTwoNumbers = (x:Int32, y:Int32) -> x + y;
   addTwoNumbers(3, 10) == 13


/** 
 * The following is using brackets
 * around the function, which seems to work
 */
@test
def usingFunctionsInlineExplicitReturnType():Bool = {
   let multiply3:(Int32, Int32, Int32) -> Int32 & Pure = 
     (x:Int32, y:Int32, z:Int32) -> x * y * z;
   multiply3(3, 4, 5) == 60
}

/**
 * The following is using pure type inferencing
 * this is declaring a let-style function within
 * the test
 */
@test
def usingFunctionsInlineInplicitReturnType():Bool = 
   let multiply3 = (x:Int32, y:Int32, z:Int32) -> x * y * z;
   multiply3(3, 4, 5) == 60

/**
 * Importing or using a function from another
 * module.
 */
@test
def usingHighLevelFunction():Bool =
   multiply(3, 4) == 12 

@test
def usingACustomType():Bool = 
  let x:Id[Int32] = Sume(30);
  x == Sume(30)