package com.evolutionnext.traitparameters

/**
* trait is like a Java interface
* Arguments to a trait parameters are evaluated 
* immediately before the trait is initialized.
*
* What is the difference between the abstract and
* trait then? Abstract has a "is-a-relationship"
* Traits offer I am "adding in a feature"
**/

trait ReallyReallyGoodLooking(handsomeLevel:Int)

trait LogStack(depth:Int) {
  import scala.collection.mutable.Queue
  private val queue = Queue.empty[String]
  def add(s:String) = {
    queue.enqueue(s)
    if (queue.size > depth) queue.dequeue
  }
  def elements = queue.toList
}

case class Account(accountNumber: String, balance:Long) extends LogStack(5) with ReallyReallyGoodLooking(10){
  def deposit(amount:Long) = {
    add(s"Depositing $amount")
  }
  def withdrawal(amount:Long) = {
    add(s"Attempt withdrawal of $amount")
    if (!(balance - amount < 0)) {
      add(s"Withdrawal $amount successful")
    }
  }
}

object TraitParameters extends App {
  val account = Account("12-40-590903", 1203)
    println(account.elements)
  account.deposit(40)
  account.deposit(400)
  account.withdrawal(100)
  account.withdrawal(1200)
  account.withdrawal(1300)
  account.withdrawal(1400)
  println(account.elements)
}
