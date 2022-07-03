# Changelog

Notable changes to this project are documented in this file. The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

Breaking changes:

New features:

Bugfixes:

Other improvements:

## [v5.0.0](https://github.com/purescript/purescript-console/releases/tag/v5.0.0) - 2021-02-26

Breaking changes:
  - Added support for PureScript 0.14 and dropped support for all previous versions (#30)

New features:

Bugfixes:

Other improvements:
  - Migrated CI to GitHub Actions and updated installation instructions to use Spago (#32)
  - Added a CHANGELOG.md file and pull request template (#33, #34)
  - Removed `return {}` from FFI functions for a small performance boost (#30)

## [v4.4.0](https://github.com/purescript/purescript-console/releases/tag/v4.4.0) - 2020-01-26

Added `clear` (@iarthstar)

## [v4.3.0](https://github.com/purescript/purescript-console/releases/tag/v4.3.0) - 2019-12-07

Added `timeLog` (@matoruru)

## [v4.2.0](https://github.com/purescript/purescript-console/releases/tag/v4.2.0) - 2018-11-11

- Added `time` and `timeEnd` (@fehrenbach)

## [v4.1.0](https://github.com/purescript/purescript-console/releases/tag/v4.1.0) - 2018-05-24

- Added `Effect.Class.Console`, the console functions lifted for `MonadEffect` (@justinwoo)

## [v4.0.0](https://github.com/purescript/purescript-console/releases/tag/v4.0.0) - 2018-05-22

Updated for PureScript 0.12

## [v3.0.0](https://github.com/purescript/purescript-console/releases/tag/v3.0.0) - 2017-03-25

- Updated for PureScript 0.11

## [v2.0.0](https://github.com/purescript/purescript-console/releases/tag/v2.0.0) - 2016-10-02

- Updated dependencies

## [v1.0.0](https://github.com/purescript/purescript-console/releases/tag/v1.0.0) - 2016-06-01

This release is intended for the PureScript 0.9.1 compiler and newer.

**Note**: The v1.0.0 tag is not meant to indicate the library is “finished”, the core libraries are all being bumped to this for the 0.9 compiler release so as to use semver more correctly.

## [v1.0.0-rc.1](https://github.com/purescript/purescript-console/releases/tag/v1.0.0-rc.1) - 2016-03-13

- Release candidate for the psc 0.8+ core libraries

## [v0.1.1](https://github.com/purescript/purescript-console/releases/tag/v0.1.1) - 2015-08-20

Add `logAny` and `errorAny` (@zudov)

## [v0.1.0](https://github.com/purescript/purescript-console/releases/tag/v0.1.0) - 2015-06-30

This release works with versions 0.7.\* of the PureScript compiler. It will not work with older versions. If you are using an older version, you should require an older, compatible version of this library.

## [v0.1.0-rc.1](https://github.com/purescript/purescript-console/releases/tag/v0.1.0-rc.1) - 2015-06-06

Initial release candidate.

