package com.evolutionnext.groovy_metaclass;

import java.time.*;

class Stock {
   String name
   private int sharesLeft

   public Stock(String name, int initialShares) {
      this.sharesLeft = initialShares
   }

   public Stock(String name) {
      this.sharesLeft = 0
   }

   def buy(int shares) { sharesLeft =- shares }

   def add(int shares) { sharesLeft =+ shares }
}


Stock.metaClass.invokeMethod = {String name, Object args ->
   System.out.println "${LocalDateTime.now()}: method name $name is invoked with the arguments,  $args"
   def metaMethod = Stock.metaClass.getMetaMethod(name, args)
   metaMethod.invoke(delegate, args[0])
}

def stock = new Stock("AAPL")
stock.add(4000)
