module AlgebraicDataTypesSpec
  ( testList
  ) where

import           Shapes

import           Test.HUnit

areaOfTriangleTest :: Test
areaOfTriangleTest =
  TestCase (assertEqual "computeTriangle" 70.0 (area $ Triangle 10 14))

testList :: Test
testList = TestList [areaOfTriangleTest]
