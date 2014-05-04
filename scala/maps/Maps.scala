// A map can be created with Map.apply, and since apply is magical and can be
// called without the explicit method of apply, we can just call Map object 
// with tuples of entries
{
   val myMap = Map(("MI", "Michigan"), ("OH", "Ohio"),
                   ("WI", "Wisconsin"), ("IA", "Iowa"))

   assert(myMap.size == 4)
}

// The standard way to create tuples within the map is to use the `->` infix 
// operator, see infix/InfixOperators.scala for more information on how to
// create and setup infix operators

{
   val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio",
                   "WI" -> "Wisconsin", "IA" -> "Iowa")

   assert(myMap.size == 4)
}
