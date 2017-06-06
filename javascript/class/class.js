
class Person {
   constructor() {
   }
}

const p1 = new Person();
const p2 = new Person();

console.log("p1 instanceof Person: " + (p1 instanceof Person)); //true

class Stock {
   constructor(name, price) {
      this.name = name;
      this.price = price;
   }
}

class Portfolio {
   constructor(...purchases) { //varargs in javascript
      this.purchases = purchases;
   }

   purchase(stock, amount) {
      this.purchases.push([stock, amount]);
   }

   report() {
      console.log(`Purchases I made before the report ${this.purchases}`);
      return this.purchases.reduce((acc, cur, idx, arr) => {
         console.log(`In reduce: acc = ${acc}, cur = ${cur[0]}`);
         return `${acc} \r\n ${cur[0].name} @ ${cur[0].price}, ${cur[1]} shares.`;
      }, "");
   }
}

const myPortfolio = new Portfolio([new Stock("MSFT", 103.00), 10],
                                  [new Stock("AAPL", 33.00) , 20]);

console.log("Completed: " + myPortfolio.report());



