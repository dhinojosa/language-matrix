type CustomerID = String
type ReviewBody = String

class BetterReview(val customerID:CustomerID, val reviewBody:ReviewBody)

val r = new BetterReview("123300-EJ", "This is a review of a nice book")

println(r.customerID)
