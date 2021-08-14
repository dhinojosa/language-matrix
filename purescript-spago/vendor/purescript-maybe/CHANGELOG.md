# Changelog

Notable changes to this project are documented in this file. The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

Breaking changes:

New features:

Bugfixes:

Other improvements:

## [v5.0.0](https://github.com/purescript/purescript-maybe/releases/tag/v5.0.0) - 2021-02-26

Breaking changes:
- Added support for PureScript 0.14 and dropped support for all previous versions (#50)
- Ported the `generics-rep` package's `Maybe` instance to this package (#55)

New features:

Bugfixes:
- Relaxed constraints on `optional`, which doesn't need the `Plus` part of `Alternative` (#47)

Other improvements:
- Fixed documentation comment for the `Last` newtype, which omitted the constructor (#42)
- Documented the relationship of `optional` to the left catch law (#52)
- Demonstrated how `do` notation for `Maybe` is similar to nested if-then-else statements (#48)
- Migrated CI to GitHub Actions and updated installation instructions to use Spago (#54)
- Added a changelog and pull request template (#56)

## [v4.0.1](https://github.com/purescript/purescript-maybe/releases/tag/v4.0.1) - 2018-12-01

- Removed an old reference to `return` from the `Applicative` instance's documentation (@gasi)

## [v4.0.0](https://github.com/purescript/purescript-maybe/releases/tag/v4.0.0) - 2018-05-23

- Updated for PureScript 0.12

## [v3.1.0](https://github.com/purescript/purescript-maybe/releases/tag/v3.1.0) - 2018-04-07

- Added instances up to `MonadZero` for `First` and `Last` (@MonoidMusician)
- Added `optional` combinator (@eric-corumdigital)

## [v3.0.0](https://github.com/purescript/purescript-maybe/releases/tag/v3.0.0) - 2017-03-25

- Updated for PureScript 0.11

## [v2.1.1](https://github.com/purescript/purescript-maybe/releases/tag/v2.1.1) - 2017-03-04

- Fixed lower bound of `prelude` dependency (@aij)

## [v2.1.0](https://github.com/purescript/purescript-maybe/releases/tag/v2.1.0) - 2017-03-02

- Added `Eq1` and `Ord1` instances

## [v2.0.1](https://github.com/purescript/purescript-maybe/releases/tag/v2.0.1) - 2016-10-23

- Fixed ordering of `Just` and `Nothing` so that `forall a. Nothing < Just a`

## [v2.0.0](https://github.com/purescript/purescript-maybe/releases/tag/v2.0.0) - 2016-10-02

- Updated dependencies
- Added `Newtype` instances for `First` and `Last`

## [v1.0.0](https://github.com/purescript/purescript-maybe/releases/tag/v1.0.0) - 2016-06-01

- Updated for PureScript 0.9.1
  
  This release is intended for the PureScript 0.9.1 compiler and newer. **Note**: The v1.0.0 tag is not meant to indicate the library is “finished”, the core libraries are all being bumped to this for the 0.9 compiler release so as to use semver more correctly.
- Updated for new `Prelude` class hierarchies

## [v0.3.5](https://github.com/purescript/purescript-maybe/releases/tag/v0.3.5) - 2015-11-15

- Fixed shadowed type variable warning (@zudov)

## [v0.3.4](https://github.com/purescript/purescript-maybe/releases/tag/v0.3.4) - 2015-08-05

- Fixed partial pattern match warning for `fromJust`

## [v0.3.3](https://github.com/purescript/purescript-maybe/releases/tag/v0.3.3) - 2015-07-31

- Added "lazy" versions of `maybe` and `fromMaybe`

## [v0.3.2](https://github.com/purescript/purescript-maybe/releases/tag/v0.3.2) - 2015-07-07

- Fixed the `Semigroup` behaviour for `Maybe`. This is technically a breaking change, but only because `v0.3.0` and `v0.3.1` had the improper behaviour. All previous versions behaved this way.

## [v0.3.1](https://github.com/purescript/purescript-maybe/releases/tag/v0.3.1) - 2015-07-02

- Corrected `Invariant Maybe` instance name (@hdgarrood)

## [v0.3.0](https://github.com/purescript/purescript-maybe/releases/tag/v0.3.0) - 2015-06-30

- Updated for PureScript 0.7

  This release works with versions 0.7.\* of the PureScript compiler. It will not work with older versions. If you are using an older version, you should require an older, compatible version of this library.

## [v0.2.2](https://github.com/purescript/purescript-maybe/releases/tag/v0.2.2) - 2015-03-17

- Updated docs

## [v0.2.1](https://github.com/purescript/purescript-maybe/releases/tag/v0.2.1) - 2014-09-03

- Added `Extend` and `Semigroup` instances (@joneshf)

## [v0.2.0](https://github.com/purescript/purescript-maybe/releases/tag/v0.2.0) - 2014-08-11

- Added `Alt`, `Plus`, and `MonadPlus`, and updated `Alternative` (@garyb)

## [v0.1.3](https://github.com/purescript/purescript-maybe/releases/tag/v0.1.3) - 2014-05-22

- Added `fromJust` in `Data.Maybe.Unsafe` (garyb)

## [v0.1.2](https://github.com/purescript/purescript-maybe/releases/tag/v0.1.2) - 2014-04-25

- Removed some test-related code and moved it to core-tests

## [v0.1.1](https://github.com/purescript/purescript-maybe/releases/tag/v0.1.1) - 2014-04-10

- Tweaked the `bower.json` file

## [v0.1.0](https://github.com/purescript/purescript-maybe/releases/tag/v0.1.0) - 2014-04-10

- Initial versioned release
