# Type Class Derivation

```scala
sealed trait Mirror:

  /** the type being mirrored */
  type MirroredType

  /** the type of the elements of the mirrored type */
  type MirroredElemTypes

  /** The mirrored *-type */
  type MirroredMonoType

  /** The name of the type */
  type MirroredLabel <: String

  /** The names of the elements of the type */
  type MirroredElemLabels <: Tuple

object Mirror:

  /** The Mirror for a product type */
  trait Product extends Mirror:

    /** Create a new instance of type `T` with elements
     *  taken from product `p`.
     */
    def fromProduct(p: scala.Product): MirroredMonoType

  trait Sum extends Mirror:

    /** The ordinal number of the case class of `x`.
     *  For enums, `ordinal(x) == x.ordinal`
     */
    def ordinal(x: MirroredMonoType): Int

end Mirror
```
