module RecordSyntaxSpec
  ( testList
  ) where

import           Control.Exception.Base (assert)

-- Using an algebraic type but with record syntax to avoid creating pattern
-- matching to get information from the type. In this case various ways to
-- create an Employee with functions to obtain items.
--
-- `Show` is a type class that provides an automatic string descriptor.
-- This is the same example from algebraic_data_types/AlgebraicDataTypes.hs
-- but simplified

import           Data.Maybe
import           Test.HUnit
import           Test.HUnit.Text

type FirstName = String

type LastName = String

type MiddleName = Maybe String -- including Maybe type, which is an optional type

type SSN = String

type Address = [String]

data Employee
  = Worker
      { ssn        :: SSN
      , firstName  :: FirstName
      , middleName :: MiddleName
      , lastName   :: LastName
      , addresses  :: Address
      }
  | Supervisor
      { ssn        :: SSN
      , firstName  :: FirstName
      , middleName :: MiddleName
      , lastName   :: LastName
      , addresses  :: Address
      , employees  :: [Employee]
      }
  deriving (Show)

johnTheWorkHorse :: Employee
johnTheWorkHorse =
  Worker
    "333-12-1200"
    "John"
    Nothing
    "Smith"
    ["1234 Amber Lane", "St. Louis", "MO"]

carlTheSlouch :: Employee
carlTheSlouch =
  Worker
    { ssn = "001-30-3032"
    , addresses = ["803 Amber Lane", "Apt B", "Little Rock", "AR"]
    , firstName = "Carl"
    , middleName = (Just "Landeau")
    , lastName = "McInroy"
    }

bobTheBoss :: Employee
bobTheBoss =
  Supervisor
    "124-55-3010"
    "Bob"
    Nothing
    "Ramirez"
    ["33 Main St.", "Skokie", "IL"]
    [johnTheWorkHorse, carlTheSlouch]

testBobIsBob :: Test
testBobIsBob = TestCase (assertEqual "Bob is Bob" "Bob" (firstName bobTheBoss))

testCarlIsCarl :: Test
testCarlIsCarl =
  TestCase (assertEqual "Carl is Carl" "Carl" (firstName carlTheSlouch))

testList :: Test
testList = TestList [testBobIsBob, testCarlIsCarl]
