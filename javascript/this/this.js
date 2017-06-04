
const o = {firstName : 'Frederick',
           lastName  : 'Douglas',
           fullName  : function() {
                         return `${this.firstName} ${this.lastName}`;
                       }
          }

console.log(o.fullName());


//Using ES6...
const o2 = {firstName  : 'Frederick',
            lastName   : 'Douglas',
            fullName() { return `${this.firstName} ${this.lastName}`;}
           }

console.log(o2.fullName());
