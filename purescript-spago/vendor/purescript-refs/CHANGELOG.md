# Changelog

Notable changes to this project are documented in this file. The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

Breaking changes:

New features:

Bugfixes:

Other improvements:

## [v5.0.0](https://github.com/purescript/purescript-refs/releases/tag/v5.0.0) - 2021-02-26

Breaking changes:
- Added support for PureScript 0.14 and dropped support for all previous versions (#29)

New features:
- Allow the construction of self-referential `Ref`s (#21)
- Add roles declarations to allow safe coercions (#29)

Bugfixes:

Other improvements:
- Add some examples and tests and update documentation (#19, #20, #31)
- Remove primes from foreign module exports in preparation for ES modules (#24)
- Remove `return {}` from FFI implementations for a small performance boost (#27) 
- Migrated CI to GitHub Actions and updated installation instructions to use Spago (#33)
- Added a changelog and pull request template (#34, #35)

## [v4.1.0](https://github.com/purescript/purescript-refs/releases/tag/v4.1.0) - 2018-05-26

- Added `modify_` - `modify` with a `Unit` return (@justinwoo)

## [v4.0.0](https://github.com/purescript/purescript-refs/releases/tag/v4.0.0) - 2018-05-22

- Updated for PureScript 0.12
- Names have been shortened to drop the `Ref` prefix for less repetition with qualified imports
- The argument order of functions has changed so the `Ref` is always in the last position

## [v3.0.0](https://github.com/purescript/purescript-refs/releases/tag/v3.0.0) - 2017-03-26

- Updated for PureScript 0.11

## [v2.0.0](https://github.com/purescript/purescript-refs/releases/tag/v2.0.0) - 2016-10-02

- Updated dependencies

## [v1.0.0](https://github.com/purescript/purescript-refs/releases/tag/v1.0.0) - 2016-06-01

This release is intended for the PureScript 0.9.1 compiler and newer.

**Note**: The v1.0.0 tag is not meant to indicate the library is “finished”, the core libraries are all being bumped to this for the 0.9 compiler release so as to use semver more correctly.

## [v0.2.0](https://github.com/purescript/purescript-refs/releases/tag/v0.2.0) - 2015-06-30

- This release works with versions 0.7.\* of the PureScript compiler. It will not work with older versions. If you are using an older version, you should require an older, compatible version of this library.

## [v0.2.0-rc.1](https://github.com/purescript/purescript-refs/releases/tag/v0.2.0-rc.1) - 2015-06-09

- Initial release candidate of the library intended for the 0.7 compiler.

## [v0.1.3](https://github.com/purescript/purescript-refs/releases/tag/v0.1.3) - 2015-03-19

- Updated docs

## [v0.1.2](https://github.com/purescript/purescript-refs/releases/tag/v0.1.2) - 2014-11-24

- Added `modifyRef` that returns a pure value (#2)

## [v0.1.1](https://github.com/purescript/purescript-refs/releases/tag/v0.1.1) - 2014-06-14

- Now uses "proper" `Unit` type instead of `{}` (garyb)

## [v0.1.0](https://github.com/purescript/purescript-refs/releases/tag/v0.1.0) - 2014-04-25

- Initial release
