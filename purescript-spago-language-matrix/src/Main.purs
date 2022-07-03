module Main where

import Prelude

import Challenges.Euler (answer)
import Effect.Console (log)

main = do
  log ("The answer is " <> show answer)
