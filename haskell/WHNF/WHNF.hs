{-
 - Copyright (c) 2017 Hinojosa, Daniel <dhinojosa@evolutionnext.com>
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

-- Normal Form - the expression is fully evaluated
-- Weak Head Normal Form - Expression is only evaluated as 
--                         necessary to reach the data constructor
--                         or a function requiring evaluation
-- If no further inputs are possible, it is still in WHNF but also NF
-- Anything that is WHNF is also NF
-- An expression cannot be in NF or WHNF if the outer most expression 
--   is not a data constructor


-- let a = (1,2)                 -- WHNF & NF

-- let b = (1, 1 + 1)            -- WHNF, not NF
-- 
-- let c = \x -> x * 10          -- WHNF, NF
-- 
-- let d = "foo" ++ "bar"        -- not WHNF, not NF
-- 
-- let e = (1, "foo" ++ "bar")   -- WHNF, not NF


-- The following shows strictness of a list

main = do 
         let lst = [1, undefined, 2] in
           print . length $ lst
