module ApplicativeFunctorsSpec
  ( testList
  ) where

import           Test.HUnit

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
maybeTest1 :: Test
maybeTest1 =
  TestCase
    (assertEqual
       "Testing Pure with single number in Maybe Applicative"
       (Just 3)
       (pure 3 :: Maybe Int))

maybeTest2 :: Test
maybeTest2 =
  TestCase
    (assertEqual
       "Testing Two Applicatives where one is Nothing is should be Nothing"
       Nothing
       (Just (+ (4 :: Int)) <*> Nothing))

maybeTest3 :: Test
maybeTest3 =
  TestCase
    (assertEqual
       "Applicative that adds four is applied to a pure 3"
       (Just 7)
       (Just (+ (4 :: Int)) <*> pure 3))

maybeTest4 :: Test
maybeTest4 =
  TestCase
    (assertEqual
       "Multipart Applicative with * then applying two Justs"
       (Just 40)
       ((*) <$> Just (4 :: Int) <*> Just 10))

maybeTest5 :: Test
maybeTest5 =
  TestCase
    (assertEqual
       "Multipart Applicative with + then applying two Justs"
       (Just 14)
       ((+) <$> Just (4 :: Int) <*> Just 10))

-- Applicative also has another method that looks very
-- similar to function application ($)
-- (<$>) :: (Functor f) => (a -> b) -> f a -> f b
-- f <$> x = fmap f x
applicativeApplyTest :: Test
applicativeApplyTest =
  TestCase
    (assertEqual
       "Applicatives Apply Method"
       (Just 40)
       ((* (10 :: Int)) <$> Just 4))

-- Using the List Applicative instance implementation:
-- instance Applicative [] where
--     pure x = [x]
--     fs <*> xs = [f x | f <- fs, x <- xs] (Note: List comprehension)
listTest1 :: Test
listTest1 =
  TestCase
    (assertEqual
       "List Applicatives with single argument"
       [11, 12, 13, 21, 22, 23]
       ([(+ (10 :: Int)), (+ 20)] <*> [1, 2, 3]))

listTest2 :: Test
listTest2 =
  TestCase
    (assertEqual
       "List Applicatives with two arguments"
       [5, 4, 10, 8, 6, 5, 7, 6]
       ([(*), (+)] <*> [1 :: Int, 2] <*> [5, 4]))

-- Using the Function Applicative instance implementation:
-- instance Applicative ((->) r) where
--    pure x = (\_ -> x)
--    f <*> g = \x -> f x (g x)
pure2Function :: r -> Int
pure2Function = pure 4 :: ((->) r) Int

functionTest1 :: Test
functionTest1 =
  TestCase
    (assertEqual
       "Using an applicative with a function"
       4
       (pure2Function (4 :: Int)))

-- Note the reason why (+1) <*> (*10) by itself will not work is:
-- Given let z = (+1) <*> (*10) that will translate to (\x -> (+1) x ((*10) x))
-- Therefore: z(4) = (5 (40)), but there is no operator, and will not
-- work and result in a type error (+) <$> (+1) <*> (*10) will work because
-- (+) will be applied to the two applicatives
-- Therefore the (5 40) will be summed with (+) to return 45.
functionTest2 :: Test
functionTest2 =
  TestCase
    (assertEqual
       "Evaluating a complicated applicative"
       45
       ((+) <$> (+ (1 :: Int)) <*> (* 10) $ 4))

functionTest3 :: Test
functionTest3 =
  TestCase
    (assertEqual
       "Performing Multilayered Applicative"
       [8, 10, 2.5]
       ((\x y z -> [x, y, z]) <$> (+ (3 :: Double)) <*> (* 2) <*> (/ 2) $ 5))

testList :: Test
testList =
  TestList
    [ maybeTest1
    , maybeTest2
    , maybeTest3
    , maybeTest4
    , maybeTest5
    , applicativeApplyTest
    , listTest1
    , listTest2
    , functionTest1
    , functionTest2
    , functionTest3
    ]
