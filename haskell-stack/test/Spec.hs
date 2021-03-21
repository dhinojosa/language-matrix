module Main (main) where

import qualified HigherOrderFunctionsSpec
import qualified RecordSyntaxSpec
import Test.HUnit
import Data.List.Extra

main :: IO Counts
main = do runTestTT $ HigherOrderFunctionsSpec.testList
          runTestTT $ RecordSyntaxSpec.testList
