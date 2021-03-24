module HigherOrderFunctionsSpec
  ( testList
  ) where

import           Test.HUnit

-- The (Int -> Int -> Int) is a higher order function.
-- It states that this must be a function, that takes two Int and return
--   an Int, there op takes that function as an argument as well as two
--   other Ints as arguments to op.
op :: (Int -> Int -> Int) -> Int -> Int -> Int
op f = f

testOp :: Test
testOp = TestCase (assertEqual "testOp" 10 (op (\x y -> x + y + 1) 4 5))

testList :: Test
testList = TestList [testOp]
