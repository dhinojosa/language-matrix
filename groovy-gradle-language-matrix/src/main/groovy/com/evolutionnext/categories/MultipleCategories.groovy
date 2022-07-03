
package com.evolutionnext.categories

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
