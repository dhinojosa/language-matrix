package com.evolutionnext.fboundedpolymorphism

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers


class FBoundedPolymorphismSpec extends AnyFunSuite with Matchers {
//  test("""We start with an attempt to constrain types and ensure that the
//         |  type system is will respect our demands""".stripMargin) {
//
//    trait Entity[E] {
//      def create(): E
//      def read(id: Long): Option[E]
//      def update(f: E => E): E
//      def delete(id: Long): Unit
//    }
//
//    class Apple extends Entity[Apple] {
//      override def create(): Apple = ???
//      override def read(id: Long): Option[Apple] = ???
//      override def update(f: Apple => Apple): Apple = ???
//      override def delete(id: Long): Unit = ???
//    }
//
//    //Issue: We can extend the following in unintended ways
//    class FlyingSaucer
//    class Orange extends Entity[FlyingSaucer] {
//      override def create(): FlyingSaucer = ???
//      override def read(id: Long): Option[FlyingSaucer] = ???
//      override def update(f: FlyingSaucer => FlyingSaucer): FlyingSaucer = ???
//      override def delete(id: Long): Unit = ???
//    }
//  }
//
//  test("""Now we need to constrain the parameterized
//         |  type to not allow other elements""".stripMargin) {
//    trait Entity[E <: Entity[E]] {
//      def create(): E
//      def read(id: Long): Option[E]
//      def update(f: E => E): E
//      def delete(id: Long): Unit
//    }
//    class Apple extends Entity[Apple] {
//      override def create(): Apple = ???
//      override def read(id: Long): Option[Apple] = ???
//      override def update(f: Apple => Apple): Apple = ???
//      override def delete(id: Long): Unit = ???
//    }
//
//    //Excellent. This now doesn't work
//    //    class Orange extends Entity[FlyingSaucer] {
//    //      override def create(): FlyingSaucer = ???
//    //      override def read(id: Long): Option[FlyingSaucer] = ???
//    //      override def update(f: FlyingSaucer => FlyingSaucer): FlyingSaucer = ???
//    //      override def delete(id: Long): Unit = ???
//    //    }
//
//    class Cantaloupe extends Entity[Cantaloupe] {
//      override def create(): Cantaloupe = ???
//      override def read(id: Long): Option[Cantaloupe] = ???
//      override def update(f: Cantaloupe => Cantaloupe): Cantaloupe = ???
//      override def delete(id: Long): Unit = ???
//    }
//  }
//
//  test("""Now we have another issue. We can still use a different fruit""".stripMargin) {
//    trait Entity[E <: Entity[E]] {
//      def create(): E
//      def read(id: Long): Option[E]
//      def update(f: E => E): E
//      def delete(id: Long): Unit
//    }
//
//    class Apple extends Entity[Apple] {
//      override def create(): Apple = ???
//      override def read(id: Long): Option[Apple] = ???
//      override def update(f: Apple => Apple): Apple = ???
//      override def delete(id: Long): Unit = ???
//    }
//
//    //Whoa this isn't right, why?
//    class Orange extends Entity[Apple] {
//      override def create(): Apple = ???
//      override def read(id: Long): Option[Apple] = ???
//      override def update(f: Apple => Apple): Apple = ???
//      override def delete(id: Long): Unit = ???
//    }
//  }
//
//  test("""We need to then ensure that Orange extends Entity[Orange],
//         |  we then use self types""".stripMargin) {
//
//    trait Entity[E <: Entity[E]] { self: E =>
//      def create(): E
//      def read(id: Long): Option[E]
//      def update(f: E => E): E
//      def delete(id: Long): Unit
//    }
//
//    class Apple extends Entity[Apple] {
//      override def create(): Apple = ???
//      override def read(id: Long): Option[Apple] = ???
//      override def update(f: Apple => Apple): Apple = ???
//      override def delete(id: Long): Unit = ???
//    }
//
//    //This is great, now this will not work, as expected
//    //    class Orange extends Entity[Apple] {
//    //      override def create(): Apple = ???
//    //      override def read(id: Long): Option[Apple] = ???
//    //      override def update(f: Apple => Apple): Apple = ???
//    //      override def delete(id: Long): Unit = ???
//    //    }
//
//    class Orange extends Entity[Orange] {
//      override def create(): Orange = ???
//      override def read(id: Long): Option[Orange] = ???
//      override def update(f: Orange => Orange): Orange = ???
//      override def delete(id: Long): Unit = ???
//    }
//  }
}
