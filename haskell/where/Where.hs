import Control.Exception (assert)

-- String is a type synonym for [Char]
assertFor :: Bool -> String -> String
assertFor b s = assert b (concat ["Assertion of (", s, "): Passed"])


assertStrLn :: Bool -> String -> IO()
assertStrLn b s = putStrLn $ show $ assertFor b s

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
         assertStrLn (myMax [1,5,13,42,5,3,1,-3,100,22,10,-40] == Just 100) 
                     "myMax $ [1,5,13,42,5,3,1,-3,100,22,10,-40] == Just 100"
         assertStrLn (myMax ([] :: [Int]) == Nothing) 
                     "myMax ([] :: [Int]) == Nothing" -- Empty List of Int
         assertStrLn (myMax [1] == Just 1) 
                     "myMax [1] == Just 1"
         assertStrLn (myMax [-3,4,1] == Just 4) 
                     "myMax [-3,4,1] == Just 4"
