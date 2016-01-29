import Util.Assert

myZip :: [a] -> [b] -> [(a,b)]
myZip as bs = [(x, y) | x <- as, y <- bs]

-- for comprehension are great for lists, but are underused since it
-- can only work for lists
monadicMyZip :: [a] -> [b] -> [(a,b)]
monadicMyZip as bs = do
                       a <- as
                       b <- bs
                       return (a,b)

main = do
         assertThat (myZip [1,2] [5,6]) [(1,5),(1,6),(2,5),(2,6)]
         assertThat (monadicMyZip [1,2] [5,6]) [(1,5),(1,6),(2,5),(2,6)]
