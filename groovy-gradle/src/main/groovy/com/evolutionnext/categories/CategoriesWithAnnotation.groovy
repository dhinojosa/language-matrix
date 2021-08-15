
package com.evolutionnext.categories

@Category(Integer)              //Category requires a value that describes what it is decorating
class IntegerDecoratorAnnotated {
   def isOdd() {                //No use of a parameter
      return this % 2 != 0;     //Instead of use of a parameter, it used the keyword this
   }

   def isEven() {
      return !isOdd()
   }
}

use (IntegerDecorator) {
   assert 10.isOdd() == false
   assert 11.isOdd() == true
}
