import Control.Exception (assert)
import Control.Monad


-- See monads/Monad.hs before continuing.
-- Monads contains a bind method that is used to apply a function that
-- returns a Monad. Consider he following

monadAssert1 = assert ((Just 3 >>= (\x -> Just (show x ++ "!"))) == Just "3!") "Monad Test 1: ✓"

-- if we had another binding within another binding...

monadAssert2 = assert ((Just 3 >>= (\x -> Just "!" >>= (\y -> Just (show x ++ y)))) == Just "3!") "Monad Test 2: ✓"

-- A monad with a failure in the chain

monadAssert3 = assert ((Just 3 >>= (\x -> Nothing >>= (\y -> Just (show x ++ y)))) == Nothing) "Monad Test 3: ✓"

-- Creating a method that does what monadAssert2 does:

monadStack :: Maybe String
monadStack = Just 3 >>= (\x ->
             Just "!" >>= (\y -> 
             Just (show x ++ y)))

monadStackWithDo :: Maybe String
monadStackWithDo = do  
                     x <- Just 3  
                     y <- Just "!"  
                     Just (show x ++ y)
               
monadAssert4 = assert (monadStackWithDo == Just "3!") "Monad Test 4: ✓"

-- In a do expression everything is a monadic value
-- Pattern matching can be done monadically as well

firstChar :: Maybe Char  
firstChar = do  
              (x:xs) <- Just "hello"  
              return x  

monadAssert5 = assert (firstChar == Just 'h') "Monad Test 5: ✓"

main = do
          putStrLn $ monadAssert1
          putStrLn $ monadAssert2
          putStrLn $ monadAssert3
          putStrLn $ monadAssert4
          putStrLn $ monadAssert5

