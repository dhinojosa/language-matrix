# purescript-numbers

[![Latest release](http://img.shields.io/github/release/purescript/purescript-numbers.svg)](https://github.com/purescript/purescript-numbers/releases)
[![Build status](https://github.com/purescript/purescript-numbers/workflows/CI/badge.svg?branch=master)](https://github.com/purescript/purescript-numbers/actions?query=workflow%3ACI+branch%3Amaster)
[![Pursuit](https://pursuit.purescript.org/packages/purescript-numbers/badge)](https://pursuit.purescript.org/packages/purescript-numbers)

Utility functions for working with PureScripts builtin `Number` type.

## Installation

```
spago install numbers
```

## Examples

Parsing:

```purs
> fromString "12.34"
(Just 12.34)

> fromString "1e-3"
(Just 0.001)
```

Formatting (`Data.Number.Format`):

```purs
> let x = 1234.56789

> toStringWith (precision 6) x
"1234.57"

> toStringWith (fixed 3) x
"1234.568"

> toStringWith (exponential 2) x
"1.23e+3"
```

Approximate comparisons (`Data.Number.Approximate`):

```purs
> 0.1 + 0.2 == 0.3
false

> 0.1 + 0.2 ≅ 0.3
true
```

_NaN_ and _infinity_:

```purs
> isNaN (Math.asin 2.0)
true

> isFinite (1.0 / 0.0)
false
```

## Documentation

Module documentation is [published on Pursuit](http://pursuit.purescript.org/packages/purescript-numbers).
