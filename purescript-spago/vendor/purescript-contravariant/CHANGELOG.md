# Changelog

Notable changes to this project are documented in this file. The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

Breaking changes:

New features:

Bugfixes:

Other improvements:

## [v5.0.0](https://github.com/purescript/purescript-contravariant/releases/tag/v5.0.0) - 2021-02-26

Breaking changes:
  - Added support for PureScript 0.14 and dropped support for all previous versions (#25)

New features:

Bugfixes:

Other improvements:
  - Migrated CI to GitHub Actions and updated installation instructions to use Spago (#27)
  - Added a CHANGELOG.md file and pull request template (#28, #29)
  - This package now depends on the `purescript-const` package, and contains an instance previously in that package (#30)

## [v4.0.1](https://github.com/purescript/purescript-contravariant/releases/tag/v4.0.1) - 2019-04-27

Remove accidental self-import (@colinwahl)

## [v4.0.0](https://github.com/purescript/purescript-contravariant/releases/tag/v4.0.0) - 2018-05-23

Updated for PureScript 0.12

## [v3.3.0](https://github.com/purescript/purescript-contravariant/releases/tag/v3.3.0) - 2018-04-30

- Added `Semigroup` and `Monoid` newtype instances for `Op` (@paluh)

## [v3.2.0](https://github.com/purescript/purescript-contravariant/releases/tag/v3.2.0) - 2018-03-17

- Added `imapC` (@Thimoteus)

## [v3.1.0](https://github.com/purescript/purescript-contravariant/releases/tag/v3.1.0) - 2017-07-10

- Added `HeytingAlgebra` and `BooleanAlgebra` instances for `Predicate` (@chfi)

## [v3.0.0](https://github.com/purescript/purescript-contravariant/releases/tag/v3.0.0) - 2017-03-26

- Updated for PureScript 0.11

## [v2.0.0](https://github.com/purescript/purescript-contravariant/releases/tag/v2.0.0) - 2016-10-07

- Updated dependencies
- Fixed `>#<` to now be the flipped version of `>$<` - previously they were both accidentally aliasing `cmap`

## [v1.0.0](https://github.com/purescript/purescript-contravariant/releases/tag/v1.0.0) - 2016-06-01

This release is intended for the PureScript 0.9.1 compiler and newer.

**Note**: The v1.0.0 tag is not meant to indicate the library is “finished”, the core libraries are all being bumped to this for the 0.9 compiler release so as to use semver more correctly.

## [v1.0.0-rc.2](https://github.com/purescript/purescript-contravariant/releases/tag/v1.0.0-rc.2) - 2016-05-20

- Update for changes in the prelude

## [v1.0.0-rc.1](https://github.com/purescript/purescript-contravariant/releases/tag/v1.0.0-rc.1) - 2016-03-13

- Release candidate for the psc 0.8+ core libraries

## [v0.2.3](https://github.com/purescript/purescript-contravariant/releases/tag/v0.2.3) - 2015-11-01

- Removed unused imports

## [v0.2.2](https://github.com/purescript/purescript-contravariant/releases/tag/v0.2.2) - 2015-09-13

- Removed some unused type variables (@xuwei-k)

## [v0.2.1](https://github.com/purescript/purescript-contravariant/releases/tag/v0.2.1) - 2015-08-24

Add `Divisible` and `Decidable`.

## [v0.2.0](https://github.com/purescript/purescript-contravariant/releases/tag/v0.2.0) - 2015-06-30

This release works with versions 0.7.\* of the PureScript compiler. It will not work with older versions. If you are using an older version, you should require an older, compatible version of this library.

## [v0.2.0-rc.1](https://github.com/purescript/purescript-contravariant/releases/tag/v0.2.0-rc.1) - 2015-06-07

Initial release candidate of the library intended for the 0.7 compiler.

## [v0.1.0](https://github.com/purescript/purescript-contravariant/releases/tag/v0.1.0) - 2015-03-09

- Moved to `Data.Functor.Contravariant`
- Added `(>#<)`
- Added `Predicate`, `Equivalence`, `Comparison`

