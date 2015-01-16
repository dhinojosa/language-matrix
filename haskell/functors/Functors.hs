import Control.Exception.Base (assert)

-- Functors want types that take a function of a -> b and 
-- an instance of that functor with the same type parameter
-- as the first function argument.

class Functor' fun where
   fmap' :: (a -> b) -> fun a -> fun b


-- Here f is an arbitrary function.  Maybe is an algebraic type that
-- contains two type constructors, Just or Nothing.

instance Functor' Maybe where
   fmap' f (Just x) = (Just (f x))
   fmap' _ Nothing = Nothing

-- The ($) function is called function applicator. 
-- See function-application/Function.hs

main = do
         putStrLn $ assert (fmap' (1+) (Just 4) == Just 5) "Yes"
