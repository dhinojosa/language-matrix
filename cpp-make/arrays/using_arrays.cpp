#include <iostream>
using namespace std;

/*
 * How arrays are created and manipulated in C++
 */
int main() {
   int int_array[4] = {1, 2, 3, 4};   //explicit declaration

   int int_array2[] = {1, 2, 3, 4};   //size of array can be inferred 
                                      //by declaration 

   cout << int_array[2] << "\n";      //access the array

   int_array[2] = 22;                 //change an element in an array

   cout << int_array[2] << "\n";      //access the same element of the array
}

