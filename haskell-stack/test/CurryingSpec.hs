module CurryingSpec
  ( testList
  ) where

-- Any function can be curried by mere supply part of the arguments
-- This is automatic currying which is always available in Haskell
import Test.HUnit

addThree :: Int -> Int -> Int -> Int
addThree x y z = x + y + z

curryingTest :: Test
curryingTest =
  let addOne = addThree 1 4
   in TestCase (assertEqual "curryingTest" 15 (addOne 10))

testList :: Test    
testList = TestList [curryingTest]
