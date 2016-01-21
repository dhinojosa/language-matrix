import Util.Assert -- customized library for assertions

-- where can be used much like let and with pattern matching
-- compare and contrast with let/Let.hs

myMax :: (Ord a) => [a] -> Maybe a
myMax [] = Nothing
myMax [x] = Just x
myMax (x:xs) 
      | item > last = Just $ item
      | otherwise   = Just $ last
      where item = x
            Just last = myMax $ xs -- Pattern matched here

main = do
         assertThat (myMax [1,5,13,42,5,3,1,-3,100,22,10,-40]) (Just 100) 
         assertThat (myMax ([] :: [Int])) Nothing 
         assertThat (myMax [1]) (Just 1) 
         assertThat (myMax [-3,4,1]) (Just 4)
