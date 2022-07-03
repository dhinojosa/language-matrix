{-
Welcome to a Spago project!
You can edit this file as you like.
-}
{ name = "purescript-spago-language-matrix"
, dependencies =
  [ "assert"
  , "console"
  , "datetime"
  , "effect"
  , "foldable-traversable"
  , "integers"
  , "lists"
  , "psci-support"
  , "spec"
  , "strings"
  ]
, packages = ./packages.dhall
, sources = [ "src/**/*.purs", "test/**/*.purs" ]
}
