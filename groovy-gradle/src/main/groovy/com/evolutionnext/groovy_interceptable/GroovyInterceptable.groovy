
package com.evolutionnext.groovy_interceptable;

import java.time.*;

class Stock implements GroovyInterceptable {
   String name
   private int sharesLeft;

   public Stock(String name, int initialShares) {
      this.sharesLeft = initialShares
   }

   public Stock(String name) {
      this.sharesLeft = 0
   }

   def buy(int shares) { sharesLeft =- shares }

   def add(int shares) { sharesLeft =+ shares }

   def invokeMethod(String name, Object args) {
      //We require System.out.println not println since println
      //is a member of Object, and will intercept
      System.out.println("${LocalDateTime.now()}: method name $name is invoked with the arguments,  $args")
      def metaMethod = metaClass.getMetaMethod(name, args) //Stock.metaClass (needed args)
      metaMethod.invoke(this, args[0])
   }
}
def stock = new Stock("AAPL")
stock.add(4000)
