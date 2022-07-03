module Records.Records where

import Data.Maybe
import Data.Generic.Rep (class Generic)

type FirstName = String
type LastName = String
type MiddleName = Maybe String
type SSN = String
type Address = Array String

derive instance genericEmployee :: Generic Employee _

data Employee
  = Worker
      { ssn :: SSN
      , firstName :: FirstName
      , middleName :: MiddleName
      , lastName :: LastName
      , addresses :: Address
      }
  | Supervisor
      { ssn :: SSN
      , firstName :: FirstName
      , middleName :: MiddleName
      , lastName :: LastName
      , addresses :: Address
      , employees :: Array Employee
      }
