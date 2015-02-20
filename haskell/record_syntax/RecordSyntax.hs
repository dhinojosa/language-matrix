-- Using an algebraic type but with record syntax to model 
-- alternate construction, in this case
-- various ways to create an Employee, `Show` is a type class that provides an
-- automatic string descriptor.
import Data.Maybe

type FirstName = String
type LastName = String
type MiddleName = Maybe String -- including Maybe type, which is an optional type
type SSN = String
type Address = [String]

data Employee = Worker {ssn :: SSN, firstName:: FirstName, middleName :: MiddleName,
                        lastName :: LastName, addresses :: Address}
              | Supervisor {ssn :: SSN, firstName :: FirstName, middleName :: MiddleName, 
                            lastName :: LastName, addresses:: Address, 
                            employees:: [Employee]} deriving (Show)

main = do
         let johnTheWorkHorse = Worker "333-12-1200" "John" Nothing "Smith" ["1234 Amber Lane", "St. Louis", "MO"]
         let carlTheSlouch = Worker{ssn = "001-30-3032", addresses = ["803 Amber Lane", "Apt B", "Little Rock", "AR"], firstName = "Carl",
                                    middleName = (Just "Landeau"), lastName = "McInroy"}
         let bobTheBoss = Supervisor "124-55-3010" "Bob" Nothing "Ramirez" ["33 Main St.", "Skokie", "IL"] [johnTheWorkHorse, carlTheSlouch]
         putStrLn(firstName(johnTheWorkHorse))
         putStrLn(firstName(bobTheBoss))
         putStrLn(firstName(carlTheSlouch))
