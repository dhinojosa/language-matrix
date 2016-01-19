import Data.List (sort)  -- required to sort and perform zips
import Control.Exception.Base (assert) --required for assertions

-- Functions can declare the types that will be used as 
-- arguments.  In this case `isOdd` takes an Int type
-- and returns a `Bool` type. `/=` determines if a number value
-- is not equal

myIsOdd :: Int -> Bool
myIsOdd x = ((x `mod` 2) /= 0)

main = do
         putStrLn(show(assert (myIsOdd 3 == True)  "Success"))

         -- The following uses function application. See:
         -- functionapplication/FunctionApplication.hs for more details

         putStrLn $ show $ assert (myIsOdd 3 == True) "Success"