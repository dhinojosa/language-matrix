module WhereSpec
  ( testList
  ) where

import           Test.HUnit

-- where can be used much like let and with pattern matching
-- compare and contrast with let/Let.hs
myMax :: (Ord a) => [a] -> Maybe a
myMax [] = Nothing
myMax [x] = Just x
myMax (x:xs)
  | item > last = Just item
  | otherwise = Just last
  where
    item = x
    Just last = myMax xs -- Pattern matched here

testMyMax1 :: Test
testMyMax1 =
  TestCase
    (assertEqual
       "Pattern Matching with Where"
       (Just 100)
       (myMax [1, 5, 13, 42, 5, 3, 1, -3, 100, 22, 10, -40]))

testMyMax2 :: Test
testMyMax2 =
  TestCase
    (assertEqual
       "Pattern Matching result with empty List"
       Nothing
       (myMax ([] :: [Int])))

testMyMax3 :: Test
testMyMax3 =
  TestCase
    (assertEqual
       "Pattern Matching result with single element"
       (Just 1)
       (myMax [1]))

testMyMax4 :: Test
testMyMax4 =
  TestCase (assertEqual "Test with 3 elements" (Just 4) (myMax [-3, 4, 1]))

testList :: Test
testList = TestList [testMyMax1, testMyMax2, testMyMax3, testMyMax4]
