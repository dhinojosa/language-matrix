
let numberArray = [1,2,3,4,5];
let result = [];
for (x in numberArray) {
    result.push(parseInt(x) + 3);
}
console.log(result.join(':'));
