package com.evolutionnext.traitparameters

import scala.collection.mutable

/**
 * trait is like a Java interface Arguments to a trait parameters are evaluated immediately before the trait is
 * initialized.
 *
 * What is the difference between the abstract and trait then? Abstract has a "is-a-relationship" Traits offer I am
 * "adding in a feature"
 */

trait ReallyReallyGoodLooking(handsomeLevel: Int)

/**
  * We can only use the depth within the LogStack
  * and we can only treat that as a single encapsulated
  * item
  */
trait LogStack(depth: Int):
  import scala.collection.mutable.Queue
  private val queue = mutable.Queue.empty[String]
  def add(s: String): Unit =
    queue.enqueue(s)
    if queue.size > depth then queue.dequeue
  def elements: Seq[String] = queue.toList

case class Account(accountNumber: String, balance: Long)
    extends LogStack(5) with ReallyReallyGoodLooking(10):
  def deposit(amount: Long): Unit =
    add(s"Depositing $amount")
  def withdrawal(amount: Long): Unit =
    add(s"Attempt withdrawal of $amount")
    if !(balance - amount < 0) then add(s"Withdrawal $amount successful")

@main
def accessingTraitParameter():Unit =
    val account = Account("12303", 10)
    account.deposit(100)
    account.withdrawal(10)
    println(account.elements)
