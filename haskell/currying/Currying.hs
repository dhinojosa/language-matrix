-- Any function can be curried by mere supply part of the arguments

addThree :: Int -> Int -> Int -> Int
addThree x y z = x + y + z

main = do
         let addOne = addThree 1 4
         print $ (addOne 4)
