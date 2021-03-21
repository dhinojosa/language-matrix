module Main
  ( main
  ) where

import           Data.List.Extra
import qualified HigherOrderFunctionsSpec
import qualified RecordSyntaxSpec
import           Test.HUnit

main :: IO Counts
main = do
  runTestTT HigherOrderFunctionsSpec.testList
  runTestTT RecordSyntaxSpec.testList
