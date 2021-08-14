# Changelog

Notable changes to this project are documented in this file. The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

Breaking changes:

New features:

Bugfixes:

Other improvements:

## [v3.0.0](https://github.com/purescript/purescript-gen/releases/tag/v3.0.0) - 2021-02-26

Breaking changes:
- Added support for PureScript 0.14 and dropped support for all previous versions (#26)

New features:

Bugfixes:
- Make `elements` test no longer hang at cost of possible false negative (#29)
- Fixed `fromIndex` internal helper in tests (#23)

Other improvements:
- Refer people to the `quickcheck` package's `Gen` type as a default implementation for `MonadGen` (#25)
- Restored frequency tests (#28)
- Migrated CI to GitHub Actions and updated installation instructions to use Spago (#30)
- Added a changelog and pull request template (#31, #32)

## [v2.1.1](https://github.com/purescript/purescript-gen/releases/tag/v2.1.1) - 2019-04-29

- Fixed `unfoldable` looping forever when `size` is `< 0`
- Fixed `genNonEmpty` reducing the size below `0`

## [v2.1.0](https://github.com/purescript/purescript-gen/releases/tag/v2.1.0) - 2018-06-22

- Added `genEither'` and `genMaybe'` that take a bias parameter to alter `Left/Right` and `Just/Nothing` frequency

## [v2.0.0](https://github.com/purescript/purescript-gen/releases/tag/v2.0.0) - 2018-05-23

- Updated for PureScript 0.12

## [v1.3.1](https://github.com/purescript/purescript-gen/releases/tag/v1.3.1) - 2018-02-26

- Export `filtered` function (@safareli)

## [v1.3.0](https://github.com/purescript/purescript-gen/releases/tag/v1.3.0) - 2018-02-25

- Generalized generators to take `Foldable1` inputs where `NonEmpty` was required previously (@matthewleon)

## [v1.2.1](https://github.com/purescript/purescript-gen/releases/tag/v1.2.1) - 2018-02-25

- Fix warnings (@matthewleon)

## [v1.2.0](https://github.com/purescript/purescript-gen/releases/tag/v1.2.0) - 2018-02-23

- Added `filtered` (like `suchThat` but filters based on `Maybe` rather than a predicate) (@safareli)

## [v1.1.1](https://github.com/purescript/purescript-gen/releases/tag/v1.1.1) - 2017-11-09

- Fixed behaviour of `frequency` (@safareli)

## [v1.1.0](https://github.com/purescript/purescript-gen/releases/tag/v1.1.0) - 2017-04-08

- Added `genNonEmpty`

## [v1.0.0](https://github.com/purescript/purescript-gen/releases/tag/v1.0.0) - 2017-04-04

- Initial release
