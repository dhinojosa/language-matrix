module Main (main) where

import qualified HigherOrderFunctionsSpec
import Test.HUnit

main :: IO Counts
main = runTestTT $ HigherOrderFunctionsSpec.testList
