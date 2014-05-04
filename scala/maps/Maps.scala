// A map can be created with Map.apply, and since apply is magical and can be
// called without the explicit method of apply, we can just call Map object 
// with tuples of entries, the keys in this case are Symbols which are 
// immutable identities that are used for things like keys


{
   val nationalLeague = Map(('Reds, "Cincinnati Reds"), 
                            ('Dodgers, "Los Angeles Dodgers"),
                            ('Braves, "Atlanta Braves"),
                            ('Astros, "Houston Astros"))

   assert(nationalLeague.size == 4)
}

// The standard way to create tuples within the map is to use the `->` infix 
// operator, see infix/InfixOperators.scala for more information on how to
// create and setup infix operators

{
   val nationalLeague = Map(('Reds -> "Cincinnati Reds"), 
                            ('Dodgers -> "Los Angeles Dodgers"),
                            ('Braves -> "Atlanta Braves"),
                            ('Astros -> "Houston Astros"))

   assert(nationalLeague.size == 4)
}
