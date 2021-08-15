
package com.evolutionnext.categories

@Category(Integer)              //Category requires a value that describes what it is decorating
class IntegerDecorator {
   def isOdd() {                //No use of a parameter
      return this % 2 != 0;     //Instead of use of a parameter, it used the keyword this
   }

   def isEven() {
      return !isOdd()
   }
}

@Category(Integer)
class DivModDecorator {
   def divMod(divisor) {
      [this.intdiv(divisor), this % divisor]
   }
}

use (IntegerDecorator, DivModDecorator) { //Both Decorate Integer and both are used
   assert 10.isOdd() == false
   assert 11.isOdd() == true
   assert 13.divMod(3) == [4, 1]
}
