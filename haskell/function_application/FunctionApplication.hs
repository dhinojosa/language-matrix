import Control.Exception.Base (assert) -- required to make assertions

-- There is a function in Haskell called _function application_
-- The signature for function application is:
--     ($) :: (a -> b) -> a -> b
-- It requires that given a function and the argument, the function
-- can be applied as:
--     (a -> b) $ a

multiplyBy2 :: Int -> Int
multiplyBy2 x = x * 2

-- Normal function application has a high precedence,
--    the ($) operator has the lowest precedence. 
-- Normal function application is also left-associative.  

-- Chart of operator priority in Haskell, normal function application 
-- has the highest priority of 10
--
-- Precedence | Left associative | Non-associative | Right associative
-- -------------------------------------------------------------------
--    9       | !!               |                 | .
-- -------------------------------------------------------------------
--    8       |                  |                 | ^, ^^, **
-- -------------------------------------------------------------------
--    7       | *, /, `div`,     |                 |
--            | `mod`, `rem,     |                 |
--            | `quot`           |                 |
-- -------------------------------------------------------------------
--    6       | +, -             |                 |
-- -------------------------------------------------------------------
--    5       |                  |                 | :, ++
-- -------------------------------------------------------------------
--    4       |                  | ==, /=, <, <=   |
--            |                  | >, >=, `elem`,  |
--            |                  | `notElem`       |
-- -------------------------------------------------------------------
--    3       |                  |                 | &&
-- -------------------------------------------------------------------
--    2       |                  |                 | ||
-- -------------------------------------------------------------------
--    1       | >>, >>=          |                 |
-- -------------------------------------------------------------------
--    0       |                  |                 | $, $!, `seq`

-- Note: Function application cannot be done with two parameters only one
-- as evident by the function application formula

main = do
         putStrLn $ show $ multiplyBy2 3 + 4    -- 10
         putStrLn $ show $ multiplyBy2 (3 + 4)  -- 14
         putStrLn $ show $ multiplyBy2 $ 3 + 4  -- 14 (no parenthesis necessary)
