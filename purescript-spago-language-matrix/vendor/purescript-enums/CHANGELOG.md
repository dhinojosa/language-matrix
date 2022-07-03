# Changelog

Notable changes to this project are documented in this file. The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

Breaking changes:

New features:

Bugfixes:

Other improvements:

## [v5.0.0](https://github.com/purescript/purescript-enums/releases/tag/v5.0.0) - 2021-02-26

Breaking changes:
- Added support for PureScript 0.14 and dropped support for all previous versions (#44)

New features:
- Absorbed `Data.Enum.Generic` from `generics-rep` (#46)

Bugfixes:

Other improvements:
- Migrated CI to GitHub Actions and updated installation instructions to use Spago (#45)
- Added a CHANGELOG.md file and pull request template (#47, #48)

## [v4.0.1](https://github.com/purescript/purescript-enums/releases/tag/v4.0.1) - 2019-01-31

* Fix stack-safety issues in `defaultCardinality`, `defaultToEnum`, and `defaultFromEnum`.

## [v4.0.0](https://github.com/purescript/purescript-enums/releases/tag/v4.0.0) - 2018-05-23

- Updated for PureScript 0.12
- Removed `Maybe`, `Either` and `Tuple` instances for `BoundedEnum` that were not law-abiding implementations
- Changed types that returned `Unfoldable` + `NonEmpty` values to instead return with `Unfoldable1`

## [v3.2.1](https://github.com/purescript/purescript-enums/releases/tag/v3.2.1) - 2017-07-29

- Fixes for `Enum` laws; see #22, #23, #32. (@jacereda)

## [v3.2.0](https://github.com/purescript/purescript-enums/releases/tag/v3.2.0) - 2017-06-11

Add `upFromIncluding` (@safareli)

## [v3.1.0](https://github.com/purescript/purescript-enums/releases/tag/v3.1.0) - 2017-06-08

- Added `genBoundedEnum`

## [v3.0.0](https://github.com/purescript/purescript-enums/releases/tag/v3.0.0) - 2017-03-26

- Updated for PureScript 0.11
- The `BoundedEnum` instance has been removed for `Int`, as it had a `cardinality` of `-1` (#25)

## [v2.0.1](https://github.com/purescript/purescript-enums/releases/tag/v2.0.1) - 2016-11-10

- Fixed stack overflow in `BoundedEnum Either` (@LiamGoodacre)
- Fixed `toEnum` for `Maybe` (@jacereda)

## [v2.0.0](https://github.com/purescript/purescript-enums/releases/tag/v2.0.0) - 2016-10-09

- Updated dependencies

## [v1.1.0](https://github.com/purescript/purescript-enums/releases/tag/v1.1.0) - 2016-08-18

- Added `toEnumWithDefaults` (@tfausak)

## [v1.0.0](https://github.com/purescript/purescript-enums/releases/tag/v1.0.0) - 2016-06-01

This release is intended for the PureScript 0.9.1 compiler and newer.

**Note**: The v1.0.0 tag is not meant to indicate the library is “finished”, the core libraries are all being bumped to this for the 0.9 compiler release so as to use semver more correctly.

## [v1.0.0-rc.1](https://github.com/purescript/purescript-enums/releases/tag/v1.0.0-rc.1) - 2016-04-02

- Release candidate for the psc 0.8+ core libraries
- Includes changes by @jbrownson for a split between `Enum` and `BoundedEnum`, so operations for both sequential types and small bounded sum types can be accomodated

## [v0.7.0](https://github.com/purescript/purescript-enums/releases/tag/v0.7.0) - 2015-08-13

- Updated dependencies

## [v0.6.0](https://github.com/purescript/purescript-enums/releases/tag/v0.6.0) - 2015-08-02

- Updated dependencies

## [v0.5.0](https://github.com/purescript/purescript-enums/releases/tag/v0.5.0) - 2015-06-30

This release works with versions 0.7.\* of the PureScript compiler. It will not work with older versions. If you are using an older version, you should require an older, compatible version of this library.

## [v0.5.0-rc.1](https://github.com/purescript/purescript-enums/releases/tag/v0.5.0-rc.1) - 2015-06-07

Initial release candidate of the library intended for the 0.7 compiler.

## [v0.4.0](https://github.com/purescript/purescript-enums/releases/tag/v0.4.0) - 2015-02-21

**This release requires PureScript v0.6.8 or later**
- Updated dependencies

## [v0.3.1](https://github.com/purescript/purescript-enums/releases/tag/v0.3.1) - 2015-02-16



## [v0.3.0](https://github.com/purescript/purescript-enums/releases/tag/v0.3.0) - 2014-12-01

- Moved `toEnum` and `fromEnum` into the `Enum` class (@NightRa)

## [v0.2.4](https://github.com/purescript/purescript-enums/releases/tag/v0.2.4) - 2014-10-31



## [v0.2.3](https://github.com/purescript/purescript-enums/releases/tag/v0.2.3) - 2014-10-18

- Add `Enum` instance for `Either` (@jdegoes)

## [v0.2.2](https://github.com/purescript/purescript-enums/releases/tag/v0.2.2) - 2014-10-16

- Add `Enum` instance for `Char` (@jdegoes)

## [v0.2.1](https://github.com/purescript/purescript-enums/releases/tag/v0.2.1) - 2014-10-14

- Export all typeclass members (@jdegoes)

## [v0.2.0](https://github.com/purescript/purescript-enums/releases/tag/v0.2.0) - 2014-10-12

Complete redesign by @jdegoes.

## [v0.1.0](https://github.com/purescript/purescript-enums/releases/tag/v0.1.0) - 2014-04-25



