module DeriveSpec
  ( testList
  ) where

import Test.HUnit

-- Automatic deriving is baked into the Haskell spec, and
-- every compiler can choose to implement it in its own way.
--
-- The only classes in the Prelude for which derived instances
-- are allowed are Eq, Ord, Enum, Bounded, Show, and Read...
-- data cx => T u1 ... uk  =  K1 t11 ... t1k1 | ...| Kn tn1 ... tnkn
--       deriving (C1, ..., Cm)
--
-- The following data declaration will automatically create an
-- equality instance implementation
data Employee =
  Employee
    { firstName :: String
    , lastName :: String
    }
  deriving (Eq)

-- The following data declaration sets up equality without using Eq but setting
-- up our own typeclass
data Book =
  Book
    { isbn :: String
    , author :: String
    , title :: String
    , chapters :: Int
    }

-- Instantiating the type class for Book, since it is not declared with
-- `deriving (Eq)`
instance Eq Book where
  a == b = isbn a == isbn b

deriveTest :: Test
deriveTest =
  let ceo = Employee "Larry" "Brin"
      someGuyNamedLarry = Employee "Larry" "Brin"
   in TestCase (assertEqual "deriveTest" "Larry" (firstName ceo))

deriveEquality :: [Test]
deriveEquality =
  let book = Book "9788498722734" "Harper Lee" "To Kill a Mockingbird" 32
      sameBook = Book "9788498722734" "Harper Lee" "To Kill a Mockingbird" 32
      sameBookDifferentISBN =
        Book "9783499142819" "Harper Lee" "To Kill a Mockingbird" 32
   in [ TestCase (assertEqual "Equality" True (book == sameBook))
      , TestCase (assertEqual "Non Equality" False (book == sameBookDifferentISBN))
      ]

testList :: Test
testList = TestList $ deriveEquality ++ [deriveTest]
