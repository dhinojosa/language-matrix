# Inline

Inlining is a common compile-time metaprogramming technique, 
typically used to achieve performance optimizations. 
As we will see, in Scala 3, the concept of inlining provides us with
an _entrypoint_ to programming with macros.

1. It introduces inline as a soft keyword.
2. It guarantees that inlining actually happens instead of being best-effort.
3. It introduces operations that are guaranteed to evaluate at compile-time.

# What is inlining

Inlining is an optimization that takes the value of code
and replaces it at the call site during _compilation_.

The following guarantees that the values `pi` and `pie` are going to be 
inlined where required

```scala
inline val pi = 3.141592653589793
inline val pie = "🥧"



```
