use MyFunctions.multiply;

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