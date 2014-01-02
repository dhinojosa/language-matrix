-- Remember: Functions are values
-- A kind can be viewed as a `type` of a `type`
-- Where as a type like 3, "Foo", takeWhile (a function), has types, 
-- Types themselves have types called kinds

-- The kinds of an Int is:  `Int :: *`
-- * means that it is a concrete type

-- The kind of `Maybe` is `* -> *`
-- * -> * means that it takes a concrete type like `Int` or `String` and returns a concrete type like `Maybe Int`
--
-- The kind of `Maybe Int` is *

-- The kind of `isUpper` a function, is * eventhough the type is `Char -> Bool`

-- The kind of `Either` is `* -> * -> *`  which means Either has takes two parameter types (* -> *) to create one concrete types *

-- The kind of `Either String` is `* -> *` whichs means `Either String` takes on parameter type to create another concrete type
--

