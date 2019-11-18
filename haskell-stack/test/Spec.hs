module Main where
import qualified AlgebraicDataTypesSpec
import qualified GuardsSpec
import qualified PatternMatchingSpec

import Test.Hspec

main :: IO ()
main = hspec spec

spec :: Spec
spec
  = do describe "PatternMatching" PatternMatchingSpec.spec
       describe "AlgebraicDataTypes" AlgebraicDataTypesSpec.spec
       describe "Guards" GuardsSpec.spec
