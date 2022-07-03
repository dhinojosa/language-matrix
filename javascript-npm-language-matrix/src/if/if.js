

let a = 10
let b = null;
if (a < 5) { //accept truthiness
   b = a + 10;
} else if (a > 5 && a < 10) {
   b = a + 20
} else {
   b = a + 40;
}

console.log(b);

const list = [1,2,3]
let status;
if (list) {
  status = "Approved";
}

console.log(status);
