module WHNFSpec
  ( testList
  ) where

import           Test.HUnit

-- Normal Form - the expression is fully evaluated
-- Weak Head Normal Form - Expression is only evaluated as
--                         necessary to reach the data constructor
--                         or a function requiring evaluation
-- If no further inputs are possible, it is still in WHNF but also NF
-- Anything that is WHNF is also NF
-- An expression cannot be in NF or WHNF if the outer most expression
--   is not a data constructor
-- let a = (1,2)                 -- WHNF & NF
-- let b = (1, 1 + 1)            -- WHNF, not NF
--
-- let c = \x -> x * 10          -- WHNF, NF
--
-- let d = "foo" ++ "bar"        -- not WHNF, not NF
--
-- let e = (1, "foo" ++ "bar")   -- WHNF, not NF
-- The following shows strictness of a list, where we do not require evaluation
-- of every element to calculate the length of a list, even though one of the
-- elements is undefined.
lst :: [Int]
lst = [1, undefined, 2]

testAbilityToGetLengthWithoutEval :: Test
testAbilityToGetLengthWithoutEval =
  TestCase (assertEqual "testLengthWithoutEvaluation" 3 (length lst))

testList :: Test
testList = TestList [testAbilityToGetLengthWithoutEval]
