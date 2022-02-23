enum Id[a] with Eq{
    case Nune,
    case Sume(a)
}

namespace Id {
  pub def mapz(id: Id[a], f: a -> b & e):Id[b] & e  =
    match id {
       case Nune => Nune
       case Sume(a) => Sume(f(a))
    }
}
