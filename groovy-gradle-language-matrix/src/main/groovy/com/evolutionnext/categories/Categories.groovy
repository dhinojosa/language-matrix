package com.evolutionnext.categories

class IntegerDecorator {
   def static isOdd(self) {
      return self % 2 != 0;
   }

   def static isEven(self) {
      return !isOdd(self)
   }
}

use (IntegerDecorator) {
   assert 10.isOdd() == false
   assert 11.isOdd() == true
}
