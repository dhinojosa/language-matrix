-- Normal Form - the expression is fully evaluated
-- Weak Head Normal Form - Expression is only evaluated as 
--                         necessary to reach the data constructor
--                         or a function requiring evaluation
-- If no further inputs are possible, it is still in WHNF but also NF
-- Anything that is WHNF is also NF


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
