
-- Once the types can longer match it may require further 
-- analysis to determine whether something is indeed a match
-- This is called a guard.

myAbs :: (Num a, Ord a) => a -> a    -- Num typeclass has negate, Ord for comp.
myAbs a                              -- Pattern matched on the (Num a)
      | a < 0     = (-a)             -- The - here is a keyword, not a function
      | otherwise = a

main = do 
         putStrLn $ show $ myAbs 10
