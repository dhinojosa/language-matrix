module Test.Records.Records (recordSpec) where

import Prelude (Unit, (==), ($), pure, unit)
import Records.Records
import Effect
import Test.Assert (assert)
import Data.Maybe (Maybe(..))
import Effect (Effect)
import Effect.Aff (launchAff_, delay)
import Test.Spec (pending, describe, it)
import Test.Spec.Assertions (shouldEqual)
import Test.Spec.Reporter.Console (consoleReporter)
import Test.Spec.Runner (runSpec)

employee :: Employee
employee = Worker{
  ssn: "132-122-4949",
  firstName: "Bob",
  middleName: (Just "Roasters"),
  lastName: "Kernel",
  addresses: ["123 Main St"]
}

recordSpec =
   describe "A record is a structure with data" do
      it "can be accessed" do
         (firstName employee) `shouldEqual` "Bob"
