# Changelog

Notable changes to this project are documented in this file. The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

Breaking changes:

New features:

Bugfixes:

Other improvements:

## [v5.0.0](https://github.com/purescript/purescript-integers/releases/tag/v5.0.0) - 2021-02-26

Breaking changes:

- Added support for PureScript 0.14 and dropped support for all previous versions (#37)
- Replaced `globals` dependency with `numbers` (#40)

New features:

Bugfixes:
- Don't rely on inlining of `Ord Number` in `unsafeClamp` (#38)

Other improvements:

- Migrated CI to GitHub Actions and updated installation instructions to use Spago (#41)
- Added a changelog and pull request template (#44)

## [v4.0.0](https://github.com/purescript/purescript-integers/releases/tag/v4.0.0) - 2018-05-23

- Updated for PureScript 0.12
- Added `quot` and `rem` (@hdgarrood)

## [v3.2.0](https://github.com/purescript/purescript-integers/releases/tag/v3.2.0) - 2017-11-22

- Added `Semiring` up to `Field` instances for `Parity`

## [v3.1.0](https://github.com/purescript/purescript-integers/releases/tag/v3.1.0) - 2017-06-30

- Added `Parity` type for even/odd-ness of integers

## [v3.0.0](https://github.com/purescript/purescript-integers/releases/tag/v3.0.0) - 2017-03-25

- Updated for PureScript 0.11

## [v2.1.1](https://github.com/purescript/purescript-integers/releases/tag/v2.1.1) - 2017-02-18

- Updated `ceil`, `floor`, and `round` will to return 0 on `NaN` / `Infinity` inputs rather than throw a runtime error

## [v2.1.0](https://github.com/purescript/purescript-integers/releases/tag/v2.1.0) - 2016-11-19

- Added `pow`, for raising an `Int` to the power of another `Int`.

## [v2.0.0](https://github.com/purescript/purescript-integers/releases/tag/v2.0.0) - 2016-10-02

- Updated dependencies

## [v1.1.0](https://github.com/purescript/purescript-integers/releases/tag/v1.1.0) - 2016-07-30

- Added `base36` radix (@texastoland)

## [v1.0.0](https://github.com/purescript/purescript-integers/releases/tag/v1.0.0) - 2016-06-01

This release is intended for the PureScript 0.9.1 compiler and newer.

**Note**: The v1.0.0 tag is not meant to indicate the library is “finished”, the core libraries are all being bumped to this for the 0.9 compiler release so as to use semver more correctly.

- Updated `purescript-math` dependency

## [v0.2.1](https://github.com/purescript/purescript-integers/releases/tag/v0.2.1) - 2015-07-28

- Added more conversions from `Number`

## [v0.2.0](https://github.com/purescript/purescript-integers/releases/tag/v0.2.0) - 2015-06-30

This release works with versions 0.7.\* of the PureScript compiler. It will not work with older versions. If you are using an older version, you should require an older, compatible version of this library.

## [v0.1.0](https://github.com/purescript/purescript-integers/releases/tag/v0.1.0) - 2015-04-06

- Updated all integer operations to ensure the result is within the range of `Int32`
- Added `Bits` module
- The upcoming PureScript v0.6.10 will optimise `Int` arithmetic and bitwise operations, but this release is still compatible with v0.6.9.x

## [v0.0.1](https://github.com/purescript/purescript-integers/releases/tag/v0.0.1) - 2015-03-15

- Initial versioned release. The compiler currently will not optimise this library so making use of `Int` will be significantly slower than the native `Number`.
