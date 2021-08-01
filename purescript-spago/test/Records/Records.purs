module Test.Records.Records where

import Prelude (Unit, (==))
import Records.Records
import Effect (Effect)
import Test.Assert (assert)
import Data.Maybe (Maybe(..))

employee :: Employee
employee = Worker {
  ssn: "132-122-4949",
  firstName: "Bob",
  middleName: (Just "Roasters"),
  lastName: "Kernel",
  addresses: ["123 Main St"]
}

main :: Effect Unit
main = do
   assert ("Hello2" == "Hello")
