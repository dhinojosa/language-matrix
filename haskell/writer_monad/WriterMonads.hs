import Data.Monoid
import Control.Monad.Writer

isBigGang :: Int -> (Bool, String)
isBigGang x = (x > 9, "A pretty big gang")

-- Sample of apply log, something that takes a tuple (a, String)
-- and a function that take an and returns a (b,String), finally returns a 
-- (b,String)

-- applyLog :: (a,String) -> (a -> (b,String)) -> (b,String)  
-- applyLog (x,log) f = let (y,newLog) = f x in (y,log ++ newLog)

applyLog :: (Monoid m) => (a,m) -> (a -> (b,m)) -> (b,m)  
applyLog (x,log) f = let (y,newLog) = f x in (y,log `mappend` newLog)  

type Food = String  
type Price = Sum Int  
  
addDrink :: Food -> (Food,Price)  
addDrink "beans" = ("milk", Sum 25)  
addDrink "jerky" = ("whiskey", Sum 99)  
addDrink _ = ("beer", Sum 30)  

-- Signature for a Writer Monad 
--
-- newtype Writer w a = Writer { runWriter :: (a, w) }  
--
-- instance (Monoid w) => Monad (Writer w) where  
--     return x = Writer (x, mempty)  
--     (Writer (x,v)) >>= f = let (Writer (y, v')) = f x in Writer (y, v `mappend` v') 

logNumber :: Int -> Writer [String] Int  
logNumber x = writer (x, ["Got number: " ++ show x])  


multWithLog :: Writer [String] Int  
multWithLog = do
    a <- logNumber 3  
    b <- logNumber 5  
    return (a*b)  

multWithLogMonadic = (logNumber 3) >>= (\x ->
                     (logNumber 5) >>= (\y ->
                     return (x * y)))

-- You can tell the writer some information using the tell method which belongs to the
-- Writer Monad
-- tell :: w -> m (); where w is a monoid and m is the Monad

multWithLogWithTell :: Writer [String] Int  
multWithLogWithTell = do
    a <- logNumber 3  
    b <- logNumber 5
    tell ["Logging going into as planned"]  
    return (a*b)  

multWithLogWithTellMonadic = (logNumber 3) >>= (\x ->
                             (logNumber 5) >>= (\y ->
                             tell ["Logging going into as planned"] >>
                             return (x * y)))

main = do
         putStrLn $ show $ isBigGang 3
         putStrLn $ show $ isBigGang 11
         putStrLn $ show $ (3, "A smallish gang.") `applyLog` isBigGang
         putStrLn $ show $ ("beans", Sum 10) `applyLog` addDrink
         putStrLn $ show $ runWriter (return 3 :: Writer String Int)  
         putStrLn $ show $ runWriter (multWithLog)  
         putStrLn $ show $ runWriter (multWithLogMonadic)  
         putStrLn $ show $ runWriter (multWithLogWithTell)  
         putStrLn $ show $ runWriter (multWithLogWithTellMonadic)  

