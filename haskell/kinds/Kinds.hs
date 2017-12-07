{-
 - Copyright (c) 2017 Hinojosa, Daniel <dhinojosa@evolutionnext.com>
 - Author: Hinojosa, Daniel <dhinojosa@evolutionnext.com>
 -
 - Permission is hereby granted, free of charge, to any person obtaining a copy of
 - this software and associated documentation files (the "Software"), to deal in
 - the Software without restriction, including without limitation the rights to
 - use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 - the Software, and to permit persons to whom the Software is furnished to do so,
 - subject to the following conditions:
 -
 - The above copyright notice and this permission notice shall be included in all
 - copies or substantial portions of the Software.
 -
 - THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 - IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 - FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 - COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 - IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 - CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 -}

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

