-- Let can assign values that can be used inside the block
-- of in. Let uses pattern matching

myMax :: (Ord a) => [a] -> Maybe a
myMax [] = Nothing
myMax [x] = Just x
myMax (x:xs) = let item = x
                   Just last = myMax $ xs -- Just last is pattern matched
                                          -- where last is assigned to the
                                          -- result
               in if (item > last) then Just $ item
                  else Just $ last

main = do
         putStrLn $ show $ myMax $ [1,5,13,42,5,3,1,-3,100,22,10,-40]
         putStrLn $ show $ myMax $ ([] :: [Int]) -- Empty List of Int
         putStrLn $ show $ myMax $ [1]
         putStrLn $ show $ myMax $ [-3,4,1]
