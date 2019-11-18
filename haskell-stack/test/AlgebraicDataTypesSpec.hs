module AlgebraicDataTypesSpec (spec) where

import Data.Maybe
import Test.Hspec
import Test.Hspec.QuickCheck

type FirstName = String

type LastName = String

type MiddleName = Maybe String

-- including Maybe type,
-- which is an optional type
type SSN = String

type Address = [String]

data Employee = Worker SSN FirstName MiddleName LastName Address
              | Supervisor SSN FirstName MiddleName LastName Address [Employee]
                  deriving (Show)

-- deriving Show to
-- be able to print
-- to console
firstName :: Employee -> String
firstName (Worker _ fst _ _ _) = fst
firstName (Supervisor _ fst _ _ _ _) = fst

worker :: Employee
worker
  = Worker "333-12-1200" "John" Nothing "Smith"
      ["1234 Amber Lane", "St. Louis", "MO"]

boss :: Employee
boss
  = Supervisor "124-55-3010" "Bob" Nothing "Ramirez"
      ["33 Main St.", "Skokie", "IL"]
      [worker]

spec :: Spec
spec
  = do describe "Abstract Data Types" $
         do it "extracts information using pattern pattern matching" $
              let johnTheWorkHorse = worker
                  bobTheBoss = boss

                in firstName johnTheWorkHorse `shouldBe` "John"

