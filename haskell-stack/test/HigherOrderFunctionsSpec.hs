module HigherOrderFunctionsSpec (testList) where

import Test.HUnit
import Test.HUnit.Text

-- The (Int -> Int -> Int) is a higher order function.

-- It states that this must be a function, that takes two Int and return 
--   an Int, there op takes that function as an argument as well as two
--   other Ints as arguments to op.

op :: (Int -> Int -> Int) -> Int -> Int -> Int
op f x y = f x y

prod2 :: Int -> Int -> Int
prod2 x y = x * y

testOp = TestCase (assertEqual "testOp" 10 (op (\ x y -> x + y + 1) 4 5))

testList = TestList [testOp]
