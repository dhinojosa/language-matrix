module Main
  ( main
  ) where

import qualified AlgebraicDataTypesSpec
import qualified ForComprehensionsSpec
import qualified HigherOrderFunctionsSpec
import qualified RecordSyntaxSpec
import qualified WHNFSpec
import           Test.HUnit

main :: IO Counts
main = do
  _ <- runTestTT HigherOrderFunctionsSpec.testList
  _ <- runTestTT RecordSyntaxSpec.testList
  _ <- runTestTT AlgebraicDataTypesSpec.testList
  _ <- runTestTT ForComprehensionsSpec.testList
  runTestTT WHNFSpec.testList  
