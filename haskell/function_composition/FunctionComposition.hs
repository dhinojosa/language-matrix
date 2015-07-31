import Data.List (sort,zip)
import Control.Exception.Base (assert)

-- function composition composes two or more functions into one. The function
-- composition operator (.) is an infix operator that composes the functions.
-- `(f . g . h)` is the same as `(f (g (h)))`
--
-- When you use ghci you can introspect the type by typing :t (.).
-- The signature for function composition is (b -> c) -> (a -> b) -> a -> c

-- If we take reverse which is [a] -> [a]
--    (provide a list of a and get a list of a)
-- and if we take sort which has a signature [a] -> [a]
-- we can compose it giving it the signature of the composition of [a] -> [a]

rsz = (reverse . sort)
fruits = rsz ["Apple", "Orange", "Tangelo", "Apricot", "Pomegranate"]

main = do
         putStrLn (assert (fruits !! 2 == "Orange"  "Success"))

         -- the previous line can be rewritten as the following to avoid 
         -- parenthesis, see function_application/FunctionApplication.hs
         -- for details

         putStrLn $ assert $ fruits !! 2 == "Orange" "Success"
