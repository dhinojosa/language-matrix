-- The format for a case expression is the following
-- where `pattern` is a pattern match
-- case expression of pattern -> result
--                    pattern -> result
--                    pattern -> result

import Util.Assert -- customized library for assertions

-- where can be used much like let and where and with pattern matching
-- compare and contrast with let/Let.hs, and where/Where.hs

myMax :: (Ord a) => [a] -> Maybe a
myMax xs  = case xs of []  -> Nothing
                       [x] -> Just x
                       (x:rest) -> case (myMax $ rest) of
                            Nothing -> (Just x)
                            Just a  -> if (a > x) then (Just a)
                                       else (Just x)

main = do
         assertThat (myMax [1,5,13,42,5,3,1,-3,100,22,10,-40]) (Just 100)
         assertThat (myMax ([] :: [Int])) Nothing
         assertThat (myMax [1]) (Just 1)
         assertThat (myMax [-3,4,1]) (Just 4)