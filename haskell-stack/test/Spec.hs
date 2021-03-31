module Main
  ( main
  ) where

import qualified AlgebraicDataTypesSpec
import qualified ApplicativeFunctorsSpec
import qualified ForComprehensionsSpec
import qualified HigherOrderFunctionsSpec
import qualified NewTypeSpec
import qualified RecordSyntaxSpec
import           Test.HUnit
import qualified WhereSpec
import qualified WHNFSpec

main :: IO Counts
main = do
  _ <- runTestTT HigherOrderFunctionsSpec.testList
  _ <- runTestTT RecordSyntaxSpec.testList
  _ <- runTestTT AlgebraicDataTypesSpec.testList
  _ <- runTestTT ForComprehensionsSpec.testList
  _ <- runTestTT ApplicativeFunctorsSpec.testList
  _ <- runTestTT WhereSpec.testList
  _ <- runTestTT NewTypeSpec.testList
  runTestTT WHNFSpec.testList
