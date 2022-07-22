module CaseSpec
  ( testList
  ) where

import Test.HUnit

-- The format for a case expression is the following
-- where `pattern` is a pattern match
-- case expression of pattern -> result
--                    pattern -> result
--                    pattern -> result
-- where can be used much like let and where and with pattern matching
-- compare and contrast with let/Let.hs, and where/Where.hs
myMax :: (Ord a) => [a] -> Maybe a
myMax xs =
  case xs of
    [] -> Nothing
    [x] -> Just x
    (x:rest) ->
      case myMax rest of
        Nothing -> Just x
        Just a ->
          if a > x
            then Just a
            else Just x

determiningMaxTest :: Test
determiningMaxTest =
  TestCase
    (assertEqual
       "determineMax"
       (Just 100)
       (myMax [1, 5, 13, 42, 5, 3, 1, -3, 100, 22, 10, -40]))

determiningMaxEmptyListTest :: Test
determiningMaxEmptyListTest =
  TestCase
    (assertEqual "determineMaxFromAnEmptyList" Nothing (myMax ([] :: [Int])))

determingMaxEmptyListWithOneElement :: Test
determingMaxEmptyListWithOneElement =
  TestCase
    (assertEqual
       "determining Max Empty List with one element"
       (Just 1)
       (myMax [1]))

determingMaxWithNegativeNumberInTheMix :: Test
determingMaxWithNegativeNumberInTheMix =
  TestCase
    (assertEqual
       "determining Max with negative number in the mix"
       (Just 4)
       (myMax [-3, 4, 1]))

testList :: Test
testList =
  TestList
    [ determiningMaxTest
    , determiningMaxEmptyListTest
    , determingMaxEmptyListWithOneElement
    , determingMaxWithNegativeNumberInTheMix
    ]
