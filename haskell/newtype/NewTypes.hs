import Control.Exception.Base (evaluate,assert)


-- First we start off with an Algebraic Data Type. 
-- See record_syntax/RecordSyntax.hs and 
-- algebraic_data_types/AlgebraicDataTypes.hs
-- for more information

data Human = Human { firstName :: String, lastName :: String }

-- We can then use a type alias to give it another alias
-- for the _same type_

type Canadian = Human

-- Here we are applying a Canadian to a function
-- but this function can also send a Human (see main function)

fullName :: Canadian -> String
fullName x = (firstName x) ++ " " ++ (lastName x)

-- To create a whole new different type on the type system you
-- can use data as a wrapper with a caveat, 
-- data is strict and not lazy.

data Romanian = Romanian {romanian2Human :: Human}

makeRomanian :: String -> String -> Romanian
makeRomanian x y = Romanian (Human x y)

-- To Create a wholly different type with it's own type 
-- constructor use newtype instead of data.  newtype is
-- lazy and the constructor will not be called until it is evaluated

newtype Bulgarian = Bulgarian {bulgarian2Human :: Human}

makeBulgarian :: String -> String -> Bulgarian
makeBulgarian x y = Bulgarian (Human x y)

usePatternMatchingB :: Bulgarian -> String
usePatternMatchingB (Bulgarian _) = "Got a Bulgarian"

usePatternMatchingR :: Romanian -> String
usePatternMatchingR (Romanian _) = "Got a Romanian"

main :: IO ()
main = do
         putStrLn $ assert ((fullName (Human "Jimmie" "Cleese")) == "Jimmie Cleese") "Assertion 1 passed: ✓"
         putStrLn $ assert ((usePatternMatchingB $ (makeBulgarian "Jim" "Flask")) == "Got a Bulgarian") "Assertion 2 passed: ✓"
         putStrLn $ assert ((usePatternMatchingR $ (makeRomanian "Jim" "Flask")) == "Got a Romanian") "Assertion 3 passes: ✓"
         putStrLn $ assert ((usePatternMatchingB $ undefined) == "Got a Bulgarian") "Assertion 4 passes: ✓"
         -- (usePatternMatchingR $ undefined) will return undefined.
