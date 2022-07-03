# Changelog

Notable changes to this project are documented in this file. The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

Breaking changes:

New features:

Bugfixes:

Other improvements:

## [v6.0.0](https://github.com/purescript/purescript-nonempty/releases/tag/v6.0.0) - 2021-02-26

Breaking changes:
- Added support for PureScript 0.14 and dropped support for all previous versions (#38, #44)

New features:

Bugfixes:

Other improvements:
- Fixed `Foldable1 (NonEmpty f)` instance, as `Foldable1` now has `foldr1` and `foldl1` as members (#39)
- Deprecated monomorphic `foldl1`, suggesting the polymorphic `foldl1` from `Data.Semigroup.Foldable` instead (#42)
- Added examples (#36)
- Migrated CI to GitHub Actions and updated installation instructions to use Spago (#43)
- Added a changelog and pull request template (#46)

## [v5.0.0](https://github.com/purescript/purescript-nonempty/releases/tag/v5.0.0) - 2018-05-23

- Updated for PureScript 0.12
- Removed monomorphic versions of `Foldable1` functions

## [v4.3.0](https://github.com/purescript/purescript-nonempty/releases/tag/v4.3.0) - 2018-05-13

- Added `Unfoldable1` instance

## [v4.2.0](https://github.com/purescript/purescript-nonempty/releases/tag/v4.2.0) - 2018-02-25

- Added `Foldable1` instance (@matthewleon)

## [v4.1.1](https://github.com/purescript/purescript-nonempty/releases/tag/v4.1.1) - 2017-11-21

- Bumped minimum version of `purescript-foldable-traversable` (non-breaking) (@anttih)

## [v4.1.0](https://github.com/purescript/purescript-nonempty/releases/tag/v4.1.0) - 2017-11-21

- Added `FunctorWithIndex`, `FoldableWithIndex`, `TraversableWithIndex` instances (@matthewleon, @safareli)

## [v4.0.0](https://github.com/purescript/purescript-nonempty/releases/tag/v4.0.0) - 2017-03-26

- Updated for PureScript 0.11

## [v3.0.0](https://github.com/purescript/purescript-nonempty/releases/tag/v3.0.0) - 2016-10-09

- Removed generics dependency for rearranged hierarchy

## [v2.0.0](https://github.com/purescript/purescript-nonempty/releases/tag/v2.0.0) - 2016-10-09

- Updated dependencies

## [v1.1.0](https://github.com/purescript/purescript-nonempty/releases/tag/v1.1.0) - 2016-07-01

- Added `Generic` instance

## [v1.0.0](https://github.com/purescript/purescript-nonempty/releases/tag/v1.0.0) - 2016-06-02

- Updated for 1.0 core libraries

## [v0.2.0](https://github.com/purescript/purescript-nonempty/releases/tag/v0.2.0) - 2016-01-31

- Updated for 0.8.0 (@sharkdp)

## [v0.1.4](https://github.com/purescript/purescript-nonempty/releases/tag/v0.1.4) - 2016-01-31

- Added `head` and `tail` (@sharkdp)

## [v0.1.3](https://github.com/purescript/purescript-nonempty/releases/tag/v0.1.3) - 2016-01-14

- Removed unused type var (@jonsterling)

## [v0.1.2](https://github.com/purescript/purescript-nonempty/releases/tag/v0.1.2) - 2015-07-23

- Added `singleton` (@garyb)

## [v0.1.1](https://github.com/purescript/purescript-nonempty/releases/tag/v0.1.1) - 2015-07-13

- Added `fromNonEmpty` operation (#1)

## [v0.1.0](https://github.com/purescript/purescript-nonempty/releases/tag/v0.1.0) - 2015-07-07

- Initial versioned release
