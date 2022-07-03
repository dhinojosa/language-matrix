# Changelog

Notable changes to this project are documented in this file. The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

Breaking changes:

New features:

Bugfixes:

Other improvements:

## [v5.0.0](https://github.com/purescript/purescript-identity/releases/tag/v5.0.0) - 2021-02-26

Breaking changes:
- Added support for PureScript 0.14 and dropped support for all previous versions (#20)

New features:
- This package no longer depends on the `purescript-foldable-traversable` package. Relevant instances have been moved to that package. (#26)

Bugfixes:

Other improvements:
- Migrated CI to GitHub Actions and updated installation instructions to use Spago (#22)
- Added a CHANGELOG.md file and pull request template (#24, #25)
- Updated `Identity`'s `Foldable1` instance to account for changes in `Foldable1` definition (#21, #23)

## [v4.1.0](https://github.com/purescript/purescript-identity/releases/tag/v4.1.0) - 2018-10-23

- Added `Foldable1` and `Traversable1` instances
- Added instances for the `-WithIndex` classes

(@MonoidMusician)

## [v4.0.0](https://github.com/purescript/purescript-identity/releases/tag/v4.0.0) - 2018-05-23

Updated for PureScript 0.12

## [v3.1.0](https://github.com/purescript/purescript-identity/releases/tag/v3.1.0) - 2017-04-24

- Added `Eq1` and `Ord1` instances

## [v3.0.0](https://github.com/purescript/purescript-identity/releases/tag/v3.0.0) - 2017-03-26

- Updated for PureScript 0.11

## [v2.1.0](https://github.com/purescript/purescript-identity/releases/tag/v2.1.0) - 2017-03-23

- Added `Lazy` instance (@matthewleon)

## [v2.0.0](https://github.com/purescript/purescript-identity/releases/tag/v2.0.0) - 2016-10-03

- Updated dependencies

## [v1.1.0](https://github.com/purescript/purescript-identity/releases/tag/v1.1.0) - 2016-07-19

- Added instance for `Alt` (@paluh)

## [v1.0.0](https://github.com/purescript/purescript-identity/releases/tag/v1.0.0) - 2016-06-01

This release is intended for the PureScript 0.9.1 compiler and newer.

**Note**: The v1.0.0 tag is not meant to indicate the library is “finished”, the core libraries are all being bumped to this for the 0.9 compiler release so as to use semver more correctly.

## [v1.0.0-rc.2](https://github.com/purescript/purescript-identity/releases/tag/v1.0.0-rc.2) - 2016-03-27

- Updated for new `Prelude` class hierarchies

## [v1.0.0-rc.1](https://github.com/purescript/purescript-identity/releases/tag/v1.0.0-rc.1) - 2016-03-13

- Release candidate for the psc 0.8+ core libraries

## [v0.4.1](https://github.com/purescript/purescript-identity/releases/tag/v0.4.1) - 2015-11-01

- Removed unused imports

## [v0.4.0](https://github.com/purescript/purescript-identity/releases/tag/v0.4.0) - 2015-06-30

This release works with versions 0.7.\* of the PureScript compiler. It will not work with older versions. If you are using an older version, you should require an older, compatible version of this library.

## [v0.4.0-rc.1](https://github.com/purescript/purescript-identity/releases/tag/v0.4.0-rc.1) - 2015-06-07

Initial release candidate of the library intended for the 0.7 compiler.

## [v0.3.0](https://github.com/purescript/purescript-identity/releases/tag/v0.3.0) - 2015-02-21

**This release requires PureScript v0.6.8 or later**
- Updated dependencies

## [v0.2.0](https://github.com/purescript/purescript-identity/releases/tag/v0.2.0) - 2015-01-10

- Updated `purescript-foldable-traversable` dependency (@philopon)

## [v0.1.0](https://github.com/purescript/purescript-identity/releases/tag/v0.1.0) - 2014-11-01

- Initial release

