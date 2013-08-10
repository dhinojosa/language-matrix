module Main(
  main
) where 
--The () of the module means that it exposes nothing

import SimpleJSON

main = print (JObject [("foo", JNumber 1), ("bar", JBool False)])
