# Changelog

Notable changes to this project are documented in this file. The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

Breaking changes:

New features:

Bugfixes:

Other improvements:

## [v5.0.0](https://github.com/purescript/purescript-bifunctors/releases/tag/v5.0.0) - 2021-02-26

Breaking changes:
  - Added support for PureScript 0.14 and dropped support for all previous versions (#16)
  - `Clown`, `Flip`, `Joker`, and `Product` have been moved to the `Data.Functors` module in the `purescript-functors` package, so that the same types can also be used as profunctors; `Product` was renamed to `Product2` (#22)
  - `Wrap` was deleted; it is expected that any instances of `Bifunctor` will be accompanied by a corresponding instance of `Functor` (#22)

New features:

Bugfixes:

Other improvements:
  - Migrated CI to GitHub Actions and updated installation instructions to use Spago (#18)
  - Added a CHANGELOG.md file and pull request template (#19, #20)
  - This package now depends on the `purescript-const`, `purescript-either`, and `purescript-tuples` packages, and contains instances previously in those packages (#22)

## [v4.0.0](https://github.com/purescript/purescript-bifunctors/releases/tag/v4.0.0) - 2018-05-23

Updated for PureScript 0.12

## [v3.0.0](https://github.com/purescript/purescript-bifunctors/releases/tag/v3.0.0) - 2017-03-25

- Updated for PureScript 0.11

## [v2.0.0](https://github.com/purescript/purescript-bifunctors/releases/tag/v2.0.0) - 2016-10-02

- Updated dependencies
- The `Product` data constructor is now called `Product` rather than `Pair`
- Added some previously absent `Eq`, `Ord`, and `Show` instances for the newtypes
- Added `Newtype` instances for the newtypes

## [v1.0.0](https://github.com/purescript/purescript-bifunctors/releases/tag/v1.0.0) - 2016-06-01

This release is intended for the PureScript 0.9.1 compiler and newer.

**Note**: The v1.0.0 tag is not meant to indicate the library is “finished”, the core libraries are all being bumped to this for the 0.9 compiler release so as to use semver more correctly.

## [v1.0.0-rc.1](https://github.com/purescript/purescript-bifunctors/releases/tag/v1.0.0-rc.1) - 2016-03-13

- Release candidate for the psc 0.8+ core libraries

## [v0.4.0](https://github.com/purescript/purescript-bifunctors/releases/tag/v0.4.0) - 2015-06-30

This release works with versions 0.7.\* of the PureScript compiler. It will not work with older versions. If you are using an older version, you should require an older, compatible version of this library.

## [v0.4.0-rc.1](https://github.com/purescript/purescript-bifunctors/releases/tag/v0.4.0-rc.1) - 2015-06-06

Initial release candidate of the library intended for the 0.7 compiler.

## [v0.3.1](https://github.com/purescript/purescript-bifunctors/releases/tag/v0.3.1) - 2015-03-18

Update docs.

## [v0.3.0](https://github.com/purescript/purescript-bifunctors/releases/tag/v0.3.0) - 2015-03-15

Bump `const` dependency.

## [v0.2.0](https://github.com/purescript/purescript-bifunctors/releases/tag/v0.2.0) - 2015-02-21

**This release requires PureScript v0.6.8 or later**
- Updated dependencies

## [v0.1.0](https://github.com/purescript/purescript-bifunctors/releases/tag/v0.1.0) - 2015-01-10

- Updated `purescript-foldable-traversable` and `purescript-const` dependencies (@garyb)

## [v0.0.6](https://github.com/purescript/purescript-bifunctors/releases/tag/v0.0.6) - 2014-10-27

- Fix `bower.json` (@garyb)

## [v0.0.5](https://github.com/purescript/purescript-bifunctors/releases/tag/v0.0.5) - 2014-10-27

- Added `Const` instance (@garyb)

## [v0.0.4](https://github.com/purescript/purescript-bifunctors/releases/tag/v0.0.4) - 2014-08-14

- Updated dependencies (@garyb)

## [v0.0.3](https://github.com/purescript/purescript-bifunctors/releases/tag/v0.0.3) - 2014-07-19

- Fixed module name for `Clown` (@DylanLukes)

## [v0.0.2](https://github.com/purescript/purescript-bifunctors/releases/tag/v0.0.2) - 2014-07-15

- Added `Clown`, `Joker`, `Flip`, `Wrap`, `Join` and `Product` (@DylanLukes)

## [v0.0.1](https://github.com/purescript/purescript-bifunctors/releases/tag/v0.0.1) - 2014-05-21



