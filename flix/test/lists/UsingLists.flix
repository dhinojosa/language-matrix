
@test
def determiningSizeOfAList():Bool & Pure = 
   let a = 1 :: 3 :: 4 :: 5 :: Nil;
   List.length(a) == 4

@test
def reversingAList():Bool & Pure = 
   let a = 1 :: 3 :: 4 :: 5 :: Nil;
   List.reverse(a) == (5 :: 4 :: 3 :: 1 :: Nil)

@test
def spanningAList():Bool & Pure = 
   let a = 1 :: 3 :: 4 :: 5 :: Nil;     
   let result = List.span(b -> (b mod 2) != 0, a); 
   result == (1 :: 3 :: Nil, 4 :: 5 :: Nil)


