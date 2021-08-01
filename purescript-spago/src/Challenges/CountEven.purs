module Challenges.CountEvens (countEven) where

import Data.EuclideanRing (mod, (+))
import Data.List (List(..), (:))
import Data.Eq

countEven :: List Int -> Int
countEven xs = countEvenIn xs 0

countEvenIn :: List Int -> Int -> Int
countEvenIn Nil acc = acc
countEvenIn (x:rest) acc =
  if isEven x
     then countEvenIn rest (acc + 1)
     else countEvenIn rest acc

isEven :: Int -> Boolean
isEven x = (mod x 2) == 0
