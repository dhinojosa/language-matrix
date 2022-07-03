# Changelog

Notable changes to this project are documented in this file. The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

Breaking changes:

New features:

Bugfixes:

Other improvements:

## [v5.0.0](https://github.com/purescript/purescript-unfoldable/releases/tag/v5.0.0) - 2021-02-26

Breaking changes:
- Added support for PureScript 0.14 and dropped support for all previous versions (#29)

New features:

Bugfixes:

Other improvements:
- Migrated CI to GitHub Actions and updated installation instructions to use Spago (#30)
- Added a changelog and pull request template (#32)

## [v4.1.0](https://github.com/purescript/purescript-unfoldable/releases/tag/v4.1.0) - 2020-01-26

- Added instances for `Maybe`

## [v4.0.2](https://github.com/purescript/purescript-unfoldable/releases/tag/v4.0.2) - 2019-05-29

- Documentation improvements: give every function at least one example, and fix a couple of minor errors.

## [v4.0.1](https://github.com/purescript/purescript-unfoldable/releases/tag/v4.0.1) - 2019-05-28

- Improved documentation to clarify the relationship between `Unfoldable` and `Unfoldable1`.

## [v4.0.0](https://github.com/purescript/purescript-unfoldable/releases/tag/v4.0.0) - 2018-05-23

- Updated for PureScript 0.12
- `Unfoldable1` is now a superclass of `Unfoldable` (if a value can be unfolded from something that is possibly empty, it can certainly be unfolded from something that is not empty). This also matches the relationship of `Foldable` and `Foldable1`, albeit in reverse.

## [v3.2.0](https://github.com/purescript/purescript-unfoldable/releases/tag/v3.2.0) - 2018-04-07

- Added `Unfoldable1` class (@matthewleon, @garyb)

## [v3.1.0](https://github.com/purescript/purescript-unfoldable/releases/tag/v3.1.0) - 2017-12-10

- Added `range` for unfolding a range of integers (@matthewleon)

## [v3.0.0](https://github.com/purescript/purescript-unfoldable/releases/tag/v3.0.0) - 2017-03-26

- Updated for PureScript 0.11

## [v2.0.0](https://github.com/purescript/purescript-unfoldable/releases/tag/v2.0.0) - 2016-10-07

- Updated dependencies

## [v1.1.0](https://github.com/purescript/purescript-unfoldable/releases/tag/v1.1.0) - 2016-09-30

- Added `fromMaybe` (@eskimor)

## [v1.0.0](https://github.com/purescript/purescript-unfoldable/releases/tag/v1.0.0) - 2016-06-01

This release is intended for the PureScript 0.9.1 compiler and newer.

**Note**: The v1.0.0 tag is not meant to indicate the library is “finished”, the core libraries are all being bumped to this for the 0.9 compiler release so as to use semver more correctly.

- Removed dependency on `purescript-arrays` so as to enable a `toUnfoldable` implementation in `Data.Array`

## [v0.4.1](https://github.com/purescript/purescript-unfoldable/releases/tag/v0.4.1) - 2015-09-26

- Added `replicate`, `replicateA`, `none`, and `singleton` (@LiamGoodacre)

## [v0.4.0](https://github.com/purescript/purescript-unfoldable/releases/tag/v0.4.0) - 2015-06-30

This release works with versions 0.7.\* of the PureScript compiler. It will not work with older versions. If you are using an older version, you should require an older, compatible version of this library.

## [v0.3.2](https://github.com/purescript/purescript-unfoldable/releases/tag/v0.3.2) - 2015-03-18

- Updated docs

## [v0.3.1](https://github.com/purescript/purescript-unfoldable/releases/tag/v0.3.1) - 2015-03-17

- Updated docs

## [v0.3.0](https://github.com/purescript/purescript-unfoldable/releases/tag/v0.3.0) - 2015-02-21

**This release requires PureScript v0.6.8 or later**
- Updated dependencies

## [v0.2.0](https://github.com/purescript/purescript-unfoldable/releases/tag/v0.2.0) - 2014-11-28

- Fix arrays dependency

## [v0.1.0](https://github.com/purescript/purescript-unfoldable/releases/tag/v0.1.0) - 2014-08-27

- Initial release
