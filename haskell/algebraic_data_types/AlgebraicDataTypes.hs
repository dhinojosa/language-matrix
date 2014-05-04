-- Using an algebraic type to model alternate construction, in this case
-- various ways to bill, `Show` is a type class that provides an
-- automatic string descriptor.

type CardHolder = String
type CardNumber = String
type Address = [String] -- Address is a list of String
type CustomerID = Int

data BillingInfo = CreditCard CardNumber CardHolder Address
                 | CashOnDelivery
                 | Invoice CustomerID
                   deriving (Show)

main = do
       let creditCard = CreditCard "3333-1233-1200" "John Doe" 
                                   ["1234 Amber Lane", "St. Louis", "MO"]
       let invoice = Invoice 10

       print creditCard
       print invoice
