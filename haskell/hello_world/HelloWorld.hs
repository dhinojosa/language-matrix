-- main is the function that starts of a program at run time
-- putStrLn writes to the console.  What is going on is that main 
-- is an IO Monad, see monads/Monad.hs.  To simplify, all lines inside 
-- an IO Monad are a series of flat maps (called bind in haskell) and maps to emulate 
-- imperative programming.

main = putStrLn "Hello, World!"
