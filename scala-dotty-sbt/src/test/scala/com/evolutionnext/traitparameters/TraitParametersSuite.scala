package com.evolutionnext.traitparameters

class TraitParametersSuite extends munit.FunSuite:
  test("trait parameters tests allows for a trait to accept parameters") {
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
