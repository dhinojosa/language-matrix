-- Type classes must be capitalized
-- Book is the value constructor
-- Int, String, and [String] are components of the type

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

-- Type synonyms
type CustomerID = Int
type ReviewBody = String

-- Another Type Class
data BetterReview = BetterReview BookInfo CustomerID ReviewBody deriving (Show)	 
	 		    
-- Creating a Book Review Type Class with other type classes and aliases
data BookReview = BookReview BookInfo CustomerID String deriving (Show)    



