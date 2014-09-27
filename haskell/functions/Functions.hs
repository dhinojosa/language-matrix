import Data.List (sort,zip)
import Control.Exception.Base (assert)

-- Functions can declare the types that will be used as 
-- arguments.  In this case `isOdd` takes an Int type
-- and returns a `Bool` type. `/=` determines if a number value
-- is not equal
disOdd :: Int -> Bool
disOdd x = ((x `mod` 2) /= 0)


-- function composition composes two or more functions into one. The function
-- composition operator (.) is an infix operator that composes the functions.
-- `(f . g . h)` is the same as `(f (g (h)))`

rsz = (reverse . sort)
fruits = rsz ["Apple", "Orange", "Tangelo", "Apricot", "Pomegranate"]


-- Function application ($) is an operator. Normal function application has 
-- a high precedence, the ($) operator has the lowest precedence. Normal 
-- function application is also left-associative.  Given functions `f` `g`,
-- and parameters `a` `b` `c`, `f g a b c` is the same as 
-- `f(g)(a b c)`.  Functional Application is right associative , 
-- therefore `a b c d` is `a b c))

main = do
         putStrLn (assert ((fruits !! 2) == "Orange")
                  (assert (disOdd 3 == True) "Success"))
