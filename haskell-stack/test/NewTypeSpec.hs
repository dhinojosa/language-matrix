module NewTypeSpec
  ( testList
  ) where

import           Test.HUnit

-- Establishing data for Human
data Human =
  Human
    { firstName :: String
    , lastName  :: String
    }

-- We can then use a type alias to give it another alias
-- for the _same type_
type Canadian = Human

-- Here we are applying a Canadian to a function
-- but this function can also send a Human (see main function)
fullName :: Canadian -> String
fullName x = firstName x ++ " " ++ lastName x

-- To create a whole new different type on the type system you
-- can use data as a wrapper with a caveat,
-- data is strict and not lazy.
data Romanian =
  Romanian
    { romanian2Human :: Human
    }

makeRomanian :: String -> String -> Romanian
makeRomanian x y = Romanian (Human x y)

-- To Create a wholly different type with it's own type
-- constructor use newtype instead of data.  newtype is
-- lazy and the constructor will not be called until it is evaluated
newtype Bulgarian =
  Bulgarian
    { bulgarian2Human :: Human
    }

makeBulgarian :: String -> String -> Bulgarian
makeBulgarian x y = Bulgarian (Human x y)

usePatternMatchingB :: Bulgarian -> String
usePatternMatchingB (Bulgarian _) = "Got a Bulgarian"

usePatternMatchingR :: Romanian -> String
usePatternMatchingR (Romanian _) = "Got a Romanian"

testGettingFullName :: Test
testGettingFullName =
  TestCase
    (assertEqual
       "Test Getting a Full Name"
       "Jimmie Cleese"
       (fullName (Human "Jimmie" "Cleese")))

testUsingPatternMatchingBulgarian :: Test
testUsingPatternMatchingBulgarian =
  TestCase
    (assertEqual
       "Test Pattern Matching a Bugarian"
       "Got a Bulgarian"
       (usePatternMatchingB (makeBulgarian "Jim" "Flask")))

testUsingPatternMatchingRomanian :: Test
testUsingPatternMatchingRomanian =
  TestCase
    (assertEqual
       "Test Pattern Matching a Romanian"
       "Got a Romanian"
       (usePatternMatchingR (makeRomanian "Jim" "Flask")))

testUsingPatternMatchingUndefined :: Test
testUsingPatternMatchingUndefined =
  TestCase
    (assertEqual
       "Test Pattern Matching an undefined"
       "Got a Bulgarian"
       (usePatternMatchingB undefined))

testList :: Test
testList =
  TestList
    [ testGettingFullName
    , testUsingPatternMatchingBulgarian
    , testUsingPatternMatchingRomanian
    , testUsingPatternMatchingUndefined
    ]
