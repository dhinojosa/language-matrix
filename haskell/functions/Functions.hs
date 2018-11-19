{-
 - Copyright (c) 2018 Hinojosa, Daniel <dhinojosa@evolutionnext.com>
 - Author: Hinojosa, Daniel <dhinojosa@evolutionnext.com>
 -
 - Permission is hereby granted, free of charge, to any person obtaining a copy of
 - this software and associated documentation files (the "Software"), to deal in
 - the Software without restriction, including without limitation the rights to
 - use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 - the Software, and to permit persons to whom the Software is furnished to do so,
 - subject to the following conditions:
 -
 - The above copyright notice and this permission notice shall be included in all
 - copies or substantial portions of the Software.
 -
 - THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 - IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 - FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 - COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 - IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 - CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 -}

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
