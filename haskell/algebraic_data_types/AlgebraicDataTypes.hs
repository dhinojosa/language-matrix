-- An algebraic data type can have more than one value constructors
data Bool = True | False

-- Using an algebraic type to model alternate construction, in this case various ways to bill
type CardHolder = String
type CardNumber = String
type Address = [String]
type CustomerID = Int

data BillingInfo = CreditCard CardNumber CardHolder Address
                 | CashOnDelivery
                 | Invoice CustomerID
                   deriving (Show)

