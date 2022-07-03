# Changelog

Notable changes to this project are documented in this file. The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

Breaking changes:

New features:

Bugfixes:

Other improvements:

## [v5.0.0](https://github.com/purescript/purescript-exceptions/releases/tag/v5.0.0) - 2021-02-26

Breaking changes:
- Added support for PureScript 0.14 and dropped support for all previous versions (#36)

New features:

Bugfixes:
- Fixed `catchException` example to use `Console.logShow` instead of `print` (#31)

Other improvements:
- Migrated CI to GitHub Actions and updated installation instructions to use Spago (#37)
- Added a CHANGELOG.md file and pull request template (#38, #39)
- Removed unnecessary type variable from `try` docstring (#33)

## [v4.0.0](https://github.com/purescript/purescript-exceptions/releases/tag/v4.0.0) - 2018-05-23

Updated for PureScript 0.12

## [v3.1.0](https://github.com/purescript/purescript-exceptions/releases/tag/v3.1.0) - 2017-07-27

Add `name` function to extract the name of an `Error` (@KtorZ)

## [v3.0.0](https://github.com/purescript/purescript-exceptions/releases/tag/v3.0.0) - 2017-03-26

- Updated for PureScript 0.11
- The `err :: EXCEPTION` row entry has been corrected to `exception :: EXCEPTION`

## [v2.0.0](https://github.com/purescript/purescript-exceptions/releases/tag/v2.0.0) - 2016-10-07

- Updated dependencies

## [v1.0.0](https://github.com/purescript/purescript-exceptions/releases/tag/v1.0.0) - 2016-06-01

This release is intended for the PureScript 0.9.1 compiler and newer.

**Note**: The v1.0.0 tag is not meant to indicate the library is “finished”, the core libraries are all being bumped to this for the 0.9 compiler release so as to use semver more correctly.

## [v1.0.0-rc.1](https://github.com/purescript/purescript-exceptions/releases/tag/v1.0.0-rc.1) - 2016-03-16

- Release candidate for the psc 0.8+ core libraries

## [v0.3.4](https://github.com/purescript/purescript-exceptions/releases/tag/v0.3.4) - 2015-12-23

- Add `stack` error message accessor (@hdgarrood)

## [v0.3.3](https://github.com/purescript/purescript-exceptions/releases/tag/v0.3.3) - 2015-12-11

Add `throw` (@hdgarrood)

## [v0.3.2](https://github.com/purescript/purescript-exceptions/releases/tag/v0.3.2) - 2015-11-20

- Removed unused import (@tfausak)

## [v0.3.1](https://github.com/purescript/purescript-exceptions/releases/tag/v0.3.1) - 2015-11-13

Added `Unsafe` module (@hdgarrood)

## [v0.3.0](https://github.com/purescript/purescript-exceptions/releases/tag/v0.3.0) - 2015-06-30

This release works with versions 0.7.\* of the PureScript compiler. It will not work with older versions. If you are using an older version, you should require an older, compatible version of this library.

## [v0.3.0-rc.1](https://github.com/purescript/purescript-exceptions/releases/tag/v0.3.0-rc.1) - 2015-06-09

Initial release candidate of the library intended for the 0.7 compiler.

## [v0.2.3](https://github.com/purescript/purescript-exceptions/releases/tag/v0.2.3) - 2015-03-20

Updated docs

## [v0.2.2](https://github.com/purescript/purescript-exceptions/releases/tag/v0.2.2) - 2014-11-16

Improvements to FFI code (@davidchambers)

## [v0.2.1](https://github.com/purescript/purescript-exceptions/releases/tag/v0.2.1) - 2014-09-04

Handle errors from other JS domains (@joneshf)

## [v0.2.0](https://github.com/purescript/purescript-exceptions/releases/tag/v0.2.0) - 2014-08-07



## [v0.1.0](https://github.com/purescript/purescript-exceptions/releases/tag/v0.1.0) - 2014-04-25



