-- Some examples of included haskell type classes

-- Eq - a typeclass that tests for equality
-- The type class requires either one of the following methods to be implemented:
-- (==) :: a -> a -> Bool
--
-- (/=) :: a -> a -> Bool


data Tuple3 a b c = Tuple3 a b c deriving (Show) -- Show is a type class

data Tuple2 a b = Tuple2 a b deriving (Show, Eq) -- Ensuring Tuple2 has equality

-- If we wish not to derive an Eq, we can certainly declare it
instance (Eq a, Eq b, Eq c) => Eq (Tuple3 a b c) where
   (Tuple3 a b c) == (Tuple3 x y z) = (a == x) && (b == y) && (c == z)

class Compatible comp where
   isCompatible :: comp -> comp -> Bool

instance (Eq a) => Compatible (Maybe a)  where
   isCompatible Nothing Nothing = True
   isCompatible (Just _) Nothing = False
   isCompatible Nothing (Just _) = False
   isCompatible (Just x) (Just y) = x == y

-- A Standard functor implementation, called Functor prime
class Functor' f where
    fmap' :: (a -> b) -> f a -> f b

-- An instance of the Function' type class
instance Functor' [] where
    -- fmap' f xs = map f xs
    -- can also be written as
    fmap' = map

class Indexable idx where
   first :: idx a -> a

-- Seems that we are declaring Tuple2 a to be negligible when evaluated, therefore
-- we are unable to extract a from the pattern match.  The solution is to use Haskell
-- extensions choose which to extract
instance Indexable (Tuple2 a) where
   first (Tuple2 a b) = b -- Cannot do a, since that is not considered part of the 
                          -- Pattern match

instance Indexable (Tuple3 a b) where
   first (Tuple3 a b c) = c -- Cannot do a or b, since that too is not a part of the
                            -- Pattern match

-- This works great since this requires a type with two parameters
class Swappable swp where
   swap :: swp a b -> swp b a

instance Swappable Tuple2 where
   swap (Tuple2 a b) = Tuple2 b a

main = do
          putStrLn(show (5 == 5))
          putStrLn(show (4 /= 3))
          putStrLn(show ('a' == 'a'))
          putStrLn . show $ isCompatible (Just 3) (Just 4)
          putStrLn . show $ fmap' (\x -> x + 1) [1,2,3]
          putStrLn . show $ Tuple2 1.0 "One" == Tuple2 1.0 "One"
          putStrLn . show $ Tuple3 1 1.0 "One" == Tuple3 1 1.0 "One"
          putStrLn . show . swap $ Tuple2 1.0 "One"
          putStrLn . show . first $ Tuple2 1.0 "One" -- Does not work as expected
          putStrLn . show . first $ Tuple3 1 1.0 "One" -- Does not work as expected
