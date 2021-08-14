
//Standard Form of create a JavaScript Array
var a = new Array();
a[1] = "One";
a[2] = "Two";
a[3] = "Three";

console.log("a: " + a);
console.log("a[2]: " + a[2]);

//Condensed Version of creating an array

var b = new Array("One", "Two", "Three");
console.log("b: " + b);
console.log("b[2]: " + b[2]);

//Another Version of creating an array
var c = ["One", "Two", "Three"];
console.log("c: " + c);
console.log("c[1]: " + c[1]);

//Array properties

//Returns the length of the array
console.log("c.length: " + c.length);

//concats two arrays (immutable)
console.log("c.concat([\"Four\", \"Five\", \"Six\"])): " + c.concat(["Four", "Five", "Six"])); 

//Finds the index of an element (immutable)
console.log("c.indexOf(\"Two\"): " + c.indexOf("Two")); 

//Creates a string of the elements with a delimeter (immutable)
console.log("c.join(\",\"): " + c.join(","));

//Removes the last element and returns that element (mutable)
console.log("c.pop(): " + c.pop()); 

//Put a new element into an array and returns the new length (mutable)
console.log("c.push(\"Four\"): " + c.push("Four")); 

//Outputting the current state of the array
console.log("c: " + c);

//Reverse all the elements (mutable)
console.log("c.reverse(): " + c.reverse()); 

//Removes the first element and returns that element (mutable)
console.log("c.shift(): " + c.shift()); 

//Outputting the current state of the array
console.log("c: " + c); 

//Resetting the elements
c = ["One", "Two", "Three", "Four", "Five"];

//Outputting the current state of the array
console.log("c: " + c);

//Selects a part of an array, and returns the new array (immutable)
console.log("c.slice(1,3): " + c.slice(1, 3)); 

//Sorts the array (mutable)
console.log("c.sort(): " + c.sort()); 

//Sorting with a function (mutable)
console.log("c.sort(function(x, y) { return (x.length - y.length);}): " + c.sort(function(x,y) { return (x.length - y.length);})); 

//Removes elements of an array (mutable)
console.log("c.splice(1,3): " + c.splice(1,3)); 

//Outputting the current state of the array
console.log("c: " + c); 

c = ["One", "Two", "Three", "Four", "Five"]; //Resetting the elements

//Outputting the current state of the array
console.log("c: " + c); 

//Removes elements of an array, and replaces them (mutable)
console.log("c.splice(1,3,\"Nine\",\"Ten\",\"Eleven\"): " + c.splice(1,3,"Nine","Ten","Eleven")); 

//Converts the array to a string
console.log("c.toString(): " + c.toString());

//Adds new elements to the beginning of the array
console.log("c.unshift(\"Negative One\", \"Zero\"): " + c.unshift("Negative One", "Zero")); 

//Outputting the current state of the array
console.log("c: " + c); 

//Return the primitive value of an array
console.log("c.valueOf(): " + c.valueOf());

//Determines if every elements meets a criteria
console.log("c.every(function(value, index, object) { value.length > 2});: " + c.every(function(value, index, object) { return value.length > 2; })); 

//Determines if some of the elements meets a criteria
console.log("c.some(function(value, index, object) { value.length == 4});: " + c.some(function(value, index, object) { return value.length == 4; })); 

//Outputting the current state of the array
console.log("c: " + c); 

//For every item perform a function (immutable, unless object is changed)
console.log("c.forEach(function(value, index, object) { return value.length});: " + c.forEach(function(value, index, object) { return value.length; })); 

//Applies a function to each element and returns a new Array with the elements (immutable, unless object is changed)
console.log("c.map(function(value, index, object) { return value.length});: " + c.map(function(value, index, object) { return value.length; }));

//Outputting the current state of the array
console.log("c: " + c);

//Uses a function that filters the contents of an Array (immutable, unless object is changed)
console.log("c.filter(function(value, index, object) { return value.length <= 3} );: " + c.filter(function(value, index, object) { return value.length <= 3; }));

//Outputting the current state of the array
console.log("c: " + c); 

//Reduces elements from the left to the right given an initial seed performing an operation and accumulating the results (immutable, unless object is changed in the function)
console.log("c.reduce(function(prev, curr, index, object) { return prev + curr.length; }, 0);: " + c.reduce(function(prev, curr, index, object) { return prev + curr.length; }, 0));

//Reduces elements from the right to the left given an initial seed performing an operation and accumulating the results (immutable, unless object is changed in the function)
console.log("c.reduceRight(function(prev, curr, index, object) { return prev + curr.length; }, 0);: " + c.reduceRight(function(prev, curr, index, object) { return prev + curr.length; }, 0));
