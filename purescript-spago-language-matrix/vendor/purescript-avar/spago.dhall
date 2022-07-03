{ name = "avar"
, dependencies =
  [ "aff"
  , "assert"
  , "console"
  , "effect"
  , "either"
  , "exceptions"
  , "functions"
  , "maybe"
  , "psci-support"
  , "refs"
  , "transformers"
  ]
, packages = ./packages.dhall
, sources = [ "src/**/*.purs", "test/**/*.purs" ]
}
