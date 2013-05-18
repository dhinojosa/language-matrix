-- Type classes must be capitalized
-- Book is the value constructor
-- Int, String, and [String] are components

data BookInfo = Book Int String [String] 
                deriving (Show)

-- A different type class, Magazine which 
-- contains the same components
-- but is treated as if it is a different type
data MagazineInfo = Magazine Int String [String]
                    deriving (Show)


-- Creating a new value of BookInfo
myInfo = Book 9780135072455 "Algebra of Programming"
         ["Richard Bird", "Oege de Moor"]
	 		    
