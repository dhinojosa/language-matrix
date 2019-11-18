module PatternMatchingSpec where

import Test.Hspec
import Test.Hspec.QuickCheck

-- Creating an employee data type using record syntax
data Employee = Employee{empId :: String, firstName :: String,
                         lastName :: String, phone :: String}
                  deriving (Show)

-- Match on the specific elements of the Employee Data Type
matchEmployee :: Employee -> String
matchEmployee Employee{firstName = x} = x

testEmployee :: Employee
testEmployee
  = Employee{empId = "203", firstName = "Bob", lastName = "Marquez",
             phone = "515-333-2222"}

spec :: Spec
spec
  = do describe "Pattern Matching in Haskell" $
         do it "can destructure elements from with the data type" $
              matchEmployee testEmployee `shouldBe` ("Bob" :: String)

