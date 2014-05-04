-- Functors want types that take on one parameter types: `* -> *`

class Functor' f where
   fmap' :: (a -> b) -> f a -> f b

instance Functor' Maybe where
   fmap' f (Just x) = (Just (f x))
   fmap' _ Nothing = Nothing

-- Creating an employee data type using record syntax
data Employee { id :: String
              , firstName :: String
              , lastName :: String
              , phone :: String
              } deriving (Show)
