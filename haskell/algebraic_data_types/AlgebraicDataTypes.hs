-- Using an algebraic type to model alternate construction, in this case
-- various ways to bill, `Show` is a type class that provides an
-- automatic string descriptor, see 

import Data.Maybe

type FirstName = String
type LastName = String
type MiddleName = Maybe String -- including Maybe type, which is an optional type
type SSN = String
type Address = [String]

data Employee = Worker SSN FirstName MiddleName LastName Address
              | Supervisor SSN FirstName MiddleName LastName 
                Address [Employee] deriving (Show) -- deriving Show to 
                                                   -- be able to print
                                                   -- to console

-- Using pattern matching, pattern_matching/PatternMatching.hs for more detail

firstName :: Employee -> String
firstName (Worker _ fst _ _ _)  = fst
firstName (Supervisor _ fst _ _ _ _) = fst

main = do
         let johnTheWorkHorse = Worker "333-12-1200" "John" Nothing 
                                "Smith" ["1234 Amber Lane", "St. Louis", "MO"]
         let bobTheBoss = Supervisor "124-55-3010" "Bob" Nothing "Ramirez" 
                                ["33 Main St.", "Skokie", "IL"] [johnTheWorkHorse]
 
         putStrLn(firstName(johnTheWorkHorse))
         putStrLn(firstName(bobTheBoss))

         -- Using function application to simplify, see function_application/FunctionApplication.hs
         putStrLn $ firstName $ johnTheWorkHorse
         putStrLn $ firstName $ bobTheBoss
