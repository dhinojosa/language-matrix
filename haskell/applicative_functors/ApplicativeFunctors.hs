import Control.Exception
import Control.Applicative -- Required for Applicatives!

-- Applicative Functors are an extension of 
-- Functors with two new methods: pure, and <*>
-- pure is the ability to convert a value into an
-- applicative, and <*> applies the a function of an
-- applicative onto another applicative.

-- The reason for applicative functors is that we cannot
-- use a functor to apply a functor with a function onto another 
-- functor:
--
-- fmap Just (5 *) Just(3) -- Will not work
-- 
-- Applicative Functors have the
-- the following definition
--
-- class (Functor f) => Applicative f where
--   pure  :: a -> f a
--   (<*>) :: f (a -> b) -> f a -> f b
-- 
-- So now we can take Applicatives (which are also functors
-- and apply one to the other!
--
-- Using a Maybe Applicative, which has the following instance implementation:
-- instance Applicative Maybe where  
--     pure = Just  
--     Nothing <*> _ = Nothing  
--     (Just f) <*> something = fmap f something 

maybeTest1 = assert ((pure 3 :: Maybe Int) == Just 3)              "Success"
maybeTest2 = assert ((Just(\x -> x + 4) <*> Nothing) == Nothing)   "Success"
maybeTest3 = assert ((Just(\x -> x + 4) <*> pure 3) == Just 7)     "Success"
maybeTest4 = assert ((pure (*) <*> Just 4 <*> Just 10) == Just 40) "Success"
maybeTest5 = assert ((pure (+) <*> Just 4 <*> Just 10) == Just 14) "Success"

-- Applicative also has another method that looks very 
-- similar to function application ($)
-- (<$>) :: (Functor f) => (a -> b) -> f a -> f b  
-- f <$> x = fmap f x  

applicativeApplyTest = assert (((* 10) <$> Just 4) == Just 40)      "Success"

-- Using the List Applicative instance implementation:
-- instance Applicative [] where  
--     pure x = [x]
--     fs <*> xs = [f x | f <- fs, x <- xs] (Note: List comprehension)

listTest1 = assert (([(+ 10), (+ 20)] <*> [1,2,3]) == [11, 12, 13, 21, 22, 23])
               "Success"
listTest2 = assert (([(*), (+)] <*> [1,2] <*> [5,4]) ==
               [5, 4, 10, 8, 6, 5, 7, 6])
                  "Success"

-- Using the Function Applicative instance implementation:
-- instance Applicative ((->) r) where  
--    pure x = (\_ -> x)  
--    f <*> g = \x -> f x (g x)   

pure2Function = (pure 4 :: ((->) r) Int) 
functionTest1 = assert ((pure2Function 4) == 4)  "Success"
functionTest2 = assert (((+) <$> (+1) <*> (*10) $ 4) == 45) "Success"
functionTest3 = assert (((\x y z -> [x,y,z]) <$> (+3) <*> (*2) <*> (/2) $ 5)
                          == [8.0, 10.0, 2.5]) "Success"

-- Note the reason why (+1) <*> (*10) by itself will not work is:
-- Given let z = (+1) <*> (*10) that will translate to (\x -> (+1) x ((*10) x))
-- Therefore: z(4) = (5 (40)), but there is no operator, and will not
-- work and result in a type error (+) <$> (+1) <*> (*10) will work because
-- (+) will be applied to the two applicatives
-- Therefore the (5 40) will be summed with (+) to return 45.
 
main = do
         putStrLn $ maybeTest1
         putStrLn $ maybeTest2
         putStrLn $ maybeTest3
         putStrLn $ maybeTest4
         putStrLn $ maybeTest5
         putStrLn $ applicativeApplyTest
         putStrLn $ listTest1
         putStrLn $ listTest2
         putStrLn $ functionTest1
         putStrLn $ functionTest2
         putStrLn $ functionTest3