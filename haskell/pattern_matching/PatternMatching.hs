myNot True = False
myNot False = True

-- Creating an employee data type using record syntax
data Employee = Employee { 
      empId :: String
      , firstName :: String
      , lastName :: String
      , phone :: String
} deriving (Show)

-- Match on the specific elements of the Employee Data Type
matchEmployee :: Employee -> String
matchEmployee Employee {firstName = x} = x

main = let emp = Employee{empId="203", firstName="Bob", lastName="Marquez", phone="515-333-2222"}
       in putStrLn (matchEmployee )
