module Util.Assert (
  assertStrLn,
  assertSilent,
  assertThat
) where

import Control.Exception.Base (assert)

-- String is a type synonym for [Char]
assertFor :: Bool -> String -> String
assertFor b s = assert b (concat ["Assertion of (", s, "): Passed"])


assertStrLn :: Bool -> String -> IO()
assertStrLn b s = putStrLn $ show $ assertFor b s

assertSilent :: Bool -> IO()
assertSilent b = if (b) then 
                    return () :: IO() 
                 else error "assertion failed"

assertThat :: (Show a, Eq a) => a -> a -> IO()
assertThat a e
           | b         = putStrLn $ prefixStr ++ ": Passed"
           | otherwise = putStrLn $ prefixStr ++ ": Failed"
           where b    = (a == e)
                 eStr = show $ e
                 aStr = show $ a
                 prefixStr = "Expected: " ++ eStr ++ " Actual: " ++ aStr ++ ""
