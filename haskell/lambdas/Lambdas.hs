import Control.Exception.Base (assert) -- required to make assertions

-- Lambdas are anonymous functions
-- They use the \ symbol since it looks like a
-- a lambda symbol (λ).  Lambdas can often be avoided
-- by using partial application.

xs = [1,2,3,4,5]

main = do
          putStrLn $ show $ map (\x -> x + 1) xs

          -- The following uses partial application
          -- see haskell/partial_application for more
          -- on partial application

          putStrLn $ show $ map (+1) xs

          putStrLn $ show $ assert (map (+3) xs == [4, 5, 6, 7, 8]) $ True

