module Main
  ( main
  ) where

import qualified HigherOrderFunctionsSpec
import qualified RecordSyntaxSpec
import qualified AlgebraicDataTypesSpec
import           Test.HUnit

main :: IO Counts
main = do
  _ <- runTestTT HigherOrderFunctionsSpec.testList
  _ <- runTestTT RecordSyntaxSpec.testList
  runTestTT AlgebraicDataTypesSpec.testList
