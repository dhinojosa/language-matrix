-- Some examples of included haskell type classes

-- Eq - a typeclass that tests for equality
-- The type class requires either one of the following methods to be implemented:
-- (==) :: a -> a -> Bool
--
-- (/=) :: a -> a -> Bool



main = do 
          putStrLn(show (5 == 5))
          putStrLn(show (4 /= 3))
          putStrLn(show ('a' == 'a'))
