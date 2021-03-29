{-# LANGUAGE RankNTypes #-}

module ForComprehensionsSpec
  ( testList
  ) where

import           Test.HUnit

myZip :: [a] -> [b] -> [(a, b)]
myZip as bs = [(x, y) | x <- as, y <- bs]

-- for comprehension are great for lists, but are underused since it
-- can only work for lists
monadicMyZip :: forall a b. [a] -> [b] -> [(a, b)]
monadicMyZip as bs = do
  a <- as
  b <- bs
  return (a, b)

myZipTest :: Test
myZipTest =
  TestCase
    (assertEqual
       "myZip"
       [(1, 5), (1, 6), (2, 5), (2, 6)]
       (myZip [1 :: Int, 2] [5 :: Int, 6]))

monadicMyZipTest :: Test
monadicMyZipTest =
  TestCase
    (assertEqual
       "monadicMyZip"
       [(1, 5), (1, 6), (2, 5), (2, 6)]
       (monadicMyZip [1 :: Int, 2] [5 :: Int, 6]))

testList :: Test
testList = TestList [myZipTest, monadicMyZipTest]
