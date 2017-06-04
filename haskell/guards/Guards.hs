
-- Once the types can longer match it may require further 
-- analysis to determine whether something is indeed a match
-- This is called a guard.

myAbs :: (Num a, Ord a) => a -> a    -- Num typeclass has negate, Ord for comp.
myAbs a                              -- Pattern matched on the (Num a)
      | a < 0     = (-a)             -- The - here is a keyword, not a function
      | otherwise = a


-- You can also use where inside of guards

data TicketPrice = Free | Cost Float deriving (Show)

discountCalc :: (Num a, Ord a) => a -> TicketPrice
discountCalc age
             | age < 10              = Free
             | age >= 10 && age < 60 = Cost regular
             | age >= 60             = Cost senior
               where regular = 35
                     senior  = regular - (regular * 0.10)

main = do 
         putStrLn . show . myAbs        $ 10
         putStrLn . show . discountCalc $ 40
         putStrLn . show . discountCalc $ 80
